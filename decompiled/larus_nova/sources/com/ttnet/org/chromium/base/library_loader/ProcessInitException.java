package com.ttnet.org.chromium.base.library_loader;

import com.ss.android.ttvecamera.TECameraSettings;

/* JADX INFO: loaded from: classes41.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int r100) {
        super(TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX + r100);
    }

    public ProcessInitException(int r100, Throwable r101) {
        super(TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX + r100, r101);
    }
}
