package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class Response implements Closeable {

    @Nullable
    final ResponseBody body;

    @Nullable
    private volatile CacheControl cacheControl;

    @Nullable
    final Response cacheResponse;
    final int code;

    @Nullable
    final j handshake;
    final Headers headers;
    final String message;

    @Nullable
    final Response networkResponse;

    @Nullable
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sentRequestAtMillis;

    /* JADX INFO: loaded from: classes6.dex */
    public static class Builder {

        @Nullable
        ResponseBody body;

        @Nullable
        Response cacheResponse;
        int code;

        @Nullable
        j handshake;
        Headers.Builder headers;
        String message;

        @Nullable
        Response networkResponse;

        @Nullable
        Response priorResponse;

        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;

        @Nullable
        Request request;
        long sentRequestAtMillis;

        public Response build() {
            if (this.request == null) goto L19;
            if (this.protocol == null) goto L17;
            if (this.code < 0) goto L15;
            if (this.message == null) goto L13;
            return new Response(this);
        L13:
            throw new IllegalStateException("message == null");
        L15:
            throw new IllegalStateException("code < 0: " + this.code);
        L17:
            throw new IllegalStateException("protocol == null");
        L19:
            throw new IllegalStateException("request == null");
        }

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public Builder(Response r100) {
            this.code = -1;
            this.request = r100.request;
            this.protocol = r100.protocol;
            this.code = r100.code;
            this.message = r100.message;
            this.handshake = r100.handshake;
            this.headers = r100.headers.newBuilder();
            this.body = r100.body;
            this.networkResponse = r100.networkResponse;
            this.cacheResponse = r100.cacheResponse;
            this.priorResponse = r100.priorResponse;
            this.sentRequestAtMillis = r100.sentRequestAtMillis;
            this.receivedResponseAtMillis = r100.receivedResponseAtMillis;
        }

        private void checkPriorResponse(Response r100) {
            if (r100.body != null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public Builder body(@Nullable ResponseBody r100) {
            this.body = r100;
            return this;
        }

        public Builder cacheResponse(@Nullable Response r100) {
            if (r100 == null) goto L4;
            checkSupportResponse("cacheResponse", r100);
        L4:
            this.cacheResponse = r100;
            return this;
        }

        public Builder code(int r100) {
            this.code = r100;
            return this;
        }

        public Builder handshake(@Nullable j r100) {
            this.handshake = r100;
            return this;
        }

        public Builder headers(Headers r100) {
            this.headers = r100.newBuilder();
            return this;
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }

        public Builder networkResponse(@Nullable Response r100) {
            if (r100 == null) goto L4;
            checkSupportResponse("networkResponse", r100);
        L4:
            this.networkResponse = r100;
            return this;
        }

        public Builder priorResponse(@Nullable Response r100) {
            if (r100 == null) goto L4;
            checkPriorResponse(r100);
        L4:
            this.priorResponse = r100;
            return this;
        }

        public Builder protocol(Protocol r100) {
            this.protocol = r100;
            return this;
        }

        public Builder receivedResponseAtMillis(long r100) {
            this.receivedResponseAtMillis = r100;
            return this;
        }

        public Builder removeHeader(String r100) {
            this.headers.removeAll(r100);
            return this;
        }

        public Builder request(Request r100) {
            this.request = r100;
            return this;
        }

        public Builder sentRequestAtMillis(long r100) {
            this.sentRequestAtMillis = r100;
            return this;
        }

        private void checkSupportResponse(String r100, Response r101) {
            if (r101.body != null) goto L18;
            if (r101.networkResponse != null) goto L16;
            if (r101.cacheResponse != null) goto L14;
            if (r101.priorResponse != null) goto L12;
            return;
        L12:
            throw new IllegalArgumentException(r100 + ".priorResponse != null");
        L14:
            throw new IllegalArgumentException(r100 + ".cacheResponse != null");
        L16:
            throw new IllegalArgumentException(r100 + ".networkResponse != null");
        L18:
            throw new IllegalArgumentException(r100 + ".body != null");
        }

        public Builder addHeader(String r100, String r101) {
            this.headers.add(r100, r101);
            return this;
        }

        public Builder header(String r100, String r101) {
            this.headers.set(r100, r101);
            return this;
        }
    }

    public CacheControl cacheControl() {
        CacheControl r100 = this.cacheControl;
        if (r100 != null) goto L7;
        CacheControl r101 = CacheControl.parse(this.headers);
        this.cacheControl = r101;
        return r101;
    L7:
        return r100;
    }

    public List<d> challenges() {
        int r100 = this.code;
        if (r100 != 401) goto L6;
        String r101 = "WWW-Authenticate";
    L8:
        Headers r102 = headers();
        ByteString r103 = evc.e.f474509a;
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L10:
        if (r105 >= r102.size()) goto L77;
        if (r101.equalsIgnoreCase(r102.name(r105)) == false) goto L76;
        Buffer r106 = new Buffer().writeUtf8(r102.value(r105));
    L14:
        Object r107 = null;
        String r108 = null;
    L15:
        if (r108 != null) goto L19;
        evc.e.h(r106);
        r108 = evc.e.d(r106);
        if (r108 == null) goto L76;
    L19:
        boolean r109 = evc.e.h(r106);
        String r110 = evc.e.d(r106);
        if (r110 == null) goto L22;
        int r111 = evc.e.f(r106);
        boolean r112 = evc.e.h(r106);
        if (r109 == true) goto L31;
        if (r112 == true) goto L30;
        if (r106.exhausted() == false) goto L31;
    L30:
        char[] r113 = new char[r111];
        Arrays.fill(r113, com.alipay.sdk.m.n.a.f25612h);
        r104.add(new d(r108, Collections.singletonMap(r107, r110.concat(new String(r113)))));
    L31:
        LinkedHashMap r114 = new LinkedHashMap();
        int r115 = r111 + evc.e.f(r106);
    L32:
        if (r110 != null) goto L37;
        r110 = evc.e.d(r106);
        if (evc.e.h(r106) == true) goto L38;
        r115 = evc.e.f(r106);
    L38:
        r104.add(new d(r108, r114));
        r108 = r110;
    L37:
        if (r115 == 0) goto L38;
        if (r115 > 1) goto L76;
        if (evc.e.h(r106) == true) goto L76;
        if (r106.exhausted() == false) goto L48;
    L64:
        String r116 = r108;
        String r117 = evc.e.d(r106);
    L65:
        if (r117 == null) goto L76;
        if (((String) r114.put(r110, r117)) != null) goto L76;
        if (evc.e.h(r106) == true) goto L75;
        if (r106.exhausted() == false) goto L76;
    L75:
        r108 = r116;
        r107 = null;
        r110 = null;
        goto L32
    L48:
        if (r106.getByte(0) != 34) goto L64;
        if (r106.readByte() != 34) goto L63;
        Buffer r118 = new Buffer();
    L52:
        long r119 = r106.indexOfElement(evc.e.f474509a);
        if (r119 == (-1)) goto L54;
        if (r106.getByte(r119) == 34) goto L57;
        r116 = r108;
        if (r106.size() == (r119 + 1)) goto L60;
        r118.write(r106, r119);
        r106.readByte();
        r118.write(r106, 1);
        r108 = r116;
    L60:
        r117 = null;
        goto L65
    L57:
        r118.write(r106, r119);
        r106.readByte();
        r117 = r118.readUtf8();
        r116 = r108;
        goto L65
    L54:
        r116 = r108;
        goto L60
    L63:
        throw new IllegalArgumentException();
    L22:
        if (r106.exhausted() == false) goto L76;
        r104.add(new d(r108, Collections.emptyMap()));
    L76:
        r105 = r105 + 1;
        goto L10
    L77:
        return r104;
    L6:
        if (r100 != 407) goto L79;
        r101 = "Proxy-Authenticate";
        goto L8
    L79:
        return Collections.emptyList();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r100 = this.body;
        if (r100 == null) goto L7;
        r100.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public boolean isRedirect() {
        int r100 = this.code;
        if (r100 != 307) goto L5;
        return true;
    L5:
        if (r100 == 308) goto L11;
        switch(r100) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
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

    public Builder newBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @Nullable
    public ResponseBody body() {
        return this.body;
    }

    @Nullable
    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public int code() {
        return this.code;
    }

    @Nullable
    public j handshake() {
        return this.handshake;
    }

    public Headers headers() {
        return this.headers;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response networkResponse() {
        return this.networkResponse;
    }

    @Nullable
    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public Response(Builder r100) {
        this.request = r100.request;
        this.protocol = r100.protocol;
        this.code = r100.code;
        this.message = r100.message;
        this.handshake = r100.handshake;
        this.headers = r100.headers.build();
        this.body = r100.body;
        this.networkResponse = r100.networkResponse;
        this.cacheResponse = r100.cacheResponse;
        this.priorResponse = r100.priorResponse;
        this.sentRequestAtMillis = r100.sentRequestAtMillis;
        this.receivedResponseAtMillis = r100.receivedResponseAtMillis;
    }

    @Nullable
    public String header(String r100) {
        return header(r100, null);
    }

    public List<String> headers(String r100) {
        return this.headers.values(r100);
    }

    public ResponseBody peekBody(long r100) throws IOException {
        BufferedSource r101 = this.body.source();
        r101.request(r100);
        Buffer r102 = r101.buffer().m10975clone();
        if (r102.size() <= r100) goto L6;
        Buffer r103 = new Buffer();
        r103.write(r102, r100);
        r102.clear();
        r102 = r103;
    L6:
        return ResponseBody.create(this.body.contentType(), r102.size(), r102);
    }

    @Nullable
    public String header(String r100, @Nullable String r101) {
        String r102 = this.headers.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }
}
