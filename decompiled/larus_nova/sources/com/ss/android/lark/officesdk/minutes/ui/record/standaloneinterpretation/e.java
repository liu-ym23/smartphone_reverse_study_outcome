package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class e implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436753a = null;

        static {
            f436753a = new a();
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
            return -1552342203;
        }

        public final String toString() {
            return "BackClick";
        }

        public a() {
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f436754a = null;

        static {
            f436754a = new b();
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
            return 383219965;
        }

        public final String toString() {
            return "BindSession";
        }

        public b() {
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f436755a = null;

        static {
            f436755a = new c();
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
            return 739582324;
        }

        public final String toString() {
            return "LanguageClick";
        }

        public c() {
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f436756a = null;

        static {
            f436756a = new d();
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
            return 1165187745;
        }

        public final String toString() {
            return "PauseResumeClick";
        }

        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.e$e, reason: collision with other inner class name */
    public static final class C5214e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmStandaloneAIInterpretationLanguageSide f436757a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5214e) == true) goto L9;
            return false;
        L9:
            if (this.f436757a == ((C5214e) r100).f436757a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436757a.hashCode();
        }

        public final String toString() {
            return "SelectLanguageSide(side=" + this.f436757a + ')';
        }

        public C5214e(MmStandaloneAIInterpretationLanguageSide r100) {
            Intrinsics.checkNotNullParameter(r100, "side");
            this.f436757a = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436758a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f436758a == ((f) r100).f436758a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436758a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetBilingual(enabled=" + this.f436758a + ')';
        }

        public f(boolean r100) {
            this.f436758a = r100;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436759a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f436759a == ((g) r100).f436759a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436759a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "SetSaveArtifactType(saveArtifactType=" + this.f436759a + ')';
        }

        public g(boolean r100) {
            this.f436759a = r100;
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f436760a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436760a, ((h) r100).f436760a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436760a.hashCode();
        }

        public final String toString() {
            return "SetSpokenLanguage(language=" + this.f436760a + ')';
        }

        public h(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f436760a = r100;
        }
    }

    public static final class i extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f436761a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436761a, ((i) r100).f436761a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436761a.hashCode();
        }

        public final String toString() {
            return "SetTargetLanguage(language=" + this.f436761a + ')';
        }

        public i(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f436761a = r100;
        }
    }

    public static final class j extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f436762a = null;

        static {
            f436762a = new j();
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
            return -1098483739;
        }

        public final String toString() {
            return "SpeakerClick";
        }

        public j() {
        }
    }

    public static final class k extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f436763a = null;

        static {
            f436763a = new k();
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
            return -1257383670;
        }

        public final String toString() {
            return "StopClick";
        }

        public k() {
        }
    }

    public e() {
    }
}
