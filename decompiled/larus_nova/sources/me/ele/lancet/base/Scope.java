package me.ele.lancet.base;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Scope extends Enum<Scope> {
    private static final /* synthetic */ Scope[] $VALUES = null;
    public static final Scope ALL = null;
    public static final Scope ALL_SELF = null;
    public static final Scope DIRECT = null;
    public static final Scope DIRECT_SELF = null;
    public static final Scope LEAF = null;
    public static final Scope SELF = null;

    static {
        Scope r100 = new Scope("SELF", 0);
        SELF = r100;
        Scope r101 = new Scope("DIRECT", 1);
        DIRECT = r101;
        Scope r102 = new Scope(AccountType.ALL, 2);
        ALL = r102;
        Scope r103 = new Scope("LEAF", 3);
        LEAF = r103;
        Scope r104 = new Scope("ALL_SELF", 4);
        ALL_SELF = r104;
        Scope r105 = new Scope("DIRECT_SELF", 5);
        DIRECT_SELF = r105;
        $VALUES = new Scope[]{r100, r101, r102, r103, r104, r105};
    }

    public static Scope[] values() {
        return (Scope[]) $VALUES.clone();
    }

    public static Scope valueOf(String r100) {
        return (Scope) a.a(Scope.class, r100);
    }

    private Scope(String r100, int r101) {
        super(r100, r101);
    }
}
