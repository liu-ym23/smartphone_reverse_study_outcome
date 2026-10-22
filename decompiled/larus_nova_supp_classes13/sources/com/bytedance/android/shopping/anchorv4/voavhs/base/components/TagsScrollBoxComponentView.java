package com.bytedance.android.shopping.anchorv4.voavhs.base.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.c;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010+\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/components/TagsScrollBoxComponentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/d;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "description", "", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "a", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "getSkuSpecText", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;", "setSkuSpecText", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/c;)V", "skuSpecText", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getOverflowContainer", "()Landroid/view/ViewGroup;", "setOverflowContainer", "(Landroid/view/ViewGroup;)V", "overflowContainer", "", "c", "Z", "getShouldBanClipChildren", "()Z", "setShouldBanClipChildren", "(Z)V", "shouldBanClipChildren", "", "", "d", "Ljava/util/List;", "getShowExtraElement", "()Ljava/util/List;", "setShowExtraElement", "(Ljava/util/List;)V", "showExtraElement", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagsScrollBoxComponentView extends FrameLayout implements ActionHubAccessor, d {
    public c a;
    public ViewGroup b;
    public boolean c;
    public List<String> d;
    public String e;
    public TagsScrollBoxComponent f;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a g;

    public TagsScrollBoxComponentView(Context r4) {
        this(r4, null, 0, 14);
    }

    public TagsScrollBoxComponentView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public TagsScrollBoxComponentView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.d
    public final List<ShowEvent> showEvent() {
        TagsScrollBoxComponent r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getShowEvent();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final ViewGroup getOverflowContainer() {
        return this.b;
    }

    public final boolean getShouldBanClipChildren() {
        return this.c;
    }

    public final List<String> getShowExtraElement() {
        return this.d;
    }

    public final c getSkuSpecText() {
        return this.a;
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

    public final void setOverflowContainer(ViewGroup r1) {
        this.b = r1;
    }

    public final void setShouldBanClipChildren(boolean r1) {
        this.c = r1;
    }

    public final void setShowExtraElement(List<String> r1) {
        this.d = r1;
    }

    public final void setSkuSpecText(c r1) {
        this.a = r1;
    }

    public final void update(TagsScrollBoxComponent r1) {
        this.f = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        c r0 = this.a;
        if (r0 == null) goto L48;
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ExtensionsKt.d(this, "spec", r1);
        if (r1.isEmpty() == false) goto L7;
        ExtensionsKt.d(this, "image_spec", r1);
    L7:
        ExtensionsKt.d(this, "spec_sum", r2);
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        ((View) r4.next()).measure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
        goto L9
    L11:
        View r5 = (View) CollectionsKt.firstOrNull(r2);
        if (r5 == null) goto L14;
        r5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
        int r6 = UIUtils.px2dip(getContext(), r5.getMeasuredWidth());
    L15:
        int r7 = ((UIUtils.px2dip(getContext(), UIUtils.getScreenWidth(getContext())) - 40) - 12) - r0.a();
        Iterator r8 = r1.iterator();
        boolean r9 = false;
        int r12 = 0;
    L17:
        if (r8.hasNext() == false) goto L29;
        View r13 = (View) r8.next();
        if (r9 == true) goto L20;
        int r14 = UIUtils.px2dip(getContext(), r13.getMeasuredWidth());
        TagsScrollBoxComponent r15 = this.f;
        if (r15 == null) goto L24;
        int r16 = r15.getSpace();
    L25:
        r12 = r12 + (r14 + r16);
        if ((r7 - r12) < r6) goto L27;
        r9 = false;
        goto L17
    L27:
        r9 = true;
        goto L17
    L24:
        r16 = 0;
        goto L25
    L20:
        r3.add(r13);
        goto L17
    L29:
        super.onMeasure(r10, r11);
        ViewParent r17 = null;
        this.a = null;
        if (r9 == false) goto L60;
        View r18 = (View) CollectionsKt.firstOrNull(r2);
        ViewGroup r19 = this.b;
        if (r19 == null) goto L44;
        if (r18 == null) goto L44;
        ViewParent r20 = r18.getParent();
        if ((r20 instanceof ViewGroup) == false) goto L40;
        r17 = r20;
    L40:
        ViewGroup r110 = (ViewGroup) r17;
        if (r110 == null) goto L43;
        r110.removeView(r18);
    L43:
        r18.setBackgroundResource(2131247846);
        r19.addView(r18, new ViewGroup.LayoutParams(-2, getMeasuredHeight()));
    L44:
        Iterator r111 = r3.iterator();
    L46:
        if (r111.hasNext() == false) goto L61;
        ((View) r111.next()).setVisibility(8);
        goto L46
    L61:
        return;
    L60:
        return;
    L14:
        r6 = 0;
        goto L15
    }

    public final LinearLayout c(List<TextWithOneIconElement> r20, int r21, int r22) {
        LinearLayout r1 = new LinearLayout(getContext());
        int r2 = 0;
        r1.setOrientation(0);
        ExtensionsKt.a(r1, r22);
        Iterator<T> r3 = r20.iterator();
    L4:
        if (r3.hasNext() == false) goto L22;
        Object r4 = r3.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TextWithOneIconElement r7 = (TextWithOneIconElement) r4;
        if (r7.getShowFirstScreen() == true) goto L14;
        List<String> r6 = this.d;
        if (r6 == null) goto L21;
        if (CollectionsKt.contains(r6, r7.getElementId()) == true) goto L14;
    L21:
        r2 = r5;
    L14:
        int r8 = TextWithOneIconElementView.j;
        Context r14 = r1.getContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        TextWithOneIconElementView r9 = new TextWithOneIconElementView(r14, null, 0, null, 30);
        TextWithOneIconElementView.b(r9, r7, null, false, this.e, 6);
        if (this.a == null) goto L17;
        r9.setMinimumWidth(b.b(28));
        r9.setMinimumHeight(b.b(28));
    L17:
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r2 <= 0) goto L20;
        r10.leftMargin = b.b(Integer.valueOf(r21));
    L20:
        r1.setGravity(16);
        Unit r11 = Unit.INSTANCE;
        r9.setLayoutParams(r10);
        r9.setClipChildren(!this.c);
        r9.setClipToPadding(!this.c);
        r1.addView(r9);
        goto L21
    L22:
        return r1;
    }

    public TagsScrollBoxComponentView(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.g = null;
    }

    public static /* synthetic */ void b(TagsScrollBoxComponentView r1, TagsScrollBoxComponent r2, List r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.a(r2, r3, false, null);
    }

    public final void a(TagsScrollBoxComponent r4, List r5, boolean r6, String r7) {
        this.d = r5;
        this.f = r4;
        this.c = r6;
        this.e = r7;
        removeAllViews();
        if (r4 == null) goto L18;
        List<TextWithOneIconElement> r8 = r4.getButtonList();
        if (r8 == null) goto L18;
        if ((!r8.isEmpty()) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L18;
        ExtensionsKt.j(this, r4.getBackground());
        if (r4.getScrollable() == false) goto L15;
        int r9 = r4.getSpace();
        int r0 = r4.getAlignStrategy();
        HorizontalScrollView r1 = new HorizontalScrollView(getContext());
        r1.setHorizontalFadingEdgeEnabled(false);
        r1.setHorizontalScrollBarEnabled(false);
        r1.addView(c(r8, r9, r0));
        Unit r10 = Unit.INSTANCE;
        addView(r1);
    L16:
        Action r11 = r4.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r11);
        return;
    L15:
        LinearLayout r12 = c(r8, r4.getSpace(), r4.getAlignStrategy());
        r12.setClipChildren(false);
        Unit r13 = Unit.INSTANCE;
        addView(r12);
    L18:
        setVisibility(8);
    }
}
