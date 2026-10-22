package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
public class Directory extends FileSystemObject {
    public static final char UNIX_ID = 'd';
    private static final long serialVersionUID = -3975569940766905884L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "Directory [type=" + super.toString() + "]";
    }

    public Directory() {
    }

    public Directory(String r100, String r101, Permissions r110, a r111) {
        super(r100, r101, r110, 0, r111);
    }
}
