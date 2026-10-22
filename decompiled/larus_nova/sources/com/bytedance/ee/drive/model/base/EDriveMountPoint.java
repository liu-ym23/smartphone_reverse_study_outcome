package com.bytedance.ee.drive.model.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/drive/model/base/EDriveMountPoint;", "", "", "strName", "Ljava/lang/String;", "getStrName", "()Ljava/lang/String;", "UNKNOWN", "DOC_IMAGE", "DOCX_IMAGE", "SLIDES_IMAGE", "CCM_EXPORT", "drive-model_release"}, k = 1, mv = {1, 7, 1})
public final enum EDriveMountPoint extends Enum<EDriveMountPoint> {
    public static final EDriveMountPoint CCM_EXPORT = null;
    public static final EDriveMountPoint DOCX_IMAGE = null;
    public static final EDriveMountPoint DOC_IMAGE = null;
    public static final EDriveMountPoint SLIDES_IMAGE = null;
    public static final EDriveMountPoint UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EDriveMountPoint[] f242661a = null;
    private final String strName;

    public static EDriveMountPoint valueOf(String r100) {
        return (EDriveMountPoint) a.a(EDriveMountPoint.class, r100);
    }

    public static EDriveMountPoint[] values() {
        return (EDriveMountPoint[]) f242661a.clone();
    }

    static {
        EDriveMountPoint r100 = new EDriveMountPoint("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        EDriveMountPoint r101 = new EDriveMountPoint("DOC_IMAGE", 1, "doc_image");
        DOC_IMAGE = r101;
        EDriveMountPoint r102 = new EDriveMountPoint("DOCX_IMAGE", 2, "docx_image");
        DOCX_IMAGE = r102;
        EDriveMountPoint r103 = new EDriveMountPoint("SLIDES_IMAGE", 3, "slides_image");
        SLIDES_IMAGE = r103;
        EDriveMountPoint r104 = new EDriveMountPoint("CCM_EXPORT", 4, "ccm_export");
        CCM_EXPORT = r104;
        f242661a = new EDriveMountPoint[]{r100, r101, r102, r103, r104};
    }

    public final String getStrName() {
        return this.strName;
    }

    public EDriveMountPoint(String r100, int r101, String r102) {
        super(r100, r101);
        this.strName = r102;
    }
}
