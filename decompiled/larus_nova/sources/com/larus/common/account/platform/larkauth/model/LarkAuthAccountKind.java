package com.larus.common.account.platform.larkauth.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/platform/larkauth/model/LarkAuthAccountKind;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN_C", "LOGIN_B", "UNKNOWN", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkAuthAccountKind extends Enum<LarkAuthAccountKind> {
    public static final LarkAuthAccountKind LOGIN_B = null;
    public static final LarkAuthAccountKind LOGIN_C = null;
    public static final LarkAuthAccountKind UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkAuthAccountKind[] f326138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f326139b = null;

    public static EnumEntries<LarkAuthAccountKind> getEntries() {
        return f326139b;
    }

    static {
        LarkAuthAccountKind r100 = new LarkAuthAccountKind("LOGIN_C", 0);
        LOGIN_C = r100;
        LarkAuthAccountKind r101 = new LarkAuthAccountKind("LOGIN_B", 1);
        LOGIN_B = r101;
        LarkAuthAccountKind r102 = new LarkAuthAccountKind("UNKNOWN", 2);
        UNKNOWN = r102;
        LarkAuthAccountKind[] r103 = {r100, r101, r102};
        f326138a = r103;
        f326139b = EnumEntriesKt.enumEntries(r103);
    }

    public static LarkAuthAccountKind[] values() {
        return (LarkAuthAccountKind[]) f326138a.clone();
    }

    public static LarkAuthAccountKind valueOf(String r100) {
        return (LarkAuthAccountKind) r27.a.a(LarkAuthAccountKind.class, r100);
    }

    public LarkAuthAccountKind(String r100, int r101) {
        super(r100, r101);
    }
}
