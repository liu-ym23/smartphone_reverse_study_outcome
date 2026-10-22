package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface DownloadCallback extends Serializable {

    public static class a {
        public final List<DownloadRequestInfo.c> a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.export.DownloadCallback$a$a, reason: collision with other inner class name */
        public static final class C0076a {
            public List<DownloadRequestInfo.c> a;
            public String b;
            public String c;
            public String d;
            public String e;

            public C0076a() {
                this.a = new ArrayList();
                this.b = "";
                this.c = "";
                this.d = "";
                this.e = "";
            }
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder("Extra{ranges size=");
            List<DownloadRequestInfo.c> r1 = this.a;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            r0.append(r2);
            r0.append("fileName=");
            r0.append(du5.b.g(this.b));
            r0.append(", fileType=");
            r0.append(this.c);
            r0.append(", filePath=");
            r0.append(du5.b.g(this.d));
            r0.append(", dataVersion=");
            r0.append(this.e);
            r0.append(", }");
            return r0.toString();
        L5:
            r2 = r1.size();
            goto L6
        }

        public a(C0076a r2) {
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
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

    boolean onFailed(String r1, int r2);

    boolean updateProgress(String r1, b r2, a r3);
}
