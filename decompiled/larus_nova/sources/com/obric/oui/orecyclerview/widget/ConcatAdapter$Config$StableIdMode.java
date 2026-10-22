package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes34.dex */
public final enum ConcatAdapter$Config$StableIdMode extends Enum<ConcatAdapter$Config$StableIdMode> {
    public static final ConcatAdapter$Config$StableIdMode ISOLATED_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode NO_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode SHARED_STABLE_IDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConcatAdapter$Config$StableIdMode[] f401553a = null;

    static {
        ConcatAdapter$Config$StableIdMode r100 = new ConcatAdapter$Config$StableIdMode("NO_STABLE_IDS", 0);
        NO_STABLE_IDS = r100;
        ConcatAdapter$Config$StableIdMode r101 = new ConcatAdapter$Config$StableIdMode("ISOLATED_STABLE_IDS", 1);
        ISOLATED_STABLE_IDS = r101;
        ConcatAdapter$Config$StableIdMode r102 = new ConcatAdapter$Config$StableIdMode("SHARED_STABLE_IDS", 2);
        SHARED_STABLE_IDS = r102;
        f401553a = new ConcatAdapter$Config$StableIdMode[]{r100, r101, r102};
    }

    public static ConcatAdapter$Config$StableIdMode[] values() {
        return (ConcatAdapter$Config$StableIdMode[]) f401553a.clone();
    }

    public static ConcatAdapter$Config$StableIdMode valueOf(String r100) {
        return (ConcatAdapter$Config$StableIdMode) r27.a.a(ConcatAdapter$Config$StableIdMode.class, r100);
    }

    public ConcatAdapter$Config$StableIdMode(String r100, int r101) {
        super(r100, r101);
    }
}
