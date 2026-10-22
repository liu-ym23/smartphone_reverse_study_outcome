package com.larus.im.internal.protocol.bean;

import af9.b1;
import com.tencent.connect.common.Constants;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0081\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/protocol/bean/MessageStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MessageStatus_AVAILABLE", "MessageStatus_INVISIBLE", "MessageStatus_NOT_EXIST", "MessageStatus_DELETED", "MessageStatus_BEFOREEDIT", "MessageStatus_REGEN_ROOT", "MessageStatus_REGENATED", "MessageStatus_NOTCOMPLIANT", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum MessageStatus extends Enum<MessageStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MessageStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("0")
    public static final MessageStatus MessageStatus_AVAILABLE = null;

    @SerialName("7")
    public static final MessageStatus MessageStatus_BEFOREEDIT = null;

    @SerialName("5")
    public static final MessageStatus MessageStatus_DELETED = null;

    @SerialName("1")
    public static final MessageStatus MessageStatus_INVISIBLE = null;

    @SerialName("11")
    public static final MessageStatus MessageStatus_NOTCOMPLIANT = null;

    @SerialName("3")
    public static final MessageStatus MessageStatus_NOT_EXIST = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final MessageStatus MessageStatus_REGENATED = null;

    @SerialName("8")
    public static final MessageStatus MessageStatus_REGEN_ROOT = null;
    public final int value;

    private static final /* synthetic */ MessageStatus[] $values() {
        return new MessageStatus[]{MessageStatus_AVAILABLE, MessageStatus_INVISIBLE, MessageStatus_NOT_EXIST, MessageStatus_DELETED, MessageStatus_BEFOREEDIT, MessageStatus_REGEN_ROOT, MessageStatus_REGENATED, MessageStatus_NOTCOMPLIANT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<MessageStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.im.internal.protocol.bean.MessageStatus$a] */
    static {
        MessageStatus_AVAILABLE = new MessageStatus("MessageStatus_AVAILABLE", 0, 0);
        MessageStatus_INVISIBLE = new MessageStatus("MessageStatus_INVISIBLE", 1, 1);
        MessageStatus_NOT_EXIST = new MessageStatus("MessageStatus_NOT_EXIST", 2, 3);
        MessageStatus_DELETED = new MessageStatus("MessageStatus_DELETED", 3, 5);
        MessageStatus_BEFOREEDIT = new MessageStatus("MessageStatus_BEFOREEDIT", 4, 7);
        MessageStatus_REGEN_ROOT = new MessageStatus("MessageStatus_REGEN_ROOT", 5, 8);
        MessageStatus_REGENATED = new MessageStatus("MessageStatus_REGENATED", 6, 10);
        MessageStatus_NOTCOMPLIANT = new MessageStatus("MessageStatus_NOTCOMPLIANT", 7, 11);
        MessageStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b1());
    }

    public static MessageStatus[] values() {
        return (MessageStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.MessageStatus", values(), new String[]{"0", "1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "11"}, new Annotation[][]{null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static MessageStatus valueOf(String r100) {
        return (MessageStatus) r27.a.a(MessageStatus.class, r100);
    }

    private MessageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
