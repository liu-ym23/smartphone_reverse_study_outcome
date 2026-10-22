package tsc;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface l {

    public interface a extends l {
        List<a> children();

        m.a parent();
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface b extends l {
    }

    a a();

    Map<String, String> b();

    int end();

    boolean isBlock();

    boolean isClosed();

    String name();

    int start();
}
