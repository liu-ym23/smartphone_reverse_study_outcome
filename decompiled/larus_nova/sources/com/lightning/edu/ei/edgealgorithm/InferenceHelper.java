package com.lightning.edu.ei.edgealgorithm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes32.dex */
public class InferenceHelper {
    public static final int DEVICE_TYPE_AUTO = 4;
    public static final int DEVICE_TYPE_CPU = 0;
    public static final int DEVICE_TYPE_DSP = 2;
    public static final int DEVICE_TYPE_GPU = 1;
    public static final int DEVICE_TYPE_NPU = 3;
    public static final int DEVICE_TYPE_OPENCL = 5;
    private static String TAG = "InferenceHelper";
    private long initCost;
    private long mInference;
    private CountDownLatch mLatch;

    public static Params getVaildParams() {
        Params r100 = new Params();
        r100.blur_status = 1;
        r100.scene_status = 1;
        r100.dark_status = 1;
        r100.orientation_status = 1;
        r100.questions_status = 1;
        return r100;
    }

    public void release() {
        PthreadAsyncTask.execute(new AnonymousClass1(this));
    }

    public String version() {
        return InferenceNative.Version(this.mInference);
    }

    private InferenceHelper() {
        this.initCost = 0;
    }

    public static String getVersion() {
        return InferenceNative.GetVersion();
    }

    private InferenceHelper(long r100) {
        this.initCost = 0;
        this.mInference = r100;
    }

    public static /* synthetic */ CountDownLatch access$000(InferenceHelper r100) {
        return r100.mLatch;
    }

    public static /* synthetic */ long access$100(InferenceHelper r100) {
        return r100.mInference;
    }

    public static /* synthetic */ long access$102(InferenceHelper r100, long r101) {
        r100.mInference = r101;
        return r101;
    }

    public Result runPredict(Bitmap r100, Params r110) {
        Result r101 = new Result();
        if (0 != this.mInference) goto L7;
        r101.pass = false;
        r101.status = 1;
        r101.msg = "Error! mInference is 0.";
        return r101;
    L7:
        if (r100.getWidth() >= 5) goto L9;
    L13:
        r101.pass = false;
        r101.status = 2;
        r101.msg = "Error! input image is too small.";
        return r101;
    L9:
        if (r100.getHeight() < 5) goto L13;
        this.mLatch = new CountDownLatch(1);
        long r102 = System.currentTimeMillis();
        Result r103 = InferenceNative.PredictBitmap(this.mInference, r100, 0, r110);
        r103.predictCost = System.currentTimeMillis() - r102;
        r103.initCost = this.initCost;
        this.mLatch.countDown();
        return r103;
    }

    public Result runPredict(Bitmap r100, int r110, Params r111) {
        Result r101 = new Result();
        if (0 != this.mInference) goto L7;
        r101.pass = false;
        r101.status = 1;
        r101.msg = "Error! mInference is 0.";
        return r101;
    L7:
        if (r100.getWidth() >= 5) goto L9;
    L13:
        r101.pass = false;
        r101.status = 2;
        r101.msg = "Error! input image is too small.";
        return r101;
    L9:
        if (r100.getHeight() < 5) goto L13;
        this.mLatch = new CountDownLatch(1);
        long r102 = System.currentTimeMillis();
        Result r103 = InferenceNative.PredictBitmap(this.mInference, r100, r110, r111);
        r103.predictCost = System.currentTimeMillis() - r102;
        r103.initCost = this.initCost;
        this.mLatch.countDown();
        return r103;
    }

    public Result runPredict(int[] r110, int r111, int r112, Params r113) {
        Result r100 = new Result();
        if (0 != this.mInference) goto L7;
        r100.pass = false;
        r100.status = 1;
        r100.msg = "Error! mInference is 0.";
        return r100;
    L7:
        if (r111 < 5) goto L12;
        if (r112 < 5) goto L12;
        this.mLatch = new CountDownLatch(1);
        long r101 = System.currentTimeMillis();
        Result r114 = InferenceNative.PredictIntArray(this.mInference, r110, r111, r112, 0, r113);
        r114.predictCost = System.currentTimeMillis() - r101;
        r114.initCost = this.initCost;
        this.mLatch.countDown();
        return r114;
    L12:
        r100.pass = false;
        r100.status = 2;
        r100.msg = "Error! input image is too small.";
        return r100;
    }

    public static InferenceHelper initModel(AssetManager r110, int r111, int r210, String r211, Params r212) {
        long r100 = System.currentTimeMillis();
        String r112 = String.valueOf(r212.blur_url);
        int r101 = r212.blur_status;
        String r113 = String.valueOf(r212.scene_url);
        int r102 = r212.scene_status;
        String r114 = String.valueOf(r212.dark_url);
        int r103 = r212.dark_status;
        String r115 = String.valueOf(r212.orientation_url);
        int r116 = r212.orientation_status;
        String r117 = String.valueOf(r212.questions_url);
        long r104 = InferenceNative.InitByAssetManger(r110, r111, r210, r101, r102, r103, r116, r212.questions_status, r211, r112, r113, r114, r115, r117);
        if ((-1) != r104) goto L6;
        return null;
    L6:
        long r105 = System.currentTimeMillis() - r100;
        InferenceHelper r106 = new InferenceHelper(r104);
        r106.initCost = r105;
        return r106;
    }

    public Result runPredict(int[] r110, int r111, int r112, int r113, Params r114) {
        Result r100 = new Result();
        if (0 != this.mInference) goto L7;
        r100.pass = false;
        r100.status = 1;
        r100.msg = "Error! mInference is 0.";
        return r100;
    L7:
        if (r111 < 5) goto L12;
        if (r112 < 5) goto L12;
        this.mLatch = new CountDownLatch(1);
        long r101 = System.currentTimeMillis();
        Result r115 = InferenceNative.PredictIntArray(this.mInference, r110, r111, r112, r113, r114);
        r115.predictCost = System.currentTimeMillis() - r101;
        r115.initCost = this.initCost;
        this.mLatch.countDown();
        return r115;
    L12:
        r100.pass = false;
        r100.status = 2;
        r100.msg = "Error! input image is too small.";
        return r100;
    }
}
