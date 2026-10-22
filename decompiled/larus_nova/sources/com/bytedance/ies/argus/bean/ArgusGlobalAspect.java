package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalAspect;", "", "Lcom/bytedance/ies/argus/bean/n;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/bean/AspectType;", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "ABOUT_TO_PREFETCH", "LOAD_STATIC_RESOURCE", "MOTION_ON_TOUCH", "ABOUT_TO_UPLOAD_FILE", "ABOUT_TO_REQUEST_LYNX_SSR_URL", "ABOUT_TO_APPEND_COMMON_PARAMS", "INJECT_LOGIN_STATE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusGlobalAspect extends Enum<ArgusGlobalAspect> implements n {
    public static final ArgusGlobalAspect ABOUT_TO_APPEND_COMMON_PARAMS = null;
    public static final ArgusGlobalAspect ABOUT_TO_PREFETCH = null;
    public static final ArgusGlobalAspect ABOUT_TO_REQUEST_LYNX_SSR_URL = null;
    public static final ArgusGlobalAspect ABOUT_TO_UPLOAD_FILE = null;
    public static final ArgusGlobalAspect INJECT_LOGIN_STATE = null;
    public static final ArgusGlobalAspect LOAD_STATIC_RESOURCE = null;
    public static final ArgusGlobalAspect MOTION_ON_TOUCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusGlobalAspect[] f245956a = null;
    private final String stringValue;
    private final AspectType type;

    public ArgusGlobalAspect() {
        throw null;
    }

    public static ArgusGlobalAspect valueOf(String r100) {
        return (ArgusGlobalAspect) r27.a.a(ArgusGlobalAspect.class, r100);
    }

    public static ArgusGlobalAspect[] values() {
        return (ArgusGlobalAspect[]) f245956a.clone();
    }

    static {
        ArgusGlobalAspect r100 = new ArgusGlobalAspect("ABOUT_TO_PREFETCH", 0, "about_to_prefetch", null, 2, null);
        ABOUT_TO_PREFETCH = r100;
        ArgusGlobalAspect r101 = new ArgusGlobalAspect("LOAD_STATIC_RESOURCE", 1, "load_static_resource", null, 2, null);
        LOAD_STATIC_RESOURCE = r101;
        ArgusGlobalAspect r102 = new ArgusGlobalAspect("MOTION_ON_TOUCH", 2, "motion_on_touch", null, 2, null);
        MOTION_ON_TOUCH = r102;
        ArgusGlobalAspect r103 = new ArgusGlobalAspect("ABOUT_TO_UPLOAD_FILE", 3, "about_to_upload_file", null, 2, null);
        ABOUT_TO_UPLOAD_FILE = r103;
        ArgusGlobalAspect r104 = new ArgusGlobalAspect("ABOUT_TO_REQUEST_LYNX_SSR_URL", 4, "about_to_request_lynx_ssr_url", null, 2, null);
        ABOUT_TO_REQUEST_LYNX_SSR_URL = r104;
        ArgusGlobalAspect r105 = new ArgusGlobalAspect("ABOUT_TO_APPEND_COMMON_PARAMS", 5, "about_to_append_common_params", null, 2, null);
        ABOUT_TO_APPEND_COMMON_PARAMS = r105;
        ArgusGlobalAspect r106 = new ArgusGlobalAspect("INJECT_LOGIN_STATE", 6, "inject_login_state", null, 2, null);
        INJECT_LOGIN_STATE = r106;
        f245956a = new ArgusGlobalAspect[]{r100, r101, r102, r103, r104, r105, r106};
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    @Override // com.bytedance.ies.argus.bean.n
    public AspectType getType() {
        return this.type;
    }

    public ArgusGlobalAspect(String r100, int r101, String r102, AspectType r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = AspectType.GLOBAL;
    L5:
        super(r100, r101);
        this.stringValue = r102;
        this.type = r103;
    }
}
