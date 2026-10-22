package com.larksuite.framework.http.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 6799379234808041243L;
    private int code;
    private Map<String, String> headers;
    private IResponseBody mResponseBody;

    public interface IResponseBody extends Serializable {
        InputStream byteStream();

        byte[] bytes() throws IOException;

        long contentLength();

        String string() throws IOException;
    }

    public InputStream byteStream() {
        return this.mResponseBody.byteStream();
    }

    public boolean isSuccessful() {
        int r100 = this.code;
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    public String message() throws IOException {
        return this.mResponseBody.string();
    }

    public BaseResponse() {
        this.code = 0;
    }

    public IResponseBody body() {
        return this.mResponseBody;
    }

    public int code() {
        return this.code;
    }

    public Map<String, String> headers() {
        return this.headers;
    }

    public BaseResponse(int r100, IResponseBody r101) {
        this.code = r100;
        this.mResponseBody = r101;
    }

    public BaseResponse(int r100, Map<String, String> r101, IResponseBody r102) {
        this.code = r100;
        this.headers = r101;
        this.mResponseBody = r102;
    }
}
