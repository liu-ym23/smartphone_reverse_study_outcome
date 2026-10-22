package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.badge.UDBadge;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001bJ\u0015\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0019J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u0010\u00102\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u0018\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0019J\u001a\u00105\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u0019J&\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J&\u0010=\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020\u0011J\u0006\u0010A\u001a\u00020\u0015J&\u0010B\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J\f\u0010C\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/NormalItem;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "view", "Landroid/view/View;", "bgView", "Landroid/widget/LinearLayout;", "leftIconContainer", "Landroid/widget/FrameLayout;", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "leftBadge", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "leftEmojiText", "Landroid/widget/TextView;", "leftLabel", "textTv", "setIcon", "", "iconRes", "", "setEmojiContent", "", "text", "setIconColor", "colorRes", "setLeftIconVisible", "visible", "setEmojiVisible", "setLeftLabelVisible", "setTextVisible", "setText", "content", "setBadge", "num", "(Ljava/lang/Integer;)V", "setTextBold", "isBold", "setTextMaxLines", "maxLines", "setTextSize", "size", "setEmojiSize", "setTextColor", "setIconSize", "isCenter", "setRoundBackground", "isRound", "isSelected", "setBgViewPadding", "left", "top", "right", "bottom", "setIconPadding", "setViewHeight", "height", "getLeftIconView", "getEmojiView", "setViewPadding", "dp", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalItem extends RelativeLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f427191i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f427192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f427193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f427194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f427195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UDBadgeView f427196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f427197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f427198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f427199h;

    public NormalItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NormalItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getEmojiView() {
        return this.f427197f;
    }

    public final AppCompatImageView getLeftIconView() {
        return this.f427195d;
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final void c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        int r102 = n.n(getContext(), "ud_icon_abbreviation_outlined");
        this.f427195d.setImageResource(r102);
        return;
    L11:
        int r103 = n.o(getContext(), r100);
        if (r103 == 0) goto L15;
        this.f427195d.setImageResource(r103);
        return;
    L15:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void setBadge(Integer r100) {
        if (r100 != null) goto L7;
        this.f427196e.setVisibility(8);
        return;
    L7:
        if (r100.intValue() <= 0) goto L9;
        this.f427196e.setVisibility(0);
        this.f427196e.setText(String.valueOf(RangesKt.coerceAtMost(r100.intValue(), 99)));
        this.f427196e.a();
        return;
    L9:
        this.f427196e.setVisibility(8);
    }

    public final void setEmojiContent(String r100) {
        this.f427195d.setVisibility(8);
        this.f427197f.setVisibility(0);
        this.f427197f.setText(r100);
    }

    public final void setEmojiSize(int r100) {
        this.f427197f.setTextSize(r100);
    }

    public final void setEmojiVisible(boolean r100) {
        TextView r101 = this.f427197f;
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
        this.f427195d.setColorFilter(r103, PorterDuff.Mode.SRC_IN);
    }

    public final void setLeftIconVisible(boolean r100) {
        AppCompatImageView r101 = this.f427195d;
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
        View r101 = this.f427198g;
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
        this.f427199h.setText(r100);
    }

    public final void setTextBold(boolean r100) {
        TextView r101 = this.f427199h;
        int r102 = e.f483540a;
        r101.setTypeface(e.b(getContext(), r100 ? 1 : 0));
    }

    public final void setTextColor(String r100) {
        Context r101 = getContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        int r102 = n.j(r101, r100);
        int r103 = ContextCompat.getColor(getContext(), r102);
        this.f427199h.setTextColor(r103);
    }

    public final void setTextMaxLines(int r100) {
        this.f427199h.setMaxLines(r100);
    }

    public final void setTextSize(int r100) {
        this.f427199h.setTextSize(r100);
    }

    public final void setTextVisible(boolean r100) {
        TextView r101 = this.f427199h;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setViewHeight(int r100) {
        ViewGroup.LayoutParams r101 = this.f427192a.getLayoutParams();
        r101.height = a(r100);
    }

    public final void d(int r100, boolean r101) {
        AppCompatImageView r102 = this.f427195d;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(a(r100), a(r100));
        if (r101 == false) goto L5;
        r103.gravity = 17;
    L5:
        r102.setLayoutParams(r103);
    }

    public NormalItem(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.layout_icon_text_item, this, true);
        this.f427192a = findViewById(R.id.item_view);
        this.f427193b = (LinearLayout) findViewById(R.id.bg_view);
        this.f427194c = (FrameLayout) findViewById(R.id.icon_view_group);
        this.f427195d = (AppCompatImageView) findViewById(R.id.icon_iv);
        UDBadgeView r103 = (UDBadgeView) findViewById(R.id.badge_view);
        this.f427196e = r103;
        this.f427197f = (TextView) findViewById(R.id.emoji_text);
        this.f427198g = findViewById(R.id.label_view);
        this.f427199h = (TextView) findViewById(R.id.content_tv);
        r103.setBadgeType(UDBadge.BadgeType.TEXT);
        r103.setTextMaxLength(2);
        r103.setVisibility(8);
    }

    public /* synthetic */ NormalItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(int r100, int r101, int r102, int r103) {
        this.f427193b.setPadding(a(r100), a(r101), a(r102), a(r103));
    }
}
