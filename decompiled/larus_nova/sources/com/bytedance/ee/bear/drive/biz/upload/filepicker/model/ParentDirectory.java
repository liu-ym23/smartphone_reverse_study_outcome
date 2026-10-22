package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;

/* JADX INFO: loaded from: classes16.dex */
public class ParentDirectory extends Directory {
    private static final long serialVersionUID = -3818276335217197479L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public boolean isHidden() {
        return false;
    }

    public ParentDirectory(String r100) {
        super(DownloadConstants.VULNERABILITY_PATH, r100, null, new a(new a.C3213a()));
    }
}
