package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NamedPipe extends SystemFile {
    public static final char UNIX_ID = 'p';
    private static final long serialVersionUID = -5199356055601688190L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "NamedPipe [type=" + super.toString() + "]";
    }

    public NamedPipe(String r8, String r9, Permissions r10, a r11) {
        super(r8, r9, r10, 0, r11);
    }
}
