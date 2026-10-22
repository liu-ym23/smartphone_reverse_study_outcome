package com.dtf.face.verify;

import com.dtf.face.api.IDTUIListener;

/* JADX INFO: loaded from: classes22.dex */
public interface ISMSResultCallback {
    IDTUIListener getUiCustomListener();

    void sendResponse(String r100, String r101);
}
