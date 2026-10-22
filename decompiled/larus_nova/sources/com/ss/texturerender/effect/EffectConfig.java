package com.ss.texturerender.effect;

import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class EffectConfig {
    public static boolean sEnableEGLCheckSupportGL3V;
    public static boolean sTRUseVBO;
    private final String LOG_TAG;
    private int mEGLBitDepth;
    private ConcurrentHashMap<Integer, Integer> mEffectOpenMap;
    private int mTexType;
    private boolean openSR;
    private boolean openSharpen;
    private boolean openTile;

    public EffectConfig() {
        this(-1);
    }

    public boolean hasFboEffect() {
        Iterator<Map.Entry<Integer, Integer>> r100 = this.mEffectOpenMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Map.Entry<Integer, Integer> r101 = r100.next();
        if (r101.getKey().intValue() == 1) goto L4;
        if (r101.getKey().intValue() == 5) goto L4;
        return true;
    L10:
        return false;
    }

    public void reset() {
        this.mEffectOpenMap.clear();
        this.openSR = false;
        this.openSharpen = false;
    }

    public String toString() {
        return this.LOG_TAG + "[opengSR:" + this.openSR + " opengSharpen:" + this.openSharpen + " config:" + this.mEffectOpenMap.toString() + "]";
    }

    public int getEGLBitDepth() {
        return this.mEGLBitDepth;
    }

    public ConcurrentHashMap<Integer, Integer> getEffectConfigMap() {
        return this.mEffectOpenMap;
    }

    public boolean isOpenSR() {
        return this.openSR;
    }

    public boolean isOpenSharpen() {
        return this.openSharpen;
    }

    public boolean isOpenTile() {
        return this.openTile;
    }

    public int texType() {
        return this.mTexType;
    }

    public EffectConfig(int r100) {
        this.openSR = false;
        this.openSharpen = false;
        this.openTile = false;
        this.mEffectOpenMap = new ConcurrentHashMap();
        this.mTexType = -1;
        this.mEGLBitDepth = 8;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
    }

    public boolean getEffectOpen(int r100) {
        Integer r101 = this.mEffectOpenMap.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isSubSet(EffectConfig r100) {
        TextureRenderManager r101 = TextureRenderManager.getManager();
        if (r101 != null) goto L5;
        boolean r102 = false;
        boolean r103 = false;
    L17:
        if (r100.getEffectOpen(21) == false) goto L19;
        return false;
    L19:
        boolean r104 = r100.getEffectOpen(8);
        boolean r105 = getEffectOpen(8);
        if (r102 == true) goto L22;
    L23:
        if (r103 == false) goto L27;
    L24:
        if (r105 == true) goto L26;
        if (r104 == false) goto L27;
    L26:
        return false;
    L27:
        if (r103 == false) goto L32;
        if (r104 != r105) goto L32;
        if (r104 == true) goto L32;
        return true;
    L32:
        if (r100.openSR == false) goto L37;
        if (this.openSR == true) goto L37;
        return false;
    L37:
        if (r100.openSharpen == false) goto L42;
        if (this.openSharpen == true) goto L42;
        return false;
    L42:
        if (r100.getEffectOpen(14) == false) goto L47;
        if (getEffectOpen(14) == true) goto L47;
        return false;
    L47:
        if (r100.getEffectOpen(16) == false) goto L52;
        if (getEffectOpen(16) == true) goto L52;
        return false;
    L52:
        if (r100.openSharpen == false) goto L54;
    L68:
        return true;
    L54:
        if (r100.openSR == true) goto L68;
        if (r100.getEffectOpen(14) == true) goto L68;
        if (r100.getEffectOpen(16) == true) goto L68;
        if (this.openSR == false) goto L62;
    L67:
        return false;
    L62:
        if (this.openSharpen == true) goto L67;
        if (getEffectOpen(14) == true) goto L67;
        if (getEffectOpen(16) == false) goto L68;
    L22:
        if (this.mTexType == 0) goto L24;
    L5:
        if (this.mTexType != 0) goto L9;
        if (r101.getEnableBmfOrLensAsyncInit() == false) goto L9;
    L12:
        r103 = true;
    L14:
        r102 = r101.isAsyncRelaseSurfaceTexture();
    L9:
        if (this.mTexType == 1) goto L11;
    L13:
        r103 = false;
        goto L14
    L11:
        if (r101.getEnableLiveBmfOrLensAsyncInit() == false) goto L13;
        goto L12
    }

    public void setEGLBitDepth(int r100) {
        this.mEGLBitDepth = r100;
    }

    public EffectConfig setOpenSR(boolean r100) {
        this.openSR = r100;
        this.mEffectOpenMap.put(5, Integer.valueOf(r100 ? 1 : 0));
        return this;
    }

    public EffectConfig setOpenSharpen(boolean r100) {
        this.openSharpen = r100;
        this.mEffectOpenMap.put(1, Integer.valueOf(r100 ? 1 : 0));
        return this;
    }

    public EffectConfig setOpenTile(boolean r100) {
        this.openTile = r100;
        return this;
    }

    public void setTexType(int r100) {
        this.mTexType = r100;
    }

    public EffectConfig setEffectOpen(int r100, int r101) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setEffectOpen effect:" + r100 + ",isOpen:" + r101);
        boolean r102 = false;
        if (r100 != 1) goto L9;
        if (r101 != 1) goto L6;
        boolean r103 = true;
    L7:
        this.openSharpen = r103;
        goto L9
    L6:
        r103 = false;
    L9:
        if (r100 != 5) goto L13;
        if (r101 != 1) goto L12;
        r102 = true;
    L12:
        this.openSR = r102;
    L13:
        this.mEffectOpenMap.put(Integer.valueOf(r100), Integer.valueOf(r101));
        return this;
    }
}
