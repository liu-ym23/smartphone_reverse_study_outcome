package com.bytedance.timonbase.utils;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/timonbase/utils/EnumUtils$WorkType", "", "Lcom/bytedance/timonbase/utils/EnumUtils$WorkType;", "", "value", "I", "getValue", "()I", AccountType.MAIN, "BACKGROUND", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final enum EnumUtils$WorkType extends Enum<EnumUtils$WorkType> {
    public static final EnumUtils$WorkType BACKGROUND = null;
    public static final EnumUtils$WorkType MAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnumUtils$WorkType[] f270902a = null;
    private final int value;

    static {
        EnumUtils$WorkType r100 = new EnumUtils$WorkType(AccountType.MAIN, 0, 0);
        MAIN = r100;
        EnumUtils$WorkType r101 = new EnumUtils$WorkType("BACKGROUND", 1, 1);
        BACKGROUND = r101;
        f270902a = new EnumUtils$WorkType[]{r100, r101};
    }

    public static EnumUtils$WorkType valueOf(String r100) {
        return (EnumUtils$WorkType) r27.a.a(EnumUtils$WorkType.class, r100);
    }

    public static EnumUtils$WorkType[] values() {
        return (EnumUtils$WorkType[]) f270902a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EnumUtils$WorkType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
