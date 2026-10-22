package com.bytedance.ee.bear.archive_api;

import com.bytedance.ee.bear.libarchive.ArchiveEntry;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface IArchiveApi {
    int extractAll(String r100, String r101, String r102) throws IOException;

    int extractEntry(String r100, String r101, String r102, String r103) throws IOException;

    List<ArchiveEntry> getFileList(String r100) throws IOException;

    boolean isEncrypted(String r100) throws IOException;
}
