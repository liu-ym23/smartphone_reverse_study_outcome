package com.bytedance.lynx.webview.extension;

/* JADX INFO: loaded from: classes21.dex */
public final enum BrowserPreInitExecutor$TaskThreadType extends Enum<BrowserPreInitExecutor$TaskThreadType> {
    public static final BrowserPreInitExecutor$TaskThreadType AnyThread = null;
    public static final BrowserPreInitExecutor$TaskThreadType PreInitFinish = null;
    public static final BrowserPreInitExecutor$TaskThreadType UIThread = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BrowserPreInitExecutor$TaskThreadType[] f265108a = null;

    static {
        BrowserPreInitExecutor$TaskThreadType r100 = new BrowserPreInitExecutor$TaskThreadType("UIThread", 0);
        UIThread = r100;
        BrowserPreInitExecutor$TaskThreadType r101 = new BrowserPreInitExecutor$TaskThreadType("AnyThread", 1);
        AnyThread = r101;
        BrowserPreInitExecutor$TaskThreadType r102 = new BrowserPreInitExecutor$TaskThreadType("PreInitFinish", 2);
        PreInitFinish = r102;
        f265108a = new BrowserPreInitExecutor$TaskThreadType[]{r100, r101, r102};
    }

    public static BrowserPreInitExecutor$TaskThreadType[] values() {
        return (BrowserPreInitExecutor$TaskThreadType[]) f265108a.clone();
    }

    public static BrowserPreInitExecutor$TaskThreadType valueOf(String r100) {
        return (BrowserPreInitExecutor$TaskThreadType) r27.a.a(BrowserPreInitExecutor$TaskThreadType.class, r100);
    }

    public BrowserPreInitExecutor$TaskThreadType(String r100, int r101) {
        super(r100, r101);
    }
}
