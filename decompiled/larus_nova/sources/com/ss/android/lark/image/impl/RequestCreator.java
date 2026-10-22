package com.ss.android.lark.image.impl;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.transform.CropTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import me.ele.lancet.base.annotations.Skip;
import rkb.c;
import rkb.g;
import xkb.a;
import xkb.b;

/* JADX INFO: loaded from: classes36.dex */
public class RequestCreator implements IRequestCreator {
    private boolean asBitmap;
    private boolean asDrawable;
    private boolean asFile;
    private boolean asGif;
    private boolean centerCrop;
    private DecodeFormat decodeFormat;
    private Drawable errorDrawable;
    private int errorResId;
    private ImageView.ScaleType errorScaleType;
    private boolean fitCenter;
    private a mBitmapTransformation;
    private b mBlurTransformation;
    protected Context mContext;
    private DiskCacheStrategy mDiskCacheStrategy;
    private boolean mDontAnimate;
    protected Fragment mFragment;
    private int mGifFileSize;
    private int mGifMaxHeight;
    private int mGifMaxWidth;
    protected c mImageLoader;
    private ImageView mImageView;
    private boolean mIsAsync;
    private Object mLoadModel;
    private boolean mOnlyRetrieveFromCache;
    private Key mSignature;
    private boolean mSkipMemoryCache;
    private GlideExecutor mSourceExecutor;
    protected androidx.fragment.app.Fragment mSupportFragment;
    private Target mTarget;
    private List<Transformation<Bitmap>> mTransformationList;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private int targetHeight;
    private int targetWidth;
    private float thumbnail;
    private IRequestCreator thumbnailRequest;
    private WrapperRequestListener wrapperListener;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.RequestCreator$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ RequestCreator this$0;
        final /* synthetic */ ImageView val$target;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_android_lark_image_impl_RequestCreator$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_android_lark_image_impl_RequestCreator$1__run$___twin___() {
            SimpleTarget<Drawable> r100 = new C50461(this);
            r100.setOriginRequest(ImageLoader.getRequest(this.val$target));
            RequestCreator r101 = this.this$0;
            r101.mImageLoader.into(r100, r101);
            ImageLoader.setRequest(this.val$target, r100.getOriginRequest());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_lark_image_impl_RequestCreator$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
            r100.com_ss_android_lark_image_impl_RequestCreator$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass1(RequestCreator r100, ImageView r101) {
            this.this$0 = r100;
            this.val$target = r101;
        }
    }

    public class WrapperRequestListener implements g {
        private volatile g listener;
        final /* synthetic */ RequestCreator this$0;

        private WrapperRequestListener(RequestCreator r100) {
            this.this$0 = r100;
        }

        private void setRequestListener(g r100) {
            this.listener = r100;
        }

