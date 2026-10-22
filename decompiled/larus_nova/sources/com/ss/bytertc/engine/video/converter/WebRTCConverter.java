package com.ss.bytertc.engine.video.converter;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.TextureBufferImpl;
import com.bytedance.realx.video.VideoFrame;
import com.bytedance.realx.video.YuvConverter;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.utils.ByteBufferUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoFrame;
import java.nio.ByteBuffer;
import vjc.a;

/* JADX INFO: loaded from: classes40.dex */
public class WebRTCConverter {
    private static final String TAG = null;

    public WebRTCConverter() {
    }

    static {
        TAG = "WebRTCConverter";
    }

    public static VideoFrame convertByteI420Frame2WebrtcI420Frame(IVideoFrame r110) {
        if (r110.bufferType() == VideoBufferType.RAW_MEMORY) goto L6;
        return null;
    L6:
        if (r110.pixelFormat() == VideoPixelFormat.I420) goto L8;
        return null;
    L8:
        r110.addRef();
        int r100 = r110.width();
        int r101 = r110.height();
        ByteBuffer r102 = r110.planeData(0);
        ByteBuffer r103 = r110.planeData(1);
        ByteBuffer r104 = r110.planeData(2);
        return new VideoFrame(JavaI420Buffer.wrap(r100, r101, r102, r110.planeStride(0), r103, r110.planeStride(1), r104, r110.planeStride(2), new a(r110)), r110.rotation().value(), r110.timestampUs());
    L11:
        e = move-exception;
        r110.releaseRef();
        LogUtil.e(TAG, "Frame convert failed: " + e.getMessage());
        return null;
    }

    public static VideoFrame convertByteRGBAFrame2WebrtcI420Frame(IVideoFrame r110) {
        if (r110.bufferType() == VideoBufferType.RAW_MEMORY) goto L5;
    L12:
        return null;
    L5:
        if (r110.pixelFormat() != VideoPixelFormat.RGBA) goto L12;
        int r100 = r110.width();
        int r101 = r110.height();
        int r102 = r110.planeStride(0);
        int r111 = ((r100 + 63) / 64) * 64;
        int r112 = (((r100 >> 1) + 63) / 64) * 64;
        ByteBuffer r103 = r110.planeData(0);
        if (r103 != null) goto L10;
        return null;
    L10:
        ByteBuffer r104 = ByteBuffer.allocateDirect(r111 * r101);
        int r105 = ((r101 + 1) >> 1) * r112;
        ByteBuffer r113 = ByteBuffer.allocateDirect(r105);
        ByteBuffer r114 = ByteBuffer.allocateDirect(r105);
        ByteBufferUtils.nativeRGBAToI420(r103, r102, r104, r111, r113, r112, r114, r112, r100, r101);
        return new VideoFrame(JavaI420Buffer.wrap(r100, r101, r104, r111, r113, r112, r114, r112, new a(r110)), r110.rotation().value(), r110.timestampUs());
    }

    public static VideoFrame convertByteTexFrame2WebrtcTexFrame(IVideoFrame r110, Looper r111) {
        if (r110.bufferType() == VideoBufferType.GL_TEXTURE) goto L5;
        return null;
    L5:
        if (r111 != null) goto L7;
        return null;
    L7:
        Matrix r100 = RendererCommon.convertMatrixToAndroidGraphicsMatrix(r110.textureMatrix());
        if (r110.pixelFormat() != VideoPixelFormat.TEXTURE_2D) goto L10;
        VideoFrame.TextureBuffer.Type r101 = VideoFrame.TextureBuffer.Type.RGB;
    L11:
        r110.addRef();
        int r102 = r110.width();
        int r103 = r110.height();
        return new VideoFrame(new TextureBufferImpl(r102, r103, r101, r110.textureId(), r100, new Handler(r111), new YuvConverter(), new a(r110)), r110.rotation().value(), r110.timestampUs());
    L10:
        r101 = VideoFrame.TextureBuffer.Type.OES;
        goto L11
    }
}
