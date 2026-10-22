package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/IconsWithSpaceElementView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconsWithSpaceElementView extends LinearLayout implements ActionHubAccessor {
    public IconsWithSpaceElement a;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a b;

    public IconsWithSpaceElementView(Context r4) {
        this(r4, null, 0, 14);
    }

    public IconsWithSpaceElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public IconsWithSpaceElementView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final void a(IconsWithSpaceElement r8) {
        this.a = r8;
        int r0 = 0;
        setOrientation(0);
        setGravity(16);
        if (r8 == null) goto L24;
        List r1 = r8.getIconList();
        if (r1 == null) goto L24;
        if ((!r1.isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L24;
        setVisibility(0);
        ExtensionsKt.j(this, r8.getBackground());
        removeAllViews();
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L22;
        Object r3 = r2.next();
        int r4 = r0 + 1;
        if (r0 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        View r5 = new SimpleDraweeView(getContext());
        ImageExtensionsKt.d(r5, (ImageModel) r3, null);
        Unit r6 = Unit.INSTANCE;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        if (r0 <= 0) goto L21;
        r7.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getSpace()));
    L21:
        addView(r5, r7);
        r0 = r4;
        goto L14
    L22:
        Action r9 = r8.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r9);
        return;
    L24:
        setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.b = r2;
    }

    public IconsWithSpaceElementView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.b = null;
    }
}
