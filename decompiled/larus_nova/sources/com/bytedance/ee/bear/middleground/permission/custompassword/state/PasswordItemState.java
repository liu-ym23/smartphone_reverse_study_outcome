package com.bytedance.ee.bear.middleground.permission.custompassword.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/state/PasswordItemState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_TIPS", "STATE_WARNING", "STATE_PASS", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PasswordItemState extends Enum<PasswordItemState> {
    public static final PasswordItemState STATE_PASS = null;
    public static final PasswordItemState STATE_TIPS = null;
    public static final PasswordItemState STATE_WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PasswordItemState[] f233826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233827b = null;

    public static EnumEntries<PasswordItemState> getEntries() {
        return f233827b;
    }

    static {
        PasswordItemState r100 = new PasswordItemState("STATE_TIPS", 0);
        STATE_TIPS = r100;
        PasswordItemState r101 = new PasswordItemState("STATE_WARNING", 1);
        STATE_WARNING = r101;
        PasswordItemState r102 = new PasswordItemState("STATE_PASS", 2);
        STATE_PASS = r102;
        PasswordItemState[] r103 = {r100, r101, r102};
        f233826a = r103;
        f233827b = EnumEntriesKt.enumEntries(r103);
    }

    public static PasswordItemState[] values() {
        return (PasswordItemState[]) f233826a.clone();
    }

    public static PasswordItemState valueOf(String r100) {
        return (PasswordItemState) a.a(PasswordItemState.class, r100);
    }

    public PasswordItemState(String r100, int r101) {
        super(r100, r101);
    }
}
