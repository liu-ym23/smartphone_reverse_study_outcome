package com.ss.bytertc.base.media.camera;

import android.graphics.ImageFormat;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.bytertc.base.media.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class CameraEnumerationAndroid {
    static final ArrayList<Size> COMMON_RESOLUTIONS = null;
    private static final String TAG = "CameraEnumerationAndroid";

    public static class CaptureFormat {
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat;
        public final int width;

        public static class FramerateRange {
            public int max;
            public int min;

            public String toString() {
                return "[" + (this.min / 1000.0f) + ":" + (this.max / 1000.0f) + "]";
            }

            public int hashCode() {
                return ((this.min * CastMonitor.EVENT_TRACK) + 1) + this.max;
            }

            public boolean equals(Object r100) {
                if ((r100 instanceof FramerateRange) == true) goto L5;
                return false;
            L5:
                FramerateRange r101 = (FramerateRange) r100;
                if (this.min == r101.min) goto L8;
                return false;
            L8:
                if (this.max != r101.max) goto L12;
                return true;
            L12:
                return false;
            }

            public FramerateRange(int r100, int r101) {
                this.min = r100;
                this.max = r101;
            }
        }

        public int frameSize() {
            return frameSize(this.width, this.height, 17);
        }

        public int hashCode() {
            return ((((this.width * 65497) + this.height) * 251) + 1) + this.framerate.hashCode();
        }

        public String toString() {
            return this.width + "x" + this.height + "@" + this.framerate;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof CaptureFormat) == true) goto L5;
            return false;
        L5:
            CaptureFormat r101 = (CaptureFormat) r100;
            if (this.width == r101.width) goto L8;
            return false;
        L8:
            if (this.height == r101.height) goto L10;
            return false;
        L10:
            if (this.framerate.equals(r101.framerate) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public CaptureFormat(int r100, int r101, FramerateRange r102) {
            this.imageFormat = 17;
            this.width = r100;
            this.height = r101;
            this.framerate = r102;
        }

        public static int frameSize(int r100, int r101, int r102) {
            if (r102 != 17) goto L7;
            return ((r100 * r101) * ImageFormat.getBitsPerPixel(r102)) / 8;
        L7:
            throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
        }

        public CaptureFormat(int r100, int r101, int r102, int r103) {
            this.imageFormat = 17;
            this.width = r100;
            this.height = r101;
            this.framerate = new FramerateRange(r102, r103);
        }
    }

    public static abstract class ClosestComparator<T> implements Comparator<T> {
        private ClosestComparator() {
        }

        public abstract int diff(T r100);

        public /* synthetic */ ClosestComparator(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(T r100, T r101) {
            return diff(r100) - diff(r101);
        }
    }

    public CameraEnumerationAndroid() {
    }

    static {
        COMMON_RESOLUTIONS = new ArrayList(Arrays.asList(new Size[]{new Size(160, 120), new Size(240, 160), new Size(320, 240), new Size(400, 240), new Size(480, 320), new Size(640, 360), new Size(640, 480), new Size(ISmModel.VERSION_0300, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(1024, 576), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(TECameraUtils.CAPTURE_NORMAL, 1080), new Size(TECameraUtils.CAPTURE_NORMAL, 1440), new Size(TECameraUtils.CAPTURE_HQ_2X, 1440), new Size(3840, 2160)}));
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> r100, final int r101) {
        return (CaptureFormat.FramerateRange) Collections.min(r100, new AnonymousClass1(r101));
    }

    public static void reportCameraResolution(Histogram r100, Size r101) {
        r100.addSample(COMMON_RESOLUTIONS.indexOf(r101) + 1);
    }

    public static Size getClosestSupportedSize(List<Size> r100, final int r101, final int r102) {
        return (Size) Collections.min(r100, new AnonymousClass2(r101, r102));
    }

    public static Size getUpClosestSupportedSize(List<Size> r100, int r101, int r102) {
        int r103 = 0;
        Size r104 = new Size(0, 0);
        boolean r105 = false;
        int r106 = Integer.MAX_VALUE;
    L4:
        if (r103 >= r100.size()) goto L12;
        Size r107 = (Size) ListProtector.get(r100, r103);
        int r108 = r107.width;
        if (r108 < r101) goto L11;
        int r109 = Math.abs(r101 - r108) + Math.abs(r102 - r107.height);
        if (r109 > r106) goto L11;
        r104 = r107;
        r106 = r109;
        r105 = true;
    L11:
        r103 = r103 + 1;
        goto L4
    L12:
        if (r105 == false) goto L14;
        return r104;
    L14:
        return getClosestSupportedSize(r100, r101, r102);
    }
}
