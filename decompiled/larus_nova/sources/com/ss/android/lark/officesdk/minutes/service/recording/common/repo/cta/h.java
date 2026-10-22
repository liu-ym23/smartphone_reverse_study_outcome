package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434921a = null;

        static {
            f434921a = new a();
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
            return -459055362;
        }

        public final String toString() {
            return "NotReady";
        }

        public a() {
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f434922a = null;

        static {
            f434922a = new b();
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
            return 1003316954;
        }

        public final String toString() {
            return "QuotaEnough";
        }

        public b() {
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmQuotaType f434923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MmQuotaData f434924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MmRecordingQuotaCtaScene f434925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MmRecordingQuotaCtaRenderType f434926d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f434923a == r101.f434923a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434924b, r101.f434924b) == true) goto L15;
            return false;
        L15:
            if (this.f434925c == r101.f434925c) goto L18;
            return false;
        L18:
            if (this.f434926d == r101.f434926d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f434923a.hashCode() * 31) + this.f434924b.hashCode()) * 31) + this.f434925c.hashCode()) * 31) + this.f434926d.hashCode();
        }

        public final String toString() {
            return "QuotaUnavailable(quotaType=" + this.f434923a + ", quotaData=" + this.f434924b + ", scene=" + this.f434925c + ", renderType=" + this.f434926d + ')';
        }

        public c(MmQuotaType r100, MmQuotaData r101, MmRecordingQuotaCtaScene r102, MmRecordingQuotaCtaRenderType r103) {
            Intrinsics.checkNotNullParameter(r100, "quotaType");
            Intrinsics.checkNotNullParameter(r101, "quotaData");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r103, "renderType");
            this.f434923a = r100;
            this.f434924b = r101;
            this.f434925c = r102;
            this.f434926d = r103;
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmQuotaType f434927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MmQuotaData f434928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MmRecordingQuotaCtaScene f434929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MmRecordingQuotaCtaRenderType f434930d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f434927a == r101.f434927a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434928b, r101.f434928b) == true) goto L15;
            return false;
        L15:
            if (this.f434929c == r101.f434929c) goto L18;
            return false;
        L18:
            if (this.f434930d == r101.f434930d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f434927a.hashCode() * 31) + this.f434928b.hashCode()) * 31) + this.f434929c.hashCode()) * 31) + this.f434930d.hashCode();
        }

        public final String toString() {
            return "Upgrade(quotaType=" + this.f434927a + ", quotaData=" + this.f434928b + ", scene=" + this.f434929c + ", renderType=" + this.f434930d + ')';
        }

        public d(MmQuotaType r100, MmQuotaData r101, MmRecordingQuotaCtaScene r102, MmRecordingQuotaCtaRenderType r103) {
            Intrinsics.checkNotNullParameter(r100, "quotaType");
            Intrinsics.checkNotNullParameter(r101, "quotaData");
            Intrinsics.checkNotNullParameter(r102, "scene");
            Intrinsics.checkNotNullParameter(r103, "renderType");
            this.f434927a = r100;
            this.f434928b = r101;
            this.f434929c = r102;
            this.f434930d = r103;
        }
    }

    public h() {
    }
}
