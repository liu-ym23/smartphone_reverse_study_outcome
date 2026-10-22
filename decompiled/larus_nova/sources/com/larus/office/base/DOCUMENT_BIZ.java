package com.larus.office.base;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/office/base/DOCUMENT_BIZ;", "", "bizName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizName", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SLIDES", "SHEET", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DOCUMENT_BIZ extends Enum<DOCUMENT_BIZ> {
    public static final DOCUMENT_BIZ DOC = null;
    public static final DOCUMENT_BIZ SHEET = null;
    public static final DOCUMENT_BIZ SLIDES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DOCUMENT_BIZ[] f360436a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360437b = null;
    private final String bizName;

    public static EnumEntries<DOCUMENT_BIZ> getEntries() {
        return f360437b;
    }

    static {
        DOCUMENT_BIZ r100 = new DOCUMENT_BIZ(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, "doc");
        DOC = r100;
        DOCUMENT_BIZ r101 = new DOCUMENT_BIZ("SLIDES", 1, "slides");
        SLIDES = r101;
        DOCUMENT_BIZ r102 = new DOCUMENT_BIZ("SHEET", 2, DocumentType.SHEET_NAME);
        SHEET = r102;
        DOCUMENT_BIZ[] r103 = {r100, r101, r102};
        f360436a = r103;
        f360437b = EnumEntriesKt.enumEntries(r103);
    }

    public static DOCUMENT_BIZ[] values() {
        return (DOCUMENT_BIZ[]) f360436a.clone();
    }

    public final String getBizName() {
        return this.bizName;
    }

    public static DOCUMENT_BIZ valueOf(String r100) {
        return (DOCUMENT_BIZ) r27.a.a(DOCUMENT_BIZ.class, r100);
    }

    public DOCUMENT_BIZ(String r100, int r101, String r102) {
        super(r100, r101);
        this.bizName = r102;
    }
}
