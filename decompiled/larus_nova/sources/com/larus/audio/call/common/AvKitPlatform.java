package com.larus.audio.call.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/common/AvKitPlatform;", "", "osName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOsName$avkit_release", "()Ljava/lang/String;", "Android", "iOS", "HarmonyOS", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvKitPlatform extends Enum<AvKitPlatform> {
    public static final AvKitPlatform Android = null;
    public static final AvKitPlatform HarmonyOS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvKitPlatform[] f289090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289091b = null;
    public static final AvKitPlatform iOS = null;
    private final String osName;

    public static EnumEntries<AvKitPlatform> getEntries() {
        return f289091b;
    }

    static {
        AvKitPlatform r100 = new AvKitPlatform("Android", 0, "Android");
        Android = r100;
        AvKitPlatform r101 = new AvKitPlatform("iOS", 1, "iOS");
        iOS = r101;
        AvKitPlatform r102 = new AvKitPlatform("HarmonyOS", 2, "openHarmony");
        HarmonyOS = r102;
        AvKitPlatform[] r103 = {r100, r101, r102};
        f289090a = r103;
        f289091b = EnumEntriesKt.enumEntries(r103);
    }

    public static AvKitPlatform[] values() {
        return (AvKitPlatform[]) f289090a.clone();
    }

    public final String getOsName$avkit_release() {
        return this.osName;
    }

    public static AvKitPlatform valueOf(String r100) {
        return (AvKitPlatform) r27.a.a(AvKitPlatform.class, r100);
    }

    public AvKitPlatform(String r100, int r101, String r102) {
        super(r100, r101);
        this.osName = r102;
    }
}
