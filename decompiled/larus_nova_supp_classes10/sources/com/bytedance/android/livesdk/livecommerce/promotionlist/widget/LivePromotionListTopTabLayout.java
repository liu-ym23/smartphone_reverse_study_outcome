package com.bytedance.android.livesdk.livecommerce.promotionlist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.b;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/widget/LivePromotionListTopTabLayout;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout$BaseOnTabSelectedListener;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout$Tab;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListTopTabLayout extends ECTabLayout implements ECTabLayout.BaseOnTabSelectedListener<ECTabLayout.Tab> {
    public gi2.a a;

    public static final class a implements Runnable {
        public final /* synthetic */ LivePromotionListTopTabLayout a;
        public final /* synthetic */ boolean b;

        public a(LivePromotionListTopTabLayout r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            b r1 = this.a.a;
            if (r1 != null) goto L5;
            r1 = b.a;
        L5:
            v r0 = new v("livesdk_list_switch_action", r1);
            r0.c("area_type", "list_head");
            if (this.b == false) goto L8;
            String r2 = "click";
        L9:
            r0.c("enter_type", r2);
            r0.i(null);
            return;
        L8:
            r2 = "slide";
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onTabReselected(ECTabLayout.Tab r1) {
    }

    public final void onTabSelected(ECTabLayout.Tab r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        View r4 = r3.getCustomView();
    L7:
        if ((r4 instanceof LivePromotionListTopTabView) == false) goto L10;
        r0 = r4;
    L10:
        LivePromotionListTopTabView r1 = (LivePromotionListTopTabView) r0;
        if (r1 == null) goto L14;
        r1.S5(true);
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onTabUnselected(ECTabLayout.Tab r3) {
        Object r0 = null;
        if (r3 == null) goto L5;
        View r4 = r3.getCustomView();
    L7:
        if ((r4 instanceof LivePromotionListTopTabView) == false) goto L10;
        r0 = r4;
    L10:
        LivePromotionListTopTabView r1 = (LivePromotionListTopTabView) r0;
        if (r1 == null) goto L14;
        r1.S5(false);
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public LivePromotionListTopTabLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final void onTabSelected(ECTabLayout.Tab r2, boolean r3) {
        if (this.a == null) goto L5;
        oh.a.c("livesdk_list_switch_action", new a(this, r3));
    L5:
        Object r4 = null;
        if (r2 == null) goto L8;
        View r5 = r2.getCustomView();
    L10:
        if ((r5 instanceof LivePromotionListTopTabView) == false) goto L13;
        r4 = r5;
    L13:
        LivePromotionListTopTabView r6 = (LivePromotionListTopTabView) r4;
        if (r6 == null) goto L17;
        r6.S5(true);
        return;
    L17:
        return;
    L8:
        r5 = null;
        goto L10
    }

    public final void setScrollPosition(int r5, float r6, boolean r7, boolean r8) {
        super.setScrollPosition(r5, Math.min((float) (((double) r6) * 1.04d), 1.0f), r7, r8);
    }
}
