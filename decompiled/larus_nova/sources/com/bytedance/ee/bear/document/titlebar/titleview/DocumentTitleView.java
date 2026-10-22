package com.bytedance.ee.bear.document.titlebar.titleview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020(H\u0016J\u0012\u00101\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\u0010\u00108\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u00103\u001a\u00020(H\u0016J\u0012\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020(H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020(H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/document/titlebar/titleview/DocumentTitleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/document/titlebar/titleview/ITitleView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "titleContainer", "spaceTagTitleView", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "secondaryTitleView", "Landroid/widget/TextView;", "templateTag", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagType;", "externalTag", "tagValue", "", "labelList", "", "initView", "", "initIconView", "setGravity", GXTemplateKey.GAIAX_LAYER_GRAVITY, "initTagTitleView", "initSecondTitleView", "getView", "Landroid/view/View;", d.f25925o, "title", "", "getTitleVisible", "", "setTitleTextSize", "sizeRes", "setTitleTextColor", "colorRes", "setTitleTextColorInt", "colorInt", "setTitleTextBold", CommodityText.BOLD, "setSecondTitle", "setSecondTitleVisibility", "visible", "setSecondTitleLeftDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "getIconView", "setTemplateTagVisible", "setTitleVisible", "setExternalVisible", "setExternalTag", "tag", "setExternalTagEnabled", "enable", "setSpaceTagTitleBarEnabled", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocumentTitleView extends LinearLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f222264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f222265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpaceTagTitleView f222266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f222267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpaceTagType f222268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceTagType f222269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f222270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<SpaceTagType> f222271h;

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public ImageView getIconView() {
        ImageView r100 = this.f222264a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        return null;
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public boolean getTitleVisible() {
        SpaceTagTitleView r100 = this.f222266c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r100 = null;
    L6:
        if (r100.f240335c.getVisibility() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public DocumentTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalTag(String r100) {
        if (TextUtils.equals(this.f222270g, r100) == true) goto L12;
        int r101 = SpaceTagType.f240339e;
        SpaceTagType r102 = SpaceTagType.Companion.f(r100, this.f222269f.f240340a, true);
        if (this.f222271h.contains(this.f222269f) == false) goto L10;
        this.f222271h.remove(this.f222269f);
        this.f222271h.add(r102);
        SpaceTagTitleView r103 = this.f222266c;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r103 = null;
    L9:
        r103.setLabels(this.f222271h);
    L10:
        this.f222269f = r102;
        this.f222270g = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalTagEnabled(boolean r100) {
        SpaceTagTitleView r101 = null;
        if (r100 == false) goto L12;
        if (this.f222271h.contains(this.f222269f) == true) goto L19;
        this.f222271h.add(this.f222269f);
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L10:
        r101.setLabels(this.f222271h);
        return;
    L9:
        r101 = r102;
        goto L10
    L19:
        return;
    L12:
        if (this.f222271h.contains(this.f222269f) == false) goto L21;
        this.f222271h.remove(this.f222269f);
        SpaceTagTitleView r103 = this.f222266c;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L17:
        r101.setLabels(this.f222271h);
        return;
    L16:
        r101 = r103;
        goto L17
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setExternalVisible(boolean r100) {
        SpaceTagType r101 = this.f222269f;
        if (r101.f240340a == r100) goto L11;
        r101.f240340a = r100;
        if (this.f222271h.contains(r101) == false) goto L12;
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r102 = null;
    L9:
        r102.setLabels(this.f222271h);
        return;
    L12:
        return;
    }

    @Override // android.widget.LinearLayout, com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setGravity(int r100) {
        super.setGravity(r100);
        Lazy r101 = FGDowngradeHelper.f216485a;
        if (((Boolean) FGDowngradeHelper.f216486b.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 == null) goto L9;
        r102.setGravity(r100);
        return;
    }

    public void setSecondTitle(CharSequence r100) {
        TextView r101 = this.f222267d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public void setSecondTitleLeftDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        r100.setBounds(0, 0, y9c.d.a(15), y9c.d.a(15));
        TextView r101 = this.f222267d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r101 = null;
    L5:
        r101.setCompoundDrawables(r100, null, null, null);
    }

    public void setSecondTitleVisibility(boolean r100) {
        TextView r101 = this.f222267d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setSpaceTagTitleBarEnabled(boolean r100) {
        SpaceTagTitleView r101 = null;
        if (r100 == false) goto L9;
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L8:
        r101.setVisibility(0);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        SpaceTagTitleView r103 = this.f222266c;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
    L13:
        r101.setVisibility(8);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTemplateTagVisible(boolean r100) {
        SpaceTagType r101 = this.f222268e;
        if (r101.f240340a == r100) goto L9;
        r101.f240340a = r100;
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r102 = null;
    L7:
        r102.setLabels(this.f222271h);
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitle(CharSequence r100) {
        SpaceTagTitleView r101 = this.f222266c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r101 = null;
    L5:
        r101.setTitle(r100);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextBold(boolean r100) {
        SpaceTagTitleView r101 = this.f222266c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r101 = null;
    L5:
        r101.setTitleBold(r100);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextColor(int r100) {
        SpaceTagTitleView r101 = this.f222266c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r101 = null;
    L5:
        r101.setTitleColor(getContext().getResources().getColor(r100));
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextColorInt(int r100) {
        SpaceTagTitleView r101 = this.f222266c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r101 = null;
    L5:
        r101.setTitleColor(r100);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleTextSize(int r100) {
        int r101 = n.F((int) getContext().getResources().getDimension(r100));
        SpaceTagTitleView r102 = this.f222266c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r102 = null;
    L5:
        r102.setTitleSize(r101);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.titleview.b
    public void setTitleVisible(boolean r100) {
        SpaceTagTitleView r101 = this.f222266c;
        ImageView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r101 = null;
    L5:
        r101.setTitleVisibility(r100);
        if (r100 == false) goto L17;
        ImageView r103 = this.f222264a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r103 = null;
    L11:
        if (r103.getDrawable() == null) goto L17;
        ImageView r104 = this.f222264a;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L16:
        r102.setVisibility(0);
        return;
    L15:
        r102 = r104;
    L17:
        ImageView r105 = this.f222264a;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L21:
        r102.setVisibility(8);
        return;
    L20:
        r102 = r105;
        goto L21
    }

    public DocumentTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public DocumentTitleView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r113 = SpaceTagType.f240339e;
        SpaceTagType r114 = SpaceTagType.Companion.i(false);
        this.f222268e = r114;
        SpaceTagType r115 = SpaceTagType.Companion.c(false);
        this.f222269f = r115;
        List<SpaceTagType> r116 = CollectionsKt.mutableListOf(new SpaceTagType[]{r115, r114});
        this.f222271h = r116;
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        r100.gravity = 17;
        r100.width = getResources().getDimensionPixelSize(R.dimen.facade_icon_size);
        r100.height = getResources().getDimensionPixelSize(R.dimen.facade_icon_size);
        r100.rightMargin = getResources().getDimensionPixelSize(R.dimen.facade_icon_margin_right);
        ImageView r101 = new ImageView(getContext());
        this.f222264a = r101;
        r101.setVisibility(8);
        View r102 = this.f222264a;
        TextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r102 = null;
    L5:
        addView(r102, r100);
        LinearLayout r104 = new LinearLayout(getContext());
        this.f222265b = r104;
        r104.setOrientation(1);
        View r105 = this.f222265b;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r105 = null;
    L8:
        addView(r105, new LinearLayout.LayoutParams(-1, -2));
        SpaceTagTitleView r106 = new SpaceTagTitleView(getContext());
        this.f222266c = r106;
        r106.setLabels(r116);
        LinearLayout r117 = this.f222265b;
        if (r117 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r117 = null;
    L11:
        SpaceTagTitleView r107 = this.f222266c;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("spaceTagTitleView");
        r107 = null;
    L14:
        r117.addView(r107);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(-2, y9c.d.a(17));
        r118.gravity = 16;
        TextView r119 = new TextView(getContext());
        this.f222267d = r119;
        r119.setEllipsize(TextUtils.TruncateAt.END);
        TextView r120 = this.f222267d;
        if (r120 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r120 = null;
    L17:
        r120.setTextSize(2, 12.0f);
        TextView r121 = this.f222267d;
        if (r121 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r121 = null;
    L20:
        r121.setTextColor(n.h(getContext(), R.color.text_caption));
        TextView r122 = this.f222267d;
        if (r122 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r122 = null;
    L23:
        r122.setSingleLine(true);
        TextView r123 = this.f222267d;
        if (r123 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r123 = null;
    L26:
        r123.setVisibility(8);
        TextView r124 = this.f222267d;
        if (r124 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
        r124 = null;
    L29:
        r124.setCompoundDrawablePadding(y9c.d.a(4));
        LinearLayout r125 = this.f222265b;
        if (r125 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        r125 = null;
    L32:
        TextView r126 = this.f222267d;
        if (r126 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("secondaryTitleView");
    L36:
        r125.addView(r103, r118);
        return;
    L35:
        r103 = r126;
        goto L36
    }
}
