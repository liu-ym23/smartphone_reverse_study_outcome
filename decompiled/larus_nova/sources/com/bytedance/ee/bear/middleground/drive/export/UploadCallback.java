package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public interface UploadCallback extends Serializable {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f232476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f232477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f232478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f232479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f232480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f232481f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f232482g;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.export.UploadCallback$a$a, reason: collision with other inner class name */
        public static final class C3324a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f232483a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f232484b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f232485c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f232486d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f232487e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f232488f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f232489g;

            public C3324a() {
                this.f232483a = "";
                this.f232484b = "";
                this.f232485c = "";
                this.f232486d = "";
                this.f232487e = "";
                this.f232488f = "";
            }
        }

        public a(C3324a r100) {
            this.f232476a = r100.f232483a;
            this.f232477b = r100.f232484b;
            this.f232478c = r100.f232485c;
            this.f232479d = r100.f232486d;
            this.f232480e = r100.f232487e;
            this.f232481f = r100.f232488f;
            this.f232482g = r100.f232489g;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DriveFile.Status f232490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f232491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f232492c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public DriveFile.Status f232493a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f232494b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f232495c;

            public a() {
                this.f232493a = DriveFile.Status.UNKNOWN;
            }
        }

        public final String toString() {
            return "TransmissionInfo{status=" + this.f232490a + ", bytesTransferred=" + this.f232491b + ", bytesTotal=" + this.f232492c + '}';
        }

        public b(a r100) {
            this.f232490a = r100.f232493a;
            this.f232491b = r100.f232494b;
            this.f232492c = r100.f232495c;
        }
    }

    boolean onFailed(String r100, int r101, String r102, long r103);

    boolean updateProgress(String r100, b r101, a r102);
}
