package com.bytedance.ee.bear.contract.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ DocumentExportType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DocumentExportType> getEntries() {
        return b;
    }

    static {
        DocumentExportType r0 = new DocumentExportType("WORD", 0);
        WORD = r0;
        DocumentExportType r1 = new DocumentExportType("EXCEL", 1);
        EXCEL = r1;
        DocumentExportType r3 = new DocumentExportType("PPTX", 2);
        PPTX = r3;
        DocumentExportType r5 = new DocumentExportType("PDF", 3);
        PDF = r5;
        DocumentExportType r7 = new DocumentExportType("MARKDOWN", 4);
        MARKDOWN = r7;
        DocumentExportType r9 = new DocumentExportType("TXT", 5);
        TXT = r9;
        DocumentExportType r11 = new DocumentExportType("JPG_LONG", 6);
        JPG_LONG = r11;
        DocumentExportType r13 = new DocumentExportType("IMAGE", 7);
        IMAGE = r13;
        DocumentExportType r16 = new DocumentExportType("AUDIO", 8);
        AUDIO = r16;
        DocumentExportType r14 = new DocumentExportType("UNKNOWN", 9);
        UNKNOWN = r14;
        DocumentExportType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r16, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static DocumentExportType[] values() {
        return (DocumentExportType[]) a.clone();
    }

    public static DocumentExportType valueOf(String r1) {
        return (DocumentExportType) a.a(DocumentExportType.class, r1);
    }

    public DocumentExportType(String r1, int r2) {
        super(r1, r2);
    }
}
