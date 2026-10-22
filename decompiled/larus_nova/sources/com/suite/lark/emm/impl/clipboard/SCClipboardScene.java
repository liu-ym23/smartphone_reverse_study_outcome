package com.suite.lark.emm.impl.clipboard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/suite/lark/emm/impl/clipboard/SCClipboardScene;", "", "param", "", "<init>", "(Ljava/lang/String;ILjava/lang/Object;)V", "getParam", "()Ljava/lang/Object;", "setParam", "(Ljava/lang/Object;)V", "SCENE_DEFAULT", "SCENE_ENCRYPT", "SCENE_SYSTEM_ONCE", "SCENE_SYSTEM", "SCENE_DISABLE_COPY", "SCENE_DISABLE_DIALOG", "SCENE_OPEN_APP", "enterprise-mobility-management-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SCClipboardScene extends Enum<SCClipboardScene> {
    public static final SCClipboardScene SCENE_DEFAULT = null;
    public static final SCClipboardScene SCENE_DISABLE_COPY = null;
    public static final SCClipboardScene SCENE_DISABLE_DIALOG = null;
    public static final SCClipboardScene SCENE_ENCRYPT = null;
    public static final SCClipboardScene SCENE_OPEN_APP = null;
    public static final SCClipboardScene SCENE_SYSTEM = null;
    public static final SCClipboardScene SCENE_SYSTEM_ONCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SCClipboardScene[] f460437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f460438b = null;
    private Object param;

    public SCClipboardScene() {
        throw null;
    }

    public static EnumEntries<SCClipboardScene> getEntries() {
        return f460438b;
    }

    static {
        SCClipboardScene r100 = new SCClipboardScene("SCENE_DEFAULT", 0, null, 1, null);
        SCENE_DEFAULT = r100;
        SCClipboardScene r101 = new SCClipboardScene("SCENE_ENCRYPT", 1, null, 1, null);
        SCENE_ENCRYPT = r101;
        SCClipboardScene r102 = new SCClipboardScene("SCENE_SYSTEM_ONCE", 2, null, 1, null);
        SCENE_SYSTEM_ONCE = r102;
        SCClipboardScene r103 = new SCClipboardScene("SCENE_SYSTEM", 3, null, 1, null);
        SCENE_SYSTEM = r103;
        SCClipboardScene r104 = new SCClipboardScene("SCENE_DISABLE_COPY", 4, null, 1, null);
        SCENE_DISABLE_COPY = r104;
        SCClipboardScene r105 = new SCClipboardScene("SCENE_DISABLE_DIALOG", 5, null, 1, null);
        SCENE_DISABLE_DIALOG = r105;
        SCClipboardScene r106 = new SCClipboardScene("SCENE_OPEN_APP", 6, null, 1, null);
        SCENE_OPEN_APP = r106;
        SCClipboardScene[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        f460437a = r107;
        f460438b = EnumEntriesKt.enumEntries(r107);
    }

    public static SCClipboardScene[] values() {
        return (SCClipboardScene[]) f460437a.clone();
    }

    public final Object getParam() {
        return this.param;
    }

    public static SCClipboardScene valueOf(String r100) {
        return (SCClipboardScene) a.a(SCClipboardScene.class, r100);
    }

    public final void setParam(Object r100) {
        this.param = r100;
    }

    public SCClipboardScene(String r100, int r101, Object r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = null;
    L5:
        super(r100, r101);
        this.param = r102;
    }
}
