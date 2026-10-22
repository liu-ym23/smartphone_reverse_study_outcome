package com.dtf.toyger.base.face;

import android.graphics.Bitmap;
import com.dtf.toyger.base.algorithm.TGDepthFrame;
import com.dtf.toyger.base.algorithm.TGFrame;
import java.io.File;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes22.dex */
public class FrameProcessor {
    private TGDepthFrame mTgDepthFrame;
    private TGFrame mTgFrame;

    public static void bitmap2File(Bitmap r100, File r101) {
    }

    public static void clearOldBinFiles() {
    }

    public static void close(OutputStream r100) {
    }

    public static synchronized boolean save(File r100, byte[] r101) {
        monitor-enter(FrameProcessor.class);
        monitor-exit(FrameProcessor.class);
        return false;
    }

    public static void saveBitmap(Bitmap r100, String r101) {
    }

    public static void saveBitmap(TGFrame r100, TGDepthFrame r101, ToygerFaceAttr r102, boolean r103, String r104) {
    }

    public void saveTgDepthFrame(String r100) {
    }

    public void saveTgFrame(String r100) {
    }

    public FrameProcessor() {
    }

    public TGDepthFrame getTgDepthFrame() {
        return this.mTgDepthFrame;
    }

    public TGFrame getTgFrame() {
        return this.mTgFrame;
    }

    public void initFame(TGFrame r100, TGDepthFrame r101) {
        this.mTgFrame = r100;
        this.mTgDepthFrame = r101;
    }
}
