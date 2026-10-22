package com.bytedance.lark.lynxlib.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class LynxBackgroundLayerDrawable extends a7a.d implements Drawable.Callback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LynxBackgroundSampleSetting f253261d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f253262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f253263c;

    @AppConfig(key = "lynx_bg_sample_settings")
    public static class LynxBackgroundSampleSetting {
        int maxBitmapDimension;
        boolean needDownSample;

        public LynxBackgroundSampleSetting() {
            this.needDownSample = true;
            this.maxBitmapDimension = 2048;
        }
    }

    @Override // a7a.d
    public final void e() {
        this.f253263c = false;
    }

    @Override // a7a.d
    public final int a() {
        Drawable r100 = this.f253262b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getIntrinsicHeight();
    }

    @Override // a7a.d
    public final int b() {
        Drawable r100 = this.f253262b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getIntrinsicWidth();
    }

    @Override // a7a.d
    public final boolean c() {
        if (this.f253262b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // a7a.d
    public final void d() {
        if (this.f253263c == true) goto L6;
        this.f253263c = true;
        return;
    }

    static {
        f253261d = (LynxBackgroundSampleSetting) SettingManager.getInstance().get(LynxBackgroundSampleSetting.class);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Drawable r101 = this.f253262b;
        if (r101 == null) goto L6;
        r101.draw(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Drawable r101 = this.f253262b;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    }

    public LynxBackgroundLayerDrawable(Context r100, String r101) {
        this.f253262b = null;
        boolean r102 = false;
        this.f253263c = false;
        IRequestCreator r103 = ImageLoader.with(r100).load(i.a(r101));
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        LynxBackgroundSampleSetting r104 = f253261d;
        if (r104.needDownSample == false) goto L11;
        if (r102 == true) goto L11;
        Log.i("CardBackgroundLayerDrawable", "load " + r101 + " needDownSample");
        r103.transform(new MayDownSampleBitmapTransform(r104.maxBitmapDimension));
    L11:
        r103.asDrawable().into(new c(this, r101));
        return;
    L5:
        if (r101.startsWith("data") == false) goto L7;
        r102 = true;
        goto L7
    }

    @Override // a7a.d
    public final void g(int r100, int r101) {
        if (this.f253263c == true) goto L6;
        this.f253263c = true;
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        UIThreadUtils.removeCallbacks(r101, r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        UIThreadUtils.runOnUiThreadAtTime(r101, r100, r102);
    }
}
