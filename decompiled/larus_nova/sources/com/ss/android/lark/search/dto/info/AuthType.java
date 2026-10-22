package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/search/dto/info/AuthType;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW_AUTH", "SHARE_AUTH", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthType extends Enum<AuthType> {
    public static final AuthType PREVIEW_AUTH = null;
    public static final AuthType SHARE_AUTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthType[] f440151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440152b = null;

    public static EnumEntries<AuthType> getEntries() {
        return f440152b;
    }

    static {
        AuthType r100 = new AuthType("PREVIEW_AUTH", 0);
        PREVIEW_AUTH = r100;
        AuthType r101 = new AuthType("SHARE_AUTH", 1);
        SHARE_AUTH = r101;
        AuthType[] r102 = {r100, r101};
        f440151a = r102;
        f440152b = EnumEntriesKt.enumEntries(r102);
    }

    public static AuthType[] values() {
        return (AuthType[]) f440151a.clone();
    }

    public static AuthType valueOf(String r100) {
        return (AuthType) r27.a.a(AuthType.class, r100);
    }

    public AuthType(String r100, int r101) {
        super(r100, r101);
    }
}
