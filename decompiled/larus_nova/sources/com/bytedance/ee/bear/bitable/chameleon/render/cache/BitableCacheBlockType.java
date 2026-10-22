package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/chameleon/render/cache/BitableCacheBlockType;", "", "rustValue", "", "<init>", "(Ljava/lang/String;II)V", "getRustValue", "()I", "Unsupported", "Default", "Bitable", "LinkedDocx", "Dashboard", "Table", "supportsNativeMainPage", "", "getSupportsNativeMainPage", "()Z", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableCacheBlockType extends Enum<BitableCacheBlockType> {
    public static final BitableCacheBlockType Bitable = null;
    public static final a Companion = null;
    public static final BitableCacheBlockType Dashboard = null;
    public static final BitableCacheBlockType Default = null;
    public static final BitableCacheBlockType LinkedDocx = null;
    public static final BitableCacheBlockType Table = null;
    public static final BitableCacheBlockType Unsupported = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableCacheBlockType[] f209681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209682b = null;
    private final int rustValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BitableCacheBlockType> getEntries() {
        return f209682b;
    }

    static {
        BitableCacheBlockType r100 = new BitableCacheBlockType("Unsupported", 0, Integer.MIN_VALUE);
        Unsupported = r100;
        BitableCacheBlockType r101 = new BitableCacheBlockType("Default", 1, 0);
        Default = r101;
        BitableCacheBlockType r102 = new BitableCacheBlockType("Bitable", 2, 8);
        Bitable = r102;
        BitableCacheBlockType r103 = new BitableCacheBlockType("LinkedDocx", 3, 22);
        LinkedDocx = r103;
        BitableCacheBlockType r104 = new BitableCacheBlockType("Dashboard", 4, 36);
        Dashboard = r104;
        BitableCacheBlockType r105 = new BitableCacheBlockType("Table", 5, 83);
        Table = r105;
        BitableCacheBlockType[] r110 = {r100, r101, r102, r103, r104, r105};
        f209681a = r110;
        f209682b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static BitableCacheBlockType[] values() {
        return (BitableCacheBlockType[]) f209681a.clone();
    }

    public final boolean getSupportsNativeMainPage() {
        if (this != Default) goto L5;
    L8:
        return true;
    L5:
        if (this == Table) goto L8;
        return false;
    }

    public final int getRustValue() {
        return this.rustValue;
    }

    public static BitableCacheBlockType valueOf(String r100) {
        return (BitableCacheBlockType) r27.a.a(BitableCacheBlockType.class, r100);
    }

    public BitableCacheBlockType(String r100, int r101, int r102) {
        super(r100, r101);
        this.rustValue = r102;
    }
}
