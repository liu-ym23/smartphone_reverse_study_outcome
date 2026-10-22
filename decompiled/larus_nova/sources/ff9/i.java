package ff9;

import com.tencent.open.SocialConstants;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476701b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f476700a == r101.f476700a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476701b, r101.f476701b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f476700a * 31;
            String r101 = this.f476701b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "AudioPublishFailed(errorCode=" + this.f476700a + ", errorMessage=" + this.f476701b + ')';
        }

        public a(int r100, String r101) {
            this.f476700a = r100;
            this.f476701b = r101;
        }
    }

    public static final class a0 extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476703b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a0) == true) goto L8;
            return false;
        L8:
            a0 r101 = (a0) r100;
            if (Intrinsics.areEqual(this.f476702a, r101.f476702a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476703b, r101.f476703b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476702a.hashCode() * 31) + this.f476703b.hashCode();
        }

        public final String toString() {
            return "UserStopAudioCapture(roomId=" + this.f476702a + ", userId=" + this.f476703b + ')';
        }

        public a0(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "userId");
            this.f476702a = r100;
            this.f476703b = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476705b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f476704a == r101.f476704a) goto L12;
            return false;
        L12:
            if (this.f476705b == r101.f476705b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476704a * 31) + this.f476705b;
        }

        public final String toString() {
            return "ConnectionStateChanged(state=" + this.f476704a + ", reason=" + this.f476705b + ')';
        }

        public b(int r100, int r101) {
            this.f476704a = r100;
            this.f476705b = r101;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f476706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f476708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f476709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f476710e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f476706a, r101.f476706a) == true) goto L12;
            return false;
        L12:
            if (this.f476707b == r101.f476707b) goto L15;
            return false;
        L15:
            if (this.f476708c == r101.f476708c) goto L18;
            return false;
        L18:
            if (this.f476709d == r101.f476709d) goto L21;
            return false;
        L21:
            if (this.f476710e == r101.f476710e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f476706a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = ((((r101 * 31) + this.f476707b) * 31) + this.f476708c) * 31;
            int r103 = 1231;
            if (this.f476709d == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f476710e == true) goto L15;
            r103 = 1237;
        L15:
            return r105 + r103;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "DeviceError(deviceType=" + this.f476706a + ", deviceState=" + this.f476707b + ", deviceError=" + this.f476708c + ", isAudio=" + this.f476709d + ", isVideo=" + this.f476710e + ')';
        }

        public c(Integer r100, int r101, int r102, boolean r103, boolean r104, int r105) {
            if ((r105 & 8) == 0) goto L6;
            r103 = false;
        L6:
            if ((r105 & 16) == 0) goto L8;
            r104 = false;
        L8:
            this.f476706a = r100;
            this.f476707b = r101;
            this.f476708c = r102;
            this.f476709d = r103;
            this.f476710e = r104;
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476712b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f476711a == r101.f476711a) goto L12;
            return false;
        L12:
            if (this.f476712b == r101.f476712b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476711a * 31) + this.f476712b;
        }

        public final String toString() {
            return "FirstLocalVideoFrameCaptured(width=" + this.f476711a + ", height=" + this.f476712b + ')';
        }

        public d(int r100, int r101) {
            this.f476711a = r100;
            this.f476712b = r101;
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476713a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f476713a, ((e) r100).f476713a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f476713a.hashCode();
        }

        public final String toString() {
            return "FirstRemoteAudioFrameReceived(userId=" + this.f476713a + ')';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f476713a = r100;
        }
    }

    public static final class f extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476715b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f476714a == r101.f476714a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476715b, r101.f476715b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476714a * 31) + this.f476715b.hashCode();
        }

        public final String toString() {
            return "InternalError(errorCode=" + this.f476714a + ", desc=" + this.f476715b + ')';
        }

        public f(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
            this.f476714a = r100;
            this.f476715b = r101;
        }
    }

    public static final class g extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f476716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f476718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f476719d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f476716a == r101.f476716a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476717b, r101.f476717b) == true) goto L15;
            return false;
        L15:
            if (this.f476718c == r101.f476718c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f476719d, r101.f476719d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f476716a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f476717b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (((r101 + r104) * 31) + this.f476718c) * 31;
            String r106 = this.f476719d;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return r105 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "JoinRoomStateChanged(success=" + this.f476716a + ", reason=" + this.f476717b + ", state=" + this.f476718c + ", userId=" + this.f476719d + ')';
        }

        public g(boolean r100, String r101, int r102, String r103) {
            this.f476716a = r100;
            this.f476717b = r101;
            this.f476718c = r102;
            this.f476719d = r103;
        }
    }

    public static final class h extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f476720a = null;

        static {
            f476720a = new h();
        }

        public h() {
        }
    }

    /* JADX INFO: renamed from: ff9.i$i, reason: collision with other inner class name */
    public static final class C5894i extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f476721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476722b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5894i) == true) goto L8;
            return false;
        L8:
            C5894i r101 = (C5894i) r100;
            if (this.f476721a == r101.f476721a) goto L12;
            return false;
        L12:
            if (this.f476722b == r101.f476722b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f476721a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f476722b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "LoginResult(success=" + this.f476721a + ", errorCode=" + this.f476722b + ')';
        }

        public C5894i(boolean r100, int r101) {
            this.f476721a = r100;
            this.f476722b = r101;
        }
    }

    public static final class j extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f476723a = null;

        static {
            f476723a = new j();
        }

        public j() {
        }
    }

    public static final class k extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f476726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f476727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f476728e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f476729f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (this.f476724a == r101.f476724a) goto L12;
            return false;
        L12:
            if (this.f476725b == r101.f476725b) goto L15;
            return false;
        L15:
            if (this.f476726c == r101.f476726c) goto L18;
            return false;
        L18:
            if (this.f476727d == r101.f476727d) goto L21;
            return false;
        L21:
            if (this.f476728e == r101.f476728e) goto L24;
            return false;
        L24:
            if (this.f476729f == r101.f476729f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f476724a * 31) + this.f476725b) * 31) + this.f476726c) * 31) + this.f476727d) * 31) + this.f476728e) * 31) + this.f476729f;
        }

        public final String toString() {
            return "OnMultiLinkStatsEvent(mainMinRtt=" + this.f476724a + ", mainMaxRtt=" + this.f476725b + ", mainAvgRtt=" + this.f476726c + ", standbyMinRtt=" + this.f476727d + ", standbyMaxRtt=" + this.f476728e + ", standbyAvgRtt=" + this.f476729f + ')';
        }

        public k(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f476724a = r100;
            this.f476725b = r101;
            this.f476726c = r102;
            this.f476727d = r103;
            this.f476728e = r104;
            this.f476729f = r105;
        }
    }

    public static final class l extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476731b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (this.f476730a == r101.f476730a) goto L12;
            return false;
        L12:
            if (this.f476731b == r101.f476731b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476730a * 31) + this.f476731b;
        }

        public final String toString() {
            return "OnMultiLinkStatusChangedEvent(multiPathLinkState=" + this.f476730a + ", multiPathLinkMode=" + this.f476731b + ')';
        }

        public l(int r100, int r101) {
            this.f476730a = r100;
            this.f476731b = r101;
        }
    }

    public static final class m extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f476732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f476733b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.f476732a, r101.f476732a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476733b, r101.f476733b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f476732a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f476733b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnNetworkQuality(upQuality=" + this.f476732a + ", downQuality=" + this.f476733b + ')';
        }

        public m(Integer r100, Integer r101) {
            this.f476732a = r100;
            this.f476733b = r101;
        }
    }

    public static final class n extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476734a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            if (this.f476734a == ((n) r100).f476734a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f476734a;
        }

        public final String toString() {
            return "OnNetworkTypeChangedEvent(networkType=" + this.f476734a + ')';
        }

        public n(int r100) {
            this.f476734a = r100;
        }
    }

    public static final class o extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f476737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f476738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f476739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f476740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f476741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f476742h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (this.f476735a == r101.f476735a) goto L12;
            return false;
        L12:
            if (this.f476736b == r101.f476736b) goto L15;
            return false;
        L15:
            if (this.f476737c == r101.f476737c) goto L18;
            return false;
        L18:
            if (this.f476738d == r101.f476738d) goto L21;
            return false;
        L21:
            if (Double.compare(this.f476739e, r101.f476739e) == 0) goto L24;
            return false;
        L24:
            if (Double.compare(this.f476740f, r101.f476740f) == 0) goto L27;
            return false;
        L27:
            if (this.f476741g == r101.f476741g) goto L30;
            return false;
        L30:
            if (this.f476742h == r101.f476742h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f476735a * 31) + this.f476736b) * 31) + this.f476737c) * 31) + this.f476738d) * 31;
            long r101 = Double.doubleToLongBits(this.f476739e);
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = Double.doubleToLongBits(this.f476740f);
            return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f476741g) * 31) + this.f476742h;
        }

        public final String toString() {
            return "OnRoomStats(txKBitRate=" + this.f476735a + ", rxKBitRate=" + this.f476736b + ", txCellularKBitrate=" + this.f476737c + ", rxCellularKBitrate=" + this.f476738d + ", txLostRate=" + this.f476739e + ", rxLostRate=" + this.f476740f + ", txJitter=" + this.f476741g + ", rxJitter=" + this.f476742h + ')';
        }

        public o(int r100, int r101, int r102, int r103, double r104, double r105, int r106, int r110) {
            this.f476735a = r100;
            this.f476736b = r101;
            this.f476737c = r102;
            this.f476738d = r103;
            this.f476739e = r104;
            this.f476740f = r105;
            this.f476741g = r106;
            this.f476742h = r110;
        }
    }

    public static final class p extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476743a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f476743a, ((p) r100).f476743a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f476743a.hashCode();
        }

        public final String toString() {
            return "RTCEngineOccupy(withBizId=" + this.f476743a + ')';
        }

        public p(String r100) {
            Intrinsics.checkNotNullParameter(r100, "withBizId");
            this.f476743a = r100;
        }
    }

    public static final class q extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f476744a = null;

        static {
            f476744a = new q();
        }

        public q() {
        }
    }

    public static final class r extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476746b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L8;
            return false;
        L8:
            r r101 = (r) r100;
            if (this.f476745a == r101.f476745a) goto L12;
            return false;
        L12:
            if (this.f476746b == r101.f476746b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476745a * 31) + this.f476746b;
        }

        public final String toString() {
            return "SelfScreenShareStop(deviceState=" + this.f476745a + ", deviceError=" + this.f476746b + ')';
        }

        public r(int r100, int r101) {
            this.f476745a = r100;
            this.f476746b = r101;
        }
    }

    public static final class s extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f476747a = null;

        static {
            f476747a = new s();
        }

        public s() {
        }
    }

    public static final class t extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f476748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476749b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L8;
            return false;
        L8:
            t r101 = (t) r100;
            if (this.f476748a == r101.f476748a) goto L12;
            return false;
        L12:
            if (this.f476749b == r101.f476749b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476748a * 31) + this.f476749b;
        }

        public final String toString() {
            return "SelfVideoCaptureStopped(deviceState=" + this.f476748a + ", deviceError=" + this.f476749b + ')';
        }

        public t(int r100, int r101) {
            this.f476748a = r100;
            this.f476749b = r101;
        }
    }

    public static final class u extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cf9.d f476750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476751b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L8;
            return false;
        L8:
            u r101 = (u) r100;
            if (Intrinsics.areEqual(this.f476750a, r101.f476750a) == true) goto L12;
            return false;
        L12:
            if (this.f476751b == r101.f476751b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476750a.hashCode() * 31) + this.f476751b;
        }

        public final String toString() {
            return "SendResult(ticket=" + this.f476750a + ", error=" + this.f476751b + ')';
        }

        public u(cf9.d r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "ticket");
            this.f476750a = r100;
            this.f476751b = r101;
        }
    }

    public static final class v extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f476752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f476753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ue9.c f476754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f476755d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            v r101 = (v) r100;
            if (this.f476752a == r101.f476752a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476753b, r101.f476753b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f476754c, r101.f476754c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f476755d, r101.f476755d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f476752a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            ByteBuffer r102 = this.f476753b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            ue9.c r106 = this.f476754c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (r105 + r107) * 31;
            Integer r109 = this.f476755d;
            if (r109 == null) goto L19;
            r103 = r109.hashCode();
        L19:
            return r108 + r103;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartSessionResult(isSuccess=" + this.f476752a + ", message=" + this.f476753b + ", error=" + this.f476754c + ", rtcErrorCode=" + this.f476755d + ')';
        }

        public v(boolean r100, ByteBuffer r101, Integer r102) {
            ue9.c.m r103 = ue9.c.m.f549857c;
            this.f476752a = r100;
            this.f476753b = r101;
            this.f476754c = r103;
            this.f476755d = r102;
        }
    }

    public static final class w extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476756a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f476756a, ((w) r100).f476756a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f476756a.hashCode();
        }

        public final String toString() {
            return "UserJoinRoom(userId=" + this.f476756a + ')';
        }

        public w(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f476756a = r100;
        }
    }

    public static final class x extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f476758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f476759c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof x) == true) goto L8;
            return false;
        L8:
            x r101 = (x) r100;
            if (Intrinsics.areEqual(this.f476757a, r101.f476757a) == true) goto L12;
            return false;
        L12:
            if (this.f476758b == r101.f476758b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f476759c, r101.f476759c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f476757a.hashCode() * 31) + this.f476758b) * 31;
            String r101 = this.f476759c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "UserLeaveRoom(userId=" + this.f476757a + ", reason=" + this.f476758b + ", extraInfo=" + this.f476759c + ')';
        }

        public x(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f476757a = r100;
            this.f476758b = r101;
            this.f476759c = r102;
        }
    }

    public static final class y extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f476760a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof y) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f476760a, ((y) r100).f476760a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f476760a.hashCode();
        }

        public final String toString() {
            return "UserMessageReceived(data=" + this.f476760a + ')';
        }

        public y(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f476760a = r100;
        }
    }

    public static final class z extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f476761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476762b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof z) == true) goto L8;
            return false;
        L8:
            z r101 = (z) r100;
            if (Intrinsics.areEqual(this.f476761a, r101.f476761a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f476762b, r101.f476762b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f476761a.hashCode() * 31) + this.f476762b.hashCode();
        }

        public final String toString() {
            return "UserStartAudioCapture(roomId=" + this.f476761a + ", userId=" + this.f476762b + ')';
        }

        public z(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "userId");
            this.f476761a = r100;
            this.f476762b = r101;
        }
    }

    public i() {
    }
}
