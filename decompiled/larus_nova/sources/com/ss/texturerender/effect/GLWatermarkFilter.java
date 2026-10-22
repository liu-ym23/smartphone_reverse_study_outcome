package com.ss.texturerender.effect;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class GLWatermarkFilter extends GLDefaultFilter {
    private final String fragmentDefaultShader;
    private Bitmap mBitmap;
    private EffectTexture mTexture;
    private int mVideoStyle;
    private int mVideoStyleLoc;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        GLES20.glDisable(3042);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        GLES20.glUniform1i(this.mVideoStyleLoc, this.mVideoStyle);
        Bitmap r100 = this.mBitmap;
        if (r100 == null) goto L5;
        GLUtils.texImage2D(3553, 0, r100, 0);
    L5:
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        EffectTexture r100 = this.mTexture;
        if (r100 == null) goto L6;
        TexGLUtils.deleteTexture(r100.getTexID());
    L6:
        return super.release();
    }

    public GLWatermarkFilter(int r100) {
        super(r100, 17);
        this.fragmentDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int videoStyle;\nvoid main() {\n  vec2 uv = vTextureCoord;\n  if(videoStyle == 3) {\n    if (uv.y <= 0.5) {\n      uv.y = uv.y * 2.0;\n    } else {\n      uv.y = (uv.y - 0.5) * 2.0;\n    }\n  } else if(videoStyle == 4) {\n    if (uv.x <= 0.5) {\n      uv.x = uv.x * 2.0;\n    } else {\n      uv.x = (uv.x - 0.5) * 2.0;\n    }\n  }\n  gl_FragColor = texture2D(sTexture, uv);\n}\n";
        this.mVideoStyle = 2;
        this.mVideoStyleLoc = -1;
        this.mOrder = 8;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "new GLWatermarkFilter");
    }

    private void getFlipBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L9;
        Matrix r101 = new Matrix();
        r101.postScale(1.0f, -1.0f);
        this.mBitmap = Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r101, true);
        r100.recycle();
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int videoStyle;\nvoid main() {\n  vec2 uv = vTextureCoord;\n  if(videoStyle == 3) {\n    if (uv.y <= 0.5) {\n      uv.y = uv.y * 2.0;\n    } else {\n      uv.y = (uv.y - 0.5) * 2.0;\n    }\n  } else if(videoStyle == 4) {\n    if (uv.x <= 0.5) {\n      uv.x = uv.x * 2.0;\n    } else {\n      uv.x = (uv.x - 0.5) * 2.0;\n    }\n  }\n  gl_FragColor = texture2D(sTexture, uv);\n}\n";
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (super.init(r100) == 0) goto L6;
        return -1;
    L6:
        this.mVideoStyleLoc = GLES20.glGetUniformLocation(this.mProgram, "videoStyle");
        this.mVideoStyle = r100.getInt(TextureRenderKeys.KEY_IS_VIDEO_STYLE, 2);
        if (r100.containsKey(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP) == false) goto L11;
        Bitmap r101 = (Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP);
        if (r101 == null) goto L11;
        getFlipBitmap(r101);
    L11:
        this.mNeedClear = false;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "GLWatermarkFilter init");
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
    L12:
        super.setOption(r100);
        return;
    L4:
        if (this.mEffectType != r100.getInt("effect_type")) goto L12;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "setOption:" + r100);
        if (r100.getInt("action") != 22) goto L15;
        Bitmap r101 = this.mBitmap;
        if (r101 == null) goto L11;
        r101.recycle();
    L11:
        getFlipBitmap((Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP));
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r110) {
        if (r110 == null) goto L5;
        if (r100 == null) goto L5;
        r110.bindTexture2D(r100.getTexID());
    L5:
        this.mViewPortWidth = r100.getWidth();
        this.mViewPortHeight = r100.getHeight();
        if (this.mTexture != null) goto L8;
        this.mTexture = new EffectTexture(null, TexGLUtils.genTexture(3553), 0, 0, 3553, r100.getRect());
    L8:
        super.process(this.mTexture, null);
        Bitmap r101 = this.mBitmap;
        if (r101 == null) goto L11;
        r101.recycle();
        this.mBitmap = null;
    L11:
        if (r110 == null) goto L13;
        r110.unbindTexture2D();
    L13:
        return r100;
    }
}
