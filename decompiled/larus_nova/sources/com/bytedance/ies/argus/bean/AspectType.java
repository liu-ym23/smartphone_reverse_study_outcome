package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectType;", "", "UN_SET", "CONTAINER", "VIEW", "GLOBAL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AspectType extends Enum<AspectType> {
    public static final AspectType CONTAINER = null;
    public static final AspectType GLOBAL = null;
    public static final AspectType UN_SET = null;
    public static final AspectType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AspectType[] f246007a = null;

    public static AspectType valueOf(String r100) {
        return (AspectType) r27.a.a(AspectType.class, r100);
    }

    public static AspectType[] values() {
        return (AspectType[]) f246007a.clone();
    }

    static {
        AspectType r100 = new AspectType("UN_SET", 0);
        UN_SET = r100;
        AspectType r101 = new AspectType("CONTAINER", 1);
        CONTAINER = r101;
        AspectType r102 = new AspectType("VIEW", 2);
        VIEW = r102;
        AspectType r103 = new AspectType("GLOBAL", 3);
        GLOBAL = r103;
        f246007a = new AspectType[]{r100, r101, r102, r103};
    }

    public AspectType(String r100, int r101) {
        super(r100, r101);
    }
}
