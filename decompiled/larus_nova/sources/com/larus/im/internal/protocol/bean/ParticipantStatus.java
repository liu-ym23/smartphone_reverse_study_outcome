package com.larus.im.internal.protocol.bean;

import af9.o1;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0081\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ParticipantStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "ParticipantStatus_Joined", "ParticipantStatus_Quited", "ParticipantStatus_Deleted", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ParticipantStatus extends Enum<ParticipantStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ParticipantStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final ParticipantStatus ParticipantStatus_Deleted = null;

    @SerialName("0")
    public static final ParticipantStatus ParticipantStatus_Joined = null;

    @SerialName("1")
    public static final ParticipantStatus ParticipantStatus_Quited = null;
    public final int value;

    private static final /* synthetic */ ParticipantStatus[] $values() {
        return new ParticipantStatus[]{ParticipantStatus_Joined, ParticipantStatus_Quited, ParticipantStatus_Deleted};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ParticipantStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.im.internal.protocol.bean.ParticipantStatus$a] */
    static {
        ParticipantStatus_Joined = new ParticipantStatus("ParticipantStatus_Joined", 0, 0);
        ParticipantStatus_Quited = new ParticipantStatus("ParticipantStatus_Quited", 1, 1);
        ParticipantStatus_Deleted = new ParticipantStatus("ParticipantStatus_Deleted", 2, 2);
        ParticipantStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new o1());
    }

    public static ParticipantStatus[] values() {
        return (ParticipantStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.ParticipantStatus", values(), new String[]{"0", "1", "2"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ParticipantStatus valueOf(String r100) {
        return (ParticipantStatus) r27.a.a(ParticipantStatus.class, r100);
    }

    private ParticipantStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
