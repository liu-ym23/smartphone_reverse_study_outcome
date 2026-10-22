package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrCancelReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bx5.a.C0371a f243902a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243902a, ((a) r100).f243902a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243902a.hashCode();
        }

        public final String toString() {
            return "AsrEndForceDelayFinished(event=" + this.f243902a + ')';
        }

        public a(bx5.a.C0371a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243902a = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bx5.a.C0371a f243903a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243903a, ((b) r100).f243903a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243903a.hashCode();
        }

        public final String toString() {
            return "AsrEnded(event=" + this.f243903a + ')';
        }

        public b(bx5.a.C0371a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243903a = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bx5.a.b f243904a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243904a, ((c) r100).f243904a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243904a.hashCode();
        }

        public final String toString() {
            return "AsrResponseReceived(event=" + this.f243904a + ')';
        }

        public c(bx5.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243904a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.flow_audio.impl.business.asr.core.d$d, reason: collision with other inner class name */
    public static final class C3492d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3492d f243905a = null;

        static {
            f243905a = new C3492d();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3492d) == true) goto L9;
            return false;
        L9:
            C3492d r101 = (C3492d) r100;
            return true;
        }

        public final int hashCode() {
            return -1268889895;
        }

        public final String toString() {
            return "AssistantCanceled";
        }

        public C3492d() {
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243906a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243906a, ((e) r100).f243906a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243906a.hashCode();
        }

        public final String toString() {
            return "AssistantFailed(error=" + this.f243906a + ')';
        }

        public e(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243906a = r100;
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw5.d f243907a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243907a, ((f) r100).f243907a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243907a.hashCode();
        }

        public final String toString() {
            return "AudioFrameReceived(frame=" + this.f243907a + ')';
        }

        public f(rw5.d r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            this.f243907a = r100;
        }
    }

    public static final class g extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243908a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243908a, ((g) r100).f243908a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243908a.hashCode();
        }

        public final String toString() {
            return "AudioRecordFailed(error=" + this.f243908a + ')';
        }

        public g(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243908a = r100;
        }
    }

    public static final class h extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f243909a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f243909a == ((h) r100).f243909a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f243909a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AudioRecordPaused(hasFocus=" + this.f243909a + ')';
        }

        public h(boolean r100) {
            this.f243909a = r100;
        }
    }

    public static final class i extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f243910a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (this.f243910a == ((i) r100).f243910a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f243910a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AudioRecordResumed(hasFocus=" + this.f243910a + ')';
        }

        public i(boolean r100) {
            this.f243910a = r100;
        }
    }

    public static final class j extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243911a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243911a, ((j) r100).f243911a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243911a.hashCode();
        }

        public final String toString() {
            return "AudioUplinkFailed(error=" + this.f243911a + ')';
        }

        public j(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243911a = r100;
        }
    }

    public static final class k extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f243912a = null;

        static {
            f243912a = new k();
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
            return 95607591;
        }

        public final String toString() {
            return "CompletionTimeout";
        }

        public k() {
        }
    }

    public static final class l extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243913a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243913a, ((l) r100).f243913a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243913a.hashCode();
        }

        public final String toString() {
            return "FailureReady(error=" + this.f243913a + ')';
        }

        public l(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243913a = r100;
        }
    }

    public static final class m extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243914a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243914a, ((m) r100).f243914a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243914a.hashCode();
        }

        public final String toString() {
            return "FinalFailureResolved(error=" + this.f243914a + ')';
        }

        public m(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243914a = r100;
        }
    }

    public static final class n extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final iw5.c f243915a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243915a, ((n) r100).f243915a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243915a.hashCode();
        }

        public final String toString() {
            return "FinalResultAccepted(result=" + this.f243915a + ')';
        }

        public n(iw5.c r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f243915a = r100;
        }
    }

    public static final class o extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final iw5.c f243916a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243916a, ((o) r100).f243916a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243916a.hashCode();
        }

        public final String toString() {
            return "FinalResultBuilt(result=" + this.f243916a + ')';
        }

        public o(iw5.c r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f243916a = r100;
        }
    }

    public static final class p extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243917a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f243917a, ((p) r100).f243917a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243917a.hashCode();
        }

        public final String toString() {
            return "FinalResultRejected(error=" + this.f243917a + ')';
        }

        public p(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f243917a = r100;
        }
    }

    public static final class q extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final hw5.a f243919b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L8;
            return false;
        L8:
            q r101 = (q) r100;
            if (Intrinsics.areEqual(this.f243918a, r101.f243918a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243919b, r101.f243919b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243918a.hashCode() * 31;
            hw5.a r101 = this.f243919b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RetryAttemptFinished(rootError=" + this.f243918a + ", attemptError=" + this.f243919b + ')';
        }

        public q(hw5.a r100, hw5.a r101) {
            Intrinsics.checkNotNullParameter(r100, "rootError");
            this.f243918a = r100;
            this.f243919b = r101;
        }
    }

    public static final class r extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f243920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.flow_audio.impl.business.asr.n f243921b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L8;
            return false;
        L8:
            r r101 = (r) r100;
            if (Intrinsics.areEqual(this.f243920a, r101.f243920a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243921b, r101.f243921b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243920a.hashCode() * 31;
            com.bytedance.flow_audio.impl.business.asr.n r101 = this.f243921b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "RetryDecisionResolved(rootError=" + this.f243920a + ", decision=" + this.f243921b + ')';
        }

        public r(hw5.a r100, com.bytedance.flow_audio.impl.business.asr.n r101) {
            Intrinsics.checkNotNullParameter(r100, "rootError");
            this.f243920a = r100;
            this.f243921b = r101;
        }
    }

    public static final class s extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowAsrCancelReason f243922a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s) == true) goto L9;
            return false;
        L9:
            if (this.f243922a == ((s) r100).f243922a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f243922a.hashCode();
        }

        public final String toString() {
            return "UserCancel(reason=" + this.f243922a + ')';
        }

        public s(FlowAsrCancelReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f243922a = r100;
        }
    }

    public static final class t extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f243923a = null;

        static {
            f243923a = new t();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L9;
            return false;
        L9:
            t r101 = (t) r100;
            return true;
        }

        public final int hashCode() {
            return 220475774;
        }

        public final String toString() {
            return "UserPrepare";
        }

        public t() {
        }
    }

    public static final class u extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f243924a = null;

        static {
            f243924a = new u();
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
            return 1629441150;
        }

        public final String toString() {
            return "UserRelease";
        }

        public u() {
        }
    }

    public static final class v extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f243925a = null;

        static {
            f243925a = new v();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L9;
            return false;
        L9:
            v r101 = (v) r100;
            return true;
        }

        public final int hashCode() {
            return 436574873;
        }

        public final String toString() {
            return "UserStart";
        }

        public v() {
        }
    }

    public static final class w extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f243926a = null;

        static {
            f243926a = new w();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w) == true) goto L9;
            return false;
        L9:
            w r101 = (w) r100;
            return true;
        }

        public final int hashCode() {
            return -1787031829;
        }

        public final String toString() {
            return "UserStop";
        }

        public w() {
        }
    }

    public d() {
    }
}
