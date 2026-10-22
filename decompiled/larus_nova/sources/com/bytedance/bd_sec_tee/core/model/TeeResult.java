package com.bytedance.bd_sec_tee.core.model;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.bd_sec_tee.core.TeeProvider;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final class TeeResult<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TeeProvider.TeeStage f199577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f199578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f199580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f199581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f199582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ResultType f199583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f199584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final KeySource f199585i;

    public static final enum KeySource extends Enum<KeySource> {
        public static final KeySource ANDROID_KEYSTORE = null;
        public static final KeySource DISK = null;
        public static final KeySource EXTERNAL = null;
        public static final KeySource MEMORY = null;
        public static final KeySource SYSTAM = null;
        public static final KeySource SYSTAM_AGAIN = null;
        public static final KeySource SYSTAM_SELF = null;
        public static final KeySource SYSTAM_SEPRATED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeySource[] f199586a = null;
        public final String source;

        static {
            KeySource r100 = new KeySource("MEMORY", 0, "memory");
            MEMORY = r100;
            KeySource r101 = new KeySource("EXTERNAL", 1, "external");
            EXTERNAL = r101;
            KeySource r102 = new KeySource("DISK", 2, UploadTypeInf.DISK);
            DISK = r102;
            KeySource r103 = new KeySource("ANDROID_KEYSTORE", 3, "android_keystore");
            ANDROID_KEYSTORE = r103;
            KeySource r104 = new KeySource("SYSTAM_AGAIN", 4, "api_again");
            SYSTAM_AGAIN = r104;
            KeySource r105 = new KeySource("SYSTAM_SELF", 5, "api_self");
            SYSTAM_SELF = r105;
            KeySource r110 = new KeySource("SYSTAM_SEPRATED", 6, "api_seprated");
            SYSTAM_SEPRATED = r110;
            KeySource r111 = new KeySource("SYSTAM", 7, "api");
            SYSTAM = r111;
            f199586a = new KeySource[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static KeySource[] values() {
            return (KeySource[]) f199586a.clone();
        }

        public static KeySource valueOf(String r100) {
            return (KeySource) a.a(KeySource.class, r100);
        }

        public KeySource(String r100, int r101, String r102) {
            super(r100, r101);
            this.source = r102;
        }
    }

    public static final enum ResultType extends Enum<ResultType> {
        public static final ResultType KEYPAIR_ERROR = null;
        public static final ResultType KEYPAIR_NEW = null;
        public static final ResultType KEYPAIR_SUCCESS = null;
        public static final ResultType PUB_COMPARE_EQUAL = null;
        public static final ResultType PUB_COMPARE_NOT_EQUAL = null;
        public static final ResultType SECRET_DERIVE_FAIL = null;
        public static final ResultType SECRET_DERIVE_SUCCESS = null;
        public static final ResultType SIGN_EQUAL = null;
        public static final ResultType SIGN_NEW = null;
        public static final ResultType SIGN_NOT_EQUAL = null;
        public static final ResultType VERIFY_FAIL = null;
        public static final ResultType VERIFY_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResultType[] f199587a = null;
        public final int code;

        static {
            ResultType r100 = new ResultType("KEYPAIR_SUCCESS", 0, 0);
            KEYPAIR_SUCCESS = r100;
            ResultType r101 = new ResultType("KEYPAIR_ERROR", 1, 1);
            KEYPAIR_ERROR = r101;
            ResultType r102 = new ResultType("KEYPAIR_NEW", 2, 2);
            KEYPAIR_NEW = r102;
            ResultType r103 = new ResultType("PUB_COMPARE_NOT_EQUAL", 3, 3);
            PUB_COMPARE_NOT_EQUAL = r103;
            ResultType r104 = new ResultType("PUB_COMPARE_EQUAL", 4, 4);
            PUB_COMPARE_EQUAL = r104;
            ResultType r105 = new ResultType("SECRET_DERIVE_SUCCESS", 5, 5);
            SECRET_DERIVE_SUCCESS = r105;
            ResultType r110 = new ResultType("SECRET_DERIVE_FAIL", 6, 6);
            SECRET_DERIVE_FAIL = r110;
            ResultType r111 = new ResultType("SIGN_NEW", 7, 7);
            SIGN_NEW = r111;
            ResultType r112 = new ResultType("SIGN_EQUAL", 8, 8);
            SIGN_EQUAL = r112;
            ResultType r113 = new ResultType("SIGN_NOT_EQUAL", 9, 9);
            SIGN_NOT_EQUAL = r113;
            ResultType r114 = new ResultType("VERIFY_SUCCESS", 10, 10);
            VERIFY_SUCCESS = r114;
            ResultType r115 = new ResultType("VERIFY_FAIL", 11, 11);
            VERIFY_FAIL = r115;
            f199587a = new ResultType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static ResultType[] values() {
            return (ResultType[]) f199587a.clone();
        }

        public static ResultType valueOf(String r100) {
            return (ResultType) a.a(ResultType.class, r100);
        }

        public ResultType(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public final String toString() {
        return "TeeResult{stage=" + this.f199577a + ", data=" + this.f199578b + ", errorCode=" + this.f199579c + ", errorMsg='" + this.f199580d + "', elapsedMs=" + this.f199581e + ", tagAlias='" + this.f199582f + "', result=" + this.f199583g + ", retryCount=" + this.f199584h + ", keySource='" + this.f199585i + "'}";
    }

    public static <T> TeeResult<T> a(TeeProvider.TeeStage r110, int r111, String r112, long r113, String r114, ResultType r115) {
        return new TeeResult(r110, null, r111, r112, r113, r114, r115, 0, null);
    }

    public static TeeResult c(TeeProvider.TeeStage r110, Object r111, long r112, ResultType r113, int r114, KeySource r115) {
        return new TeeResult(r110, r111, 0, "", r112, "sec_tee_key_v1", r113, r114, r115);
    }

    public static <T> TeeResult<T> d(TeeProvider.TeeStage r110, T r111, long r112, String r113, ResultType r114, KeySource r115) {
        return new TeeResult(r110, r111, 0, "", r112, r113, r114, 0, r115);
    }

    public static <T> TeeResult<T> b(TeeProvider.TeeStage r110, int r111, String r112, long r113, String r114, ResultType r115, int r116, KeySource r210) {
        return new TeeResult(r110, null, r111, r112, r113, r114, r115, r116, r210);
    }

    public TeeResult(TeeProvider.TeeStage r100, T r101, int r102, String r103, long r104, String r105, ResultType r106, int r107, KeySource r110) {
        this.f199577a = r100;
        this.f199578b = r101;
        this.f199579c = r102;
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        this.f199580d = r103;
        this.f199581e = r104;
        this.f199582f = r105;
        this.f199583g = r106;
        this.f199584h = r107;
        this.f199585i = r110;
    }
}
