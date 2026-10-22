package com.obric.oui.constraintlayout.core.state;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final enum State$Wrap extends Enum<State$Wrap> {
    public static final State$Wrap ALIGNED = null;
    public static final State$Wrap CHAIN = null;
    public static final State$Wrap NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Wrap[] f399686a = null;
    public static Map<String, Integer> valueMap;
    public static Map<String, State$Wrap> wrapMap;

    static {
        State$Wrap r100 = new State$Wrap(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        State$Wrap r101 = new State$Wrap("CHAIN", 1);
        CHAIN = r101;
        State$Wrap r102 = new State$Wrap("ALIGNED", 2);
        ALIGNED = r102;
        f399686a = new State$Wrap[]{r100, r101, r102};
        wrapMap = new HashMap();
        valueMap = new HashMap();
        wrapMap.put("none", r100);
        wrapMap.put("chain", r101);
        wrapMap.put("aligned", r102);
        valueMap.put("none", 0);
        valueMap.put("chain", 3);
        valueMap.put("aligned", 2);
    }

    public static State$Wrap[] values() {
        return (State$Wrap[]) f399686a.clone();
    }

    public static State$Wrap getChainByString(String r100) {
        if (wrapMap.containsKey(r100) == true) goto L5;
        return null;
    L5:
        return wrapMap.get(r100);
    }

    public static int getValueByString(String r100) {
        if (valueMap.containsKey(r100) == true) goto L5;
        return -1;
    L5:
        return valueMap.get(r100).intValue();
    }

    public static State$Wrap valueOf(String r100) {
        return (State$Wrap) r27.a.a(State$Wrap.class, r100);
    }

    public State$Wrap(String r100, int r101) {
        super(r100, r101);
    }
}
