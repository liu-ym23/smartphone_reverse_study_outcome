package com.ss.texturerender;

import android.content.Context;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Surface;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.modeldownload.ModelDownloadInfo;
import com.ss.texturerender.modeldownload.ModelDownloadTaskEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class TextureRenderManager {
    public static final int TEX_EXT = 2;
    public static final int TEX_LIVE = 1;
    public static final int TEX_OVERLAY = 4;
    public static final int TEX_PICOVR = 8;
    public static final int TEX_VOD = 0;
    private static TextureRenderManager mManager;
    private final String TAG;
    private boolean mAsyncRelaseSurfaceTexture;
    private Context mContext;
    private boolean mEnableBmfOrLensAsyncInit;
    private boolean mEnableLiveBmfOrLensAsyncInit;
    private boolean mEnableSetTRThreadPriority;
    private ReentrantLock mListLock;
    private int mLiveTRThreadPriority;
    private Map<ModelDownloadTaskEnum, ModelDownloadInfo> mModelDownloadTaskMap;
    private List<TextureRenderer> mRenderers;
    private ReadWriteLock mRwLock;
    private int mTRThreadPriority;
    private String mTextureError;
    private int mUpdateSurfaceWaitTimeOut;

    public synchronized void release() {
        monitor-enter(this);
        releaseRenderers();     // Catch: Throwable -> L6
        mManager = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static synchronized TextureRenderManager getManager() {
        monitor-enter(TextureRenderManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mManager != null) goto L7;
        mManager = new TextureRenderManager();     // Catch: Throwable -> L10
    L7:
        TextureRenderManager r100 = mManager;     // Catch: Throwable -> L10
        monitor-exit(TextureRenderManager.class);
        return r100;
    }

    private void releaseRenderers() {
        if (this.mRenderers.size() != 0) goto L5;
        return;
    L5:
        this.mListLock.lock();
        Iterator<TextureRenderer> r100 = this.mRenderers.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        TextureRenderer r101 = r100.next();
        int r102 = r101.texType();
        TextureRenderLog.i(r102, this.TAG, "render = " + r101 + ", call release");
        r101.release();
        r100.remove();
        TextureRenderLog.i(r102, this.TAG, "release : remove render =" + r101 + "size = " + this.mRenderers.size());
        goto L7
    L9:
        this.mListLock.unlock();
    }

    public void releaseAllEffectNodes() {
        if (this.mRenderers.size() != 0) goto L5;
        return;
    L5:
        this.mListLock.lock();
        Iterator<TextureRenderer> r100 = this.mRenderers.iterator();
        Bundle r101 = new Bundle();
        r101.putInt("action", 32);
        r101.putInt("effect_type", 32);
        TextureRenderer r102 = null;
    L7:
        if (r100.hasNext() == false) goto L9;
        r102 = r100.next();
        TextureRenderLog.i(r102.texType(), this.TAG, "render = " + r102 + ", call release nodes");
        r102.sendMessage(36, r101);
        goto L7
    L9:
        TextureRenderLog.i(-1, this.TAG, "releaseAllEffectNodes end," + r102 + "size = " + this.mRenderers.size());
        this.mListLock.unlock();
    }

    private TextureRenderManager() {
        this.mAsyncRelaseSurfaceTexture = false;
        this.mEnableSetTRThreadPriority = false;
        this.mTRThreadPriority = 0;
        this.mUpdateSurfaceWaitTimeOut = 100;
        this.mEnableBmfOrLensAsyncInit = false;
        this.mEnableLiveBmfOrLensAsyncInit = false;
        this.mLiveTRThreadPriority = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.mRenderers = new ArrayList();
        this.mListLock = new ReentrantLock();
        this.mRwLock = new ReentrantReadWriteLock();
        this.mModelDownloadTaskMap = new HashMap();
        this.mTextureError = null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean getEnableBmfOrLensAsyncInit() {
        return this.mEnableBmfOrLensAsyncInit;
    }

    public boolean getEnableLiveBmfOrLensAsyncInit() {
        return this.mEnableLiveBmfOrLensAsyncInit;
    }

    public boolean getEnableSetTRThreadPriority() {
        return this.mEnableSetTRThreadPriority;
    }

    public int getLiveTRThreadPriority() {
        return this.mLiveTRThreadPriority;
    }

    public String getTextureError() {
        return this.mTextureError;
    }

    public int getTrThreadPriority() {
        return this.mTRThreadPriority;
    }

    public int getUpdateSurfaceWaitTimeOut() {
        return this.mUpdateSurfaceWaitTimeOut;
    }

    public boolean isAsyncRelaseSurfaceTexture() {
        return this.mAsyncRelaseSurfaceTexture;
    }

    public ModelDownloadInfo getModelDownloadInfo(ModelDownloadTaskEnum r100) {
        this.mRwLock.readLock().lock();
        ModelDownloadInfo r101 = null;
        Map<ModelDownloadTaskEnum, ModelDownloadInfo> r102 = this.mModelDownloadTaskMap;     // Catch: Throwable -> L10
        if (r102 != null) goto L6;
    L9:
        this.mRwLock.readLock().unlock();
        return r101;
    L6:
        if (r102.containsKey(r100) == false) goto L9;
        r101 = this.mModelDownloadTaskMap.get(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        TextureRenderLog.d(-1, this.TAG, "getModelDownloadInfo error: " + th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mRwLock.readLock().unlock();
        throw th;
    }

    public synchronized boolean isSRRenderAvaiable(int r100) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        boolean r101 = false;
        if (this.mRenderers.size() != 0) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.mListLock.lock();     // Catch: Throwable -> L21
        Iterator<TextureRenderer> r102 = this.mRenderers.iterator();     // Catch: Throwable -> L21
    L10:
        if (r102.hasNext() == false) goto L18;
        TextureRenderer r103 = r102.next();     // Catch: Throwable -> L21
        if (r103.getEffectConfig().isOpenSR() == false) goto L10;
        if (r103.texType() != r100) goto L10;
        if ((r103.texType() & 4) != 0) goto L10;
        r101 = true;
    L18:
        this.mListLock.unlock();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r101;
    }

    public void setAsyncRelaseSurfaceTexture(boolean r100) {
        this.mAsyncRelaseSurfaceTexture = r100;
    }

    public void setContext(Context r100) {
        if (r100 == null) goto L5;
        this.mContext = r100.getApplicationContext();
        return;
    }

    public void setEnableBmfOrLensAsyncInit(boolean r100) {
        this.mEnableBmfOrLensAsyncInit = r100;
    }

    public void setEnableLiveBmfOrLensAsyncInit(boolean r100) {
        this.mEnableLiveBmfOrLensAsyncInit = r100;
    }

    public void setEnableSetTRThreadPriority(boolean r100) {
        this.mEnableSetTRThreadPriority = r100;
    }

    public void setLiveTRThreadPriority(int r100) {
        this.mLiveTRThreadPriority = r100;
    }

    public void setTrThreadPriority(int r100) {
        this.mTRThreadPriority = r100;
    }

    public void setUpdateSurfaceWaitTimeOut(int r100) {
        this.mUpdateSurfaceWaitTimeOut = r100;
    }

    public void setVRDeviceType(int r100) {
        DeviceManager.setDeviceType(r100);
    }

    private VideoSurface genRenderSurface(EffectConfig r100, int r101) {
        return genRenderSurface(r100, r101, null, null, false);
    }

    public boolean clearSurface(Surface r100, boolean r101) {
        return clearSurface(r100, r101, null, null);
    }

    public synchronized VideoSurface genAvaiableSurface(boolean r100, int r101) {
        monitor-enter(this);
        EffectConfig r102 = new EffectConfig(r101);     // Catch: Throwable -> L6
        r102.setOpenSR(r100);     // Catch: Throwable -> L6
        VideoSurface r103 = genAvaiableSurface(r102, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r103;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isEffectAvailable(EffectConfig r100, int r101) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        boolean r102 = false;
        if (this.mRenderers.size() != 0) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.mListLock.lock();     // Catch: Throwable -> L21
        Iterator<TextureRenderer> r103 = this.mRenderers.iterator();     // Catch: Throwable -> L21
    L10:
        if (r103.hasNext() == false) goto L18;
        TextureRenderer r104 = r103.next();     // Catch: Throwable -> L21
        if (r104.getEffectConfig().isSubSet(r100) == false) goto L10;
        if (r104.texType() != r101) goto L10;
        if ((r104.texType() & 4) != 0) goto L10;
        r102 = true;
    L18:
        this.mListLock.unlock();     // Catch: Throwable -> L21
        monitor-exit(this);
        return r102;
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig r100, int r101) {
        monitor-enter(this);
        VideoSurface r102 = genAvaiableSurface(r100, r101, null, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig r100, int r101, boolean r102) {
        monitor-enter(this);
        VideoSurface r103 = genAvaiableSurface(r100, r101, null, null, r102);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    private VideoSurface genRenderSurface(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110) {
        return genRenderSurface(r100, r101, null, null, false);
    }

    private TextureRenderer getRenderer(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110) {
        this.mListLock.lock();
        Iterator<TextureRenderer> r103 = this.mRenderers.iterator();
    L3:
        TextureRenderer r104 = null;
        if (r103.hasNext() == false) goto L10;
        TextureRenderer r105 = r103.next();
        if (r105.texType() != r101) goto L3;
        if (r105.getState() >= 1) goto L11;
        TextureRenderLog.i(r105.texType(), this.TAG, "remove render =" + r105 + " state = " + r105.getState());
        r105.release();
        r103.remove();
    L11:
        if (r105 != null) goto L16;
        TextureRenderer r106 = RenderFactory.createRender(r100, r101, r102, r110, false);
        if (r106.getState() == (-1)) goto L15;
        this.mRenderers.add(r106);
        TextureRenderLog.i(r106.texType(), this.TAG, "add render = " + r106 + ", effectconfig= " + r100 + ", texType =" + r101 + ",size = " + this.mRenderers.size());
        r104 = r106;
    L17:
        this.mListLock.unlock();
        return r104;
    L15:
        this.mTextureError = r106.getErrorReason();
        r106.release();
        goto L17
    L16:
        r104 = r105;
        goto L17
    L10:
        r105 = null;
        goto L11
    }

    public boolean clearSurface(Surface r100, boolean r101, EGLContext r102, EGLConfig r103) {
        if (r100 != null) goto L6;
        TextureRenderLog.e(-1, this.TAG, "invalid parameter");
        return false;
    L6:
        TextureRenderer r104 = getRenderer(new EffectConfig(2), 2, r102, r103);
        if (r104 != null) goto L11;
        TextureRenderLog.e(-1, this.TAG, "couldn't get a renderer return");
        return false;
    L11:
        return r104.clearSurface(r100, r101);
    }

    public synchronized VideoSurface genAvaiableSurface(boolean r100, int r101, EGLContext r102, EGLConfig r103) {
        monitor-enter(this);
        EffectConfig r104 = new EffectConfig(r101);     // Catch: Throwable -> L6
        r104.setOpenSR(r100);     // Catch: Throwable -> L6
        VideoSurface r105 = genAvaiableSurface(r104, r101, r102, r103);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r105;
    L6:
        th = move-exception;
        throw th;
    }

    public void setModelDownloadInfo(ModelDownloadTaskEnum r100, int r101, float r102, int r103) {
        this.mRwLock.writeLock().lock();
    L7:
        th = move-exception;
        TextureRenderLog.d(-1, this.TAG, "setModelDownloadInfo error: " + th);     // Catch: Throwable -> L11
    L6:
        this.mRwLock.writeLock().unlock();
        return;
    L11:
        th = move-exception;
        this.mRwLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mModelDownloadTaskMap == null) goto L6;
        this.mModelDownloadTaskMap.put(r100, new ModelDownloadInfo(r101, r102, r103));     // Catch: Throwable -> L7
        goto L6
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110) {
        monitor-enter(this);
        VideoSurface r103 = genAvaiableSurface(r100, r101, null, null, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    private VideoSurface genRenderSurface(EffectConfig r100, int r101, EGLContext r102, EGLConfig r103, boolean r104) {
        TextureRenderer r105 = RenderFactory.createRender(r100, r101, r102, r103, r104);
        TextureRenderLog.i(r105.texType(), this.TAG, "new TextureRenderer use:" + r105);
        if (r105.getState() == (-1)) goto L9;
        VideoSurface r106 = r105.genOffscreenSurface();
        if (r106 != null) goto L8;
        this.mTextureError = r105.getErrorReason();
        r105.release();
        return null;
    L8:
        this.mListLock.lock();
        this.mRenderers.add(r105);
        TextureRenderLog.i(r105.texType(), this.TAG, "add render = " + r105 + ", effectconfig= " + r100 + ", texType =" + r101 + ",size = " + this.mRenderers.size());
        this.mListLock.unlock();
        return r106;
    L9:
        this.mTextureError = r105.getErrorReason();
        r105.release();
        return null;
    }

    public synchronized void asyncInitSR(int r100, int r101, String r102, String r103, String r104) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (isSRRenderAvaiable(r100) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        VideoSurface r105 = genAvaiableSurface(true, r100);     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r105.setSuperResolutionInitConfig(r101, r102, r103, r104);     // Catch: Throwable -> L13
        r105.release();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public synchronized VideoSurface genAvaiableSurface(EffectConfig r110, int r111, EGLContext r112, EGLConfig r113, boolean r114) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.mRenderers.size() != 0) goto L8;
        VideoSurface r115 = genRenderSurface(r110, r111, r112, r113, r114);     // Catch: Throwable -> L36
        monitor-exit(this);
        return r115;
    L8:
        this.mListLock.lock();     // Catch: Throwable -> L36
        Iterator<TextureRenderer> r100 = this.mRenderers.iterator();     // Catch: Throwable -> L36
        VideoSurface r101 = null;
    L10:
        if (r100.hasNext() == false) goto L29;
        TextureRenderer r102 = r100.next();     // Catch: Throwable -> L36
        EffectConfig r103 = r102.getEffectConfig();     // Catch: Throwable -> L36
        TextureRenderLog.i(r102.texType(), this.TAG, "tmpConfig: " + r103 + ", config: " + r110);     // Catch: Throwable -> L36
        if (r103.isSubSet(r110) == false) goto L13;
        if (r102.texType() != r111) goto L16;
        if ((r111 & 4) != (r102.texType() & 4)) goto L10;
        TextureRenderLog.i(r102.texType(), this.TAG, "TextureRenderer use:" + r102);     // Catch: Throwable -> L36
        r101 = r102.genOffscreenSurface();     // Catch: Throwable -> L36
        if (r101 != null) goto L25;
        if (r102.getState() >= 1) goto L25;
        TextureRenderLog.i(r102.texType(), this.TAG, "remove render =" + r102 + " state = " + r102.getState());     // Catch: Throwable -> L36
        r102.release();     // Catch: Throwable -> L36
        r100.remove();     // Catch: Throwable -> L36
    L25:
        if (r101 == null) goto L10;
        this.mListLock.unlock();     // Catch: Throwable -> L36
        monitor-exit(this);
        return r101;
    L16:
        TextureRenderLog.i(r102.texType(), this.TAG, "tex type is mis match = " + r102.texType() + ", " + r111);     // Catch: Throwable -> L36
        goto L10
    L13:
        TextureRenderLog.i(r102.texType(), this.TAG, "render type is mis match = " + r103 + ", " + r110);     // Catch: Throwable -> L36
        goto L10
    L29:
        this.mListLock.unlock();     // Catch: Throwable -> L36
        if (r101 != null) goto L34;
        VideoSurface r116 = genRenderSurface(r110, r111, r112, r113, r114);     // Catch: Throwable -> L36
        monitor-exit(this);
        return r116;
    L34:
        monitor-exit(this);
        return null;
    }

    public synchronized void asyncInitSR(int r110, int r111, String r112, String r113, String r114, int r115, int r116) {
        monitor-enter(this);
        asyncInitSR(r110, r111, r112, r113, r114, r115, r116, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void asyncInitSR(int r110, int r111, String r112, String r113, String r114, int r115, int r116, String r117) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isSRRenderAvaiable(r110) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        VideoSurface r100 = genAvaiableSurface(true, r110);     // Catch: Throwable -> L14
        if (r100 == null) goto L12;
        r100.setSuperResolutionInitConfig(r111, r112, r113, r114, r115, r116, r117);     // Catch: Throwable -> L14
        r100.release();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }
}
