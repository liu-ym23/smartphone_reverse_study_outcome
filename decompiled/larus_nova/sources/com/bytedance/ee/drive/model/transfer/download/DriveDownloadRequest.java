package com.bytedance.ee.drive.model.transfer.download;

import com.bytedance.ee.drive.model.base.EDriveMountPoint;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveDownloadRequest {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f242664e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f242665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f242666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EDriveMountPoint f242667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f242668d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/download/DriveDownloadRequest$EApiType;", "", "", "numValue", "I", "getNumValue", "()I", "ORIGIN", "COVER", "PREVIEW", "IMG", "RANGE", "drive-model_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EApiType extends Enum<EApiType> {
        public static final EApiType COVER = null;
        public static final EApiType IMG = null;
        public static final EApiType ORIGIN = null;
        public static final EApiType PREVIEW = null;
        public static final EApiType RANGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EApiType[] f242669a = null;
        private final int numValue;

        public static EApiType valueOf(String r100) {
            return (EApiType) r27.a.a(EApiType.class, r100);
        }

        public static EApiType[] values() {
            return (EApiType[]) f242669a.clone();
        }

        static {
            EApiType r100 = new EApiType("ORIGIN", 0, 0);
            ORIGIN = r100;
            EApiType r101 = new EApiType("COVER", 1, 1);
            COVER = r101;
            EApiType r102 = new EApiType("PREVIEW", 2, 2);
            PREVIEW = r102;
            EApiType r103 = new EApiType("IMG", 3, 3);
            IMG = r103;
            EApiType r104 = new EApiType("RANGE", 4, 4);
            RANGE = r104;
            f242669a = new EApiType[]{r100, r101, r102, r103, r104};
        }

        public final int getNumValue() {
            return this.numValue;
        }

        public EApiType(String r100, int r101, int r102) {
            super(r100, r101);
            this.numValue = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public DriveDownloadRequest() {
        this.f242667c = EDriveMountPoint.UNKNOWN;
        EApiType r100 = EApiType.ORIGIN;
    }
}
