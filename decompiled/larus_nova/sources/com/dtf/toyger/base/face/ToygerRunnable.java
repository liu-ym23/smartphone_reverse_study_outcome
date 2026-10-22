package com.dtf.toyger.base.face;

import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.algorithm.TGDepthFrame;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.dtf.toyger.base.algorithm.Toyger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerRunnable implements Runnable {
    private static final String TAG = "TOYGER_FLOW_RUNNABLE";
    public ToygerAttr attr;
    public TGDepthFrame depthFrame;
    public List<TGFrame> frames;

    @Override // java.lang.Runnable
    public void run() {
        com_dtf_toyger_base_face_ToygerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_dtf_toyger_base_face_ToygerRunnable__run$___twin___() {
        Toyger.processImage(this.frames, this.depthFrame, this.attr);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_dtf_toyger_base_face_ToygerRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ToygerRunnable r100) {
        r100.com_dtf_toyger_base_face_ToygerRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ToygerRunnable(List<TGFrame> r100, TGDepthFrame r101, ToygerAttr r102) {
        this.frames = r100;
        this.depthFrame = r101;
        this.attr = r102;
    }
}
