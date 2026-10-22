package com.ss.android.lark.compose.groupinfo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/GroupInfoToast;", "", "<init>", "(Ljava/lang/String;I)V", "SAVE_SUCCESS", "EDIT_NOT_ALLOWED", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GroupInfoToast extends Enum<GroupInfoToast> {
    public static final GroupInfoToast EDIT_NOT_ALLOWED = null;
    public static final GroupInfoToast SAVE_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupInfoToast[] f417704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417705b = null;

    public static EnumEntries<GroupInfoToast> getEntries() {
        return f417705b;
    }

    static {
        GroupInfoToast r100 = new GroupInfoToast("SAVE_SUCCESS", 0);
        SAVE_SUCCESS = r100;
        GroupInfoToast r101 = new GroupInfoToast("EDIT_NOT_ALLOWED", 1);
        EDIT_NOT_ALLOWED = r101;
        GroupInfoToast[] r102 = {r100, r101};
        f417704a = r102;
        f417705b = EnumEntriesKt.enumEntries(r102);
    }

    public static GroupInfoToast[] values() {
        return (GroupInfoToast[]) f417704a.clone();
    }

    public static GroupInfoToast valueOf(String r100) {
        return (GroupInfoToast) r27.a.a(GroupInfoToast.class, r100);
    }

    public GroupInfoToast(String r100, int r101) {
        super(r100, r101);
    }
}
