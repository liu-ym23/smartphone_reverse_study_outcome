package com.ss.android.lark.preload;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;

/* JADX INFO: loaded from: classes37.dex */
public final enum PreloadTarget extends Enum<PreloadTarget> {
    public static final PreloadTarget DOC = null;
    public static final PreloadTarget MAIL = null;
    public static final PreloadTarget MINI_APP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadTarget[] f438800a = null;
    private int value;

    static {
        PreloadTarget r100 = new PreloadTarget(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 0, 1);
        DOC = r100;
        PreloadTarget r101 = new PreloadTarget("MINI_APP", 1, 2);
        MINI_APP = r101;
        PreloadTarget r102 = new PreloadTarget("MAIL", 2, 3);
        MAIL = r102;
        f438800a = new PreloadTarget[]{r100, r101, r102};
    }

    public static PreloadTarget[] values() {
        return (PreloadTarget[]) f438800a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static PreloadTarget valueOf(String r100) {
        return (PreloadTarget) r27.a.a(PreloadTarget.class, r100);
    }

    public PreloadTarget(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
