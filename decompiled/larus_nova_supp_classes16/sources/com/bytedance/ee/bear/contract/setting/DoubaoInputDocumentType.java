package com.bytedance.ee.bear.contract.setting;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/contract/setting/DoubaoInputDocumentType;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "SLIDES", "features-feature-gating-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoInputDocumentType extends Enum<DoubaoInputDocumentType> {
    public static final DoubaoInputDocumentType DOC = null;
    public static final DoubaoInputDocumentType SHEET = null;
    public static final DoubaoInputDocumentType SLIDES = null;
    public static final /* synthetic */ DoubaoInputDocumentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String configValue;

    public static EnumEntries<DoubaoInputDocumentType> getEntries() {
        return b;
    }

    static {
        DoubaoInputDocumentType r0 = new DoubaoInputDocumentType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, "doc");
        DOC = r0;
        DoubaoInputDocumentType r1 = new DoubaoInputDocumentType("SHEET", 1, "sheet");
        SHEET = r1;
        DoubaoInputDocumentType r2 = new DoubaoInputDocumentType("SLIDES", 2, "slides");
        SLIDES = r2;
        DoubaoInputDocumentType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DoubaoInputDocumentType[] values() {
        return (DoubaoInputDocumentType[]) a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static DoubaoInputDocumentType valueOf(String r1) {
        return (DoubaoInputDocumentType) a.a(DoubaoInputDocumentType.class, r1);
    }

    public DoubaoInputDocumentType(String r1, int r2, String r3) {
        super(r1, r2);
        this.configValue = r3;
    }
}
