package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public final class JarMarker implements ZipExtraField {
    private static final JarMarker DEFAULT = null;
    private static final ZipShort ID = null;
    private static final byte[] NO_BYTES = null;
    private static final ZipShort NULL = null;

    static {
        ID = new ZipShort(51966);
        NULL = new ZipShort(0);
        NO_BYTES = new byte[0];
        DEFAULT = new JarMarker();
    }

    public JarMarker() {
    }

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        if (r102 != 0) goto L5;
        return;
    L5:
        throw new ZipException("JarMarker doesn't expect any data");
    }
}
