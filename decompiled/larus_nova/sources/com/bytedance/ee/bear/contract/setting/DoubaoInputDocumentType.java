package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/DoubaoInputDocumentType;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoInputDocumentType extends Enum<DoubaoInputDocumentType> {
    public static final DoubaoInputDocumentType DOC = null;
    public static final DoubaoInputDocumentType SHEET = null;
    public static final DoubaoInputDocumentType SLIDES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoInputDocumentType[] f217194a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f217195b = null;
    private final String configValue;

    public static EnumEntries<DoubaoInputDocumentType> getEntries() {
        return f217195b;
    }

    static {
        DoubaoInputDocumentType r100 = new DoubaoInputDocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, "doc");
        DOC = r100;
        DoubaoInputDocumentType r101 = new DoubaoInputDocumentType("SHEET", 1, DocumentType.SHEET_NAME);
        SHEET = r101;
        DoubaoInputDocumentType r102 = new DoubaoInputDocumentType("SLIDES", 2, "slides");
        SLIDES = r102;
        DoubaoInputDocumentType[] r103 = {r100, r101, r102};
        f217194a = r103;
        f217195b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoubaoInputDocumentType[] values() {
        return (DoubaoInputDocumentType[]) f217194a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static DoubaoInputDocumentType valueOf(String r100) {
        return (DoubaoInputDocumentType) a.a(DoubaoInputDocumentType.class, r100);
    }

    public DoubaoInputDocumentType(String r100, int r101, String r102) {
        super(r100, r101);
        this.configValue = r102;
    }
}
