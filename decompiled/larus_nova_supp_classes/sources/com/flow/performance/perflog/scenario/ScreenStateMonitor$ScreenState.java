package com.flow.performance.perflog.scenario;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/flow/performance/perflog/scenario/ScreenStateMonitor$ScreenState;", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCREEN_ON", "SCREEN_OFF", "USER_PRESENT", "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final enum ScreenStateMonitor$ScreenState extends Enum<ScreenStateMonitor$ScreenState> {
    public static final ScreenStateMonitor$ScreenState SCREEN_OFF = null;
    public static final ScreenStateMonitor$ScreenState SCREEN_ON = null;
    public static final ScreenStateMonitor$ScreenState USER_PRESENT = null;
    public static final /* synthetic */ ScreenStateMonitor$ScreenState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ScreenStateMonitor$ScreenState> getEntries() {
        return b;
    }

    static {
        ScreenStateMonitor$ScreenState r0 = new ScreenStateMonitor$ScreenState("SCREEN_ON", 0, "SCREEN_ON");
        SCREEN_ON = r0;
        ScreenStateMonitor$ScreenState r1 = new ScreenStateMonitor$ScreenState("SCREEN_OFF", 1, "SCREEN_OFF");
        SCREEN_OFF = r1;
        ScreenStateMonitor$ScreenState r3 = new ScreenStateMonitor$ScreenState("USER_PRESENT", 2, "USER_PRESENT");
        USER_PRESENT = r3;
        ScreenStateMonitor$ScreenState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ScreenStateMonitor$ScreenState[] values() {
        return (ScreenStateMonitor$ScreenState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ScreenStateMonitor$ScreenState valueOf(String r1) {
        return (ScreenStateMonitor$ScreenState) a.a(ScreenStateMonitor$ScreenState.class, r1);
    }

    public ScreenStateMonitor$ScreenState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
