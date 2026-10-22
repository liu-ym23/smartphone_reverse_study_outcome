package com.bytedance.ee.bear.bitable.card.model.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/enums/EItemViewSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "FAST_ADD_RECORD", "SUBMIT_MODE", "PAGE_FROM_SUBMIT_MODE", "PAGE_FROM_FAST_ADD", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EItemViewSceneType extends Enum<EItemViewSceneType> {
    public static final EItemViewSceneType FAST_ADD_RECORD = null;
    public static final EItemViewSceneType PAGE_FROM_FAST_ADD = null;
    public static final EItemViewSceneType PAGE_FROM_SUBMIT_MODE = null;
    public static final EItemViewSceneType SUBMIT_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EItemViewSceneType[] f207089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207090b = null;

    public static EnumEntries<EItemViewSceneType> getEntries() {
        return f207090b;
    }

    static {
        EItemViewSceneType r100 = new EItemViewSceneType("FAST_ADD_RECORD", 0);
        FAST_ADD_RECORD = r100;
        EItemViewSceneType r101 = new EItemViewSceneType("SUBMIT_MODE", 1);
        SUBMIT_MODE = r101;
        EItemViewSceneType r102 = new EItemViewSceneType("PAGE_FROM_SUBMIT_MODE", 2);
        PAGE_FROM_SUBMIT_MODE = r102;
        EItemViewSceneType r103 = new EItemViewSceneType("PAGE_FROM_FAST_ADD", 3);
        PAGE_FROM_FAST_ADD = r103;
        EItemViewSceneType[] r104 = {r100, r101, r102, r103};
        f207089a = r104;
        f207090b = EnumEntriesKt.enumEntries(r104);
    }

    public static EItemViewSceneType[] values() {
        return (EItemViewSceneType[]) f207089a.clone();
    }

    public static EItemViewSceneType valueOf(String r100) {
        return (EItemViewSceneType) a.a(EItemViewSceneType.class, r100);
    }

    public EItemViewSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
