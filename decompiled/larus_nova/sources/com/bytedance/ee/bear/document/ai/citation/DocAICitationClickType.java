package com.bytedance.ee.bear.document.ai.citation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationClickType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DeleteCurrent", "DeleteAll", "ReferenceOpen", "Close", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocAICitationClickType extends Enum<DocAICitationClickType> {
    public static final DocAICitationClickType Close = null;
    public static final DocAICitationClickType DeleteAll = null;
    public static final DocAICitationClickType DeleteCurrent = null;
    public static final DocAICitationClickType ReferenceOpen = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocAICitationClickType[] f218728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218729b = null;
    private final String type;

    public static EnumEntries<DocAICitationClickType> getEntries() {
        return f218729b;
    }

    static {
        DocAICitationClickType r100 = new DocAICitationClickType("DeleteCurrent", 0, "deleteCurrent");
        DeleteCurrent = r100;
        DocAICitationClickType r101 = new DocAICitationClickType("DeleteAll", 1, "deleteAll");
        DeleteAll = r101;
        DocAICitationClickType r102 = new DocAICitationClickType("ReferenceOpen", 2, "referenceOpen");
        ReferenceOpen = r102;
        DocAICitationClickType r103 = new DocAICitationClickType("Close", 3, "close");
        Close = r103;
        DocAICitationClickType[] r104 = {r100, r101, r102, r103};
        f218728a = r104;
        f218729b = EnumEntriesKt.enumEntries(r104);
    }

    public static DocAICitationClickType[] values() {
        return (DocAICitationClickType[]) f218728a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static DocAICitationClickType valueOf(String r100) {
        return (DocAICitationClickType) r27.a.a(DocAICitationClickType.class, r100);
    }

    public DocAICitationClickType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
