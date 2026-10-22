package com.ss.android.lark.compose.chatsetting.report;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_MEMBER", "REMOVE_MEMBER", "GROUP_NAME_AND_AVATAR", "GROUP_QR_CODE", "GROUP_MANAGE", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatSettingFunction extends Enum<ChatSettingFunction> {
    public static final ChatSettingFunction ADD_MEMBER = null;
    public static final ChatSettingFunction GROUP_MANAGE = null;
    public static final ChatSettingFunction GROUP_NAME_AND_AVATAR = null;
    public static final ChatSettingFunction GROUP_QR_CODE = null;
    public static final ChatSettingFunction REMOVE_MEMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatSettingFunction[] f417484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417485b = null;

    public static EnumEntries<ChatSettingFunction> getEntries() {
        return f417485b;
    }

    static {
        ChatSettingFunction r100 = new ChatSettingFunction("ADD_MEMBER", 0);
        ADD_MEMBER = r100;
        ChatSettingFunction r101 = new ChatSettingFunction("REMOVE_MEMBER", 1);
        REMOVE_MEMBER = r101;
        ChatSettingFunction r102 = new ChatSettingFunction("GROUP_NAME_AND_AVATAR", 2);
        GROUP_NAME_AND_AVATAR = r102;
        ChatSettingFunction r103 = new ChatSettingFunction("GROUP_QR_CODE", 3);
        GROUP_QR_CODE = r103;
        ChatSettingFunction r104 = new ChatSettingFunction("GROUP_MANAGE", 4);
        GROUP_MANAGE = r104;
        ChatSettingFunction[] r105 = {r100, r101, r102, r103, r104};
        f417484a = r105;
        f417485b = EnumEntriesKt.enumEntries(r105);
    }

    public static ChatSettingFunction[] values() {
        return (ChatSettingFunction[]) f417484a.clone();
    }

    public static ChatSettingFunction valueOf(String r100) {
        return (ChatSettingFunction) r27.a.a(ChatSettingFunction.class, r100);
    }

    public ChatSettingFunction(String r100, int r101) {
        super(r100, r101);
    }
}
