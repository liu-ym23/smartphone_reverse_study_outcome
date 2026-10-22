package hia;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f485368a = null;

        static {
            f485368a = new a();
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
            return 1100627058;
        }

        public final String toString() {
            return "PreInterrupted";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: hia.b$b, reason: collision with other inner class name */
    public static final class C6153b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f485369a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6153b) == true) goto L9;
            return false;
        L9:
            if (this.f485369a == ((C6153b) r100).f485369a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f485369a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "QueryBegin(startListenTimestampMs=" + this.f485369a + ')';
        }

        public C6153b(long r100) {
            this.f485369a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f485370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f485371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f485372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f485373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f485374e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f485375f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Long f485376g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Long f485377h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f485378i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f485370a == r101.f485370a) goto L12;
            return false;
        L12:
            if (this.f485371b == r101.f485371b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f485372c, r101.f485372c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f485373d, r101.f485373d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f485374e, r101.f485374e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f485375f, r101.f485375f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f485376g, r101.f485376g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f485377h, r101.f485377h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f485378i, r101.f485378i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            if (this.f485370a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f485371b;
            int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Long r103 = this.f485372c;
            int r104 = 0;
            if (r103 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r102 + r105) * 31;
            String r107 = this.f485373d;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f485374e;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f485375f;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Long r116 = this.f485376g;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            Long r119 = this.f485377h;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.f485378i;
            if (r122 == null) goto L35;
            r104 = r122.hashCode();
        L35:
            return r121 + r104;
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r103.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.f485370a + ", userDuration=" + this.f485371b + ", lastRespCostTime=" + this.f485372c + ", questionId=" + this.f485373d + ", asrTaskId=" + this.f485374e + ", localMessageId=" + this.f485375f + ", queryStartTime=" + this.f485376g + ", queryEndTime=" + this.f485377h + ", callRound=" + this.f485378i + ')';
        }

        public c(boolean r100, long r101, Long r102, String r103, String r104, String r105, Long r106, Long r107, String r110) {
            this.f485370a = r100;
            this.f485371b = r101;
            this.f485372c = r102;
            this.f485373d = r103;
            this.f485374e = r104;
            this.f485375f = r105;
            this.f485376g = r106;
            this.f485377h = r107;
            this.f485378i = r110;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f485379a = null;

        static {
            f485379a = new d();
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
            return 1363465779;
        }

        public final String toString() {
            return "QueryRejected";
        }

        public d() {
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f485380a = null;

        static {
            f485380a = new e();
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
            return 1661526974;
        }

        public final String toString() {
            return "QueryUpdate";
        }

        public e() {
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f485381a = null;

        static {
            f485381a = new f();
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
            return 1732912690;
        }

        public final String toString() {
            return "ReplyBegin";
        }

        public f() {
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f485382a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f485382a, ((g) r100).f485382a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f485382a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ReplyEnd(messageId=" + this.f485382a + ')';
        }

        public g(String r100) {
            this.f485382a = r100;
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f485383a = null;

        static {
            f485383a = new h();
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
            return -355891246;
        }

        public final String toString() {
            return "VadVoiceActived";
        }

        public h() {
        }
    }

    public static final class i extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f485384a = null;

        static {
            f485384a = new i();
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
            return 137027679;
        }

        public final String toString() {
            return "VadVoiceFinish";
        }

        public i() {
        }
    }

    public static final class j extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f485385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f485386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f485387c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (Intrinsics.areEqual(this.f485385a, r101.f485385a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f485386b, r101.f485386b) == true) goto L15;
            return false;
        L15:
            if (this.f485387c == r101.f485387c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f485385a.hashCode() * 31) + this.f485386b.hashCode()) * 31;
            if (this.f485387c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "VoiceAuthResult(roomId=" + this.f485385a + ", asrTaskId=" + this.f485386b + ", voiceMatch=" + this.f485387c + ')';
        }

        public j(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "asrTaskId");
            this.f485385a = r100;
            this.f485386b = r101;
            this.f485387c = r102;
        }
    }

    public b() {
    }
}
