package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface FileCache extends DiskTrimmable {
    void clearAll();

    void clearByPercentage(Double r100);

    void clearByTimestamp(long r100);

    long clearOldEntries(long r100);

    long getCount();

    DiskStorage.DiskDumpInfo getDumpInfo() throws IOException;

    BinaryResource getResource(CacheKey r100);

    Map<String, String> getResourceConfig(CacheKey r100) throws IOException;

    long getSize();

    boolean hasKey(CacheKey r100);

    boolean hasKeySync(CacheKey r100);

    BinaryResource insert(CacheKey r100, WriterCallback r101) throws IOException;

    boolean isEnabled();

    boolean probe(CacheKey r100);

    void remove(CacheKey r100);
}
