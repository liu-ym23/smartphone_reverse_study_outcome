package com.larus.im.internal.protocol.bean;

import af9.j0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0081\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/protocol/bean/FetchType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "FETCH_TYPE_UNKNOWN", "CLIENT_PULL", "FRONTIER_PUSH", "CHUNK_STREAM", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum FetchType extends Enum<FetchType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FetchType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("3")
    public static final FetchType CHUNK_STREAM = null;

    @SerialName("1")
    public static final FetchType CLIENT_PULL = null;
    public static final a Companion = null;

    @SerialName("0")
    public static final FetchType FETCH_TYPE_UNKNOWN = null;

    @SerialName("2")
    public static final FetchType FRONTIER_PUSH = null;
    public final int value;

    private static final /* synthetic */ FetchType[] $values() {
        return new FetchType[]{FETCH_TYPE_UNKNOWN, CLIENT_PULL, FRONTIER_PUSH, CHUNK_STREAM};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<FetchType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.im.internal.protocol.bean.FetchType$a] */
    static {
        FETCH_TYPE_UNKNOWN = new FetchType("FETCH_TYPE_UNKNOWN", 0, 0);
        CLIENT_PULL = new FetchType("CLIENT_PULL", 1, 1);
        FRONTIER_PUSH = new FetchType("FRONTIER_PUSH", 2, 2);
        CHUNK_STREAM = new FetchType("CHUNK_STREAM", 3, 3);
        FetchType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j0());
    }

    public static FetchType[] values() {
        return (FetchType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.FetchType", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static FetchType valueOf(String r100) {
        return (FetchType) r27.a.a(FetchType.class, r100);
    }

    private FetchType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
