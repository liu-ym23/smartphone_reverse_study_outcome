package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements f {
    public w a;
    public final m b;
    public final g c;
    public final r d;
    public final com.bytedance.android.shopping.commentv3.audio.a e;
    public final h f;

    public static final class a {
        public boolean a;
        public final Function1<d, Unit> b;

        public final void b() {
            d r0 = new d(true, null, null);
            if (this.a == true) goto L10;
            this.a = true;
            Function1<d, Unit> r1 = this.b;
            if (r1 == null) goto L9;
            Unit r2 = (Unit) r1.invoke(r0);
            return;
        L9:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super d, Unit> r1) {
            this.b = r1;
        }

        public final void a(int r3, String r4) {
            d r0 = new d(false, Integer.valueOf(r3), r4);
            if (this.a == true) goto L10;
            this.a = true;
            Function1<d, Unit> r5 = this.b;
            if (r5 == null) goto L9;
            Unit r6 = (Unit) r5.invoke(r0);
            return;
        L9:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.f
    public final void c(StopReason r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        f.a.a(this, null, r8, new y(false, 6), null, 8);
        h r9 = this.f;
        if (r9 == null) goto L6;
        r9.release();
        return;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.f
    public final void a(com.bytedance.android.shopping.commentv3.audio.b r13, Function1<? super d, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "params");
        a r1 = new a(r14);
        if (r13.a != AudioControlAction.PLAY) goto L18;
        String r15 = r13.b;
        if (r15 == null) goto L18;
        if (r15.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r15 = null;
    L14:
        if (r15 == null) goto L18;
        e r3 = r13.c;
        if (r3 == null) goto L18;
        v r4 = new v(r15, r3, r13.d);
    L20:
        if (r4 != null) goto L25;
        r1.a(-1001, "AudioControl play params is invalid");
        IAction r16 = r13.d;
        if (r16 == null) goto L90;
        this.e.a(r16);
        return;
    L90:
        return;
    L25:
        u r17 = this.c.b(r4, this.a);
        if (r17.a == true) goto L32;
        dm.a.a("CommentAudioPlayer").i("play rejected, sliceId: " + r4.a);
        r1.a(-1002, "AudioControl play rejected");
        IAction r18 = r13.d;
        if (r18 == null) goto L91;
        this.e.a(r18);
        return;
    L91:
        return;
    L32:
        if (r17.b == false) goto L86;
        w r19 = this.a;
        if (r19 == null) goto L36;
        String r7 = r19.a;
    L37:
        f.a.a(this, r7, r17.c, r17.d, null, 8);
        goto L86
    L36:
        r7 = null;
    L86:
        t r110 = r17.e;     // Catch: Throwable -> L53
        if (r110 == null) goto L42;
        z.b r111 = this.d.a(r110);     // Catch: Throwable -> L53
    L82:
        TTVideoEngineAudioPlayer r112 = this.b.a(r4.b);     // Catch: Throwable -> L51
        w r5 = new w(r4.a, r4.b, r4.c, r112, r111);     // Catch: Throwable -> L49
        this.a = r5;     // Catch: Throwable -> L47
        r112.b = new o(this, r5.a, r1);     // Catch: Throwable -> L47
        r112.d(r5.b);     // Catch: Throwable -> L47
        r112.c();     // Catch: Throwable -> L47
        dm.a.a("CommentAudioPlayer").i("play start, sliceId: " + r5.a);     // Catch: Throwable -> L47
        return;
    L47:
        Throwable th = th;
    L56:
        dm.a.a("CommentAudioPlayer").b("play failed, sliceId: " + r4.a, th);
        r1.a(-1003, th.getMessage());
        if (r5 == null) goto L59;
        f.a.a(this, r4.a, StopReason.PLAY_ERROR, null, null, 12);
        return;
    L59:
        if (r112 == null) goto L61;
        r112.b = null;
    L61:
        if (r112 != null) goto L84;
    L65:
        if (r112 != null) goto L88;
    L69:
        if (r111 != null) goto L80;
    L71:
        IAction r113 = r4.c;
        if (r113 == null) goto L93;
        this.e.a(r113);
        return;
    L93:
        return;
    L80:
        r111.a(StopReason.PLAY_ERROR);     // Catch: Throwable -> L75
        goto L71
    L88:
        r112.release();     // Catch: Throwable -> L68
        goto L69
    L84:
        r112.stop();     // Catch: Throwable -> L64
    L49:
        th = th;
        r5 = null;
    L51:
        th = move-exception;
        th = th;
    L55:
        r112 = null;
        r5 = null;
        goto L56
    L42:
        r111 = null;
    L53:
        th = move-exception;
        th = th;
        r111 = null;
        goto L55
    L10:
        r2 = false;
    L18:
        r4 = null;
        goto L20
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.f
    public final void b(String r6, StopReason r7, y r8, Function1<? super d, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        Intrinsics.checkNotNullParameter(r8, "options");
        a r0 = new a(r9);
        w r10 = this.a;
        if (r10 != null) goto L6;
        r0.b();
        return;
    L6:
        if (r6 != null) goto L8;
    L11:
        Throwable th = null;
        this.a = null;
        x r1 = this.c.a(r10, r7);
        r10.d.a(null);
    L17:
        th = th;
    L45:
    L26:
        th = move-exception;
        if (th != null) goto L30;
        th = th;
    L30:
        if (th != null) goto L32;
        dm.a.a("CommentAudioPlayer").i("stop, sliceId: " + r10.a + ", reason: " + r7);
        r0.b();
    L33:
        h r11 = this.f;
        if (r11 == null) goto L37;
        r11.f(r7);
    L37:
        if (r8.a == false) goto L47;
        IAction r12 = r10.c;
        if (r12 == null) goto L48;
        this.e.a(r12);
        return;
    L48:
        return;
    L47:
        return;
    L32:
        dm.a.a("CommentAudioPlayer").b("stop failed, sliceId: " + r10.a + ", reason: " + r7, th);
        r0.a(-1004, th.getMessage());
        goto L33
    L19:
        if (r8.c == false) goto L30;
        if (r1.a == false) goto L30;
        s r2 = r10.e;     // Catch: Throwable -> L26
        if (r2 == null) goto L30;
        r2.a(r7);     // Catch: Throwable -> L26
        goto L30
    L13:
        if (r8.b == false) goto L15;
        r10.d.stop();     // Catch: Throwable -> L17
        r10.d.release();     // Catch: Throwable -> L17
    L42:
        goto L45
    L15:
        r10.d.stop();     // Catch: Throwable -> L17
        goto L42
    L8:
        if ((!Intrinsics.areEqual(r10.a, r6)) == false) goto L11;
        r0.b();
    }

    public n(b0 r2, q r3, z r4, p r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "playerFactory");
        Intrinsics.checkNotNullParameter(r3, "playbackPolicy");
        Intrinsics.checkNotNullParameter(r4, "externalAudioCoordinator");
        Intrinsics.checkNotNullParameter(r5, "actionExecutor");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
