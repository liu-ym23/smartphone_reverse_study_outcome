package com.ss.texturerender.effect;

import android.hardware.HardwareBuffer;
import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.texturerender.TextureRenderLog;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class EffectTexture {
    private final String TAG;
    private float alpha;
    private int drType;
    private EffectTexture[] extraEffectTextures;
    private int format;
    private HardwareBuffer hardwareBuffer;
    private int height;
    private int internalFormat;
    private FilterType mMagFilterType;
    private FilterType mMinFilterType;
    private TextureWrapType mTextureWrapTypes;
    private TextureWrapType mTextureWrapTypet;
    private EffectTextureManager manager;
    private Bundle rect;
    private int sourceType;
    private int texID;
    private int texTarget;
    private int type;
    private TextureUsage usage;
    private int width;

    /* JADX INFO: renamed from: com.ss.texturerender.effect.EffectTexture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$texturerender$effect$EffectTexture$TextureWrapType = null;

        static {
            int[] r100 = new int[TextureWrapType.values().length];
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$TextureWrapType = r100;
            r100[TextureWrapType.WRAP_CLAMP_TO_EDGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L27:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$TextureWrapType[TextureWrapType.WRAP_REPEAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$TextureWrapType[TextureWrapType.WRAP_MIRRORED_REPEAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            int[] r101 = new int[FilterType.values().length];
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType = r101;
            r101[FilterType.LINEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L41:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L25:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.LINEAR_MIPMAP_LINEAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L31:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.LINEAR_MIPMAP_NEAREST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST_MIPMAP_LINEAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L29:
            $SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[FilterType.NEAREST_MIPMAP_NEAREST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
            return;
        }
    }

    public static final enum FilterType extends Enum<FilterType> {
        private static final /* synthetic */ FilterType[] $VALUES = null;
        public static final FilterType LINEAR = null;
        public static final FilterType LINEAR_MIPMAP_LINEAR = null;
        public static final FilterType LINEAR_MIPMAP_NEAREST = null;
        public static final FilterType NEAREST = null;
        public static final FilterType NEAREST_MIPMAP_LINEAR = null;
        public static final FilterType NEAREST_MIPMAP_NEAREST = null;

        static {
            FilterType r100 = new FilterType("LINEAR", 0);
            LINEAR = r100;
            FilterType r101 = new FilterType("NEAREST", 1);
            NEAREST = r101;
            FilterType r102 = new FilterType("LINEAR_MIPMAP_LINEAR", 2);
            LINEAR_MIPMAP_LINEAR = r102;
            FilterType r103 = new FilterType("LINEAR_MIPMAP_NEAREST", 3);
            LINEAR_MIPMAP_NEAREST = r103;
            FilterType r104 = new FilterType("NEAREST_MIPMAP_LINEAR", 4);
            NEAREST_MIPMAP_LINEAR = r104;
            FilterType r105 = new FilterType("NEAREST_MIPMAP_NEAREST", 5);
            NEAREST_MIPMAP_NEAREST = r105;
            $VALUES = new FilterType[]{r100, r101, r102, r103, r104, r105};
        }

        public static FilterType[] values() {
            return (FilterType[]) $VALUES.clone();
        }

        public static FilterType valueOf(String r100) {
            return (FilterType) a.a(FilterType.class, r100);
        }

        private FilterType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TextureType extends Enum<TextureType> {
        private static final /* synthetic */ TextureType[] $VALUES = null;
        public static final TextureType TEXTURE_2D = null;
        public static final TextureType TEXTURE_2D_MULTISAMPLE = null;
        public static final TextureType TEXTURE_OES = null;

        static {
            TextureType r100 = new TextureType("TEXTURE_2D", 0);
            TEXTURE_2D = r100;
            TextureType r101 = new TextureType("TEXTURE_2D_MULTISAMPLE", 1);
            TEXTURE_2D_MULTISAMPLE = r101;
            TextureType r102 = new TextureType("TEXTURE_OES", 2);
            TEXTURE_OES = r102;
            $VALUES = new TextureType[]{r100, r101, r102};
        }

        public static TextureType[] values() {
            return (TextureType[]) $VALUES.clone();
        }

        public static TextureType valueOf(String r100) {
            return (TextureType) a.a(TextureType.class, r100);
        }

        private TextureType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TextureUsage extends Enum<TextureUsage> {
        private static final /* synthetic */ TextureUsage[] $VALUES = null;
        public static final TextureUsage LUT_3D = null;
        public static final TextureUsage NORMAL = null;

        static {
            TextureUsage r100 = new TextureUsage(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            TextureUsage r101 = new TextureUsage("LUT_3D", 1);
            LUT_3D = r101;
            $VALUES = new TextureUsage[]{r100, r101};
        }

        public static TextureUsage[] values() {
            return (TextureUsage[]) $VALUES.clone();
        }

        public static TextureUsage valueOf(String r100) {
            return (TextureUsage) a.a(TextureUsage.class, r100);
        }

        private TextureUsage(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TextureWrapType extends Enum<TextureWrapType> {
        private static final /* synthetic */ TextureWrapType[] $VALUES = null;
        public static final TextureWrapType WRAP_CLAMP_TO_EDGE = null;
        public static final TextureWrapType WRAP_MIRRORED_REPEAT = null;
        public static final TextureWrapType WRAP_REPEAT = null;

        static {
            TextureWrapType r100 = new TextureWrapType("WRAP_CLAMP_TO_EDGE", 0);
            WRAP_CLAMP_TO_EDGE = r100;
            TextureWrapType r101 = new TextureWrapType("WRAP_REPEAT", 1);
            WRAP_REPEAT = r101;
            TextureWrapType r102 = new TextureWrapType("WRAP_MIRRORED_REPEAT", 2);
            WRAP_MIRRORED_REPEAT = r102;
            $VALUES = new TextureWrapType[]{r100, r101, r102};
        }

        public static TextureWrapType[] values() {
            return (TextureWrapType[]) $VALUES.clone();
        }

        public static TextureWrapType valueOf(String r100) {
            return (TextureWrapType) a.a(TextureWrapType.class, r100);
        }

        private TextureWrapType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void giveBack() {
        EffectTextureManager r100 = this.manager;
        if (r100 == null) goto L6;
        r100.onTextureReturn(this);
        return;
    }

    public String toString() {
        return this.TAG + "[manager:" + this.manager + "," + this.texID + "," + this.texTarget + "," + this.width + "," + this.height + "," + this.internalFormat + "," + this.format + "," + this.type + "]";
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getDrType() {
        return this.drType;
    }

    public EffectTexture[] getExtraEffectTexture() {
        return this.extraEffectTextures;
    }

    public int getFormat() {
        return this.format;
    }

    public HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public int getHeight() {
        return this.height;
    }

    public int getInternalFormat() {
        return this.internalFormat;
    }

    public Bundle getRect() {
        return this.rect;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getTexID() {
        return this.texID;
    }

    public int getTexTarget() {
        return this.texTarget;
    }

    public int getType() {
        return this.type;
    }

    public TextureUsage getUsage() {
        return this.usage;
    }

    public int getWidth() {
        return this.width;
    }

    public static int getGLFilerType(FilterType r100) {
        switch(AnonymousClass1.$SwitchMap$com$ss$texturerender$effect$EffectTexture$FilterType[r100.ordinal()]) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 9984;
    L8:
        return 9986;
    L10:
        return 9985;
    L12:
        return 9987;
    L14:
        return 9728;
    L16:
        return 9729;
    }

    public static int getGLWrapperType(TextureWrapType r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$ss$texturerender$effect$EffectTexture$TextureWrapType[r100.ordinal()];
        if (r101 != 2) goto L5;
        return 10497;
    L5:
        if (r101 == 3) goto L8;
        return 33071;
    L8:
        return 33648;
    }

    public boolean isEqualTo(EffectTexture r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.texID != r100.texID) goto L9;
        return true;
    L9:
        return false;
    }

    public void setAlpha(float r100) {
        this.alpha = r100;
    }

    public void setDrType(int r100) {
        this.drType = r100;
    }

    public void setExtraEffectTexture(EffectTexture[] r100) {
        this.extraEffectTextures = r100;
    }

    public void setManager(EffectTextureManager r100) {
        this.manager = r100;
    }

    public void setUsage(TextureUsage r100) {
        this.usage = r100;
    }

    public void switchFilterType(FilterType r100, FilterType r101) {
        if (this.mMinFilterType == r100) goto L5;
    L6:
        this.mMinFilterType = r100;
        this.mMagFilterType = r101;
        GLES20.glBindTexture(this.texTarget, this.texID);
        int r102 = this.texTarget;
        if (r102 == 37120) goto L9;
        GLES20.glTexParameteri(r102, 10241, getGLFilerType(r100));
        GLES20.glTexParameteri(this.texTarget, 10240, getGLFilerType(r101));
    L9:
        GLES20.glBindTexture(this.texTarget, 0);
        return;
    L5:
        if (this.mMagFilterType != r101) goto L6;
    }

    public void switchWrapType(TextureWrapType r100, TextureWrapType r101) {
        if (this.mTextureWrapTypes == r100) goto L5;
    L6:
        this.mTextureWrapTypes = r100;
        this.mTextureWrapTypet = r101;
        GLES20.glBindTexture(this.texTarget, this.texID);
        GLES20.glTexParameteri(this.texTarget, 10242, getGLWrapperType(r100));
        GLES20.glTexParameteri(this.texTarget, 10243, getGLWrapperType(r101));
        GLES20.glBindTexture(this.texTarget, 0);
        return;
    L5:
        if (this.mTextureWrapTypet != r101) goto L6;
    }

    public EffectTexture(EffectTextureManager r100, int r101, int r102, int r103, int r104, Bundle r105) {
        this.usage = TextureUsage.NORMAL;
        this.alpha = 1.0f;
        TextureWrapType r106 = TextureWrapType.WRAP_CLAMP_TO_EDGE;
        this.mTextureWrapTypes = r106;
        this.mTextureWrapTypet = r106;
        this.drType = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.manager = r100;
        this.texID = r101;
        this.width = r102;
        this.height = r103;
        this.texTarget = r104;
        FilterType r107 = FilterType.LINEAR;
        this.mMinFilterType = r107;
        this.mMagFilterType = r107;
        this.mTextureWrapTypes = r106;
        this.mTextureWrapTypet = r106;
        this.extraEffectTextures = null;
        this.sourceType = 1;
        this.rect = r105;
    }

    public EffectTexture(EffectTextureManager r100, HardwareBuffer r101, int r102, int r103, int r104, int r105) {
        this.usage = TextureUsage.NORMAL;
        this.alpha = 1.0f;
        TextureWrapType r106 = TextureWrapType.WRAP_CLAMP_TO_EDGE;
        this.mTextureWrapTypes = r106;
        this.mTextureWrapTypet = r106;
        this.drType = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.hardwareBuffer = r101;
        this.manager = r100;
        this.width = r102;
        this.height = r103;
        this.format = r104;
        this.sourceType = r105;
    }

    public EffectTexture(EffectTextureManager r100, int r101, int r102, int r103, int r104, FilterType r105, FilterType r106, Bundle r110) {
        this.usage = TextureUsage.NORMAL;
        this.alpha = 1.0f;
        TextureWrapType r107 = TextureWrapType.WRAP_CLAMP_TO_EDGE;
        this.mTextureWrapTypes = r107;
        this.mTextureWrapTypet = r107;
        this.drType = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.manager = r100;
        this.texID = r101;
        this.width = r102;
        this.height = r103;
        this.texTarget = r104;
        this.mMinFilterType = r105;
        this.mMagFilterType = r106;
        this.mTextureWrapTypes = r107;
        this.mTextureWrapTypet = r107;
        this.extraEffectTextures = null;
        this.sourceType = 1;
        this.rect = r110;
    }

    public EffectTexture(EffectTextureManager r100, int r110, int r111, int r112, int r113, int r114, int r115, int r116, Bundle r117) {
        this(r100, r110, r111, r112, r113, r117);
        this.internalFormat = r114;
        this.format = r115;
        this.type = r116;
    }
}
