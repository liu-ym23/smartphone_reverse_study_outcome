package com.bytedance.apm6.cpu.collect;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CpuCacheItem {
    public final CpuDataType a;
    public double b;
    public double c;
    public double d;
    public double e;
    public String f;
    public final long g;
    public int h;

    public static final enum CpuDataType extends Enum<CpuDataType> {
        public static final CpuDataType BACK = null;
        public static final CpuDataType FRONT = null;
        public static final CpuDataType MIX = null;
        public static final /* synthetic */ CpuDataType[] a = null;

        static {
            CpuDataType r0 = new CpuDataType("MIX", 0);
            MIX = r0;
            CpuDataType r1 = new CpuDataType("FRONT", 1);
            FRONT = r1;
            CpuDataType r3 = new CpuDataType("BACK", 2);
            BACK = r3;
            a = new CpuDataType[]{r0, r1, r3};
        }

        public static CpuDataType[] values() {
            return (CpuDataType[]) a.clone();
        }

        public static CpuDataType valueOf(String r1) {
            return (CpuDataType) a.a(CpuDataType.class, r1);
        }

        public CpuDataType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final String toString() {
        return "CpuCacheItem{type=" + this.a + ", metricRate=" + this.b + ", metricMaxRate=" + this.c + ", metricCpuStats=" + this.d + ", metricMaxCpuStats=" + this.e + ", sceneString='" + this.f + "', firstTs=" + this.g + ", times=" + this.h + '}';
    }

    public CpuDataType getType() {
        return this.a;
    }

    public CpuCacheItem(CpuDataType r1, long r2) {
        this.a = r1;
        this.g = r2;
        this.h = 0;
    }
}
