package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: classes33.dex */
public final class ParamsValidator {
    public ParamsValidator() {
    }

    public static boolean validate(HarMonitorParams r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.stateVoteWindowSize > 0) goto L9;
        return false;
    L9:
        if (r100.accStateMonitorWindow > 0) goto L11;
    L15:
        return false;
    L11:
        if (r100.runningStateMonitorWindow <= 0) goto L15;
        return true;
    }
}
