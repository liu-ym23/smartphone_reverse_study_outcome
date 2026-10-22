package com.bytedance.ug.sdk.deeplink;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/SchemeType;", "", AccountType.ALL, "APP_LINK", "SINGLE_SCHEME", "MULTI_SCHEME", "deeplink_release"}, k = 1, mv = {1, 4, 0})
public final enum SchemeType extends Enum<SchemeType> {
    public static final SchemeType ALL = null;
    public static final SchemeType APP_LINK = null;
    public static final SchemeType MULTI_SCHEME = null;
    public static final SchemeType SINGLE_SCHEME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SchemeType[] f271059a = null;

    static {
        SchemeType r100 = new SchemeType(AccountType.ALL, 0);
        ALL = r100;
        SchemeType r101 = new SchemeType("APP_LINK", 1);
        APP_LINK = r101;
        SchemeType r102 = new SchemeType("SINGLE_SCHEME", 2);
        SINGLE_SCHEME = r102;
        SchemeType r103 = new SchemeType("MULTI_SCHEME", 3);
        MULTI_SCHEME = r103;
        f271059a = new SchemeType[]{r100, r101, r102, r103};
    }

    public static SchemeType valueOf(String r100) {
        return (SchemeType) a.a(SchemeType.class, r100);
    }

    public static SchemeType[] values() {
        return (SchemeType[]) f271059a.clone();
    }

    public SchemeType(String r100, int r101) {
        super(r100, r101);
    }
}
