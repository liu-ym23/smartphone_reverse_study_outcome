package com.bytedance.dora.offline.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public interface OfflineFileBusiness {

    /* JADX INFO: loaded from: classes15.dex */
    public static final enum DeliveryResult extends Enum<DeliveryResult> {
        public static final DeliveryResult CANCELLED = null;
        public static final DeliveryResult CONSUMED = null;
        public static final DeliveryResult FINAL_FAILED = null;
        public static final DeliveryResult RETAINED = null;
        public static final DeliveryResult RETRYABLE_FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DeliveryResult[] f204496a = null;

        static {
            DeliveryResult r100 = new DeliveryResult("CONSUMED", 0);
            CONSUMED = r100;
            DeliveryResult r101 = new DeliveryResult("RETAINED", 1);
            RETAINED = r101;
            DeliveryResult r102 = new DeliveryResult("RETRYABLE_FAILED", 2);
            RETRYABLE_FAILED = r102;
            DeliveryResult r103 = new DeliveryResult("FINAL_FAILED", 3);
            FINAL_FAILED = r103;
            DeliveryResult r104 = new DeliveryResult("CANCELLED", 4);
            CANCELLED = r104;
            f204496a = new DeliveryResult[]{r100, r101, r102, r103, r104};
        }

        public static DeliveryResult[] values() {
            return (DeliveryResult[]) f204496a.clone();
        }

        public static DeliveryResult valueOf(String r100) {
            return (DeliveryResult) r27.a.a(DeliveryResult.class, r100);
        }

        public DeliveryResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f204497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f204498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f204500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f204501e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f204502f;

        public a(int r100, String r101, int r102, int r103, int r104, String r105, long r106) {
            this.f204497a = r100;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            this.f204498b = r101;
            this.f204499c = r102;
            this.f204500d = r103;
            this.f204501e = r104;
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            this.f204502f = r105;
        }
    }

    String a(b.d r100);

    DeliveryResult b(String r100, b.d r101, PolarisFileWrapper r102) throws Exception;

    void c(String r100, b.d r101, PolarisFileWrapper r102);

    void d(String r100, b.f r101);

    void e(String r100, a r101);

    void f();
}
