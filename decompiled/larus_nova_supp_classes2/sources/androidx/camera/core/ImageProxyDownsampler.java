package androidx.camera.core;

import android.util.Size;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageProxyDownsampler {

    public static final enum DownsamplingMethod extends Enum<DownsamplingMethod> {
        private static final /* synthetic */ DownsamplingMethod[] $VALUES = null;
        public static final DownsamplingMethod AVERAGING = null;
        public static final DownsamplingMethod NEAREST_NEIGHBOR = null;

        private static /* synthetic */ DownsamplingMethod[] $values() {
            return new DownsamplingMethod[]{NEAREST_NEIGHBOR, AVERAGING};
        }

        static {
            NEAREST_NEIGHBOR = new DownsamplingMethod("NEAREST_NEIGHBOR", 0);
            AVERAGING = new DownsamplingMethod("AVERAGING", 1);
            $VALUES = $values();
        }

        public static DownsamplingMethod[] values() {
            return (DownsamplingMethod[]) $VALUES.clone();
        }

        public static DownsamplingMethod valueOf(String r1) {
            return (DownsamplingMethod) r27.a.a(DownsamplingMethod.class, r1);
        }

        private DownsamplingMethod(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }

        public ForwardingImageProxyImpl(ImageProxy r1, ImageProxy.PlaneProxy[] r2, int r3, int r4) {
            super(r1);
            this.mDownsampledPlanes = r2;
            this.mDownsampledWidth = r3;
            this.mDownsampledHeight = r4;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final int r1, final int r2, final byte[] r3) {
        return new AnonymousClass1(r3, r1, r2);
    }

    public static ForwardingImageProxy downsample(ImageProxy r21, int r22, int r23, DownsamplingMethod r24) {
        if (r21.getFormat() != 35) goto L28;
        if (r21.getWidth() < r22) goto L26;
        if (r21.getHeight() < r23) goto L26;
        if (r21.getWidth() == r22) goto L11;
    L14:
        int r6 = 0;
        int[] r4 = {r21.getWidth(), r21.getWidth() / 2, r21.getWidth() / 2};
        int[] r5 = {r21.getHeight(), r21.getHeight() / 2, r21.getHeight() / 2};
        int r10 = r22 / 2;
        int[] r9 = {r22, r10, r10};
        int r11 = r23 / 2;
        int[] r12 = {r23, r11, r11};
        ImageProxy.PlaneProxy[] r7 = new ImageProxy.PlaneProxy[3];
    L15:
        if (r6 >= 3) goto L24;
        ImageProxy.PlaneProxy r13 = r21.getPlanes()[r6];
        ByteBuffer r14 = r13.getBuffer();
        byte[] r15 = new byte[r9[r6] * r12[r6]];
        int r16 = r24.ordinal();
        if (r16 == 0) goto L21;
        if (r16 == 1) goto L20;
        byte[] r20 = r15;
    L22:
        r7[r6] = createPlaneProxy(r9[r6], 1, r20);
        r6 = r6 + 1;
        goto L15
    L20:
        r20 = r15;
        resizeAveraging(r14, r4[r6], r13.getPixelStride(), r13.getRowStride(), r5[r6], r20, r9[r6], r12[r6]);
        goto L22
    L21:
        r20 = r15;
        resizeNearestNeighbor(r14, r4[r6], r13.getPixelStride(), r13.getRowStride(), r5[r6], r20, r9[r6], r12[r6]);
        goto L22
    L24:
        return new ForwardingImageProxyImpl(r21, r7, r22, r23);
    L11:
        if (r21.getHeight() != r23) goto L14;
        return new ForwardingImageProxyImpl(r21, r21.getPlanes(), r22, r23);
    L26:
        throw new IllegalArgumentException("Downsampled dimension " + new Size(r22, r23) + " is not <= original dimension " + new Size(r21.getWidth(), r21.getHeight()) + ".");
    L28:
        throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
    }

    private static void resizeAveraging(ByteBuffer r16, int r17, int r18, int r19, int r20, byte[] r21, int r22, int r23) {
        float r4 = r17 / r22;
        float r6 = r20 / r23;
        byte[] r7 = new byte[r19];
        byte[] r8 = new byte[r19];
        int[] r9 = new int[r22];
        int r10 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r22) goto L5;
        r9[r11] = ((int) (r11 * r4)) * r18;
        r11 = r11 + 1;
        goto L3
    L5:
        monitor-enter(r16);
        r16.rewind();     // Catch: Throwable -> L14
        int r5 = 0;
    L7:
        if (r5 >= r23) goto L12;
        int r12 = (int) (r5 * r6);     // Catch: Throwable -> L14
        int r13 = r20 - 1;     // Catch: Throwable -> L14
        int r14 = Math.min(r12, r13) * r19;     // Catch: Throwable -> L14
        int r15 = Math.min(r12 + 1, r13) * r19;     // Catch: Throwable -> L14
        int r110 = r5 * r22;     // Catch: Throwable -> L14
        r16.position(r14);     // Catch: Throwable -> L14
        r16.get(r7, r10, Math.min(r19, r16.remaining()));     // Catch: Throwable -> L14
        r16.position(r15);     // Catch: Throwable -> L14
        r16.get(r8, r10, Math.min(r19, r16.remaining()));     // Catch: Throwable -> L14
        int r111 = 0;
    L9:
        if (r111 >= r22) goto L11;
        int r112 = r9[r111];     // Catch: Throwable -> L14
        int r113 = r7[r112] & 255;     // Catch: Throwable -> L14
        int r114 = r7[r112 + r18] & 255;     // Catch: Throwable -> L14
        r21[r110 + r111] = (byte) (((((r113 + r114) + (r8[r112] & 255)) + (r8[r112 + r18] & 255)) / 4) & 255);     // Catch: Throwable -> L14
        r111 = r111 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r5 = r5 + 1;     // Catch: Throwable -> L14
        r10 = 0;
        goto L7
    L12:
        monitor-exit(r16);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static void resizeNearestNeighbor(ByteBuffer r7, int r8, int r9, int r10, int r11, byte[] r12, int r13, int r14) {
        float r15 = r8 / r13;
        float r0 = r11 / r14;
        byte[] r1 = new byte[r10];
        int[] r2 = new int[r13];
        int r4 = 0;
    L3:
        if (r4 >= r13) goto L5;
        r2[r4] = ((int) (r4 * r15)) * r9;
        r4 = r4 + 1;
        goto L3
    L5:
        monitor-enter(r7);
        r7.rewind();     // Catch: Throwable -> L14
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L12;
        int r5 = r16 * r13;     // Catch: Throwable -> L14
        r7.position(Math.min((int) (r16 * r0), r11 - 1) * r10);     // Catch: Throwable -> L14
        r7.get(r1, 0, Math.min(r10, r7.remaining()));     // Catch: Throwable -> L14
        int r17 = 0;
    L9:
        if (r17 >= r13) goto L11;
        r12[r5 + r17] = r1[r2[r17]];     // Catch: Throwable -> L14
        r17 = r17 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r16 = r16 + 1;     // Catch: Throwable -> L14
        goto L7
    L12:
        monitor-exit(r7);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
