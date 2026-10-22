package com.bytedance.common.jato.memory.LeakRepair;

import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.view.View;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.util.DoubleReflector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public class RenderNodeReclaimer {
    private static RenderNodeReclaimer sInstance;
    private Field mFld_RenderNode_mNativeRenderNode;
    private Field mFld_View_RenderNode;
    private Method mMth_RecordingCanvas_drawRenderNode;
    private Constructor<RenderNode> mMth_RenderNode_Contructor_nativePtr;
    private Method mMth_RenderNode_isValid;
    private RenderNode mReplaceEmptyNode;
    private long mReplaceEmptyNodeNative;

    private static native boolean nativeInitRenderNodeReclaim(long r100, Method r101, boolean r102);

    static {
        JatoNativeLoader.loadLibrary();
        sInstance = null;
    }

    private RenderNodeReclaimer() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        long r100 = -1;
        Field r101 = DoubleReflector.getField(View.class, "mRenderNode");     // Catch: Exception -> L8
        this.mFld_View_RenderNode = r101;     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        Field r102 = DoubleReflector.getField(RenderNode.class, "mNativeRenderNode");     // Catch: Exception -> L8
        this.mFld_RenderNode_mNativeRenderNode = r102;     // Catch: Exception -> L8
        r102.setAccessible(true);     // Catch: Exception -> L8
        Class r103 = Long.TYPE;     // Catch: Exception -> L8
        Method r104 = DoubleReflector.getMethod(RenderNode.class, "nIsValid", new Class[]{r103});     // Catch: Exception -> L8
        this.mMth_RenderNode_isValid = r104;     // Catch: Exception -> L8
        r104.setAccessible(true);     // Catch: Exception -> L8
        Constructor<RenderNode> r105 = RenderNode.class.getDeclaredConstructor(new Class[]{r103});     // Catch: Exception -> L8
        this.mMth_RenderNode_Contructor_nativePtr = r105;     // Catch: Exception -> L8
        r105.setAccessible(true);     // Catch: Exception -> L8
        RenderNode r106 = new RenderNode("ReplaceEmptyNode");     // Catch: Exception -> L8
        this.mReplaceEmptyNode = r106;     // Catch: Exception -> L8
        r100 = ((Long) this.mFld_RenderNode_mNativeRenderNode.get(r106)).longValue();     // Catch: Exception -> L8
        Method r107 = DoubleReflector.getMethod(RecordingCanvas.class, "nDrawRenderNode", new Class[]{r103, r103});     // Catch: Exception -> L8
        this.mMth_RecordingCanvas_drawRenderNode = r107;     // Catch: Exception -> L8
        r107.setAccessible(true);     // Catch: Exception -> L8
    L11:
        if (r100 != 0) goto L13;
        return;
    L13:
        if (nativeInitRenderNodeReclaim(r100, this.mMth_RecordingCanvas_drawRenderNode, LeakRepair2.IS_DEBUG) == false) goto L19;
        this.mReplaceEmptyNodeNative = r100;
        return;
    L19:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }
}
