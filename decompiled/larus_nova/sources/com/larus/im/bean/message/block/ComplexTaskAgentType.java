package com.larus.im.bean.message.block;

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
import zc9.m;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/block/ComplexTaskAgentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "ORGANIZER", "SUPERTASK", "CUA", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ComplexTaskAgentType extends Enum<ComplexTaskAgentType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ComplexTaskAgentType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("cua")
    public static final ComplexTaskAgentType CUA = null;
    public static final a Companion = null;

    @SerialName("organizer")
    public static final ComplexTaskAgentType ORGANIZER = null;

    @SerialName("supertask")
    public static final ComplexTaskAgentType SUPERTASK = null;

    @SerialName("unknown")
    public static final ComplexTaskAgentType UNKNOWN = null;
    private final String value;

    private static final /* synthetic */ ComplexTaskAgentType[] $values() {
        return new ComplexTaskAgentType[]{UNKNOWN, ORGANIZER, SUPERTASK, CUA};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ComplexTaskAgentType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.bean.message.block.ComplexTaskAgentType$a] */
    static {
        UNKNOWN = new ComplexTaskAgentType("UNKNOWN", 0, "unknown");
        ORGANIZER = new ComplexTaskAgentType("ORGANIZER", 1, "organizer");
        SUPERTASK = new ComplexTaskAgentType("SUPERTASK", 2, "supertask");
        CUA = new ComplexTaskAgentType("CUA", 3, "cua");
        ComplexTaskAgentType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new m());
    }

    public static ComplexTaskAgentType[] values() {
        return (ComplexTaskAgentType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.message.block.ComplexTaskAgentType", values(), new String[]{"unknown", "organizer", "supertask", "cua"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final String getValue() {
        return this.value;
    }

    public static ComplexTaskAgentType valueOf(String r100) {
        return (ComplexTaskAgentType) r27.a.a(ComplexTaskAgentType.class, r100);
    }

    private ComplexTaskAgentType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
