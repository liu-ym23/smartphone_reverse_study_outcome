package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.o;
import com.bytedance.android.shopping.store.tabkit.model.w;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/BottomTabItemView;", "Lcom/bytedance/android/shopping/store/tabkit/view/ABSTabItemView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomTabItemView extends ABSTabItemView {
    public ECUrlModel j;

    public BottomTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void e(ECUrlModel r3) {
        Intrinsics.checkNotNullParameter(getIconView(), "draweeView");
        if (Intrinsics.areEqual(this.j, r3) == true) goto L7;
        this.j = r3;
        e.h(getIconView(), r3);
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
    public void a(boolean r2, boolean r3) {
        super.a(r2, r3);
        w r4 = getTabStyle();
        if (r4 == null) goto L5;
        String r5 = r4.e();
    L7:
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        getTitleTV().setVisibility(8);
    L16:
        w r7 = getTabStyle();
        if (r7 == null) goto L39;
        o r8 = getTabBarStyle();
        if (r8 == null) goto L25;
        String r9 = r8.e();
        if (r9 == null) goto L25;
        Integer r10 = s.b(r9);
        if (r10 == null) goto L25;
        getTitleTV().setTextColor(r10.intValue());
    L25:
        getTitleTV().setText(r7.e());
        ECUrlModel r11 = r7.a();
        if (r11 != null) goto L28;
        r11 = r7.b();
    L28:
        e(r11);
        o r12 = getTabBarStyle();
        if (r12 == null) goto L33;
        Integer r13 = r12.a();
        if (r13 == null) goto L33;
        getTitleTV().setTextSize(2, r13.intValue());
    L33:
        o r14 = getTabBarStyle();
        if (r14 == null) goto L40;
        Integer r15 = r14.b();
        if (r15 == null) goto L41;
        f.e(getTitleTV(), Integer.valueOf(r15.intValue()));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L15:
        getTitleTV().setVisibility(0);
        goto L16
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public BottomTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ECDraweeView.setPlaceholderImage$default(getIconView(), 2131234817, null, 2, null);
    }

    public /* synthetic */ BottomTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
