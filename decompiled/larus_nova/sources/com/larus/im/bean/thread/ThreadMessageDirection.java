package com.larus.im.bean.thread;

import dd9.b;
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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/thread/ThreadMessageDirection;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UN_KNOW", "OLDER", "NEWER", "LATEST", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ThreadMessageDirection extends Enum<ThreadMessageDirection> implements java.io.Serializable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ThreadMessageDirection[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("3")
    public static final ThreadMessageDirection LATEST = null;

    @SerialName("2")
    public static final ThreadMessageDirection NEWER = null;

    @SerialName("1")
    public static final ThreadMessageDirection OLDER = null;

    @SerialName("0")
    public static final ThreadMessageDirection UN_KNOW = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public final d<ThreadMessageDirection> serializer() {
            return (d) ThreadMessageDirection.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    private static final /* synthetic */ ThreadMessageDirection[] $values() {
        return new ThreadMessageDirection[]{UN_KNOW, OLDER, NEWER, LATEST};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ThreadMessageDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        UN_KNOW = new ThreadMessageDirection("UN_KNOW", 0, 0);
        OLDER = new ThreadMessageDirection("OLDER", 1, 1);
        NEWER = new ThreadMessageDirection("NEWER", 2, 2);
        LATEST = new ThreadMessageDirection("LATEST", 3, 3);
        ThreadMessageDirection[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b());
    }

    public static ThreadMessageDirection[] values() {
        return (ThreadMessageDirection[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.thread.ThreadMessageDirection", values(), new String[]{"0", "1", "2", "3"}, new Annotation[][]{null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ThreadMessageDirection valueOf(String r100) {
        return (ThreadMessageDirection) r27.a.a(ThreadMessageDirection.class, r100);
    }

    private ThreadMessageDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
