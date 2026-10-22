package com.larus.account.base.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "Request", "ForegroundSwitch", "ColdStart", "Preload", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GetOauthTokenTriggerScene extends Enum<GetOauthTokenTriggerScene> {
    public static final GetOauthTokenTriggerScene ColdStart = null;
    public static final GetOauthTokenTriggerScene ForegroundSwitch = null;
    public static final GetOauthTokenTriggerScene Preload = null;
    public static final GetOauthTokenTriggerScene Request = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GetOauthTokenTriggerScene[] f286198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286199b = null;
    private final String scene;

    public static EnumEntries<GetOauthTokenTriggerScene> getEntries() {
        return f286199b;
    }

    static {
        GetOauthTokenTriggerScene r100 = new GetOauthTokenTriggerScene("Request", 0, "request");
        Request = r100;
        GetOauthTokenTriggerScene r101 = new GetOauthTokenTriggerScene("ForegroundSwitch", 1, "foreground_switch");
        ForegroundSwitch = r101;
        GetOauthTokenTriggerScene r102 = new GetOauthTokenTriggerScene("ColdStart", 2, "cold_start");
        ColdStart = r102;
        GetOauthTokenTriggerScene r103 = new GetOauthTokenTriggerScene("Preload", 3, "preload");
        Preload = r103;
        GetOauthTokenTriggerScene[] r104 = {r100, r101, r102, r103};
        f286198a = r104;
        f286199b = EnumEntriesKt.enumEntries(r104);
    }

    public static GetOauthTokenTriggerScene[] values() {
        return (GetOauthTokenTriggerScene[]) f286198a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static GetOauthTokenTriggerScene valueOf(String r100) {
        return (GetOauthTokenTriggerScene) a.a(GetOauthTokenTriggerScene.class, r100);
    }

    public GetOauthTokenTriggerScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
