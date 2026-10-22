package com.ss.android.lark.statistics.chat;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$Target;", "Lcom/ss/android/lark/statistics/extensions/ITargetParam;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IM_CHAT_MAIN_VIEW", "PROFILE_MAIN_VIEW", UserProfileEvent.POSITION_NONE, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$Target extends Enum<ChatHitPointExtraParams$Target> implements s5c.e {
    public static final ChatHitPointExtraParams$Target IM_CHAT_MAIN_VIEW = null;
    public static final ChatHitPointExtraParams$Target NONE = null;
    public static final ChatHitPointExtraParams$Target PROFILE_MAIN_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$Target[] f440651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440652b = null;
    private final String value;

    public static EnumEntries<ChatHitPointExtraParams$Target> getEntries() {
        return f440652b;
    }

    @Override // s5c.d
    public String getKey() {
        return PickerReporterConstants.KEY.TARGET;
    }

    static {
        ChatHitPointExtraParams$Target r100 = new ChatHitPointExtraParams$Target("IM_CHAT_MAIN_VIEW", 0, "im_chat_main_view");
        IM_CHAT_MAIN_VIEW = r100;
        ChatHitPointExtraParams$Target r101 = new ChatHitPointExtraParams$Target("PROFILE_MAIN_VIEW", 1, "profile_main_view");
        PROFILE_MAIN_VIEW = r101;
        ChatHitPointExtraParams$Target r102 = new ChatHitPointExtraParams$Target(UserProfileEvent.POSITION_NONE, 2, "none");
        NONE = r102;
        ChatHitPointExtraParams$Target[] r103 = {r100, r101, r102};
        f440651a = r103;
        f440652b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatHitPointExtraParams$Target[] values() {
        return (ChatHitPointExtraParams$Target[]) f440651a.clone();
    }

    @Override // s5c.d
    public JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public String getValue() {
        return this.value;
    }

    public static ChatHitPointExtraParams$Target valueOf(String r100) {
        return (ChatHitPointExtraParams$Target) r27.a.a(ChatHitPointExtraParams$Target.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$Target(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
