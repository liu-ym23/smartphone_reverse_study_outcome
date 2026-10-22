package com.ss.android.lark.statistics.chat;

import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$UrlAnalysisScene;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "CHAT_STATUS", "MY_PAGE", "PROFILE_SIGN", "CHAT_NAVIBAR", "USER_STATUS", "CHATTER_LIST", "CHAT", "CHAT_DETAIL", "THREAD", "THREAD_DETAIL", "MERGE_FORWARD", "FAVORITE", "PIN", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$UrlAnalysisScene extends Enum<ChatHitPointExtraParams$UrlAnalysisScene> implements s5c.d {
    public static final ChatHitPointExtraParams$UrlAnalysisScene CHAT = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene CHATTER_LIST = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene CHAT_DETAIL = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene CHAT_NAVIBAR = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene CHAT_STATUS = null;
    public static final a Companion = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene FAVORITE = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene MERGE_FORWARD = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene MY_PAGE = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene PIN = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene PROFILE_SIGN = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene THREAD = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene THREAD_DETAIL = null;
    public static final ChatHitPointExtraParams$UrlAnalysisScene USER_STATUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$UrlAnalysisScene[] f440657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440658b = null;
    private final String key;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public ChatHitPointExtraParams$UrlAnalysisScene() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$UrlAnalysisScene> getEntries() {
        return f440658b;
    }

    static {
        ChatHitPointExtraParams$UrlAnalysisScene r100 = new ChatHitPointExtraParams$UrlAnalysisScene("CHAT_STATUS", 0, "chat_status", null, 2, null);
        CHAT_STATUS = r100;
        ChatHitPointExtraParams$UrlAnalysisScene r101 = new ChatHitPointExtraParams$UrlAnalysisScene("MY_PAGE", 1, "my_page", null, 2, null);
        MY_PAGE = r101;
        ChatHitPointExtraParams$UrlAnalysisScene r102 = new ChatHitPointExtraParams$UrlAnalysisScene("PROFILE_SIGN", 2, "profile_sign", null, 2, null);
        PROFILE_SIGN = r102;
        ChatHitPointExtraParams$UrlAnalysisScene r103 = new ChatHitPointExtraParams$UrlAnalysisScene("CHAT_NAVIBAR", 3, "chat_navibar", null, 2, null);
        CHAT_NAVIBAR = r103;
        ChatHitPointExtraParams$UrlAnalysisScene r104 = new ChatHitPointExtraParams$UrlAnalysisScene("USER_STATUS", 4, "user_status", null, 2, null);
        USER_STATUS = r104;
        ChatHitPointExtraParams$UrlAnalysisScene r110 = new ChatHitPointExtraParams$UrlAnalysisScene("CHATTER_LIST", 5, "chatter_list", null, 2, null);
        CHATTER_LIST = r110;
        ChatHitPointExtraParams$UrlAnalysisScene r210 = new ChatHitPointExtraParams$UrlAnalysisScene("CHAT", 6, "chat", null, 2, null);
        CHAT = r210;
        ChatHitPointExtraParams$UrlAnalysisScene r211 = new ChatHitPointExtraParams$UrlAnalysisScene("CHAT_DETAIL", 7, "chat_detail", null, 2, null);
        CHAT_DETAIL = r211;
        ChatHitPointExtraParams$UrlAnalysisScene r111 = new ChatHitPointExtraParams$UrlAnalysisScene("THREAD", 8, "thread", null, 2, null);
        THREAD = r111;
        ChatHitPointExtraParams$UrlAnalysisScene r105 = new ChatHitPointExtraParams$UrlAnalysisScene("THREAD_DETAIL", 9, "thread_detail", null, 2, null);
        THREAD_DETAIL = r105;
        ChatHitPointExtraParams$UrlAnalysisScene r106 = new ChatHitPointExtraParams$UrlAnalysisScene("MERGE_FORWARD", 10, ShareChannel.MERGE_FORWARD, null, 2, null);
        MERGE_FORWARD = r106;
        ChatHitPointExtraParams$UrlAnalysisScene r112 = new ChatHitPointExtraParams$UrlAnalysisScene("FAVORITE", 11, "favorite", null, 2, null);
        FAVORITE = r112;
        ChatHitPointExtraParams$UrlAnalysisScene r212 = new ChatHitPointExtraParams$UrlAnalysisScene("PIN", 12, "pin", null, 2, null);
        PIN = r212;
        ChatHitPointExtraParams$UrlAnalysisScene[] r107 = {r100, r101, r102, r103, r104, r110, r210, r211, r111, r105, r106, r112, r212};
        f440657a = r107;
        f440658b = EnumEntriesKt.enumEntries(r107);
        Companion = new a();
    }

    public static ChatHitPointExtraParams$UrlAnalysisScene[] values() {
        return (ChatHitPointExtraParams$UrlAnalysisScene[]) f440657a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public String getKey() {
        return this.key;
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static ChatHitPointExtraParams$UrlAnalysisScene valueOf(String r100) {
        return (ChatHitPointExtraParams$UrlAnalysisScene) r27.a.a(ChatHitPointExtraParams$UrlAnalysisScene.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$UrlAnalysisScene(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "scene";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
