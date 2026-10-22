package com.larus.audio.call.arch;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/arch/LifecycleStage;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "RETRY", "BEFORE_STOP", "STOP", "PAUSE", "RESUME", "RELEASE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LifecycleStage extends Enum<LifecycleStage> {
    public static final LifecycleStage BEFORE_STOP = null;
    public static final LifecycleStage PAUSE = null;
    public static final LifecycleStage RELEASE = null;
    public static final LifecycleStage RESUME = null;
    public static final LifecycleStage RETRY = null;
    public static final LifecycleStage START = null;
    public static final LifecycleStage STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LifecycleStage[] f289053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289054b = null;

    public static EnumEntries<LifecycleStage> getEntries() {
        return f289054b;
    }

    static {
        LifecycleStage r100 = new LifecycleStage(GXAnimation.STATE_START, 0);
        START = r100;
        LifecycleStage r101 = new LifecycleStage("RETRY", 1);
        RETRY = r101;
        LifecycleStage r102 = new LifecycleStage("BEFORE_STOP", 2);
        BEFORE_STOP = r102;
        LifecycleStage r103 = new LifecycleStage("STOP", 3);
        STOP = r103;
        LifecycleStage r104 = new LifecycleStage("PAUSE", 4);
        PAUSE = r104;
        LifecycleStage r105 = new LifecycleStage("RESUME", 5);
        RESUME = r105;
        LifecycleStage r110 = new LifecycleStage("RELEASE", 6);
        RELEASE = r110;
        LifecycleStage[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f289053a = r111;
        f289054b = EnumEntriesKt.enumEntries(r111);
    }

    public static LifecycleStage[] values() {
        return (LifecycleStage[]) f289053a.clone();
    }

    public static LifecycleStage valueOf(String r100) {
        return (LifecycleStage) r27.a.a(LifecycleStage.class, r100);
    }

    public LifecycleStage(String r100, int r101) {
        super(r100, r101);
    }
}
