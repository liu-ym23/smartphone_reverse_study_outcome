package com.larus.voicecall.api.bean;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/api/bean/RealtimeLandingFeatureScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "VIDEO", "CALL", "SCREEN_SHARE", "SCENE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeLandingFeatureScene extends Enum<RealtimeLandingFeatureScene> {
    public static final RealtimeLandingFeatureScene CALL = null;
    public static final RealtimeLandingFeatureScene SCENE = null;
    public static final RealtimeLandingFeatureScene SCREEN_SHARE = null;
    public static final RealtimeLandingFeatureScene VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeLandingFeatureScene[] f377091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377092b = null;
    private final String scene;

    public static EnumEntries<RealtimeLandingFeatureScene> getEntries() {
        return f377092b;
    }

    static {
        RealtimeLandingFeatureScene r100 = new RealtimeLandingFeatureScene("VIDEO", 0, "video");
        VIDEO = r100;
        RealtimeLandingFeatureScene r101 = new RealtimeLandingFeatureScene("CALL", 1, NotificationCompat.CATEGORY_CALL);
        CALL = r101;
        RealtimeLandingFeatureScene r102 = new RealtimeLandingFeatureScene("SCREEN_SHARE", 2, "screen_share");
        SCREEN_SHARE = r102;
        RealtimeLandingFeatureScene r103 = new RealtimeLandingFeatureScene("SCENE", 3, "scene");
        SCENE = r103;
        RealtimeLandingFeatureScene[] r104 = {r100, r101, r102, r103};
        f377091a = r104;
        f377092b = EnumEntriesKt.enumEntries(r104);
    }

    public static RealtimeLandingFeatureScene[] values() {
        return (RealtimeLandingFeatureScene[]) f377091a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static RealtimeLandingFeatureScene valueOf(String r100) {
        return (RealtimeLandingFeatureScene) a.a(RealtimeLandingFeatureScene.class, r100);
    }

    public RealtimeLandingFeatureScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
