package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusContainerAspect;", "", "Lcom/bytedance/ies/argus/bean/n;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/bean/AspectType;", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "CONTAINER_CREATED", "ON_ROUTER_SESSION_CREATED", "JSB_CALL", "AFTER_JSB_HANDLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusContainerAspect extends Enum<ArgusContainerAspect> implements n {
    public static final ArgusContainerAspect AFTER_JSB_HANDLE = null;
    public static final ArgusContainerAspect CONTAINER_CREATED = null;
    public static final ArgusContainerAspect JSB_CALL = null;
    public static final ArgusContainerAspect ON_ROUTER_SESSION_CREATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusContainerAspect[] f245953a = null;
    private final String stringValue;
    private final AspectType type;

    public ArgusContainerAspect() {
        throw null;
    }

    public static ArgusContainerAspect valueOf(String r100) {
        return (ArgusContainerAspect) r27.a.a(ArgusContainerAspect.class, r100);
    }

    public static ArgusContainerAspect[] values() {
        return (ArgusContainerAspect[]) f245953a.clone();
    }

    static {
        ArgusContainerAspect r100 = new ArgusContainerAspect("CONTAINER_CREATED", 0, "container_created", null, 2, null);
        CONTAINER_CREATED = r100;
        ArgusContainerAspect r101 = new ArgusContainerAspect("ON_ROUTER_SESSION_CREATED", 1, "on_router_session_created", null, 2, null);
        ON_ROUTER_SESSION_CREATED = r101;
        ArgusContainerAspect r102 = new ArgusContainerAspect("JSB_CALL", 2, "jsb_call", null, 2, null);
        JSB_CALL = r102;
        ArgusContainerAspect r103 = new ArgusContainerAspect("AFTER_JSB_HANDLE", 3, "after_jsb_handle", null, 2, null);
        AFTER_JSB_HANDLE = r103;
        f245953a = new ArgusContainerAspect[]{r100, r101, r102, r103};
    }

    @Override // com.bytedance.ies.argus.bean.q
    public String getStringValue() {
        return this.stringValue;
    }

    @Override // com.bytedance.ies.argus.bean.n
    public AspectType getType() {
        return this.type;
    }

    public ArgusContainerAspect(String r100, int r101, String r102, AspectType r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = AspectType.CONTAINER;
    L5:
        super(r100, r101);
        this.stringValue = r102;
        this.type = r103;
    }
}
