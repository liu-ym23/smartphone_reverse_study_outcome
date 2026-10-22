package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class v0 extends ImageSpan implements gw8.d, q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f305279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f305280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f305281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f305282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<View> f305283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f305284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f305285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f305286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f305287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f305288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f305289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u0 f305290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f305291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f305292n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f305293o;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<v0> f305294a;

        public a(v0 r100) {
            Intrinsics.checkNotNullParameter(r100, "span");
            this.f305294a = new WeakReference(r100);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            v0 r101 = this.f305294a.get();
            if (r101 != null) goto L6;
            r100.cancel();
            return;
        L6:
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.f305288j = ((Integer) r102).intValue();
            WeakReference<View> r103 = r101.f305283e;
            if (r103 == null) goto L27;
            View r104 = r103.get();
            if (r104 == null) goto L29;
            Unit r105 = null;
            if ((r104 instanceof ViewGroup) == false) goto L14;
            ViewGroup r106 = (ViewGroup) r104;
        L15:
            if (r106 == null) goto L25;
            View r107 = r106.getChildAt(r106.getChildCount() - 1);
            if ((r107 instanceof FrameLayout) == false) goto L19;
            FrameLayout r108 = (FrameLayout) r107;
        L20:
            if (r108 == null) goto L24;
            View r109 = r108.getChildAt(0);
            if (r109 == null) goto L24;
            r109.invalidate();
            r105 = Unit.INSTANCE;
        L24:
            if (r105 == null) goto L25;
            return;
        L19:
            r108 = null;
        L25:
            r104.invalidate();
            return;
        L14:
            r106 = null;
            goto L15
        L29:
            return;
        }
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.f305292n = false;
        a();
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.f305292n = true;
        b();
    }

    public final void a() {
        this.f305287i.cancel();
        if (((Boolean) this.f305286h.getValue()).booleanValue() == false) goto L6;
        com.larus.utils.t0.f375468a.removeCallbacks(this.f305290l);
        return;
    }

    public final void b() {
        if (this.f305289k == true) goto L5;
        return;
    L5:
        if (this.f305293o == true) goto L30;
        WeakReference<View> r100 = this.f305283e;
        if (r100 == null) goto L9;
        View r101 = r100.get();
    L11:
        if (this.f305282d == false) goto L16;
        if (r101 != null) goto L14;
    L15:
        boolean r102 = true;
    L17:
        if (r102 == false) goto L21;
        a();
        return;
    L21:
        if (this.f305287i.isRunning() == false) goto L23;
        return;
    L23:
        if (this.f305291m == true) goto L26;
        CopyOnWriteArrayList<WeakReference<q0>> r103 = s0.f305249a;
        s0.a(this);
        this.f305292n = !AppHost.f326268a.a().isAppBackground();
        this.f305291m = true;
    L26:
        if (this.f305292n == false) goto L32;
        this.f305287i.start();
        return;
    L32:
        return;
    L14:
        if (r101.isAttachedToWindow() == false) goto L15;
    L16:
        r102 = false;
        goto L17
    L9:
        r101 = null;
        goto L11
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = this.f305280b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Drawable r101 = super.getDrawable();
        if (r101 == null) goto L8;
        Drawable r102 = r101.mutate();
    L9:
        this.f305280b = r102;
        if (r102 == null) goto L17;
        Integer r103 = this.f305281c;
        if (r103 == null) goto L15;
        DrawableCompat.setTint(r102, r103.intValue());
        goto L17
    L15:
        DrawableCompat.setTintList(r102, null);
    L17:
        return this.f305280b;
    L8:
        r102 = null;
        goto L9
    }

    public /* synthetic */ v0(View r100, int r101, Context r102) {
        this(r100, r101, r102, false, null);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.bmhome.chat.layout.widget.u0] */
    public v0(View r100, int r101, Context r102, boolean r103, Integer r104) {
        if (r102 == null) goto L5;
        Context r105 = r102.getApplicationContext();
        if (r105 == null) goto L5;
    L6:
        super(r105, r101);
        this.f305279a = r103;
        this.f305281c = r104;
        if (r100 == null) goto L9;
        boolean r106 = true;
    L10:
        this.f305282d = r106;
        if (r100 == null) goto L13;
        WeakReference<View> r107 = new WeakReference(r100);
    L14:
        this.f305283e = r107;
        this.f305286h = LazyKt.lazy(new t0());
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{0, 255});
        r108.setDuration(400);
        r108.setRepeatCount(-1);
        r108.setRepeatMode(2);
        r108.addUpdateListener(new a(this));
        this.f305287i = r108;
        this.f305290l = new u0(this);
        this.f305292n = true;
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = false;
    L5:
        r105 = AppHost.f326268a.getApplication();
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        int r105 = 0;
        if (this.f305285g == false) goto L5;
        return 0;
    L5:
        Drawable r106 = getDrawable();
        if (r106 == null) goto L11;
        Rect r107 = r106.getBounds();
        if (r107 == null) goto L11;
        r105 = r107.right;
    L11:
        return r105 + i5.e0();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r108, "paint");
        if (this.f305285g == false) goto L5;
        return;
    L5:
        WeakReference<View> r109 = this.f305283e;
        io.noties.markwon.core.spans.o r110 = null;
        if (r109 == null) goto L8;
        View r111 = r109.get();
    L9:
        int r112 = 0;
        if (this.f305282d == false) goto L15;
        if (r111 != null) goto L13;
    L14:
        boolean r113 = true;
    L16:
        if (r113 == false) goto L20;
        a();
        return;
    L20:
        if ((r101 instanceof SpannableString) == false) goto L22;
        SpannableString r114 = (SpannableString) r101;
    L23:
        if (r114 == null) goto L28;
        io.noties.markwon.core.spans.o[] r115 = (io.noties.markwon.core.spans.o[]) r114.getSpans(0, ((SpannableString) r101).length(), io.noties.markwon.core.spans.o.class);
        if (r115 == null) goto L28;
        r110 = (io.noties.markwon.core.spans.o) ArraysKt.lastOrNull(r115);
    L28:
        if (this.f305279a == true) goto L31;
        if (r110 == null) goto L31;
        return;
    L31:
        Drawable r116 = getDrawable();
        if (r116 != null) goto L34;
        return;
    L34:
        Paint.FontMetricsInt r117 = r108.getFontMetricsInt();
        int r118 = ((((r117.descent + r106) + r106) + r117.ascent) / 2) - (r116.getBounds().bottom / 2);
        r100.save();
        if (this.f305284f == true) goto L38;
        r112 = i5.e0();
    L38:
        r100.translate(r104 + r112, r118);
        r116.setAlpha(this.f305288j);
        r116.draw(r100);
        r100.restore();
        return;
    L22:
        r114 = null;
        goto L23
    L13:
        if (r111.isAttachedToWindow() == false) goto L14;
    L15:
        r113 = false;
        goto L16
    L8:
        r111 = null;
        goto L9
    }
}
