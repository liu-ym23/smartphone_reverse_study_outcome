package com.larus.im.internal.protocol.bean;

import af9.z0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/protocol/bean/MessageDirection;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MSG_DIRECTION_UNKNOWN", "OLDER", "NEWER", "FROM_LATEST", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum MessageDirection extends Enum<MessageDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MessageDirection[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("3")
    public static final MessageDirection FROM_LATEST = null;

    @SerialName("0")
    public static final MessageDirection MSG_DIRECTION_UNKNOWN = null;

    @SerialName("2")
    public static final MessageDirection NEWER = null;

    @SerialName("1")
    public static final MessageDirection OLDER = null;
    public final int value;

    private static final /* synthetic */ MessageDirection[] $values() {
        return new MessageDirection[]{MSG_DIRECTION_UNKNOWN, OLDER, NEWER, FROM_LATEST};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<MessageDirection> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.internal.protocol.bean.MessageDirection$a] */
    static {
        MSG_DIRECTION_UNKNOWN = new MessageDirection("MSG_DIRECTION_UNKNOWN", 0, 0);
        OLDER = new MessageDirection("OLDER", 1, 1);
        NEWER = new MessageDirection("NEWER", 2, 2);
        FROM_LATEST = new MessageDirection("FROM_LATEST", 3, 3);
        MessageDirection[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z0());
    }

    public static MessageDirection[] values() {
        return (MessageDirection[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.MessageDirection", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static MessageDirection valueOf(String r100) {
        return (MessageDirection) r27.a.a(MessageDirection.class, r100);
    }

    private MessageDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
