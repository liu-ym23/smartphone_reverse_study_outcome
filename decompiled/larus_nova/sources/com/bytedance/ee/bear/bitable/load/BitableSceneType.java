package com.bytedance.ee.bear.bitable.load;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/BitableSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "BaseApp", "MainDoc", "ShareRecord", "AddRecord", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableSceneType extends Enum<BitableSceneType> {
    public static final BitableSceneType AddRecord = null;
    public static final BitableSceneType BaseApp = null;
    public static final BitableSceneType MainDoc = null;
    public static final BitableSceneType ShareRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableSceneType[] f214461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214462b = null;

    public static EnumEntries<BitableSceneType> getEntries() {
        return f214462b;
    }

    static {
        BitableSceneType r100 = new BitableSceneType("BaseApp", 0);
        BaseApp = r100;
        BitableSceneType r101 = new BitableSceneType("MainDoc", 1);
        MainDoc = r101;
        BitableSceneType r102 = new BitableSceneType("ShareRecord", 2);
        ShareRecord = r102;
        BitableSceneType r103 = new BitableSceneType("AddRecord", 3);
        AddRecord = r103;
        BitableSceneType[] r104 = {r100, r101, r102, r103};
        f214461a = r104;
        f214462b = EnumEntriesKt.enumEntries(r104);
    }

    public static BitableSceneType[] values() {
        return (BitableSceneType[]) f214461a.clone();
    }

    public static BitableSceneType valueOf(String r100) {
        return (BitableSceneType) r27.a.a(BitableSceneType.class, r100);
    }

    public BitableSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
