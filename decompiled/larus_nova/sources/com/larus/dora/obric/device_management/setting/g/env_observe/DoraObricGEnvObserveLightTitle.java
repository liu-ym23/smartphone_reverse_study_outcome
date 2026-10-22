package com.larus.dora.obric.device_management.setting.g.env_observe;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/env_observe/DoraObricGEnvObserveLightTitle;", "", "<init>", "(Ljava/lang/String;I)V", "WHITE", "YELLOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGEnvObserveLightTitle extends Enum<DoraObricGEnvObserveLightTitle> {
    public static final DoraObricGEnvObserveLightTitle WHITE = null;
    public static final DoraObricGEnvObserveLightTitle YELLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGEnvObserveLightTitle[] f340353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340354b = null;

    public static EnumEntries<DoraObricGEnvObserveLightTitle> getEntries() {
        return f340354b;
    }

    static {
        DoraObricGEnvObserveLightTitle r100 = new DoraObricGEnvObserveLightTitle("WHITE", 0);
        WHITE = r100;
        DoraObricGEnvObserveLightTitle r101 = new DoraObricGEnvObserveLightTitle("YELLOW", 1);
        YELLOW = r101;
        DoraObricGEnvObserveLightTitle[] r102 = {r100, r101};
        f340353a = r102;
        f340354b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraObricGEnvObserveLightTitle[] values() {
        return (DoraObricGEnvObserveLightTitle[]) f340353a.clone();
    }

    public static DoraObricGEnvObserveLightTitle valueOf(String r100) {
        return (DoraObricGEnvObserveLightTitle) r27.a.a(DoraObricGEnvObserveLightTitle.class, r100);
    }

    public DoraObricGEnvObserveLightTitle(String r100, int r101) {
        super(r100, r101);
    }
}
