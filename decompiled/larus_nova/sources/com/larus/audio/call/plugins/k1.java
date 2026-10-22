package com.larus.audio.call.plugins;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k1 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {

    public static final class a extends com.larus.im.service.audio.a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1 f289492a;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            this.f289492a.getClass();
            return "RealtimeModelProactivePlugin";
        }

        public a(k1 r100) {
            this.f289492a = r100;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(com.larus.im.service.audio.z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof pf9.d0) == true) goto L5;
            return;
        L5:
            if (((pf9.d0) r100).f528897b == false) goto L9;
            com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
            this.f289492a.getClass();
            r101.i("RealtimeModelProactivePlugin", "model proactive speak");
            com.larus.audio.call.arch.b.a(this.f289492a.getContext()).e0().d(true, true, "model proactive");
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "RealtimeModelProactivePlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public k1(com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
