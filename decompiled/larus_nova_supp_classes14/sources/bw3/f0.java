package bw3;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.audioplayer.api.news.UrlAudioPlayerDelegate;
import com.larus.platform.api.k4;
import com.larus.platform.api.l0;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 implements b88.a, b88.c {
    public static final /* synthetic */ int j = 0;
    public final String a;
    public final String b;
    public final g0 c;
    public final b d;
    public boolean e;
    public double f;
    public double g;
    public float h;
    public final b88.b i;

    public static final class a {
        public static double a(double r9) {
            if (Double.isInfinite(r9) == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == true) goto L10;
        L12:
            return 1.0d;
        L10:
            if (r9 <= 0.0d) goto L12;
            return RangesKt.coerceIn(r9, 0.5d, 2.0d);
        L5:
            if (Double.isNaN(r9) == true) goto L7;
            r0 = true;
            goto L8
        }

        public static double b(double r7) {
            if (Double.isInfinite(r7) == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == true) goto L12;
            return 1.0d;
        L12:
            return RangesKt.coerceIn(r7, 0.0d, 1.0d);
        L5:
            if (Double.isNaN(r7) == true) goto L7;
            r0 = true;
            goto L8
        }
    }

    public interface b {
        void a(f0 r1);

        void b(f0 r1);

        void c(f0 r1);

        void d(f0 r1);

        void e(f0 r1);

        void f(f0 r1);

        void g(f0 r1, x r2);

        void h(f0 r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[UrlAudioPlayStatus.values().length];
            r0[UrlAudioPlayStatus.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[UrlAudioPlayStatus.PLAYING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L51:
            r0[UrlAudioPlayStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[UrlAudioPlayStatus.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[UrlAudioPlayStatus.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            r0[UrlAudioPlayStatus.FINISH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L43:
            r0[UrlAudioPlayStatus.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L13:
            a = r0;
            int[] r1 = new int[UrlAudioLoadState.values().length];
            r1[UrlAudioLoadState.PLAYABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L35:
            r1[UrlAudioLoadState.STALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L45:
            r1[UrlAudioLoadState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L33:
            r1[UrlAudioLoadState.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L18:
            b = r1;
        }
    }

    public static final class d implements l0 {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void onCompletion(boolean r2) {
            this.a.invoke(Boolean.valueOf(r2));
        }
    }

    static {
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
    }

    public final void f(float r6) {
        if (Float.isInfinite(r6) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L11;
        float r7 = RangesKt.coerceIn(r6, 0.0f, 1.0f);
    L12:
        this.h = r7;
        this.i.c(RangesKt.coerceIn(((float) this.g) * r7, 0.0f, 1.0f));
        FLogger.a.i("InnerAudioPlayer", "category volume factor updated. audioId: " + this.a + ", volumeFactor: " + this.h);
        return;
    L11:
        r7 = 1.0f;
        goto L12
    L5:
        if (Float.isNaN(r6) == true) goto L7;
        r0 = true;
        goto L9
    }

    public final void g(h0 r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        double r0 = a.a(r9.l);
        boolean r4 = false;
        if (r0 != this.f) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        this.f = r0;
        this.i.d((float) r0);
        FLogger.a.i("InnerAudioPlayer", "playback rate updated. audioId: " + this.a + ", rate: " + this.f);
    L9:
        double r1 = a.b(r9.k);
        if (r1 != this.g) goto L12;
        r4 = true;
    L12:
        if (r4 == true) goto L14;
        this.g = r1;
        this.i.c(RangesKt.coerceIn(((float) r1) * this.h, 0.0f, 1.0f));
        FLogger.a.i("InnerAudioPlayer", "volume updated. audioId: " + this.a + ", volume: " + this.g);
    L14:
        this.i.setLooping(r9.d);
        return;
    L5:
        r2 = false;
        goto L7
    }

    public final void a(String r3, UrlAudioLoadState r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "state");
        if (Intrinsics.areEqual(r3, this.c.b) == true) goto L5;
        return;
    L5:
        FLogger.a.i("InnerAudioPlayer", "load state changed. audioId: " + this.a + ", state: " + r4);
        int r5 = c.b[r4.ordinal()];
        if (r5 != 1) goto L8;
        this.d.e(this);
        return;
    L8:
        if (r5 != 2) goto L10;
        this.d.b(this);
        return;
    L10:
        if (r5 != 3) goto L12;
        this.d.g(this, new x(-2007, "inner audio play failed"));
        return;
    L12:
        if (r5 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void c(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        if (Intrinsics.areEqual(r3, this.c.b) == false) goto L6;
        FLogger.a.i("InnerAudioPlayer", "audio status changed. audioId: " + this.a + ", status: " + r4);
        return;
    }

    public final boolean e(double r7, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        boolean r1 = false;
        if (this.e == false) goto L5;
        return false;
    L5:
        b88.b r0 = this.i;
        if (Double.isInfinite(r7) == false) goto L8;
    L10:
        double r4 = 0.0d;
        if (r1 == false) goto L13;
        r4 = RangesKt.coerceAtLeast(r7, 0.0d);
    L13:
        r0.j(MathKt.roundToInt(RangesKt.coerceAtMost(r4, 2147483.647d) * ((double) ECDraweeView.SQUARE)), new d(r9));
        return true;
    L8:
        if (Double.isNaN(r7) == true) goto L10;
        r1 = true;
        goto L10
    }

    public final void d(String r1, String r2, int r3, UrlAudioPlayStatus r4) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r4, "status");
        if (Intrinsics.areEqual(r1, this.c.b) == true) goto L5;
        return;
    L5:
        FLogger.a.i("InnerAudioPlayer", "player status changed. audioId: " + this.a + ", status: " + r4.getValue());
        switch(c.a[r4.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L16;
            default: goto L8;
        };
    L9:
        this.d.d(this);
        return;
    L10:
        this.d.g(this, new x(-2007, "inner audio play failed"));
        return;
    L11:
        this.d.f(this);
        return;
    L12:
        this.d.h(this);
        return;
    L13:
        this.d.a(this);
        return;
    L14:
        this.d.c(this);
        return;
    L16:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public f0(String r20, String r21, g0 r22, h0 r23, b r24) {
        Intrinsics.checkNotNullParameter(r20, "audioId");
        Intrinsics.checkNotNullParameter(r21, "appletId");
        Intrinsics.checkNotNullParameter(r22, "resolvedSource");
        Intrinsics.checkNotNullParameter(r23, "initialState");
        Intrinsics.checkNotNullParameter(r24, "listener");
        this.a = r20;
        this.b = r21;
        this.c = r22;
        this.d = r24;
        this.f = a.a(r23.l);
        this.g = a.b(r23.k);
        this.h = 1.0f;
        JSONObject r14 = new JSONObject();
        r14.put("scene", "plugin_inner_audio");
        r14.put("audio_id", r20);
        b88.b r1 = UrlAudioPlayerDelegate.b.a(new b88.f(r22.b, r22.c, new k4("plugin_inner_audio", "", "", r20, "", ""), r14, "plugin_inner_audio", "plugin_inner_audio", null, 512), this, this);
        r1.setLooping(r23.d);
        r1.d((float) this.f);
        r1.c(RangesKt.coerceIn(((float) this.g) * this.h, 0.0f, 1.0f));
        this.i = r1;
    }
}
