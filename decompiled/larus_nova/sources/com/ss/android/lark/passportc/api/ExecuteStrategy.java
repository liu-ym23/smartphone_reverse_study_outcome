package com.ss.android.lark.passportc.api;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passportc/api/ExecuteStrategy;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "RETRY", "ROLLBACK", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExecuteStrategy extends Enum<ExecuteStrategy> {
    public static final ExecuteStrategy NORMAL = null;
    public static final ExecuteStrategy RETRY = null;
    public static final ExecuteStrategy ROLLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecuteStrategy[] f438099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438100b = null;

    public static EnumEntries<ExecuteStrategy> getEntries() {
        return f438100b;
    }

    static {
        ExecuteStrategy r100 = new ExecuteStrategy(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ExecuteStrategy r101 = new ExecuteStrategy("RETRY", 1);
        RETRY = r101;
        ExecuteStrategy r102 = new ExecuteStrategy("ROLLBACK", 2);
        ROLLBACK = r102;
        ExecuteStrategy[] r103 = {r100, r101, r102};
        f438099a = r103;
        f438100b = EnumEntriesKt.enumEntries(r103);
    }

    public static ExecuteStrategy[] values() {
        return (ExecuteStrategy[]) f438099a.clone();
    }

    public static ExecuteStrategy valueOf(String r100) {
        return (ExecuteStrategy) r27.a.a(ExecuteStrategy.class, r100);
    }

    public ExecuteStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
