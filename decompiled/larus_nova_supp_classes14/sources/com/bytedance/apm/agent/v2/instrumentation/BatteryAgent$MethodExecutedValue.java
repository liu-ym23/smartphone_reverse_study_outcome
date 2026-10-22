package com.bytedance.apm.agent.v2.instrumentation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BatteryAgent$MethodExecutedValue {
    private int cpuCost;
    private int exeCount;

    public String toString() {
        return "MethodExecutedValue{exeCount=" + this.exeCount + ", cpuCost=" + this.cpuCost + '}';
    }

    public BatteryAgent$MethodExecutedValue() {
        this.exeCount = 0;
        this.cpuCost = 0;
    }

    public int getCost() {
        return this.cpuCost;
    }

    public int getCount() {
        return this.exeCount;
    }

    public static /* synthetic */ int access$300(BatteryAgent$MethodExecutedValue r0) {
        return r0.cpuCost;
    }

    public void addValue(BatteryAgent$MethodExecutingValue r7) {
        this.exeCount += BatteryAgent$MethodExecutingValue.access$000(r7);
        this.cpuCost = (int) (((long) this.cpuCost) + (BatteryAgent$MethodExecutingValue.access$100(r7) - BatteryAgent$MethodExecutingValue.access$200(r7)));
    }
}
