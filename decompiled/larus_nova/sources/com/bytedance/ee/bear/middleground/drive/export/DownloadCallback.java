package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface DownloadCallback extends Serializable {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<DownloadRequestInfo.c> f232408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f232409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f232410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f232411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f232412e;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.export.DownloadCallback$a$a, reason: collision with other inner class name */
        public static final class C3323a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<DownloadRequestInfo.c> f232413a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f232414b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f232415c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f232416d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f232417e;

            public C3323a() {
                this.f232413a = new ArrayList();
                this.f232414b = "";
                this.f232415c = "";
                this.f232416d = "";
                this.f232417e = "";
            }
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("Extra{ranges size=");
            List<DownloadRequestInfo.c> r101 = this.f232408a;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            r100.append(r102);
            r100.append("fileName=");
            r100.append(du5.b.g(this.f232409b));
            r100.append(", fileType=");
            r100.append(this.f232410c);
            r100.append(", filePath=");
            r100.append(du5.b.g(this.f232411d));
            r100.append(", dataVersion=");
            r100.append(this.f232412e);
            r100.append(", }");
            return r100.toString();
        L5:
            r102 = r101.size();
            goto L6
        }

        public a(C3323a r100) {
            this.f232408a = r100.f232413a;
            this.f232409b = r100.f232414b;
            this.f232410c = r100.f232415c;
            this.f232411d = r100.f232416d;
            this.f232412e = r100.f232417e;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DriveFile.Status f232418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f232419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f232420c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public DriveFile.Status f232421a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f232422b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f232423c;

            public a() {
                this.f232421a = DriveFile.Status.UNKNOWN;
            }
        }

        public final String toString() {
            return "TransmissionInfo{status=" + this.f232418a + ", bytesTransferred=" + this.f232419b + ", bytesTotal=" + this.f232420c + '}';
        }

        public b(a r100) {
            this.f232418a = r100.f232421a;
            this.f232419b = r100.f232422b;
            this.f232420c = r100.f232423c;
        }
    }

    boolean onFailed(String r100, int r101);

    boolean updateProgress(String r100, b r101, a r102);
}
