package com.lynx.devtoolwrapper;

import android.content.Context;
import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxLogBox {
    void attachContext(Context r100);

    void onLoadTemplate();

    void showLogMessage(LynxError r100);
}
