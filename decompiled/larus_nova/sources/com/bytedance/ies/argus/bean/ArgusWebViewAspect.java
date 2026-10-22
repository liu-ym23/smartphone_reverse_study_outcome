package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebViewAspect;", "", "Lcom/bytedance/ies/argus/bean/p;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/bean/AspectType;", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "LOAD_URL", "WEB_REDIRECT", "SHOULD_INTERCEPT_REQUEST", "SHOULD_INTERCEPT_RESPONSE", "ON_PAGE_FINISHED", "ON_WEBVIEW_CREATED", "ON_ACCESS_GLOBAL_PROPS", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusWebViewAspect extends Enum<ArgusWebViewAspect> implements p {
    public static final ArgusWebViewAspect LOAD_URL = null;
    public static final ArgusWebViewAspect ON_ACCESS_GLOBAL_PROPS = null;
    public static final ArgusWebViewAspect ON_PAGE_FINISHED = null;
    public static final ArgusWebViewAspect ON_WEBVIEW_CREATED = null;
    public static final ArgusWebViewAspect SHOULD_INTERCEPT_REQUEST = null;
    public static final ArgusWebViewAspect SHOULD_INTERCEPT_RESPONSE = null;
    public static final ArgusWebViewAspect WEB_REDIRECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebViewAspect[] f245980a = null;
    private final ArgusContainerType containerType;
    private final String stringValue;
    private final AspectType type;

    public ArgusWebViewAspect() {
        throw null;
    }

    public static ArgusWebViewAspect valueOf(String r100) {
        return (ArgusWebViewAspect) r27.a.a(ArgusWebViewAspect.class, r100);
    }

    public static ArgusWebViewAspect[] values() {
        return (ArgusWebViewAspect[]) f245980a.clone();
    }

    static {
        ArgusWebViewAspect r100 = new ArgusWebViewAspect("LOAD_URL", 0, "web_load_url", null, null, 6, null);
        LOAD_URL = r100;
        ArgusWebViewAspect r101 = new ArgusWebViewAspect("WEB_REDIRECT", 1, "web_redirect", null, null, 6, null);
        WEB_REDIRECT = r101;
        ArgusWebViewAspect r102 = new ArgusWebViewAspect("SHOULD_INTERCEPT_REQUEST", 2, "should_intercept_request", null, null, 6, null);
        SHOULD_INTERCEPT_REQUEST = r102;
        ArgusWebViewAspect r103 = new ArgusWebViewAspect("SHOULD_INTERCEPT_RESPONSE", 3, "should_intercept_response", null, null, 6, null);
        SHOULD_INTERCEPT_RESPONSE = r103;
        ArgusWebViewAspect r104 = new ArgusWebViewAspect("ON_PAGE_FINISHED", 4, "on_page_finished", null, null, 6, null);
        ON_PAGE_FINISHED = r104;
        ArgusWebViewAspect r105 = new ArgusWebViewAspect("ON_WEBVIEW_CREATED", 5, "on_webview_created", null, null, 6, null);
        ON_WEBVIEW_CREATED = r105;
        ArgusWebViewAspect r106 = new ArgusWebViewAspect("ON_ACCESS_GLOBAL_PROPS", 6, "on_access_global_props", null, null, 6, null);
        ON_ACCESS_GLOBAL_PROPS = r106;
        f245980a = new ArgusWebViewAspect[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public ArgusContainerType getContainerType() {
        return this.containerType;
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    @Override // com.bytedance.ies.argus.bean.p, com.bytedance.ies.argus.bean.n
    public AspectType getType() {
        return this.type;
    }

    public ArgusWebViewAspect(String r100, int r101, String r102, AspectType r103, ArgusContainerType r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 2) == 0) goto L6;
        r103 = AspectType.VIEW;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r104 = ArgusContainerType.WEB;
    L8:
        super(r100, r101);
        this.stringValue = r102;
        this.type = r103;
        this.containerType = r104;
    }
}
