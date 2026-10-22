package com.hihonor.mcs.system.diagnosis.core.performance;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BasePerformanceMetric implements Serializable {
    private static final long serialVersionUID = 2956703571917806534L;
    private String appVersion;
    private long happenTime;
    private OperationType operationType;
    private OptSceneType optSceneType;
    private int pid;
    private String processName;

    public static final enum OperationType extends Enum<OperationType> {
        public static final OperationType JANK_OPT_TYPE_CLICK = null;
        public static final OperationType JANK_OPT_TYPE_DOWNING = null;
        public static final OperationType JANK_OPT_TYPE_LONG_PRESS = null;
        public static final OperationType JANK_OPT_TYPE_SLIDE_DOWN = null;
        public static final OperationType JANK_OPT_TYPE_SLIDE_LEFT = null;
        public static final OperationType JANK_OPT_TYPE_SLIDE_RIGHT = null;
        public static final OperationType JANK_OPT_TYPE_SLIDE_UP = null;
        public static final OperationType JANK_OPT_TYPE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OperationType[] f276656a = null;

        static {
            OperationType r100 = new OperationType("JANK_OPT_TYPE_CLICK", 0);
            JANK_OPT_TYPE_CLICK = r100;
            OperationType r101 = new OperationType("JANK_OPT_TYPE_LONG_PRESS", 1);
            JANK_OPT_TYPE_LONG_PRESS = r101;
            OperationType r102 = new OperationType("JANK_OPT_TYPE_SLIDE_UP", 2);
            JANK_OPT_TYPE_SLIDE_UP = r102;
            OperationType r103 = new OperationType("JANK_OPT_TYPE_SLIDE_DOWN", 3);
            JANK_OPT_TYPE_SLIDE_DOWN = r103;
            OperationType r104 = new OperationType("JANK_OPT_TYPE_SLIDE_LEFT", 4);
            JANK_OPT_TYPE_SLIDE_LEFT = r104;
            OperationType r105 = new OperationType("JANK_OPT_TYPE_SLIDE_RIGHT", 5);
            JANK_OPT_TYPE_SLIDE_RIGHT = r105;
            OperationType r110 = new OperationType("JANK_OPT_TYPE_DOWNING", 6);
            JANK_OPT_TYPE_DOWNING = r110;
            OperationType r111 = new OperationType("JANK_OPT_TYPE_UNKNOWN", 7);
            JANK_OPT_TYPE_UNKNOWN = r111;
            f276656a = new OperationType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public OperationType(String r100, int r101) {
            super(r100, r101);
        }

        public static OperationType valueOf(String r100) {
            return (OperationType) a.a(OperationType.class, r100);
        }

        public static OperationType[] values() {
            return (OperationType[]) f276656a.clone();
        }
    }

    public static final enum OptSceneType extends Enum<OptSceneType> {
        public static final OptSceneType ACTIVITY_BACK_IN_APP = null;
        public static final OptSceneType ACTIVITY_CHANGED_IN_APP = null;
        public static final OptSceneType ACTIVITY_CHANGING_IN_APP = null;
        public static final OptSceneType APP_BACK_TO_APP = null;
        public static final OptSceneType APP_BACK_TO_LAUNCHER = null;
        public static final OptSceneType APP_LAUNCHED_IN_APP = null;
        public static final OptSceneType APP_LAUNCHED_IN_LAUNCHER = null;
        public static final OptSceneType APP_LAUNCHING_IN_APP = null;
        public static final OptSceneType APP_LAUNCHING_IN_LAUNCHER = null;
        public static final OptSceneType OPT_SCENE_TYPE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OptSceneType[] f276657a = null;

        static {
            OptSceneType r100 = new OptSceneType("APP_LAUNCHING_IN_LAUNCHER", 0);
            APP_LAUNCHING_IN_LAUNCHER = r100;
            OptSceneType r101 = new OptSceneType("APP_LAUNCHED_IN_LAUNCHER", 1);
            APP_LAUNCHED_IN_LAUNCHER = r101;
            OptSceneType r102 = new OptSceneType("ACTIVITY_CHANGING_IN_APP", 2);
            ACTIVITY_CHANGING_IN_APP = r102;
            OptSceneType r103 = new OptSceneType("ACTIVITY_CHANGED_IN_APP", 3);
            ACTIVITY_CHANGED_IN_APP = r103;
            OptSceneType r104 = new OptSceneType("APP_LAUNCHING_IN_APP", 4);
            APP_LAUNCHING_IN_APP = r104;
            OptSceneType r105 = new OptSceneType("APP_LAUNCHED_IN_APP", 5);
            APP_LAUNCHED_IN_APP = r105;
            OptSceneType r110 = new OptSceneType("APP_BACK_TO_LAUNCHER", 6);
            APP_BACK_TO_LAUNCHER = r110;
            OptSceneType r111 = new OptSceneType("ACTIVITY_BACK_IN_APP", 7);
            ACTIVITY_BACK_IN_APP = r111;
            OptSceneType r112 = new OptSceneType("APP_BACK_TO_APP", 8);
            APP_BACK_TO_APP = r112;
            OptSceneType r113 = new OptSceneType("OPT_SCENE_TYPE_UNKNOWN", 9);
            OPT_SCENE_TYPE_UNKNOWN = r113;
            f276657a = new OptSceneType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public OptSceneType(String r100, int r101) {
            super(r100, r101);
        }

        public static OptSceneType valueOf(String r100) {
            return (OptSceneType) a.a(OptSceneType.class, r100);
        }

        public static OptSceneType[] values() {
            return (OptSceneType[]) f276657a.clone();
        }
    }

    public BasePerformanceMetric() {
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public abstract String getDiagInfo();

    public long getHappenTime() {
        return this.happenTime;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    public OptSceneType getOptSceneType() {
        return this.optSceneType;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setHappenTime(long r100) {
        this.happenTime = r100;
    }

    public void setOperationType(OperationType r100) {
        this.operationType = r100;
    }

    public void setOptSceneType(OptSceneType r100) {
        this.optSceneType = r100;
    }

    public void setPid(int r100) {
        this.pid = r100;
    }

    public void setProcessName(String r100) {
        this.processName = r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("BasePerformanceMetric{appVersion='");
        r100.append(this.appVersion);
        r100.append("', happenTime=");
        r100.append(this.happenTime);
        r100.append(", optSceneType=");
        OptSceneType r101 = this.optSceneType;
        String r102 = "";
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r100.append(r103);
        r100.append(", operationType=");
        OperationType r104 = this.operationType;
        if (r104 == null) goto L9;
        r102 = r104.toString();
    L9:
        r100.append(r102);
        r100.append(", pid=");
        r100.append(this.pid);
        r100.append(", processName='");
        r100.append(this.processName);
        r100.append("'}");
        return r100.toString();
    L5:
        r103 = "";
        goto L6
    }
}
