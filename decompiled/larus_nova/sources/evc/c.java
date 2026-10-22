package evc;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okio.Sink;

/* JADX INFO: loaded from: classes42.dex */
public interface c {
    void a() throws IOException;

    void b(Request r100) throws IOException;

    Sink c(Request r100, long r101);

    void cancel();

    void d() throws IOException;

    g e(Response r100) throws IOException;

    Response.Builder f(boolean r100) throws IOException;
}
