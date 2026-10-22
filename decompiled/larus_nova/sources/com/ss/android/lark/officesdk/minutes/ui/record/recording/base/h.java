package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class h implements k {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436228a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436228a, ((a) r100).f436228a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436228a.hashCode();
        }

        public final String toString() {
            return "RecordingEnded(recordingId=" + this.f436228a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "recordingId");
            this.f436228a = r100;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436229a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436229a, ((b) r100).f436229a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436229a.hashCode();
        }

        public final String toString() {
            return "ShowAIInterpretationHeadsetDialog(content=" + this.f436229a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f436229a = r100;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f436230a = null;

        static {
            f436230a = new c();
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
            return -189028216;
        }

        public final String toString() {
            return "ShowAIInterpretationSwitchTipBubble";
        }

        public c() {
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b f436231a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436231a, ((d) r100).f436231a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436231a.hashCode();
        }

        public final String toString() {
            return "ShowAutoSaveDialog(info=" + this.f436231a + ')';
        }

        public d(com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f436231a = r100;
        }
    }

    public static final class e extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f436232a = null;

        static {
            f436232a = new e();
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
            return 1076701856;
        }

        public final String toString() {
            return "ShowAutoTranslationTipBubble";
        }

        public e() {
        }
    }

    public static final class f extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436233a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436233a, ((f) r100).f436233a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436233a.hashCode();
        }

        public final String toString() {
            return "ShowFirstMarkTooltip(message=" + this.f436233a + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f436233a = r100;
        }
    }

    public static final class g extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final svb.a f436234a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436234a, ((g) r100).f436234a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436234a.hashCode();
        }

        public final String toString() {
            return "ShowToast(event=" + this.f436234a + ')';
        }

        public g(svb.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f436234a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.h$h, reason: collision with other inner class name */
    public static final class C5207h extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436236b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5207h) == true) goto L8;
            return false;
        L8:
            C5207h r101 = (C5207h) r100;
            if (Intrinsics.areEqual(this.f436235a, r101.f436235a) == true) goto L12;
            return false;
        L12:
            if (this.f436236b == r101.f436236b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f436235a.hashCode() * 31;
            if (this.f436236b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "UpdateTitleFailed(originalTitle='" + this.f436235a + "')";
        }

        public C5207h(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "originalTitle");
            this.f436235a = r100;
            this.f436236b = r101;
        }
    }

    public static final class i extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f436237a = null;

        static {
            f436237a = new i();
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
            return 811474385;
        }

        public final String toString() {
            return "Vibrate";
        }

        public i() {
        }
    }

    public h() {
    }
}
