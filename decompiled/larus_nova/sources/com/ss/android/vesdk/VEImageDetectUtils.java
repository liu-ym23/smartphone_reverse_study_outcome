package com.ss.android.vesdk;

import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.medialib.model.EnigmaResult;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.vesdk.runtime.VEEffectConfig;
import com.ss.android.vesdk.runtime.VERuntime;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VEImageDetectUtils {
    public static final String TAG = null;
    private IDetectImageEnigmaResultListener mDetectEnigmaResultListener;
    private IDetectImageResultListener mDetectResultListener;
    private IDetectImageResultWithNumListener mDetectResultWithNumListener;
    private boolean mInterruptDetectImageContent;
    private long mNativeHandler;

    public interface IDetectImageEnigmaResultListener {
        void onDetectResult(EnigmaResult r100);
    }

    public interface IDetectImageResultListener {
        void onDetectResult(String r100, String r101, String r102, boolean r103);
    }

    public interface IDetectImageResultWithNumListener {
        void onDetectResult(String r100, String r101, String r102, int r103);
    }

    private native int nativeDestroy(long r100);

    private native int nativeDetectImageContent(long r100, String r101, String r102, String[] r103, int r104, int r105);

    private native int nativeDetectImageEnigma(long r100, String r101, int r102, int r103);

    private native long nativeInit(int r100, int r101, String r102, String r103, boolean r104, String r105);

    public int init() {
        long r100 = nativeInit(0, 0, VERuntime.getInstance().getEnv().a(), Build.DEVICE, false, VEEffectConfig.getCacheDir());
        if (r100 != 0) goto L6;
        return -1;
    L6:
        this.mNativeHandler = r100;
        return 0;
    }

    public synchronized void stopDetectImagesContentIfNeed() {
        monitor-enter(this);
        this.mInterruptDetectImageContent = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        TAG = "VEImageDetectUtils";
        TENativeLibsLoader.loadLibrary();
    }

    public int destroy() {
        long r100 = this.mNativeHandler;
        if (r100 != 0) goto L6;
        VELogUtil.w(TAG, "invoke destroy() encounter handler == 0. Consider destroy() has been called already?");
        return -1;
    L6:
        int r101 = nativeDestroy(r100);
        if (r101 != 0) goto L9;
        this.mNativeHandler = 0;
        VELogUtil.i(TAG, "NativeHandler destroy succeed.");
    L9:
        this.mDetectResultListener = null;
        return r101;
    }

    public VEImageDetectUtils() {
        this.mNativeHandler = 0;
        this.mInterruptDetectImageContent = true;
        this.mDetectResultListener = null;
        this.mDetectResultWithNumListener = null;
        this.mDetectEnigmaResultListener = null;
    }

    public void onNativeCallback_onDetectImageEnigma(EnigmaResult r100) {
        IDetectImageEnigmaResultListener r101 = this.mDetectEnigmaResultListener;
        if (r101 != null) goto L6;
        VELogUtil.w(TAG, "Native callback onDetectImageEnigma encounter no listener handle?");
        return;
    L6:
        if (r101 == null) goto L9;
        r101.onDetectResult(r100);
        return;
    }

    public void setDetectImageContentListener(IDetectImageResultListener r100) {
        this.mDetectResultListener = r100;
    }

    public void setDetectImageContentWithNumListener(IDetectImageResultWithNumListener r100) {
        this.mDetectResultWithNumListener = r100;
    }

    public void setDetectImageEnigmaListener(IDetectImageEnigmaResultListener r100) {
        this.mDetectEnigmaResultListener = r100;
    }

    public int detectImageEnigma(String r100, int r110, int r111) {
        if (r100.startsWith("content") == false) goto L5;
    L8:
        VELogUtil.i(TAG, "detectImageEnigma..., imagePath=" + r100 + ", maxWidth=" + r110 + ", maxHeight=" + r110);
        return nativeDetectImageEnigma(this.mNativeHandler, r100, r110, r111);
    L5:
        if (new PolarisFileWrapper(r100).exists() == true) goto L8;
        VELogUtil.e(TAG, "Illegal argument. file: \"" + r100 + "\" is not exist.");
        return -100;
    }

    public void detectImagesContent(String r110, List<String> r111, List<String> r112) {
        monitor-enter(this);
        int r100 = 0;
        this.mInterruptDetectImageContent = false;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r112.isEmpty() == false) goto L10;
        VELogUtil.w(TAG, "Unexpected argument. scanAlgorithmList is empty?");
        return;
    L10:
        String[] r101 = new String[r112.size()];
        r112.toArray(r101);
        int r113 = r111.size();
    L11:
        if (r100 >= r113) goto L21;
        if (this.mInterruptDetectImageContent == true) goto L31;
        String r102 = (String) ListProtector.get(r111, r100);
        if (r102.startsWith("content") == false) goto L17;
    L19:
        nativeDetectImageContent(this.mNativeHandler, r110, (String) ListProtector.get(r111, r100), r101, -1, -1);
    L20:
        r100 = r100 + 1;
        goto L11
    L17:
        if (new PolarisFileWrapper(r102).exists() == true) goto L19;
        VELogUtil.e(TAG, "Illegal argument. file: \"" + r102 + "\" is not exist.");
        goto L20
    L31:
        return;
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public int detectImageContent(String r110, String r111, List<String> r112, int r113, int r114) {
        if (r111.startsWith("content") == true) goto L9;
        if (new PolarisFileWrapper(r111).exists() == true) goto L9;
        VELogUtil.e(TAG, "Illegal argument. file: \"" + r111 + "\" is not exist.");
        return -100;
    L9:
        if (r112.isEmpty() == false) goto L12;
        VELogUtil.w(TAG, "Unexpected argument. scanAlgorithmList is empty?");
        return -100;
    L12:
        VELogUtil.w(TAG, "detectImageContent... stickerId:" + r110 + ", imagePath=" + r111 + ", maxWidth=" + r113 + ", maxHeight=" + r113);
        String[] r100 = new String[r112.size()];
        r112.toArray(r100);
        return nativeDetectImageContent(this.mNativeHandler, r110, r111, r100, r113, r114);
    }

    public void detectImagesContentWithSize(String r110, List<String> r111, List<String> r112, int r113, int r114) {
        monitor-enter(this);
        int r100 = 0;
        this.mInterruptDetectImageContent = false;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r112.isEmpty() == false) goto L10;
        VELogUtil.w(TAG, "Unexpected argument. scanAlgorithmList is empty?");
        return;
    L10:
        String[] r101 = new String[r112.size()];
        r112.toArray(r101);
        int r115 = r111.size();
    L11:
        if (r100 >= r115) goto L21;
        if (this.mInterruptDetectImageContent == true) goto L31;
        String r102 = (String) ListProtector.get(r111, r100);
        if (r102.startsWith("content") == false) goto L17;
    L19:
        nativeDetectImageContent(this.mNativeHandler, r110, (String) ListProtector.get(r111, r100), r101, r113, r114);
    L20:
        r100 = r100 + 1;
        goto L11
    L17:
        if (new PolarisFileWrapper(r102).exists() == true) goto L19;
        VELogUtil.e(TAG, "Illegal argument. file: \"" + r102 + "\" is not exist.");
        goto L20
    L31:
        return;
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void onNativeCallback_onDetectImageContent(String r100, String r101, String r102, boolean r103, int r104) {
        IDetectImageResultListener r105 = this.mDetectResultListener;
        if (r105 == null) goto L5;
    L8:
        if (r105 == null) goto L10;
        r105.onDetectResult(r100, r101, r102, r103);
    L10:
        IDetectImageResultWithNumListener r106 = this.mDetectResultWithNumListener;
        if (r106 == null) goto L14;
        r106.onDetectResult(r100, r101, r102, r104);
        return;
    L14:
        return;
    L5:
        if (this.mDetectResultWithNumListener != null) goto L8;
        VELogUtil.w(TAG, "Native callback onDetectImageContent encounter no listener handle?");
    }
}
