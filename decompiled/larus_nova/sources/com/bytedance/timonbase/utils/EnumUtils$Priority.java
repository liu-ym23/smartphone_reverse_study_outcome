package com.bytedance.timonbase.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/timonbase/utils/EnumUtils$Priority", "", "Lcom/bytedance/timonbase/utils/EnumUtils$Priority;", "", "value", "I", "getValue", "()I", "LOW", "MIDDLE", "HIGH", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final enum EnumUtils$Priority extends Enum<EnumUtils$Priority> {
    public static final EnumUtils$Priority HIGH = null;
    public static final EnumUtils$Priority LOW = null;
    public static final EnumUtils$Priority MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumUtils$Priority[] f270901a = null;
    private final int value;

    static {
        EnumUtils$Priority r100 = new EnumUtils$Priority("LOW", 0, -10);
        LOW = r100;
        EnumUtils$Priority r101 = new EnumUtils$Priority("MIDDLE", 1, 0);
        MIDDLE = r101;
        EnumUtils$Priority r102 = new EnumUtils$Priority("HIGH", 2, 10);
        HIGH = r102;
        f270901a = new EnumUtils$Priority[]{r100, r101, r102};
    }

    public static EnumUtils$Priority valueOf(String r100) {
        return (EnumUtils$Priority) r27.a.a(EnumUtils$Priority.class, r100);
    }

    public static EnumUtils$Priority[] values() {
        return (EnumUtils$Priority[]) f270901a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EnumUtils$Priority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
