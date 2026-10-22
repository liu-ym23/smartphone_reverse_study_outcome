package com.ss.android.lark.statistics.chat;

import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$TextType;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "MEMBER_JOIN", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$TextType extends Enum<ChatHitPointExtraParams$TextType> implements s5c.d {
    public static final ChatHitPointExtraParams$TextType MEMBER_JOIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$TextType[] f440653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440654b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$TextType() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$TextType> getEntries() {
        return f440654b;
    }

    static {
        ChatHitPointExtraParams$TextType r100 = new ChatHitPointExtraParams$TextType("MEMBER_JOIN", 0, "member_join", null, 2, null);
        MEMBER_JOIN = r100;
        ChatHitPointExtraParams$TextType[] r101 = {r100};
        f440653a = r101;
        f440654b = EnumEntriesKt.enumEntries(r101);
    }

    public static ChatHitPointExtraParams$TextType[] values() {
        return (ChatHitPointExtraParams$TextType[]) f440653a.clone();
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

    public static ChatHitPointExtraParams$TextType valueOf(String r100) {
        return (ChatHitPointExtraParams$TextType) r27.a.a(ChatHitPointExtraParams$TextType.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$TextType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE;
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
