package com.larus.account.base.api;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/account/base/api/ConversationAuthUpdateScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserChangedCallback.CHANGE_TYPE_LOGIN, "Bind", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationAuthUpdateScene extends Enum<ConversationAuthUpdateScene> {
    public static final ConversationAuthUpdateScene Bind = null;
    public static final ConversationAuthUpdateScene Login = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConversationAuthUpdateScene[] f286092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286093b = null;
    private final int value;

    public static EnumEntries<ConversationAuthUpdateScene> getEntries() {
        return f286093b;
    }

    static {
        ConversationAuthUpdateScene r100 = new ConversationAuthUpdateScene(UserChangedCallback.CHANGE_TYPE_LOGIN, 0, 1);
        Login = r100;
        ConversationAuthUpdateScene r101 = new ConversationAuthUpdateScene("Bind", 1, 2);
        Bind = r101;
        ConversationAuthUpdateScene[] r102 = {r100, r101};
        f286092a = r102;
        f286093b = EnumEntriesKt.enumEntries(r102);
    }

    public static ConversationAuthUpdateScene[] values() {
        return (ConversationAuthUpdateScene[]) f286092a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationAuthUpdateScene valueOf(String r100) {
        return (ConversationAuthUpdateScene) a.a(ConversationAuthUpdateScene.class, r100);
    }

    public ConversationAuthUpdateScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
