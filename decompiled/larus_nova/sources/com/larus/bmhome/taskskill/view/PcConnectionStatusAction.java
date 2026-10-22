package com.larus.bmhome.taskskill.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/taskskill/view/PcConnectionStatusAction;", "", "<init>", "(Ljava/lang/String;I)V", "RetryGetAllDevices", "RequestAuthorizedPermission", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcConnectionStatusAction extends Enum<PcConnectionStatusAction> {
    public static final PcConnectionStatusAction RequestAuthorizedPermission = null;
    public static final PcConnectionStatusAction RetryGetAllDevices = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcConnectionStatusAction[] f314591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314592b = null;

    public static EnumEntries<PcConnectionStatusAction> getEntries() {
        return f314592b;
    }

    static {
        PcConnectionStatusAction r100 = new PcConnectionStatusAction("RetryGetAllDevices", 0);
        RetryGetAllDevices = r100;
        PcConnectionStatusAction r101 = new PcConnectionStatusAction("RequestAuthorizedPermission", 1);
        RequestAuthorizedPermission = r101;
        PcConnectionStatusAction[] r102 = {r100, r101};
        f314591a = r102;
        f314592b = EnumEntriesKt.enumEntries(r102);
    }

    public static PcConnectionStatusAction[] values() {
        return (PcConnectionStatusAction[]) f314591a.clone();
    }

    public static PcConnectionStatusAction valueOf(String r100) {
        return (PcConnectionStatusAction) r27.a.a(PcConnectionStatusAction.class, r100);
    }

    public PcConnectionStatusAction(String r100, int r101) {
        super(r100, r101);
    }
}
