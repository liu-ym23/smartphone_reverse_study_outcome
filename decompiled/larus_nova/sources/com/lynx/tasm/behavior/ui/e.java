package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f382488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f382489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f382490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f382491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ILynxUIMeaningfulContent$MeaningfulContentStatus f382492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f382493f;

    public interface a {
        IDrawChildHook getDrawChildHook();

        void invalidateMeaningfulPaintingArea();
    }

    public e(int r100, int r101, int r102, int r103) {
        this.f382492e = ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
        this.f382493f = -1;
        this.f382488a = r100;
        this.f382489b = r101;
        this.f382490c = r102;
        this.f382491d = r103;
    }
}
