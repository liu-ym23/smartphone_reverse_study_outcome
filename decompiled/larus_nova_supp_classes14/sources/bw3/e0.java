package bw3;

import android.os.Looper;
import com.bytedance.applet.audio.inner.InnerAudioPlaybackState;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 {
    public final String a;
    public final String b;
    public boolean c;
    public f0 d;
    public Double e;
    public final h0 f;

    public static final class a {
    }

    static {
    }

    public final h0 a() {
        this.c = true;
        f("destroy");
        this.e = null;
        h0 r0 = this.f;
        h0.c(r0, 0.0d, r0.h);
        this.f.d(InnerAudioPlaybackState.STOPPED);
        return h0.a(this.f);
    }

    public final h0 h() {
        e(this.d);
        return h0.a(this.f);
    }

    public static void g(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        com.larus.utils.y.b().post(new d0(r2));
    }

    public final boolean b(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        if (this.d == r2) goto L5;
    L7:
        return false;
    L5:
        if (this.c == true) goto L7;
        return true;
    }

    public final w c(float r4) {
        f0 r0 = this.d;
        if (r0 != null) goto L16;
        int r5 = w.c;
        String r6 = this.f.b;
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        x r8 = x.e;
    L15:
        return w.a.a(r8, this.f);
    L13:
        r8 = x.f;
        goto L15
    L7:
        if (StringsKt.isBlank(r6) == true) goto L10;
        r7 = false;
        goto L11
    L16:
        r0.f(r4);
        this.f.d(InnerAudioPlaybackState.PLAYING);
        h0 r9 = this.f;
        Intrinsics.checkNotNullParameter(r9, "state");
        if (r0.e == false) goto L19;
        FLogger.a.e("InnerAudioPlayer", "play rejected. audioId: " + r0.a + ", reason: released");
        x r10 = x.g;
    L20:
        if (r10 == null) goto L23;
        this.f.d(InnerAudioPlaybackState.ERROR);
        int r1 = w.c;
        return w.a.a(r10, this.f);
    L23:
        e(r0);
        FLogger.a.i("InnerAudioInstance", "play requested. appletId: " + this.b + ", audioId: " + this.a + ", " + this.f.b());
        int r11 = w.c;
        return w.a.b(this.f);
    L19:
        r0.g(r9);
        r0.i.i("inner_audio");
        r10 = null;
        goto L20
    }

    public final w d(f0.b r14) {
        Intrinsics.checkNotNullParameter(r14, "listener");
        if (this.c == false) goto L6;
        int r15 = w.c;
        return w.a.a(x.d, this.f);
    L6:
        String r0 = this.f.b;
        Double r1 = null;
        if (r0 == null) goto L9;
        String r2 = StringsKt.trim(r0).toString();
    L10:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        boolean r3 = true;
        if (StringsKt.isBlank(r2) == false) goto L16;
    L51:
        g0 r10 = null;
    L54:
        if (r10 != null) goto L66;
        int r16 = w.c;
        String r17 = this.f.b;
        if (r17 != null) goto L58;
    L61:
        if (r3 == false) goto L63;
        x r18 = x.e;
    L65:
        return w.a.a(r18, this.f);
    L63:
        r18 = x.f;
        goto L65
    L58:
        if (StringsKt.isBlank(r17) == true) goto L61;
        r3 = false;
        goto L61
    L66:
        f0 r4 = this.d;
        if (r4 != null) goto L69;
    L70:
        f("new_source");
        Double r5 = Double.valueOf(this.f.f);
        if (r5.doubleValue() > 0.0d) goto L74;
        r3 = false;
    L74:
        if (r3 == false) goto L76;
        r1 = r5;
    L76:
        this.e = r1;
        this.d = new f0(this.a, this.b, r10, this.f, r14);
    L77:
        FLogger.a.i("InnerAudioInstance", "prepare play success. appletId: " + this.b + ", audioId: " + this.a + ", " + this.f.b());
        int r19 = w.c;
        return w.a.b(this.f);
    L69:
        if (Intrinsics.areEqual(r4.c.b, r10.b) == true) goto L77;
    L16:
        if (StringsKt.startsWith$default(r2, "http://", false, 2, null) == false) goto L18;
    L52:
        g0 r6 = new g0(r2, r2, SOURCE_TYPE.URL.getValue());
    L53:
        r10 = r6;
        goto L54
    L18:
        if (StringsKt.startsWith$default(r2, "https://", false, 2, null) == true) goto L52;
        if (StringsKt.startsWith$default(r2, "appletfile://", false, 2, null) == true) goto L79;
        r6 = null;
    L48:
        if (r6 != null) goto L53;
        FLogger.a.e("InnerAudioInstance", "resolve source failed. appletId: " + this.b + ", audioId: " + this.a + ", src: " + r2);
        goto L51
    L79:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L39
        bw3.a r8 = bw3.a.a;     // Catch: Throwable -> L39
        String r9 = this.b;     // Catch: Throwable -> L39
        r8.getClass();     // Catch: Throwable -> L39
        File r11 = bw3.a.a(r9, r2);     // Catch: Throwable -> L39
        if (r11 != null) goto L26;
    L36:
        g0 r12 = null;
    L37:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L39
    L41:
        Throwable r20 = Result.exceptionOrNull-impl(r13);
        if (r20 == null) goto L45;
        FLogger.a.e("InnerAudioInstance", "resolve applet file failed. appletId: " + this.b + ", audioId: " + this.a + ", error: " + r20.getMessage());
    L45:
        if (Result.isFailure-impl(r13) == false) goto L47;
        r13 = null;
    L47:
        r6 = (g0) r13;
        goto L48
    L26:
        if (r11.exists() == true) goto L28;
    L30:
        boolean r21 = false;
    L31:
        if (r21 == true) goto L34;
        r11 = null;
    L34:
        if (r11 == null) goto L36;
        r12 = new g0(r2, r11.getAbsolutePath(), SOURCE_TYPE.LOCAL_FILE.getValue());     // Catch: Throwable -> L39
        goto L37
    L28:
        if (r11.isFile() == false) goto L30;
        r21 = true;
    L39:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L9:
        r2 = null;
        goto L10
    }

    public final void e(f0 r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        h0 r0 = this.f;
        int r1 = f0.j;
        h0.c(r0, ((double) RangesKt.coerceAtLeast(r8.i.f(), 0)) / 1000.0d, ((double) RangesKt.coerceAtLeast(r8.i.getAudioDuration(), 0)) / 1000.0d);
        this.f.l = f0.a.a(r8.i.e());
    }

    public final void f(String r4) {
        f0 r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        this.d = null;
        if (r0.e == true) goto L9;
        r0.e = true;
        r0.i.release();
    L9:
        FLogger.a.i("InnerAudioInstance", "player released. appletId: " + this.b + ", audioId: " + this.a + ", reason: " + r4);
    }

    public e0(String r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "audioId");
        Intrinsics.checkNotNullParameter(r24, "appletId");
        this.a = r23;
        this.b = r24;
        this.f = new h0(r23, null, false, false, true, 0.0d, 0.0d, 0.0d, true, 0.0d, 1.0d, 1.0d, InnerAudioPlaybackState.STOPPED);
    }
}
