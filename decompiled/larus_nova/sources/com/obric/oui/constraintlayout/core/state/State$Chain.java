package com.obric.oui.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final enum State$Chain extends Enum<State$Chain> {
    public static final State$Chain PACKED = null;
    public static final State$Chain SPREAD = null;
    public static final State$Chain SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Chain[] f399682a = null;
    public static Map<String, State$Chain> chainMap;
    public static Map<String, Integer> valueMap;

    static {
        State$Chain r100 = new State$Chain("SPREAD", 0);
        SPREAD = r100;
        State$Chain r101 = new State$Chain("SPREAD_INSIDE", 1);
        SPREAD_INSIDE = r101;
        State$Chain r102 = new State$Chain("PACKED", 2);
        PACKED = r102;
        f399682a = new State$Chain[]{r100, r101, r102};
        chainMap = new HashMap();
        valueMap = new HashMap();
        chainMap.put("packed", r102);
        chainMap.put("spread_inside", r101);
        chainMap.put("spread", r100);
        valueMap.put("packed", 2);
        valueMap.put("spread_inside", 1);
        valueMap.put("spread", 0);
    }

    public static State$Chain[] values() {
        return (State$Chain[]) f399682a.clone();
    }

    public static State$Chain getChainByString(String r100) {
        if (chainMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        return chainMap.get(r100);
    }

    public static int getValueByString(String r100) {
        if (valueMap.containsKey(r100) == true) goto L5;
        return -1;
    L5:
        return valueMap.get(r100).intValue();
    }

    public static State$Chain valueOf(String r100) {
        return (State$Chain) r27.a.a(State$Chain.class, r100);
    }

    public State$Chain(String r100, int r101) {
        super(r100, r101);
    }
}
