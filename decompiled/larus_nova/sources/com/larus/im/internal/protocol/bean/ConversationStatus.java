package com.larus.im.internal.protocol.bean;

import af9.a0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0081\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ConversationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "CONV_STATUS_UNKNOWN", "AVAILABLE", "DELETED", "DISSOLVED_CAN_RECOVER", "DISSOLVED_CAN_NOT_RECOVER", "ARCHIVE", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ConversationStatus extends Enum<ConversationStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConversationStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("8")
    public static final ConversationStatus ARCHIVE = null;

    @SerialName("1")
    public static final ConversationStatus AVAILABLE = null;

    @SerialName("0")
    public static final ConversationStatus CONV_STATUS_UNKNOWN = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final ConversationStatus DELETED = null;

    @SerialName("4")
    public static final ConversationStatus DISSOLVED_CAN_NOT_RECOVER = null;

    @SerialName("3")
    public static final ConversationStatus DISSOLVED_CAN_RECOVER = null;
    public final int value;

    private static final /* synthetic */ ConversationStatus[] $values() {
        return new ConversationStatus[]{CONV_STATUS_UNKNOWN, AVAILABLE, DELETED, DISSOLVED_CAN_RECOVER, DISSOLVED_CAN_NOT_RECOVER, ARCHIVE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ConversationStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.im.internal.protocol.bean.ConversationStatus$a] */
    static {
        CONV_STATUS_UNKNOWN = new ConversationStatus("CONV_STATUS_UNKNOWN", 0, 0);
        AVAILABLE = new ConversationStatus("AVAILABLE", 1, 1);
        DELETED = new ConversationStatus("DELETED", 2, 2);
        DISSOLVED_CAN_RECOVER = new ConversationStatus("DISSOLVED_CAN_RECOVER", 3, 3);
        DISSOLVED_CAN_NOT_RECOVER = new ConversationStatus("DISSOLVED_CAN_NOT_RECOVER", 4, 4);
        ARCHIVE = new ConversationStatus("ARCHIVE", 5, 8);
        ConversationStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a0());
    }

    public static ConversationStatus[] values() {
        return (ConversationStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.ConversationStatus", values(), new String[]{"0", "1", "2", "3", "4", "8"}, new Annotation[][]{null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ConversationStatus valueOf(String r100) {
        return (ConversationStatus) r27.a.a(ConversationStatus.class, r100);
    }

    private ConversationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
