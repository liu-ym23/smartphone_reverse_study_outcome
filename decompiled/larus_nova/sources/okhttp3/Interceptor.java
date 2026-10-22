package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        Response proceed(Request r100) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int r100, TimeUnit r101);

        Chain withReadTimeout(int r100, TimeUnit r101);

        Chain withWriteTimeout(int r100, TimeUnit r101);

        int writeTimeoutMillis();
    }

    Response intercept(Chain r100) throws IOException;
}
