package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class TESystemResManager {
    private boolean isInitialized;
    public ITESystemResourceStrategy mStrategy;

    public static class Action {
        public int timeout;
        public ActionType type;

        public Action(ActionType r100) {
            this.timeout = 0;
            this.type = r100;
        }

        public Action(ActionType r100, int r101) {
            this.type = r100;
            this.timeout = r101;
        }
    }

    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ActionType BOOST_CPU = null;
        public static final ActionType RESTORE_CPU = null;
        public static final ActionType UNKNOWN = null;

        private static /* synthetic */ ActionType[] $values() {
            return new ActionType[]{UNKNOWN, BOOST_CPU, RESTORE_CPU};
        }

        static {
            UNKNOWN = new ActionType("UNKNOWN", 0);
            BOOST_CPU = new ActionType("BOOST_CPU", 1);
            RESTORE_CPU = new ActionType("RESTORE_CPU", 2);
            $VALUES = $values();
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        private ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TESystemResManager() {
        this.isInitialized = false;
    }

    public void initStrategy(Context r100) {
        if (this.isInitialized == true) goto L9;
        ITESystemResourceStrategy r101 = this.mStrategy;
        if (r101 == null) goto L7;
        r101.init(r100);
    L7:
        this.isInitialized = true;
        return;
    }

    public void setStrategy(ITESystemResourceStrategy r100) {
        this.isInitialized = false;
        this.mStrategy = r100;
    }

    public void startAction(Action r100) {
        if (this.isInitialized == false) goto L13;
        ITESystemResourceStrategy r101 = this.mStrategy;
        if (r101 == null) goto L14;
        ActionType r102 = r100.type;
        if (r102 != ActionType.BOOST_CPU) goto L10;
        r101.boostCpuFreq(r100.timeout);
        return;
    L10:
        if (r102 != ActionType.RESTORE_CPU) goto L16;
        r101.restoreCpuFreq();
        return;
    L16:
        return;
    L14:
        return;
    }
}
