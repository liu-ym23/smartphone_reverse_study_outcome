package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
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

    public DomainSocket(String r100, String r101, Permissions r110, a r111) {
        super(r100, r101, r110, 0, r111);
    }
}
