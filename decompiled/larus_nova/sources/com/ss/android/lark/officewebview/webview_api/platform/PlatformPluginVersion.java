package com.ss.android.lark.officewebview.webview_api.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/platform/PlatformPluginVersion;", "", "versionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersionName", "()Ljava/lang/String;", "OVERLAY", "EMBED", "SANDWICH", "SANDWICH_EMBED", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlatformPluginVersion extends Enum<PlatformPluginVersion> {
    public static final PlatformPluginVersion EMBED = null;
    public static final PlatformPluginVersion OVERLAY = null;
    public static final PlatformPluginVersion SANDWICH = null;
    public static final PlatformPluginVersion SANDWICH_EMBED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformPluginVersion[] f437579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437580b = null;
    private final String versionName;

    public static EnumEntries<PlatformPluginVersion> getEntries() {
        return f437580b;
    }

    static {
        PlatformPluginVersion r100 = new PlatformPluginVersion("OVERLAY", 0, "overlay");
        OVERLAY = r100;
        PlatformPluginVersion r101 = new PlatformPluginVersion("EMBED", 1, "embed");
        EMBED = r101;
        PlatformPluginVersion r102 = new PlatformPluginVersion("SANDWICH", 2, "sandwich");
        SANDWICH = r102;
        PlatformPluginVersion r103 = new PlatformPluginVersion("SANDWICH_EMBED", 3, "sandwich_embed");
        SANDWICH_EMBED = r103;
        PlatformPluginVersion[] r104 = {r100, r101, r102, r103};
        f437579a = r104;
        f437580b = EnumEntriesKt.enumEntries(r104);
    }

    public static PlatformPluginVersion[] values() {
        return (PlatformPluginVersion[]) f437579a.clone();
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public static PlatformPluginVersion valueOf(String r100) {
        return (PlatformPluginVersion) a.a(PlatformPluginVersion.class, r100);
    }

    public PlatformPluginVersion(String r100, int r101, String r102) {
        super(r100, r101);
        this.versionName = r102;
    }
}
