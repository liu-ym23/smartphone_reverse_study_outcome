package kr7;

import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes22.dex */
public final class r extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f505831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f505832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f505833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LynxBaseUI f505834f;

    @Override // kr7.t, lr7.c
    public final float b() {
        return -(this.f505832d + this.f505831c);
    }

    @Override // kr7.t, lr7.c
    public final float c() {
        return this.f505840b - (this.f505832d + this.f505831c);
    }

    public r(int r100, int r101, int r102, String r103, LynxBaseUI r104) {
        super(r100, r101);
        this.f505833e = r103;
        this.f505832d = r102;
        this.f505834f = r104;
    }
}
