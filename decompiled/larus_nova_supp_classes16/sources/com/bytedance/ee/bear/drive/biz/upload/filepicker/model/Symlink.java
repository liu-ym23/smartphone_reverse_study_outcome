package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setLink(String r1) {
        this.mLink = r1;
    }

    public void setLinkRef(FileSystemObject r1) {
        this.mLinkRef = r1;
    }

    public Symlink(String r8, String r9, String r10, Permissions r11, a r12) {
        super(r8, r10, r11, 0, r12);
        this.mLink = r9;
    }
}
