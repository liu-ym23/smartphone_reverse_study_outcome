package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436573a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f436573a == ((a) r100).f436573a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436573a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "OnFishBonePageVisibilityChanged(resumed=" + this.f436573a + ')';
        }

        public a(boolean r100) {
            this.f436573a = r100;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.b$b, reason: collision with other inner class name */
    public static final class C5212b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436574a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5212b) == true) goto L9;
            return false;
        L9:
            if (this.f436574a == ((C5212b) r100).f436574a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436574a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "OnFishBoneThemeChanged(isDarkMode=" + this.f436574a + ')';
        }

        public C5212b(boolean r100) {
            this.f436574a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f436575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f436576b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f436575a, r101.f436575a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f436576b, r101.f436576b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f436575a.hashCode() * 31) + this.f436576b.hashCode();
        }

        public final String toString() {
            return "OnFishBoneWebContextAttached(source=" + this.f436576b + ')';
        }

        public final Context getContext() {
            return this.f436575a;
        }

        public c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter("onAttach", "source");
            this.f436575a = r100;
            this.f436576b = "onAttach";
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436577a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436577a, ((d) r100).f436577a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436577a.hashCode();
        }

        public final String toString() {
            return "OnFishBoneWebContextDetached(source=" + this.f436577a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f436577a = r100;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f436578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f436579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f436580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f436581d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f436578a == r101.f436578a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f436579b, r101.f436579b) == true) goto L15;
            return false;
        L15:
            if (this.f436580c == r101.f436580c) goto L18;
            return false;
        L18:
            if (this.f436581d == r101.f436581d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f436578a;
            return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f436579b.hashCode()) * 31) + this.f436580c) * 31) + this.f436581d;
        }

        public final String toString() {
            return "OnFishBoneWebScrollRequested(requestId=" + this.f436578a + ", direction=" + this.f436579b + ", xDp=" + this.f436580c + ", yDp=" + this.f436581d + ')';
        }

        public e(long r100, String r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "direction");
            this.f436578a = r100;
            this.f436579b = r101;
            this.f436580c = r102;
            this.f436581d = r103;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f436582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f436584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Throwable f436585d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f436582a, r101.f436582a) == true) goto L12;
            return false;
        L12:
            if (this.f436583b == r101.f436583b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f436584c, r101.f436584c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f436585d, r101.f436585d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Context r100 = this.f436582a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f436583b == false) goto L9;
            int r103 = 1231;
        L11:
            return ((((r102 + r103) * 31) + this.f436584c.hashCode()) * 31) + this.f436585d.hashCode();
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnFishBoneWebViewAttachFailed(retry=" + this.f436583b + ", source=" + this.f436584c + ", error=" + this.f436585d.getClass().getSimpleName() + ')';
        }

        public final Context getContext() {
            return this.f436582a;
        }

        public f(Context r100, boolean r101, String r102, Throwable r103) {
            Intrinsics.checkNotNullParameter(r102, "source");
            Intrinsics.checkNotNullParameter(r103, "error");
            this.f436582a = r100;
            this.f436583b = r101;
            this.f436584c = r102;
            this.f436585d = r103;
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f436586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436587b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f436586a, r101.f436586a) == true) goto L12;
            return false;
        L12:
            if (this.f436587b == r101.f436587b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f436586a.hashCode() * 31;
            if (this.f436587b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OnFishBoneWebViewCreated(isDarkMode=" + this.f436587b + ')';
        }

        public final Context getContext() {
            return this.f436586a;
        }

        public g(Context r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f436586a = r100;
            this.f436587b = r101;
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f436589b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f436588a == r101.f436588a) goto L12;
            return false;
        L12:
            if (this.f436589b == r101.f436589b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f436588a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f436589b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "OnFishBoneWebVisibilityChanged(visible=" + this.f436588a + ", forceNotify=" + this.f436589b + ')';
        }

        public h(boolean r100, boolean r101) {
            this.f436588a = r100;
            this.f436589b = r101;
        }
    }

    public static final class i extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436590a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436590a, ((i) r100).f436590a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436590a.hashCode();
        }

        public final String toString() {
            return "OnNewContentViewed(source=" + this.f436590a + ')';
        }

        public i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f436590a = r100;
        }
    }

    public static final class j extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f436591a = null;

        static {
            f436591a = new j();
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
            return -935932364;
        }

        public final String toString() {
            return "OnQuotaCtaActionClick";
        }

        public j() {
        }
    }

    public static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f436592a = null;

        static {
            f436592a = new k();
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
            return -1863687782;
        }

        public final String toString() {
            return "OnQuotaCtaBenefitCenterClick";
        }

        public k() {
        }
    }

    public static final class l extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436593a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (this.f436593a == ((l) r100).f436593a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436593a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "OnQuotaCtaVisible(forceTrack=" + this.f436593a + ')';
        }

        public l(boolean r100) {
            this.f436593a = r100;
        }
    }

    public static final class m extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmSummaryViewType f436594a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f436594a == ((m) r100).f436594a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436594a.hashCode();
        }

        public final String toString() {
            return "OnSwitchViewType(viewType=" + this.f436594a + ')';
        }

        public m(MmSummaryViewType r100) {
            Intrinsics.checkNotNullParameter(r100, "viewType");
            this.f436594a = r100;
        }
    }

    public static final class n extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f436595a = null;

        static {
            f436595a = new n();
        }

        public final String toString() {
            return "OnViewCreated";
        }

        public n() {
        }
    }

    public b() {
    }
}
