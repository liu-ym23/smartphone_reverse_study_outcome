package com.ss.texturerender.effect;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class GLLutFilter extends GLDefaultFilter {
    private final String fragmentShader;
    private int mCurrentIndex;
    private int mLutTextureHandle;
    private HashMap<Integer, LutTextureNode> mLutTextureMap;
    private int mStrengthHandle;

    public class LutTextureNode {
        public float strength;
        public int texID;
        final /* synthetic */ GLLutFilter this$0;
        public boolean using;

        public String toString() {
            return "[texID:" + this.texID + ",strength:" + this.strength + ",using:" + this.using + "]";
        }

        public LutTextureNode(GLLutFilter r100, int r101, float r102, boolean r103) {
            this.this$0 = r100;
            this.texID = r101;
            this.using = r103;
            this.strength = r102;
        }
    }

    private void disableAllTextureNode() {
        Iterator<LutTextureNode> r100 = this.mLutTextureMap.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().using = false;
        goto L4
    }

    private void removeExtraTextureNode() {
        Iterator<Map.Entry<Integer, LutTextureNode>> r100 = this.mLutTextureMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        LutTextureNode r101 = r100.next().getValue();
        if (r101.using == true) goto L4;
        TexGLUtils.deleteTexture(r101.texID);
        r100.remove();
        goto L4
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        LutTextureNode r100 = this.mLutTextureMap.get(Integer.valueOf(this.mCurrentIndex));
        if (r100 != null) goto L6;
        return -1;
    L6:
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, r100.texID);
        GLES20.glUniform1i(this.mLutTextureHandle, 1);
        GLES20.glUniform1f(this.mStrengthHandle, r100.strength);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        disableAllTextureNode();
        removeExtraTextureNode();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        return super.release();
    }

    public GLLutFilter(int r100) {
        super(r100, 2);
        this.fragmentShader = "precision mediump float;\nuniform sampler2D sTexture;\nuniform sampler2D lutTexture;\nvarying vec2 vTextureCoord;\nuniform float strength;\nvoid main() {\n    vec4 inputTexColor = texture2D(sTexture, vTextureCoord);\n    float blueColor = inputTexColor.b * 63.0;\n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 7.999);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    vec2 texturePos1;\n    texturePos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec2 texturePos2;\n    texturePos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec4 newColor1 = texture2D(lutTexture, texturePos1);\n    vec4 newColor2 = texture2D(lutTexture, texturePos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
        this.mLutTextureMap = new HashMap();
        this.mOrder = 15;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLLutFilter");
    }

    private void setAllLutStrength(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 > 1.0f) goto L13;
        Iterator<LutTextureNode> r101 = this.mLutTextureMap.values().iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        r101.next().strength = r100;
        goto L9
    L14:
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return "precision mediump float;\nuniform sampler2D sTexture;\nuniform sampler2D lutTexture;\nvarying vec2 vTextureCoord;\nuniform float strength;\nvoid main() {\n    vec4 inputTexColor = texture2D(sTexture, vTextureCoord);\n    float blueColor = inputTexColor.b * 63.0;\n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 7.999);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    vec2 texturePos1;\n    texturePos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec2 texturePos2;\n    texturePos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec4 newColor1 = texture2D(lutTexture, texturePos1);\n    vec4 newColor2 = texture2D(lutTexture, texturePos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (super.init(r100) == 0) goto L8;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L7;
        r101.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
    L7:
        return -1;
    L8:
        this.mStrengthHandle = GLES20.glGetUniformLocation(this.mProgram, TextureRenderKeys.KEY_IS_STRENGTH_FLOAT);
        this.mLutTextureHandle = GLES20.glGetUniformLocation(this.mProgram, "lutTexture");
        disableAllTextureNode();
        if (r100.containsKey(TextureRenderKeys.KEY_IS_LUT_BITMAP) == false) goto L14;
        if (((Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP)) == null) goto L21;
        addTextureNode(0, (Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP));
    L21:
        removeExtraTextureNode();
        if (r100.containsKey(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT) == false) goto L25;
        setAllLutStrength(r100.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT));
    L32:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init:" + r100 + " LutMap:" + this.mLutTextureMap);
        return 0;
    L25:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_STRENGTH_MULTI_FLOAT) == false) goto L32;
        HashMap r102 = (HashMap) r100.getSerializable(TextureRenderKeys.KEY_IS_STRENGTH_MULTI_FLOAT);
        if (r102 == null) goto L32;
        Iterator r103 = r102.entrySet().iterator();
    L30:
        if (r103.hasNext() == false) goto L32;
        Map.Entry r104 = (Map.Entry) r103.next();
        setLutStrength(((Integer) r104.getKey()).intValue(), ((Float) r104.getValue()).floatValue());
        goto L30
    L14:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_LUT_BITMAP_MULTI) == false) goto L34;
        HashMap r105 = (HashMap) r100.getSerializable(TextureRenderKeys.KEY_IS_LUT_BITMAP_MULTI);
        if (r105 == null) goto L21;
        Iterator r106 = r105.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        Map.Entry r107 = (Map.Entry) r106.next();
        addTextureNode(((Integer) r107.getKey()).intValue(), (Bitmap) r107.getValue());
        goto L19
    L34:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init no bitmap");
        return -1;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
    L25:
        super.setOption(r100);
        return;
    L4:
        if (this.mEffectType != r100.getInt("effect_type")) goto L25;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setOption:" + r100);
        int r101 = r100.getInt("action");
        if (r101 == 20) goto L22;
        if (r101 == 22) goto L11;
        return;
    L11:
        if (this.mLutTextureMap.isEmpty() == false) goto L13;
        return;
    L13:
        Bitmap r102 = (Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP);
        if (r100.containsKey("index") == false) goto L18;
        LutTextureNode r103 = this.mLutTextureMap.get(Integer.valueOf(r100.getInt("index")));
        if (r103 == null) goto L27;
        setBitmap(r103.texID, r102);
        return;
    L27:
        return;
    L18:
        LutTextureNode r104 = this.mLutTextureMap.get(0);
        if (r104 == null) goto L29;
        setBitmap(r104.texID, r102);
        return;
    L29:
        return;
    L22:
        if (r100.containsKey("index") == false) goto L24;
        setLutStrength(r100.getInt("index", 0), r100.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f));
        return;
    L24:
        setAllLutStrength(r100.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f));
    }

    private void addTextureNode(int r100, Bitmap r101) {
        LutTextureNode r102 = this.mLutTextureMap.get(Integer.valueOf(r100));
        if (r102 != null) goto L12;
        Iterator<Map.Entry<Integer, LutTextureNode>> r103 = this.mLutTextureMap.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<Integer, LutTextureNode> r104 = r103.next();
        LutTextureNode r105 = r104.getValue();
        if (r105.using == true) goto L6;
        this.mLutTextureMap.remove(r104.getKey());
        this.mLutTextureMap.put(Integer.valueOf(r100), r105);
        setBitmap(r105.texID, r101);
        return;
    L11:
        LutTextureNode r106 = new LutTextureNode(this, TexGLUtils.genTexture(3553), 1.0f, true);
        setBitmap(r106.texID, r101);
        this.mLutTextureMap.put(Integer.valueOf(r100), r106);
        return;
    L12:
        setBitmap(r102.texID, r101);
        r102.using = true;
    }

    private void setLutStrength(int r100, float r101) {
        if (r101 >= 0.0f) goto L5;
        return;
    L5:
        if (r101 > 1.0f) goto L13;
        LutTextureNode r102 = this.mLutTextureMap.get(Integer.valueOf(r100));
        if (r102 == null) goto L12;
        r102.strength = r101;
        return;
    L12:
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L5;
        r102.currentEffectProcessBegin(this.mEffectType);
    L5:
        int r103 = 0;
    L6:
        this.mCurrentIndex = r103;
        if (this.mCurrentIndex >= this.mLutTextureMap.size()) goto L14;
        LutTextureNode r104 = this.mLutTextureMap.get(Integer.valueOf(this.mCurrentIndex));
        if (r104 == null) goto L13;
        if (r104.strength <= 0.0f) goto L13;
        r100 = super.process(r100, r101);
    L13:
        r103 = this.mCurrentIndex + 1;
        goto L6
    L14:
        VideoSurfaceTexture r105 = this.mSurfaceTexture;
        if (r105 == null) goto L17;
        r105.currentEffectProcessEnd(this.mEffectType);
    L17:
        return r100;
    }

    public void setBitmap(int r100, Bitmap r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isRecycled() == true) goto L9;
        GLES20.glBindTexture(3553, r100);
        GLUtils.texImage2D(3553, 0, r101, 0);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setBitmap:" + r101);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float r101) {
        if (r100 == 20) goto L5;
        super.setOption(r100, r101);
        return;
    L5:
        setAllLutStrength(r101);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set strength:" + r101);
    }
}
