package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DomainSocket extends SystemFile {
    public static final char UNIX_ID = 's';
    private static final long serialVersionUID = 7821422013567568593L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return 's';
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "DomainSocket [type=" + super.toString() + "]";
    }

    public DomainSocket(String r8, String r9, Permissions r10, a r11) {
        super(r8, r9, r10, 0, r11);
    }
}
