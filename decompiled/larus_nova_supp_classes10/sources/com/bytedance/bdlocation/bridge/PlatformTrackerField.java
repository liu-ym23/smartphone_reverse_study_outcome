package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    public PlatformTrackerField(String r1, int r2, long r3, double r5, boolean r7, String r8) {
        this.key = r1;
        this.kind = r2;
        this.intValue = r3;
        this.doubleValue = r5;
        this.boolValue = r7;
        this.stringValue = r8;
    }
}
