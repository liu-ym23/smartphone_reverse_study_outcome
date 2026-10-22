package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.view.style.StyleTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/MarqueeTextViewV2;", "Lcom/ss/android/ugc/tools/view/style/StyleTextView;", "", "enable", "", "setMarqueeEnable$lib_runtime_release", "(Z)V", "setMarqueeEnable", "", "b", "I", "getEndPosition", "()I", "setEndPosition", "(I)V", "endPosition", "c", "getCount", "setCount", "count", "d", "getSpeed", "setSpeed", "speed", "e", "getTaskInterval", "setTaskInterval", "taskInterval", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Marquee", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class MarqueeTextViewV2 extends StyleTextView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f455042h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Marquee f455043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f455045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f455047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f455048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f455049g;

    public static final class Marquee {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f455050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f455051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f455052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f455053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f455054e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f455055f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f455056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f455057h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f455058i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f455059j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f455060k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final a f455061l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final MarqueeTextViewV2 f455062m;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Marquee f455063a;

            public a(Marquee r100) {
                this.f455063a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f455063a.a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void a() {
            if (this.f455056g == false) goto L5;
            return;
        L5:
            int r100 = -1;
            if (this.f455057h > 0) goto L41;
            int r101 = this.f455052c;
            if (r101 <= 0) goto L17;
            this.f455052c = r101 - 1;
            if (this.f455058i == false) goto L12;
            this.f455058i = false;
            this.f455057h = this.f455054e;
            goto L41
        L12:
            MarqueeTextViewV2 r102 = this.f455062m;
            int r103 = (-this.f455054e) - this.f455055f;
            if (this.f455060k == false) goto L15;
            int r104 = -1;
        L16:
            r102.scrollBy(r103 * r104, 0);
            this.f455057h = this.f455054e + this.f455055f;
        L40:
            boolean r105 = true;
        L42:
            if (r105 == true) goto L60;
            int r106 = this.f455057h;
            if (r106 > 0) goto L46;
            this.f455056g = true;
            return;
        L46:
            int r107 = this.f455050a;
            int r108 = (this.f455051b * r107) / 1000;
            if (r108 <= r106) goto L49;
            r108 = r106;
        L49:
            if (r108 > 0) goto L55;
            this.f455057h = r106 - 1;
            int r109 = 1000 / r107;
            MarqueeTextViewV2 r110 = this.f455062m;
            if (this.f455060k == true) goto L54;
            r100 = 1;
        L54:
            r110.scrollBy(r100 * 1, 0);
            MarqueeTextViewV2$Marquee$innerMoveTask$1 r111 = new MarqueeTextViewV2$Marquee$innerMoveTask$1(this.f455061l);
            this.f455062m.postOnAnimationDelayed(new e(r111), r109);
            return;
        L55:
            this.f455057h = r106 - r108;
            MarqueeTextViewV2 r112 = this.f455062m;
            if (this.f455060k == true) goto L59;
            r100 = 1;
        L59:
            r112.scrollBy(r108 * r100, 0);
            MarqueeTextViewV2$Marquee$innerMoveTask$2 r113 = new MarqueeTextViewV2$Marquee$innerMoveTask$2(this.f455061l);
            this.f455062m.postOnAnimationDelayed(new e(r113), this.f455051b);
            return;
        L60:
            this.f455062m.postOnAnimation(new e(new MarqueeTextViewV2$Marquee$scrollTaskInner$1(this.f455061l)));
            return;
        L15:
            r104 = 1;
            goto L16
        L17:
            if (r101 >= 0) goto L27;
            if (this.f455058i == false) goto L21;
            this.f455058i = false;
            this.f455057h = this.f455054e;
            goto L41
        L21:
            MarqueeTextViewV2 r114 = this.f455062m;
            int r115 = (-this.f455054e) - this.f455055f;
            if (this.f455060k == false) goto L24;
            int r116 = -1;
        L25:
            r114.scrollBy(r115 * r116, 0);
            this.f455057h = this.f455054e + this.f455055f;
            goto L40
        L24:
            r116 = 1;
            goto L25
        L27:
            if (this.f455059j == false) goto L30;
            this.f455057h = 0;
            goto L41
        L30:
            if (this.f455058i == true) goto L36;
            MarqueeTextViewV2 r117 = this.f455062m;
            int r118 = (-this.f455054e) - this.f455055f;
            if (this.f455060k == false) goto L34;
            int r119 = -1;
        L35:
            r117.scrollBy(r118 * r119, 0);
            goto L36
        L34:
            r119 = 1;
        L36:
            this.f455059j = true;
            if (this.f455058i == false) goto L39;
            this.f455058i = true;
            this.f455057h = this.f455053d;
            goto L40
        L39:
            this.f455057h = this.f455055f + this.f455053d;
        L41:
            r105 = false;
            goto L42
        }

        public Marquee(MarqueeTextViewV2 r100) {
            Intrinsics.checkNotNullParameter(r100, "marqueeTextViewV2");
            this.f455062m = r100;
            this.f455050a = 40;
            this.f455051b = 10;
            this.f455052c = -1;
            this.f455056g = true;
            this.f455058i = true;
            this.f455061l = new a(this);
            this.f455054e = (int) r100.getPaint().measureText(r100.getText().toString());
            this.f455055f = (r100.getMeasuredWidth() - r100.getPaddingLeft()) - r100.getPaddingRight();
            this.f455060k = r100.y();
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarqueeTextViewV2 f455064a;

        public a(MarqueeTextViewV2 r100) {
            this.f455064a = r100;
        }

        public final void a() {
            MarqueeTextViewV2 r100 = this.f455064a;
            int r101 = MarqueeTextViewV2.f455042h;
            if ((((int) r100.getPaint().measureText(r100.getText().toString())) - ((r100.getMeasuredWidth() - r100.getPaddingLeft()) - r100.getPaddingRight())) <= 0) goto L28;
            r100.setHorizontallyScrolling(true);
            r100.setHorizontalFadingEdgeEnabled(true);
            r100.setEllipsize(null);
            Marquee r102 = new Marquee(r100);
            r100.f455043a = r102;
            StringBuilder r103 = new StringBuilder();
            r103.append(r100.getText());
            r103.append(' ');
            String r104 = r103.toString();
            Intrinsics.checkNotNullParameter(r104, "str");
            int r105 = (int) r100.getPaint().measureText(r104);
            if (r105 < 0) goto L27;
            r102.f455053d = r105;
            Marquee r106 = r100.f455043a;
            if (r106 == null) goto L9;
            r106.f455052c = r100.f455045c;
        L9:
            if (r106 == null) goto L15;
            float r107 = r100.f455046d;
            Resources r108 = Resources.getSystem();
            int r109 = (int) ((r107 * WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density) + 0.5f);
            if (r109 <= 0) goto L14;
            r106.f455050a = r109;
            goto L15
        L14:
            throw new IllegalArgumentException("speed must > 0");
        L15:
            Marquee r110 = r100.f455043a;
            if (r110 == null) goto L22;
            int r111 = r100.f455047e;
            if (r111 <= 0) goto L21;
            r110.f455051b = r111;
            goto L22
        L21:
            throw new IllegalArgumentException("taskInterval must > 0");
        L22:
            if (r110 != null) goto L24;
            return;
        L24:
            if (r110.f455056g == false) goto L30;
            r110.f455056g = false;
            r110.a();
            return;
        L30:
            return;
        L27:
            throw new IllegalArgumentException("endPosition must >= 0");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MarqueeTextViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MarqueeTextViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void z() {
        removeCallbacks(this.f455049g);
        Marquee r100 = this.f455043a;
        if (r100 == null) goto L8;
        if (r100.f455056g == true) goto L8;
        r100.f455056g = true;
    L8:
        if (y() == false) goto L10;
        setTextDirection(4);
        setLayoutDirection(1);
        invalidate();
        requestLayout();
    L10:
        postDelayed(this.f455049g, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f455048f == false) goto L6;
        z();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f455049g);
        Marquee r100 = this.f455043a;
        if (r100 != null) goto L5;
    L7:
        setHorizontallyScrolling(false);
        setHorizontalFadingEdgeEnabled(false);
        setEllipsize(TextUtils.TruncateAt.END);
        return;
    L5:
        if (r100.f455056g == true) goto L7;
        r100.f455056g = true;
        goto L7
    }

    public final boolean y() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getCount() {
        return this.f455045c;
    }

    public final int getEndPosition() {
        return this.f455044b;
    }

    public final int getSpeed() {
        return this.f455046d;
    }

    public final int getTaskInterval() {
        return this.f455047e;
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f455048f;
    }

    public final void setCount(int r100) {
        this.f455045c = r100;
    }

    public final void setEndPosition(int r100) {
        this.f455044b = r100;
    }

    public final void setMarqueeEnable$lib_runtime_release(boolean r100) {
        if (this.f455048f == r100) goto L14;
        this.f455048f = r100;
        if (r100 == false) goto L7;
        z();
        return;
    L7:
        removeCallbacks(this.f455049g);
        Marquee r101 = this.f455043a;
        if (r101 != null) goto L10;
    L12:
        setHorizontallyScrolling(false);
        setHorizontalFadingEdgeEnabled(false);
        setEllipsize(TextUtils.TruncateAt.END);
        return;
    L10:
        if (r101.f455056g == true) goto L12;
        r101.f455056g = true;
        goto L12
    }

    public final void setSpeed(int r100) {
        this.f455046d = r100;
    }

    public final void setTaskInterval(int r100) {
        this.f455047e = r100;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Marquee r102 = this.f455043a;
        if (r102 != null) goto L5;
    L7:
        this.f455043a = null;
        super.setText(r100, r101);
        return;
    L5:
        if (r102.f455056g == true) goto L7;
        r102.f455056g = true;
        goto L7
    }

    public MarqueeTextViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f455045c = -1;
        this.f455046d = 40;
        this.f455047e = 25;
        this.f455049g = new a(this);
    }

    public /* synthetic */ MarqueeTextViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