        public /* synthetic */ WrapperRequestListener(RequestCreator r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ void access$100(WrapperRequestListener r100, g r101) {
            r100.setRequestListener(r101);
        }

        @Override // rkb.g
        public boolean onLoadFailed(Exception r100, Object r101, Target r102, boolean r103) {
            ImageView r104 = this.this$0.getImageView();
            if (r104 != null) goto L14;
        L8:
            g r105 = this.listener;
            if (r105 != null) goto L11;
            return false;
        L11:
            return r105.onLoadFailed(r100, r101, r102, r103);
        L14:
            r104.setScaleType(RequestCreator.access$200(this.this$0));     // Catch: Exception -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        @Override // rkb.g
        public boolean onResourceReady(Object r100, Object r101, Target r102, DataSource r110, boolean r111) {
            g r103 = this.listener;
            if (r103 != null) goto L5;
            return false;
        L5:
            return r103.onResourceReady(r100, r101, r102, r110, r111);
        }
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator asBitmap() {
        this.asBitmap = true;
        this.asFile = false;
        this.asDrawable = false;
        this.asGif = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asDrawable() {
        this.asDrawable = true;
        this.asGif = false;
        this.asFile = false;
        this.asBitmap = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asFile() {
        this.asFile = true;
        this.asBitmap = false;
        this.asDrawable = false;
        this.asGif = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asGif() {
        this.asGif = true;
        this.asFile = false;
        this.asBitmap = false;
        this.asDrawable = false;
        return this;
    }

    public CropTransformation getCropTransformation() {
        return null;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(CropTransformation r100) {
        return this;
    }

    private void init() {
        this.wrapperListener = new WrapperRequestListener(this, null);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void pauseRequests() {
        this.mImageLoader.pauseRequests(this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void resumeRequests() {
        this.mImageLoader.resumeRequests(this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator centerCrop() {
        return centerCrop();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator fitCenter() {
        return fitCenter();
    }

    public a getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public b getBlurTransformation() {
        return this.mBlurTransformation;
    }

    public Context getContext() {
        return this.mContext;
    }

    public DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.mDiskCacheStrategy;
    }

    public Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    public int getErrorResId() {
        return this.errorResId;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public int getGifFileSize() {
        return this.mGifFileSize;
    }

    public int getGifMaxHeight() {
        return this.mGifMaxHeight;
    }

    public int getGifMaxWidth() {
        return this.mGifMaxWidth;
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public Object getLoadModel() {
        return this.mLoadModel;
    }

    public Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public int getPlaceholderResId() {
        return this.placeholderResId;
    }

    public g getRequestListener() {
        return this.wrapperListener;
    }

    public Key getSignature() {
        return this.mSignature;
    }

    public GlideExecutor getSourceExecutor() {
        return this.mSourceExecutor;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.mSupportFragment;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public float getThumbnail() {
        return this.thumbnail;
    }

    public IRequestCreator getThumbnailRequest() {
        return this.thumbnailRequest;
    }

    public List<Transformation<Bitmap>> getTransformationList() {
        return this.mTransformationList;
    }

    public boolean isAsBitmap() {
        return this.asBitmap;
    }

    public boolean isAsFile() {
        return this.asFile;
    }

    public boolean isAsGif() {
        return this.asGif;
    }

    public boolean isCenterCrop() {
        return this.centerCrop;
    }

    public boolean isDontAnimate() {
        return this.mDontAnimate;
    }

    public boolean isFitCenter() {
        return this.fitCenter;
    }

    public boolean isOnlyRetrieveFromCache() {
        return this.mOnlyRetrieveFromCache;
    }

    public boolean isSkipMemoryCache() {
        return this.mSkipMemoryCache;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator asBitmap() {
        return asBitmap();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator centerCrop() {
        this.centerCrop = true;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator fitCenter() {
        this.fitCenter = true;
        return this;
    }

    public static /* synthetic */ ImageView.ScaleType access$200(RequestCreator r100) {
        return r100.errorScaleType;
    }

    public static /* synthetic */ ImageView access$300(RequestCreator r100) {
        return r100.mImageView;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator decodeFormat(DecodeFormat r100) {
        return decodeFormat(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator diskCacheStrategy(DiskCacheStrategy r100) {
        return diskCacheStrategy(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator dontAnimate(boolean r100) {
        this.mDontAnimate = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public <R> void downloadOnly(Target<R> r100) {
        this.mTarget = r100;
        this.mImageLoader.downloadOnly(r100, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator error(int r100) {
        return error(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifFileSize(int r100) {
        this.mGifFileSize = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifMaxHeight(int r100) {
        this.mGifMaxHeight = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifMaxWidth(int r100) {
        this.mGifMaxWidth = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void into(ImageView r100) {
        this.mImageView = r100;
        if (this.mIsAsync == false) goto L5;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(this, r100));
        return;
    L5:
        this.mImageLoader.into(r100, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator isAsync(boolean r100) {
        this.mIsAsync = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator listener(g r100) {
        WrapperRequestListener.access$100(this.wrapperListener, r100);
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator load(Object r100) {
        return load(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator onlyRetrieveFromCache(boolean r100) {
        this.mOnlyRetrieveFromCache = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator placeholder(int r100) {
        return placeholder(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator setErrorScaleType(ImageView.ScaleType r100) {
        this.errorScaleType = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator signature(Key r100) {
        this.mSignature = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator skipMemoryCache(boolean r100) {
        this.mSkipMemoryCache = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator sourceExecutor(GlideExecutor r100) {
        this.mSourceExecutor = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator thumbnail(float r100) {
        return thumbnail(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator transform(Transformation<Bitmap> r100) {
        this.mTransformationList.add(r100);
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator transforms(List<Transformation<Bitmap>> r100) {
        if (CollectionUtils.isNotEmpty(r100) == false) goto L5;
        this.mTransformationList.addAll(r100);
    L5:
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator decodeFormat(DecodeFormat r100) {
        this.decodeFormat = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator diskCacheStrategy(DiskCacheStrategy r100) {
        this.mDiskCacheStrategy = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator error(Drawable r100) {
        return error(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public <R> void into(Target<R> r100) {
        this.mTarget = r100;
        this.mImageLoader.into(r100, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator listener(g r100) {
        return listener(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator load(Object r100) {
        this.mLoadModel = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator placeholder(Drawable r100) {
        return placeholder(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator thumbnail(IRequestCreator r100) {
        return thumbnail(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(CropTransformation r100) {
        return transform(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator error(int r100) {
        this.errorResId = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator placeholder(int r100) {
        this.placeholderResId = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator thumbnail(float r100) {
        this.thumbnail = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(a r100) {
        return transform(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator error(Drawable r100) {
        this.errorDrawable = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator placeholder(Drawable r100) {
        this.placeholderDrawable = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator thumbnail(IRequestCreator r100) {
        this.thumbnailRequest = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(b r100) {
        return transform(r100);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(a r100) {
        this.mBitmapTransformation = r100;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(b r100) {
        this.mBlurTransformation = r100;
        return this;
    }

    public RequestCreator(c r100, Fragment r101) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r100;
        this.mFragment = r101;
        init();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public File downloadOnly(int r100, int r101) throws InterruptedException, ExecutionException {
        return this.mImageLoader.downloadOnly(r100, r101, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public Bitmap getBitmap(int r100, int r101) throws InterruptedException, ExecutionException {
        return this.mImageLoader.getBitmap(r100, r101, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public String getCacheFile(int r100, int r101) {
        return this.mImageLoader.getCacheFile(r100, r101, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator override(int r100, int r101) {
        return override(r100, r101);
    }

    public RequestCreator(c r100, Context r101) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r100;
        this.mContext = r101;
        init();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator override(int r100, int r101) {
        this.targetWidth = r100;
        this.targetHeight = r101;
        return this;
    }

    public RequestCreator(c r100, androidx.fragment.app.Fragment r101) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r100;
        this.mSupportFragment = r101;
        init();
    }
}
