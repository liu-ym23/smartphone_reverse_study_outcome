package com.larus.asr.session.clicktalk;

import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.audio.call.mgr.MajorState;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface j {

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f287615a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287615a, ((a) r100).f287615a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f287615a);
        }

        public final String toString() {
            return "AudioDataReceive(data=" + Arrays.toString(this.f287615a) + ')';
        }

        public a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f287615a = r100;
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<pf9.p> f287616a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287616a, ((b) r100).f287616a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f287616a.hashCode();
        }

        public final String toString() {
            return "CommandReply(commands=" + this.f287616a + ')';
        }

        public b(List<pf9.p> r100) {
            Intrinsics.checkNotNullParameter(r100, "commands");
            this.f287616a = r100;
        }
    }

    public static final class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f287617a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287617a, ((c) r100).f287617a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f287617a.hashCode();
        }

        public final String toString() {
            return "ConversationIdUpdated(conversationId=" + this.f287617a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f287617a = r100;
        }
    }

    public static final class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f287618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f287619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f287620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f287621d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f287618a, r101.f287618a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f287619b, r101.f287619b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f287620c, r101.f287620c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f287621d, r101.f287621d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f287618a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f287619b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f287620c.hashCode()) * 31;
            Integer r107 = this.f287621d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(errorCode=" + this.f287618a + ", vuiErrorCode=" + this.f287619b + ", message=" + this.f287620c + ", subErrorCode=" + this.f287621d + ')';
        }

        public d(Integer r100, Integer r101, String r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r102, "message");
            this.f287618a = r100;
            this.f287619b = r101;
            this.f287620c = r102;
            this.f287621d = r103;
        }
    }

    public static final class e implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f287622a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287622a, ((e) r100).f287622a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f287622a.hashCode();
        }

        public final String toString() {
            return "FinishCall(callId=" + this.f287622a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
            this.f287622a = r100;
        }
    }

    public static final class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MajorState f287623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MajorState f287624b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f287623a, r101.f287623a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f287624b, r101.f287624b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f287623a.hashCode() * 31) + this.f287624b.hashCode();
        }

        public final String toString() {
            return "MajorStateChanged(previous=" + this.f287623a + ", current=" + this.f287624b + ')';
        }

        public f(MajorState r100, MajorState r101) {
            Intrinsics.checkNotNullParameter(r100, "previous");
            Intrinsics.checkNotNullParameter(r101, "current");
            this.f287623a = r100;
            this.f287624b = r101;
        }
    }

    public static final class g implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f287625a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287625a, ((g) r100).f287625a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f287625a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "QueryBegin(questionId=" + this.f287625a + ')';
        }

        public g(String r100) {
            this.f287625a = r100;
        }
    }

    public static final class h implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f287626a = null;

        static {
            f287626a = new h();
        }

        public h() {
        }
    }

    public static final class i implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pf9.a f287627a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f287627a, ((i) r100).f287627a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            pf9.a r100 = this.f287627a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "QueryUpdate(asrResult=" + this.f287627a + ')';
        }

        public i(pf9.a r100) {
            this.f287627a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.asr.session.clicktalk.j$j, reason: collision with other inner class name */
    public static final class C3949j implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3949j f287628a = null;

        static {
            f287628a = new C3949j();
        }

        public C3949j() {
        }
    }

    public static final class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f287629a = null;

        static {
            f287629a = new k();
        }

        public k() {
        }
    }

    public static final class l implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f287630a = null;

        static {
            f287630a = new l();
        }

        public l() {
        }
    }

    public static final class m implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f287631a = null;

        static {
            f287631a = new m();
        }

        public m() {
        }
    }

    public static final class n implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f287632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f287633b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (this.f287632a == r101.f287632a) goto L12;
            return false;
        L12:
            if (this.f287633b == r101.f287633b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f287632a * 31;
            if (this.f287633b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "StateChanged(state=" + this.f287632a + ", firstConnect=" + this.f287633b + ')';
        }

        public n(int r100, boolean r101) {
            this.f287632a = r100;
            this.f287633b = r101;
        }
    }
}
