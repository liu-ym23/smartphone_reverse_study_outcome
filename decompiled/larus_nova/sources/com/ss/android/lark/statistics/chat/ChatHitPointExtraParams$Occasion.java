package com.ss.android.lark.statistics.chat;

import com.larus.bmhome.share.panel.ShareChannel;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$Occasion;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "MOMENTS", AlarmSessionType.TODO, "MSG", "FAVORITE", "MULTI_FORWARD", "PIN", "MY_PAGE", "TOPIC", "FEED_PREVIEW", "PROFILE_SIGN", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$Occasion extends Enum<ChatHitPointExtraParams$Occasion> implements s5c.d {
    public static final ChatHitPointExtraParams$Occasion FAVORITE = null;
    public static final ChatHitPointExtraParams$Occasion FEED_PREVIEW = null;
    public static final ChatHitPointExtraParams$Occasion MOMENTS = null;
    public static final ChatHitPointExtraParams$Occasion MSG = null;
    public static final ChatHitPointExtraParams$Occasion MULTI_FORWARD = null;
    public static final ChatHitPointExtraParams$Occasion MY_PAGE = null;
    public static final ChatHitPointExtraParams$Occasion PIN = null;
    public static final ChatHitPointExtraParams$Occasion PROFILE_SIGN = null;
    public static final ChatHitPointExtraParams$Occasion TODO = null;
    public static final ChatHitPointExtraParams$Occasion TOPIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$Occasion[] f440647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440648b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$Occasion() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$Occasion> getEntries() {
        return f440648b;
    }

    static {
        ChatHitPointExtraParams$Occasion r100 = new ChatHitPointExtraParams$Occasion("MOMENTS", 0, ShareChannel.WX_MOMENTS, null, 2, null);
        MOMENTS = r100;
        ChatHitPointExtraParams$Occasion r101 = new ChatHitPointExtraParams$Occasion(AlarmSessionType.TODO, 1, IOfflineExtraParser.ParserType.TODO, null, 2, null);
        TODO = r101;
        ChatHitPointExtraParams$Occasion r102 = new ChatHitPointExtraParams$Occasion("MSG", 2, "msg", null, 2, null);
        MSG = r102;
        ChatHitPointExtraParams$Occasion r103 = new ChatHitPointExtraParams$Occasion("FAVORITE", 3, "favorite", null, 2, null);
        FAVORITE = r103;
        ChatHitPointExtraParams$Occasion r104 = new ChatHitPointExtraParams$Occasion("MULTI_FORWARD", 4, "multi_forward", null, 2, null);
        MULTI_FORWARD = r104;
        ChatHitPointExtraParams$Occasion r105 = new ChatHitPointExtraParams$Occasion("PIN", 5, "pin", null, 2, null);
        PIN = r105;
        ChatHitPointExtraParams$Occasion r106 = new ChatHitPointExtraParams$Occasion("MY_PAGE", 6, "my_page", null, 2, null);
        MY_PAGE = r106;
        ChatHitPointExtraParams$Occasion r107 = new ChatHitPointExtraParams$Occasion("TOPIC", 7, "topic", null, 2, null);
        TOPIC = r107;
        ChatHitPointExtraParams$Occasion r108 = new ChatHitPointExtraParams$Occasion("FEED_PREVIEW", 8, "feed_preview", null, 2, null);
        FEED_PREVIEW = r108;
        ChatHitPointExtraParams$Occasion r110 = new ChatHitPointExtraParams$Occasion("PROFILE_SIGN", 9, "profile_sign", null, 2, null);
        PROFILE_SIGN = r110;
        ChatHitPointExtraParams$Occasion[] r109 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r110};
        f440647a = r109;
        f440648b = EnumEntriesKt.enumEntries(r109);
    }

    public static ChatHitPointExtraParams$Occasion[] values() {
        return (ChatHitPointExtraParams$Occasion[]) f440647a.clone();
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

    public static ChatHitPointExtraParams$Occasion valueOf(String r100) {
        return (ChatHitPointExtraParams$Occasion) r27.a.a(ChatHitPointExtraParams$Occasion.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$Occasion(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "occasion";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
