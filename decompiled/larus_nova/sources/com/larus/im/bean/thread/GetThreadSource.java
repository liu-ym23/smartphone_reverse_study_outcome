package com.larus.im.bean.thread;

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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u000b2\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/thread/GetThreadSource;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "GetThreadSource_MIXED", "GetThreadSource_LOCAL", "GetThreadSource_REMOTE", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum GetThreadSource extends Enum<GetThreadSource> implements java.io.Serializable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GetThreadSource[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("1")
    public static final GetThreadSource GetThreadSource_LOCAL = null;

    @SerialName("0")
    public static final GetThreadSource GetThreadSource_MIXED = null;

    @SerialName("2")
    public static final GetThreadSource GetThreadSource_REMOTE = null;
    public final int value;

    private static final /* synthetic */ GetThreadSource[] $values() {
        return new GetThreadSource[]{GetThreadSource_MIXED, GetThreadSource_LOCAL, GetThreadSource_REMOTE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<GetThreadSource> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.im.bean.thread.GetThreadSource$a] */
    static {
        GetThreadSource_MIXED = new GetThreadSource("GetThreadSource_MIXED", 0, 0);
        GetThreadSource_LOCAL = new GetThreadSource("GetThreadSource_LOCAL", 1, 1);
        GetThreadSource_REMOTE = new GetThreadSource("GetThreadSource_REMOTE", 2, 2);
        GetThreadSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new dd9.a());
    }

    public static GetThreadSource[] values() {
        return (GetThreadSource[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.thread.GetThreadSource", values(), new String[]{"0", "1", "2"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static GetThreadSource valueOf(String r100) {
        return (GetThreadSource) r27.a.a(GetThreadSource.class, r100);
    }

    private GetThreadSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
