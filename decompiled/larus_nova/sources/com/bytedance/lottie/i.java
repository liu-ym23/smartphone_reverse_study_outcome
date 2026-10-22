package com.bytedance.lottie;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements LottieDrawable.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f264449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f264450b;

    @Override // com.bytedance.lottie.LottieDrawable.i
    public final void run() {
        LottieDrawable r100 = this.f264450b;
        float r101 = this.f264449a;
        d r102 = r100.f264394b;
        if (r102 != null) goto L5;
        r100.f264397e.add(new i(r100, r101));
        return;
    L5:
        float r103 = r102.f264433j;
        r100.i((int) (r103 + (r101 * (r102.f264434k - r103))));
    }

    public i(LottieDrawable r100, float r101) {
        this.f264450b = r100;
        this.f264449a = r101;
    }
}
