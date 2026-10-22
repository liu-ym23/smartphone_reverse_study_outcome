package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public RegularFile(String r1, String r2, Permissions r3, long r4, a r6) {
        super(r1, r2, r3, r4, r6);
    }
}
