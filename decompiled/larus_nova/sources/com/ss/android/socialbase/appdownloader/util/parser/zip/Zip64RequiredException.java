package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class Zip64RequiredException extends ZipException {
    static final String ARCHIVE_TOO_BIG_MESSAGE = "archive's size exceeds the limit of 4GByte.";
    static final String TOO_MANY_ENTRIES_MESSAGE = "archive contains more than 65535 entries.";
    private static final long serialVersionUID = 20110809;

    public Zip64RequiredException(String r100) {
        super(r100);
    }

    public static String getEntryTooBigMessage(ZipEntry r100) {
        return r100.getName() + "'s size exceeds the limit of 4GByte.";
    }
}
