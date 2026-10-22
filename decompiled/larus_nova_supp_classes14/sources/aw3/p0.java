package aw3;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.api.news.UrlAudioLoadState;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.audioplayer.api.news.UrlAudioPlayerDelegate;
import com.larus.platform.api.k4;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p0 implements b88.a, b88.c {
    public static final /* synthetic */ int g = 0;
    public final b a;
    public final String b;
    public boolean c;
    public double d;
    public m0 e;
    public final b88.b f;

    public static final class a {
        public static double a(double r3) {
            if (Double.isInfinite(r3) == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == true) goto L10;
        L12:
            return 1.0d;
        L10:
            if (r3 <= 0.0d) goto L12;
            return r3;
        L5:
            if (Double.isNaN(r3) == true) goto L7;
            r0 = true;
            goto L8
        }
    }

    public interface b {
        void a(p0 r1);

        void b(p0 r1);

        void c(p0 r1);

        void d(p0 r1);

        void e(p0 r1, String r2);

        void f(p0 r1, m0 r2);

        void g(p0 r1);

        void h(p0 r1);

        void i(p0 r1);
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

    public static final class d implements com.larus.platform.api.l0 {
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

    public final void f(q0 r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        double r0 = a.a(r6.l);
        if (r0 != this.d) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        this.d = r0;
        this.f.d((float) r0);
        FLogger.a.i("BackgroundAudioPlayer", "playback rate updated. rate: " + this.d + ", hasUrl: " + (true ^ StringsKt.isBlank(this.b)));
        return;
    L9:
        return;
    L5:
        r2 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [aw3.o0] */
    public p0(q0 r14, b r15) {
        Intrinsics.checkNotNullParameter(r14, "initialState");
        Intrinsics.checkNotNullParameter(r15, "listener");
        this.a = r15;
        String r16 = r14.a;
        if (r16 != null) goto L5;
        r16 = "";
    L5:
        this.b = r16;
        this.d = a.a(r14.l);
        JSONObject r8 = new JSONObject();
        r8.put("scene", "plugin_background_audio");
        UrlAudioPlayerDelegate r10 = UrlAudioPlayerDelegate.b;
        int r9 = SOURCE_TYPE.URL.getValue();
        String r1 = r14.b;
        if (r1 != null) goto L8;
        String r3 = "";
    L9:
        String r17 = r14.d;
        if (r17 != null) goto L12;
        String r4 = "";
    L13:
        String r2 = r16;
        b88.b r18 = r10.a(new b88.f(r2, r9, new k4("plugin_background_audio", r3, r4, r16, "", ""), r8, "plugin_background_audio", "plugin_background_audio", new o0(this), 256), this, this);
        r18.d((float) this.d);
        this.f = r18;
        return;
    L12:
        r4 = r17;
        goto L13
    L8:
        r3 = r1;
        goto L9
    }

    public final void a(String r4, UrlAudioLoadState r5) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (Intrinsics.areEqual(r4, this.b) == true) goto L5;
        return;
    L5:
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("load state changed. state: ");
        r0.append(r5);
        r0.append(", hasUrl: ");
        r0.append(!StringsKt.isBlank(this.b));
        r6.i("BackgroundAudioPlayer", r0.toString());
        int r7 = c.b[r5.ordinal()];
        if (r7 != 1) goto L8;
        this.a.b(this);
        return;
    L8:
        if (r7 != 2) goto L10;
        this.a.c(this);
        return;
    L10:
        if (r7 != 3) goto L12;
        b r8 = this.a;
        m0 r9 = m0.c;
        r8.f(this, m0.d);
        return;
    L12:
        if (r7 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void c(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        if (Intrinsics.areEqual(r3, this.b) == true) goto L5;
        return;
    L5:
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("audio status changed. status: ");
        r0.append(r4);
        r0.append(", hasUrl: ");
        r0.append(!StringsKt.isBlank(this.b));
        r5.i("BackgroundAudioPlayer", r0.toString());
    }

    public final boolean e(double r7, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        boolean r1 = false;
        if (this.c == false) goto L5;
        return false;
    L5:
        b88.b r0 = this.f;
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
        if (Intrinsics.areEqual(r1, this.b) == true) goto L5;
        return;
    L5:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("player status changed. status: ");
        r6.append(r4.getValue());
        r6.append(", hasUrl: ");
        r6.append(!StringsKt.isBlank(this.b));
        r5.i("BackgroundAudioPlayer", r6.toString());
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
        this.a.i(this);
        return;
    L10:
        b r7 = this.a;
        m0 r8 = m0.c;
        r7.f(this, m0.d);
        return;
    L11:
        this.a.g(this);
        return;
    L12:
        this.a.a(this);
        return;
    L13:
        this.a.d(this);
        return;
    L14:
        this.a.h(this);
        return;
    L16:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
