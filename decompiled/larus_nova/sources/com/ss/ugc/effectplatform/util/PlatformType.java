package com.ss.ugc.effectplatform.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/ugc/effectplatform/util/PlatformType;", "", "ANDROID", "IOS", "PC", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final enum PlatformType extends Enum<PlatformType> {
    public static final PlatformType ANDROID = null;
    public static final PlatformType IOS = null;
    public static final PlatformType PC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformType[] f458023a = null;

    static {
        PlatformType r100 = new PlatformType("ANDROID", 0);
        ANDROID = r100;
        PlatformType r101 = new PlatformType("IOS", 1);
        IOS = r101;
        PlatformType r102 = new PlatformType("PC", 2);
        PC = r102;
        f458023a = new PlatformType[]{r100, r101, r102};
    }

    public static PlatformType valueOf(String r100) {
        return (PlatformType) r27.a.a(PlatformType.class, r100);
    }

    public static PlatformType[] values() {
        return (PlatformType[]) f458023a.clone();
    }

    public PlatformType(String r100, int r101) {
        super(r100, r101);
    }
}
