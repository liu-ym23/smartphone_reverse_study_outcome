package com.larus.im.internal.protocol.bean;

import af9.q2;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/protocol/bean/UpdateConversationParticipantType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UPDATE_CONVERSATION_PARTICIPANT_TYPE_UNKNOWN", "OPERATE_CONVERSATION_PARTICIPANT_CREATE_CONV", "OPERATE_CONVERSATION_PARTICIPANT_ADD_FROM_CONV", "OPERATE_CONVERSATION_PARTICIPANT_QUIT", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum UpdateConversationParticipantType extends Enum<UpdateConversationParticipantType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UpdateConversationParticipantType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final UpdateConversationParticipantType OPERATE_CONVERSATION_PARTICIPANT_ADD_FROM_CONV = null;

    @SerialName("1")
    public static final UpdateConversationParticipantType OPERATE_CONVERSATION_PARTICIPANT_CREATE_CONV = null;

    @SerialName("3")
    public static final UpdateConversationParticipantType OPERATE_CONVERSATION_PARTICIPANT_QUIT = null;

    @SerialName("0")
    public static final UpdateConversationParticipantType UPDATE_CONVERSATION_PARTICIPANT_TYPE_UNKNOWN = null;
    public final int value;

    private static final /* synthetic */ UpdateConversationParticipantType[] $values() {
        return new UpdateConversationParticipantType[]{UPDATE_CONVERSATION_PARTICIPANT_TYPE_UNKNOWN, OPERATE_CONVERSATION_PARTICIPANT_CREATE_CONV, OPERATE_CONVERSATION_PARTICIPANT_ADD_FROM_CONV, OPERATE_CONVERSATION_PARTICIPANT_QUIT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<UpdateConversationParticipantType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.internal.protocol.bean.UpdateConversationParticipantType$a] */
    static {
        UPDATE_CONVERSATION_PARTICIPANT_TYPE_UNKNOWN = new UpdateConversationParticipantType("UPDATE_CONVERSATION_PARTICIPANT_TYPE_UNKNOWN", 0, 0);
        OPERATE_CONVERSATION_PARTICIPANT_CREATE_CONV = new UpdateConversationParticipantType("OPERATE_CONVERSATION_PARTICIPANT_CREATE_CONV", 1, 1);
        OPERATE_CONVERSATION_PARTICIPANT_ADD_FROM_CONV = new UpdateConversationParticipantType("OPERATE_CONVERSATION_PARTICIPANT_ADD_FROM_CONV", 2, 2);
        OPERATE_CONVERSATION_PARTICIPANT_QUIT = new UpdateConversationParticipantType("OPERATE_CONVERSATION_PARTICIPANT_QUIT", 3, 3);
        UpdateConversationParticipantType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q2());
    }

    public static UpdateConversationParticipantType[] values() {
        return (UpdateConversationParticipantType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.UpdateConversationParticipantType", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static UpdateConversationParticipantType valueOf(String r100) {
        return (UpdateConversationParticipantType) r27.a.a(UpdateConversationParticipantType.class, r100);
    }

    private UpdateConversationParticipantType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
