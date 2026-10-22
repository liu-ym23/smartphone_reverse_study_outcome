package com.lark.kmp.basic;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/lark/kmp/basic/ReturnType;", "", "<init>", "(Ljava/lang/String;I)V", "QUICK_ONLINE_RETURN", "Foreground", CancelRetainContactInfoFunctions.All, "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReturnType extends Enum<ReturnType> {
    public static final ReturnType All = null;
    public static final ReturnType Foreground = null;
    public static final ReturnType QUICK_ONLINE_RETURN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReturnType[] f278573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f278574b = null;

    public static EnumEntries<ReturnType> getEntries() {
        return f278574b;
    }

    static {
        ReturnType r100 = new ReturnType("QUICK_ONLINE_RETURN", 0);
        QUICK_ONLINE_RETURN = r100;
        ReturnType r101 = new ReturnType("Foreground", 1);
        Foreground = r101;
        ReturnType r102 = new ReturnType(CancelRetainContactInfoFunctions.All, 2);
        All = r102;
        ReturnType[] r103 = {r100, r101, r102};
        f278573a = r103;
        f278574b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReturnType[] values() {
        return (ReturnType[]) f278573a.clone();
    }

    public static ReturnType valueOf(String r100) {
        return (ReturnType) a.a(ReturnType.class, r100);
    }

    public ReturnType(String r100, int r101) {
        super(r100, r101);
    }
}
