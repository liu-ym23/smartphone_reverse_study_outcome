package com.lynx.tasm.ui.image;

import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: classes32.dex */
public class l {
    public l() {
    }

    public boolean isPendingLoad() {
        return false;
    }

    public void onImageDstSize(int r100, int r101) {
    }

    public void onImageLoadFailed(String r100) {
    }

    public void onImageLoadFailed(String r100, int r101, int r102) {
    }

    public void onImageLoadSuccess(int r100, int r101) {
    }

    public void onImageStartLoad() {
    }

    public void onImageLoadFailed(LynxError r100, int r101, int r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getSummaryMessage() + ": " + r100.getRootCause();
    L5:
        onImageLoadFailed(r103, r101, r102);
        return;
    L4:
        r103 = "";
        goto L5
    }
}
