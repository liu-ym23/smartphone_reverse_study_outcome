package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ParentDirectory extends Directory {
    private static final long serialVersionUID = -3818276335217197479L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public boolean isHidden() {
        return false;
    }

    public ParentDirectory(String r4) {
        super("..", r4, null, new a(new a.C0157a()));
    }
}
