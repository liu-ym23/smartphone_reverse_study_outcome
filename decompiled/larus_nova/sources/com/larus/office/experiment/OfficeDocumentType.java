package com.larus.office.experiment;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/office/experiment/OfficeDocumentType;", "", "value", "", "type", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getType", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "BITABLE", "FILE", "WIKI", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "SLIDES", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum OfficeDocumentType extends Enum<OfficeDocumentType> {
    public static final OfficeDocumentType BITABLE = null;
    public static final OfficeDocumentType DOC = null;
    public static final OfficeDocumentType DOCX = null;
    public static final OfficeDocumentType FILE = null;
    public static final OfficeDocumentType SHEET = null;
    public static final OfficeDocumentType SLIDES = null;
    public static final OfficeDocumentType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeDocumentType[] f362169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f362170b = null;
    private final String type;
    private final int value;

    public static EnumEntries<OfficeDocumentType> getEntries() {
        return f362170b;
    }

    static {
        OfficeDocumentType r100 = new OfficeDocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, 2, DocumentType.DOCX_NAME);
        DOC = r100;
        OfficeDocumentType r101 = new OfficeDocumentType("SHEET", 1, 3, DocumentType.SHEET_NAME);
        SHEET = r101;
        OfficeDocumentType r102 = new OfficeDocumentType("BITABLE", 2, 8, DocumentType.BITABLE_NAME);
        BITABLE = r102;
        OfficeDocumentType r103 = new OfficeDocumentType("FILE", 3, 12, "file");
        FILE = r103;
        OfficeDocumentType r104 = new OfficeDocumentType("WIKI", 4, 16, "wiki");
        WIKI = r104;
        OfficeDocumentType r110 = new OfficeDocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 5, 22, DocumentType.DOCX_NAME);
        DOCX = r110;
        OfficeDocumentType r105 = new OfficeDocumentType("SLIDES", 6, 30, "slides");
        SLIDES = r105;
        OfficeDocumentType[] r111 = {r100, r101, r102, r103, r104, r110, r105};
        f362169a = r111;
        f362170b = EnumEntriesKt.enumEntries(r111);
    }

    public static OfficeDocumentType[] values() {
        return (OfficeDocumentType[]) f362169a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public static OfficeDocumentType valueOf(String r100) {
        return (OfficeDocumentType) r27.a.a(OfficeDocumentType.class, r100);
    }

    public OfficeDocumentType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.type = r103;
    }
}
