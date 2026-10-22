package com.facebook.drawee.controller;

import android.content.Context;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private static final NullPointerException NO_REQUEST_EXCEPTION = null;
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = null;
    private static final AtomicLong sIdCounter = null;
    private boolean mAutoPlayAnimations;
    private final Set<ControllerListener> mBoundControllerListeners;

    @Nullable
    private Object mCallerContext;
    private String mContentDescription;
    protected final Context mContext;

    @Nullable
    private ControllerListener<? super INFO> mControllerListener;

    @Nullable
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @Nullable
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    private DraweePlaceHolderConfig mDraweePlaceHolderConfig;
    boolean mEnableHeaderBlurhash;

    @Nullable
    private Set<ControllerListener> mGlobalControllerListeners;

    @Nullable
    private REQUEST mImageRequest;
    private boolean mKeepFirstAvailableRequest;

    @Nullable
    private REQUEST mLowResImageRequest;

    @Nullable
    private REQUEST[] mMultiImageRequests;

    @Nullable
    private DraweeController mOldController;

    @Nullable
    private Boolean mOptFirstAvailableCache;
    private boolean mRetainImageOnFailure;
    private boolean mRetainPreviousImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;

    public static final enum CacheLevel extends Enum<CacheLevel> {
        private static final /* synthetic */ CacheLevel[] $VALUES = null;
        public static final CacheLevel BITMAP_MEMORY_CACHE = null;
        public static final CacheLevel DISK_CACHE = null;
        public static final CacheLevel FULL_FETCH = null;

        static {
            CacheLevel r100 = new CacheLevel("FULL_FETCH", 0);
            FULL_FETCH = r100;
            CacheLevel r101 = new CacheLevel("DISK_CACHE", 1);
            DISK_CACHE = r101;
            CacheLevel r102 = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
            BITMAP_MEMORY_CACHE = r102;
            $VALUES = new CacheLevel[]{r100, r101, r102};
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) $VALUES.clone();
        }

        public static CacheLevel valueOf(String r100) {
            return (CacheLevel) Enum.valueOf(CacheLevel.class, r100);
        }

        private CacheLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract class CustomSupplier<D> implements Supplier<DataSource<IMAGE>> {
        final /* synthetic */ AbstractDraweeControllerBuilder this$0;

        public abstract REQUEST getRequest();

        public CustomSupplier(AbstractDraweeControllerBuilder r100) {
            this.this$0 = r100;
        }
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
        this.mDataSourceSupplier = null;
    }

    public abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController r100, String r101, REQUEST r102, Object r103, CacheLevel r104);

    public final BUILDER getThis() {
        return this;
    }

    public abstract AbstractDraweeController obtainController();

    public abstract BUILDER transMultiImageRequestsToImageRequest(REQUEST[] r100, boolean r101);

    static {
        sAutoPlayAnimationsListener = new AnonymousClass1();
        NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
        sIdCounter = new AtomicLong();
    }

    public static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    public void validate() {
        boolean r100 = false;
        if (this.mMultiImageRequests != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Preconditions.checkState(r101, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier != null) goto L12;
    L17:
        r100 = true;
    L18:
        Preconditions.checkState(r100, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        return;
    L12:
        if (this.mMultiImageRequests != null) goto L18;
        if (this.mImageRequest != null) goto L18;
        if (this.mLowResImageRequest != null) goto L18;
    L5:
        if (this.mImageRequest == null) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public AbstractDraweeController build() {
        validate();
        if (this.mImageRequest != null) goto L10;
        if (this.mMultiImageRequests != null) goto L10;
        REQUEST r100 = this.mLowResImageRequest;
        if (r100 == null) goto L10;
        this.mImageRequest = r100;
        this.mLowResImageRequest = null;
    L10:
        if (FrescoCacheMonitorUtil.isMultiUrlCacheOpt() == false) goto L19;
        if (this.mImageRequest != null) goto L19;
        REQUEST[] r101 = this.mMultiImageRequests;
        if (r101 == null) goto L19;
        if (r101.length <= 0) goto L19;
        this.mImageRequest = r101[0];
    L19:
        return buildController();
    }

    public AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
    L5:
        AbstractDraweeController r100 = obtainController();
        r100.setRetainImageOnFailure(getRetainImageOnFailure());
        r100.setContentDescription(getContentDescription());
        r100.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(r100);
        maybeAttachListeners(r100);
        if (FrescoSystrace.isTracing() == false) goto L8;
        FrescoSystrace.endSection();
    L8:
        r100.setEnableHeaderBlurhash(this.mEnableHeaderBlurhash);
        return r100;
    }

    public BUILDER reset() {
        init();
        return (BUILDER) getThis();
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Nullable
    public String getContentDescription() {
        return this.mContentDescription;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    @Nullable
    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    @Nullable
    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public DraweePlaceHolderConfig getDraweePlaceHolderConfig() {
        return this.mDraweePlaceHolderConfig;
    }

    public boolean getEnableHeaderBlurhash() {
        return this.mEnableHeaderBlurhash;
    }

    @Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    @Nullable
    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    @Nullable
    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    @Nullable
    public DraweeController getOldController() {
        return this.mOldController;
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public boolean getRetainPreviousImageOnFailure() {
        return this.mRetainPreviousImageOnFailure;
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public boolean isKeepFirstAvailableRequest() {
        return this.mKeepFirstAvailableRequest;
    }

    public Boolean isOptFirstAvailableCache() {
        return this.mOptFirstAvailableCache;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public /* bridge */ /* synthetic */ DraweeController build() {
        return build();
    }

    public void maybeAttachListeners(AbstractDraweeController r100) {
        Set<ControllerListener> r101 = this.mBoundControllerListeners;
        if (r101 == null) goto L8;
        Iterator<ControllerListener> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.addControllerListener(r102.next());
    L8:
        ControllerListener<? super INFO> r103 = this.mControllerListener;
        if (r103 == null) goto L11;
        r100.addControllerListener(r103);
    L11:
        Set<ControllerListener> r104 = this.mGlobalControllerListeners;
        if (r104 == null) goto L20;
        if (r104.size() == 0) goto L20;
        Iterator<ControllerListener> r105 = this.mGlobalControllerListeners.iterator();
    L17:
        if (r105.hasNext() == false) goto L20;
        r100.addControllerListener(r105.next());
    L20:
        if (this.mAutoPlayAnimations == false) goto L25;
        r100.addControllerListener(sAutoPlayAnimationsListener);
        return;
    }

    public void maybeBuildAndSetGestureDetector(AbstractDraweeController r100) {
        if (r100.getGestureDetector() != null) goto L6;
        r100.setGestureDetector(GestureDetector.newInstance(this.mContext));
        return;
    }

    public void maybeBuildAndSetRetryManager(AbstractDraweeController r100) {
        if (this.mTapToRetryEnabled == true) goto L5;
        return;
    L5:
        r100.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
        maybeBuildAndSetGestureDetector(r100);
    }

    public BUILDER setAutoPlayAnimations(boolean r100) {
        this.mAutoPlayAnimations = r100;
        return (BUILDER) getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(Object r100) {
        this.mCallerContext = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setContentDescription(String r100) {
        this.mContentDescription = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setControllerListener(ControllerListener<? super INFO> r100) {
        this.mControllerListener = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener r100) {
        this.mControllerViewportVisibilityListener = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> r100) {
        this.mDataSourceSupplier = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setDraweePlaceHolderConfig(DraweePlaceHolderConfig r100) {
        this.mDraweePlaceHolderConfig = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setEnableHeaderBlurhash(boolean r100) {
        this.mEnableHeaderBlurhash = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] r100) {
        return (BUILDER) setFirstAvailableImageRequests(r100, true);
    }

    public void setGlobalControllerListeners(Set<ControllerListener> r100) {
        this.mGlobalControllerListeners = r100;
    }

    public BUILDER setImageRequest(REQUEST r100) {
        this.mImageRequest = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setKeepFirstAvailableRequest(boolean r100) {
        this.mKeepFirstAvailableRequest = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setLowResImageRequest(REQUEST r100) {
        this.mLowResImageRequest = r100;
        return (BUILDER) getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@Nullable DraweeController r100) {
        this.mOldController = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setOptFirstAvailableCache(Boolean r100) {
        this.mOptFirstAvailableCache = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setRetainImageOnFailure(boolean r100) {
        this.mRetainImageOnFailure = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setRetainPreviousImageOnFailure(boolean r100) {
        this.mRetainPreviousImageOnFailure = r100;
        return (BUILDER) getThis();
    }

    public BUILDER setTapToRetryEnabled(boolean r100) {
        this.mTapToRetryEnabled = r100;
        return (BUILDER) getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public /* bridge */ /* synthetic */ SimpleDraweeControllerBuilder setCallerContext(Object r100) {
        return setCallerContext(r100);
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public /* bridge */ /* synthetic */ SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController r100) {
        return setOldController(r100);
    }

    public AbstractDraweeControllerBuilder(Context r100, Set<ControllerListener> r101) {
        this.mEnableHeaderBlurhash = true;
        this.mOptFirstAvailableCache = null;
        this.mContext = r100;
        this.mBoundControllerListeners = r101;
        init();
    }

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController r100, String r101) {
        Supplier<DataSource<IMAGE>> r102 = this.mDataSourceSupplier;
        if (r102 == null) goto L5;
        return r102;
    L5:
        REQUEST r103 = this.mImageRequest;
        if (r103 == null) goto L8;
        Supplier<DataSource<IMAGE>> r104 = getDataSourceSupplierForRequest(r100, r101, r103);
    L12:
        if (r104 != null) goto L14;
    L16:
        if (r104 == null) goto L18;
        return r104;
    L18:
        return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
    L14:
        if (this.mLowResImageRequest == null) goto L16;
        ArrayList r105 = new ArrayList(2);
        r105.add(r104);
        r105.add(getDataSourceSupplierForRequest(r100, r101, this.mLowResImageRequest));
        r104 = IncreasingQualityDataSourceSupplier.create(r105, false);
        goto L16
    L8:
        REQUEST[] r106 = this.mMultiImageRequests;
        if (r106 == null) goto L11;
        r104 = getFirstAvailableDataSourceSupplier(r100, r101, r106, this.mTryCacheOnlyFirst);
        goto L12
    L11:
        r104 = null;
        goto L12
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] r100, boolean r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        Preconditions.checkArgument(r102, "No requests specified!");
        if (ImagePipelineConfig.useSingleImageRequest == true) goto L11;
    L17:
        this.mMultiImageRequests = r100;
        this.mTryCacheOnlyFirst = r101;
        return (BUILDER) getThis();
    L11:
        if (this.mKeepFirstAvailableRequest == true) goto L17;
        if (r100 == null) goto L17;
        if (r100.length <= 0) goto L17;
        return (BUILDER) transMultiImageRequestsToImageRequest(r100, r101);
    L4:
        if (r100.length > 0) goto L7;
        r102 = false;
        goto L8
    }

    public BUILDER setImageRequests(REQUEST[] r100, boolean r101) {
        this.mMultiImageRequests = r100;
        this.mTryCacheOnlyFirst = r101;
        return (BUILDER) getThis();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController r100, String r101, REQUEST r102) {
        return getDataSourceSupplierForRequest(r100, r101, r102, CacheLevel.FULL_FETCH);
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController r100, final String r110, final REQUEST r111, final CacheLevel r112) {
        final Object r101 = getCallerContext();
        return new AnonymousClass2(this, r111, r100, r110, r101, r112);
    }

    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController r100, String r101, REQUEST[] r102, boolean r103) {
        ArrayList r104 = new ArrayList(r102.length * 2);
        int r105 = 0;
        if (r103 == false) goto L12;
        if (FrescoCacheMonitorUtil.isMultiUrlCacheOpt() == false) goto L7;
        r104.add(getDataSourceSupplierForRequest(r100, r101, r102[0], CacheLevel.BITMAP_MEMORY_CACHE));
        goto L12
    L7:
        int r106 = 0;
    L9:
        if (r106 >= r102.length) goto L12;
        r104.add(getDataSourceSupplierForRequest(r100, r101, r102[r106], CacheLevel.BITMAP_MEMORY_CACHE));
        r106 = r106 + 1;
    L12:
        if (r105 >= r102.length) goto L15;
        r104.add(getDataSourceSupplierForRequest(r100, r101, r102[r105]));
        r105 = r105 + 1;
        goto L12
    L15:
        return FirstAvailableDataSourceSupplier.create(r104);
    }
}
