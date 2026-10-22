package nub;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.RecordingRtcOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f520617a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f520617a == ((a) r100).f520617a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f520617a;
        }

        public final String toString() {
            return "Error(err=" + this.f520617a + ')';
        }

        public a(int r100) {
            this.f520617a = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520618a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f520618a, ((b) r100).f520618a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520618a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "FirstRemoteAudioFrame(rtcJoinId=" + this.f520618a + ')';
        }

        public b(String r100) {
            this.f520618a = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f520620b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f520619a, r101.f520619a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f520620b, r101.f520620b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520619a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f520620b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "JoinChannelSuccess(channel=" + this.f520619a + ", rtcJoinId=" + this.f520620b + ')';
        }

        public c(String r100, String r101) {
            this.f520619a = r100;
            this.f520620b = r101;
        }
    }

    /* JADX INFO: renamed from: nub.d$d, reason: collision with other inner class name */
    public static final class C6976d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oub.a f520621a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6976d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f520621a, ((C6976d) r100).f520621a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            oub.a r100 = this.f520621a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "LocalAudioVolumeIndication(rtcAudioVolumeInfo=" + this.f520621a + ')';
        }

        public C6976d(oub.a r100) {
            this.f520621a = r100;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f520622a = null;

        static {
            f520622a = new e();
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
            return 324999721;
        }

        public final String toString() {
            return "MicCaptureError";
        }

        public e() {
        }
    }

    public static final class f extends d {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            ((f) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 1237;
        }

        public final String toString() {
            return "NetworkQualityChanged(isWeak=false)";
        }
    }

    public static final class g extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecordingRtcOperation f520623a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f520623a == ((g) r100).f520623a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f520623a.hashCode();
        }

        public final String toString() {
            return "OperationCall(operation=" + this.f520623a + ')';
        }

        public g(RecordingRtcOperation r100) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
            this.f520623a = r100;
        }
    }

    public static final class h extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecordingRtcOperation f520624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f520625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f520626c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f520624a == r101.f520624a) goto L12;
            return false;
        L12:
            if (this.f520625b == r101.f520625b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f520626c, r101.f520626c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f520624a.hashCode() * 31) + this.f520625b) * 31) + this.f520626c.hashCode();
        }

        public final String toString() {
            return "OperationFailure(operation=" + this.f520624a + ", resultCode=" + this.f520625b + ", resultSource=" + this.f520626c + ')';
        }

        public h(RecordingRtcOperation r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
            Intrinsics.checkNotNullParameter(r102, "resultSource");
            this.f520624a = r100;
            this.f520625b = r101;
            this.f520626c = r102;
        }
    }

    public static final class i extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f520627a;

        public i(byte[] r100) {
            this.f520627a = r100;
        }
    }

    public static final class j extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f520628a;

        public j(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f520628a = r100;
        }
    }

    public static final class k extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f520629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f520630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f520631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f520632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f520633e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f520634f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f520635g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (this.f520629a == r101.f520629a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f520630b, r101.f520630b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f520631c, r101.f520631c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f520632d, r101.f520632d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f520633e, r101.f520633e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f520634f, r101.f520634f) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.f520635g, r101.f520635g) == 0) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f520629a * 31) + Float.floatToIntBits(this.f520630b)) * 31) + Float.floatToIntBits(this.f520631c)) * 31) + Float.floatToIntBits(this.f520632d)) * 31) + Float.floatToIntBits(this.f520633e)) * 31) + Float.floatToIntBits(this.f520634f)) * 31) + Float.floatToIntBits(this.f520635g);
        }

        public final String toString() {
            return "SysStatsEvent(cpuCores=" + this.f520629a + ", cpuAppUsage=" + this.f520630b + ", cpuTotalUsage=" + this.f520631c + ", memoryUsage=" + this.f520632d + ", fullMemory=" + this.f520633e + ", totalMemoryUsage=" + this.f520634f + ", freeMemory=" + this.f520635g + ')';
        }

        public k(int r100, float r101, float r102, float r103, float r104, float r105, float r106) {
            this.f520629a = r100;
            this.f520630b = r101;
            this.f520631c = r102;
            this.f520632d = r103;
            this.f520633e = r104;
            this.f520634f = r105;
            this.f520635g = r106;
        }
    }

    public static final class l extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520636a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f520636a, ((l) r100).f520636a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520636a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "UserJoined(identifier=" + this.f520636a + ')';
        }

        public final String getIdentifier() {
            return this.f520636a;
        }

        public l(String r100) {
            this.f520636a = r100;
        }
    }

    public static final class m extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f520638b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.f520637a, r101.f520637a) == true) goto L12;
            return false;
        L12:
            if (this.f520638b == r101.f520638b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520637a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f520638b;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "UserOffline(identifier=" + this.f520637a + ", reason=" + this.f520638b + ')';
        }

        public final String getIdentifier() {
            return this.f520637a;
        }

        public m(String r100, int r101) {
            this.f520637a = r100;
            this.f520638b = r101;
        }
    }

    public static final class n extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f520639a = null;

        static {
            f520639a = new n();
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
            return -853161847;
        }

        public final String toString() {
            return "WeakNetWorkQuality";
        }

        public n() {
        }
    }

    public d() {
    }
}
