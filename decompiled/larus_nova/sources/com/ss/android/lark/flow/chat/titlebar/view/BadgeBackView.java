package com.ss.android.lark.flow.chat.titlebar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "badgeView", "Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView$BadgeView;", "badgeMarginToIconStart", "setBadgeMarginToIconStart", "", "marginPx", "setIconResId", "res", "updateBadgeCount", "count", "BadgeView", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BadgeBackView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f423103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BadgeView f423104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f423105c;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView$BadgeView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "minSize", "paddingHorizontal", "textSize", "", "bgPaint", "Landroid/graphics/Paint;", "textPaint", "fontMetrics", "Landroid/graphics/Paint$FontMetrics;", "updateBadge", "", "setBadgeBackgroundColor", "color", "setBadgeTextColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BadgeView extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f423106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f423107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f423108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f423109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f423110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Paint.FontMetrics f423111f;

        public BadgeView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AttributeSet r101 = null;
            this(r100, r101, 6, 0);
        }

        public BadgeView(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this(r100, r101, 4, 0);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r110) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            super.onDraw(r110);
            if (this.f423106a > 0) goto L5;
            return;
        L5:
            float r100 = getWidth();
            float r101 = getHeight();
            float r102 = 2;
            float r103 = r100 / r102;
            float r111 = r101 / r102;
            String r112 = String.valueOf(this.f423106a);
            if (r112.length() != 1) goto L8;
            r110.drawCircle(r103, r111, Math.min(r100, r101) / r102, this.f423109d);
        L9:
            this.f423110e.getFontMetrics(this.f423111f);
            Paint.FontMetrics r104 = this.f423111f;
            r110.drawText(r112, r103, r111 - ((r104.bottom + r104.top) / r102), this.f423110e);
            return;
        L8:
            r110.drawRoundRect(0.0f, 0.0f, r100, r101, r111, r111, this.f423109d);
            goto L9
        }

        public final void setBadgeBackgroundColor(int r100) {
            this.f423109d.setColor(r100);
            invalidate();
        }

        public final void setBadgeTextColor(int r100) {
            this.f423110e.setColor(r100);
            invalidate();
        }

        @Override // android.view.View
        public final void onMeasure(int r100, int r101) {
            int r102 = this.f423106a;
            if (r102 > 0) goto L6;
            setMeasuredDimension(0, 0);
            return;
        L6:
            String r103 = String.valueOf(r102);
            float r104 = this.f423110e.measureText(r103);
            int r105 = this.f423107b;
            if (r103.length() != 1) goto L9;
            int r106 = this.f423107b;
        L10:
            setMeasuredDimension(View.resolveSize(r106, r100), View.resolveSize(r105, r101));
            return;
        L9:
            r106 = RangesKt.coerceAtLeast((int) (r104 + (this.f423108c * 2)), this.f423107b);
            goto L10
        }

        public BadgeView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
            this.f423107b = UIUtils.dp2px(r100, 18.0f);
            this.f423108c = UIUtils.dp2px(r100, 6.0f);
            float r103 = UIUtils.sp2px(r100, 11.0f);
            Paint r104 = new Paint(1);
            r104.setColor(ColorProtector.parseColor("#FFFF3B30"));
            r104.setStyle(Paint.Style.FILL);
            this.f423109d = r104;
            Paint r105 = new Paint(1);
            r105.setColor(-1);
            r105.setTextSize(r103);
            r105.setTypeface(Typeface.DEFAULT_BOLD);
            r105.setTextAlign(Paint.Align.CENTER);
            this.f423110e = r105;
            this.f423111f = new Paint.FontMetrics();
        }

        public /* synthetic */ BadgeView(Context r100, AttributeSet r101, int r102, int r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, 0);
        }
    }

    public BadgeBackView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BadgeBackView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setBadgeMarginToIconStart(int r100) {
        this.f423105c = r100;
        ViewGroup.LayoutParams r101 = this.f423104b.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        r102.setMarginStart(r100);
        this.f423104b.setLayoutParams(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setIconResId(int r100) {
        this.f423103a.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), r100, UIUtils.getColor(getContext(), R.color.flow_ud_neutral_100)));
    }

    public BadgeBackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AppCompatImageView r103 = new AppCompatImageView(r100);
        r103.setId(View.generateViewId());
        r103.setScaleType(ImageView.ScaleType.CENTER);
        this.f423103a = r103;
        BadgeView r104 = new BadgeView(r100, null, 6, 0);
        r104.setId(View.generateViewId());
        this.f423104b = r104;
        this.f423105c = UIUtils.dp2px(r100, 28.0f);
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(UIUtils.dp2px(r100, 44.0f), UIUtils.dp2px(r100, 44.0f));
        r105.startToStart = 0;
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        Unit r106 = Unit.INSTANCE;
        addView(r103, r105);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(-2, -2);
        r107.startToStart = r103.getId();
        r107.topToTop = 0;
        r107.bottomToBottom = 0;
        r107.setMarginStart(this.f423105c);
        r107.setMarginEnd(UIUtils.dp2px(r100, 6.0f));
        r107.endToEnd = 0;
        addView(r104, r107);
    }

    public /* synthetic */ BadgeBackView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
