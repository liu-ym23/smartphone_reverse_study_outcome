package okhttp3;

import java.io.IOException;
import okio.j0;

/* JADX INFO: loaded from: classes5.dex */
public interface Call extends Cloneable {

    public interface a {
        Call newCall(Request r100);
    }

    void cancel();

    /* JADX INFO: renamed from: clone */
    Call mo7964clone();

    void enqueue(Callback r100);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    j0 timeout();
}
