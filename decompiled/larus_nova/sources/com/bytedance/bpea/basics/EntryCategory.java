package com.bytedance.bpea.basics;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bpea/basics/EntryCategory;", "", "", "type", "I", "getType", "()I", "BPEA_ENTRY", "DIRECT_AUTH", "basics_release"}, k = 1, mv = {1, 4, 0})
public final enum EntryCategory extends Enum<EntryCategory> {
    public static final EntryCategory BPEA_ENTRY = null;
    public static final EntryCategory DIRECT_AUTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntryCategory[] f202178a = null;
    private final int type;

    static {
        EntryCategory r100 = new EntryCategory("BPEA_ENTRY", 0, 0);
        BPEA_ENTRY = r100;
        EntryCategory r101 = new EntryCategory("DIRECT_AUTH", 1, 1);
        DIRECT_AUTH = r101;
        f202178a = new EntryCategory[]{r100, r101};
    }

    public static EntryCategory valueOf(String r100) {
        return (EntryCategory) a.a(EntryCategory.class, r100);
    }

    public static EntryCategory[] values() {
        return (EntryCategory[]) f202178a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public EntryCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
