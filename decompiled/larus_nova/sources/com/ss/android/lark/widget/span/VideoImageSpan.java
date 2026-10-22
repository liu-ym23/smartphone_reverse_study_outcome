package com.ss.android.lark.widget.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.resource.service.impl.ImageService;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoImageSpan extends com.ss.android.lark.widget.span.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f448622r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f448623s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function1<com.ss.android.lark.widget.span.b, Unit> f448624t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f448625u;

    public static final class a {
    }

    public static final class b extends BitmapDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoImageSpan f448626a;

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawRect(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f448626a.f448625u);
            super.draw(r100);
        }

        public b(VideoImageSpan r100, Resources r101, Bitmap r102) {
            this.f448626a = r100;
            super(r101, r102);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.widget.span.b
    public final k b(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        if (FeatureGatingModule.getFeatureGatingService().isEnable(ImageService.FEATURE_CHAT_DRAFT_RESET_SYNC) == false) goto L5;
        b r101 = new b(this, this.f448622r.getResources(), c(r100));
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        e r102 = new e(r101);
        if (r102.f448663b == true) goto L9;
        r102.invalidateSelf();
    L10:
        i r103 = new i(r102, new VideoImageSpan$onPrepareImageResource$1(this));
        r103.a(this.f448634m);
        r103.b(this.f448635n);
        return r103;
    L9:
        r102.f448663b = false;
        r102.f448669h.removeCallbacks(r102.f448670i);
        r102.f448668g = false;
        r102.invalidateSelf();
        goto L10
    L5:
        return super.b(c(r100));
    }

    public final Bitmap c(Bitmap r110) {
        Resources r100 = this.f448622r.getResources();
        int[] r101 = ImageUtils.g(r110.getWidth(), r110.getHeight(), (int) (((double) WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels) * 0.4d), (int) (((double) WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels) * 0.4d), 80, 80);
        int r102 = this.f448637p;
        if (r102 >= 1) goto L5;
    L7:
        int r103 = r101[0];
        int r104 = r110.getWidth();
        int r105 = r110.getHeight();
        float r106 = r103 / r104;
        Matrix r107 = new Matrix();
        r107.postScale(r106, r106);
        return scc.a.b(Bitmap.createBitmap(r110, 0, 0, r104, r105, r107, true), this.f448623s, 1);
    L5:
        if (r102 >= r101[1]) goto L7;
        r101[0] = r102;
        r101[1] = r102;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoImageSpan(Context r100, String r101, com.ss.android.lark.widget.span.b.AbstractC5432b<?> r102, Function1<? super com.ss.android.lark.widget.span.b, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "durationLabel");
        Intrinsics.checkNotNullParameter(r102, "loadInfo");
        Intrinsics.checkNotNullParameter(r103, "imageLoadHandle");
        super(r100, r102, r103);
        this.f448622r = r100;
        this.f448623s = r101;
        this.f448624t = r103;
        Paint r104 = new Paint();
        r104.setColor(UIHelper.getColor(R.color.static_white));
        r104.setStyle(Paint.Style.FILL);
        this.f448625u = r104;
    }
}
