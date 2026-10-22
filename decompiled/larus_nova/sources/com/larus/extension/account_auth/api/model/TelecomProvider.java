package com.larus.extension.account_auth.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/extension/account_auth/api/model/TelecomProvider;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHINA_MOBILE", "CHINA_UNICOM", "CHINA_TELECOM", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TelecomProvider extends Enum<TelecomProvider> {
    public static final TelecomProvider CHINA_MOBILE = null;
    public static final TelecomProvider CHINA_TELECOM = null;
    public static final TelecomProvider CHINA_UNICOM = null;
    public static final TelecomProvider UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TelecomProvider[] f342482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f342483b = null;

    public static EnumEntries<TelecomProvider> getEntries() {
        return f342483b;
    }

    static {
        TelecomProvider r100 = new TelecomProvider("UNKNOWN", 0);
        UNKNOWN = r100;
        TelecomProvider r101 = new TelecomProvider("CHINA_MOBILE", 1);
        CHINA_MOBILE = r101;
        TelecomProvider r102 = new TelecomProvider("CHINA_UNICOM", 2);
        CHINA_UNICOM = r102;
        TelecomProvider r103 = new TelecomProvider("CHINA_TELECOM", 3);
        CHINA_TELECOM = r103;
        TelecomProvider[] r104 = {r100, r101, r102, r103};
        f342482a = r104;
        f342483b = EnumEntriesKt.enumEntries(r104);
    }

    public static TelecomProvider[] values() {
        return (TelecomProvider[]) f342482a.clone();
    }

    public static TelecomProvider valueOf(String r100) {
        return (TelecomProvider) a.a(TelecomProvider.class, r100);
    }

    public TelecomProvider(String r100, int r101) {
        super(r100, r101);
    }
}
