package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public interface CentralDirectoryParsingZipExtraField extends ZipExtraField {
    void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) throws ZipException;
}
