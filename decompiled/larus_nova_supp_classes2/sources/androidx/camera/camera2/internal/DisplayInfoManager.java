package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.camera.camera2.internal.compat.workaround.DisplaySizeCorrector;
import androidx.camera.camera2.internal.compat.workaround.MaxPreviewSize;
import androidx.camera.core.internal.utils.SizeUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DisplayInfoManager {
    private static final Size ABNORMAL_DISPLAY_SIZE_THRESHOLD = null;
    private static final Size FALLBACK_DISPLAY_SIZE = null;
    private static final Object INSTANCE_LOCK = null;
    private static final Size MAX_PREVIEW_SIZE = null;
    private static volatile DisplayInfoManager sInstance;
    private final DisplayManager mDisplayManager;
    private final DisplaySizeCorrector mDisplaySizeCorrector;
    private final MaxPreviewSize mMaxPreviewSize;
    private volatile Size mPreviewSize;

    public static void releaseInstance() {
        sInstance = null;
    }

    static {
        MAX_PREVIEW_SIZE = new Size(1920, 1080);
        ABNORMAL_DISPLAY_SIZE_THRESHOLD = new Size(320, 240);
        FALLBACK_DISPLAY_SIZE = new Size(640, 480);
        INSTANCE_LOCK = new Object();
    }

    private Size getCorrectedDisplaySize() {
        Point r0 = new Point();
        getMaxSizeDisplay(false).getRealSize(r0);
        Size r1 = new Size(r0.x, r0.y);
        if (SizeUtil.isSmallerByArea(r1, ABNORMAL_DISPLAY_SIZE_THRESHOLD) == false) goto L8;
        r1 = this.mDisplaySizeCorrector.getDisplaySize();
        if (r1 != null) goto L8;
        r1 = FALLBACK_DISPLAY_SIZE;
    L8:
        if (r1.getHeight() > r1.getWidth()) goto L10;
        return r1;
    L10:
        return new Size(r1.getHeight(), r1.getWidth());
    }

    public Size getPreviewSize() {
        if (this.mPreviewSize != null) goto L5;
        this.mPreviewSize = calculatePreviewSize();
        return this.mPreviewSize;
    L5:
        return this.mPreviewSize;
    }

    private Size calculatePreviewSize() {
        Size r0 = getCorrectedDisplaySize();
        int r1 = r0.getWidth() * r0.getHeight();
        Size r2 = MAX_PREVIEW_SIZE;
        if (r1 <= (r2.getWidth() * r2.getHeight())) goto L6;
        r0 = r2;
    L6:
        return this.mMaxPreviewSize.getMaxPreviewResolution(r0);
    }

    public void refresh() {
        this.mPreviewSize = calculatePreviewSize();
    }

    private DisplayInfoManager(Context r2) {
        this.mPreviewSize = null;
        this.mMaxPreviewSize = new MaxPreviewSize();
        this.mDisplaySizeCorrector = new DisplaySizeCorrector();
        this.mDisplayManager = (DisplayManager) r2.getSystemService("display");
    }

    public static DisplayInfoManager getInstance(Context r2) {
        if (sInstance != null) goto L15;
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DisplayInfoManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Display getMaxSizeDisplay(boolean r5) {
        Display[] r0 = this.mDisplayManager.getDisplays();
        if (r0.length == 1) goto L5;
        Display r1 = getMaxSizeDisplayInternal(r0, r5);
        if (r1 != null) goto L10;
        if (r5 == false) goto L10;
        r1 = getMaxSizeDisplayInternal(r0, false);
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    L5:
        return r0[0];
    }

    private Display getMaxSizeDisplayInternal(Display[] r9, boolean r10) {
        int r0 = r9.length;
        Display r1 = null;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L13;
        Display r4 = r9[r3];
        if (r10 == true) goto L7;
    L9:
        Point r5 = new Point();
        r4.getRealSize(r5);
        int r6 = r5.x;
        int r7 = r5.y;
        if ((r6 * r7) <= r2) goto L12;
        r1 = r4;
        r2 = r6 * r7;
    L12:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4.getState() != 1) goto L9;
    L13:
        return r1;
    }
}
