package com.bytedance.lynx.webview.extension;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes21.dex */
final enum BrowserPreInitExecutor$PreInitAction extends Enum<BrowserPreInitExecutor$PreInitAction> {
    public static final BrowserPreInitExecutor$PreInitAction CREATE_BROWSER_UI_EXECUTOR = null;
    public static final BrowserPreInitExecutor$PreInitAction ENSURE_FACTORY_PROVIDER_CREATE = null;
    public static final BrowserPreInitExecutor$PreInitAction FAILED_FINISH = null;
    public static final BrowserPreInitExecutor$PreInitAction INIT_BROWSER_DEPENDENCIES = null;
    public static final BrowserPreInitExecutor$PreInitAction PRE_INIT_BROWSER_PROCESS = null;
    public static final BrowserPreInitExecutor$PreInitAction START = null;
    public static final BrowserPreInitExecutor$PreInitAction SUCCESS_FINISH = null;
    public static final BrowserPreInitExecutor$PreInitAction UN_PRE_INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BrowserPreInitExecutor$PreInitAction[] f265107a = null;

    static {
        BrowserPreInitExecutor$PreInitAction r100 = new BrowserPreInitExecutor$PreInitAction("UN_PRE_INIT", 0);
        UN_PRE_INIT = r100;
        BrowserPreInitExecutor$PreInitAction r101 = new BrowserPreInitExecutor$PreInitAction(GXAnimation.STATE_START, 1);
        START = r101;
        BrowserPreInitExecutor$PreInitAction r102 = new BrowserPreInitExecutor$PreInitAction("ENSURE_FACTORY_PROVIDER_CREATE", 2);
        ENSURE_FACTORY_PROVIDER_CREATE = r102;
        BrowserPreInitExecutor$PreInitAction r103 = new BrowserPreInitExecutor$PreInitAction("CREATE_BROWSER_UI_EXECUTOR", 3);
        CREATE_BROWSER_UI_EXECUTOR = r103;
        BrowserPreInitExecutor$PreInitAction r104 = new BrowserPreInitExecutor$PreInitAction("INIT_BROWSER_DEPENDENCIES", 4);
        INIT_BROWSER_DEPENDENCIES = r104;
        BrowserPreInitExecutor$PreInitAction r105 = new BrowserPreInitExecutor$PreInitAction("PRE_INIT_BROWSER_PROCESS", 5);
        PRE_INIT_BROWSER_PROCESS = r105;
        BrowserPreInitExecutor$PreInitAction r110 = new BrowserPreInitExecutor$PreInitAction("FAILED_FINISH", 6);
        FAILED_FINISH = r110;
        BrowserPreInitExecutor$PreInitAction r111 = new BrowserPreInitExecutor$PreInitAction("SUCCESS_FINISH", 7);
        SUCCESS_FINISH = r111;
        f265107a = new BrowserPreInitExecutor$PreInitAction[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static BrowserPreInitExecutor$PreInitAction[] values() {
        return (BrowserPreInitExecutor$PreInitAction[]) f265107a.clone();
    }

    public static BrowserPreInitExecutor$PreInitAction valueOf(String r100) {
        return (BrowserPreInitExecutor$PreInitAction) r27.a.a(BrowserPreInitExecutor$PreInitAction.class, r100);
    }

    public BrowserPreInitExecutor$PreInitAction(String r100, int r101) {
        super(r100, r101);
    }
}
