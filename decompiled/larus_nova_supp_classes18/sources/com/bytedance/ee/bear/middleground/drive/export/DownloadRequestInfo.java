package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DownloadRequestInfo {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final DownloadType g;
    public final DriveBizScene h;
    public final DriveWatermarkScene i;
    public final String j;
    public final long k;
    public final boolean l;
    public final String m;
    public final int n;
    public DownloadCallback o;
    public final b p;
    public final boolean q;
    public final String r;
    public final List<c> s;

    public static final enum DownloadType extends Enum<DownloadType> {
        public static final DownloadType COVER = null;
        public static final DownloadType DRIVE = null;
        public static final DownloadType IMG = null;
        public static final DownloadType PREVIEW = null;
        public static final DownloadType RANGE = null;
        public static final /* synthetic */ DownloadType[] a = null;
        private int value;

        static {
            DownloadType r0 = new DownloadType("DRIVE", 0, 0);
            DRIVE = r0;
            DownloadType r1 = new DownloadType("COVER", 1, 1);
            COVER = r1;
            DownloadType r3 = new DownloadType("PREVIEW", 2, 2);
            PREVIEW = r3;
            DownloadType r5 = new DownloadType("IMG", 3, 3);
            IMG = r5;
            DownloadType r7 = new DownloadType("RANGE", 4, 4);
            RANGE = r7;
            a = new DownloadType[]{r0, r1, r3, r5, r7};
        }

        public static DownloadType[] values() {
            return (DownloadType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DownloadType fromInt(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return DRIVE;
        L11:
            return IMG;
        L13:
            return PREVIEW;
        L15:
            return COVER;
        }

        public static DownloadType valueOf(String r1) {
            return (DownloadType) r27.a.a(DownloadType.class, r1);
        }

        public DownloadType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public DownloadType f;
        public String g;
        public long h;
        public boolean i;
        public String j;
        public int k;
        public DownloadCallback l;
        public b m;
        public boolean n;
        public String o;

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            DrivePriority$DownloadPriority.DEFAULT.getPriority();
            this.e = "";
            this.f = DownloadType.DRIVE;
            DriveBizScene r1 = DriveBizScene.DriveBizScene_UNKNOWN;
            this.g = "";
            this.h = 0;
            this.i = false;
            this.j = "";
            this.k = 2;
            this.l = null;
            this.m = null;
            this.n = false;
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final String c;
        public final boolean d;

        public final String toString() {
            return "DownloadCoverInfo{width=" + this.a + ", height=" + this.b + ", policy='" + this.c + "', retryOrigin='" + this.d + "'}";
        }

        public b(int r3, int r4) {
            this(r3, r4, "equal", true);
        }

        public b(int r1, int r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static class c {
        public final long a;
        public final long b;

        public final String toString() {
            return "[" + this.a + "," + this.b + ']';
        }

        public c(long r3, long r5) {
            this.a = -1;
            this.b = -1;
            this.a = r3;
            this.b = r5;
        }
    }

    public DownloadRequestInfo() {
        throw null;
    }

    public final String toString() {
        return "Params{fileToken='" + du5.b.g(this.b) + "', localPath='" + du5.b.g(this.a) + "', priority='" + this.e + "', dataVersion='" + this.f + "', mountNodeToken='" + du5.b.g(this.c) + "', mountPoint='" + this.d + "', downloadType='" + this.g + "', docToken='" + du5.b.g(this.m) + "', docType='" + this.n + "', slice='" + this.l + "', fileSize='" + this.k + "', downloadRanges='" + this.s + "', coverInfo='" + this.p + "', disableCdn='" + this.q + "', driveBizScene='" + this.h + "', driveWatermarkScene='" + this.i + "'}";
    }

    public DownloadRequestInfo(String r4, String r5, String r6, String r7, int r8, String r9, DownloadType r10, String r11, long r12, boolean r14, String r15, int r16, DownloadCallback r17, b r18, boolean r19, String r20, List r21, DriveBizScene r22, DriveWatermarkScene r23) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r22;
        this.i = r23;
        this.j = r11;
        this.k = r12;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
    }
}
