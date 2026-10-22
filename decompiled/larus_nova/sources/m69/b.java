package m69;

import com.larus.im.service.audio.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import pf9.a0;
import pf9.c0;
import pf9.z;

/* JADX INFO: loaded from: classes27.dex */
public final class b extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f512301f;

    public static final class a extends z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f512302a;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            this.f512302a.getClass();
            return "DoraAsrPlugin";
        }

        public a(b r100) {
            this.f512302a = r100;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof z) == false) goto L6;
            this.f512302a.f512301f = "";
            m69.a.f512299a.a("");
            return;
        L6:
            if ((r100 instanceof c0) == false) goto L13;
            b r101 = this.f512302a;
            pf9.a r102 = ((c0) r100).f528895a;
            if (r102 == null) goto L10;
            String r103 = r102.f528874a;
        L11:
            r101.f512301f = r103;
            m69.a.f512299a.a(r103);
            return;
        L10:
            r103 = null;
            goto L11
        L13:
            if ((r100 instanceof a0) == false) goto L18;
            m69.a.f512299a.a(this.f512302a.f512301f);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "DoraAsrPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        this.f512301f = null;
    }

    public b(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
