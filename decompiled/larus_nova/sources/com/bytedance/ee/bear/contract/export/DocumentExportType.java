package com.bytedance.ee.bear.contract.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/contract/export/DocumentExportType;", "", "<init>", "(Ljava/lang/String;I)V", "WORD", "EXCEL", "PPTX", "PDF", "MARKDOWN", "TXT", "JPG_LONG", "IMAGE", "AUDIO", "UNKNOWN", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocumentExportType extends Enum<DocumentExportType> {
    public static final DocumentExportType AUDIO = null;
    public static final DocumentExportType EXCEL = null;
    public static final DocumentExportType IMAGE = null;
    public static final DocumentExportType JPG_LONG = null;
    public static final DocumentExportType MARKDOWN = null;
    public static final DocumentExportType PDF = null;
    public static final DocumentExportType PPTX = null;
    public static final DocumentExportType TXT = null;
    public static final DocumentExportType UNKNOWN = null;
    public static final DocumentExportType WORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocumentExportType[] f217051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f217052b = null;

    public static EnumEntries<DocumentExportType> getEntries() {
        return f217052b;
    }

    static {
        DocumentExportType r100 = new DocumentExportType("WORD", 0);
        WORD = r100;
        DocumentExportType r101 = new DocumentExportType("EXCEL", 1);
        EXCEL = r101;
        DocumentExportType r102 = new DocumentExportType("PPTX", 2);
        PPTX = r102;
        DocumentExportType r103 = new DocumentExportType("PDF", 3);
        PDF = r103;
        DocumentExportType r104 = new DocumentExportType("MARKDOWN", 4);
        MARKDOWN = r104;
        DocumentExportType r105 = new DocumentExportType("TXT", 5);
        TXT = r105;
        DocumentExportType r110 = new DocumentExportType("JPG_LONG", 6);
        JPG_LONG = r110;
        DocumentExportType r111 = new DocumentExportType("IMAGE", 7);
        IMAGE = r111;
        DocumentExportType r112 = new DocumentExportType("AUDIO", 8);
        AUDIO = r112;
        DocumentExportType r113 = new DocumentExportType("UNKNOWN", 9);
        UNKNOWN = r113;
        DocumentExportType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f217051a = r114;
        f217052b = EnumEntriesKt.enumEntries(r114);
    }

    public static DocumentExportType[] values() {
        return (DocumentExportType[]) f217051a.clone();
    }

    public static DocumentExportType valueOf(String r100) {
        return (DocumentExportType) a.a(DocumentExportType.class, r100);
    }

    public DocumentExportType(String r100, int r101) {
        super(r100, r101);
    }
}
