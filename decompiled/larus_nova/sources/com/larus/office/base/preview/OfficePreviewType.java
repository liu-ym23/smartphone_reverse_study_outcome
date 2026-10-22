package com.larus.office.base.preview;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/office/base/preview/OfficePreviewType;", "", "routeType", "", "previewTypeValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getRouteType", "()Ljava/lang/String;", "getPreviewTypeValue", "()I", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "SHEETS", "SLIDES", "BITABLE", "FILE", "WIKI", "UNKNOWN", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficePreviewType extends Enum<OfficePreviewType> {
    public static final OfficePreviewType BITABLE = null;
    public static final OfficePreviewType DOCX = null;
    public static final OfficePreviewType FILE = null;
    public static final OfficePreviewType SHEETS = null;
    public static final OfficePreviewType SLIDES = null;
    public static final OfficePreviewType UNKNOWN = null;
    public static final OfficePreviewType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficePreviewType[] f361014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f361015b = null;
    private final int previewTypeValue;
    private final String routeType;

    public static EnumEntries<OfficePreviewType> getEntries() {
        return f361015b;
    }

    static {
        OfficePreviewType r100 = new OfficePreviewType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, DocumentType.DOCX_NAME, 22);
        DOCX = r100;
        OfficePreviewType r101 = new OfficePreviewType("SHEETS", 1, "sheets", 3);
        SHEETS = r101;
        OfficePreviewType r102 = new OfficePreviewType("SLIDES", 2, "slides", 30);
        SLIDES = r102;
        OfficePreviewType r103 = new OfficePreviewType("BITABLE", 3, "base", 8);
        BITABLE = r103;
        OfficePreviewType r104 = new OfficePreviewType("FILE", 4, "file", 12);
        FILE = r104;
        OfficePreviewType r105 = new OfficePreviewType("WIKI", 5, "wiki", 16);
        WIKI = r105;
        OfficePreviewType r110 = new OfficePreviewType("UNKNOWN", 6, "unknown", -1);
        UNKNOWN = r110;
        OfficePreviewType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f361014a = r111;
        f361015b = EnumEntriesKt.enumEntries(r111);
    }

    public static OfficePreviewType[] values() {
        return (OfficePreviewType[]) f361014a.clone();
    }

    public final int getPreviewTypeValue() {
        return this.previewTypeValue;
    }

    public final String getRouteType() {
        return this.routeType;
    }

    public static OfficePreviewType valueOf(String r100) {
        return (OfficePreviewType) r27.a.a(OfficePreviewType.class, r100);
    }

    public OfficePreviewType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.routeType = r102;
        this.previewTypeValue = r103;
    }
}
