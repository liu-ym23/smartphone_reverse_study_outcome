package znc;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public interface h {
    File a(String r100) throws IOException;

    String b();

    <T, R extends c<? extends T>> T c(String r100, R r101) throws IOException;

    void d(String r100, d r101) throws IOException;

    void delete() throws IOException;

    void flush() throws IOException;

    boolean remove(String r100) throws IOException;

    long size();
}
