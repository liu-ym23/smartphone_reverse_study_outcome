package com.ss.android.lark.statistics.chat;

import com.obric.miniapp.alarm.AccountType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$Status;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", AccountType.ALL, "PIN_TO_TOP", "UNPIN_TO_TOP", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$Status extends Enum<ChatHitPointExtraParams$Status> implements s5c.d {
    public static final ChatHitPointExtraParams$Status ALL = null;
    public static final ChatHitPointExtraParams$Status PIN_TO_TOP = null;
    public static final ChatHitPointExtraParams$Status UNPIN_TO_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$Status[] f440649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440650b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$Status() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$Status> getEntries() {
        return f440650b;
    }

    static {
        ChatHitPointExtraParams$Status r100 = new ChatHitPointExtraParams$Status(AccountType.ALL, 0, "all", null, 2, null);
        ALL = r100;
        ChatHitPointExtraParams$Status r101 = new ChatHitPointExtraParams$Status("PIN_TO_TOP", 1, "pin_to_top", null, 2, null);
        PIN_TO_TOP = r101;
        ChatHitPointExtraParams$Status r102 = new ChatHitPointExtraParams$Status("UNPIN_TO_TOP", 2, "unpin_to_top", null, 2, null);
        UNPIN_TO_TOP = r102;
        ChatHitPointExtraParams$Status[] r103 = {r100, r101, r102};
        f440649a = r103;
        f440650b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatHitPointExtraParams$Status[] values() {
        return (ChatHitPointExtraParams$Status[]) f440649a.clone();
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

    public static ChatHitPointExtraParams$Status valueOf(String r100) {
        return (ChatHitPointExtraParams$Status) r27.a.a(ChatHitPointExtraParams$Status.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$Status(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "status";
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
