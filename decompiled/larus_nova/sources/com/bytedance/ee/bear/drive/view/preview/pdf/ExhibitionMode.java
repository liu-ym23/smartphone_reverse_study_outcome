package com.bytedance.ee.bear.drive.view.preview.pdf;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes16.dex */
public final enum ExhibitionMode extends Enum<ExhibitionMode> {
    public static final ExhibitionMode NORMAL = null;
    public static final ExhibitionMode PRESENTATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExhibitionMode[] f225078a = null;

    static {
        ExhibitionMode r100 = new ExhibitionMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ExhibitionMode r101 = new ExhibitionMode("PRESENTATION", 1);
        PRESENTATION = r101;
        f225078a = new ExhibitionMode[]{r100, r101};
    }

    public static ExhibitionMode[] values() {
        return (ExhibitionMode[]) f225078a.clone();
    }

    public static ExhibitionMode valueOf(String r100) {
        return (ExhibitionMode) r27.a.a(ExhibitionMode.class, r100);
    }

    public ExhibitionMode(String r100, int r101) {
        super(r100, r101);
    }
}
