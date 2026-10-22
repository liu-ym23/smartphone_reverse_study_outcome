package wbc;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.camera.video.AudioStats;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.dto.WatermarkDensity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f559038a;

    /* JADX INFO: renamed from: wbc.a$a, reason: collision with other inner class name */
    public static final class C8089a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f559039a;

        public final Context getContext() {
            return this.f559039a;
        }

        public b(Context r100) {
            this.f559039a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f559040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f559041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f559042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f559043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f559044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final double f559045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final double f559046h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f559047i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f559048j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List<vbc.a> f559049k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final List<vbc.a> f559050l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f559051m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final List<String> f559052n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final float f559053o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f559054p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final vbc.a f559055q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Path f559056r;

        public c(Context r210, String r211, int r212, float r213, float r214, float r310, int r311) {
            int r100 = r311;
            Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r211, "text");
            super(r210);
            Paint r101 = new Paint();
            r101.setColor(r210.getResources().getColor(R.color.ud_N500));
            r101.setAlpha((int) (255 * r213));
            r101.setAntiAlias(true);
            r101.setTextAlign(Paint.Align.LEFT);
            r101.setTextSize(UIUtils.dp2px(r210, r212));
            w08.a.a(r101, r210, 0);
            this.f559040b = r101;
            this.f559041c = Math.min(r101.measureText(r211), UIUtils.dp2px(r210, 240.0f));
            if (r100 >= (-75)) goto L5;
        L6:
            r100 = -15;
        L7:
            this.f559044f = r100;
            double r110 = Math.toRadians(r100);
            this.f559045g = Math.sin(r110);
            this.f559046h = Math.cos(r110);
            this.f559049k = new ArrayList();
            this.f559050l = new ArrayList();
            Rect r102 = new Rect();
            r101.getTextBounds(r211, 0, r211.length(), r102);
            this.f559051m = r102.height();
            wbc.b r103 = wbc.b.f559057a;
            float r104 = UIUtils.dp2px(r210, 240.0f);
            monitor-enter(r103);
            Intrinsics.checkNotNullParameter(r211, "longText");     // Catch: Throwable -> L68
            Intrinsics.checkNotNullParameter(r101, "textPaint");     // Catch: Throwable -> L68
            ArrayList r111 = new ArrayList();     // Catch: Throwable -> L68
            wbc.b.f559058b = r211;     // Catch: Throwable -> L68
            wbc.b.f559059c = r104;     // Catch: Throwable -> L68
            wbc.b.f559064h = r101;     // Catch: Throwable -> L68
            wbc.b.f559063g = (int) (r104 / r101.measureText("AA"));     // Catch: Throwable -> L68
        L10:
            String r105 = wbc.b.f559058b;     // Catch: Throwable -> L68
            String r106 = null;
            if (r105 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("textRemain");     // Catch: Throwable -> L68
            r105 = null;
        L14:
            if (r105.length() <= 0) goto L16;
            boolean r107 = true;
        L17:
            if (r107 == false) goto L46;
            String r108 = wbc.b.f559058b;     // Catch: Throwable -> L68
            if (r108 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("textRemain");     // Catch: Throwable -> L68
            r108 = null;
        L21:
            String r109 = StringsKt.trim(r108).toString();     // Catch: Throwable -> L68
            wbc.b.f559058b = r109;     // Catch: Throwable -> L68
            if (r109 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("textRemain");     // Catch: Throwable -> L68
            r109 = null;
        L25:
            if (r109.length() != 0) goto L27;
            boolean r112 = true;
        L28:
            if (r112 == true) goto L29;
            Paint r113 = wbc.b.f559064h;     // Catch: Throwable -> L68
            if (r113 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("paint");     // Catch: Throwable -> L68
            r113 = null;
        L34:
            String r114 = wbc.b.f559058b;     // Catch: Throwable -> L68
            if (r114 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("textRemain");     // Catch: Throwable -> L68
            r114 = null;
        L38:
            if (r113.measureText(r114) <= wbc.b.f559059c) goto L39;
            wbc.b.a(r111);     // Catch: Throwable -> L68
            goto L10
        L39:
            String r115 = wbc.b.f559058b;     // Catch: Throwable -> L68
            if (r115 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("textRemain");     // Catch: Throwable -> L68
        L43:
            r111.add(r106);     // Catch: Throwable -> L68
            wbc.b.f559058b = "";     // Catch: Throwable -> L68
            goto L46
        L42:
            r106 = r115;
            goto L43
        L29:
            monitor-exit(r103);
        L47:
            this.f559052n = r111;
            double r116 = (((double) this.f559041c) * Math.abs(this.f559045g)) + (((double) (this.f559051m * (r111.size() - 1))) * Math.abs(this.f559046h));
            double r117 = (((double) this.f559041c) * Math.abs(this.f559046h)) + (((double) (this.f559051m * (r111.size() - 1))) * Math.abs(this.f559045g));
            double r118 = ((double) this.f559041c) * this.f559045g;
            double r119 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r118 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L50;
            boolean r120 = true;
        L52:
            if (r214 > 0.0f) goto L54;
            int r121 = UIUtils.dp2px(r210, WatermarkDensity.MID_DENSITY.getHorizontalInterval());
        L55:
            this.f559053o = r121 + ((float) r117);
            if (r310 > 0.0f) goto L58;
            int r122 = UIUtils.dp2px(r210, WatermarkDensity.MID_DENSITY.getVerticalInterval());
        L59:
            this.f559054p = r122 + ((float) r116);
            double r123 = this.f559051m;
            if (r120 == false) goto L62;
            r119 = ((double) this.f559041c) * Math.abs(this.f559045g);
        L62:
            double r215 = r123 + r119;
            int r124 = this.f559051m;
            if (r120 == true) goto L66;
            r124 = r124 * (r111.size() - 1);
        L66:
            double r125 = ((double) r124) * Math.abs(this.f559045g);
            this.f559055q = new vbc.a(r125, r215, r125 + ((double) this.f559041c), r215);
            this.f559056r = new Path();
            return;
        L58:
            r122 = UIUtils.dp2px(r210, r310);
            goto L59
        L54:
            r121 = UIUtils.dp2px(r210, r214);
            goto L55
        L50:
            r120 = false;
            goto L52
        L27:
            r112 = false;
        L46:
            monitor-exit(r103);
            goto L47
        L16:
            r107 = false;
        L68:
            th = move-exception;
            throw th;
        L5:
            if (r100 <= 75) goto L7;
            goto L6
        }
    }

    static {
    }

    public a(Context r110, String r111, int r112, float r113, float r114, float r115, int r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "text");
        this.f559038a = new c(r110, r111, r112, r113, r114, r115, r116);
    }
}
