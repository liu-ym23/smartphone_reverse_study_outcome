package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationEnqueueStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "ENQUEUE", "SKIP_IF_BUSY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationEnqueueStrategy extends Enum<ZoomInAnimationEnqueueStrategy> {
    public static final ZoomInAnimationEnqueueStrategy ENQUEUE = null;
    public static final ZoomInAnimationEnqueueStrategy SKIP_IF_BUSY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ZoomInAnimationEnqueueStrategy[] f310428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f310429b = null;

    public static EnumEntries<ZoomInAnimationEnqueueStrategy> getEntries() {
        return f310429b;
    }

    static {
        ZoomInAnimationEnqueueStrategy r100 = new ZoomInAnimationEnqueueStrategy("ENQUEUE", 0);
        ENQUEUE = r100;
        ZoomInAnimationEnqueueStrategy r101 = new ZoomInAnimationEnqueueStrategy("SKIP_IF_BUSY", 1);
        SKIP_IF_BUSY = r101;
        ZoomInAnimationEnqueueStrategy[] r102 = {r100, r101};
        f310428a = r102;
        f310429b = EnumEntriesKt.enumEntries(r102);
    }

    public static ZoomInAnimationEnqueueStrategy[] values() {
        return (ZoomInAnimationEnqueueStrategy[]) f310428a.clone();
    }

    public static ZoomInAnimationEnqueueStrategy valueOf(String r100) {
        return (ZoomInAnimationEnqueueStrategy) a.a(ZoomInAnimationEnqueueStrategy.class, r100);
    }

    public ZoomInAnimationEnqueueStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
