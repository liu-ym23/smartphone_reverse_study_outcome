package com.hihonor.mcs.system.diagnosis.core.stability;

import java.io.Serializable;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class KilledMetric implements Serializable {
    private static final long serialVersionUID = 5440181629610360124L;
    private String appVersion;
    private String diagInfo;
    private long happenTime;
    private int pid;
    private String processName;
    private String trustStack;
    private KilledType type;

    public static final enum KilledType extends Enum<KilledType> {
        public static final KilledType EXCESSIVE_CPU = null;
        public static final KilledType KILL_SELF = null;
        public static final KilledType LOWMEM = null;
        public static final KilledType MEMORY_LEAK = null;
        public static final KilledType PERMISSION = null;
        public static final KilledType POWER_THERMAL = null;
        public static final KilledType SYSTEM_CLEAN = null;
        public static final KilledType USER_MANUAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KilledType[] f276667a = null;

        static {
            KilledType r100 = new KilledType("EXCESSIVE_CPU", 0);
            EXCESSIVE_CPU = r100;
            KilledType r101 = new KilledType("LOWMEM", 1);
            LOWMEM = r101;
            KilledType r102 = new KilledType("MEMORY_LEAK", 2);
            MEMORY_LEAK = r102;
            KilledType r103 = new KilledType("POWER_THERMAL", 3);
            POWER_THERMAL = r103;
            KilledType r104 = new KilledType("PERMISSION", 4);
            PERMISSION = r104;
            KilledType r105 = new KilledType("SYSTEM_CLEAN", 5);
            SYSTEM_CLEAN = r105;
            KilledType r110 = new KilledType("USER_MANUAL", 6);
            USER_MANUAL = r110;
            KilledType r111 = new KilledType("KILL_SELF", 7);
            KILL_SELF = r111;
            f276667a = new KilledType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public KilledType(String r100, int r101) {
            super(r100, r101);
        }

        public static KilledType valueOf(String r100) {
            return (KilledType) a.a(KilledType.class, r100);
        }

        public static KilledType[] values() {
            return (KilledType[]) f276667a.clone();
        }
    }

    public KilledMetric() {
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

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getTrustStack() {
        return this.trustStack;
    }

    public KilledType getType() {
        return this.type;
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

    public void setPid(int r100) {
        this.pid = r100;
    }

    public void setProcessName(String r100) {
        this.processName = r100;
    }

    public void setReason(KilledType r100) {
        this.type = r100;
    }

    public void setTrustStack(String r100) {
        this.trustStack = r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("KilledMetric{appVersion='");
        r100.append(this.appVersion);
        r100.append("', diagInfo='");
        r100.append(this.diagInfo);
        r100.append("', happenTime=");
        r100.append(this.happenTime);
        r100.append(", pid=");
        r100.append(this.pid);
        r100.append(", processName='");
        r100.append(this.processName);
        r100.append("', type=");
        KilledType r101 = this.type;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(", trustStack='");
        r100.append(this.trustStack);
        r100.append("'}");
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }
}
