package com.ss.android.lark.search.doubao.api.request;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/request/OuterGroupOption;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.ALL, "ONLY_OUTER", "ONLY_INNER", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OuterGroupOption extends Enum<OuterGroupOption> {
    public static final OuterGroupOption ALL = null;
    public static final OuterGroupOption ONLY_INNER = null;
    public static final OuterGroupOption ONLY_OUTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OuterGroupOption[] f439946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439947b = null;

    public static EnumEntries<OuterGroupOption> getEntries() {
        return f439947b;
    }

    static {
        OuterGroupOption r100 = new OuterGroupOption(AccountType.ALL, 0);
        ALL = r100;
        OuterGroupOption r101 = new OuterGroupOption("ONLY_OUTER", 1);
        ONLY_OUTER = r101;
        OuterGroupOption r102 = new OuterGroupOption("ONLY_INNER", 2);
        ONLY_INNER = r102;
        OuterGroupOption[] r103 = {r100, r101, r102};
        f439946a = r103;
        f439947b = EnumEntriesKt.enumEntries(r103);
    }

    public static OuterGroupOption[] values() {
        return (OuterGroupOption[]) f439946a.clone();
    }

    public static OuterGroupOption valueOf(String r100) {
        return (OuterGroupOption) r27.a.a(OuterGroupOption.class, r100);
    }

    public OuterGroupOption(String r100, int r101) {
        super(r100, r101);
    }
}
