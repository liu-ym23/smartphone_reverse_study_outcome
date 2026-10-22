package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebDomMonitorJsbInjectReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "ENABLE_IN_WEBVIEW_CREATED", "SKIP_IN_WEBVIEW_CREATED", "REWRITE_INJECT_SCRIPT", "SKIP_IN_PAGE_FINISHED", "SCRIPT_GENERATE_FAILED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebDomMonitorJsbInjectReason extends Enum<ArgusWebDomMonitorJsbInjectReason> implements o {
    public static final ArgusWebDomMonitorJsbInjectReason ENABLE_IN_WEBVIEW_CREATED = null;
    public static final ArgusWebDomMonitorJsbInjectReason REWRITE_INJECT_SCRIPT = null;
    public static final ArgusWebDomMonitorJsbInjectReason SCRIPT_GENERATE_FAILED = null;
    public static final ArgusWebDomMonitorJsbInjectReason SKIP_IN_PAGE_FINISHED = null;
    public static final ArgusWebDomMonitorJsbInjectReason SKIP_IN_WEBVIEW_CREATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebDomMonitorJsbInjectReason[] f245977a = null;
    private final int code;
    private final String strValue;

    public static ArgusWebDomMonitorJsbInjectReason valueOf(String r100) {
        return (ArgusWebDomMonitorJsbInjectReason) r27.a.a(ArgusWebDomMonitorJsbInjectReason.class, r100);
    }

    public static ArgusWebDomMonitorJsbInjectReason[] values() {
        return (ArgusWebDomMonitorJsbInjectReason[]) f245977a.clone();
    }

    static {
        ArgusWebDomMonitorJsbInjectReason r100 = new ArgusWebDomMonitorJsbInjectReason("ENABLE_IN_WEBVIEW_CREATED", 0, 1, "enable jsb interface in webview created");
        ENABLE_IN_WEBVIEW_CREATED = r100;
        ArgusWebDomMonitorJsbInjectReason r101 = new ArgusWebDomMonitorJsbInjectReason("SKIP_IN_WEBVIEW_CREATED", 1, 2, "skip jsb interface in webview created");
        SKIP_IN_WEBVIEW_CREATED = r101;
        ArgusWebDomMonitorJsbInjectReason r102 = new ArgusWebDomMonitorJsbInjectReason("REWRITE_INJECT_SCRIPT", 2, 3, "rewrite inject script in page finished");
        REWRITE_INJECT_SCRIPT = r102;
        ArgusWebDomMonitorJsbInjectReason r103 = new ArgusWebDomMonitorJsbInjectReason("SKIP_IN_PAGE_FINISHED", 3, 4, "skip inject in page finished");
        SKIP_IN_PAGE_FINISHED = r103;
        ArgusWebDomMonitorJsbInjectReason r104 = new ArgusWebDomMonitorJsbInjectReason("SCRIPT_GENERATE_FAILED", 4, 1001, "script generate failed");
        SCRIPT_GENERATE_FAILED = r104;
        f245977a = new ArgusWebDomMonitorJsbInjectReason[]{r100, r101, r102, r103, r104};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusWebDomMonitorJsbInjectReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
