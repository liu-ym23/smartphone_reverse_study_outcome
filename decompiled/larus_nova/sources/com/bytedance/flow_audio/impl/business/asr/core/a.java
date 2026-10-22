package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.mammon.audiosdk.session.type.RequestEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.flow_audio.impl.business.asr.core.a$a, reason: collision with other inner class name */
    public static final class C3490a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3490a f243828a = null;

        static {
            f243828a = new C3490a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3490a) == true) goto L9;
            return false;
        L9:
            C3490a r101 = (C3490a) r100;
            return true;
        }

        public final int hashCode() {
            return 611901560;
        }

        public final String toString() {
            return "BuildFinalResult";
        }

        public C3490a() {
        }
    }

    public static final class a0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f243829a = null;

        static {
            f243829a = new a0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a0) == true) goto L9;
            return false;
        L9:
            a0 r101 = (a0) r100;
            return true;
        }

        public final int hashCode() {
            return -620937736;
        }

        public final String toString() {
            return "EndAsr";
        }

        public a0() {
        }
    }

    public static final class a1 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final iw5.c f243830a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a1) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243830a, ((a1) r100).f243830a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243830a.hashCode();
        }

        public final String toString() {
            return "ValidateFinalResult(result=" + this.f243830a + ')';
        }

        public a1(iw5.c r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f243830a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f243831a = null;

        static {
            f243831a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1577099416;
        }

        public final String toString() {
            return "CancelCompletionTimeout";
        }

        public b() {
        }
    }

    public static final class b0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw5.d f243832a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243832a, ((b0) r100).f243832a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243832a.hashCode();
        }

        public final String toString() {
            return "EnqueueAudioFrame(frame=" + this.f243832a + ')';
        }

        public b0(rw5.d r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            this.f243832a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f243833a = null;

        static {
            f243833a = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -735728025;
        }

        public final String toString() {
            return "CancelTaskIgnoringError";
        }

        public c() {
        }
    }

    public static final class c0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243834a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243834a, ((c0) r100).f243834a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243834a.hashCode();
        }

        public final String toString() {
            return "FailTerminal(error=" + this.f243834a + ')';
        }

        public c0(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243834a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f243835a = null;

        static {
            f243835a = new d();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            d r101 = (d) r100;
            return true;
        }

        public final int hashCode() {
            return 1668963516;
        }

        public final String toString() {
            return "CleanupAfterTerminalSuccess";
        }

        public d() {
        }
    }

    public static final class d0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d0 f243836a = null;

        static {
            f243836a = new d0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d0) == true) goto L9;
            return false;
        L9:
            d0 r101 = (d0) r100;
            return true;
        }

        public final int hashCode() {
            return -1748593978;
        }

        public final String toString() {
            return "FlushUplink";
        }

        public d0() {
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f243837a = null;

        static {
            f243837a = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 1948040848;
        }

        public final String toString() {
            return "ClearFailure";
        }

        public e() {
        }
    }

    public static final class e0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bx5.a.b f243838a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243838a, ((e0) r100).f243838a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243838a.hashCode();
        }

        public final String toString() {
            return "HandleAsrResponse(event=" + this.f243838a + ')';
        }

        public e0(bx5.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243838a = r100;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f243839a = null;

        static {
            f243839a = new f();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            f r101 = (f) r100;
            return true;
        }

        public final int hashCode() {
            return 929945710;
        }

        public final String toString() {
            return "ClearListener";
        }

        public f() {
        }
    }

    public static final class f0 extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f0) == true) goto L8;
            return false;
        L8:
            ((f0) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "LogError(message=null)";
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f243840a = null;

        static {
            f243840a = new g();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            g r101 = (g) r100;
            return true;
        }

        public final int hashCode() {
            return 975823223;
        }

        public final String toString() {
            return "ClearRecording";
        }

        public g() {
        }
    }

    public static final class g0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f243841a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243841a, ((g0) r100).f243841a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243841a.hashCode();
        }

        public final String toString() {
            return "LogInfo(message=" + this.f243841a + ')';
        }

        public g0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f243841a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f243842a;

        public h() {
            this(true);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f243842a == ((h) r100).f243842a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f243842a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ClearTask(reuseTask=" + this.f243842a + ')';
        }

        public h(boolean r100) {
            this.f243842a = r100;
        }
    }

    public static final class h0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f243843a = null;

        static {
            f243843a = new h0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h0) == true) goto L9;
            return false;
        L9:
            h0 r101 = (h0) r100;
            return true;
        }

        public final int hashCode() {
            return -1158011575;
        }

        public final String toString() {
            return "MarkRecordingEnded";
        }

        public h0() {
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f243844a = null;

        static {
            f243844a = new i();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            i r101 = (i) r100;
            return true;
        }

        public final int hashCode() {
            return 1476047695;
        }

        public final String toString() {
            return "ClearUplink";
        }

        public i() {
        }
    }

    public static final class i0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i0 f243845a = null;

        static {
            f243845a = new i0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i0) == true) goto L9;
            return false;
        L9:
            i0 r101 = (i0) r100;
            return true;
        }

        public final int hashCode() {
            return -743034032;
        }

        public final String toString() {
            return "MarkRecordingStarted";
        }

        public i0() {
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f243846a = null;

        static {
            f243846a = new j();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            j r101 = (j) r100;
            return true;
        }

        public final int hashCode() {
            return -1030664493;
        }

        public final String toString() {
            return "CloseRuntime";
        }

        public j() {
        }
    }

    public static final class j0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowAsrSessionState f243847a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j0) == true) goto L9;
            return false;
        L9:
            if (this.f243847a == ((j0) r100).f243847a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243847a.hashCode();
        }

        public final String toString() {
            return "MoveState(state=" + this.f243847a + ')';
        }

        public j0(FlowAsrSessionState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f243847a = r100;
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f243848a = null;

        static {
            f243848a = new k();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            k r101 = (k) r100;
            return true;
        }

        public final int hashCode() {
            return -668719448;
        }

        public final String toString() {
            return "DispatchAsrEnd";
        }

        public k() {
        }
    }

    public static final class k0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k0 f243849a = null;

        static {
            f243849a = new k0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k0) == true) goto L9;
            return false;
        L9:
            k0 r101 = (k0) r100;
            return true;
        }

        public final int hashCode() {
            return -412294066;
        }

        public final String toString() {
            return "MoveToWaitingAsrCompletion";
        }

        public k0() {
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw5.d f243850a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243850a, ((l) r100).f243850a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243850a.hashCode();
        }

        public final String toString() {
            return "DispatchAudioData(data=" + this.f243850a + ')';
        }

        public l(rw5.d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f243850a = r100;
        }
    }

    public static final class l0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l0 f243851a = null;

        static {
            f243851a = new l0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l0) == true) goto L9;
            return false;
        L9:
            l0 r101 = (l0) r100;
            return true;
        }

        public final int hashCode() {
            return -1551212939;
        }

        public final String toString() {
            return "Noop";
        }

        public l0() {
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowAsrCancelReason f243852a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f243852a == ((m) r100).f243852a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243852a.hashCode();
        }

        public final String toString() {
            return "DispatchCancel(reason=" + this.f243852a + ')';
        }

        public m(FlowAsrCancelReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f243852a = r100;
        }
    }

    public static final class m0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.flow_audio.impl.business.asr.n f243854b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m0) == true) goto L8;
            return false;
        L8:
            m0 r101 = (m0) r100;
            if (Intrinsics.areEqual(this.f243853a, r101.f243853a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243854b, r101.f243854b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f243853a.hashCode() * 31) + this.f243854b.hashCode();
        }

        public final String toString() {
            return "RecordRetry(rootError=" + this.f243853a + ", decision=" + this.f243854b + ')';
        }

        public m0(hw5.a r100, com.bytedance.flow_audio.impl.business.asr.n r101) {
            Intrinsics.checkNotNullParameter(r100, "rootError");
            Intrinsics.checkNotNullParameter(r101, "decision");
            this.f243853a = r100;
            this.f243854b = r101;
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f243855a = null;

        static {
            f243855a = new n();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            n r101 = (n) r100;
            return true;
        }

        public final int hashCode() {
            return -138771083;
        }

        public final String toString() {
            return "DispatchDidPrepare";
        }

        public n() {
        }
    }

    public static final class n0 extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n0) == true) goto L8;
            return false;
        L8:
            ((n0) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "RecreateTask(config=null)";
        }
    }

    public static final class o extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f243856a = null;

        static {
            f243856a = new o();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            o r101 = (o) r100;
            return true;
        }

        public final int hashCode() {
            return 1866367056;
        }

        public final String toString() {
            return "DispatchDidStart";
        }

        public o() {
        }
    }

    public static final class o0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o0 f243857a = null;

        static {
            f243857a = new o0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o0) == true) goto L9;
            return false;
        L9:
            o0 r101 = (o0) r100;
            return true;
        }

        public final int hashCode() {
            return -1686716492;
        }

        public final String toString() {
            return "ReleaseRecordIgnoringError";
        }

        public o0() {
        }
    }

    public static final class p extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            ((p) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DispatchFail(error=null)";
        }
    }

    public static final class p0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0 f243858a = null;

        static {
            f243858a = new p0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p0) == true) goto L9;
            return false;
        L9:
            p0 r101 = (p0) r100;
            return true;
        }

        public final int hashCode() {
            return 1000985559;
        }

        public final String toString() {
            return "ResetDownlinkForRetry";
        }

        public p0() {
        }
    }

    public static final class q extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final iw5.c f243859a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243859a, ((q) r100).f243859a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243859a.hashCode();
        }

        public final String toString() {
            return "DispatchFinish(result=" + this.f243859a + ')';
        }

        public q(iw5.c r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f243859a = r100;
        }
    }

    public static final class q0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243860a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243860a, ((q0) r100).f243860a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243860a.hashCode();
        }

        public final String toString() {
            return "ResolveFailure(error=" + this.f243860a + ')';
        }

        public q0(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243860a = r100;
        }
    }

    public static final class r extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f243861a = null;

        static {
            f243861a = new r();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L9;
            return false;
        L9:
            r r101 = (r) r100;
            return true;
        }

        public final int hashCode() {
            return -33781778;
        }

        public final String toString() {
            return "DispatchRecordingDidFinish";
        }

        public r() {
        }
    }

    public static final class r0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r0 f243862a = null;

        static {
            f243862a = new r0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r0) == true) goto L9;
            return false;
        L9:
            r0 r101 = (r0) r100;
            return true;
        }

        public final int hashCode() {
            return -313106398;
        }

        public final String toString() {
            return "ResolvePendingFailureAfterSourceStopped";
        }

        public r0() {
        }
    }

    public static final class s extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f243863a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s) == true) goto L9;
            return false;
        L9:
            if (this.f243863a == ((s) r100).f243863a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f243863a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "DispatchRecordingDidPause(hasFocus=" + this.f243863a + ')';
        }

        public s(boolean r100) {
            this.f243863a = r100;
        }
    }

    public static final class s0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f243864a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243864a, ((s0) r100).f243864a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243864a.hashCode();
        }

        public final String toString() {
            return "RunFileReplay(filePath=" + this.f243864a + ')';
        }

        public s0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            this.f243864a = r100;
        }
    }

    public static final class t extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f243865a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.f243865a == ((t) r100).f243865a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f243865a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "DispatchRecordingDidResume(hasFocus=" + this.f243865a + ')';
        }

        public t(boolean r100) {
            this.f243865a = r100;
        }
    }

    public static final class t0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.flow_audio.impl.business.asr.n f243867b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t0) == true) goto L8;
            return false;
        L8:
            t0 r101 = (t0) r100;
            if (Intrinsics.areEqual(this.f243866a, r101.f243866a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243867b, r101.f243867b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f243866a.hashCode() * 31) + this.f243867b.hashCode();
        }

        public final String toString() {
            return "RunFileRetry(rootError=" + this.f243866a + ", decision=" + this.f243867b + ')';
        }

        public t0(hw5.a r100, com.bytedance.flow_audio.impl.business.asr.n r101) {
            Intrinsics.checkNotNullParameter(r100, "rootError");
            Intrinsics.checkNotNullParameter(r101, "decision");
            this.f243866a = r100;
            this.f243867b = r101;
        }
    }

    public static final class u extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f243868a = null;

        static {
            f243868a = new u();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L9;
            return false;
        L9:
            u r101 = (u) r100;
            return true;
        }

        public final int hashCode() {
            return 149778855;
        }

        public final String toString() {
            return "DispatchRecordingDidStart";
        }

        public u() {
        }
    }

    public static final class u0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bx5.a.C0371a f243869a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243869a, ((u0) r100).f243869a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243869a.hashCode();
        }

        public final String toString() {
            return "ScheduleAsrEndForceDelay(event=" + this.f243869a + ')';
        }

        public u0(bx5.a.C0371a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243869a = r100;
        }
    }

    public static final class v extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            ((v) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DispatchResult(result=null)";
        }
    }

    public static final class v0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v0 f243870a = null;

        static {
            f243870a = new v0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v0) == true) goto L9;
            return false;
        L9:
            v0 r101 = (v0) r100;
            return true;
        }

        public final int hashCode() {
            return 1099075808;
        }

        public final String toString() {
            return "StartRecord";
        }

        public v0() {
        }
    }

    public static final class w extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w) == true) goto L8;
            return false;
        L8:
            ((w) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DispatchStreamResult(result=null)";
        }
    }

    public static final class w0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w0 f243871a = null;

        static {
            f243871a = new w0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w0) == true) goto L9;
            return false;
        L9:
            w0 r101 = (w0) r100;
            return true;
        }

        public final int hashCode() {
            return 1140863444;
        }

        public final String toString() {
            return RequestEvent.StartTask;
        }

        public w0() {
        }
    }

    public static final class x extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof x) == true) goto L8;
            return false;
        L8:
            ((x) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DispatchStreamSentence(sentence=null)";
        }
    }

    public static final class x0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x0 f243872a = null;

        static {
            f243872a = new x0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof x0) == true) goto L9;
            return false;
        L9:
            x0 r101 = (x0) r100;
            return true;
        }

        public final int hashCode() {
            return 1198894022;
        }

        public final String toString() {
            return "StopRecord";
        }

        public x0() {
        }
    }

    public static final class y extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f243873a = null;

        static {
            f243873a = new y();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof y) == true) goto L9;
            return false;
        L9:
            y r101 = (y) r100;
            return true;
        }

        public final int hashCode() {
            return 442138760;
        }

        public final String toString() {
            return "DispatchWillPrepare";
        }

        public y() {
        }
    }

    public static final class y0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y0 f243874a = null;

        static {
            f243874a = new y0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof y0) == true) goto L9;
            return false;
        L9:
            y0 r101 = (y0) r100;
            return true;
        }

        public final int hashCode() {
            return 677165843;
        }

        public final String toString() {
            return "StopRecordIgnoringError";
        }

        public y0() {
        }
    }

    public static final class z extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f243875a = null;

        static {
            f243875a = new z();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof z) == true) goto L9;
            return false;
        L9:
            z r101 = (z) r100;
            return true;
        }

        public final int hashCode() {
            return 1236804643;
        }

        public final String toString() {
            return "DispatchWillStart";
        }

        public z() {
        }
    }

    public static final class z0 extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z0 f243876a = null;

        static {
            f243876a = new z0();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof z0) == true) goto L9;
            return false;
        L9:
            z0 r101 = (z0) r100;
            return true;
        }

        public final int hashCode() {
            return -1773128417;
        }

        public final String toString() {
            return "StopTaskIgnoringError";
        }

        public z0() {
        }
    }

    public a() {
    }
}
