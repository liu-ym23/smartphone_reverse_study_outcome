package com.ss.android.ugc.aweme.live.alphaplayer.mask;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import androidx.camera.core.processing.util.GLUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.utils.ShaderUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class MaskRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f451107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f451108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f451109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f451110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f451111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f451112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f451113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f451114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f451115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f451116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, MaskSrc> f451117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Integer> f451118l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<MaskSrc> f451119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, DataSource.Area> f451120n;

    public final void a() {
        ByteBuffer.allocateDirect(this.f451108b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451108b).position(0);
        ByteBuffer.allocateDirect(this.f451109c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451109c).position(0);
        ByteBuffer.allocateDirect(this.f451110d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.f451110d).position(0);
        int r100 = ShaderUtil.b(ShaderUtil.c("mask/mask_vertex.sh", this.f451107a.getResources()), ShaderUtil.c("mask/mask_frag.sh", this.f451107a.getResources()));
        this.f451111e = r100;
        if (r100 == 0) goto L15;
        this.f451112f = GLES20.glGetAttribLocation(r100, "aPosition");
        ShaderUtil.a();
        if (this.f451112f == (-1)) goto L44;
        this.f451113g = GLES20.glGetAttribLocation(this.f451111e, "aTextureCoord");
        ShaderUtil.a();
        if (this.f451113g == (-1)) goto L42;
        this.f451114h = GLES20.glGetAttribLocation(this.f451111e, "aMaskTextureCoord");
        ShaderUtil.a();
        if (this.f451114h == (-1)) goto L40;
        this.f451115i = GLES20.glGetUniformLocation(this.f451111e, GLUtils.VAR_TEXTURE);
        ShaderUtil.a();
        if (this.f451115i == (-1)) goto L38;
        this.f451116j = GLES20.glGetUniformLocation(this.f451111e, "sMaskTexture");
        ShaderUtil.a();
        if (this.f451116j != (-1)) goto L15;
        throw new RuntimeException("Could not get attrib location for sMaskTexture");
    L38:
        throw new RuntimeException("Could not get attrib location for sTexture");
    L40:
        throw new RuntimeException("Could not get attrib location for aMaskTextureCoord");
    L42:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L44:
        throw new RuntimeException("Could not get attrib location for aPosition");
    L15:
        List<MaskSrc> r101 = this.f451119m;
        if (r101 != null) goto L18;
        return;
    L18:
        if (((ArrayList) r101).isEmpty() == true) goto L48;
        ((HashMap) this.f451118l).clear();
        ((HashMap) this.f451117k).clear();
        int r102 = 0;
    L22:
        if (r102 >= ((ArrayList) this.f451119m).size()) goto L49;
        MaskSrc r103 = (MaskSrc) ListProtector.get(this.f451119m, r102);
        Map<String, MaskSrc> r104 = this.f451117k;
        HashMap r105 = (HashMap) r104;
        r105.put(r103.f451155a, r103);
        Map<String, Integer> r106 = this.f451118l;
        String r107 = r103.f451155a;
        Bitmap r108 = r103.f451161g;
        if (r108 != null) goto L26;
    L32:
        int r109 = 0;
    L33:
        HashMap r110 = (HashMap) r106;
        r110.put(r107, Integer.valueOf(r109));
        r102 = r102 + 1;
        goto L22
    L26:
        if (r108.isRecycled() == true) goto L32;
        int[] r111 = new int[1];
        GLES20.glGenTextures(1, r111, 0);
        int r112 = r111[0];
        if (r112 == 0) goto L32;
        GLES20.glBindTexture(3553, r112);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, 10240, 9729);
        android.opengl.GLUtils.texImage2D(3553, 0, r108, 0);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        r109 = r111[0];
        goto L33
    L49:
        return;
    }

    public MaskRender(Context r100, List<MaskSrc> r101) {
        this.f451108b = new float[8];
        this.f451109c = new float[8];
        this.f451110d = new float[8];
        new DataSource.Area();
        this.f451111e = 0;
        this.f451112f = 0;
        this.f451113g = 0;
        this.f451114h = 0;
        this.f451115i = 0;
        this.f451116j = 0;
        this.f451117k = new HashMap();
        this.f451118l = new HashMap();
        this.f451120n = new HashMap();
        this.f451107a = r100;
        this.f451119m = new ArrayList(r101);
    }
}
