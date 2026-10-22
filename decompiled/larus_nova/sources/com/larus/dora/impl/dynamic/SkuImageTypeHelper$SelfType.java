package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/SkuImageTypeHelper$SelfType;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_E", "LITE", "H_FREE_CLIP", "H_FREE_PRO", "H_FREE_BUDS_PRO", "H_FREE_CLIP_HE", "GUITAR", "DOLPHIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkuImageTypeHelper$SelfType extends Enum<SkuImageTypeHelper$SelfType> {
    public static final SkuImageTypeHelper$SelfType DOLPHIN = null;
    public static final SkuImageTypeHelper$SelfType DORA_E = null;
    public static final SkuImageTypeHelper$SelfType GUITAR = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_BUDS_PRO = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_CLIP = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_CLIP_HE = null;
    public static final SkuImageTypeHelper$SelfType H_FREE_PRO = null;
    public static final SkuImageTypeHelper$SelfType LITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkuImageTypeHelper$SelfType[] f335139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335140b = null;

    public static EnumEntries<SkuImageTypeHelper$SelfType> getEntries() {
        return f335140b;
    }

    static {
        SkuImageTypeHelper$SelfType r100 = new SkuImageTypeHelper$SelfType("DORA_E", 0);
        DORA_E = r100;
        SkuImageTypeHelper$SelfType r101 = new SkuImageTypeHelper$SelfType("LITE", 1);
        LITE = r101;
        SkuImageTypeHelper$SelfType r102 = new SkuImageTypeHelper$SelfType("H_FREE_CLIP", 2);
        H_FREE_CLIP = r102;
        SkuImageTypeHelper$SelfType r103 = new SkuImageTypeHelper$SelfType("H_FREE_PRO", 3);
        H_FREE_PRO = r103;
        SkuImageTypeHelper$SelfType r104 = new SkuImageTypeHelper$SelfType("H_FREE_BUDS_PRO", 4);
        H_FREE_BUDS_PRO = r104;
        SkuImageTypeHelper$SelfType r105 = new SkuImageTypeHelper$SelfType("H_FREE_CLIP_HE", 5);
        H_FREE_CLIP_HE = r105;
        SkuImageTypeHelper$SelfType r110 = new SkuImageTypeHelper$SelfType("GUITAR", 6);
        GUITAR = r110;
        SkuImageTypeHelper$SelfType r111 = new SkuImageTypeHelper$SelfType("DOLPHIN", 7);
        DOLPHIN = r111;
        SkuImageTypeHelper$SelfType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f335139a = r112;
        f335140b = EnumEntriesKt.enumEntries(r112);
    }

    public static SkuImageTypeHelper$SelfType[] values() {
        return (SkuImageTypeHelper$SelfType[]) f335139a.clone();
    }

    public static SkuImageTypeHelper$SelfType valueOf(String r100) {
        return (SkuImageTypeHelper$SelfType) r27.a.a(SkuImageTypeHelper$SelfType.class, r100);
    }

    public SkuImageTypeHelper$SelfType(String r100, int r101) {
        super(r100, r101);
    }
}
