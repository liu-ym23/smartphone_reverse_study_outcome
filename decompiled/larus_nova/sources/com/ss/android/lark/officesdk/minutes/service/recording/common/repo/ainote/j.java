package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class j implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434855a = null;

        static {
            f434855a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 803806975;
        }

        public final String toString() {
            return "ContentHeightChanged";
        }

        public a() {
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f434856a = null;

        static {
            f434856a = new b();
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
            return -588010445;
        }

        public final String toString() {
            return "DismissSaveSwitchTooltip";
        }

        public b() {
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f434857a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434857a, ((c) r100).f434857a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434857a.hashCode();
        }

        public final String toString() {
            return "NavigateToSubtitleRequested(request=" + this.f434857a + ')';
        }

        public c(l r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            this.f434857a = r100;
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f434858a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434858a, ((d) r100).f434858a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434858a.hashCode();
        }

        public final String toString() {
            return "RequestCloseSheet(reason=" + this.f434858a + ')';
        }

        public d() {
            Intrinsics.checkNotNullParameter("go_to_subtitle", "reason");
            this.f434858a = "go_to_subtitle";
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingAINoteHint f434859a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f434859a == ((e) r100).f434859a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434859a.hashCode();
        }

        public final String toString() {
            return "ShowHint(hint=" + this.f434859a + ')';
        }

        public e(MmRecordingAINoteHint r100) {
            Intrinsics.checkNotNullParameter(r100, "hint");
            this.f434859a = r100;
        }
    }

    public static final class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f434860a = null;

        static {
            f434860a = new f();
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
            return -353549270;
        }

        public final String toString() {
            return "ShowSaveSwitchTooltip";
        }

        public f() {
        }
    }

    public j() {
    }
}
