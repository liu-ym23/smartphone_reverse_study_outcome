package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applet/debugger/DebuggerDebugChannelState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", "DISCONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebuggerDebugChannelState extends Enum<DebuggerDebugChannelState> {
    public static final DebuggerDebugChannelState CONNECTED = null;
    public static final DebuggerDebugChannelState DISCONNECTED = null;
    public static final /* synthetic */ DebuggerDebugChannelState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DebuggerDebugChannelState> getEntries() {
        return b;
    }

    static {
        DebuggerDebugChannelState r0 = new DebuggerDebugChannelState("CONNECTED", 0);
        CONNECTED = r0;
        DebuggerDebugChannelState r1 = new DebuggerDebugChannelState("DISCONNECTED", 1);
        DISCONNECTED = r1;
        DebuggerDebugChannelState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DebuggerDebugChannelState[] values() {
        return (DebuggerDebugChannelState[]) a.clone();
    }

    public static DebuggerDebugChannelState valueOf(String r1) {
        return (DebuggerDebugChannelState) r27.a.a(DebuggerDebugChannelState.class, r1);
    }

    public DebuggerDebugChannelState(String r1, int r2) {
        super(r1, r2);
    }
}
