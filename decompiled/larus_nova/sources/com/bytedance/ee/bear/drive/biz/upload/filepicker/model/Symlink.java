package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
public class Symlink extends FileSystemObject {
    public static final char UNIX_ID = 'l';
    private static final long serialVersionUID = -6411787401264288389L;
    private String mLink;
    private FileSystemObject mLinkRef;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public char getUnixIdentifier() {
        return UNIX_ID;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.FileSystemObject
    public String toString() {
        return "Symlink [type=" + super.toString() + ", link=" + this.mLink + "]";
    }

    public String getLink() {
        return this.mLink;
    }

    public FileSystemObject getLinkRef() {
        return this.mLinkRef;
    }

    public void setLink(String r100) {
        this.mLink = r100;
    }

    public void setLinkRef(FileSystemObject r100) {
        this.mLinkRef = r100;
    }

    public Symlink(String r100, String r101, String r110, Permissions r111, a r112) {
        super(r100, r110, r111, 0, r112);
        this.mLink = r101;
    }
}
