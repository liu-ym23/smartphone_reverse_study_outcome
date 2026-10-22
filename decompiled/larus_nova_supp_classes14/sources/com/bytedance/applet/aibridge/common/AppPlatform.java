package com.bytedance.applet.aibridge.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applet/aibridge/common/AppPlatform;", "", "appName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "DouYin", "Luna", "QQMusic", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppPlatform extends Enum<AppPlatform> {
    public static final AppPlatform DouYin = null;
    public static final AppPlatform Luna = null;
    public static final AppPlatform QQMusic = null;
    public static final /* synthetic */ AppPlatform[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String appName;

    public static EnumEntries<AppPlatform> getEntries() {
        return b;
    }

    static {
        AppPlatform r0 = new AppPlatform("DouYin", 0, "Douyin");
        DouYin = r0;
        AppPlatform r1 = new AppPlatform("Luna", 1, "Luna");
        Luna = r1;
        AppPlatform r2 = new AppPlatform("QQMusic", 2, "QQMusic");
        QQMusic = r2;
        AppPlatform[] r5 = {r0, r1, r2};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AppPlatform[] values() {
        return (AppPlatform[]) a.clone();
    }

    public final String getAppName() {
        return this.appName;
    }

    public static AppPlatform valueOf(String r1) {
        return (AppPlatform) a.a(AppPlatform.class, r1);
    }

    public AppPlatform(String r1, int r2, String r3) {
        super(r1, r2);
        this.appName = r3;
    }
}
