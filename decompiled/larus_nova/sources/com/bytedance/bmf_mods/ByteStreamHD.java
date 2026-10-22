package com.bytedance.bmf_mods;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.custom.CustomDownloader;
import com.bytedance.bmf_mods.downloader.custom.ModelPathCache;
import com.bytedance.bmf_mods_api.ByteStreamHDAPI;
import com.bytedance.bmf_mods_api.ByteStreamHDCallbackAPI;
import com.bytedance.bmf_mods_api.ByteStreamHDConfig;
import com.bytedance.bmf_mods_api.ByteStreamHDInfo;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {ByteStreamHDAPI.class}, singleton = false)
public class ByteStreamHD implements ByteStreamHDAPI {
    private ByteStreamHDCallbackAPI byteStreamHDCallback;
    private CustomDownloader downloader;
    private int mAlgType;
    private long mNativePtr;
    private StringBuilder modelPathBuilder;
    private int[] outputData;
    private ByteStreamHDInfo streamHDInfo;

    private native long nativeCreateHydraByteStreamHD();

    private native int nativeGetHydraByteStreamHDReport(long r100, int[] r101);

    private native int nativeGetHydraByteStreamHDResult(long r100);

    private native int nativeHydraByteStreamHDProcessTexture(long r100, int r101, boolean r102, int r103, int r104, float[] r105, int r106, boolean r107, int r110);

    private native int nativeInitHydraByteStreamHD(long r100, int r101, int r102, int r103, int r104, int r105, int r106, String r107, int r110, int r111, int r112, int r113, int r114, String r115, int r116, float r117, float r118, float r119, String r210);

    private native void nativeReleaseHydraByteStreamHD(long r100);

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseHydraByteStreamHD(r100);
        this.mNativePtr = 0;
    }

    public ByteStreamHD() {
        this.mNativePtr = 0;
        this.mAlgType = -1;
        this.outputData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.modelPathBuilder = new StringBuilder();
        this.streamHDInfo = new ByteStreamHDInfo();
        Logging.d("New streamHD");
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public ByteStreamHDInfo GetReport() {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return null;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return null;
    L9:
        if (nativeGetHydraByteStreamHDReport(r100, this.outputData) == 0) goto L12;
        return null;
    L12:
        if (this.streamHDInfo != null) goto L14;
        this.streamHDInfo = new ByteStreamHDInfo();
    L14:
        ByteStreamHDInfo r101 = this.streamHDInfo;
        int[] r102 = this.outputData;
        r101.algRunflag = r102[0];
        r101.abStrategy = r102[1];
        r101.strongDenoiseIsoTh = r102[2];
        r101.mediumgDenoiseIsoTh = r102[3];
        r101.weakDenoiseIsoTh = r102[4];
        r101.framIndex = r102[5];
        r101.isoValue = r102[6];
        r101.initCostTime = r102[7];
        r101.frameProcessTime = r102[8];
        return r101;
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int GetResult() {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L11;
        return -2;
    L11:
        return nativeGetHydraByteStreamHDResult(r100);
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void SetDownloadCallback(ByteStreamHDCallbackAPI r100) {
        this.byteStreamHDCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void DownloadModel(Context r110, ByteStreamHDConfig r111) {
        if (r111.getAesBoostAlgType() > 0) goto L6;
        this.byteStreamHDCallback.callback(1);
        Logging.d("ByteStreamHD: algType list no aesboost, not need download ");
        return;
    L6:
        int[] r100 = r111.getGroupIds();
        if (r100.length > 0) goto L10;
        Logging.e("ByteStreamHD: GroupIds is empty ");
        return;
    L10:
        String r101 = ModelPathCache.INSTANCE.getModelPath(r111.getModelNamePrefix() + "_" + r100[0]);
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (new PolarisFileWrapper(r101).exists() == false) goto L19;
        this.modelPathBuilder.setLength(0);
        this.modelPathBuilder.append(r101);
        ByteStreamHDCallbackAPI r102 = this.byteStreamHDCallback;
        if (r102 == null) goto L23;
        r102.callback(1);
        return;
    L23:
        return;
    L19:
        if (this.downloader != null) goto L21;
        this.downloader = new CustomDownloader(r110);
    L21:
        r111.getDownLoadPath();
        this.downloader.download(r111.getModelNamePrefix() + "_" + r100[0], r111.getModelNamePrefix() + "_" + r100[0] + "Dir", "ByteStreamHD", "11.0.0", this.modelPathBuilder, r111.getParamMap(), this.byteStreamHDCallback);
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int Init(int r210, int r211, int r212, int r213, int r214, String r215, String r216, ByteStreamHDConfig r217) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        this.mAlgType = r210;
        if (r210 == 11) goto L9;
    L44:
        Logging.e("ByteStreamHD: algType range is [11],backend is [3] ");
        return -200;
    L9:
        if (r211 != 3) goto L44;
        long r100 = nativeCreateHydraByteStreamHD();
        this.mNativePtr = r100;
        if (r100 != 0) goto L15;
        return -2;
    L15:
        if (r212 > 0) goto L17;
    L20:
        Logging.d("ByteStreamHD: pool size should be more than 0, change to 3 for default");
        int r101 = 3;
    L22:
        if (r217.getAesBoostAlgType() <= 0) goto L24;
        int r102 = 1;
    L26:
        if (r217.getDenoiseAlgType() <= 0) goto L29;
        r102 = r102 | 2;
    L29:
        if (r217.getSharpAlgType() <= 0) goto L31;
        r102 = r102 | 4;
    L31:
        int r103 = r102;
        if (r103 == r217.getSubAlgListIndex()) goto L36;
        Logging.e("ByteStreamHD: subAlgListIndex not match aesboostAlg、denoiseAlg、sharpAlg");
        return -211;
    L36:
        if ((r103 & 1) <= 0) goto L43;
        if (this.modelPathBuilder.length() > 0) goto L46;
        Logging.e("ByteStreamHD: download fail");
        return ErrorCode.DOWNLOAD_FAIL;
    L46:
        return nativeInitHydraByteStreamHD(this.mNativePtr, r210, r211, r103, r101, r213, r214, r216, r217.getAbStrategy(), r217.getStrongISO(), r217.getMediumISO(), r217.getWeakISO(), r217.getTexProcessType(), this.modelPathBuilder.toString(), r217.getAesBoostAlgType(), r217.getSharpStrength(), r217.getSharpThresholdLow(), r217.getSharpThresholdHigh(), r217.getModelNamePrefix());
    L43:
        return nativeInitHydraByteStreamHD(this.mNativePtr, r210, r211, r103, r101, r213, r214, r216, r217.getAbStrategy(), r217.getStrongISO(), r217.getMediumISO(), r217.getWeakISO(), r217.getTexProcessType(), "", r217.getAesBoostAlgType(), r217.getSharpStrength(), r217.getSharpThresholdLow(), r217.getSharpThresholdHigh(), "");
    L24:
        r102 = 0;
        goto L26
    L17:
        if (r212 > 10) goto L20;
        r101 = r212;
        goto L22
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int ProcessTexture(int r110, boolean r111, int r112, int r113, float[] r114, int r115, boolean r116, int r210, int r211) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L11;
        return -2;
    L11:
        return nativeHydraByteStreamHDProcessTexture(r100, r110, r111, r112, r113, r114, r115, r116, r210);
    }
}
