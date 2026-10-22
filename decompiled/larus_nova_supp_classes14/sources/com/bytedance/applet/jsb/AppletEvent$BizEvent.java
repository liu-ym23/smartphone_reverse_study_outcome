package com.bytedance.applet.jsb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/jsb/AppletEvent$BizEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "NAVIGATION_STATUS_CHANGE", "AUDIO_PLAY_STATUS_CHANGE", "MUSIC_PLAY_STATUS_CHANGE", "MUSIC_ACTION_TRIGGERED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletEvent$BizEvent extends Enum<AppletEvent$BizEvent> {
    public static final AppletEvent$BizEvent AUDIO_PLAY_STATUS_CHANGE = null;
    public static final AppletEvent$BizEvent MUSIC_ACTION_TRIGGERED = null;
    public static final AppletEvent$BizEvent MUSIC_PLAY_STATUS_CHANGE = null;
    public static final AppletEvent$BizEvent NAVIGATION_STATUS_CHANGE = null;
    public static final /* synthetic */ AppletEvent$BizEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String eventName;

    public static EnumEntries<AppletEvent$BizEvent> getEntries() {
        return b;
    }

    static {
        AppletEvent$BizEvent r0 = new AppletEvent$BizEvent("NAVIGATION_STATUS_CHANGE", 0, "navigationStatus");
        NAVIGATION_STATUS_CHANGE = r0;
        AppletEvent$BizEvent r1 = new AppletEvent$BizEvent("AUDIO_PLAY_STATUS_CHANGE", 1, "audioPlayStatusChanged");
        AUDIO_PLAY_STATUS_CHANGE = r1;
        AppletEvent$BizEvent r2 = new AppletEvent$BizEvent("MUSIC_PLAY_STATUS_CHANGE", 2, "musicPlayStatusChanged");
        MUSIC_PLAY_STATUS_CHANGE = r2;
        AppletEvent$BizEvent r4 = new AppletEvent$BizEvent("MUSIC_ACTION_TRIGGERED", 3, "musicActionTriggered");
        MUSIC_ACTION_TRIGGERED = r4;
        AppletEvent$BizEvent[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static AppletEvent$BizEvent[] values() {
        return (AppletEvent$BizEvent[]) a.clone();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public static AppletEvent$BizEvent valueOf(String r1) {
        return (AppletEvent$BizEvent) r27.a.a(AppletEvent$BizEvent.class, r1);
    }

    public AppletEvent$BizEvent(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventName = r3;
    }
}
