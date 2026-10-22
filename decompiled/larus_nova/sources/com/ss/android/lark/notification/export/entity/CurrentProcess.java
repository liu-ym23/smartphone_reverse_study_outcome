package com.ss.android.lark.notification.export.entity;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/notification/export/entity/CurrentProcess;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.MAIN, "WSCHANNEL", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CurrentProcess extends Enum<CurrentProcess> {
    public static final CurrentProcess MAIN = null;
    public static final CurrentProcess WSCHANNEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CurrentProcess[] f433053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433054b = null;

    public static EnumEntries<CurrentProcess> getEntries() {
        return f433054b;
    }

    static {
        CurrentProcess r100 = new CurrentProcess(AccountType.MAIN, 0);
        MAIN = r100;
        CurrentProcess r101 = new CurrentProcess("WSCHANNEL", 1);
        WSCHANNEL = r101;
        CurrentProcess[] r102 = {r100, r101};
        f433053a = r102;
        f433054b = EnumEntriesKt.enumEntries(r102);
    }

    public static CurrentProcess[] values() {
        return (CurrentProcess[]) f433053a.clone();
    }

    public static CurrentProcess valueOf(String r100) {
        return (CurrentProcess) r27.a.a(CurrentProcess.class, r100);
    }

    public CurrentProcess(String r100, int r101) {
        super(r100, r101);
    }
}
