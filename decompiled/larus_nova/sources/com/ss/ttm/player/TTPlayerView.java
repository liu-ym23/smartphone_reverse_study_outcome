package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerView extends FrameLayout implements TTAVPlayerView {
    private float mCropHeightLimit;
    private float mCropWidthLimit;
    private boolean mIsNeededFixedSize;
    private boolean mIsOnloadCallback;
    private boolean mIsSurfaceCreated;
    private boolean mIsTTPlayerDisplaySizeCalled;
    private TTAVPlayerView.LifeCycleCallback mLifeCycleCallback;
    private boolean mLockCpuBuffer;
    private boolean mNeedCrop;
    private ITTRenderView mRenderView;
    private int mScaleType;
    private float mVideoAspect;
    private TTPlayerViewHelper.Size mVideoSize;
    private int mViewType;
    private TTWindowClient mWindowClient;

    public static /* synthetic */ void a(TTPlayerView r100) {
        r100.lambda$setScaleType$0();
    }

    private void registerRenderViewCallback() {
        this.mRenderView.setRenderCallback(new AnonymousClass2(this));
    }

    private void setupView() {
        if (this.mViewType == 2) goto L5;
        this.mRenderView = new TTSurfaceView(getContext());
    L6:
        addView(this.mRenderView.getView());
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.mRenderView.getView().getLayoutParams();
        if (r100 != null) goto L9;
        r100 = new FrameLayout.LayoutParams(-1, -1, 17);
    L10:
        this.mRenderView.getView().setLayoutParams(r100);
        this.mWindowClient = new TTWindowClient(this.mRenderView, new AnonymousClass1(this));
        registerRenderViewCallback();
        return;
    L9:
        r100.gravity = 17;
        goto L10
    L5:
        this.mRenderView = new TTTextureView(getContext());
        goto L6
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Rect getSurfacePosition() {
        ITTRenderView r100 = this.mRenderView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return TTPlayerViewHelper.getSurfaceRenderPosition(r100.getView());
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Size getSurfaceSize() {
        if (this.mRenderView != null) goto L7;
        return new Size(0, 0);
    L7:
        return new Size(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceAvailable() {
        Surface r100 = this.mRenderView.getSurface();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isValid() == false) goto L7;
        return true;
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceView() {
        return this.mRenderView instanceof TTSurfaceView;
    }

    private /* synthetic */ void lambda$setScaleType$0() {
        forceLayout();
        requestLayout();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void detachFromParent() {
        ViewGroup r100 = (ViewGroup) getParent();
        if (r100 == null) goto L5;
        r100.removeView(this);
    L5:
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view detachFromParent:" + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(r100));
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewHeight() {
        return super.getHeight();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewWidth() {
        return super.getWidth();
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public int getVisibility() {
        return super.getVisibility();
    }

    public static /* synthetic */ boolean access$000(TTPlayerView r100) {
        return r100.mIsTTPlayerDisplaySizeCalled;
    }

    public static /* synthetic */ TTWindowClient access$100(TTPlayerView r100) {
        return r100.mWindowClient;
    }

    public static /* synthetic */ boolean access$1000(TTPlayerView r100) {
        return r100.mNeedCrop;
    }

    public static /* synthetic */ boolean access$200(TTPlayerView r100) {
        return r100.mIsNeededFixedSize;
    }

    public static /* synthetic */ TTPlayerViewHelper.Size access$300(TTPlayerView r100) {
        return r100.mVideoSize;
    }

    public static /* synthetic */ ITTRenderView access$600(TTPlayerView r100) {
        return r100.mRenderView;
    }

    public static /* synthetic */ TTAVPlayerView.LifeCycleCallback access$800(TTPlayerView r100) {
        return r100.mLifeCycleCallback;
    }

    public static /* synthetic */ boolean access$900(TTPlayerView r100) {
        return r100.mIsOnloadCallback;
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup r100) {
        attachToParent(r100, null);
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setLayoutParams(ViewGroup.LayoutParams r100) {
        super.setLayoutParams(r100);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setLifeCycleCallback(TTAVPlayerView.LifeCycleCallback r100) {
        TTAVPlayerView.LifeCycleCallback r101 = this.mLifeCycleCallback;
        if (r101 != null) goto L14;
        if (r101 == r100) goto L18;
        this.mLifeCycleCallback = r100;
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.mIsOnloadCallback == false) goto L11;
        return;
    L11:
        if (this.mIsSurfaceCreated == false) goto L17;
        this.mIsOnloadCallback = true;
        r100.onLoad(this.mWindowClient);
        this.mLifeCycleCallback.onNewSurfaceAvailable();
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        ITTRenderView r101 = this.mRenderView;
        if (r101 == null) goto L6;
        r101.getView().setVisibility(r100);
        return;
    }

    public static /* synthetic */ boolean access$002(TTPlayerView r100, boolean r101) {
        r100.mIsTTPlayerDisplaySizeCalled = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(TTPlayerView r100, boolean r101) {
        r100.mIsNeededFixedSize = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(TTPlayerView r100, boolean r101) {
        r100.mLockCpuBuffer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(TTPlayerView r100, boolean r101) {
        r100.mIsSurfaceCreated = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(TTPlayerView r100, boolean r101) {
        r100.mIsOnloadCallback = r101;
        return r101;
    }

    private void updateDisplaySize(int r100, int r101) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", window: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ",update size called: " + this.mIsTTPlayerDisplaySizeCalled + ",width: " + r100 + ", height: " + r101 + ". fixed: " + this.mIsNeededFixedSize);
        if (r101 != 0) goto L5;
        float r102 = 1.0f;
    L7:
        if (Math.abs(this.mVideoAspect - r102) <= 0.001f) goto L9;
        this.mVideoAspect = r102;
        forceLayout();
        requestLayout();
    L9:
        TTPlayerViewHelper.Size r103 = this.mVideoSize;
        if (r103 != null) goto L12;
    L15:
        this.mVideoSize = new TTPlayerViewHelper.Size(r100, r101);
        if (this.mIsNeededFixedSize == false) goto L20;
        this.mRenderView.setFixedSizeIfNeeded(r100, r101);
        return;
    L20:
        return;
    L12:
        if (r100 != r103.getWidth()) goto L15;
        if (r101 != this.mVideoSize.getHeight()) goto L15;
        return;
    L5:
        r102 = r100 / r101;
        goto L7
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup r100, ViewGroup.LayoutParams r101) {
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view attachToParent: " + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(r100));
        ViewGroup r102 = (ViewGroup) getParent();
        if (r100 == null) goto L10;
        if (r102 == r100) goto L11;
        if (r101 != null) goto L8;
        r101 = new FrameLayout.LayoutParams(-1, -1, 17);
    L8:
        this.mRenderView.reuse();
        detachFromParent();
        setLayoutParams(r101);
        r100.addView(this);
        return;
    L11:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getSize(r100);
        int r102 = View.MeasureSpec.getSize(r110);
        Pair<TTPlayerViewHelper.Size, Boolean> r103 = TTPlayerViewHelper.calculatePlayerViewSize(this.mScaleType, this.mVideoAspect, r101, r102, this.mCropWidthLimit, this.mCropHeightLimit);
        TTPlayerViewHelper.Size r104 = r103.first;
        this.mNeedCrop = Boolean.TRUE.equals(r103.second);
        if (r104 != null) goto L5;
    L14:
        com.ss.vcbkit.a.e(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", viewSize: " + r101 + "x" + r102 + "vaspect: " + this.mVideoAspect);
        measureChildren(r100, r110);
        setMeasuredDimension(r100, r110);
        return;
    L5:
        if (r104.getWidth() == 0) goto L14;
        if (r104.getHeight() == 0) goto L14;
        com.ss.vcbkit.a.c(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view : " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", render view: " + TTPlayerViewHelper.objectToString(this.mRenderView) + ",onMeasure: " + r104.toString() + " viewSize: " + r101 + "x" + r102 + ", scaleType: " + this.mScaleType + ", videoAspect: " + this.mVideoAspect);
        int r105 = View.MeasureSpec.makeMeasureSpec(r104.getWidth(), 1073741824);
        int r106 = View.MeasureSpec.makeMeasureSpec(r104.getHeight(), 1073741824);
        this.mRenderView.getView().measure(r105, r106);
        if (getLayoutParams().width != (-2)) goto L12;
        setMeasuredDimension(r105, r106);
        return;
    L12:
        setMeasuredDimension(r100, r110);
    }

    public static /* synthetic */ void access$400(TTPlayerView r100, int r101, int r102) {
        r100.updateDisplaySize(r101, r102);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setScaleType(int r100, float r101, float r102) {
        if (this.mScaleType == r100) goto L5;
    L9:
        this.mScaleType = r100;
        this.mCropWidthLimit = r101;
        this.mCropHeightLimit = r102;
        post(new e(this));
        return;
    L5:
        if (this.mCropWidthLimit != r101) goto L9;
        if (this.mCropHeightLimit != r102) goto L9;
    }

    public TTPlayerView(Context r110, int r111, float r112, int r113) {
        super(r110);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(r110, null, r111, r112, r113);
    }

    public TTPlayerView(Context r100, TTAVPlayerView.LifeCycleCallback r101, int r102, float r103, int r104) {
        super(r100);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(r100, r101, r102, r103, r104);
    }

    private void init(Context r100, TTAVPlayerView.LifeCycleCallback r101, int r102, float r103, int r104) {
        this.mLifeCycleCallback = r101;
        if (r102 != 2) goto L5;
        int r105 = 2;
    L6:
        this.mViewType = r105;
        if (1 == r102) goto L9;
    L11:
        this.mVideoAspect = r103;
        this.mScaleType = r104;
        setupView();
        return;
    L9:
        if (TTPlayerViewHelper.isEnableSurfaceView(r100) == true) goto L11;
        this.mViewType = 2;
        com.ss.vcbkit.a.e(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn player view current device not support surface view");
        goto L11
    L5:
        r105 = 1;
        goto L6
    }
}
