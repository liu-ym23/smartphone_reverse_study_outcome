package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BlockDevice extends SystemFile {
    public static final char UNIX_ID = 'b';
    private static final long serialVersionUID = 5938248951823805680L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "BlockDevice [type=" + super.toString() + "]";
    }

    public BlockDevice(String r8, String r9, Permissions r10, a r11) {
        super(r8, r9, r10, 0, r11);
    }
}
