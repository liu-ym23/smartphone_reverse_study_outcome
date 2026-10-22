package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/larus/settings/provider/ChatListSearchConfig;", "", "chatListSearchIsOn", "", "chatListSearchIsDefaultHidden", "useFts", "chatListBotSearchIsOn", "chatListIconSearchIsOn", "chatListSearchBotsAndMessage", "chatListSearchShowRecommendBots", "chatListSearchShowMessageFirst", "<init>", "(ZZZZZZZZ)V", "getChatListSearchIsOn", "()Z", "getChatListSearchIsDefaultHidden", "getUseFts", "getChatListBotSearchIsOn", "getChatListIconSearchIsOn", "getChatListSearchBotsAndMessage", "getChatListSearchShowRecommendBots", "getChatListSearchShowMessageFirst", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c0 {

    @SerializedName("chatlist_bot_search_is_on")
    private final boolean chatListBotSearchIsOn;

    @SerializedName("chatlist_icon_search_is_on")
    private final boolean chatListIconSearchIsOn;

    @SerializedName("chatlist_search_bots_and_message")
    private final boolean chatListSearchBotsAndMessage;

    @SerializedName("chatlist_search_is_default_hidden")
    private final boolean chatListSearchIsDefaultHidden;

    @SerializedName("chatlist_search_is_on")
    private final boolean chatListSearchIsOn;

    @SerializedName("chatlist_search_show_message_first")
    private final boolean chatListSearchShowMessageFirst;

    @SerializedName("chatlist_search_show_recommend_bots")
    private final boolean chatListSearchShowRecommendBots;

    @SerializedName("search_in_fts")
    private final boolean useFts;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.chatListSearchIsOn == r101.chatListSearchIsOn) goto L12;
        return false;
    L12:
        if (this.chatListSearchIsDefaultHidden == r101.chatListSearchIsDefaultHidden) goto L15;
        return false;
    L15:
        if (this.useFts == r101.useFts) goto L18;
        return false;
    L18:
        if (this.chatListBotSearchIsOn == r101.chatListBotSearchIsOn) goto L21;
        return false;
    L21:
        if (this.chatListIconSearchIsOn == r101.chatListIconSearchIsOn) goto L24;
        return false;
    L24:
        if (this.chatListSearchBotsAndMessage == r101.chatListSearchBotsAndMessage) goto L27;
        return false;
    L27:
        if (this.chatListSearchShowRecommendBots == r101.chatListSearchShowRecommendBots) goto L30;
        return false;
    L30:
        if (this.chatListSearchShowMessageFirst == r101.chatListSearchShowMessageFirst) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.chatListSearchIsOn == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.chatListSearchIsDefaultHidden == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.useFts == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.chatListBotSearchIsOn == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.chatListIconSearchIsOn == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.chatListSearchBotsAndMessage == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.chatListSearchShowRecommendBots == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.chatListSearchShowMessageFirst == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
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
        return "ChatListSearchConfig(chatListSearchIsOn=" + this.chatListSearchIsOn + ", chatListSearchIsDefaultHidden=" + this.chatListSearchIsDefaultHidden + ", useFts=" + this.useFts + ", chatListBotSearchIsOn=" + this.chatListBotSearchIsOn + ", chatListIconSearchIsOn=" + this.chatListIconSearchIsOn + ", chatListSearchBotsAndMessage=" + this.chatListSearchBotsAndMessage + ", chatListSearchShowRecommendBots=" + this.chatListSearchShowRecommendBots + ", chatListSearchShowMessageFirst=" + this.chatListSearchShowMessageFirst + ')';
    }

    public final boolean a() {
        return this.chatListBotSearchIsOn;
    }

    public final boolean b() {
        return this.chatListIconSearchIsOn;
    }

    public final boolean c() {
        return this.chatListSearchBotsAndMessage;
    }

    public final boolean d() {
        return this.chatListSearchIsDefaultHidden;
    }

    public final boolean e() {
        return this.chatListSearchIsOn;
    }

    public final boolean f() {
        return this.chatListSearchShowMessageFirst;
    }

    public final boolean g() {
        return this.chatListSearchShowRecommendBots;
    }

    public final boolean h() {
        return this.useFts;
    }

    public c0(int r100) {
        this.chatListSearchIsOn = false;
        this.chatListSearchIsDefaultHidden = false;
        this.useFts = true;
        this.chatListBotSearchIsOn = false;
        this.chatListIconSearchIsOn = true;
        this.chatListSearchBotsAndMessage = true;
        this.chatListSearchShowRecommendBots = false;
        this.chatListSearchShowMessageFirst = true;
    }
}
