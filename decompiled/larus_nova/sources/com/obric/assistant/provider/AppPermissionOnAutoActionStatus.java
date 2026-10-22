package com.obric.assistant.provider;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/provider/AppPermissionOnAutoActionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNAVAILABLE", "AVAILABLE_ALWAYS", "AVAILABLE_FOR_ONCE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppPermissionOnAutoActionStatus extends Enum<AppPermissionOnAutoActionStatus> {
    public static final AppPermissionOnAutoActionStatus AVAILABLE_ALWAYS = null;
    public static final AppPermissionOnAutoActionStatus AVAILABLE_FOR_ONCE = null;
    public static final AppPermissionOnAutoActionStatus UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppPermissionOnAutoActionStatus[] f391169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391170b = null;
    private final int value;

    public static EnumEntries<AppPermissionOnAutoActionStatus> getEntries() {
        return f391170b;
    }

    static {
        AppPermissionOnAutoActionStatus r100 = new AppPermissionOnAutoActionStatus("UNAVAILABLE", 0, 0);
        UNAVAILABLE = r100;
        AppPermissionOnAutoActionStatus r101 = new AppPermissionOnAutoActionStatus("AVAILABLE_ALWAYS", 1, 1);
        AVAILABLE_ALWAYS = r101;
        AppPermissionOnAutoActionStatus r102 = new AppPermissionOnAutoActionStatus("AVAILABLE_FOR_ONCE", 2, 2);
        AVAILABLE_FOR_ONCE = r102;
        AppPermissionOnAutoActionStatus[] r103 = {r100, r101, r102};
        f391169a = r103;
        f391170b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppPermissionOnAutoActionStatus[] values() {
        return (AppPermissionOnAutoActionStatus[]) f391169a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppPermissionOnAutoActionStatus valueOf(String r100) {
        return (AppPermissionOnAutoActionStatus) r27.a.a(AppPermissionOnAutoActionStatus.class, r100);
    }

    public AppPermissionOnAutoActionStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
