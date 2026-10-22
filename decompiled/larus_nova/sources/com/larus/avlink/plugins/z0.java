package com.larus.avlink.plugins;

import com.larus.platform.model.LocateScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class z0 extends com.larus.audio.call.arch.a<n4> {

    public static final class a extends com.larus.im.service.audio.z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0 f294121a;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            this.f294121a.getClass();
            return "DoraLocationPlugin";
        }

        public a(z0 r100) {
            this.f294121a = r100;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(com.larus.im.service.audio.z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof pf9.z) == false) goto L6;
            com.larus.platform.service.l1.f365760a.a(LocateScene.DORA_G_ASR, null);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "DoraLocationPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public z0(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
