package com.ss.ttm.player;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public interface IMediaDataSource extends Closeable {
    public static final int MDS_VERSION_0 = 0;
    public static final int MDS_VERSION_1 = 1;

    /* JADX INFO: renamed from: com.ss.ttm.player.IMediaDataSource$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$close(IMediaDataSource r100, int r101) {
            return -1;
        }

        public static String $default$getFilePath(IMediaDataSource r100) {
            return "/mds_default_file";
        }

        public static int $default$getMDSVersion(IMediaDataSource r100) {
            return 0;
        }

        public static long $default$getSize(IMediaDataSource r100, int r101) {
            return -1;
        }

        public static int $default$open(IMediaDataSource r100, String r101) {
            return -1;
        }

        public static int $default$readAt(IMediaDataSource r100, int r101, long r102, ByteBuffer r103, int r104, int r105) {
            return -1;
        }
    }

    int close(int r100);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    String getFilePath();

    int getMDSVersion();

    long getSize() throws IOException;

    long getSize(int r100);

    int open(String r100);

    int readAt(int r100, long r101, ByteBuffer r102, int r103, int r104);

    int readAt(long r100, byte[] r101, int r102, int r103) throws IOException;
}
