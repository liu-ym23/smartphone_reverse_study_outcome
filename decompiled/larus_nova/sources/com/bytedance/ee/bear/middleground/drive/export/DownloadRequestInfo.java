package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class DownloadRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f232426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f232427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f232428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f232429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DownloadType f232430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DriveBizScene f232431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DriveWatermarkScene f232432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f232433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f232434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f232435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f232436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f232437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DownloadCallback f232438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f232439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f232440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f232441r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<c> f232442s;

    public static final enum DownloadType extends Enum<DownloadType> {
        public static final DownloadType COVER = null;
        public static final DownloadType DRIVE = null;
        public static final DownloadType IMG = null;
        public static final DownloadType PREVIEW = null;
        public static final DownloadType RANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadType[] f232443a = null;
        private int value;

        static {
            DownloadType r100 = new DownloadType("DRIVE", 0, 0);
            DRIVE = r100;
            DownloadType r101 = new DownloadType("COVER", 1, 1);
            COVER = r101;
            DownloadType r102 = new DownloadType("PREVIEW", 2, 2);
            PREVIEW = r102;
            DownloadType r103 = new DownloadType("IMG", 3, 3);
            IMG = r103;
            DownloadType r104 = new DownloadType("RANGE", 4, 4);
            RANGE = r104;
            f232443a = new DownloadType[]{r100, r101, r102, r103, r104};
        }

        public static DownloadType[] values() {
            return (DownloadType[]) f232443a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DownloadType fromInt(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return DRIVE;
        L11:
            return IMG;
        L13:
            return PREVIEW;
        L15:
            return COVER;
        }

        public static DownloadType valueOf(String r100) {
            return (DownloadType) r27.a.a(DownloadType.class, r100);
        }

        public DownloadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f232444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f232445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f232446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f232447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f232448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DownloadType f232449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f232450g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f232451h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f232452i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f232453j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f232454k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DownloadCallback f232455l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public b f232456m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f232457n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f232458o;

        public a() {
            this.f232444a = "";
            this.f232445b = "";
            this.f232446c = "";
            this.f232447d = "";
            DrivePriority$DownloadPriority.DEFAULT.getPriority();
            this.f232448e = "";
            this.f232449f = DownloadType.DRIVE;
            DriveBizScene r100 = DriveBizScene.DriveBizScene_UNKNOWN;
            this.f232450g = "";
            this.f232451h = 0;
            this.f232452i = false;
            this.f232453j = "";
            this.f232454k = 2;
            this.f232455l = null;
            this.f232456m = null;
            this.f232457n = false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f232459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f232460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f232461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f232462d;

        public final String toString() {
            return "DownloadCoverInfo{width=" + this.f232459a + ", height=" + this.f232460b + ", policy='" + this.f232461c + "', retryOrigin='" + this.f232462d + "'}";
        }

        public b(int r100, int r101) {
            this(r100, r101, CoverDownloadInfo.DEFAULT_POLICY, true);
        }

        public b(int r100, int r101, String r102, boolean r103) {
            this.f232459a = r100;
            this.f232460b = r101;
            this.f232461c = r102;
            this.f232462d = r103;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f232463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f232464b;

        public final String toString() {
            return "[" + this.f232463a + "," + this.f232464b + ']';
        }

        public c(long r100, long r101) {
            this.f232463a = -1;
            this.f232464b = -1;
            this.f232463a = r100;
            this.f232464b = r101;
        }
    }

    public DownloadRequestInfo() {
        throw null;
    }

    public final String toString() {
        return "Params{fileToken='" + du5.b.g(this.f232425b) + "', localPath='" + du5.b.g(this.f232424a) + "', priority='" + this.f232428e + "', dataVersion='" + this.f232429f + "', mountNodeToken='" + du5.b.g(this.f232426c) + "', mountPoint='" + this.f232427d + "', downloadType='" + this.f232430g + "', docToken='" + du5.b.g(this.f232436m) + "', docType='" + this.f232437n + "', slice='" + this.f232435l + "', fileSize='" + this.f232434k + "', downloadRanges='" + this.f232442s + "', coverInfo='" + this.f232439p + "', disableCdn='" + this.f232440q + "', driveBizScene='" + this.f232431h + "', driveWatermarkScene='" + this.f232432i + "'}";
    }

    public DownloadRequestInfo(String r100, String r101, String r102, String r103, int r104, String r105, DownloadType r110, String r111, long r112, boolean r113, String r114, int r115, DownloadCallback r116, b r117, boolean r118, String r210, List r211, DriveBizScene r212, DriveWatermarkScene r213) {
        this.f232424a = r100;
        this.f232425b = r101;
        this.f232426c = r102;
        this.f232427d = r103;
        this.f232428e = r104;
        this.f232429f = r105;
        this.f232430g = r110;
        this.f232431h = r212;
        this.f232432i = r213;
        this.f232433j = r111;
        this.f232434k = r112;
        this.f232435l = r113;
        this.f232436m = r114;
        this.f232437n = r115;
        this.f232438o = r116;
        this.f232439p = r117;
        this.f232440q = r118;
        this.f232441r = r210;
        this.f232442s = r211;
    }
}
