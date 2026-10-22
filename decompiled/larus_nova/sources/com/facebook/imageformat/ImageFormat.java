package com.facebook.imageformat;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFormat {
    public static final ImageFormat UNKNOWN = null;
    private final String mFileExtension;
    private final String mName;

    public interface FormatChecker {
        @Nullable
        ImageFormat determineFormat(byte[] r100, int r101);

        int getHeaderSize();
    }

    static {
        UNKNOWN = new ImageFormat("UNKNOWN", null);
    }

    public String toString() {
        return getName();
    }

    @Nullable
    public String getFileExtension() {
        return this.mFileExtension;
    }

    public String getName() {
        return this.mName;
    }

    public ImageFormat(String r100, @Nullable String r101) {
        this.mName = r100;
        this.mFileExtension = r101;
    }
}
