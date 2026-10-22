package com.bytedance.ee.bear.libarchive;

/* JADX INFO: loaded from: classes16.dex */
public class ArchiveEntry {
    private static final int ENTRY_FILE = 32768;
    private static final int ENTRY_FOLDER = 16384;
    private int entryType;
    private String path;
    private long size;

    public boolean isFolder() {
        if (this.entryType != 16384) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "ArchiveEntry{entryType=" + this.entryType + ", path='" + this.path + "', size=" + this.size + '}';
    }

    public int getEntryType() {
        return this.entryType;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public void setEntryType(int r100) {
        this.entryType = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public ArchiveEntry(int r100, String r101, long r102) {
        this.entryType = r100;
        this.path = r101;
        this.size = r102;
    }
}
