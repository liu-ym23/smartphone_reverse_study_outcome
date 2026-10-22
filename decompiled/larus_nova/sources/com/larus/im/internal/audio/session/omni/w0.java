package com.larus.im.internal.audio.session.omni;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larus.im.internal.jni.bean.OMNIAVVideoFrameBufferType;
import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f347392a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347393a = null;

        static {
            int[] r100 = new int[VideoFrameBufferType.values().length];
            r100[VideoFrameBufferType.GL_TEXTURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VideoFrameBufferType.GL_TEXTURE_OES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f347393a = r100;
        }
    }

    static {
        f347392a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static final OmniAVVideoFrameData a(tf9.b r210, String r211, String r212, int r213) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "tag");
        Intrinsics.checkNotNullParameter(r212, com.alipay.sdk.m.p.e.f25671s);
        int r100 = 0;
        float[] r101 = null;
        if (r210.f545780d > 0) goto L5;
    L20:
        String r102 = "invalid size=" + r210.f545780d + Permission.EXECUTE + r210.f545781e;
    L21:
        if (r102 == null) goto L24;
        fe9.a.f476620a.f(r211, r212 + " ignored, " + r102 + ", rotation=" + r210.f545782f + ", timeUs=" + r210.f545783g + ", isFirstFrame=" + r210.f545784h);
        return null;
    L24:
        float[] r103 = r210.f545779c;
        if (r103 != null) goto L27;
    L35:
        fe9.a r104 = fe9.a.f476620a;
        StringBuilder r105 = new StringBuilder();
        r105.append(r212);
        r105.append(" uses identity texture matrix, matrixSize=");
        float[] r106 = r210.f545779c;
        if (r106 == null) goto L38;
        r100 = r106.length;
    L38:
        r105.append(r100);
        r105.append(", textureId=");
        r105.append(r210.f545778b);
        r104.f(r211, r105.toString());
        float[] r107 = Arrays.copyOf(f347392a, 16);
    L39:
        float[] r214 = r107;
        int r108 = r210.f545778b;
        int r109 = r210.f545780d;
        int r110 = r210.f545781e;
        int r111 = r210.f545782f;
        long r112 = r210.f545783g;
        int r113 = a.f347393a[r210.f545785i.ordinal()];
        if (r113 != 1) goto L42;
        int r114 = OMNIAVVideoFrameBufferType.GlTexture.getValue();
    L48:
        return new OmniAVVideoFrameData(r109, r110, r111, r112, r114, r213, 0, r210.f545784h, 0, null, r108, r214, r210.f545777a, false, 9024, null);
    L42:
        if (r113 != 2) goto L45;
        r114 = OMNIAVVideoFrameBufferType.GLTextureOES.getValue();
        goto L48
    L45:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r103.length < 16) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == false) goto L32;
        r101 = r103;
    L32:
        if (r101 == null) goto L35;
        r107 = Arrays.copyOf(r101, 16);
        if (r107 != null) goto L39;
    L29:
        r115 = false;
        goto L30
    L5:
        if (r210.f545781e <= 0) goto L20;
        if (r210.f545778b > 0) goto L10;
        r102 = "invalid textureId=" + r210.f545778b;
        goto L21
    L10:
        EGLContext r116 = r210.f545777a;
        if (r116 != null) goto L13;
    L16:
        boolean r117 = true;
    L17:
        if (r117 == false) goto L19;
        r102 = "eglContext is null";
        goto L21
    L19:
        r102 = null;
        goto L21
    L13:
        if (Intrinsics.areEqual(r116, EGL14.EGL_NO_CONTEXT) == true) goto L16;
        r117 = false;
        goto L17
    }
}
