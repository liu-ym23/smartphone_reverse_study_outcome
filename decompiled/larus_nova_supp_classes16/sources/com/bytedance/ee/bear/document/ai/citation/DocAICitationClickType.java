package com.bytedance.ee.bear.document.ai.citation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationClickType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DeleteCurrent", "DeleteAll", "ReferenceOpen", "Close", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocAICitationClickType extends Enum<DocAICitationClickType> {
    public static final DocAICitationClickType Close = null;
    public static final DocAICitationClickType DeleteAll = null;
    public static final DocAICitationClickType DeleteCurrent = null;
    public static final DocAICitationClickType ReferenceOpen = null;
    public static final /* synthetic */ DocAICitationClickType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<DocAICitationClickType> getEntries() {
        return b;
    }

    static {
        DocAICitationClickType r0 = new DocAICitationClickType("DeleteCurrent", 0, "deleteCurrent");
        DeleteCurrent = r0;
        DocAICitationClickType r1 = new DocAICitationClickType("DeleteAll", 1, "deleteAll");
        DeleteAll = r1;
        DocAICitationClickType r2 = new DocAICitationClickType("ReferenceOpen", 2, "referenceOpen");
        ReferenceOpen = r2;
        DocAICitationClickType r4 = new DocAICitationClickType("Close", 3, "close");
        Close = r4;
        DocAICitationClickType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DocAICitationClickType[] values() {
        return (DocAICitationClickType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static DocAICitationClickType valueOf(String r1) {
        return (DocAICitationClickType) r27.a.a(DocAICitationClickType.class, r1);
    }

    public DocAICitationClickType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
