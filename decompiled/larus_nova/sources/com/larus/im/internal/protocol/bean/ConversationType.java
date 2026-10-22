package com.larus.im.internal.protocol.bean;

import af9.b0;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ConversationType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "CONVERSATION_TYPE_UNKNOWN", "ONE_TO_ONE_CHAT", "GROUP_CHAT", "ONE_TO_BOT_CHAT", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ConversationType extends Enum<ConversationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConversationType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("0")
    public static final ConversationType CONVERSATION_TYPE_UNKNOWN = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final ConversationType GROUP_CHAT = null;

    @SerialName("3")
    public static final ConversationType ONE_TO_BOT_CHAT = null;

    @SerialName("1")
    public static final ConversationType ONE_TO_ONE_CHAT = null;
    public final int value;

    private static final /* synthetic */ ConversationType[] $values() {
        return new ConversationType[]{CONVERSATION_TYPE_UNKNOWN, ONE_TO_ONE_CHAT, GROUP_CHAT, ONE_TO_BOT_CHAT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ConversationType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.internal.protocol.bean.ConversationType$a] */
    static {
        CONVERSATION_TYPE_UNKNOWN = new ConversationType("CONVERSATION_TYPE_UNKNOWN", 0, 0);
        ONE_TO_ONE_CHAT = new ConversationType("ONE_TO_ONE_CHAT", 1, 1);
        GROUP_CHAT = new ConversationType("GROUP_CHAT", 2, 2);
        ONE_TO_BOT_CHAT = new ConversationType("ONE_TO_BOT_CHAT", 3, 3);
        ConversationType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b0());
    }

    public static ConversationType[] values() {
        return (ConversationType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.ConversationType", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ConversationType valueOf(String r100) {
        return (ConversationType) r27.a.a(ConversationType.class, r100);
    }

    private ConversationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
