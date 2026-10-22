package com.bytedance.lottie;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements LottieDrawable.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f264451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f264452b;

    @Override // com.bytedance.lottie.LottieDrawable.i
    public final void run() {
        LottieDrawable r100 = this.f264452b;
        float r101 = this.f264451a;
        d r102 = r100.f264394b;
        if (r102 != null) goto L5;
        r100.f264397e.add(new j(r100, r101));
        return;
    L5:
        float r103 = r102.f264433j;
        r100.h((int) (r103 + (r101 * (r102.f264434k - r103))));
    }

    public j(LottieDrawable r100, float r101) {
        this.f264452b = r100;
        this.f264451a = r101;
    }
}
