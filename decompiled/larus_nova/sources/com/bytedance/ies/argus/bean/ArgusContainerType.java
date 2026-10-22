package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WEB", "LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusContainerType extends Enum<ArgusContainerType> {
    public static final ArgusContainerType LYNX = null;
    public static final ArgusContainerType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusContainerType[] f245954a = null;
    private final String value;

    public static ArgusContainerType valueOf(String r100) {
        return (ArgusContainerType) r27.a.a(ArgusContainerType.class, r100);
    }

    public static ArgusContainerType[] values() {
        return (ArgusContainerType[]) f245954a.clone();
    }

    static {
        ArgusContainerType r100 = new ArgusContainerType("WEB", 0, "web");
        WEB = r100;
        ArgusContainerType r101 = new ArgusContainerType("LYNX", 1, "lynx");
        LYNX = r101;
        f245954a = new ArgusContainerType[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public ArgusContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
