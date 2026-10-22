package com.bytedance.ee.bear.libarchive;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ArchiveEntry {
    private static final int ENTRY_FILE = 32768;
    private static final int ENTRY_FOLDER = 16384;
    private int entryType;
    private String path;
    private long size;

    public boolean isFolder() {
        if (this.entryType != ENTRY_FOLDER) goto L5;
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

    public void setEntryType(int r1) {
        this.entryType = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }

    public ArchiveEntry(int r1, String r2, long r3) {
        this.entryType = r1;
        this.path = r2;
        this.size = r3;
    }
}
