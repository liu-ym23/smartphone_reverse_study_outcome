package com.lynx.tasm.behavior.ui.krypton;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonHelper {
    private static final String TAG = "LynxKryptonHelper";
    private LynxKryptonAudioFrameCallback mAudioDownstreamCallback;
    private LynxKryptonAudioDownstreamMode mAudioDownstreamMode;
    private final c mBehaviorRegistry;
    private final LinkedHashMap<Class<?>, Object> mCachedServiceMap;
    private CanvasRuntimeMediator mRuntimeMediator;
    private String mTemporaryDirectory;

    public void deInit() {
        CanvasRuntimeMediator r100 = this.mRuntimeMediator;
        if (r100 == null) goto L5;
        r100.deInit();
    L5:
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    }

    public ICanvasManager getCanvasManager() {
        CanvasRuntimeMediator r100 = this.mRuntimeMediator;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getCanvasManager();
    }

    public void setupCanvasIfCanvasViewCreated() {
        LLog.i(TAG, "[Krypton] Setup canvas environment if introduce canvas tag in app.");
        CanvasRuntimeMediator r100 = this.mRuntimeMediator;
        if (r100 == null) goto L6;
        r100.setupCanvasFromUI();
        return;
    }

    public void setupCanvasIfEnableCanvas() {
        LLog.i(TAG, "[Krypton] Setup canvas environment when specify enable_canvas in schema.");
        CanvasRuntimeMediator r100 = this.mRuntimeMediator;
        if (r100 == null) goto L6;
        r100.setupCanvasFromUI();
        this.mRuntimeMediator.registerCanvasBehavior(this.mBehaviorRegistry);
        return;
    }

    public LynxKryptonHelper(c r100) {
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        this.mCachedServiceMap = new LinkedHashMap();
        this.mBehaviorRegistry = r100;
    }

    public void onTemplateLoad(String r100) {
        CanvasRuntimeMediator r101 = this.mRuntimeMediator;
        if (r101 == null) goto L6;
        r101.onTemplateLoad(r100);
        return;
    }

    public void registerCanvasRuntimeMediator(CanvasRuntimeMediator r100) {
        LLog.i(TAG, "[Krypton] Register new CanvasRuntimeMediator." + r100);
        this.mRuntimeMediator = r100;
        String r101 = this.mTemporaryDirectory;
        if (r101 == null) goto L5;
        r100.setTemporaryDirectory(r101);
    L5:
        Iterator<Map.Entry<Class<?>, Object>> r102 = this.mCachedServiceMap.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<Class<?>, Object> r103 = r102.next();
        this.mRuntimeMediator.registerService(r103.getKey(), r103.getValue());
        goto L7
    L9:
        LynxKryptonAudioFrameCallback r104 = this.mAudioDownstreamCallback;
        if (r104 == null) goto L14;
        this.mRuntimeMediator.setAudioDownstreamCallback(r104, this.mAudioDownstreamMode);
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        return;
    }

    public void setRenderFrameCallback(RenderFrameCallback r100) {
        CanvasRuntimeMediator r101 = this.mRuntimeMediator;
        if (r101 == null) goto L9;
        ICanvasManager r102 = r101.getCanvasManager();
        if (r102 == null) goto L7;
        r102.setRenderFrameCallback(r100);
        return;
    L7:
        LLog.w(TAG, "do not support set render frame callback when canvas manager is null(only be lazy init mode)");
        return;
    }

    public void setTemporaryDirectory(String r100) {
        this.mTemporaryDirectory = r100;
        CanvasRuntimeMediator r101 = this.mRuntimeMediator;
        if (r101 == null) goto L6;
        r101.setTemporaryDirectory(r100);
        return;
    }

    public void registerService(Class<?> r100, Object r101) {
        if (r101 != null) goto L5;
        LLog.w(TAG, "do not support unregister service or register null service");
        return;
    L5:
        this.mCachedServiceMap.put(r100, r101);
        CanvasRuntimeMediator r102 = this.mRuntimeMediator;
        if (r102 == null) goto L9;
        r102.registerService(r100, r101);
        return;
    }

    public void setAudioDownstreamCallback(LynxKryptonAudioFrameCallback r100, LynxKryptonAudioDownstreamMode r101) {
        if (r101 != null) goto L4;
        r101 = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    L4:
        CanvasRuntimeMediator r102 = this.mRuntimeMediator;
        if (r102 != null) goto L8;
        this.mAudioDownstreamCallback = r100;
        this.mAudioDownstreamMode = r101;
        return;
    L8:
        this.mAudioDownstreamCallback = null;
        r102.setAudioDownstreamCallback(r100, r101);
    }
}
