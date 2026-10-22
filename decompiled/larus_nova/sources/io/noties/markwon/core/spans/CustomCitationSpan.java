package io.noties.markwon.core.spans;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class CustomCitationSpan extends ReplacementSpan implements lw8.g, btc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lsc.d f492281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hw8.b f492282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f492283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f492284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f492285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f492286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f492287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f492288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ValueAnimator f492289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ValueAnimator f492290k;

    @Override // lw8.g
    public final String a() {
        return this.f492284e;
    }

    @Override // lw8.g
    public final String getTitle() {
        return this.f492283d;
    }

    @Override // btc.a
    public final void b(final TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f492289j.end();
        this.f492290k.cancel();
        this.f492290k.removeAllUpdateListeners();
        this.f492290k.addUpdateListener(new i(this, r100));
        this.f492290k.start();
    }

    @Override // btc.a
    public final void c(final TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f492289j.end();
        this.f492290k.cancel();
        this.f492290k.removeAllUpdateListeners();
        this.f492290k.addUpdateListener(new h(this, r100));
        this.f492290k.start();
    }

    @Override // btc.a
    public final void d(final TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f492289j.cancel();
        this.f492289j.removeAllUpdateListeners();
        this.f492289j.addUpdateListener(new g(this, r100));
        this.f492289j.start();
    }

    public CustomCitationSpan(msc.s r100, String r101, String r102, lsc.d r103, hw8.b r104) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "mTitle");
        Intrinsics.checkNotNullParameter(r102, "mLink");
        Intrinsics.checkNotNullParameter(r103, "linkResolver");
        this.f492280a = r100;
        this.f492281b = r103;
        this.f492282c = r104;
        this.f492283d = r101;
        this.f492284e = r102;
        this.f492285f = p.f492359c;
        this.f492286g = MarkdownDimensExtKt.f(R.dimen.dp_26);
        this.f492287h = MarkdownDimensExtKt.f(R.dimen.dp_10);
        MarkdownDimensExtKt.f(R.dimen.dp_8);
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r105.setDuration(60);
        r105.setInterpolator(new CubicBezierInterpolator());
        this.f492289j = r105;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r106.setDuration(60);
        r106.setInterpolator(new CubicBezierInterpolator());
        this.f492290k = r106;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        hw8.b r105 = this.f492282c;
        if (r105 == null) goto L6;
        return r105.b(r100, new hw8.a(this.f492283d, this.f492284e));
    L6:
        return this.f492286g;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(final Canvas r110, CharSequence r111, int r112, int r113, final float r114, int r115, final int r210, int r211, Paint r212) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r212, GXTemplateKey.GAIAX_PT);
        this.f492285f.set(r212);
        Unit r100 = null;
        if ((r111 instanceof SpannableString) == false) goto L5;
        SpannableString r101 = (SpannableString) r111;
    L6:
        if (r101 == null) goto L12;
        o[] r102 = (o[]) r101.getSpans(r112, r113, o.class);
        if (r102 == null) goto L12;
        o r103 = (o) ArraysKt.firstOrNull(r102);
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r103.getAlpha());
    L13:
        if (r104 == null) goto L15;
        this.f492285f.setAlpha(r104.intValue());
    L15:
        Function0<Unit> r116 = new CustomCitationSpan$draw$defaultHandler$1(this, r110, r114, r210);
        hw8.b r105 = this.f492282c;
        if (r105 == null) goto L18;
        r105.a(r110, r114, r115, r210, r211, r212, this.f492285f, this.f492280a, new hw8.a(this.f492283d, this.f492284e), this.f492288i);
        r100 = Unit.INSTANCE;
    L18:
        if (r100 != null) goto L21;
        r116.invoke();
        return;
    L21:
        return;
    L12:
        r104 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }
}
