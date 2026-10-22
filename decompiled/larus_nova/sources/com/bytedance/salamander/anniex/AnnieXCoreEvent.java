package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXCoreEvent;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "onPageShow", "onPageHide", "appBecomeActive", "appResignActive", "keyboardStatusChange", "screenOrientationChange", "screenFoldStateChange", "onUserCaptureScreen", "socketDataReceived", "socketStatusChanged", "memoryWarning", "onHeadsetPlug", "loginStatusChange", "onGyroscopeChange", "windowResize", "bulletOnBackPressAction", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXCoreEvent extends Enum<AnnieXCoreEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXCoreEvent[] f267820a = null;
    public static final AnnieXCoreEvent appBecomeActive = null;
    public static final AnnieXCoreEvent appResignActive = null;
    public static final AnnieXCoreEvent bulletOnBackPressAction = null;
    public static final AnnieXCoreEvent keyboardStatusChange = null;
    public static final AnnieXCoreEvent loginStatusChange = null;
    public static final AnnieXCoreEvent memoryWarning = null;
    public static final AnnieXCoreEvent onGyroscopeChange = null;
    public static final AnnieXCoreEvent onHeadsetPlug = null;
    public static final AnnieXCoreEvent onPageHide = null;
    public static final AnnieXCoreEvent onPageShow = null;
    public static final AnnieXCoreEvent onUserCaptureScreen = null;
    public static final AnnieXCoreEvent screenFoldStateChange = null;
    public static final AnnieXCoreEvent screenOrientationChange = null;
    public static final AnnieXCoreEvent socketDataReceived = null;
    public static final AnnieXCoreEvent socketStatusChanged = null;
    public static final AnnieXCoreEvent windowResize = null;
    private final String value;

    public static AnnieXCoreEvent valueOf(String r100) {
        return (AnnieXCoreEvent) r27.a.a(AnnieXCoreEvent.class, r100);
    }

    public static AnnieXCoreEvent[] values() {
        return (AnnieXCoreEvent[]) f267820a.clone();
    }

    static {
        AnnieXCoreEvent r100 = new AnnieXCoreEvent("onPageShow", 0, "onPageShow");
        onPageShow = r100;
        AnnieXCoreEvent r101 = new AnnieXCoreEvent("onPageHide", 1, "onPageHide");
        onPageHide = r101;
        AnnieXCoreEvent r102 = new AnnieXCoreEvent("appBecomeActive", 2, "appBecomeActive");
        appBecomeActive = r102;
        AnnieXCoreEvent r103 = new AnnieXCoreEvent("appResignActive", 3, "appResignActive");
        appResignActive = r103;
        AnnieXCoreEvent r104 = new AnnieXCoreEvent("keyboardStatusChange", 4, "keyboardStatusChange");
        keyboardStatusChange = r104;
        AnnieXCoreEvent r105 = new AnnieXCoreEvent("screenOrientationChange", 5, "screenOrientationChange");
        screenOrientationChange = r105;
        AnnieXCoreEvent r110 = new AnnieXCoreEvent("screenFoldStateChange", 6, "screenFoldStateChange");
        screenFoldStateChange = r110;
        AnnieXCoreEvent r111 = new AnnieXCoreEvent("onUserCaptureScreen", 7, "onUserCaptureScreen");
        onUserCaptureScreen = r111;
        AnnieXCoreEvent r112 = new AnnieXCoreEvent("socketDataReceived", 8, "x.socketDataReceived");
        socketDataReceived = r112;
        AnnieXCoreEvent r113 = new AnnieXCoreEvent("socketStatusChanged", 9, "x.socketStatusChanged");
        socketStatusChanged = r113;
        AnnieXCoreEvent r114 = new AnnieXCoreEvent("memoryWarning", 10, "memoryWarning");
        memoryWarning = r114;
        AnnieXCoreEvent r115 = new AnnieXCoreEvent("onHeadsetPlug", 11, "onHeadsetPlug");
        onHeadsetPlug = r115;
        AnnieXCoreEvent r106 = new AnnieXCoreEvent("loginStatusChange", 12, "loginStatusChange");
        loginStatusChange = r106;
        AnnieXCoreEvent r107 = new AnnieXCoreEvent("onGyroscopeChange", 13, "onGyroscopeChange");
        onGyroscopeChange = r107;
        AnnieXCoreEvent r108 = new AnnieXCoreEvent("windowResize", 14, "windowResize");
        windowResize = r108;
        AnnieXCoreEvent r109 = new AnnieXCoreEvent("bulletOnBackPressAction", 15, "bulletOnBackPressAction");
        bulletOnBackPressAction = r109;
        f267820a = new AnnieXCoreEvent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public final String getValue() {
        return this.value;
    }

    public AnnieXCoreEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
