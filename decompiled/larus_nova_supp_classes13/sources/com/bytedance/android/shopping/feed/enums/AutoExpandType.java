package com.bytedance.android.shopping.feed.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/enums/AutoExpandType;", "", "", "type", "I", "getType", "()I", "DEFAULT", "NEW_USER_AUTO_EXPAND", "OTHER_USER_AUTO_EXPAND", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AutoExpandType extends Enum<AutoExpandType> {
    public static final AutoExpandType DEFAULT = null;
    public static final AutoExpandType NEW_USER_AUTO_EXPAND = null;
    public static final AutoExpandType OTHER_USER_AUTO_EXPAND = null;
    public static final /* synthetic */ AutoExpandType[] a = null;
    private final int type;

    static {
        AutoExpandType r1 = new AutoExpandType("DEFAULT", 0, 0);
        DEFAULT = r1;
        AutoExpandType r2 = new AutoExpandType("NEW_USER_AUTO_EXPAND", 1, 1);
        NEW_USER_AUTO_EXPAND = r2;
        AutoExpandType r3 = new AutoExpandType("OTHER_USER_AUTO_EXPAND", 2, 2);
        OTHER_USER_AUTO_EXPAND = r3;
        a = new AutoExpandType[]{r1, r2, r3};
    }

    public static AutoExpandType valueOf(String r1) {
        return (AutoExpandType) a.a(AutoExpandType.class, r1);
    }

    public static AutoExpandType[] values() {
        return (AutoExpandType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public AutoExpandType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
