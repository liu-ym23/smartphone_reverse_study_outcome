package com.bytedance.iesgurd;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdUpdatePriority;", "", "LOW", "MIDDLE", "HIGH", "USE_INTERACTION", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum IESGurdUpdatePriority extends Enum<IESGurdUpdatePriority> {
    public static final IESGurdUpdatePriority HIGH = null;
    public static final IESGurdUpdatePriority LOW = null;
    public static final IESGurdUpdatePriority MIDDLE = null;
    public static final IESGurdUpdatePriority USE_INTERACTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IESGurdUpdatePriority[] f250626a = null;

    static {
        IESGurdUpdatePriority r100 = new IESGurdUpdatePriority("LOW", 0);
        LOW = r100;
        IESGurdUpdatePriority r101 = new IESGurdUpdatePriority("MIDDLE", 1);
        MIDDLE = r101;
        IESGurdUpdatePriority r102 = new IESGurdUpdatePriority("HIGH", 2);
        HIGH = r102;
        IESGurdUpdatePriority r103 = new IESGurdUpdatePriority("USE_INTERACTION", 3);
        USE_INTERACTION = r103;
        f250626a = new IESGurdUpdatePriority[]{r100, r101, r102, r103};
    }

    public static IESGurdUpdatePriority valueOf(String r100) {
        return (IESGurdUpdatePriority) r27.a.a(IESGurdUpdatePriority.class, r100);
    }

    public static IESGurdUpdatePriority[] values() {
        return (IESGurdUpdatePriority[]) f250626a.clone();
    }

    public IESGurdUpdatePriority(String r100, int r101) {
        super(r100, r101);
    }
}
