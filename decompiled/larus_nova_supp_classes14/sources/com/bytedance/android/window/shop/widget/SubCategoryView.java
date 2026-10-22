package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/SubCategoryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubCategoryView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public ECWindowTabLayout a;
    public i0 b;

    public static final class a implements Runnable {
        public final /* synthetic */ SubCategoryView a;
        public final /* synthetic */ i0 b;

        public a(SubCategoryView r1, i0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            SubCategoryView r0 = this.a;
            i0 r1 = this.b;
            int r2 = SubCategoryView.c;
            r0.getClass();
            if (Intrinsics.areEqual(r1.l, SubCategoryTypes.SUB_LIVE_APPOINT.getType()) == false) goto L31;
            Iterator<WindowProductCategoryVODeprecated.a> r3 = r1.k.j.iterator();
            int r4 = 0;
        L7:
            if (r3.hasNext() == false) goto L12;
            if (Intrinsics.areEqual(r3.next().a, SubCategoryTypes.SUB_LIVE_HOT.getType()) == true) goto L13;
            r4 = r4 + 1;
        L13:
            if (r4 == (-1)) goto L32;
            String r5 = com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId();
            ECWindowTabLayout r6 = r0.a;
            if (r6 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
        L18:
            ECTabLayout.Tab r7 = r6.getTabAt(r4);
            if (r7 == null) goto L30;
            View r8 = r7.getCustomView();
            if (r8 != null) goto L24;
            return;
        L24:
            if (SharedPrefExtKt.getSharePref(r0.getContext(), "ec_window_live_point").getBoolean(r5, false) == true) goto L34;
            List r9 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.h());
            new com.bytedance.android.ec.window.base.common.bubble.r(r8, "更多直播热卖商品", new com.bytedance.android.ec.window.base.common.bubble.q(13.0f, 4294967295L), r9, new m(r0, r5), 312).b();
            return;
        L34:
            return;
        L30:
            return;
        L32:
            return;
        L12:
            r4 = -1;
            goto L13
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

    public SubCategoryView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SubCategoryView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ECWindowTabLayout) findViewById(2131371350);
    }

    public final void a(i0 r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (Intrinsics.areEqual(this.b, r4) == false) goto L5;
        return;
    L5:
        this.b = r4;
        ECWindowTabLayout r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L8:
        r0.removeAllTabs();
        ((ArrayList) r0.a).clear();
        ((LinkedHashMap) r0.b).clear();
        r0.clearOnTabSelectedListeners();
        r0.post(new e(r0));
        r0.setSelectedTabIndicator(2131248174);
        r0.setTabRippleColor(null);
        r0.addOnTabSelectedListener(new d());
        ECWindowTabLayout r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L11:
        r1.c(r4);
        ECWindowTabLayout r2 = this.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L14:
        r2.post(new a(this, r4));
    }

    public final void b(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ECWindowTabLayout r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L7:
        int r1 = r0.getTabCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L25;
        ECWindowTabLayout r3 = this.a;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L12:
        ECTabLayout.Tab r4 = r3.getTabAt(r2);
        if (r4 == null) goto L15;
        Object r6 = r4.getTag();
    L17:
        if (Intrinsics.areEqual(r6, r5) == false) goto L24;
        ECWindowTabLayout r7 = this.a;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L21:
        ECTabLayout.Tab r8 = r7.getTabAt(r2);
        if (r8 == null) goto L24;
        r8.select();
    L24:
        r2 = r2 + 1;
        goto L8
    L15:
        r6 = null;
        goto L17
    }

    public SubCategoryView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SubCategoryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
