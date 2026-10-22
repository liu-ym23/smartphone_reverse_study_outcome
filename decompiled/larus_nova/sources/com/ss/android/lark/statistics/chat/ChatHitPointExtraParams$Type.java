package com.ss.android.lark.statistics.chat;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$Type;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "BUTTON_SEND", "HOTKEY_SEND", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$Type extends Enum<ChatHitPointExtraParams$Type> implements s5c.d {
    public static final ChatHitPointExtraParams$Type BUTTON_SEND = null;
    public static final ChatHitPointExtraParams$Type HOTKEY_SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$Type[] f440655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440656b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$Type() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$Type> getEntries() {
        return f440656b;
    }

    static {
        ChatHitPointExtraParams$Type r100 = new ChatHitPointExtraParams$Type("BUTTON_SEND", 0, "button_send", null, 2, null);
        BUTTON_SEND = r100;
        ChatHitPointExtraParams$Type r101 = new ChatHitPointExtraParams$Type("HOTKEY_SEND", 1, "hotkey_send", null, 2, null);
        HOTKEY_SEND = r101;
        ChatHitPointExtraParams$Type[] r102 = {r100, r101};
        f440655a = r102;
        f440656b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatHitPointExtraParams$Type[] values() {
        return (ChatHitPointExtraParams$Type[]) f440655a.clone();
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

    public static ChatHitPointExtraParams$Type valueOf(String r100) {
        return (ChatHitPointExtraParams$Type) r27.a.a(ChatHitPointExtraParams$Type.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$Type(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "type";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
