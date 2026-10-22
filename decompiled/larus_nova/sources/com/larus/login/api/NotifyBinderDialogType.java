package com.larus.login.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/login/api/NotifyBinderDialogType;", "", "<init>", "(Ljava/lang/String;I)V", "CheckNeedBinder", "NotifyBinder", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NotifyBinderDialogType extends Enum<NotifyBinderDialogType> {
    public static final NotifyBinderDialogType CheckNeedBinder = null;
    public static final NotifyBinderDialogType NotifyBinder = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NotifyBinderDialogType[] f356991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356992b = null;

    public static EnumEntries<NotifyBinderDialogType> getEntries() {
        return f356992b;
    }

    static {
        NotifyBinderDialogType r100 = new NotifyBinderDialogType("CheckNeedBinder", 0);
        CheckNeedBinder = r100;
        NotifyBinderDialogType r101 = new NotifyBinderDialogType("NotifyBinder", 1);
        NotifyBinder = r101;
        NotifyBinderDialogType[] r102 = {r100, r101};
        f356991a = r102;
        f356992b = EnumEntriesKt.enumEntries(r102);
    }

    public static NotifyBinderDialogType[] values() {
        return (NotifyBinderDialogType[]) f356991a.clone();
    }

    public static NotifyBinderDialogType valueOf(String r100) {
        return (NotifyBinderDialogType) r27.a.a(NotifyBinderDialogType.class, r100);
    }

    public NotifyBinderDialogType(String r100, int r101) {
        super(r100, r101);
    }
}
