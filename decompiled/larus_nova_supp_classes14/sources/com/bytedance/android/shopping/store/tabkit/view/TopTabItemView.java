package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import hk3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/TopTabItemView;", "Lcom/bytedance/android/shopping/store/tabkit/view/ABSTabItemView;", "", "getResourceId", "", "j", "Z", "getEnableImageIcon", "()Z", "setEnableImageIcon", "(Z)V", "enableImageIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TopTabItemView extends ABSTabItemView {
    public boolean j;

    public TopTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TopTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView
    public int getResourceId() {
        return 2131560982;
    }

    public final boolean getEnableImageIcon() {
        return this.j;
    }

    public final void setEnableImageIcon(boolean r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public void a(boolean r3, boolean r4) {
        k r0 = getTab();
        if (r0 == null) goto L5;
        k r1 = r0.a;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
        setEnableBadge(false);
    L9:
        super.a(r3, r4);
        w r5 = getTabStyle();
        if (r5 == null) goto L43;
        o r6 = getTabBarStyle();
        if (r6 == null) goto L18;
        String r7 = r6.e();
        if (r7 == null) goto L18;
        Integer r8 = s.b(r7);
        if (r8 == null) goto L18;
        getTitleTV().setTextColor(r8.intValue());
    L18:
        ECUrlModel r9 = r5.a();
        if (r9 != null) goto L22;
        r9 = r5.b();
    L22:
        if (r9 != null) goto L24;
    L32:
        ExtensionsKt.visible(getTitleTV());
        ExtensionsKt.gone(getIconView());
        getTitleTV().setText(r5.e());
        o r10 = getTabBarStyle();
        if (r10 == null) goto L37;
        Integer r11 = r10.a();
        if (r11 == null) goto L37;
        getTitleTV().setTextSize(1, r11.intValue());
    L37:
        o r12 = getTabBarStyle();
        if (r12 == null) goto L45;
        Integer r13 = r12.b();
        if (r13 == null) goto L46;
        f.e(getTitleTV(), Integer.valueOf(r13.intValue()));
        return;
    L46:
        return;
    L45:
        return;
    L24:
        if (this.j == false) goto L32;
        int r14 = h.a;
        if (e.a() == 0) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L30;
        com.bytedance.android.shopping.store.tabkit.e.h(getIconView(), r5.b());
    L31:
        ExtensionsKt.visible(getIconView());
        ExtensionsKt.gone(getTitleTV());
        return;
    L30:
        h0 r15 = h0.a;
        com.bytedance.android.shopping.store.tabkit.e.g(getIconView(), r5.b());
        goto L31
    L43:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public TopTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = true;
        setClipChildren(false);
    }

    public /* synthetic */ TopTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
