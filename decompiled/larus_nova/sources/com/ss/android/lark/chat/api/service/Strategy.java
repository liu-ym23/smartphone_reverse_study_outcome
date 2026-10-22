package com.ss.android.lark.chat.api.service;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/api/service/Strategy;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "TRY_LOCAL", "FORCE_SERVER", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Strategy extends Enum<Strategy> {
    public static final Strategy FORCE_SERVER = null;
    public static final Strategy LOCAL = null;
    public static final Strategy TRY_LOCAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Strategy[] f411529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411530b = null;

    public static EnumEntries<Strategy> getEntries() {
        return f411530b;
    }

    static {
        Strategy r100 = new Strategy(AccountType.LOCAL, 0);
        LOCAL = r100;
        Strategy r101 = new Strategy("TRY_LOCAL", 1);
        TRY_LOCAL = r101;
        Strategy r102 = new Strategy("FORCE_SERVER", 2);
        FORCE_SERVER = r102;
        Strategy[] r103 = {r100, r101, r102};
        f411529a = r103;
        f411530b = EnumEntriesKt.enumEntries(r103);
    }

    public static Strategy[] values() {
        return (Strategy[]) f411529a.clone();
    }

    public static Strategy valueOf(String r100) {
        return (Strategy) a.a(Strategy.class, r100);
    }

    public Strategy(String r100, int r101) {
        super(r100, r101);
    }
}
