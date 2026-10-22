package com.facebook.drawee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    private DraweeController mController;
    private final DraweeEventTracker mEventTracker;
    private DH mHierarchy;
    private boolean mIsControllerAttached;
    private boolean mIsHolderAttached;
    private boolean mIsVisible;

    public void registerWithContext(Context r100) {
    }

    private void attachController() {
        if (this.mIsControllerAttached == false) goto L5;
        return;
    L5:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        this.mIsControllerAttached = true;
        DraweeController r100 = this.mController;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getHierarchy() == null) goto L12;
        this.mController.onAttach();
        return;
    }

    private void attachOrDetachController() {
        if (this.mIsHolderAttached == true) goto L5;
    L7:
        detachController();
        return;
    L5:
        if (this.mIsVisible == false) goto L7;
        attachController();
    }

    private void detachController() {
        if (this.mIsControllerAttached == true) goto L5;
        return;
    L5:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsControllerAttached = false;
        if (isControllerValid() == false) goto L9;
        this.mController.onDetach();
        return;
    }

    public DH getHierarchy() {
        return (DH) Preconditions.checkNotNull(this.mHierarchy);
    }

    public Drawable getTopLevelDrawable() {
        DH r100 = this.mHierarchy;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getTopLevelDrawable();
    }

    public boolean hasHierarchy() {
        if (this.mHierarchy == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isControllerValid() {
        DraweeController r100 = this.mController;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getHierarchy() != this.mHierarchy) goto L7;
        return true;
    }

    public void onAttach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.mIsHolderAttached = true;
        attachOrDetachController();
    }

    public void onDetach() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.mIsHolderAttached = false;
        attachOrDetachController();
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
        if (this.mIsControllerAttached == false) goto L5;
        return;
    L5:
        FLog.w(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), toString()});
        this.mIsHolderAttached = true;
        this.mIsVisible = true;
        attachOrDetachController();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("events", this.mEventTracker.toString()).toString();
    }

    @Nullable
    public DraweeController getController() {
        return this.mController;
    }

    public DraweeEventTracker getDraweeEventTracker() {
        return this.mEventTracker;
    }

    public boolean isAttached() {
        return this.mIsHolderAttached;
    }

    public DraweeHolder(@Nullable DH r100) {
        this.mIsControllerAttached = false;
        this.mIsHolderAttached = false;
        this.mIsVisible = true;
        this.mController = null;
        this.mEventTracker = DraweeEventTracker.newInstance();
        if (r100 == null) goto L6;
        setHierarchy(r100);
        return;
    }

    private void setVisibilityCallback(@Nullable VisibilityCallback r100) {
        Object r101 = getTopLevelDrawable();
        if ((r101 instanceof VisibilityAwareDrawable) == false) goto L6;
        ((VisibilityAwareDrawable) r101).setVisibilityCallback(r100);
        return;
    }

    public boolean onTouchEvent(MotionEvent r100) {
        if (isControllerValid() == true) goto L7;
        return false;
    L7:
        return this.mController.onTouchEvent(r100);
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onVisibilityChange(boolean r100) {
        if (this.mIsVisible != r100) goto L5;
        return;
    L5:
        DraweeEventTracker r101 = this.mEventTracker;
        if (r100 == false) goto L8;
        DraweeEventTracker.Event r102 = DraweeEventTracker.Event.ON_DRAWABLE_SHOW;
    L9:
        r101.recordEvent(r102);
        this.mIsVisible = r100;
        attachOrDetachController();
        return;
    L8:
        r102 = DraweeEventTracker.Event.ON_DRAWABLE_HIDE;
        goto L9
    }

    public void setController(@Nullable DraweeController r100) {
        boolean r101 = this.mIsControllerAttached;
        if (r101 == false) goto L6;
        detachController();
    L6:
        if (isControllerValid() == false) goto L11;
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
        if (FrescoCacheMonitorUtil.isOptRest() == false) goto L10;
        this.mController.clearHierarchy();
        goto L11
    L10:
        this.mController.setHierarchy(null);
    L11:
        this.mController = r100;
        if (r100 == null) goto L14;
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
        this.mController.setHierarchy(this.mHierarchy);
    L15:
        if (r101 == false) goto L18;
        attachController();
        return;
    L18:
        return;
    L14:
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        goto L15
    }

    public void setHierarchy(DH r100) {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        boolean r101 = isControllerValid();
        setVisibilityCallback(null);
        DH r102 = (DH) Preconditions.checkNotNull(r100);
        this.mHierarchy = r102;
        Drawable r103 = r102.getTopLevelDrawable();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        onVisibilityChange(r104);
        setVisibilityCallback(this);
        if (r101 == false) goto L13;
        this.mController.setHierarchy(r100);
        return;
    L13:
        return;
    L5:
        if (r103.isVisible() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH r100, Context r101) {
        DraweeHolder<DH> r102 = new DraweeHolder(r100);
        r102.registerWithContext(r101);
        return r102;
    }
}
