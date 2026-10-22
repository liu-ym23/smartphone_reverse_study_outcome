package com.bytedance.ee.bear.middleground.permission.custompassword.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/state/PasswordItemState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_TIPS", "STATE_WARNING", "STATE_PASS", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PasswordItemState extends Enum<PasswordItemState> {
    public static final PasswordItemState STATE_PASS = null;
    public static final PasswordItemState STATE_TIPS = null;
    public static final PasswordItemState STATE_WARNING = null;
    public static final /* synthetic */ PasswordItemState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PasswordItemState> getEntries() {
        return b;
    }

    static {
        PasswordItemState r0 = new PasswordItemState("STATE_TIPS", 0);
        STATE_TIPS = r0;
        PasswordItemState r1 = new PasswordItemState("STATE_WARNING", 1);
        STATE_WARNING = r1;
        PasswordItemState r3 = new PasswordItemState("STATE_PASS", 2);
        STATE_PASS = r3;
        PasswordItemState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PasswordItemState[] values() {
        return (PasswordItemState[]) a.clone();
    }

    public static PasswordItemState valueOf(String r1) {
        return (PasswordItemState) a.a(PasswordItemState.class, r1);
    }

    public PasswordItemState(String r1, int r2) {
        super(r1, r2);
    }
}
