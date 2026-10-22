package ojb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends RequestOptions {
    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions autoClone() {
        return (a) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions centerCrop() {
        return (a) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions centerInside() {
        return (a) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions circleCrop() {
        return (a) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions clone() {
        return (a) super.clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions disallowHardwareConfig() {
        return (a) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions dontAnimate() {
        return (a) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions dontTransform() {
        return (a) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions fitCenter() {
        return (a) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions lock() {
        return (a) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalCenterCrop() {
        return (a) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalCenterInside() {
        return (a) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalCircleCrop() {
        return (a) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalFitCenter() {
        return (a) super.optionalFitCenter();
    }

    public a() {
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public final Object mo8140clone() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public final a a(BaseRequestOptions<?> r100) {
        return (a) super.apply(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions r100) {
        return a(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions decode(Class r100) {
        return (a) super.decode(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions diskCacheStrategy(DiskCacheStrategy r100) {
        return (a) super.diskCacheStrategy(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions downsample(DownsampleStrategy r100) {
        return (a) super.downsample(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions encodeFormat(Bitmap.CompressFormat r100) {
        return (a) super.encodeFormat(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions encodeQuality(int r100) {
        return (a) super.encodeQuality(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions error(int r100) {
        return (a) super.error(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions fallback(int r100) {
        return (a) super.fallback(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions format(DecodeFormat r100) {
        return (a) super.format(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions frame(long r100) {
        return (a) super.frame(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions onlyRetrieveFromCache(boolean r100) {
        return (a) super.onlyRetrieveFromCache(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalTransform(Transformation r100) {
        return (a) super.optionalTransform(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions override(int r100) {
        return (a) super.override(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions placeholder(int r100) {
        return (a) super.placeholder(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions priority(Priority r100) {
        return (a) super.priority(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions signature(Key r100) {
        return (a) super.signature(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions sizeMultiplier(float r100) {
        return (a) super.sizeMultiplier(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions skipMemoryCache(boolean r100) {
        return (a) super.skipMemoryCache(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions theme(Resources.Theme r100) {
        return (a) super.theme(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions timeout(int r100) {
        return (a) super.timeout(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions transform(Transformation r100) {
        return (a) super.transform(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    public final BaseRequestOptions transforms(Transformation[] r100) {
        return (a) super.transforms(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions useAnimationPool(boolean r100) {
        return (a) super.useAnimationPool(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean r100) {
        return (a) super.useUnlimitedSourceGeneratorsPool(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions error(Drawable r100) {
        return (a) super.error(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions fallback(Drawable r100) {
        return (a) super.fallback(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions placeholder(Drawable r100) {
        return (a) super.placeholder(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @SafeVarargs
    public final BaseRequestOptions transform(Transformation[] r100) {
        return (a) super.transform(r100);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions optionalTransform(Class r100, Transformation r101) {
        return (a) super.optionalTransform(r100, r101);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions override(int r100, int r101) {
        return (a) super.override(r100, r101);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions set(Option r100, Object r101) {
        return (a) super.set(r100, r101);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions transform(Class r100, Transformation r101) {
        return (a) super.transform(r100, r101);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions gifLimit(int r100, int r101, int r102) {
        return (a) super.gifLimit(r100, r101, r102);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public final BaseRequestOptions transform(Class r100, Transformation r101, boolean r102) {
        return (a) super.transform(r100, r101, r102);
    }
}
