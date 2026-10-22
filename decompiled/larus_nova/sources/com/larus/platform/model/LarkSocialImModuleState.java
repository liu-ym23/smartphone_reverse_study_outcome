package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/LarkSocialImModuleState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "READY", "FAILED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkSocialImModuleState extends Enum<LarkSocialImModuleState> {
    public static final LarkSocialImModuleState FAILED = null;
    public static final LarkSocialImModuleState LOADING = null;
    public static final LarkSocialImModuleState NOT_LOADED = null;
    public static final LarkSocialImModuleState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkSocialImModuleState[] f365458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365459b = null;

    public static EnumEntries<LarkSocialImModuleState> getEntries() {
        return f365459b;
    }

    static {
        LarkSocialImModuleState r100 = new LarkSocialImModuleState("NOT_LOADED", 0);
        NOT_LOADED = r100;
        LarkSocialImModuleState r101 = new LarkSocialImModuleState("LOADING", 1);
        LOADING = r101;
        LarkSocialImModuleState r102 = new LarkSocialImModuleState("READY", 2);
        READY = r102;
        LarkSocialImModuleState r103 = new LarkSocialImModuleState("FAILED", 3);
        FAILED = r103;
        LarkSocialImModuleState[] r104 = {r100, r101, r102, r103};
        f365458a = r104;
        f365459b = EnumEntriesKt.enumEntries(r104);
    }

    public static LarkSocialImModuleState[] values() {
        return (LarkSocialImModuleState[]) f365458a.clone();
    }

    public static LarkSocialImModuleState valueOf(String r100) {
        return (LarkSocialImModuleState) a.a(LarkSocialImModuleState.class, r100);
    }

    public LarkSocialImModuleState(String r100, int r101) {
        super(r100, r101);
    }
}
