package org.apache.commons.compress.compressors.gzip;

/* JADX INFO: loaded from: classes42.dex */
public class GzipParameters {
    private String comment;
    private int compressionLevel;
    private String filename;
    private long modificationTime;
    private int operatingSystem;

    public GzipParameters() {
        this.compressionLevel = -1;
        this.operatingSystem = 255;
    }

    public void setComment(String r100) {
        this.comment = r100;
    }

    public void setCompressionLevel(int r100) {
        if (r100 < (-1)) goto L9;
        if (r100 > 9) goto L9;
        this.compressionLevel = r100;
        return;
    L9:
        throw new IllegalArgumentException("Invalid gzip compression level: " + r100);
    }

    public void setFilename(String r100) {
        this.filename = r100;
    }

    public void setModificationTime(long r100) {
        this.modificationTime = r100;
    }

    public void setOperatingSystem(int r100) {
        this.operatingSystem = r100;
    }
}
