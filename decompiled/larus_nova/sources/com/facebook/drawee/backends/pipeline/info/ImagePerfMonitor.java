package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfMonitor extends BaseRequestListener {
    private boolean mEnabled;

    @Nullable
    private ForwardingRequestListener mForwardingRequestListener;

    @Nullable
    private ImageOriginListener mImageOriginListener;

    @Nullable
    private ImageOriginRequestListener mImageOriginRequestListener;

    @Nullable
    private ImagePerfControllerListener mImagePerfControllerListener;

    @Nullable
    private List<ImagePerfDataListener> mImagePerfDataListeners;

    @Nullable
    private ImagePerfRequestListener mImagePerfRequestListener;
    private final ImagePerfState mImagePerfState;
    private final MonotonicClock mMonotonicClock;
    private final PipelineDraweeController mPipelineDraweeController;

    private void setupListeners() {
        if (this.mImagePerfControllerListener != null) goto L6;
        this.mImagePerfControllerListener = new ImagePerfControllerListener(this.mMonotonicClock, this.mImagePerfState, this);
    L6:
        if (this.mImagePerfRequestListener != null) goto L9;
        this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
    L9:
        if (this.mImageOriginListener != null) goto L11;
        this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
    L11:
        ImageOriginRequestListener r100 = this.mImageOriginRequestListener;
        if (r100 != null) goto L14;
        this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
    L16:
        if (this.mForwardingRequestListener != null) goto L19;
        this.mForwardingRequestListener = new ForwardingRequestListener(new RequestListener[]{this.mImagePerfRequestListener, this.mImageOriginRequestListener});
        return;
    L19:
        return;
    L14:
        r100.init(this.mPipelineDraweeController.getId());
        goto L16
    }

    public void addViewportData() {
        DraweeHierarchy r100 = this.mPipelineDraweeController.getHierarchy();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getTopLevelDrawable() == null) goto L9;
        Rect r101 = r100.getTopLevelDrawable().getBounds();
        this.mImagePerfState.setOnScreenWidth(r101.width());
        this.mImagePerfState.setOnScreenHeight(r101.height());
        return;
    }

    public void clearImagePerfDataListeners() {
        List<ImagePerfDataListener> r100 = this.mImagePerfDataListeners;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public void reset() {
        clearImagePerfDataListeners();
        setEnabled(false);
        this.mImagePerfState.reset();
    }

    public void addImagePerfDataListener(@Nullable ImagePerfDataListener r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mImagePerfDataListeners != null) goto L7;
        this.mImagePerfDataListeners = new LinkedList();
    L7:
        this.mImagePerfDataListeners.add(r100);
    }

    public void removeImagePerfDataListener(ImagePerfDataListener r100) {
        List<ImagePerfDataListener> r101 = this.mImagePerfDataListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void setEnabled(boolean r100) {
        this.mEnabled = r100;
        if (r100 == false) goto L13;
        setupListeners();
        ImageOriginListener r101 = this.mImageOriginListener;
        if (r101 == null) goto L7;
        this.mPipelineDraweeController.addImageOriginListener(r101);
    L7:
        ImagePerfControllerListener r102 = this.mImagePerfControllerListener;
        if (r102 == null) goto L10;
        this.mPipelineDraweeController.addControllerListener(r102);
    L10:
        ForwardingRequestListener r103 = this.mForwardingRequestListener;
        if (r103 == null) goto L23;
        this.mPipelineDraweeController.addRequestListener(r103);
        return;
    L23:
        return;
    L13:
        ImageOriginListener r104 = this.mImageOriginListener;
        if (r104 == null) goto L16;
        this.mPipelineDraweeController.removeImageOriginListener(r104);
    L16:
        ImagePerfControllerListener r105 = this.mImagePerfControllerListener;
        if (r105 == null) goto L19;
        this.mPipelineDraweeController.removeControllerListener(r105);
    L19:
        ForwardingRequestListener r106 = this.mForwardingRequestListener;
        if (r106 == null) goto L25;
        this.mPipelineDraweeController.removeRequestListener(r106);
        return;
    }

    public ImagePerfMonitor(MonotonicClock r100, PipelineDraweeController r101) {
        this.mMonotonicClock = r100;
        this.mPipelineDraweeController = r101;
        this.mImagePerfState = new ImagePerfState();
    }

    public void notifyListenersOfVisibilityStateUpdate(ImagePerfState r100, int r101) {
        if (this.mEnabled == false) goto L13;
        List<ImagePerfDataListener> r102 = this.mImagePerfDataListeners;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isEmpty() == true) goto L16;
        ImagePerfData r103 = r100.snapshot();
        Iterator<ImagePerfDataListener> r104 = this.mImagePerfDataListeners.iterator();
    L11:
        if (r104.hasNext() == false) goto L17;
        r104.next().onImageVisibilityUpdated(r103, r101);
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public void notifyStatusUpdated(ImagePerfState r100, int r101) {
        r100.setImageLoadStatus(r101);
        if (this.mEnabled == false) goto L16;
        List<ImagePerfDataListener> r102 = this.mImagePerfDataListeners;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.isEmpty() == false) goto L10;
        return;
    L10:
        if (r101 != 3) goto L12;
        addViewportData();
    L12:
        ImagePerfData r103 = r100.snapshot();
        Iterator<ImagePerfDataListener> r104 = this.mImagePerfDataListeners.iterator();
    L14:
        if (r104.hasNext() == false) goto L20;
        r104.next().onImageLoadStatusUpdated(r103, r101);
        goto L14
    L20:
        return;
    }
}
