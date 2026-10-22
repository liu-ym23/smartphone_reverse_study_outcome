package m69;

import com.larus.audio.call.plugins.t0;
import com.larus.im.service.audio.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes27.dex */
public final class d extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f512305f;

    public static final class a extends z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f512306a;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            this.f512306a.getClass();
            return "DoraLLMPlugin";
        }

        public a(d r100) {
            this.f512306a = r100;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            c.f512303a.e(r100);
        }
    }

    public static final class b extends com.larus.audio.call.play.e {
        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void a() {
            c.f512303a.a();
        }

        public b() {
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void b(Map<String, String> r100) {
            c.f512303a.b(r100);
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void i(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "audio");
            c.f512303a.c(r100);
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "DoraLLMPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        b r100 = new b();
        t0 r101 = (t0) getContext().c(Reflection.getOrCreateKotlinClass(t0.class), null);
        if (r101 == null) goto L7;
        u68.c r102 = r101.e0();
        if (r102 == null) goto L7;
        r102.i(r100);
    L7:
        this.f512305f = r100;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        c.f512303a.d(getContext().params().f288754n.f288838a);
        b r100 = this.f512305f;
        if (r100 == null) goto L10;
        t0 r101 = (t0) getContext().c(Reflection.getOrCreateKotlinClass(t0.class), null);
        if (r101 == null) goto L11;
        u68.c r102 = r101.e0();
        if (r102 == null) goto L12;
        r102.j(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public d(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
