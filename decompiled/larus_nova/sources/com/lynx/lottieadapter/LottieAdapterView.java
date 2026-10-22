package com.lynx.lottieadapter;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b6a.b;
import b6a.i;
import b6a.k;
import c6a.c;
import e6a.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LottieAdapterView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f381424a;

    /* JADX INFO: loaded from: classes32.dex */
    public class a implements d<ColorFilter> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PorterDuffColorFilter f381425a;

        @Override // e6a.d
        public final Object getValue() {
            return this.f381425a;
        }

        public a(PorterDuffColorFilter r100) {
            this.f381425a = r100;
        }
    }

    public /* bridge */ /* synthetic */ void setOption(k r100) {
    }

    @Override // b6a.b
    public final void cancelAnimation() {
        this.f381424a.cancelAnimation();
    }

    @Override // b6a.b
    public ColorFilter getColorFilter() {
        return this.f381424a.getColorFilter();
    }

    @Override // b6a.b
    public c getComposition() {
        return this.f381424a.getComposition();
    }

    @Override // b6a.b
    public AnimationType getContentType() {
        return this.f381424a.getContentType();
    }

    @Override // b6a.b
    public long getDuration() {
        return this.f381424a.getDuration();
    }

    @Override // b6a.b
    public int getFrame() {
        return this.f381424a.getFrame();
    }

    @Override // b6a.b
    public String getImageAssetsFolder() {
        return this.f381424a.getImageAssetsFolder();
    }

    @Override // b6a.b
    public float getMaxFrame() {
        return this.f381424a.getMaxFrame();
    }

    @Override // b6a.b
    public float getMinFrame() {
        return this.f381424a.getMinFrame();
    }

    @Override // b6a.b
    public float getProgress() {
        return this.f381424a.getProgress();
    }

    @Override // b6a.b
    public int getRepeatCount() {
        return this.f381424a.getRepeatCount();
    }

    @Override // b6a.b
    public int getRepeatMode() {
        return this.f381424a.getRepeatMode();
    }

    @Override // b6a.b
    public float getScale() {
        return this.f381424a.getScale();
    }

    @Override // b6a.b
    public float getSpeed() {
        return this.f381424a.getSpeed();
    }

    @Override // b6a.b
    public final boolean isAnimating() {
        return this.f381424a.isAnimating();
    }

    @Override // b6a.b
    public final void pauseAnimation() {
        this.f381424a.pauseAnimation();
    }

    @Override // b6a.b
    public final void playAnimation() {
        this.f381424a.playAnimation();
    }

    @Override // b6a.b
    public final void resumeAnimation() {
        this.f381424a.resumeAnimation();
    }

    public LottieAdapterView(Context r100) {
        k r101 = new k(i.f17886a);
        super(r100);
        b r102 = i.b(r100, r101);
        r102.setParentView(this);
        this.f381424a = r102;
    }

    public static k b(TypedArray r100) {
        k r101 = i.f17886a;
        k r102 = new k(r101);
        int r103 = r100.getInt(4, r101.getType().ordinal());
        r102.f17892a = AnimationType.values()[r103];
        r102.f17893b = r100.getBoolean(5, false);
        r102.f17894c = r100.getBoolean(2, false);
        return r102;
    }

    public final void a(TypedArray r100) {
        if (r100.hasValue(14) == false) goto L10;
        if (r100.hasValue(9) == false) goto L10;
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    L10:
        if (r100.hasValue(14) == false) goto L15;
        int r101 = r100.getResourceId(14, 0);
        if (r101 == 0) goto L25;
        setAnimation(r101);
    L25:
        if (r100.getBoolean(6, false) == false) goto L28;
        setAutoPlay(true);
    L28:
        if (r100.getBoolean(12, false) == false) goto L31;
        setRepeatCount(-1);
    L31:
        if (r100.hasValue(3) == false) goto L34;
        setRepeatMode(r100.getInt(3, 1));
    L34:
        if (r100.hasValue(15) == false) goto L36;
        setRepeatCount(r100.getInt(15, -1));
    L36:
        setImageAssetsFolder(r100.getString(10));
        setProgress(r100.getFloat(13, 0.0f));
        if (r100.hasValue(7) == false) goto L40;
        PorterDuffColorFilter r102 = new PorterDuffColorFilter(r100.getColor(7, 0), PorterDuff.Mode.SRC_ATOP);
        setColorFilter(r102);
        addValueCallback(new d6a.a(new String[]{"**"}), c6a.d.C, new a(r102));
    L40:
        if (r100.hasValue(16) == false) goto L43;
        setScale(r100.getFloat(16, 1.0f));
    L43:
        if (r100.hasValue(0) == false) goto L46;
        int r103 = r100.getInt(0, ImageView.ScaleType.FIT_CENTER.ordinal());
        setScaleType(ImageView.ScaleType.values()[r103]);
        return;
    L46:
        return;
    L15:
        if (r100.hasValue(9) == false) goto L20;
        String r104 = r100.getString(9);
        if (r104 == null) goto L25;
        setAnimation(r104);
        goto L25
    L20:
        if (r100.hasValue(17) == false) goto L25;
        String r105 = r100.getString(17);
        if (r105 == null) goto L25;
        setAnimationFromUrl(r105);
        goto L25
    }

    @Override // b6a.b
    public void setAnimation(int r100) {
        this.f381424a.setAnimation(r100);
    }

    @Override // b6a.b
    public void setAnimationFromJson(String r100) {
        this.f381424a.setAnimationFromJson(r100);
    }

    @Override // b6a.b
    public void setAnimationFromUrl(String r100) {
        this.f381424a.setAnimationFromUrl(r100);
    }

    @Override // b6a.b
    public void setAutoPlay(boolean r100) {
        this.f381424a.setAutoPlay(r100);
    }

    @Override // b6a.b
    public void setColorFilter(ColorFilter r100) {
        this.f381424a.setColorFilter(r100);
    }

    @Override // b6a.b
    public void setComposition(c r100) {
        this.f381424a.setComposition(r100);
    }

    @Override // b6a.b
    public void setFontAssetDelegate(c6a.a r100) {
        this.f381424a.setFontAssetDelegate(r100);
    }

    @Override // b6a.b
    public void setFrame(int r100) {
        this.f381424a.setFrame(r100);
    }

    @Override // b6a.b
    public void setImageAssetDelegate(c6a.b r100) {
        this.f381424a.setImageAssetDelegate(r100);
    }

    @Override // b6a.b
    public void setImageAssetsFolder(String r100) {
        this.f381424a.setImageAssetsFolder(r100);
    }

    @Override // b6a.b
    public void setImageDrawable(Drawable r100) {
        this.f381424a.setImageDrawable(r100);
    }

    @Override // b6a.b
    public void setImageResource(int r100) {
        this.f381424a.setImageResource(r100);
    }

    @Override // b6a.b
    public void setMaxFrame(int r100) {
        this.f381424a.setMaxFrame(r100);
    }

    @Override // b6a.b
    public void setMaxFrameRate(float r100) {
        b r101 = this.f381424a;
        if (r101 == null) goto L6;
        r101.setMaxFrameRate(r100);
        return;
    }

    @Override // b6a.b
    public void setMaxProgress(float r100) {
        this.f381424a.setMaxProgress(r100);
    }

    @Override // b6a.b
    public void setMinFrame(int r100) {
        this.f381424a.setMinFrame(r100);
    }

    @Override // b6a.b
    public void setMinProgress(float r100) {
        this.f381424a.setMinProgress(r100);
    }

    @Override // b6a.b
    public void setParentView(ViewGroup r100) {
        throw new UnsupportedOperationException("setParentView should not be called here");
    }

    @Override // b6a.b
    public void setProgress(float r100) {
        this.f381424a.setProgress(r100);
    }

    @Override // b6a.b
    public void setRepeatCount(int r100) {
        this.f381424a.setRepeatCount(r100);
    }

    @Override // b6a.b
    public void setRepeatMode(int r100) {
        this.f381424a.setRepeatMode(r100);
    }

    @Override // b6a.b
    public void setScale(float r100) {
        this.f381424a.setScale(r100);
    }

    @Override // b6a.b
    public void setScaleType(ImageView.ScaleType r100) {
        b r101 = this.f381424a;
        if (r101 == null) goto L6;
        r101.setScaleType(r100);
        return;
    }

    @Override // b6a.b
    public void setSpeed(float r100) {
        this.f381424a.setSpeed(r100);
    }

    @Override // b6a.b
    public void setAnimation(String r100) {
        this.f381424a.setAnimation(r100);
    }

    @Override // b6a.b
    public void setAnimation(JSONObject r100) {
        this.f381424a.setAnimation(r100);
    }

    public LottieAdapterView(Context r100, AttributeSet r101) {
        super(r100, r101);
        if (r101 == null) goto L10;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.scaleType, com.larus.nova.R.attr.lottie_adapter_cacheStrategy, com.larus.nova.R.attr.lottie_adapter_multiThreadAccelerate, com.larus.nova.R.attr.lottie_adapter_repeatMode, com.larus.nova.R.attr.lottie_adapter_type, com.larus.nova.R.attr.lottie_adapter_useImageMode, com.larus.nova.R.attr.lottie_autoPlay, com.larus.nova.R.attr.lottie_colorFilter, com.larus.nova.R.attr.lottie_enableMergePathsForKitKatAndAbove, com.larus.nova.R.attr.lottie_fileName, com.larus.nova.R.attr.lottie_imageAssetsFolder, com.larus.nova.R.attr.lottie_lazyLoad, com.larus.nova.R.attr.lottie_loop, com.larus.nova.R.attr.lottie_progress, com.larus.nova.R.attr.lottie_rawRes, com.larus.nova.R.attr.lottie_repeatCount, com.larus.nova.R.attr.lottie_scale, com.larus.nova.R.attr.lottie_url});
        b r103 = i.b(r100, b(r102));     // Catch: Throwable -> L7
        r103.setParentView(this);     // Catch: Throwable -> L7
        this.f381424a = r103;     // Catch: Throwable -> L7
        a(r102);     // Catch: Throwable -> L7
        r102.recycle();
        return;
    L7:
        th = move-exception;
        r102.recycle();
        throw th;
    L10:
        b r104 = i.b(r100, i.f17886a);
        r104.setParentView(this);
        this.f381424a = r104;
    }

    @Override // b6a.b
    public final void setMinAndMaxProgress(float r100, float r101) {
        this.f381424a.setMinAndMaxProgress(r100, r101);
    }

    public LottieAdapterView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L10;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.scaleType, com.larus.nova.R.attr.lottie_adapter_cacheStrategy, com.larus.nova.R.attr.lottie_adapter_multiThreadAccelerate, com.larus.nova.R.attr.lottie_adapter_repeatMode, com.larus.nova.R.attr.lottie_adapter_type, com.larus.nova.R.attr.lottie_adapter_useImageMode, com.larus.nova.R.attr.lottie_autoPlay, com.larus.nova.R.attr.lottie_colorFilter, com.larus.nova.R.attr.lottie_enableMergePathsForKitKatAndAbove, com.larus.nova.R.attr.lottie_fileName, com.larus.nova.R.attr.lottie_imageAssetsFolder, com.larus.nova.R.attr.lottie_lazyLoad, com.larus.nova.R.attr.lottie_loop, com.larus.nova.R.attr.lottie_progress, com.larus.nova.R.attr.lottie_rawRes, com.larus.nova.R.attr.lottie_repeatCount, com.larus.nova.R.attr.lottie_scale, com.larus.nova.R.attr.lottie_url});
        b r104 = i.b(r100, b(r103));     // Catch: Throwable -> L7
        r104.setParentView(this);     // Catch: Throwable -> L7
        this.f381424a = r104;     // Catch: Throwable -> L7
        a(r103);     // Catch: Throwable -> L7
        r103.recycle();
        return;
    L7:
        th = move-exception;
        r103.recycle();
        throw th;
    L10:
        b r105 = i.b(r100, i.f17886a);
        r105.setParentView(this);
        this.f381424a = r105;
    }

    @Override // b6a.b
    public final <T> void addValueCallback(d6a.a r100, T r101, d<T> r102) {
        this.f381424a.addValueCallback(r100, r101, r102);
    }
}
