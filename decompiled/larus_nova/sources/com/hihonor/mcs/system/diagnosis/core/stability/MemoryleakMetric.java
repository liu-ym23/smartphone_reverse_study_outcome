package com.hihonor.mcs.system.diagnosis.core.stability;

import java.io.Serializable;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryleakMetric implements Serializable {
    private static final long serialVersionUID = 3164385139394252514L;
    private String appVersion;
    private String diagInfo;
    private long happenTime;
    private MemoryLeakType leakType;
    private int memInc;
    private int memRatio;
    private int memTotal;
    private int pid;
    private String processName;
    private float slope;
    private int vss;

    public static final enum MemoryLeakType extends Enum<MemoryLeakType> {
        public static final MemoryLeakType DMABUF_MEMORY = null;
        public static final MemoryLeakType GPU_MEMORY = null;
        public static final MemoryLeakType JAVA_HEAP = null;
        public static final MemoryLeakType NATIVE_HEAP_DIRECT_MMAP = null;
        public static final MemoryLeakType NATIVE_HEAP_MALLOC = null;
        public static final MemoryLeakType RSS_MEMORY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MemoryLeakType[] f276668a = null;

        static {
            MemoryLeakType r100 = new MemoryLeakType("DMABUF_MEMORY", 0);
            DMABUF_MEMORY = r100;
            MemoryLeakType r101 = new MemoryLeakType("GPU_MEMORY", 1);
            GPU_MEMORY = r101;
            MemoryLeakType r102 = new MemoryLeakType("JAVA_HEAP", 2);
            JAVA_HEAP = r102;
            MemoryLeakType r103 = new MemoryLeakType("NATIVE_HEAP_DIRECT_MMAP", 3);
            NATIVE_HEAP_DIRECT_MMAP = r103;
            MemoryLeakType r104 = new MemoryLeakType("NATIVE_HEAP_MALLOC", 4);
            NATIVE_HEAP_MALLOC = r104;
            MemoryLeakType r105 = new MemoryLeakType("RSS_MEMORY", 5);
            RSS_MEMORY = r105;
            f276668a = new MemoryLeakType[]{r100, r101, r102, r103, r104, r105};
        }

        public MemoryLeakType(String r100, int r101) {
            super(r100, r101);
        }

        public static MemoryLeakType valueOf(String r100) {
            return (MemoryLeakType) a.a(MemoryLeakType.class, r100);
        }

        public static MemoryLeakType[] values() {
            return (MemoryLeakType[]) f276668a.clone();
        }
    }

    public MemoryleakMetric() {
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDiagInfo() {
        return this.diagInfo;
    }

    public long getHappenTime() {
        return this.happenTime;
    }

    public MemoryLeakType getLeakType() {
        return this.leakType;
    }

    public int getMemInc() {
        return this.memInc;
    }

    public int getMemRatio() {
        return this.memRatio;
    }

    public int getMemTotal() {
        return this.memTotal;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public float getSlope() {
        return this.slope;
    }

    public int getVss() {
        return this.vss;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setDiagInfo(JSONObject r100) {
        this.diagInfo = r100.toString();
    }

    public void setHappenTime(long r100) {
        this.happenTime = r100;
    }

    public void setLeakType(MemoryLeakType r100) {
        this.leakType = r100;
    }

    public void setMemInc(int r100) {
        this.memInc = r100;
    }

    public void setMemRatio(int r100) {
        this.memRatio = r100;
    }

    public void setMemTotal(int r100) {
        this.memTotal = r100;
    }

    public void setPid(int r100) {
        this.pid = r100;
    }

    public void setProcessName(String r100) {
        this.processName = r100;
    }

    public void setSlope(float r100) {
        this.slope = r100;
    }

    public void setVss(int r100) {
        this.vss = r100;
    }

    public String toString() {
        return "MemoryleakMetric{appVersion='" + this.appVersion + "', diagInfo='" + this.diagInfo + "', happenTime=" + this.happenTime + ", leakType=" + this.leakType + ", memInc=" + this.memInc + ", memRatio=" + this.memRatio + ", memTotal=" + this.memTotal + ", pid=" + this.pid + ", processName='" + this.processName + "', slope=" + this.slope + ", vss=" + this.vss + '}';
    }
}
