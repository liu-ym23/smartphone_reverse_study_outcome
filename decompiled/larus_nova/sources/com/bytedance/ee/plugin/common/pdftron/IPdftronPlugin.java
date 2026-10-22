package com.bytedance.ee.plugin.common.pdftron;

import android.content.Context;
import com.bytedance.ee.plugin.common.IPluginApi;

/* JADX INFO: loaded from: classes19.dex */
public interface IPdftronPlugin extends IPluginApi {
    boolean initPdftron(Context r100, String r101);

    IPDFDrawWrapper newPDFDraw(Context r100);

    IPDFViewCtrlWrapper newPDFViewCtrl(Context r100);
}
