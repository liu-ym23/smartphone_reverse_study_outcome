package com.bytedance.ee.bear.document.titlebar.titleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.n;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020(H\u0016J\u0012\u00101\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\u0010\u00108\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0012\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020(H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/document/titlebar/titleview/DocumentTitleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/document/titlebar/titleview/ITitleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "titleContainer", "spaceTagTitleView", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "secondaryTitleView", "Landroid/widget/TextView;", "templateTag", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagType;", "externalTag", "tagValue", "", "labelList", "", "initView", "", "initIconView", "setGravity", "gravity", "initTagTitleView", "initSecondTitleView", "getView", "Landroid/view/View;", "setTitle", "title", "", "getTitleVisible", "", "setTitleTextSize", "sizeRes", "setTitleTextColor", "colorRes", "setTitleTextColorInt", "colorInt", "setTitleTextBold", "bold", "setSecondTitle", "setSecondTitleVisibility", "visible", "setSecondTitleLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "getIconView", "setTemplateTagVisible", "setTitleVisible", "setExternalVisible", "setExternalTag", "tag", "setExternalTagEnabled", "enable", "setSpaceTagTitleBarEnabled", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocumentTitleView extends LinearLayout implements b {
    public ImageView a;
    public LinearLayout b;
    public SpaceTagTitleView c;
    public TextView d;
    public final SpaceTagType e;
    public SpaceTagType f;
    public String g;
    public final List<SpaceTagType> h;

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public ImageView getIconView() {
        ImageView r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public boolean getTitleVisible() {
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L6:
        if (r0.c.getVisibility() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public DocumentTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalTag(String r4) {
        if (TextUtils.equals(this.g, r4) == true) goto L12;
        int r0 = SpaceTagType.e;
        SpaceTagType r1 = SpaceTagType.Companion.f(r4, this.f.a, true);
        if (this.h.contains(this.f) == false) goto L10;
        this.h.remove(this.f);
        this.h.add(r1);
        SpaceTagTitleView r2 = this.c;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r2 = null;
    L9:
        r2.setLabels(this.h);
    L10:
        this.f = r1;
        this.g = r4;
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalTagEnabled(boolean r4) {
        SpaceTagTitleView r0 = null;
        if (r4 == false) goto L12;
        if (this.h.contains(this.f) == true) goto L19;
        this.h.add(this.f);
        SpaceTagTitleView r5 = this.c;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L10:
        r0.setLabels(this.h);
        return;
    L9:
        r0 = r5;
        goto L10
    L19:
        return;
    L12:
        if (this.h.contains(this.f) == false) goto L21;
        this.h.remove(this.f);
        SpaceTagTitleView r6 = this.c;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L17:
        r0.setLabels(this.h);
        return;
    L16:
        r0 = r6;
        goto L17
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalVisible(boolean r3) {
        SpaceTagType r0 = this.f;
        if (r0.a == r3) goto L11;
        r0.a = r3;
        if (this.h.contains(r0) == false) goto L12;
        SpaceTagTitleView r4 = this.c;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r4 = null;
    L9:
        r4.setLabels(this.h);
        return;
    L12:
        return;
    }

    @Override // android.widget.LinearLayout, com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setGravity(int r2) {
        super.setGravity(r2);
        Lazy r0 = FGDowngradeHelper.a;
        if (((Boolean) FGDowngradeHelper.b.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        SpaceTagTitleView r1 = this.c;
        if (r1 == null) goto L9;
        r1.setGravity(r2);
        return;
    }

    public void setSecondTitle(CharSequence r2) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public void setSecondTitleLeftDrawable(Drawable r4) {
        Intrinsics.checkNotNullParameter(r4, "drawable");
        r4.setBounds(0, 0, d.a(15), d.a(15));
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r0 = null;
    L5:
        r0.setCompoundDrawables(r4, null, null, null);
    }

    public void setSecondTitleVisibility(boolean r2) {
        TextView r0 = this.d;
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

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setSpaceTagTitleBarEnabled(boolean r3) {
        LinearLayout r0 = null;
        if (r3 == false) goto L9;
        LinearLayout r4 = this.c;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L8:
        r0.setVisibility(0);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        LinearLayout r5 = this.c;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L13:
        r0.setVisibility(8);
        return;
    L12:
        r0 = r5;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTemplateTagVisible(boolean r3) {
        SpaceTagType r0 = this.e;
        if (r0.a == r3) goto L9;
        r0.a = r3;
        SpaceTagTitleView r4 = this.c;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r4 = null;
    L7:
        r4.setLabels(this.h);
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitle(CharSequence r2) {
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitle(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextBold(boolean r2) {
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleBold(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextColor(int r3) {
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleColor(getContext().getResources().getColor(r3));
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextColorInt(int r2) {
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleColor(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextSize(int r2) {
        int r3 = n.F((int) getContext().getResources().getDimension(r2));
        SpaceTagTitleView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleSize(r3);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleVisible(boolean r3) {
        SpaceTagTitleView r0 = this.c;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r0 = null;
    L5:
        r0.setTitleVisibility(r3);
        if (r3 == false) goto L17;
        ImageView r4 = this.a;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L11:
        if (r4.getDrawable() == null) goto L17;
        ImageView r5 = this.a;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L16:
        r1.setVisibility(0);
        return;
    L15:
        r1 = r5;
    L17:
        ImageView r6 = this.a;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L21:
        r1.setVisibility(8);
        return;
    L20:
        r1 = r6;
        goto L21
    }

    public DocumentTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public DocumentTitleView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        int r13 = SpaceTagType.e;
        SpaceTagType r14 = SpaceTagType.Companion.i(false);
        this.e = r14;
        SpaceTagType r16 = SpaceTagType.Companion.c(false);
        this.f = r16;
        List<SpaceTagType> r17 = CollectionsKt.mutableListOf(new SpaceTagType[]{r16, r14});
        this.h = r17;
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r1.width = getResources().getDimensionPixelSize(2131166499);
        r1.height = getResources().getDimensionPixelSize(2131166499);
        r1.rightMargin = getResources().getDimensionPixelSize(2131166498);
        ImageView r4 = new ImageView(getContext());
        this.a = r4;
        r4.setVisibility(8);
        View r5 = this.a;
        TextView r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r5 = null;
    L5:
        addView(r5, r1);
        LinearLayout r2 = new LinearLayout(getContext());
        this.b = r2;
        r2.setOrientation(1);
        View r3 = this.b;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r3 = null;
    L8:
        addView(r3, new LinearLayout.LayoutParams(-1, -2));
        SpaceTagTitleView r7 = new SpaceTagTitleView(getContext());
        this.c = r7;
        r7.setLabels(r17);
        LinearLayout r18 = this.b;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r18 = null;
    L11:
        View r8 = this.c;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r8 = null;
    L14:
        r18.addView(r8);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, d.a(17));
        r19.gravity = 16;
        TextView r110 = new TextView(getContext());
        this.d = r110;
        r110.setEllipsize(TextUtils.TruncateAt.END);
        TextView r111 = this.d;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r111 = null;
    L17:
        r111.setTextSize(2, 12.0f);
        TextView r112 = this.d;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r112 = null;
    L20:
        r112.setTextColor(n.h(getContext(), 2131106607));
        TextView r113 = this.d;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r113 = null;
    L23:
        r113.setSingleLine(true);
        TextView r114 = this.d;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r114 = null;
    L26:
        r114.setVisibility(8);
        TextView r115 = this.d;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r115 = null;
    L29:
        r115.setCompoundDrawablePadding(d.a(4));
        LinearLayout r116 = this.b;
        if (r116 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r116 = null;
    L32:
        TextView r117 = this.d;
        if (r117 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
    L36:
        r116.addView(r6, r19);
        return;
    L35:
        r6 = r117;
        goto L36
    }
}
