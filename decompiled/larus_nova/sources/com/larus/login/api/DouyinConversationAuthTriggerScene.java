package com.larus.login.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/login/api/DouyinConversationAuthTriggerScene;", "", "<init>", "(Ljava/lang/String;I)V", "DOUYIN_LOGIN", "ACCOUNT_BIND", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DouyinConversationAuthTriggerScene extends Enum<DouyinConversationAuthTriggerScene> {
    public static final DouyinConversationAuthTriggerScene ACCOUNT_BIND = null;
    public static final DouyinConversationAuthTriggerScene DOUYIN_LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DouyinConversationAuthTriggerScene[] f356986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356987b = null;

    public static EnumEntries<DouyinConversationAuthTriggerScene> getEntries() {
        return f356987b;
    }

    static {
        DouyinConversationAuthTriggerScene r100 = new DouyinConversationAuthTriggerScene("DOUYIN_LOGIN", 0);
        DOUYIN_LOGIN = r100;
        DouyinConversationAuthTriggerScene r101 = new DouyinConversationAuthTriggerScene("ACCOUNT_BIND", 1);
        ACCOUNT_BIND = r101;
        DouyinConversationAuthTriggerScene[] r102 = {r100, r101};
        f356986a = r102;
        f356987b = EnumEntriesKt.enumEntries(r102);
    }

    public static DouyinConversationAuthTriggerScene[] values() {
        return (DouyinConversationAuthTriggerScene[]) f356986a.clone();
    }

    public static DouyinConversationAuthTriggerScene valueOf(String r100) {
        return (DouyinConversationAuthTriggerScene) r27.a.a(DouyinConversationAuthTriggerScene.class, r100);
    }

    public DouyinConversationAuthTriggerScene(String r100, int r101) {
        super(r100, r101);
    }
}
