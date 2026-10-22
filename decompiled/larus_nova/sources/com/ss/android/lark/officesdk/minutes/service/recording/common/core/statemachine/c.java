package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f434643b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f434644a;

    public static final class a {
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final EndRecordingReason f434645c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f434645c == ((b) r100).f434645c) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434645c.hashCode();
        }

        public b() {
            this(EndRecordingReason.OTHERS);
        }

        public final String toString() {
            return "EndRecording(endReason=" + this.f434645c + ')';
        }

        public b(EndRecordingReason r100) {
            Intrinsics.checkNotNullParameter(r100, "endReason");
            super(8);
            this.f434645c = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c$c, reason: collision with other inner class name */
    public static final class C5181c extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C5181c f434646c = null;

        static {
            f434646c = new C5181c();
        }

        public C5181c() {
            super(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5181c) == true) goto L9;
            return false;
        L9:
            C5181c r101 = (C5181c) r100;
            return true;
        }

        public final int hashCode() {
            return -1723108791;
        }

        public final String toString() {
            return "Init";
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f434647c = null;

        static {
            f434647c = new d();
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
            return -235307287;
        }

        public final String toString() {
            return "Interrupted";
        }

        public d() {
            super(12);
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f434648c = null;

        static {
            f434648c = new e();
        }

        public e() {
            super(2);
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
            return 519798975;
        }

        public final String toString() {
            return "LocalRecording";
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f434649c = null;

        static {
            f434649c = new f();
        }

        public f() {
            super(3);
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
            return 441888195;
        }

        public final String toString() {
            return "MeetingBinding";
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f434650c = null;

        static {
            f434650c = new g();
        }

        public g() {
            super(4);
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
            return -88739780;
        }

        public final String toString() {
            return "MeetingBound";
        }
    }

    public static final class h extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f434651c = null;

        static {
            f434651c = new h();
        }

        public h() {
            super(7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            h r101 = (h) r100;
            return true;
        }

        public final int hashCode() {
            return 2138586151;
        }

        public final String toString() {
            return "Paused";
        }
    }

    public static final class i extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f434652c = null;

        static {
            f434652c = new i();
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
            return -52693556;
        }

        public final String toString() {
            return "PostProcessing";
        }

        public i() {
            super(9);
        }
    }

    public static final class j extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f434653c = null;

        static {
            f434653c = new j();
        }

        public j() {
            super(1);
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
            return 1120398865;
        }

        public final String toString() {
            return "PreparingLocalRecording";
        }
    }

    public static final class k extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final k f434654c = null;

        static {
            f434654c = new k();
        }

        public k() {
            super(6);
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
            return -761082792;
        }

        public final String toString() {
            return "Recording";
        }
    }

    public static final class l extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f434655c = null;

        static {
            f434655c = new l();
        }

        public l() {
            super(5);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            l r101 = (l) r100;
            return true;
        }

        public final int hashCode() {
            return 416167792;
        }

        public final String toString() {
            return "RecordingCreated";
        }
    }

    public static final class m extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TerminateReason f434656c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f434656c == ((m) r100).f434656c) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434656c.hashCode();
        }

        public final String toString() {
            return "Terminated(reason=" + this.f434656c + ')';
        }

        public m(TerminateReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            super(11);
            this.f434656c = r100;
        }
    }

    public static final class n extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final n f434657c = null;

        static {
            f434657c = new n();
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
            return -1817745639;
        }

        public final String toString() {
            return "Uploaded";
        }

        public n() {
            super(10);
        }
    }

    static {
    }

    public final boolean a() {
        if ((this instanceof b) == false) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(this, i.f434652c) == true) goto L11;
        if (Intrinsics.areEqual(this, n.f434657c) == true) goto L11;
        if ((this instanceof m) == true) goto L11;
        return true;
    }

    public c(int r100) {
        this.f434644a = r100;
    }
}
