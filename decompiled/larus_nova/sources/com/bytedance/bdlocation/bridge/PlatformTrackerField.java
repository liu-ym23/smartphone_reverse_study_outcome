package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
final class PlatformTrackerField {
    static final int KIND_BOOL = 2;
    static final int KIND_DOUBLE = 1;
    static final int KIND_INT = 0;
    static final int KIND_STRING = 3;
    final boolean boolValue;
    final double doubleValue;
    final long intValue;
    final String key;
    final int kind;
    final String stringValue;

    public PlatformTrackerField(String r100, int r101, long r102, double r103, boolean r104, String r105) {
        this.key = r100;
        this.kind = r101;
        this.intValue = r102;
        this.doubleValue = r103;
        this.boolValue = r104;
        this.stringValue = r105;
    }
}
