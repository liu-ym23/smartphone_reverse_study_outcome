package com.larus.bmhome.chat.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/api/LaunchRequestScene;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN_OR_SWITCH", "TOURIST_CORE_ONLY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LaunchRequestScene extends Enum<LaunchRequestScene> {
    public static final LaunchRequestScene LOGIN_OR_SWITCH = null;
    public static final LaunchRequestScene TOURIST_CORE_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchRequestScene[] f297169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297170b = null;

    public static EnumEntries<LaunchRequestScene> getEntries() {
        return f297170b;
    }

    static {
        LaunchRequestScene r100 = new LaunchRequestScene("LOGIN_OR_SWITCH", 0);
        LOGIN_OR_SWITCH = r100;
        LaunchRequestScene r101 = new LaunchRequestScene("TOURIST_CORE_ONLY", 1);
        TOURIST_CORE_ONLY = r101;
        LaunchRequestScene[] r102 = {r100, r101};
        f297169a = r102;
        f297170b = EnumEntriesKt.enumEntries(r102);
    }

    public static LaunchRequestScene[] values() {
        return (LaunchRequestScene[]) f297169a.clone();
    }

    public static LaunchRequestScene valueOf(String r100) {
        return (LaunchRequestScene) r27.a.a(LaunchRequestScene.class, r100);
    }

    public LaunchRequestScene(String r100, int r101) {
        super(r100, r101);
    }
}
