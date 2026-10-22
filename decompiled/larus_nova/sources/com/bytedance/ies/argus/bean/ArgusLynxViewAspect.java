package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxViewAspect;", "", "Lcom/bytedance/ies/argus/bean/p;", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "Lcom/bytedance/ies/argus/bean/AspectType;", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "ABOUT_TO_LOAD_TEMPLATE", "LOAD_TEMPLATE", "EXIT", "SET_GLOBAL_PROPS", "INVOKE_JSI", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusLynxViewAspect extends Enum<ArgusLynxViewAspect> implements p {
    public static final ArgusLynxViewAspect ABOUT_TO_LOAD_TEMPLATE = null;
    public static final ArgusLynxViewAspect EXIT = null;
    public static final ArgusLynxViewAspect INVOKE_JSI = null;
    public static final ArgusLynxViewAspect LOAD_TEMPLATE = null;
    public static final ArgusLynxViewAspect SET_GLOBAL_PROPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusLynxViewAspect[] f245964a = null;
    private final ArgusContainerType containerType;
    private final String stringValue;
    private final AspectType type;

    public ArgusLynxViewAspect() {
        throw null;
    }

    public static ArgusLynxViewAspect valueOf(String r100) {
        return (ArgusLynxViewAspect) r27.a.a(ArgusLynxViewAspect.class, r100);
    }

    public static ArgusLynxViewAspect[] values() {
        return (ArgusLynxViewAspect[]) f245964a.clone();
    }

    static {
        ArgusLynxViewAspect r100 = new ArgusLynxViewAspect("ABOUT_TO_LOAD_TEMPLATE", 0, "about_to_load_template", null, null, 6, null);
        ABOUT_TO_LOAD_TEMPLATE = r100;
        ArgusLynxViewAspect r101 = new ArgusLynxViewAspect("LOAD_TEMPLATE", 1, "load_template", null, null, 6, null);
        LOAD_TEMPLATE = r101;
        ArgusLynxViewAspect r102 = new ArgusLynxViewAspect("EXIT", 2, "exit", null, null, 6, null);
        EXIT = r102;
        ArgusLynxViewAspect r103 = new ArgusLynxViewAspect("SET_GLOBAL_PROPS", 3, "set_globalprops", null, null, 6, null);
        SET_GLOBAL_PROPS = r103;
        ArgusLynxViewAspect r104 = new ArgusLynxViewAspect("INVOKE_JSI", 4, "invoke_jsi", null, null, 6, null);
        INVOKE_JSI = r104;
        f245964a = new ArgusLynxViewAspect[]{r100, r101, r102, r103, r104};
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

    public ArgusLynxViewAspect(String r100, int r101, String r102, AspectType r103, ArgusContainerType r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 2) == 0) goto L6;
        r103 = AspectType.VIEW;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r104 = ArgusContainerType.LYNX;
    L8:
        super(r100, r101);
        this.stringValue = r102;
        this.type = r103;
        this.containerType = r104;
    }
}
