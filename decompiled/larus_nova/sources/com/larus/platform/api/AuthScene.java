package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/AuthScene;", "", "<init>", "(Ljava/lang/String;I)V", "LocalLife", "Luna", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthScene extends Enum<AuthScene> {
    public static final AuthScene LocalLife = null;
    public static final AuthScene Luna = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthScene[] f364752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364753b = null;

    public static EnumEntries<AuthScene> getEntries() {
        return f364753b;
    }

    static {
        AuthScene r100 = new AuthScene("LocalLife", 0);
        LocalLife = r100;
        AuthScene r101 = new AuthScene("Luna", 1);
        Luna = r101;
        AuthScene[] r102 = {r100, r101};
        f364752a = r102;
        f364753b = EnumEntriesKt.enumEntries(r102);
    }

    public static AuthScene[] values() {
        return (AuthScene[]) f364752a.clone();
    }

    public static AuthScene valueOf(String r100) {
        return (AuthScene) r27.a.a(AuthScene.class, r100);
    }

    public AuthScene(String r100, int r101) {
        super(r100, r101);
    }
}
