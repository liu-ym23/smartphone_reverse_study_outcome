package com.bytedance.ee.bear.document.titlebar.titleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.bear.widgets.v;
import com.bytedance.ee.util.ui.n;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\fH\u0016J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000202H\u0016J\u0012\u00109\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u000202H\u0016J\u0010\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0016H\u0016J\u0010\u0010@\u001a\u00020$2\u0006\u0010;\u001a\u000202H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010;\u001a\u000202H\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010;\u001a\u000202H\u0016J\u0012\u0010C\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u000202H\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010F\u001a\u000202H\u0016J\b\u0010H\u001a\u00020\fH\u0002J\b\u0010I\u001a\u00020\fH\u0002J\u0016\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010KH\u0002J\n\u0010L\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020\fH\u0002J\b\u0010O\u001a\u000202H\u0002R\u001b\u0010\u000e\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/ee/bear/document/titlebar/titleview/DocumentOfficeTitleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/document/titlebar/titleview/IOfficeTitleView;", "Lcom/bytedance/ee/bear/widgets/VisualCenterOffsettable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minRightOffsetForCenterPx", "getMinRightOffsetForCenterPx", "()I", "minRightOffsetForCenterPx$delegate", "Lkotlin/Lazy;", "appliedTitleMaxWidthPx", "Ljava/lang/Integer;", "iconView", "Landroid/widget/ImageView;", "titleContainer", "spaceTagTitleView", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "secondaryTitleView", "Landroid/widget/TextView;", "templateTag", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagType;", "externalTag", "tagValue", "", "labelList", "", "initView", "", "initIconView", "setGravity", "gravity", "initTagTitleView", "initSecondTitleView", "getView", "Landroid/view/View;", "applyVisualCenterOffset", "desiredOffsetPx", "setTitle", "title", "", "getTitleVisible", "", "setTitleTextSize", "sizeRes", "setTitleTextColor", "colorRes", "setTitleTextBold", "bold", "setSecondTitle", "setSecondTitleVisibility", "visible", "setSecondTitleLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "getIconView", "setTemplateTagVisible", "setTitleVisible", "setExternalVisible", "setExternalTag", "tag", "setExternalTagEnabled", "enable", "setSpaceTagTitleBarEnabled", "getAvailableLeftOffsetPx", "getAvailableRightOffsetPx", "getVisibleContentBounds", "Lkotlin/Pair;", "getPrimaryTitleView", "updatePrimaryTitleMaxWidthIfNeeded", "targetMaxWidthPx", "resetPrimaryTitleMaxWidthIfNeeded", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocumentOfficeTitleView extends LinearLayout implements a, v {
    public final Lazy a;
    public Integer b;
    public ImageView c;
    public LinearLayout d;
    public SpaceTagTitleView e;
    public TextView f;
    public final SpaceTagType g;
    public SpaceTagType h;
    public String i;
    public final List<SpaceTagType> j;

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public View getView() {
        return this;
    }

    private final int getMinRightOffsetForCenterPx() {
        return ((Number) this.a.getValue()).intValue();
    }

    private final TextView getPrimaryTitleView() {
        LinearLayout r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L6:
        if (r0.getChildCount() <= 0) goto L14;
        LinearLayout r1 = this.e;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r1 = null;
    L10:
        View r2 = r1.getChildAt(0);
        if ((r2 instanceof TextView) == true) goto L13;
        return null;
    L13:
        return (TextView) r2;
    L14:
        return null;
    }

    private final Pair<Integer, Integer> getVisibleContentBounds() {
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = SmallLoadingPlugin.DURATION_MAX;
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = ShareItemModel.SRC_TINT_UNDEFINED;
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        ImageView r3 = this.c;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r3 = null;
    L6:
        if (r3.getVisibility() != 0) goto L19;
        ImageView r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L11:
        if (r4.getWidth() <= 0) goto L19;
        ImageView r5 = this.c;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r5 = null;
    L15:
        int r6 = r5.getLeft();
        ImageView r7 = this.c;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r7 = null;
    L18:
        b(r0, r1, r2, r6, r7.getRight());
    L19:
        View r8 = this.e;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r8 = null;
    L22:
        LinearLayout r9 = this.d;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r9 = null;
    L25:
        c(r0, r1, r2, r8, r9.getLeft());
        TextView r10 = this.f;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r10 = null;
    L28:
        LinearLayout r11 = this.d;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r11 = null;
    L31:
        c(r0, r1, r2, r10, r11.getLeft());
        if (r2.element == true) goto L34;
        return null;
    L34:
        return TuplesKt.to(Integer.valueOf(r0.element), Integer.valueOf(r1.element));
    }

    public final boolean d() {
        if (this.b != null) goto L5;
        return false;
    L5:
        TextView r0 = getPrimaryTitleView();
        if (r0 != null) goto L8;
        return false;
    L8:
        LinearLayout r1 = null;
        this.b = null;
        r0.setMaxWidth(SmallLoadingPlugin.DURATION_MAX);
        r0.requestLayout();
        LinearLayout r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L12:
        r1.requestLayout();
        requestLayout();
        return true;
    L11:
        r1 = r2;
        goto L12
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public ImageView getIconView() {
        ImageView r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public boolean getTitleVisible() {
        SpaceTagTitleView r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L6:
        if (r0.c.getVisibility() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final int getAvailableLeftOffsetPx() {
        Pair<Integer, Integer> r0 = getVisibleContentBounds();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return RangesKt.coerceAtLeast(((Number) r0.getFirst()).intValue() - getPaddingLeft(), 0);
    }

    private final int getAvailableRightOffsetPx() {
        Pair<Integer, Integer> r0 = getVisibleContentBounds();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return RangesKt.coerceAtLeast((getWidth() - getPaddingRight()) - ((Number) r0.getSecond()).intValue(), 0);
    }

    public DocumentOfficeTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(int r11) {
        int r0 = getAvailableLeftOffsetPx();
        int r1 = getAvailableRightOffsetPx();
        TextView r2 = getPrimaryTitleView();
        LinearLayout r6 = null;
        if (r11 == 0) goto L5;
        int r8 = 0;
        int r7 = RangesKt.coerceAtLeast(r11 - r1, 0);
        if (r2 == null) goto L27;
        int r3 = r2.getWidth();
    L28:
        if (r7 <= 0) goto L58;
        if (r3 <= 0) goto L58;
        int r4 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r3 - r7, 0), 0);
        Integer r9 = this.b;
        if (r9 != null) goto L34;
    L36:
        if (r9 != null) goto L38;
    L40:
        TextView r10 = getPrimaryTitleView();
        if (r10 != null) goto L43;
    L42:
        boolean r5 = false;
    L47:
        if (r5 == false) goto L58;
        ImageView r12 = this.c;
        if (r12 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r12 = null;
    L51:
        r12.setTranslationX(0.0f);
        LinearLayout r13 = this.d;
        if (r13 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L55:
        r6.setTranslationX(0.0f);
        return;
    L54:
        r6 = r13;
        goto L55
    L43:
        this.b = Integer.valueOf(r4);
        r10.setMaxWidth(r4);
        r10.requestLayout();
        LinearLayout r14 = this.e;
        if (r14 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r14 = null;
    L46:
        r14.requestLayout();
        requestLayout();
        r5 = true;
        goto L47
    L38:
        if (r4 < r9.intValue()) goto L40;
    L34:
        if (r9.intValue() != r4) goto L36;
    L58:
        if (r1 < getMinRightOffsetForCenterPx()) goto L61;
        r8 = RangesKt.coerceIn(r11, -r0, r1);
    L61:
        float r16 = r8;
        ImageView r17 = this.c;
        if (r17 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r17 = null;
    L64:
        r17.setTranslationX(r16);
        LinearLayout r18 = this.d;
        if (r18 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L68:
        r6.setTranslationX(r16);
        return;
    L67:
        r6 = r18;
        goto L68
    L27:
        r3 = 0;
        goto L28
    L5:
        if (d() == false) goto L15;
        ImageView r19 = this.c;
        if (r19 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r19 = null;
    L9:
        r19.setTranslationX(0.0f);
        LinearLayout r110 = this.d;
        if (r110 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L13:
        r6.setTranslationX(0.0f);
        return;
    L12:
        r6 = r110;
        goto L13
    L15:
        ImageView r111 = this.c;
        if (r111 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r111 = null;
    L18:
        r111.setTranslationX(0.0f);
        LinearLayout r112 = this.d;
        if (r112 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    L22:
        r6.setTranslationX(0.0f);
        return;
    L21:
        r6 = r112;
        goto L22
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setExternalTag(String r4) {
        if (TextUtils.equals(this.i, r4) == true) goto L12;
        int r0 = SpaceTagType.e;
        SpaceTagType r1 = SpaceTagType.Companion.f(r4, this.h.a, true);
        if (this.j.contains(this.h) == false) goto L10;
        this.j.remove(this.h);
        this.j.add(r1);
        d();
        SpaceTagTitleView r2 = this.e;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r2 = null;
    L9:
        r2.setLabels(this.j);
    L10:
        this.h = r1;
        this.i = r4;
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setExternalTagEnabled(boolean r4) {
        SpaceTagTitleView r0 = null;
        if (r4 == false) goto L12;
        if (this.j.contains(this.h) == true) goto L19;
        this.j.add(this.h);
        d();
        SpaceTagTitleView r5 = this.e;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L10:
        r0.setLabels(this.j);
        return;
    L9:
        r0 = r5;
        goto L10
    L19:
        return;
    L12:
        if (this.j.contains(this.h) == false) goto L21;
        this.j.remove(this.h);
        d();
        SpaceTagTitleView r6 = this.e;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L17:
        r0.setLabels(this.j);
        return;
    L16:
        r0 = r6;
        goto L17
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setExternalVisible(boolean r3) {
        SpaceTagType r0 = this.h;
        if (r0.a == r3) goto L11;
        r0.a = r3;
        if (this.j.contains(r0) == false) goto L12;
        d();
        SpaceTagTitleView r4 = this.e;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r4 = null;
    L9:
        r4.setLabels(this.j);
        return;
    L12:
        return;
    }

    @Override // android.widget.LinearLayout, com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setGravity(int r2) {
        super.setGravity(r2);
        Lazy r0 = FGDowngradeHelper.a;
        if (((Boolean) FGDowngradeHelper.b.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        SpaceTagTitleView r1 = this.e;
        if (r1 == null) goto L9;
        r1.setGravity(r2);
        return;
    }

    public void setSecondTitle(CharSequence r2) {
        TextView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public void setSecondTitleLeftDrawable(Drawable r4) {
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r4.setBounds(0, 0, d.a(15), d.a(15));
        TextView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r0 = null;
    L5:
        r0.setCompoundDrawables(r4, null, null, null);
    }

    public void setSecondTitleVisibility(boolean r2) {
        TextView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setSpaceTagTitleBarEnabled(boolean r3) {
        LinearLayout r0 = null;
        if (r3 == false) goto L9;
        LinearLayout r4 = this.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L8:
        r0.setVisibility(0);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        LinearLayout r5 = this.e;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L13:
        r0.setVisibility(8);
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public void setTemplateTagVisible(boolean r3) {
        SpaceTagType r0 = this.g;
        if (r0.a == r3) goto L9;
        r0.a = r3;
        d();
        SpaceTagTitleView r4 = this.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r4 = null;
    L7:
        r4.setLabels(this.j);
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setTitle(CharSequence r2) {
        d();
        SpaceTagTitleView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitle(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setTitleTextBold(boolean r2) {
        SpaceTagTitleView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleBold(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setTitleTextColor(int r3) {
        SpaceTagTitleView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleColor(getContext().getResources().getColor(r3));
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setTitleTextSize(int r2) {
        int r3 = n.F((int) getContext().getResources().getDimension(r2));
        SpaceTagTitleView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleSize(r3);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.a
    public void setTitleVisible(boolean r3) {
        SpaceTagTitleView r0 = this.e;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleVisibility(r3);
        if (r3 == false) goto L17;
        ImageView r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L11:
        if (r4.getDrawable() == null) goto L17;
        ImageView r5 = this.c;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L16:
        r1.setVisibility(0);
        return;
    L15:
        r1 = r5;
    L17:
        ImageView r6 = this.c;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L21:
        r1.setVisibility(8);
        return;
    L20:
        r1 = r6;
        goto L21
    }

    public DocumentOfficeTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public DocumentOfficeTitleView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = LazyKt.lazy(DocumentOfficeTitleView$minRightOffsetForCenterPx$2.INSTANCE);
        int r13 = SpaceTagType.e;
        SpaceTagType r14 = SpaceTagType.Companion.i(false);
        this.g = r14;
        SpaceTagType r16 = SpaceTagType.Companion.c(false);
        this.h = r16;
        List<SpaceTagType> r17 = CollectionsKt.mutableListOf(new SpaceTagType[]{r16, r14});
        this.j = r17;
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r1.width = getResources().getDimensionPixelSize(2131166499);
        r1.height = getResources().getDimensionPixelSize(2131166499);
        r1.rightMargin = getResources().getDimensionPixelSize(2131166498);
        ImageView r4 = new ImageView(getContext());
        this.c = r4;
        r4.setVisibility(8);
        View r5 = this.c;
        TextView r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r5 = null;
    L5:
        addView(r5, r1);
        LinearLayout r2 = new LinearLayout(getContext());
        this.d = r2;
        r2.setOrientation(1);
        View r3 = this.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r3 = null;
    L8:
        addView(r3, new LinearLayout.LayoutParams(-1, -2));
        SpaceTagTitleView r7 = new SpaceTagTitleView(getContext());
        this.e = r7;
        r7.setLabels(r17);
        LinearLayout r18 = this.d;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r18 = null;
    L11:
        View r8 = this.e;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r8 = null;
    L14:
        r18.addView(r8);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, d.a(17));
        r19.gravity = 16;
        TextView r110 = new TextView(getContext());
        this.f = r110;
        r110.setEllipsize(TextUtils.TruncateAt.END);
        TextView r111 = this.f;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r111 = null;
    L17:
        r111.setTextSize(2, 12.0f);
        TextView r112 = this.f;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r112 = null;
    L20:
        r112.setTextColor(n.h(getContext(), 2131106607));
        TextView r113 = this.f;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r113 = null;
    L23:
        r113.setSingleLine(true);
        TextView r114 = this.f;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r114 = null;
    L26:
        r114.setVisibility(8);
        TextView r115 = this.f;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r115 = null;
    L29:
        r115.setCompoundDrawablePadding(d.a(4));
        LinearLayout r116 = this.d;
        if (r116 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r116 = null;
    L32:
        TextView r117 = this.f;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
    L36:
        r116.addView(r6, r19);
        return;
    L35:
        r6 = r117;
        goto L36
    }

    public static final void b(Ref.IntRef r1, Ref.IntRef r2, Ref.BooleanRef r3, int r4, int r5) {
        r1.element = Math.min(r1.element, r4);
        r2.element = Math.max(r2.element, r5);
        r3.element = true;
    }

    public static final void c(Ref.IntRef r4, Ref.IntRef r5, Ref.BooleanRef r6, View r7, int r8) {
        if (r7.getVisibility() == 0) goto L5;
        return;
    L5:
        if (r7.getWidth() <= 0) goto L28;
        boolean r0 = r7 instanceof LinearLayout;
        if (r0 == false) goto L10;
    L13:
        if (r0 == true) goto L17;
        if ((r7 instanceof SpaceTagTitleView) == true) goto L17;
        return;
    L17:
        if ((r7 instanceof ViewGroup) == false) goto L23;
        LinearLayout r1 = (LinearLayout) r7;
        if (r1.getChildCount() <= 0) goto L23;
        int r9 = r1.getChildCount();
        int r2 = 0;
    L21:
        if (r2 >= r9) goto L29;
        c(r4, r5, r6, r1.getChildAt(r2), r1.getLeft() + r8);
        r2 = r2 + 1;
        goto L21
    L29:
        return;
    L23:
        LinearLayout r10 = (LinearLayout) r7;
        b(r4, r5, r6, r10.getLeft() + r8, r8 + r10.getRight());
        return;
    L10:
        if ((r7 instanceof SpaceTagTitleView) == true) goto L13;
        b(r4, r5, r6, r7.getLeft() + r8, r8 + r7.getRight());
        return;
    }
}
