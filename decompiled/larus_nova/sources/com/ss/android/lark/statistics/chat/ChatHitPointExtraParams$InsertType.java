package com.ss.android.lark.statistics.chat;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/statistics/chat/ChatHitPointExtraParams$InsertType;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "MEDIA", "IMAGE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatHitPointExtraParams$InsertType extends Enum<ChatHitPointExtraParams$InsertType> implements s5c.d {
    public static final ChatHitPointExtraParams$InsertType IMAGE = null;
    public static final ChatHitPointExtraParams$InsertType MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatHitPointExtraParams$InsertType[] f440639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440640b = null;
    private final String key;
    private final String value;

    public ChatHitPointExtraParams$InsertType() {
        throw null;
    }

    public static EnumEntries<ChatHitPointExtraParams$InsertType> getEntries() {
        return f440640b;
    }

    static {
        ChatHitPointExtraParams$InsertType r100 = new ChatHitPointExtraParams$InsertType("MEDIA", 0, "media", null, 2, null);
        MEDIA = r100;
        ChatHitPointExtraParams$InsertType r101 = new ChatHitPointExtraParams$InsertType("IMAGE", 1, "image", null, 2, null);
        IMAGE = r101;
        ChatHitPointExtraParams$InsertType[] r102 = {r100, r101};
        f440639a = r102;
        f440640b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatHitPointExtraParams$InsertType[] values() {
        return (ChatHitPointExtraParams$InsertType[]) f440639a.clone();
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

    public static ChatHitPointExtraParams$InsertType valueOf(String r100) {
        return (ChatHitPointExtraParams$InsertType) r27.a.a(ChatHitPointExtraParams$InsertType.class, r100);
    }

    @Override // s5c.d
    public s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }

    public ChatHitPointExtraParams$InsertType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = ILiveRoomPlayFragmentConstant.EXTRA_INSERT_TYPE;
    L5:
        super(r100, r101);
        this.value = r102;
        this.key = r103;
    }
}
