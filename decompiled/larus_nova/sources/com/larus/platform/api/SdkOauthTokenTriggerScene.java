package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/platform/api/SdkOauthTokenTriggerScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "Request", "ForegroundSwitch", "ColdStart", "Preload", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SdkOauthTokenTriggerScene extends Enum<SdkOauthTokenTriggerScene> {
    public static final SdkOauthTokenTriggerScene ColdStart = null;
    public static final SdkOauthTokenTriggerScene ForegroundSwitch = null;
    public static final SdkOauthTokenTriggerScene Preload = null;
    public static final SdkOauthTokenTriggerScene Request = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SdkOauthTokenTriggerScene[] f364849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364850b = null;
    private final String scene;

    public static EnumEntries<SdkOauthTokenTriggerScene> getEntries() {
        return f364850b;
    }

    static {
        SdkOauthTokenTriggerScene r100 = new SdkOauthTokenTriggerScene("Request", 0, "request");
        Request = r100;
        SdkOauthTokenTriggerScene r101 = new SdkOauthTokenTriggerScene("ForegroundSwitch", 1, "foreground_switch");
        ForegroundSwitch = r101;
        SdkOauthTokenTriggerScene r102 = new SdkOauthTokenTriggerScene("ColdStart", 2, "cold_start");
        ColdStart = r102;
        SdkOauthTokenTriggerScene r103 = new SdkOauthTokenTriggerScene("Preload", 3, "preload");
        Preload = r103;
        SdkOauthTokenTriggerScene[] r104 = {r100, r101, r102, r103};
        f364849a = r104;
        f364850b = EnumEntriesKt.enumEntries(r104);
    }

    public static SdkOauthTokenTriggerScene[] values() {
        return (SdkOauthTokenTriggerScene[]) f364849a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static SdkOauthTokenTriggerScene valueOf(String r100) {
        return (SdkOauthTokenTriggerScene) r27.a.a(SdkOauthTokenTriggerScene.class, r100);
    }

    public SdkOauthTokenTriggerScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
