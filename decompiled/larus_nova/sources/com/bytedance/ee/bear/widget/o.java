package com.bytedance.ee.bear.widget;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f239946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ bo4.a f239947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f239948c;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        tt5.a.b("DocEditTextPresenter", "invalidateDrawable");
        AtEditText r101 = this.f239948c.f239936f;
        final SpannableStringBuilder r102 = this.f239946a;
        final bo4.a r103 = this.f239947b;
        r101.post(new n(this, r102, r103));
    }

    public o(l r100, SpannableStringBuilder r101, bo4.a r102) {
        this.f239948c = r100;
        this.f239946a = r101;
        this.f239947b = r102;
    }
}
