package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/viewmodel/CatalogMode;", "", "modeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getModeName", "()Ljava/lang/String;", "EMBED", "COVERAGE", "DIALOG", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CatalogMode extends Enum<CatalogMode> {
    public static final CatalogMode COVERAGE = null;
    public static final CatalogMode DIALOG = null;
    public static final CatalogMode EMBED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CatalogMode[] f218257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218258b = null;
    private final String modeName;

    public static EnumEntries<CatalogMode> getEntries() {
        return f218258b;
    }

    static {
        CatalogMode r100 = new CatalogMode("EMBED", 0, "embedded");
        EMBED = r100;
        CatalogMode r101 = new CatalogMode("COVERAGE", 1, "covered");
        COVERAGE = r101;
        CatalogMode r102 = new CatalogMode("DIALOG", 2, "dialog");
        DIALOG = r102;
        CatalogMode[] r103 = {r100, r101, r102};
        f218257a = r103;
        f218258b = EnumEntriesKt.enumEntries(r103);
    }

    public static CatalogMode[] values() {
        return (CatalogMode[]) f218257a.clone();
    }

    public final String getModeName() {
        return this.modeName;
    }

    public static CatalogMode valueOf(String r100) {
        return (CatalogMode) r27.a.a(CatalogMode.class, r100);
    }

    public CatalogMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.modeName = r102;
    }
}
