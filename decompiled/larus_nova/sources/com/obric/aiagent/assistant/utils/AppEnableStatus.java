package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NoInstalled", "AppDisabled", "Enabled", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppEnableStatus extends Enum<AppEnableStatus> {
    public static final AppEnableStatus AppDisabled = null;
    public static final AppEnableStatus Enabled = null;
    public static final AppEnableStatus NoInstalled = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppEnableStatus[] f384602a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384603b = null;

    public static EnumEntries<AppEnableStatus> getEntries() {
        return f384603b;
    }

    static {
        AppEnableStatus r100 = new AppEnableStatus("NoInstalled", 0);
        NoInstalled = r100;
        AppEnableStatus r101 = new AppEnableStatus("AppDisabled", 1);
        AppDisabled = r101;
        AppEnableStatus r102 = new AppEnableStatus("Enabled", 2);
        Enabled = r102;
        AppEnableStatus[] r103 = {r100, r101, r102};
        f384602a = r103;
        f384603b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppEnableStatus[] values() {
        return (AppEnableStatus[]) f384602a.clone();
    }

    public static AppEnableStatus valueOf(String r100) {
        return (AppEnableStatus) r27.a.a(AppEnableStatus.class, r100);
    }

    public AppEnableStatus(String r100, int r101) {
        super(r100, r101);
    }
}
