package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
public class RegularFile extends FileSystemObject {
    public static final char UNIX_ID = '-';
    private static final long serialVersionUID = 7113562456595400525L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return '-';
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "RegularFile [type=" + super.toString() + "]";
    }

    public RegularFile(String r100, String r101, Permissions r102, long r103, a r104) {
        super(r100, r101, r102, r103, r104);
    }
}
