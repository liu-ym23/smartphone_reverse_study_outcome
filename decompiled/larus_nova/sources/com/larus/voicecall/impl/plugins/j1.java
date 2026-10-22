package com.larus.voicecall.impl.plugins;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j1 extends com.larus.audio.call.arch.a<r> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f378534f;

    public static final class a extends com.larus.im.service.audio.a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f378535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j1 f378536b;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f378535a;
        }

        public a(j1 r100) {
            this.f378536b = r100;
            this.f378535a = r100.f378534f;
        }

        @Override // com.larus.im.service.audio.a1
        public final void q(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r102 = r100.hashCode();
            if (r102 == (-1381107413)) goto L22;
            if (r102 == 1624133454) goto L16;
            if (r102 == 2027072059) goto L10;
            return;
        L10:
            if (r100.equals("OTHER_EVENT_REQUEST_RETRIED_TOAST") == false) goto L34;
            com.larus.voicecall.impl.q r103 = this.f378536b.getContext().h();
            if (r103 == null) goto L28;
            r103.onReconnected();
            return;
        L28:
            return;
        L34:
            return;
        L16:
            if (r100.equals("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST") == false) goto L35;
            com.larus.voicecall.impl.q r104 = this.f378536b.getContext().h();
            if (r104 == null) goto L30;
            r104.onReconnect();
            return;
        L30:
            return;
        L35:
            return;
        L22:
            if (r100.equals("OTHER_EVENT_TASK_FAILED_TOAST") == false) goto L36;
            com.larus.voicecall.impl.q r105 = this.f378536b.getContext().h();
            if (r105 == null) goto L32;
            r105.h();
            return;
        L32:
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f378534f;
    }

    public j1(r r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f378534f = "RealtimeCallUIEventPlugin";
    }
}
