package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/SkuBaseInfoComponentView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/MediaBoxElementView;", "a", "Lkotlin/Lazy;", "getMainSkuImage", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/MediaBoxElementView;", "mainSkuImage", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "b", "getSkuNumContent", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "skuNumContent", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MediaScrollBoxComponentView;", "c", "getThumbnail", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/MediaScrollBoxComponentView;", "thumbnail", "", "<set-?>", "f", "Ljava/lang/String;", "getOldSelectRefId", "()Ljava/lang/String;", "oldSelectRefId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBaseInfoComponentView extends LinearLayout implements ActionHubAccessor, d {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public HorizontalScrollView d;
    public SkuBaseInfoComponent e;
    public String f;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a g;

    public static final class a {
    }

    static {
    }

    public SkuBaseInfoComponentView(Context r3) {
        this(r3, null, 6);
    }

    public SkuBaseInfoComponentView(Context r2, AttributeSet r3) {
        this(r2, r3, 4);
    }

    private final MediaBoxElementView getMainSkuImage() {
        return (MediaBoxElementView) this.a.getValue();
    }

    private final TextElementView getSkuNumContent() {
        return (TextElementView) this.b.getValue();
    }

    private final MediaScrollBoxComponentView getThumbnail() {
        return (MediaScrollBoxComponentView) this.c.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public final List<ShowEvent> showEvent() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final String getOldSelectRefId() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    public final void a(SkuBaseInfoComponent r6) {
        Intrinsics.checkNotNullParameter(r6, "skuBaseInfo");
        this.e = r6;
        MediaBoxElementView.c(getMainSkuImage(), r6.getMainSkuImage(), null, false, 6);
        ?? r0 = getSkuNumContent();
        r0.x(r6.getSkuNumContent());
        r0.setGravity(17);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(b.b(32), b.b(32));
        r1.leftMargin = b.b(Integer.valueOf(r6.getTextSpace()));
        r1.rightMargin = b.b(Integer.valueOf(r6.getTextSpace()));
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        MediaScrollBoxComponentView r3 = getThumbnail();
        MediaScrollBoxComponent r7 = r6.getThumbnail();
        int r4 = MediaScrollBoxComponentView.e;
        r3.a(r7, false);
        removeAllViews();
        addView(getMainSkuImage());
        addView(getSkuNumContent());
        addView(getThumbnail());
        this.d = getThumbnail().getHorizontalScrollView();
    }

    public final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "refId");
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = "main_pic";
        if (r0 == false) goto L10;
        r7 = "main_pic";
    L10:
        if (Intrinsics.areEqual(r7, this.f) == false) goto L12;
        return;
    L12:
        View r1 = ExtensionsKt.k(this, this.f);
        View r5 = null;
        if ((r1 instanceof MediaBoxElementView) == true) goto L15;
        r1 = null;
    L15:
        MediaBoxElementView r2 = (MediaBoxElementView) r1;
        if (r2 == null) goto L18;
        r2.d(false);
    L18:
        View r4 = ExtensionsKt.k(this, r7);
        if ((r4 instanceof MediaBoxElementView) == true) goto L21;
        r4 = null;
    L21:
        MediaBoxElementView r6 = (MediaBoxElementView) r4;
        if (r6 == null) goto L29;
        r6.d(true);
        if ((true ^ Intrinsics.areEqual(r7, "main_pic")) == false) goto L28;
        HorizontalScrollView r8 = this.d;
        if (r8 == null) goto L28;
        r8.smoothScrollTo((r6.getLeft() + (r6.getWidth() / 2)) - (r8.getWidth() / 2), 0);
    L28:
        r3 = r7;
    L36:
        this.f = r3;
        return;
    L29:
        View r9 = ExtensionsKt.k(this, "main_pic");
        if ((r9 instanceof MediaBoxElementView) == false) goto L33;
        r5 = r9;
    L33:
        MediaBoxElementView r10 = (MediaBoxElementView) r5;
        if (r10 == null) goto L36;
        r10.d(true);
        goto L36
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.g = r2;
    }

    public SkuBaseInfoComponentView(final Context r2, AttributeSet r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.g = null;
        this.a = LazyKt.lazy(new SkuBaseInfoComponentView$mainSkuImage$2(r2));
        this.b = LazyKt.lazy(new SkuBaseInfoComponentView$skuNumContent$2(r2));
        this.c = LazyKt.lazy(new SkuBaseInfoComponentView$thumbnail$2(r2));
        this.f = "";
        setOrientation(0);
        setGravity(19);
    }
}
