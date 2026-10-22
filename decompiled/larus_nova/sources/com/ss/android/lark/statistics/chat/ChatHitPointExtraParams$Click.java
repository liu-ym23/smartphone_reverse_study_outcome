package com.ss.android.lark.statistics.chat;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$Click;", "Lcom/ss/android/lark/statistics/extensions/IClickParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INPUT_BOX_MSG_SEND", "ATTACHMENT_AREA_FILE_INSERT", "PIN_TO_TOP", "PIN_TO_TOP_OWNER", "CLICK_PIN_TO_TOP", "CLOSE_PIN_TO_TOP", "SEND_TO_CHAT_AND_PIN_TO_TOP", "SEND_TO_CHAT", "OPEN_PAGE", "OPEN_URL", "CLOSE", "BUTTON", "REPLY_IN_THREAD", "MSG_SEND", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$Click extends Enum<ChatHitPointExtraParams$Click> implements s5c.d {
    public static final ChatHitPointExtraParams$Click ATTACHMENT_AREA_FILE_INSERT = null;
    public static final ChatHitPointExtraParams$Click BUTTON = null;
    public static final ChatHitPointExtraParams$Click CLICK_PIN_TO_TOP = null;
    public static final ChatHitPointExtraParams$Click CLOSE = null;
    public static final ChatHitPointExtraParams$Click CLOSE_PIN_TO_TOP = null;
    public static final ChatHitPointExtraParams$Click INPUT_BOX_MSG_SEND = null;
    public static final ChatHitPointExtraParams$Click MSG_SEND = null;
    public static final ChatHitPointExtraParams$Click OPEN_PAGE = null;
    public static final ChatHitPointExtraParams$Click OPEN_URL = null;
    public static final ChatHitPointExtraParams$Click PIN_TO_TOP = null;
    public static final ChatHitPointExtraParams$Click PIN_TO_TOP_OWNER = null;
    public static final ChatHitPointExtraParams$Click REPLY_IN_THREAD = null;
    public static final ChatHitPointExtraParams$Click SEND_TO_CHAT = null;
    public static final ChatHitPointExtraParams$Click SEND_TO_CHAT_AND_PIN_TO_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$Click[] f440633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440634b = null;
    private final String value;

    public static EnumEntries<ChatHitPointExtraParams$Click> getEntries() {
        return f440634b;
    }

    @Override // s5c.d
    public String getKey() {
        return "click";
    }

    static {
        ChatHitPointExtraParams$Click r100 = new ChatHitPointExtraParams$Click("INPUT_BOX_MSG_SEND", 0, "input_box_msg_send");
        INPUT_BOX_MSG_SEND = r100;
        ChatHitPointExtraParams$Click r101 = new ChatHitPointExtraParams$Click("ATTACHMENT_AREA_FILE_INSERT", 1, "attachment_area_file_insert");
        ATTACHMENT_AREA_FILE_INSERT = r101;
        ChatHitPointExtraParams$Click r102 = new ChatHitPointExtraParams$Click("PIN_TO_TOP", 2, "pin_to_top");
        PIN_TO_TOP = r102;
        ChatHitPointExtraParams$Click r103 = new ChatHitPointExtraParams$Click("PIN_TO_TOP_OWNER", 3, "pin_to_top_owner");
        PIN_TO_TOP_OWNER = r103;
        ChatHitPointExtraParams$Click r104 = new ChatHitPointExtraParams$Click("CLICK_PIN_TO_TOP", 4, "click_pin_to_top");
        CLICK_PIN_TO_TOP = r104;
        ChatHitPointExtraParams$Click r105 = new ChatHitPointExtraParams$Click("CLOSE_PIN_TO_TOP", 5, "close_pin_to_top");
        CLOSE_PIN_TO_TOP = r105;
        ChatHitPointExtraParams$Click r110 = new ChatHitPointExtraParams$Click("SEND_TO_CHAT_AND_PIN_TO_TOP", 6, "send_to_chat_and_pin_to_top");
        SEND_TO_CHAT_AND_PIN_TO_TOP = r110;
        ChatHitPointExtraParams$Click r111 = new ChatHitPointExtraParams$Click("SEND_TO_CHAT", 7, "send_to_chat");
        SEND_TO_CHAT = r111;
        ChatHitPointExtraParams$Click r112 = new ChatHitPointExtraParams$Click("OPEN_PAGE", 8, "open_page");
        OPEN_PAGE = r112;
        ChatHitPointExtraParams$Click r113 = new ChatHitPointExtraParams$Click("OPEN_URL", 9, "open_url");
        OPEN_URL = r113;
        ChatHitPointExtraParams$Click r114 = new ChatHitPointExtraParams$Click("CLOSE", 10, "close");
        CLOSE = r114;
        ChatHitPointExtraParams$Click r106 = new ChatHitPointExtraParams$Click("BUTTON", 11, "button");
        BUTTON = r106;
        ChatHitPointExtraParams$Click r107 = new ChatHitPointExtraParams$Click("REPLY_IN_THREAD", 12, "reply_in_thread");
        REPLY_IN_THREAD = r107;
        ChatHitPointExtraParams$Click r108 = new ChatHitPointExtraParams$Click("MSG_SEND", 13, "msg_send");
        MSG_SEND = r108;
        ChatHitPointExtraParams$Click[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
        f440633a = r109;
        f440634b = EnumEntriesKt.enumEntries(r109);
    }

    public static ChatHitPointExtraParams$Click[] values() {
        return (ChatHitPointExtraParams$Click[]) f440633a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static ChatHitPointExtraParams$Click valueOf(String r100) {
        return (ChatHitPointExtraParams$Click) r27.a.a(ChatHitPointExtraParams$Click.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$Click(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
