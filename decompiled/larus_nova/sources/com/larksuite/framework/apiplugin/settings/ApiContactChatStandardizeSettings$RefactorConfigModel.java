package com.larksuite.framework.apiplugin.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@AppConfig(key = "contact_chat_standardize")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larksuite/framework/apiplugin/settings/ApiContactChatStandardizeSettings$RefactorConfigModel;", "", "<init>", "()V", "chooseContact", "", "getChooseContact", "()Z", "setChooseContact", "(Z)V", "enterChat", "getEnterChat", "setEnterChat", "getChatInfo", "getGetChatInfo", "setGetChatInfo", "getChatInfoAuth", "getGetChatInfoAuth", "setGetChatInfoAuth", "toString", "", "open-plugin-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApiContactChatStandardizeSettings$RefactorConfigModel {

    @SerializedName("chooseContact")
    private boolean chooseContact;

    @SerializedName("enterChat")
    private boolean enterChat;

    @SerializedName("getChatInfo")
    private boolean getChatInfo;

    @SerializedName("getChatInfo_fix_auth")
    private boolean getChatInfoAuth;

    public ApiContactChatStandardizeSettings$RefactorConfigModel() {
    }

    public final String toString() {
        return "\n                RefactorConfigModel {\n                    enableChooseContact = " + this.chooseContact + "\n                    enableEnterChat = " + this.enterChat + "\n                    enableGetChatInfo = " + this.getChatInfo + "\n                    getChatInfo_fix_auth = " + this.getChatInfoAuth + "\n                }\n            ";
    }
}
