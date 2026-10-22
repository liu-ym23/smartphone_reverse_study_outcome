package com.bytedance.kmp.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/launcher/KmpLaunchStage;", "", "<init>", "(Ljava/lang/String;I)V", "IMMEDIATE", "BOOT_FINISH", "launcher_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KmpLaunchStage extends Enum<KmpLaunchStage> {
    public static final KmpLaunchStage BOOT_FINISH = null;
    public static final KmpLaunchStage IMMEDIATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpLaunchStage[] f252196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252197b = null;

    public static EnumEntries<KmpLaunchStage> getEntries() {
        return f252197b;
    }

    static {
        KmpLaunchStage r100 = new KmpLaunchStage("IMMEDIATE", 0);
        IMMEDIATE = r100;
        KmpLaunchStage r101 = new KmpLaunchStage("BOOT_FINISH", 1);
        BOOT_FINISH = r101;
        KmpLaunchStage[] r102 = {r100, r101};
        f252196a = r102;
        f252197b = EnumEntriesKt.enumEntries(r102);
    }

    public static KmpLaunchStage[] values() {
        return (KmpLaunchStage[]) f252196a.clone();
    }

    public static KmpLaunchStage valueOf(String r100) {
        return (KmpLaunchStage) a.a(KmpLaunchStage.class, r100);
    }

    public KmpLaunchStage(String r100, int r101) {
        super(r100, r101);
    }
}
