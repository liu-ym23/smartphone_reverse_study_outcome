package com.hihonor.mcs.system.diagnosis.core.powerthermal;

import java.io.Serializable;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class PowerThermalMetric implements Serializable {
    private static final long serialVersionUID = 5643728476404994202L;
    private String diagInfo;
    private long happenTime;
    private int pid;
    private PowerType powerType;

    public static final enum PowerType extends Enum<PowerType> {
        public static final PowerType ALARM = null;
        public static final PowerType AUTOSTART = null;
        public static final PowerType BT_SCAN = null;
        public static final PowerType CPU = null;
        public static final PowerType GNSS = null;
        public static final PowerType NETLOCATION = null;
        public static final PowerType NETWORK = null;
        public static final PowerType WAKELOCK = null;
        public static final PowerType WIFI_SCAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PowerType[] f276663a = null;

        static {
            PowerType r100 = new PowerType("CPU", 0);
            CPU = r100;
            PowerType r101 = new PowerType("WAKELOCK", 1);
            WAKELOCK = r101;
            PowerType r102 = new PowerType("GNSS", 2);
            GNSS = r102;
            PowerType r103 = new PowerType("ALARM", 3);
            ALARM = r103;
            PowerType r104 = new PowerType("BT_SCAN", 4);
            BT_SCAN = r104;
            PowerType r105 = new PowerType("WIFI_SCAN", 5);
            WIFI_SCAN = r105;
            PowerType r110 = new PowerType("NETWORK", 6);
            NETWORK = r110;
            PowerType r111 = new PowerType("NETLOCATION", 7);
            NETLOCATION = r111;
            PowerType r112 = new PowerType("AUTOSTART", 8);
            AUTOSTART = r112;
            f276663a = new PowerType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public PowerType(String r100, int r101) {
            super(r100, r101);
        }

        public static PowerType valueOf(String r100) {
            return (PowerType) a.a(PowerType.class, r100);
        }

        public static PowerType[] values() {
            return (PowerType[]) f276663a.clone();
        }
    }

    public PowerThermalMetric() {
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

    public PowerType getPowerType() {
        return this.powerType;
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

    public void setPowerType(PowerType r100) {
        this.powerType = r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PowerThermalMetric{diagInfo='");
        r100.append(this.diagInfo);
        r100.append("', happenTime=");
        r100.append(this.happenTime);
        r100.append(", pid=");
        r100.append(this.pid);
        r100.append(", powerType=");
        PowerType r101 = this.powerType;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }
}
