package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public Directory(String r8, String r9, Permissions r10, a r11) {
        super(r8, r9, r10, 0, r11);
    }
}
