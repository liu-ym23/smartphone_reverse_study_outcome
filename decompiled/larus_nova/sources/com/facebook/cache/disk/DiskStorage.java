package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface DiskStorage {

    /* JADX INFO: loaded from: classes22.dex */
    public static class DiskDumpInfo {
        public List<DiskDumpInfoEntry> entries;
        public Map<String, Integer> typeCounts;

        public DiskDumpInfo() {
            this.entries = new ArrayList();
            this.typeCounts = new HashMap();
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class DiskDumpInfoEntry {
        public final String firstBits;
        public final String path;
        public final float size;
        public final String type;

        public DiskDumpInfoEntry(String r100, String r101, float r102, String r103) {
            this.path = r100;
            this.type = r101;
            this.size = r102;
            this.firstBits = r103;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface Entry {
        String getId();

        BinaryResource getResource();

        long getSize();

        long getTimestamp();

        int getVisitCount();

        boolean isContentFile();
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface Inserter {
        boolean cleanUp();

        BinaryResource commit(Object r100) throws IOException;

        void writeData(WriterCallback r100, Object r101) throws IOException;
    }

    void clearAll() throws IOException;

    boolean contains(String r100, Object r101) throws IOException;

    Collection<Entry> getConfigEntries() throws IOException;

    List<Entry> getDiskCacheEntries() throws IOException;

    DiskDumpInfo getDumpInfo() throws IOException;

    Collection<Entry> getEntries() throws IOException;

    BinaryResource getResource(String r100, Object r101) throws IOException;

    Map<String, String> getResourceConfig(String r100, Object r101) throws IOException;

    String getStorageName();

    Inserter insert(String r100, Object r101) throws IOException;

    boolean isEnabled();

    boolean isExternal();

    void purgeUnexpectedResources();

    long remove(Entry r100) throws IOException;

    long remove(String r100) throws IOException;

    long removeConfig(String r100) throws IOException;

    boolean touch(String r100, Object r101) throws IOException;
}
