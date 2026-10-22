package com.bytedance.apm6.cpu;

import android.os.Process;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CgroupFetcher {
    public static final int a = 0;

    public static final enum CGROUP_LEVEL extends Enum<CGROUP_LEVEL> {
        public static final CGROUP_LEVEL BACKGROUND = null;
        public static final CGROUP_LEVEL FOREGROUND = null;
        public static final CGROUP_LEVEL TOP_APP = null;
        public static final CGROUP_LEVEL UNKNOWN = null;
        public static final /* synthetic */ CGROUP_LEVEL[] a = null;
        private final int value;

        static {
            CGROUP_LEVEL r0 = new CGROUP_LEVEL("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            CGROUP_LEVEL r1 = new CGROUP_LEVEL("TOP_APP", 1, 0);
            TOP_APP = r1;
            CGROUP_LEVEL r2 = new CGROUP_LEVEL("FOREGROUND", 2, 1);
            FOREGROUND = r2;
            CGROUP_LEVEL r5 = new CGROUP_LEVEL("BACKGROUND", 3, 2);
            BACKGROUND = r5;
            a = new CGROUP_LEVEL[]{r0, r1, r2, r5};
        }

        public static CGROUP_LEVEL[] values() {
            return (CGROUP_LEVEL[]) a.clone();
        }

        public static CGROUP_LEVEL valueOf(int r1) {
            if (r1 == (-1)) goto L18;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L12;
            return UNKNOWN;
        L12:
            return BACKGROUND;
        L14:
            return FOREGROUND;
        L16:
            return TOP_APP;
        L18:
            return UNKNOWN;
        }

        public static CGROUP_LEVEL valueOf(String r1) {
            return (CGROUP_LEVEL) a.a(CGROUP_LEVEL.class, r1);
        }

        public CGROUP_LEVEL(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        a = Process.myPid();
    }
}
