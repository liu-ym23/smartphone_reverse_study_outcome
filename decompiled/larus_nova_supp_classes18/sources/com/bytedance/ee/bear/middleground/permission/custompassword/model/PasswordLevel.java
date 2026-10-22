package com.bytedance.ee.bear.middleground.permission.custompassword.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PasswordLevel;", "", "<init>", "(Ljava/lang/String;I)V", "STRONG", "MIDDLE", "WEAK", "NO", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PasswordLevel extends Enum<PasswordLevel> {
    public static final PasswordLevel MIDDLE = null;
    public static final PasswordLevel NO = null;
    public static final PasswordLevel STRONG = null;
    public static final PasswordLevel WEAK = null;
    public static final /* synthetic */ PasswordLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PasswordLevel> getEntries() {
        return b;
    }

    static {
        PasswordLevel r0 = new PasswordLevel("STRONG", 0);
        STRONG = r0;
        PasswordLevel r1 = new PasswordLevel("MIDDLE", 1);
        MIDDLE = r1;
        PasswordLevel r3 = new PasswordLevel("WEAK", 2);
        WEAK = r3;
        PasswordLevel r5 = new PasswordLevel("NO", 3);
        NO = r5;
        PasswordLevel[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PasswordLevel[] values() {
        return (PasswordLevel[]) a.clone();
    }

    public static PasswordLevel valueOf(String r1) {
        return (PasswordLevel) a.a(PasswordLevel.class, r1);
    }

    public PasswordLevel(String r1, int r2) {
        super(r1, r2);
    }
}
