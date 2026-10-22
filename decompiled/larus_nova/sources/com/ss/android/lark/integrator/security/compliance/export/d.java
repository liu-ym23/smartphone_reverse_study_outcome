package com.ss.android.lark.integrator.security.compliance.export;

import android.app.Dialog;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public interface d extends IOfficeSDKCapacity {
    void K(Dialog r100);

    void L8(Dialog r100);

    void w0(String r100, String r101, ByteString r102, IGetWaterMarkResourceCallback r103);
}
