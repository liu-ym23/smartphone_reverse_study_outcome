package gd9;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface v {

    public interface a {
        void onReceive(byte[] r100);
    }

    public interface b {
        void onStatusChanged(int r100, int r101);
    }

    void a(byte[] r100, Map<String, String> r101);

    n b();

    void c(a r100);

    void connect();

    int d();

    void disconnect();

    String e(String r100);

    com.larus.im.g f();

    void g(a r100);

    t h();

    void i(b r100);

    boolean isNetworkAvailable();

    boolean j(e r100);

    void k(b r100);
}
