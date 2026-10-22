package com.ss.android.lark.watermark.userscope;

import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public interface c {
    void C4(BaseFragment r100);

    void N0(Fragment r100);

    void attachGlobalWatermark(Dialog r100);

    String cd(String r100, String r101);

    void h6(com.ss.android.lark.watermark.a r100);

    void hf(com.ss.android.lark.watermark.a r100);

    void qa(BaseFragment r100);

    int s();

    void v7();

    void w0(String r100, String r101, ByteString r102, IGetWaterMarkResourceCallback r103);

    WatermarkInfo z0(Context r100);
}
