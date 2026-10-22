package com.facebook.common.memory;

/* JADX INFO: loaded from: classes22.dex */
public final enum MemoryTrimType extends Enum<MemoryTrimType> {
    private static final /* synthetic */ MemoryTrimType[] $VALUES = null;
    public static final MemoryTrimType OnAppBackgrounded = null;
    public static final MemoryTrimType OnCloseToDalvikHeapLimit = null;
    public static final MemoryTrimType OnSystemLowMemoryWhileAppInBackground = null;
    public static final MemoryTrimType OnSystemLowMemoryWhileAppInForeground = null;
    public static final MemoryTrimType OnSystemMemoryCriticallyLowWhileAppInForeground = null;
    private double mSuggestedTrimRatio;

    static {
        MemoryTrimType r100 = new MemoryTrimType("OnCloseToDalvikHeapLimit", 0, 0.5d);
        OnCloseToDalvikHeapLimit = r100;
        MemoryTrimType r101 = new MemoryTrimType("OnSystemMemoryCriticallyLowWhileAppInForeground", 1, 1.0d);
        OnSystemMemoryCriticallyLowWhileAppInForeground = r101;
        MemoryTrimType r102 = new MemoryTrimType("OnSystemLowMemoryWhileAppInForeground", 2, 0.5d);
        OnSystemLowMemoryWhileAppInForeground = r102;
        MemoryTrimType r103 = new MemoryTrimType("OnSystemLowMemoryWhileAppInBackground", 3, 1.0d);
        OnSystemLowMemoryWhileAppInBackground = r103;
        MemoryTrimType r104 = new MemoryTrimType("OnAppBackgrounded", 4, 1.0d);
        OnAppBackgrounded = r104;
        $VALUES = new MemoryTrimType[]{r100, r101, r102, r103, r104};
    }

    public static MemoryTrimType[] values() {
        return (MemoryTrimType[]) $VALUES.clone();
    }

    public double getSuggestedTrimRatio() {
        return this.mSuggestedTrimRatio;
    }

    public static MemoryTrimType valueOf(String r100) {
        return (MemoryTrimType) Enum.valueOf(MemoryTrimType.class, r100);
    }

    private MemoryTrimType(String r100, int r101, double r102) {
        super(r100, r101);
        this.mSuggestedTrimRatio = r102;
    }
}
