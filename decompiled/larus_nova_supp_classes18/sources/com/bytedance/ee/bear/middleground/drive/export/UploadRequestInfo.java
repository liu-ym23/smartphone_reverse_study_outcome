package com.bytedance.ee.bear.middleground.drive.export;

import du5.b;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UploadRequestInfo {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final UploadType h;
    public final Map<String, String> i;
    public final Map<String, String> j;
    public final Map<String, String> k;
    public final UploadCallback l;

    public static final enum UploadType extends Enum<UploadType> {
        public static final UploadType DRIVE = null;
        public static final UploadType IMG = null;
        public static final /* synthetic */ UploadType[] a = null;
        private int value;

        static {
            UploadType r0 = new UploadType("DRIVE", 0, 0);
            DRIVE = r0;
            UploadType r1 = new UploadType("IMG", 1, 1);
            IMG = r1;
            a = new UploadType[]{r0, r1};
        }

        public static UploadType[] values() {
            return (UploadType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static UploadType fromInt(int r1) {
            if (r1 == 1) goto L7;
            return DRIVE;
        L7:
            return IMG;
        }

        public static UploadType valueOf(String r1) {
            return (UploadType) r27.a.a(UploadType.class, r1);
        }

        public UploadType(String r1, int r2, int r3) {
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
        public String f;
        public int g;
        public UploadType h;
        public Map<String, String> i;
        public Map<String, String> j;
        public Map<String, String> k;
        public UploadCallback l;

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = DrivePriority$UploadPriority.DEFAULT.getPriority();
            this.h = UploadType.DRIVE;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
        }
    }

    public final String toString() {
        return "Params{localPath='" + this.a + "'uri='" + this.b + "', fileName='" + b.f(this.c) + "', mountNodeToken='" + b.g(this.d) + "', mountPoint='" + this.e + "', priority='" + this.g + "', uploadType='" + this.h + "', extraRust='" + this.j + "'}";
    }

    public UploadRequestInfo(String r1, String r2, String r3, String r4, String r5, String r6, int r7, UploadType r8, Map r9, Map r10, Map r11, UploadCallback r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
