package ny5;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    File a();

    void b();

    void c() throws IOException;

    void finish();

    long length();

    long position() throws IOException;

    void position(long r100) throws IOException;

    int read() throws IOException;

    int read(byte[] r100) throws IOException;

    int read(byte[] r100, int r101, int r102) throws IOException;

    void release();

    long skip(long r100) throws IOException;

    int write(byte[] r100, int r101, int r102) throws IOException;

    void write(int r100) throws IOException;

    void write(byte[] r100) throws IOException;
}
