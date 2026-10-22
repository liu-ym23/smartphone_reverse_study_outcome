package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ForwardingControllerListener<INFO> extends BaseControllerListener<INFO> {
    private static final String TAG = "FdingControllerListener";
    private final List<ControllerListener<? super INFO>> mListeners;

    public synchronized void clearListeners() {
        monitor-enter(this);
        this.mListeners.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static <INFO> ForwardingControllerListener<INFO> create() {
        return new ForwardingControllerListener();
    }

    public ForwardingControllerListener() {
        this.mListeners = new ArrayList(2);
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> r100) {
        ForwardingControllerListener<INFO> r101 = create();
        r101.addListener(r100);
        return r101;
    }

    public synchronized void addListener(ControllerListener<? super INFO> r100) {
        monitor-enter(this);
        this.mListeners.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(String r100) {
        monitor-enter(this);
        int r101 = this.mListeners.size();     // Catch: Throwable -> L15
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L13;
        ControllerListener<? super INFO> r103 = this.mListeners.get(r102);     // Catch: Exception -> L10 Throwable -> L15
        if (r103 == null) goto L12;
        r103.onRelease(r100);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r102 = r102 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onRelease", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void removeListener(ControllerListener<? super INFO> r100) {
        monitor-enter(this);
        int r101 = this.mListeners.indexOf(r100);     // Catch: Throwable -> L8
        if (r101 == (-1)) goto L6;
        this.mListeners.set(r101, null);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> r100, ControllerListener<? super INFO> r101) {
        ForwardingControllerListener<INFO> r102 = create();
        r102.addListener(r100);
        r102.addListener(r101);
        return r102;
    }

    private synchronized void onException(String r100, Throwable r101) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public void onControllerStart(ImageRequest r100, long r101) {
        int r102 = this.mListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L8
        if ((r104 instanceof BaseFrescoControllerListener) == false) goto L10;
        ((BaseFrescoControllerListener) r104).onControllerStart(r100, r101);     // Catch: Exception -> L8
    L10:
        r103 = r103 + 1;
    L8:
        e = move-exception;
        onException("InternalListener exception in onFinalImageSet", e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(String r100, Throwable r101) {
        monitor-enter(this);
        int r102 = this.mListeners.size();     // Catch: Throwable -> L15
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L10 Throwable -> L15
        if (r104 == null) goto L12;
        r104.onFailure(r100, r101);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r103 = r103 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onFailure", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String r100, Throwable r101) {
        int r102 = this.mListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L8
        if (r104 == null) goto L10;
        r104.onIntermediateImageFailed(r100, r101);     // Catch: Exception -> L8
    L10:
        r103 = r103 + 1;
    L8:
        e = move-exception;
        onException("InternalListener exception in onIntermediateImageFailed", e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String r100, @Nullable INFO r101) {
        int r102 = this.mListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L8
        if (r104 == null) goto L10;
        r104.onIntermediateImageSet(r100, r101);     // Catch: Exception -> L8
    L10:
        r103 = r103 + 1;
    L8:
        e = move-exception;
        onException("InternalListener exception in onIntermediateImageSet", e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public synchronized void onRelease(String r100, ImageRequest r101) {
        monitor-enter(this);
        int r102 = this.mListeners.size();     // Catch: Throwable -> L15
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L10 Throwable -> L15
        if ((r104 instanceof BaseFrescoControllerListener) == false) goto L12;
        ((BaseFrescoControllerListener) r104).onRelease(r100, r101);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r103 = r103 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onRelease", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(String r100, Object r101) {
        monitor-enter(this);
        int r102 = this.mListeners.size();     // Catch: Throwable -> L15
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L13;
        ControllerListener<? super INFO> r104 = this.mListeners.get(r103);     // Catch: Exception -> L10 Throwable -> L15
        if (r104 == null) goto L12;
        r104.onSubmit(r100, r101);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r103 = r103 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onSubmit", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public synchronized void onFailure(String r100, ImageRequest r101, Throwable r102) {
        monitor-enter(this);
        int r103 = this.mListeners.size();     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        ControllerListener<? super INFO> r105 = this.mListeners.get(r104);     // Catch: Exception -> L10 Throwable -> L15
        if ((r105 instanceof BaseFrescoControllerListener) == false) goto L12;
        ((BaseFrescoControllerListener) r105).onFailure(r100, r101, r102);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r104 = r104 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onFailure", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
        monitor-enter(this);
        int r103 = this.mListeners.size();     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        ControllerListener<? super INFO> r105 = this.mListeners.get(r104);     // Catch: Exception -> L10 Throwable -> L15
        if (r105 == null) goto L12;
        r105.onFinalImageSet(r100, r101, r102);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        r104 = r104 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onFinalImageSet", e);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public void onIntermediateImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
        int r103 = this.mListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener<? super INFO> r105 = this.mListeners.get(r104);     // Catch: Exception -> L8
        if ((r105 instanceof BaseControllerListener) == false) goto L10;
        ((BaseControllerListener) r105).onIntermediateImageSet(r100, r101, r102);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        onException("InternalListener exception in onIntermediateImageSet", e);
        goto L10
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public void onFinalImageSet(String r110, @Nullable INFO r111, @Nullable Animatable r112, ImageRequest r113, Map r114) {
        int r100 = this.mListeners.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L13;
        ControllerListener<? super INFO> r102 = this.mListeners.get(r101);     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        if ((r102 instanceof BaseFrescoControllerListener) == false) goto L12;
        ((BaseFrescoControllerListener) r102).onFinalImageSet(r110, r111, r112, r113, r114);     // Catch: Exception -> L10
    L12:
        r101 = r101 + 1;
    L10:
        e = move-exception;
        onException("InternalListener exception in onFinalImageSet", e);
        goto L12
    }
}
