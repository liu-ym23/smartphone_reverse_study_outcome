package com.bytedance.crash;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;

/* JADX INFO: loaded from: classes15.dex */
public final enum CustomizeExceptionType extends Enum<CustomizeExceptionType> {
    public static final CustomizeExceptionType FD_TRACKER = null;
    public static final CustomizeExceptionType HEAP_TRACKER = null;
    public static final CustomizeExceptionType MAX = null;
    public static final CustomizeExceptionType PRIO_MONITOR = null;
    public static final CustomizeExceptionType REF_MONITOR = null;
    public static final CustomizeExceptionType TLS_MONITOR = null;
    public static final CustomizeExceptionType VM_MONITOR = null;
    public static final CustomizeExceptionType XASAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomizeExceptionType[] f203094a = null;
    private final String mName;

    static {
        CustomizeExceptionType r100 = new CustomizeExceptionType("XASAN", 0, "xasan");
        XASAN = r100;
        CustomizeExceptionType r101 = new CustomizeExceptionType("HEAP_TRACKER", 1, "heap_tracker");
        HEAP_TRACKER = r101;
        CustomizeExceptionType r102 = new CustomizeExceptionType("FD_TRACKER", 2, "fd_tracker");
        FD_TRACKER = r102;
        CustomizeExceptionType r103 = new CustomizeExceptionType("VM_MONITOR", 3, "vm_monitor");
        VM_MONITOR = r103;
        CustomizeExceptionType r104 = new CustomizeExceptionType("TLS_MONITOR", 4, "tls_monitor");
        TLS_MONITOR = r104;
        CustomizeExceptionType r105 = new CustomizeExceptionType("REF_MONITOR", 5, "ref_monitor");
        REF_MONITOR = r105;
        CustomizeExceptionType r110 = new CustomizeExceptionType("PRIO_MONITOR", 6, "priority_monitor");
        PRIO_MONITOR = r110;
        CustomizeExceptionType r111 = new CustomizeExceptionType("MAX", 7, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX);
        MAX = r111;
        f203094a = new CustomizeExceptionType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static CustomizeExceptionType[] values() {
        return (CustomizeExceptionType[]) f203094a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }

    public static CustomizeExceptionType getType(String r100) {
        return valueOf(r100.toUpperCase());
    L5:
        return MAX;
    }

    public static CustomizeExceptionType valueOf(String r100) {
        return (CustomizeExceptionType) r27.a.a(CustomizeExceptionType.class, r100);
    }

    public CustomizeExceptionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mName = r102;
    }
}
