package com.ss.android.lark.inline.ai.creationai.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\"\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u0010\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0016J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u001a\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u0014J&\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J&\u00104\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u0006\u00105\u001a\u00020\u000bJ&\u00106\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u0006\u00107\u001a\u00020\rJ\n\u00108\u001a\u00020\u0007*\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "leftEmojiText", "Landroid/widget/TextView;", "leftLabel", "Landroid/view/View;", "textTv", "bgView", "Landroid/widget/LinearLayout;", "setIcon", "", "iconRes", "", "setEmojiContent", "", "text", "setIconColor", "colorRes", "setLeftIconVisible", "visible", "setEmojiVisible", "setLeftLabelVisible", "setTextVisible", "setText", "content", "setTextBold", "isBold", "setTextMaxLines", "maxLines", "setTextSize", "size", "setEmojiSize", "setTextColor", "setIconSize", "setRoundBackground", "isRound", "isSelected", "setBgViewPadding", "left", "top", "right", "bottom", "setIconPadding", "getLeftIconView", "setViewPadding", "getEmojiView", "dp", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconTextItem extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f427221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f427222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f427223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f427224d;

    public static final class a {
    }

    static {
    }

    public IconTextItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IconTextItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getEmojiView() {
        return this.f427222b;
    }

    public final AppCompatImageView getLeftIconView() {
        return this.f427221a;
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final void setEmojiContent(String r100) {
        this.f427221a.setVisibility(8);
        this.f427222b.setText(r100);
    }

    public final void setEmojiSize(int r100) {
        this.f427222b.setTextSize(r100);
    }

    public final void setEmojiVisible(boolean r100) {
        TextView r101 = this.f427222b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setIconColor(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.i(r101, r100);
        int r103 = ContextCompat.getColor(getContext(), r102);
        this.f427221a.setColorFilter(r103, PorterDuff.Mode.SRC_IN);
    }

    public final void setIconSize(int r100) {
        this.f427221a.setLayoutParams(new LinearLayout.LayoutParams(a(r100), a(r100)));
    }

    public final void setLeftIconVisible(boolean r100) {
        AppCompatImageView r101 = this.f427221a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setLeftLabelVisible(boolean r100) {
        View r101 = this.f427223c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setText(String r100) {
        this.f427224d.setText(r100);
    }

    public final void setTextBold(boolean r100) {
        if (r100 == false) goto L4;
        TextView r101 = this.f427224d;
        int r102 = e.f483540a;
        r101.setTypeface(e.b(getContext(), 1));
        return;
    L4:
        TextView r103 = this.f427224d;
        int r104 = e.f483540a;
        r103.setTypeface(e.b(getContext(), 0));
    }

    public final void setTextColor(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.j(r101, r100);
        int r103 = ContextCompat.getColor(getContext(), r102);
        this.f427224d.setTextColor(r103);
    }

    public final void setTextMaxLines(int r100) {
        this.f427224d.setMaxLines(r100);
    }

    public final void setTextSize(int r100) {
        this.f427224d.setTextSize(r100);
    }

    public final void setTextVisible(boolean r100) {
        TextView r101 = this.f427224d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public IconTextItem(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LinearLayout r113 = new LinearLayout(r110);
        r113.setOrientation(0);
        r113.setGravity(16);
        AppCompatImageView r100 = new AppCompatImageView(r110);
        r100.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r100.setAdjustViewBounds(true);
        this.f427221a = r100;
        TextView r101 = new TextView(r110);
        r101.setVisibility(8);
        r101.setTextSize(14.0f);
        r101.setPadding(0, a(1), a(4), 0);
        this.f427222b = r101;
        View r102 = new View(r110);
        r102.setBackground(ContextCompat.getDrawable(r110, n.j(r110, "icon_disabled")));
        r102.setVisibility(8);
        this.f427223c = r102;
        TextView r103 = new TextView(r110);
        r103.setPadding(a(2), 0, 0, 0);
        r103.setTextColor(ContextCompat.getColor(r110, n.i(r110, "title_color")));
        r103.setTextSize(14.0f);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setMaxLines(1);
        this.f427224d = r103;
        addView(r113, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(a(2), a(16));
        r114.gravity = 16;
        r114.setMargins(a(8), 0, a(8), 0);
        Unit r115 = Unit.INSTANCE;
        r113.addView(r102, r114);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(-2, -2);
        r116.gravity = 16;
        r113.addView(r100, r116);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-2, -2);
        r117.gravity = 16;
        r113.addView(r101, r117);
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-2, -2);
        r118.gravity = 16;
        r113.addView(r103, r118);
        ViewGroup.LayoutParams r119 = new FrameLayout.LayoutParams(-1, -2);
        setPadding(a(20), a(12), a(20), a(12));
        setLayoutParams(r119);
    }

    public /* synthetic */ IconTextItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
