package com.bytedance.ies.xbridge.event;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/xbridge/event/AppEvent;", "", "", "active", "unActive", "", "isActive", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "Z", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "KeyboardStatusChange", "SystemBack", "LoginStatusChange", "AppStatusChange", "GeckoResourceUpdated", "OnHeadSetPlug", "MemoryWarning", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AppEvent extends Enum<AppEvent> {
    public static final AppEvent AppStatusChange = null;
    public static final a Companion = null;
    public static final AppEvent GeckoResourceUpdated = null;
    public static final AppEvent KeyboardStatusChange = null;
    public static final AppEvent LoginStatusChange = null;
    public static final AppEvent MemoryWarning = null;
    public static final AppEvent OnHeadSetPlug = null;
    public static final AppEvent SystemBack = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppEvent[] f249472a = null;
    private final String eventName;
    private boolean isActive;

    public static final class a {
        public a() {
        }
    }

    public static AppEvent valueOf(String r100) {
        return (AppEvent) r27.a.a(AppEvent.class, r100);
    }

    public static AppEvent[] values() {
        return (AppEvent[]) f249472a.clone();
    }

    public final void active() {
        this.isActive = true;
    }

    public final void unActive() {
        this.isActive = true;
    }

    static {
        AppEvent r100 = new AppEvent("KeyboardStatusChange", 0, "keyboardStatusChange");
        KeyboardStatusChange = r100;
        AppEvent r101 = new AppEvent("SystemBack", 1, "systemBack");
        SystemBack = r101;
        AppEvent r102 = new AppEvent("LoginStatusChange", 2, "loginStatusChange");
        LoginStatusChange = r102;
        AppEvent r103 = new AppEvent("AppStatusChange", 3, "appStatusChange");
        AppStatusChange = r103;
        AppEvent r104 = new AppEvent("GeckoResourceUpdated", 4, "geckoResourceUpdated");
        GeckoResourceUpdated = r104;
        AppEvent r105 = new AppEvent("OnHeadSetPlug", 5, "onHeadsetPlug");
        OnHeadSetPlug = r105;
        AppEvent r110 = new AppEvent("MemoryWarning", 6, "memoryWarning");
        MemoryWarning = r110;
        f249472a = new AppEvent[]{r100, r101, r102, r103, r104, r105, r110};
        Companion = new a();
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public AppEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventName = r102;
    }
}
