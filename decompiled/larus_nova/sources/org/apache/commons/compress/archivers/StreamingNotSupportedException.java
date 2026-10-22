package org.apache.commons.compress.archivers;

/* JADX INFO: loaded from: classes42.dex */
public class StreamingNotSupportedException extends ArchiveException {
    private static final long serialVersionUID = 1;
    private final String format;

    public String getFormat() {
        return this.format;
    }

    public StreamingNotSupportedException(String r100) {
        super("The " + r100 + " doesn't support streaming.");
        this.format = r100;
    }
}
