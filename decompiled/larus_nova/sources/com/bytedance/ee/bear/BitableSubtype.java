package com.bytedance.ee.bear;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/BitableSubtype;", "", "type", "", "typeName", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getTypeName", "()Ljava/lang/String;", "BASE", "APP", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableSubtype extends Enum<BitableSubtype> {
    public static final BitableSubtype APP = null;
    public static final BitableSubtype BASE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableSubtype[] f206176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206177b = null;
    private final int type;
    private final String typeName;

    public static EnumEntries<BitableSubtype> getEntries() {
        return f206177b;
    }

    static {
        BitableSubtype r100 = new BitableSubtype("BASE", 0, 0, "base");
        BASE = r100;
        BitableSubtype r101 = new BitableSubtype("APP", 1, 1, "app");
        APP = r101;
        BitableSubtype[] r102 = {r100, r101};
        f206176a = r102;
        f206177b = EnumEntriesKt.enumEntries(r102);
    }

    public static BitableSubtype[] values() {
        return (BitableSubtype[]) f206176a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static BitableSubtype valueOf(String r100) {
        return (BitableSubtype) r27.a.a(BitableSubtype.class, r100);
    }

    public BitableSubtype(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.typeName = r103;
    }
}
