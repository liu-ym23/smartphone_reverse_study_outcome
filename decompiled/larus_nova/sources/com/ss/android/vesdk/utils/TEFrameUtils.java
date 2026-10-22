package com.ss.android.vesdk.utils;

import bfc.b;
import com.ss.android.medialib.camera.ImageFrame;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.model.e;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.vesdk.VECameraSettings;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class TEFrameUtils {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f455937a = null;

        static {
            int[] r100 = new int[TECameraFrame.ETEPixelFormat.values().length];
            f455937a = r100;
            r100[TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f455937a[TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f455937a[TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public TEFrameUtils() {
    }

    public static int TEFormat2ImageFormat(TECameraFrame.ETEPixelFormat r100) {
        int r101 = a.f455937a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1;
    L5:
        if (r101 != 2) goto L7;
        return -3;
    L7:
        if (r101 == 3) goto L9;
        return -1;
    L9:
        return -2;
    }

    public static ImageFrame TEImageFrame2ImageFrame(TECameraFrame r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420) goto L9;
        return new ImageFrame(new b(r100.getPlans().getPlanes()), TEFormat2ImageFormat(r100.getPixelFormat()), r100.getSize().width, r100.getSize().height);
    L9:
        if (r100.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG) goto L15;
        if (r100.getBufferData() != null) goto L19;
        ByteBuffer r101 = r100.getPlans().getPlaneBuffer(0);
        r101.rewind();
        byte[] r102 = new byte[r101.remaining()];
        r101.get(r102);
        return new ImageFrame(r102, TEFormat2ImageFormat(r100.getPixelFormat()), r100.getSize().width, r100.getSize().height);
    L19:
        return new ImageFrame(r100.getBufferData(), TEFormat2ImageFormat(r100.getPixelFormat()), r100.getSize().width, r100.getSize().height);
    L15:
        if (r100.getPixelFormat() == TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21) goto L17;
        return null;
    L17:
        return new ImageFrame(r100.getBufferData(), TEFormat2ImageFormat(r100.getPixelFormat()), r100.getSize().width, r100.getSize().height);
    }

    public static VEFrame TEImageFrame2VEFrame(TECameraFrame r110) {
        VEFrame r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        boolean r101 = false;
        if (r110.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420) goto L9;
        r100 = VEFrame.createYUVPlanFrame(new e(r110.getPlans().getPlanes()), r110.getSize().width, r110.getSize().height, r110.getRotation(), r110.getTimeStampNS(), VEFrame.ETEPixelFormat.TEPIXEL_FORMAT_YUV420);
    L20:
        if (r100 != null) goto L22;
    L27:
        return r100;
    L22:
        if (r110.getFacing() != VECameraSettings.CAMERA_FACING_ID.FACING_FRONT.ordinal()) goto L24;
        r101 = true;
    L24:
        r100.setFromFrontCamera(r101);
        TECameraFrame.Metadata r111 = r110.getMetadata();
        if (r111 == null) goto L27;
        r100.setMetaData(r111.flatten());
        goto L27
    L9:
        if (r110.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_JPEG) goto L15;
        if (r110.getBufferData() == null) goto L13;
        r100 = VEFrame.createByteArrayFrame(r110.getBufferData(), r110.getSize().width, r110.getSize().height, r110.getRotation(), r110.getTimeStampNS(), VEFrame.ETEPixelFormat.TEPIXEL_FORMAT_JPEG);
        goto L20
    L13:
        ByteBuffer r102 = r110.getPlans().getPlaneBuffer(0);
        r102.rewind();
        byte[] r103 = new byte[r102.remaining()];
        r102.get(r103);
        r100 = VEFrame.createByteArrayFrame(r103, r110.getSize().width, r110.getSize().height, r110.getRotation(), r110.getTimeStampNS(), VEFrame.ETEPixelFormat.TEPIXEL_FORMAT_JPEG);
        goto L20
    L15:
        if (r110.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_NV21) goto L18;
        r100 = VEFrame.createByteArrayFrame(r110.getBufferData(), r110.getSize().width, r110.getSize().height, r110.getRotation(), r110.getTimeStampNS(), VEFrame.ETEPixelFormat.TEPixFmt_NV21);
        goto L20
    L18:
        if (r110.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES) goto L20;
        r100 = VEFrame.createTextureFrame(r110.getTextureID(), r110.getMVPMatrix(), r110.getSize().width, r110.getSize().height, r110.getRotation(), r110.getTimeStampNS(), VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_OES.ordinal());
        goto L20
    }

    public static ImageFrame VEFrame2ImageFrame(VEFrame r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getFormat() != VEFrame.ETEPixelFormat.TEPIXEL_FORMAT_YUV420) goto L9;
        return new ImageFrame(new b(((VEFrame.YUVPlansFrame) r100.getFrame()).getPlanes()), -2, r100.getWidth(), r100.getHeight());
    L9:
        if (r100.getFormat() != VEFrame.ETEPixelFormat.TEPIXEL_FORMAT_JPEG) goto L14;
        if ((r100.getFrame() instanceof VEFrame.ByteArrayFrame) == true) goto L21;
        return null;
    L21:
        return new ImageFrame(((VEFrame.ByteArrayFrame) r100.getFrame()).getByteArray(), 1, r100.getWidth(), r100.getHeight());
    L14:
        if (r100.getFormat() == VEFrame.ETEPixelFormat.TEPixFmt_NV21) goto L16;
        return null;
    L16:
        if ((r100.getFrame() instanceof VEFrame.ByteArrayFrame) == true) goto L18;
        return null;
    L18:
        return new ImageFrame(((VEFrame.ByteArrayFrame) r100.getFrame()).getByteArray(), -3, r100.getWidth(), r100.getHeight());
    }
}
