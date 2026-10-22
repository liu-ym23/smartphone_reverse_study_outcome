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
import zc9.n;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/message/block/ComplexTaskDisplayType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "THREAD", "SUB_AGENT", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ComplexTaskDisplayType extends Enum<ComplexTaskDisplayType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ComplexTaskDisplayType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("sub_agent")
    public static final ComplexTaskDisplayType SUB_AGENT = null;

    @SerialName("thread")
    public static final ComplexTaskDisplayType THREAD = null;

    @SerialName("unknown")
    public static final ComplexTaskDisplayType UNKNOWN = null;
    private final String value;

    private static final /* synthetic */ ComplexTaskDisplayType[] $values() {
        return new ComplexTaskDisplayType[]{UNKNOWN, THREAD, SUB_AGENT};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ComplexTaskDisplayType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.im.bean.message.block.ComplexTaskDisplayType$a] */
    static {
        UNKNOWN = new ComplexTaskDisplayType("UNKNOWN", 0, "unknown");
        THREAD = new ComplexTaskDisplayType("THREAD", 1, "thread");
        SUB_AGENT = new ComplexTaskDisplayType("SUB_AGENT", 2, "sub_agent");
        ComplexTaskDisplayType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n());
    }

    public static ComplexTaskDisplayType[] values() {
        return (ComplexTaskDisplayType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.message.block.ComplexTaskDisplayType", values(), new String[]{"unknown", "thread", "sub_agent"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final String getValue() {
        return this.value;
    }

    public static ComplexTaskDisplayType valueOf(String r100) {
        return (ComplexTaskDisplayType) r27.a.a(ComplexTaskDisplayType.class, r100);
    }

    private ComplexTaskDisplayType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
