package com.larus.canvas.feature.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/ability/UpdateProgress;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_START", "UPDATING", "UPDATE_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateProgress extends Enum<UpdateProgress> {
    public static final UpdateProgress UPDATE_END = null;
    public static final UpdateProgress UPDATE_START = null;
    public static final UpdateProgress UPDATING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateProgress[] f323030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323031b = null;

    public static EnumEntries<UpdateProgress> getEntries() {
        return f323031b;
    }

    static {
        UpdateProgress r100 = new UpdateProgress("UPDATE_START", 0);
        UPDATE_START = r100;
        UpdateProgress r101 = new UpdateProgress("UPDATING", 1);
        UPDATING = r101;
        UpdateProgress r102 = new UpdateProgress("UPDATE_END", 2);
        UPDATE_END = r102;
        UpdateProgress[] r103 = {r100, r101, r102};
        f323030a = r103;
        f323031b = EnumEntriesKt.enumEntries(r103);
    }

    public static UpdateProgress[] values() {
        return (UpdateProgress[]) f323030a.clone();
    }

    public static UpdateProgress valueOf(String r100) {
        return (UpdateProgress) a.a(UpdateProgress.class, r100);
    }

    public UpdateProgress(String r100, int r101) {
        super(r100, r101);
    }
}
