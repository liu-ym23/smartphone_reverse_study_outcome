package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.ButtonType;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&R(\u0010.\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/e;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "description", "", "setRadius", "", "statusId", "", "shouldIndent", "update", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "getViewTag", "a", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getDescriptionVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "setDescriptionVO", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "descriptionVO", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "b", "Lkotlin/Lazy;", "getRadiusHelper", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/extensions/b;", "radiusHelper", "", "c", "getStatusMap", "()Ljava/util/Map;", "statusMap", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "d", "getTextElementView", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "textElementView", "Landroid/view/View;", "<set-?>", "e", "Landroid/view/View;", "getIconView", "()Landroid/view/View;", "iconView", "Landroid/widget/LinearLayout;", "f", "getLinearWrapBox", "()Landroid/widget/LinearLayout;", "linearWrapBox", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TextWithOneIconElementView extends FrameLayout implements ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.e {
    public static final /* synthetic */ int j = 0;
    public TextWithOneIconElement a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public View e;
    public final Lazy f;
    public String g;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a h;
    public String i;

    public static final class a {
    }

    static {
    }

    public TextWithOneIconElementView(Context r7) {
        this(r7, null, 0, null, 30);
    }

    public TextWithOneIconElementView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 28);
    }

    public TextWithOneIconElementView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 24);
    }

    private final LinearLayout getLinearWrapBox() {
        return (LinearLayout) this.f.getValue();
    }

    private final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b getRadiusHelper() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b) this.b.getValue();
    }

    private final Map<String, TextWithOneIconElement> getStatusMap() {
        return (Map) this.c.getValue();
    }

    public final TextElementView getTextElementView() {
        return (TextElementView) this.d.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        TextWithOneIconElement r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.e
    public String getViewTag() {
        TextWithOneIconElement r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTag();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final TextWithOneIconElement getDescriptionVO() {
        return this.a;
    }

    public final View getIconView() {
        return this.e;
    }

    private final void setRadius(TextWithOneIconElement r2) {
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r0 = getRadiusHelper();
        Background r3 = r2.getBackground();
        if (r3 == null) goto L5;
        Radius r4 = r3.getRadius();
    L6:
        r0.f(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "status");
        TextWithOneIconElement r0 = this.a;
        if (r0 == null) goto L8;
        TextWithOneIconElement r2 = r0.findStatus(r8);
        if (r2 == null) goto L9;
        b(this, r2, null, false, null, 14);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        getRadiusHelper().e(r2);
        super.draw(r2);
        getRadiusHelper().d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.h = r2;
    }

    public final void setDescriptionVO(TextWithOneIconElement r1) {
        this.a = r1;
    }

    public final void a(View r2, ViewGroup.MarginLayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        wg.a.a(r2);
        addView(r2, r3);
    }

    public final void update(TextWithOneIconElement r1, String r2, boolean r3) {
        this.a = r1;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        getRadiusHelper().c(r1, r2);
    }

    public TextWithOneIconElementView(final Context r2, AttributeSet r3, int r4, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = r5;
        this.i = r6;
        this.b = LazyKt.lazy(new TextWithOneIconElementView$radiusHelper$2(this));
        this.c = LazyKt.lazy(TextWithOneIconElementView$statusMap$2.INSTANCE);
        this.d = LazyKt.lazy(new TextWithOneIconElementView$textElementView$2(this, r2));
        this.f = LazyKt.lazy(new TextWithOneIconElementView$linearWrapBox$2(r2));
    }

    public /* synthetic */ TextWithOneIconElementView(Context r9, AttributeSet r10, int r11, String r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        AttributeSet r4 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        String r7 = null;
    L14:
        this(r9, r4, r5, null, r7);
        return;
    L13:
        r7 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v8, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    public static void b(TextWithOneIconElementView r8, TextWithOneIconElement r9, String r10, boolean r11, String r12, int r13) {
        Integer r1 = null;
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 8) == 0) goto L11;
        r12 = null;
    L11:
        r8.a = r9;
        r8.g = r12;
        if (r9 != null) goto L14;
        r8.setVisibility(8);
        return;
    L14:
        r8.removeAllViews();
        r8.e = null;
        LinearLayout r14 = r8.getLinearWrapBox();
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        int r4 = r9.getAlignStrategy();
        boolean r5 = true;
        if (r4 == 1) goto L22;
        int r6 = 3;
        if (r4 != 3) goto L19;
    L23:
        r15.gravity = r6;
        Unit r7 = Unit.INSTANCE;
        r8.addView(r14, r15);
        r8.getStatusMap().clear();
        List r16 = r9.getStates();
        if (r16 != null) goto L26;
    L40:
        r8.setContentDescription(r9.getContentDescription());
        TextWithOneIconElement r17 = r8.getStatusMap().get(r10);
        if (r17 == null) goto L44;
        r9 = r17;
    L44:
        r8.setRadius(r9);
        ExtensionsKt.j(r8, r9.getBackground());
        r8.getLinearWrapBox().removeAllViews();
        if (r9.getIcon() == null) goto L126;
        if (r9.getContent() == null) goto L126;
        int r18 = r9.getButtonType();
        TextElement r19 = r9.getContent();
        if (r19 == null) goto L149;
        ImageModel r110 = r9.getIcon();
        if (r110 == null) goto L149;
        ButtonType r0 = ButtonType.LEFT;
        Integer r20 = r0.getType();
        if (r20 != null) goto L58;
    L59:
        Integer r21 = ButtonType.RIGHT.getType();
        if (r21 != null) goto L63;
    L65:
        int r22 = 0;
    L67:
        r8.getLinearWrapBox().setOrientation(r22 ^ 1);
        View r111 = ImageExtensionsKt.f(r110, r8.getContext(), r8.g);
        r8.e = r111;
        View[] r23 = new View[2];
        r23[0] = r111;
        ?? r112 = r8.getTextElementView();
        r112.x(r19);
        r112.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
        Integer r24 = Integer.valueOf(r9.getSpace());
        if (r24.intValue() <= 0) goto L70;
        boolean r25 = true;
    L71:
        if (r25 == false) goto L73;
        r1 = r24;
    L73:
        if (r1 == null) goto L98;
        int r2 = r1.intValue();
        Integer r3 = r0.getType();
        if (r3 != null) goto L78;
    L80:
        Integer r26 = ButtonType.TOP.getType();
        if (r26 != null) goto L84;
    L86:
        Integer r27 = ButtonType.RIGHT.getType();
        if (r27 != null) goto L90;
    L92:
        Integer r28 = ButtonType.BOTTOM.getType();
        if (r28 == null) goto L98;
        if (r18 != r28.intValue()) goto L98;
        r113.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
        goto L98
    L90:
        if (r18 != r27.intValue()) goto L92;
        r113.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
        goto L98
    L84:
        if (r18 != r26.intValue()) goto L86;
        r113.topMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
        goto L98
    L78:
        if (r18 != r3.intValue()) goto L80;
        r113.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2));
    L98:
        r112.setLayoutParams(r113);
        Unit r114 = Unit.INSTANCE;
        r23[1] = r112;
        List r115 = CollectionsKt.listOf(r23);
        Integer r116 = ButtonType.RIGHT.getType();
        if (r116 != null) goto L102;
    L103:
        Integer r117 = ButtonType.BOTTOM.getType();
        if (r117 != null) goto L107;
    L109:
        r5 = false;
    L110:
        if (r5 == false) goto L112;
        r115 = CollectionsKt.reversed(r115);
    L112:
        Iterator r118 = r115.iterator();
    L114:
        if (r118.hasNext() == false) goto L149;
        AppCompatTextView r119 = (View) r118.next();
        if (r11 == false) goto L124;
        if ((r119 instanceof TextElementView) == false) goto L124;
        ViewGroup.LayoutParams r120 = ((TextElementView) r119).getLayoutParams();
        if (r120 == null) goto L123;
        LinearLayout.LayoutParams r121 = (LinearLayout.LayoutParams) r120;
        r121.width = 0;
        r121.height = -2;
        r121.weight = 1.0f;
        r8.getLinearWrapBox().addView(r119, r121);
        goto L114
    L123:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L124:
        r8.getLinearWrapBox().addView(r119);
        goto L114
    L107:
        if (r18 != r117.intValue()) goto L109;
    L102:
        if (r18 == r116.intValue()) goto L110;
    L70:
        r25 = false;
        goto L71
    L63:
        if (r18 != r21.intValue()) goto L65;
    L66:
        r22 = 1;
        goto L67
    L58:
        if (r18 == r20.intValue()) goto L66;
    L149:
        Action r29 = r9.getAction();
        Intrinsics.checkNotNullParameter(r8, "theView");
        ActionHubAccessor.DefaultImpls.a(r8, r8, r29);
        return;
    L126:
        if (r9.getIcon() == null) goto L132;
        ImageModel r122 = r9.getIcon();
        if (r122 == null) goto L149;
        r8.e = ImageExtensionsKt.f(r122, r8.getContext(), r8.g);
        r8.getLinearWrapBox().addView(r8.e);
        goto L149
    L132:
        if (r9.getContent() == null) goto L138;
        TextElement r123 = r9.getContent();
        if (r123 == null) goto L149;
        LinearLayout r124 = r8.getLinearWrapBox();
        ?? r125 = r8.getTextElementView();
        r125.x(r123);
        r124.addView(r125);
        goto L149
    L138:
        if (r9.getContentV2() == null) goto L147;
        List r126 = r9.getContentV2();
        if (r126 == null) goto L149;
        Iterator r127 = r126.iterator();
    L144:
        if (r127.hasNext() == false) goto L149;
        TextElement r128 = (TextElement) r127.next();
        LinearLayout r129 = r8.getLinearWrapBox();
        ?? r130 = new TextElementView(r8.getContext(), null, 0, r8.i, 14);
        r130.x(r128);
        r129.addView(r130);
        goto L144
    L147:
        if (r9.getBackground() != null) goto L149;
        r8.setVisibility(8);
        goto L149
    L26:
        if ((!r16.isEmpty()) != true) goto L40;
        String r131 = r9.getStatusId();
        if (r131 == null) goto L30;
        TextWithOneIconElement r132 = r8.getStatusMap().put(r131, r9);
    L30:
        List r133 = r9.getStates();
        if (r133 == null) goto L40;
        Iterator r134 = r133.iterator();
    L34:
        if (r134.hasNext() == false) goto L40;
        TextWithOneIconElement r135 = (TextWithOneIconElement) r134.next();
        if (r135 == null) goto L34;
        String r30 = r135.getStatusId();
        if (r30 == null) goto L34;
        TextWithOneIconElement r136 = r8.getStatusMap().put(r30, r135);
        goto L34
    L19:
        if (r4 != 4) goto L22;
        r6 = 5;
    L22:
        r6 = 17;
        goto L23
    }
}
