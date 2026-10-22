package com.ss.android.lark.search.dto.service;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/search/dto/service/Union;", "", "<init>", "(Ljava/lang/String;I)V", "YES", "NO", AccountType.ALL, "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Union extends Enum<Union> {
    public static final Union ALL = null;
    public static final Union NO = null;
    public static final Union YES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Union[] f440205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440206b = null;

    public static EnumEntries<Union> getEntries() {
        return f440206b;
    }

    static {
        Union r100 = new Union("YES", 0);
        YES = r100;
        Union r101 = new Union("NO", 1);
        NO = r101;
        Union r102 = new Union(AccountType.ALL, 2);
        ALL = r102;
        Union[] r103 = {r100, r101, r102};
        f440205a = r103;
        f440206b = EnumEntriesKt.enumEntries(r103);
    }

    public static Union[] values() {
        return (Union[]) f440205a.clone();
    }

    public static Union valueOf(String r100) {
        return (Union) a.a(Union.class, r100);
    }

    public Union(String r100, int r101) {
        super(r100, r101);
    }
}
