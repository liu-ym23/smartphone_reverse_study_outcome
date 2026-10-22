package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public interface TTDiskStorage extends DiskStorage {
    BinaryResource getTempResource(String r100, Object r101) throws IOException;

    DiskStorage.Inserter insertTemp(String r100, int r101, Object r102) throws IOException;
}
