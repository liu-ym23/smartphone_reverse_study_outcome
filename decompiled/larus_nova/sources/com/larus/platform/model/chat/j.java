package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/chat/ChatPageLoadOptConfig;", "", "removeGetParticipants", "", "sidebarRemoveGetBot", "appIconUseLocalBot", "mainBotModelCache", "conversationCallOpt", "globalNotifyRemoteMessageOpt", "<init>", "(ZZZZZZ)V", "getRemoveGetParticipants", "()Z", "getSidebarRemoveGetBot", "getAppIconUseLocalBot", "getMainBotModelCache", "getConversationCallOpt", "getGlobalNotifyRemoteMessageOpt", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("app_icon_use_local_bot")
    private final boolean appIconUseLocalBot;

    @SerializedName("conversation_call_opt")
    private final boolean conversationCallOpt;

    @SerializedName("global_notify_remote_message_opt")
    private final boolean globalNotifyRemoteMessageOpt;

    @SerializedName("main_bot_model_cache")
    private final boolean mainBotModelCache;

    @SerializedName("remove_get_participants")
    private final boolean removeGetParticipants;

    @SerializedName("sidebar_remove_get_bot")
    private final boolean sidebarRemoveGetBot;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.removeGetParticipants == r101.removeGetParticipants) goto L12;
        return false;
    L12:
        if (this.sidebarRemoveGetBot == r101.sidebarRemoveGetBot) goto L15;
        return false;
    L15:
        if (this.appIconUseLocalBot == r101.appIconUseLocalBot) goto L18;
        return false;
    L18:
        if (this.mainBotModelCache == r101.mainBotModelCache) goto L21;
        return false;
    L21:
        if (this.conversationCallOpt == r101.conversationCallOpt) goto L24;
        return false;
    L24:
        if (this.globalNotifyRemoteMessageOpt == r101.globalNotifyRemoteMessageOpt) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.removeGetParticipants == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.sidebarRemoveGetBot == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.appIconUseLocalBot == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.mainBotModelCache == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.conversationCallOpt == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.globalNotifyRemoteMessageOpt == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatPageLoadOptConfig(removeGetParticipants=" + this.removeGetParticipants + ", sidebarRemoveGetBot=" + this.sidebarRemoveGetBot + ", appIconUseLocalBot=" + this.appIconUseLocalBot + ", mainBotModelCache=" + this.mainBotModelCache + ", conversationCallOpt=" + this.conversationCallOpt + ", globalNotifyRemoteMessageOpt=" + this.globalNotifyRemoteMessageOpt + ')';
    }

    public final boolean a() {
        return this.appIconUseLocalBot;
    }

    public final boolean b() {
        return this.conversationCallOpt;
    }

    public final boolean c() {
        return this.globalNotifyRemoteMessageOpt;
    }

    public final boolean d() {
        return this.mainBotModelCache;
    }

    public final boolean e() {
        return this.removeGetParticipants;
    }

    public final boolean f() {
        return this.sidebarRemoveGetBot;
    }

    public j(int r100) {
        this.removeGetParticipants = false;
        this.sidebarRemoveGetBot = false;
        this.appIconUseLocalBot = false;
        this.mainBotModelCache = false;
        this.conversationCallOpt = false;
        this.globalNotifyRemoteMessageOpt = false;
    }
}
