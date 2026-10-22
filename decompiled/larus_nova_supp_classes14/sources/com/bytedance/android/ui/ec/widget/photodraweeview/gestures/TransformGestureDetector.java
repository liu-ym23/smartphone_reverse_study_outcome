package com.bytedance.android.ui.ec.widget.photodraweeview.gestures;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000eH\u0002J\u000e\u00101\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u00102\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u00104\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000e\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207J\u0014\u00108\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u00109\u001a\u00020+H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R \u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u001e\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\b¨\u0006;"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/MultiPointerGestureDetector;", "()V", "<set-?>", "", "deltaScale", "getDeltaScale", "()F", "deltaTranslationX", "getDeltaTranslationX", "deltaTranslationY", "getDeltaTranslationY", "detector", "", "gestureIntent", "getGestureIntent", "()I", "ignoreGestureIntents", "Ljava/util/ArrayList;", "", "isGestureInProgress", "()Z", "isMultiPointer", "isPointerCountChanged", "isSinglePointer", "listeners", "Ljava/util/LinkedList;", "getListeners", "()Ljava/util/LinkedList;", "setListeners", "(Ljava/util/LinkedList;)V", "pivotX", "getPivotX", "pivotY", "getPivotY", "scale", "getScale", "translationX", "getTranslationX", "translationY", "getTranslationY", "addListener", "", "listener", "calcAverage", "arr", "", "len", "ignoreInitGestureIntent", "onGestureBegin", "onGestureEnd", "onGestureUpdate", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeListener", "reset", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransformGestureDetector implements GestureListener<MultiPointerGestureDetector> {
    public static final Companion Companion = null;
    private static final int GESTURE_DIRECTION_EPS = 10;
    private float deltaScale;
    private float deltaTranslationX;
    private float deltaTranslationY;
    private final MultiPointerGestureDetector detector;
    private int gestureIntent;
    private final ArrayList<Integer> ignoreGestureIntents;
    private boolean isGestureInProgress;
    private boolean isMultiPointer;
    private boolean isPointerCountChanged;
    private boolean isSinglePointer;
    private LinkedList<GestureListener<TransformGestureDetector>> listeners;
    private float pivotX;
    private float pivotY;
    private float scale;
    private float translationX;
    private float translationY;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector$Companion;", "", "()V", "GESTURE_DIRECTION_EPS", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void reset() {
        this.scale = 1.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.pivotX = 0.0f;
        this.pivotY = 0.0f;
        this.deltaTranslationX = 0.0f;
        this.deltaTranslationY = 0.0f;
        this.deltaScale = 1.0f;
        this.gestureIntent = 0;
    }

    public final boolean isGestureInProgress() {
        return this.detector.isGestureInProgress();
    }

    public final boolean isMultiPointer() {
        if (this.detector.getCurPointerCount() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isPointerCountChanged() {
        if (this.detector.getCurPointerCount() == this.detector.getLastPointCount()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSinglePointer() {
        if (this.detector.getCurPointerCount() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public TransformGestureDetector() {
        this.listeners = new LinkedList();
        MultiPointerGestureDetector r0 = new MultiPointerGestureDetector();
        this.detector = r0;
        this.ignoreGestureIntents = new ArrayList();
        this.scale = 1.0f;
        this.deltaScale = 1.0f;
        r0.setListener(this);
    }

    public final float getDeltaScale() {
        return this.deltaScale;
    }

    public final float getDeltaTranslationX() {
        return this.deltaTranslationX;
    }

    public final float getDeltaTranslationY() {
        return this.deltaTranslationY;
    }

    public final int getGestureIntent() {
        return this.gestureIntent;
    }

    public final LinkedList<GestureListener<TransformGestureDetector>> getListeners() {
        return this.listeners;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void addListener(GestureListener<TransformGestureDetector> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listeners.add(r2);
    }

    public final void ignoreInitGestureIntent(int r3) {
        if (this.ignoreGestureIntents.contains(Integer.valueOf(r3)) == true) goto L6;
        this.ignoreGestureIntents.add(Integer.valueOf(r3));
        return;
    }

    /* JADX INFO: renamed from: onGestureBegin, reason: avoid collision after fix types in other method */
    public void onGestureBegin2(MultiPointerGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        Iterator<T> r3 = this.listeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((GestureListener) r3.next()).onGestureBegin(this);
        goto L4
    }

    /* JADX INFO: renamed from: onGestureEnd, reason: avoid collision after fix types in other method */
    public void onGestureEnd2(MultiPointerGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        Iterator<T> r3 = this.listeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((GestureListener) r3.next()).onGestureEnd(this);
        goto L4
    L6:
        reset();
    }

    /* JADX INFO: renamed from: onGestureUpdate, reason: avoid collision after fix types in other method */
    public void onGestureUpdate2(MultiPointerGestureDetector r11) {
        Intrinsics.checkNotNullParameter(r11, "detector");
        if (isSinglePointer() == true) goto L5;
        float r0 = r11.getStartX()[1] - r11.getStartX()[0];
        float r3 = r11.getStartY()[1] - r11.getStartY()[0];
        float r4 = r11.getCurrentX()[1] - r11.getCurrentX()[0];
        float r5 = r11.getCurrentY()[1] - r11.getCurrentY()[0];
        float r1 = (float) Math.hypot(r0, r3);
        float r6 = (float) Math.hypot(r4, r5);
        float r7 = this.scale;
        float r8 = r6 / r1;
        this.scale = r8;
        this.deltaScale = r8 / r7;
        this.pivotX = calcAverage(r11.getCurrentX(), r11.getCurPointerCount());
        this.pivotY = calcAverage(r11.getCurrentY(), r11.getCurPointerCount());
    L6:
        float r2 = calcAverage(r11.getCurrentX(), r11.getCurPointerCount()) - calcAverage(r11.getLastX(), r11.getCurPointerCount());
        this.deltaTranslationX = r2;
        this.translationX += r2;
        float r9 = calcAverage(r11.getCurrentY(), r11.getCurPointerCount()) - calcAverage(r11.getLastY(), r11.getCurPointerCount());
        this.deltaTranslationY = r9;
        this.translationY += r9;
        if (isSinglePointer() == true) goto L9;
        this.gestureIntent = -1;
    L33:
        Iterator<T> r12 = this.listeners.iterator();
    L35:
        if (r12.hasNext() == false) goto L37;
        ((GestureListener) r12.next()).onGestureUpdate(this);
        goto L35
    L37:
        return;
    L9:
        if (this.gestureIntent != 0) goto L33;
        if ((Math.abs(this.translationX) - Math.abs(this.translationY)) < 0) goto L23;
        if (this.translationX >= (-10)) goto L18;
        if (this.ignoreGestureIntents.contains(1) == true) goto L18;
        this.gestureIntent = 1;
    L18:
        if (this.translationX <= 10) goto L33;
        if (this.ignoreGestureIntents.contains(3) == true) goto L33;
        this.gestureIntent = 3;
        goto L33
    L23:
        if (this.translationY >= (-10)) goto L28;
        if (this.ignoreGestureIntents.contains(2) == true) goto L28;
        this.gestureIntent = 2;
    L28:
        if (this.translationY <= 10) goto L33;
        if (this.ignoreGestureIntents.contains(4) == true) goto L33;
        this.gestureIntent = 4;
        goto L33
    L5:
        this.scale = 1.0f;
        this.deltaScale = 1.0f;
        goto L6
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.detector.onTouchEvent(r2);
    }

    public final void removeListener(GestureListener<TransformGestureDetector> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listeners.remove(r2);
    }

    public final void setListeners(LinkedList<GestureListener<TransformGestureDetector>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.listeners = r2;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(MultiPointerGestureDetector r1) {
        onGestureBegin2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(MultiPointerGestureDetector r1) {
        onGestureEnd2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(MultiPointerGestureDetector r1) {
        onGestureUpdate2(r1);
    }

    private final float calcAverage(float[] r5, int r6) {
        int r1 = 0;
        float r2 = 0.0f;
    L3:
        if (r1 >= r6) goto L5;
        r2 = r2 + r5[r1];
        r1 = r1 + 1;
        goto L3
    L5:
        if (r6 > 0) goto L7;
        return 0.0f;
    L7:
        return r2 / r6;
    }
}
