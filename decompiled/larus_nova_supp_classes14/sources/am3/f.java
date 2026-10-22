package am3;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface f {
    void a();

    f b();

    void c(long r1) throws IOException;

    boolean d() throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray(long r1) throws IOException;

    int readIntLe() throws IOException;

    long readLongLe() throws IOException;

    String readUtf8(long r1) throws IOException;

    void skip(long r1) throws IOException;
}
