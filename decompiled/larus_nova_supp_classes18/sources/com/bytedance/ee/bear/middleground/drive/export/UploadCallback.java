package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface UploadCallback extends Serializable {

    public static class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.export.UploadCallback$a$a, reason: collision with other inner class name */
        public static final class C0077a {
            public String a;
            public String b;
            public String c;
            public String d;
            public String e;
            public String f;
            public String g;

            public C0077a() {
                this.a = "";
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = "";
                this.f = "";
            }
        }

        public a(C0077a r2) {
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.g = r2.g;
        }
    }

    public static class b {
        public final DriveFile.Status a;
        public final long b;
        public final long c;

        public static final class a {
            public DriveFile.Status a;
            public long b;
            public long c;

            public a() {
                this.a = DriveFile.Status.UNKNOWN;
            }
        }

        public final String toString() {
            return "TransmissionInfo{status=" + this.a + ", bytesTransferred=" + this.b + ", bytesTotal=" + this.c + '}';
        }

        public b(a r3) {
            this.a = r3.a;
            this.b = r3.b;
            this.c = r3.c;
        }
    }

    boolean onFailed(String r1, int r2, String r3, long r4);

    boolean updateProgress(String r1, b r2, a r3);
}
