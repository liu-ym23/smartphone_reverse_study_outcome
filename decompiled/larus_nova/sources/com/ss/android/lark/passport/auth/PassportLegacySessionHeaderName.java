package com.ss.android.lark.passport.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/auth/PassportLegacySessionHeaderName;", "", "<init>", "(Ljava/lang/String;I)V", "SUITE_SESSION_KEY", "SESSION_ID", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PassportLegacySessionHeaderName extends Enum<PassportLegacySessionHeaderName> {
    public static final PassportLegacySessionHeaderName SESSION_ID = null;
    public static final PassportLegacySessionHeaderName SUITE_SESSION_KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PassportLegacySessionHeaderName[] f437709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437710b = null;

    public static EnumEntries<PassportLegacySessionHeaderName> getEntries() {
        return f437710b;
    }

    static {
        PassportLegacySessionHeaderName r100 = new PassportLegacySessionHeaderName("SUITE_SESSION_KEY", 0);
        SUITE_SESSION_KEY = r100;
        PassportLegacySessionHeaderName r101 = new PassportLegacySessionHeaderName("SESSION_ID", 1);
        SESSION_ID = r101;
        PassportLegacySessionHeaderName[] r102 = {r100, r101};
        f437709a = r102;
        f437710b = EnumEntriesKt.enumEntries(r102);
    }

    public static PassportLegacySessionHeaderName[] values() {
        return (PassportLegacySessionHeaderName[]) f437709a.clone();
    }

    public static PassportLegacySessionHeaderName valueOf(String r100) {
        return (PassportLegacySessionHeaderName) r27.a.a(PassportLegacySessionHeaderName.class, r100);
    }

    public PassportLegacySessionHeaderName(String r100, int r101) {
        super(r100, r101);
    }
}
