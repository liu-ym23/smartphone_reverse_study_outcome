package okhttp3;

import com.alibaba.gaiax.render.view.basic.GXImageView;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Request {

    @Nullable
    final RequestBody body;

    @Nullable
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final HttpUrl originUrl;
    final Map<Class<?>, Object> tags;
    final HttpUrl url;

    public static class Builder {

        @Nullable
        RequestBody body;
        Headers.Builder headers;
        String method;

        @Nullable
        HttpUrl originUrl;
        Map<Class<?>, Object> tags;

        @Nullable
        HttpUrl url;

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public Builder delete() {
            return delete(cvc.c.f465516d);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder() {
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request r100) {
            this.tags = Collections.emptyMap();
            this.url = r100.url;
            this.method = r100.method;
            this.body = r100.body;
            if (r100.tags.isEmpty() == false) goto L5;
            Map<Class<?>, Object> r101 = Collections.emptyMap();
        L6:
            this.tags = r101;
            this.headers = r100.headers.newBuilder();
            this.originUrl = r100.originUrl;
            return;
        L5:
            r101 = new LinkedHashMap(r100.tags);
            goto L6
        }

        public Builder cacheControl(CacheControl r100) {
            String r101 = r100.toString();
            if (r101.isEmpty() == false) goto L7;
            return removeHeader("Cache-Control");
        L7:
            return header("Cache-Control", r101);
        }

        public Builder delete(@Nullable RequestBody r100) {
            return method("DELETE", r100);
        }

        public Builder headers(Headers r100) {
            this.headers = r100.newBuilder();
            return this;
        }

        public Builder originUrl(String r100) {
            if (r100 == null) goto L12;
            if (r100.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            r100 = GXImageView.NET_HTTP_PREFIX + r100.substring(3);
        L10:
            return originUrl(HttpUrl.get(r100));
        L7:
            if (r100.regionMatches(true, 0, "wss:", 0, 4) == false) goto L10;
            r100 = GXImageView.NET_HTTPS_PREFIX + r100.substring(4);
            goto L10
        L12:
            throw new NullPointerException("url == null");
        }

        public Builder patch(RequestBody r100) {
            return method("PATCH", r100);
        }

        public Builder post(RequestBody r100) {
            return method("POST", r100);
        }

        public Builder put(RequestBody r100) {
            return method("PUT", r100);
        }

        public Builder removeHeader(String r100) {
            this.headers.removeAll(r100);
            return this;
        }

        public Builder tag(@Nullable Object r100) {
            return tag(Object.class, r100);
        }

        public Builder url(String r100) {
            if (r100 == null) goto L12;
            if (r100.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            r100 = GXImageView.NET_HTTP_PREFIX + r100.substring(3);
        L10:
            return url(HttpUrl.get(r100));
        L7:
            if (r100.regionMatches(true, 0, "wss:", 0, 4) == false) goto L10;
            r100 = GXImageView.NET_HTTPS_PREFIX + r100.substring(4);
            goto L10
        L12:
            throw new NullPointerException("url == null");
        }

        public Builder originUrl(HttpUrl r100) {
            if (r100 == null) goto L6;
            this.originUrl = r100;
            return this;
        L6:
            throw new NullPointerException("originUrl == null");
        }

        public Builder url(URL r100) {
            if (r100 == null) goto L6;
            return url(HttpUrl.get(r100.toString()));
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder url(HttpUrl r100) {
            if (r100 == null) goto L6;
            this.url = r100;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public Builder addHeader(String r100, String r101) {
            this.headers.add(r100, r101);
            return this;
        }

        public Builder header(String r100, String r101) {
            this.headers.set(r100, r101);
            return this;
        }

        public Builder method(String r100, @Nullable RequestBody r101) {
            if (r100 == null) goto L23;
            if (r100.length() == 0) goto L21;
            if (r101 != null) goto L8;
        L12:
            if (r101 == null) goto L14;
        L18:
            this.method = r100;
            this.body = r101;
            return this;
        L14:
            if (evc.f.c(r100) == false) goto L18;
            throw new IllegalArgumentException("method " + r100 + " must have a request body.");
        L8:
            if (evc.f.b(r100) == true) goto L12;
            throw new IllegalArgumentException("method " + r100 + " must not have a request body.");
        L21:
            throw new IllegalArgumentException("method.length() == 0");
        L23:
            throw new NullPointerException("method == null");
        }

        public <T> Builder tag(Class<? super T> r100, @Nullable T r101) {
            if (r100 == null) goto L11;
            if (r101 != null) goto L6;
            this.tags.remove(r100);
        L9:
            return this;
        L6:
            if (this.tags.isEmpty() == false) goto L8;
            this.tags = new LinkedHashMap();
        L8:
            this.tags.put(r100, r100.cast(r101));
            goto L9
        L11:
            throw new NullPointerException("type == null");
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

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    public Headers headers() {
        return this.headers;
    }

    public String method() {
        return this.method;
    }

    public HttpUrl originUrl() {
        return this.originUrl;
    }

    public HttpUrl url() {
        return this.url;
    }

    public Request(Builder r100) {
        this.url = r100.url;
        this.originUrl = r100.originUrl;
        this.method = r100.method;
        this.headers = r100.headers.build();
        this.body = r100.body;
        Map<Class<?>, Object> r101 = r100.tags;
        byte[] r102 = cvc.c.f465513a;
        if (r101.isEmpty() == false) goto L5;
        Map<Class<?>, Object> r103 = Collections.emptyMap();
    L6:
        this.tags = r103;
        return;
    L5:
        r103 = Collections.unmodifiableMap(new LinkedHashMap(r101));
        goto L6
    }

    @Nullable
    public String header(String r100) {
        return this.headers.get(r100);
    }

    public List<String> headers(String r100) {
        return this.headers.values(r100);
    }

    @Nullable
    public <T> T tag(Class<? extends T> r100) {
        return r100.cast(this.tags.get(r100));
    }
}
