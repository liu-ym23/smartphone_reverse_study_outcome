package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/templateloader/loaderimpl/GeckoStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NO_WAIT_FOR_REMOTE", "WAIT_FOR_REMOTE", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GeckoStrategy extends Enum<GeckoStrategy> {
    public static final GeckoStrategy NO_WAIT_FOR_REMOTE = null;
    public static final GeckoStrategy WAIT_FOR_REMOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GeckoStrategy[] f431529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431530b = null;

    public static EnumEntries<GeckoStrategy> getEntries() {
        return f431530b;
    }

    static {
        GeckoStrategy r100 = new GeckoStrategy("NO_WAIT_FOR_REMOTE", 0);
        NO_WAIT_FOR_REMOTE = r100;
        GeckoStrategy r101 = new GeckoStrategy("WAIT_FOR_REMOTE", 1);
        WAIT_FOR_REMOTE = r101;
        GeckoStrategy[] r102 = {r100, r101};
        f431529a = r102;
        f431530b = EnumEntriesKt.enumEntries(r102);
    }

    public static GeckoStrategy[] values() {
        return (GeckoStrategy[]) f431529a.clone();
    }

    public static GeckoStrategy valueOf(String r100) {
        return (GeckoStrategy) r27.a.a(GeckoStrategy.class, r100);
    }

    public GeckoStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
