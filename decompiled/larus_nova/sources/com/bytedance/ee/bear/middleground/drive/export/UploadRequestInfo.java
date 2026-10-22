package com.bytedance.ee.bear.middleground.drive.export;

import du5.b;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class UploadRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f232498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f232499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f232500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f232501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f232502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UploadType f232503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f232504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f232505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, String> f232506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UploadCallback f232507l;

    public static final enum UploadType extends Enum<UploadType> {
        public static final UploadType DRIVE = null;
        public static final UploadType IMG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UploadType[] f232508a = null;
        private int value;

        static {
            UploadType r100 = new UploadType("DRIVE", 0, 0);
            DRIVE = r100;
            UploadType r101 = new UploadType("IMG", 1, 1);
            IMG = r101;
            f232508a = new UploadType[]{r100, r101};
        }

        public static UploadType[] values() {
            return (UploadType[]) f232508a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static UploadType fromInt(int r100) {
            if (r100 == 1) goto L7;
            return DRIVE;
        L7:
            return IMG;
        }

        public static UploadType valueOf(String r100) {
            return (UploadType) r27.a.a(UploadType.class, r100);
        }

        public UploadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f232509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f232510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f232511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f232512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f232513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f232514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f232515g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public UploadType f232516h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f232517i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, String> f232518j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Map<String, String> f232519k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public UploadCallback f232520l;

        public a() {
            this.f232509a = "";
            this.f232510b = "";
            this.f232511c = "";
            this.f232512d = "";
            this.f232513e = "";
            this.f232514f = "";
            this.f232515g = DrivePriority$UploadPriority.DEFAULT.getPriority();
            this.f232516h = UploadType.DRIVE;
            this.f232517i = null;
            this.f232518j = null;
            this.f232519k = null;
            this.f232520l = null;
        }
    }

    public final String toString() {
        return "Params{localPath='" + this.f232496a + "'uri='" + this.f232497b + "', fileName='" + b.f(this.f232498c) + "', mountNodeToken='" + b.g(this.f232499d) + "', mountPoint='" + this.f232500e + "', priority='" + this.f232502g + "', uploadType='" + this.f232503h + "', extraRust='" + this.f232505j + "'}";
    }

    public UploadRequestInfo(String r100, String r101, String r102, String r103, String r104, String r105, int r106, UploadType r107, Map r108, Map r110, Map r111, UploadCallback r112) {
        this.f232496a = r100;
        this.f232497b = r101;
        this.f232498c = r102;
        this.f232499d = r103;
        this.f232500e = r104;
        this.f232501f = r105;
        this.f232502g = r106;
        this.f232503h = r107;
        this.f232504i = r108;
        this.f232505j = r110;
        this.f232506k = r111;
        this.f232507l = r112;
    }
}
