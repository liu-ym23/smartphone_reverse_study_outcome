package retrofit2;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes41.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public int code() {
        return this.rawResponse.code();
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    @Nullable
    public T body() {
        return this.body;
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public static <T> Response<T> success(@Nullable T r100) {
        return success(r100, new okhttp3.Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> error(int r100, ResponseBody r101) {
        if (r100 < 400) goto L7;
        return error(r101, new okhttp3.Response.Builder().code(r100).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    L7:
        throw new IllegalArgumentException("code < 400: " + r100);
    }

    public static <T> Response<T> success(int r100, @Nullable T r101) {
        if (r100 < 200) goto L9;
        if (r100 >= 300) goto L9;
        return success(r101, new okhttp3.Response.Builder().code(r100).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    L9:
        throw new IllegalArgumentException("code < 200 or >= 300: " + r100);
    }

    public static <T> Response<T> error(ResponseBody r100, okhttp3.Response r101) {
        u.a(r100, "body == null");
        u.a(r101, "rawResponse == null");
        if (r101.isSuccessful() == true) goto L7;
        return new Response(r101, null, r100);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(@Nullable T r100, Headers r101) {
        u.a(r101, "headers == null");
        return success(r100, new okhttp3.Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(r101).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(@Nullable T r100, okhttp3.Response r101) {
        u.a(r101, "rawResponse == null");
        if (r101.isSuccessful() == false) goto L7;
        return new Response(r101, r100, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    private Response(okhttp3.Response r100, @Nullable T r101, @Nullable ResponseBody r102) {
        this.rawResponse = r100;
        this.body = r101;
        this.errorBody = r102;
    }
}
