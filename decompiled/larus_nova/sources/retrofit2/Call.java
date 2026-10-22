package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes41.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> mo11002clone();

    void enqueue(Callback<T> r100);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
