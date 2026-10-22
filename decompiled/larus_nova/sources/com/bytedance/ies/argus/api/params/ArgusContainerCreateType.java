package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusContainerCreateType;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "Activity", "View", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusContainerCreateType extends Enum<ArgusContainerCreateType> {
    public static final ArgusContainerCreateType Activity = null;
    public static final ArgusContainerCreateType View = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusContainerCreateType[] f245645a = null;
    private final String strValue;

    public static ArgusContainerCreateType valueOf(String r100) {
        return (ArgusContainerCreateType) r27.a.a(ArgusContainerCreateType.class, r100);
    }

    public static ArgusContainerCreateType[] values() {
        return (ArgusContainerCreateType[]) f245645a.clone();
    }

    static {
        ArgusContainerCreateType r100 = new ArgusContainerCreateType("Activity", 0, "activity");
        Activity = r100;
        ArgusContainerCreateType r101 = new ArgusContainerCreateType("View", 1, "view");
        View = r101;
        f245645a = new ArgusContainerCreateType[]{r100, r101};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public ArgusContainerCreateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
