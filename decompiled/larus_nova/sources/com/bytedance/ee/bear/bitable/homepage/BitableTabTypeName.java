package com.bytedance.ee.bear.bitable.homepage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableTabTypeName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECOMMEND", "MINE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableTabTypeName extends Enum<BitableTabTypeName> {
    public static final BitableTabTypeName MINE = null;
    public static final BitableTabTypeName RECOMMEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableTabTypeName[] f212242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212243b = null;
    private final String value;

    public static EnumEntries<BitableTabTypeName> getEntries() {
        return f212243b;
    }

    static {
        BitableTabTypeName r100 = new BitableTabTypeName("RECOMMEND", 0, "feed");
        RECOMMEND = r100;
        BitableTabTypeName r101 = new BitableTabTypeName("MINE", 1, "my");
        MINE = r101;
        BitableTabTypeName[] r102 = {r100, r101};
        f212242a = r102;
        f212243b = EnumEntriesKt.enumEntries(r102);
    }

    public static BitableTabTypeName[] values() {
        return (BitableTabTypeName[]) f212242a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BitableTabTypeName valueOf(String r100) {
        return (BitableTabTypeName) r27.a.a(BitableTabTypeName.class, r100);
    }

    public BitableTabTypeName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
