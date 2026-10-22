package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
public class CharacterDevice extends SystemFile {
    public static final char UNIX_ID = 'c';
    private static final long serialVersionUID = -3585051204874199619L;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "CharacterDevice [type=" + super.toString() + "]";
    }

    public CharacterDevice(String r100, String r101, Permissions r110, a r111) {
        super(r100, r101, r110, 0, r111);
    }
}
