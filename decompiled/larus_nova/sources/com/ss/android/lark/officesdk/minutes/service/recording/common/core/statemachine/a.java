package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a$a, reason: collision with other inner class name */
    public static final class C5180a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5180a f434627a = null;

        static {
            f434627a = new C5180a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5180a) == true) goto L9;
            return false;
        L9:
            C5180a r101 = (C5180a) r100;
            return true;
        }

        public final int hashCode() {
            return 908255335;
        }

        public final String toString() {
            return "LocalRecordingPreparedEvent";
        }

        public C5180a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f434628a = null;

        static {
            f434628a = new b();
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
            return -3478193;
        }

        public final String toString() {
            return "LocalRecordingStartedEvent";
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f434629a = null;

        static {
            f434629a = new c();
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
            return 869266823;
        }

        public final String toString() {
            return "MeetingBoundEvent";
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TerminateReason f434630a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f434630a == ((d) r100).f434630a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434630a.hashCode();
        }

        public final String toString() {
            return "MeetingCreateFailedEvent(reason=" + this.f434630a + ')';
        }

        public d() {
            this(TerminateReason.MEETING_CREATED_FAILED);
        }

        public d(TerminateReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f434630a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f434631a = null;

        static {
            f434631a = new e();
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
            return 1952136093;
        }

        public final String toString() {
            return "MeetingCreatedEvent";
        }

        public e() {
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f434632a = null;

        static {
            f434632a = new f();
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
            return -628466824;
        }

        public final String toString() {
            return "RecordingInterruptEvent";
        }

        public f() {
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f434633a = null;

        static {
            f434633a = new g();
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
            return 1975130315;
        }

        public final String toString() {
            return "RecordingInterruptResumeEvent";
        }

        public g() {
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f434634a = null;

        static {
            f434634a = new h();
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
            return -876670907;
        }

        public final String toString() {
            return "RecordingPauseEvent";
        }

        public h() {
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f434635a = null;

        static {
            f434635a = new i();
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
            return 695051404;
        }

        public final String toString() {
            return "RecordingResumeEvent";
        }

        public i() {
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f434636a = null;

        static {
            f434636a = new j();
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
            return -456435622;
        }

        public final String toString() {
            return "RecordingStartedEvent";
        }

        public j() {
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EndRecordingReason f434637a;

        public k(EndRecordingReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f434637a = r100;
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f434638a = null;

        static {
            f434638a = new l();
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
            return 2035916141;
        }

        public final String toString() {
            return "StartCreateMeetingEvent";
        }

        public l() {
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f434639a = null;

        static {
            f434639a = new m();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            m r101 = (m) r100;
            return true;
        }

        public final int hashCode() {
            return -932099317;
        }

        public final String toString() {
            return "StartUploadingEvent";
        }

        public m() {
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TerminateReason f434640a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            if (this.f434640a == ((n) r100).f434640a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434640a.hashCode();
        }

        public final String toString() {
            return "TerminateSessionEvent(reason=" + this.f434640a + ')';
        }

        public n(TerminateReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f434640a = r100;
        }
    }

    public static final class o extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f434641a = null;

        static {
            f434641a = new o();
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
            return 1463479862;
        }

        public final String toString() {
            return "UploadFinishEvent";
        }

        public o() {
        }
    }

    public a() {
    }
}
