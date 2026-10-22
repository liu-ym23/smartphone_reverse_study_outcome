package com.bytedance.retrofit2.client;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.OptConfig;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    public static final String KEY_BYPASS_DISPATCH = "x-tt-bypass-dp";
    public static final String KEY_BYPASS_OKHTTP_COOKIE = "x-metasec-bypass-okhttp-cookie";
    public static final String KEY_BYPASS_TTNET_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    public static final String KEY_BYPASS_TTNET_FEATURES = "x-metasec-bypass-ttnet-features";
    private final boolean addCommonParam;
    private final TypedOutput body;
    private int commonParamLevel;
    private Object extraInfo;
    private final List<Header> headers;
    private boolean isBodyEncryptEnabled;
    private boolean isQueryEncryptEnabled;
    private final int maxLength;
    private final String method;
    private RetrofitMetrics metrics;
    private final int priorityLevel;
    private int queryFilterPriority;
    private final RequestBody requestBody;
    private final int requestPriorityLevel;
    private final boolean responseStreaming;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private URI uri;
    private final String url;

    public static class Builder {
        boolean addCommonParam;
        TypedOutput body;
        int commonParamLevel;
        Object extraInfo;
        List<Header> headers;
        boolean isBodyEncryptEnabled;
        boolean isQueryEncryptEnabled;
        int maxLength;
        String method;
        RetrofitMetrics metrics;
        int priorityLevel;
        RequestBody requestBody;
        int requestPriorityLevel;
        boolean responseStreaming;
        String serviceType;
        Map<Class<?>, Object> tags;
        String url;

        public Request build() {
            if (this.url == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder() {
            this.method = "GET";
        }

        public Builder(Request r100) {
            this.method = Request.access$000(r100);
            this.url = Request.access$100(r100);
            LinkedList r101 = new LinkedList();
            this.headers = r101;
            r101.addAll(Request.access$200(r100));
            this.body = Request.access$300(r100);
            this.requestBody = Request.access$400(r100);
            this.priorityLevel = Request.access$500(r100);
            this.requestPriorityLevel = Request.access$600(r100);
            this.responseStreaming = Request.access$700(r100);
            this.maxLength = Request.access$800(r100);
            this.addCommonParam = Request.access$900(r100);
            this.commonParamLevel = Request.access$1000(r100);
            this.extraInfo = Request.access$1100(r100);
            this.serviceType = Request.access$1200(r100);
            this.metrics = Request.access$1300(r100);
            this.tags = Request.access$1400(r100);
            this.isQueryEncryptEnabled = Request.access$1500(r100);
            this.isBodyEncryptEnabled = Request.access$1600(r100);
        }

        public Builder addCommonParam(boolean r100) {
            this.addCommonParam = r100;
            return this;
        }

        public Builder delete(TypedOutput r100) {
            return method("DELETE", r100);
        }

        public Builder headers(List<Header> r100) {
            this.headers = r100;
            return this;
        }

        public Builder maxLength(int r100) {
            this.maxLength = r100;
            return this;
        }

        public Builder patch(TypedOutput r100) {
            return method("PATCH", r100);
        }

        public Builder post(TypedOutput r100) {
            return method("POST", r100);
        }

        public Builder priorityLevel(int r100) {
            this.priorityLevel = r100;
            return this;
        }

        public Builder put(TypedOutput r100) {
            return method("PUT", r100);
        }

        public Builder requestPriorityLevel(int r100) {
            this.requestPriorityLevel = r100;
            return this;
        }

        public Builder responseStreaming(boolean r100) {
            this.responseStreaming = r100;
            return this;
        }

        public Builder serviceType(String r100) {
            this.serviceType = r100;
            return this;
        }

        public Builder setExtraInfo(Object r100) {
            this.extraInfo = r100;
            return this;
        }

        public Builder tag(Object r100) {
            return tag(Object.class, r100);
        }

        public Builder url(String r100) {
            if (r100 == null) goto L6;
            this.url = r100;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.retrofit2.mime.TypedOutput] */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
        public Builder method(String r100, TypedOutput r101) {
            if (r100 == null) goto L20;
            if (r100.length() == 0) goto L18;
            if (r101 != 0) goto L7;
        L11:
            if (r101 == 0) goto L13;
        L15:
            this.method = r100;
            this.body = r101;
            return this;
        L13:
            if (Utils.requiresRequestBody(r100) == false) goto L15;
            r101 = new FormUrlEncodedTypedOutput();
            r101.addField(ContainerPosition.BODY, "null");
            goto L15
        L7:
            if (Utils.permitsRequestBody(r100) == true) goto L11;
            throw new IllegalArgumentException("method " + r100 + " must not have a request body.");
        L18:
            throw new IllegalArgumentException("method.length() == 0");
        L20:
            throw new NullPointerException("method == null");
        }

        public <T> Builder tag(Class<? super T> r100, T r101) {
            if (r100 == null) goto L11;
            if (this.tags != null) goto L6;
            this.tags = new HashMap();
        L6:
            if (r101 != null) goto L8;
            this.tags.remove(r100);
        L9:
            return this;
        L8:
            this.tags.put(r100, r100.cast(r101));
            goto L9
        L11:
            throw new NullPointerException("type == null");
        }
    }

    public TypedOutput getBody() {
        RequestBody r100 = this.requestBody;
        if (r100 == null) goto L7;
        return Utils.convert(r100);
    L7:
        return this.body;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Object tag() {
        return tag(Object.class);
    }

    private URI getUri() {
        if (OptConfig.isEnableRequestOpt() == false) goto L18;
        if (this.uri != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.uri != null) goto L10;
        this.uri = safeCreateUri(this.url);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.uri;
    L18:
        return safeCreateUri(this.url);
    }

    public String getHost() {
        URI r100 = getUri();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHost();
    }

    public String getPath() {
        URI r100 = getUri();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPath();
    }

    public boolean isBypassDispatch() {
        List<Header> r100 = headers(KEY_BYPASS_DISPATCH);
        if (r100 != null) goto L5;
    L10:
        return false;
    L5:
        if (r100.size() <= 0) goto L10;
        if ("1".equals(((Header) ListProtector.get(r100, 0)).getValue()) == false) goto L10;
        return true;
    }

    public boolean isPureRequest() {
        List<Header> r100 = headers(KEY_BYPASS_TTNET_FEATURES);
        if (r100 != null) goto L5;
    L10:
        return false;
    L5:
        if (r100.size() <= 0) goto L10;
        if ("1".equals(((Header) ListProtector.get(r100, 0)).getValue()) == false) goto L10;
        return true;
    }

    public int getCommonParamLevel() {
        return this.commonParamLevel;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getMethod() {
        return this.method;
    }

    public RetrofitMetrics getMetrics() {
        return this.metrics;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getQueryFilterPriority() {
        return this.queryFilterPriority;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    public int getRequestPriorityLevel() {
        return this.requestPriorityLevel;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isBodyEncryptEnabled() {
        return this.isBodyEncryptEnabled;
    }

    public boolean isQueryEncryptEnabled() {
        return this.isQueryEncryptEnabled;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public Request(Builder r100) {
        this.queryFilterPriority = 0;
        String r101 = r100.url;
        if (r101 == null) goto L15;
        this.url = r101;
        String r102 = r100.method;
        if (r102 == null) goto L13;
        this.method = r102;
        if (r100.headers != null) goto L9;
        this.headers = Collections.emptyList();
    L10:
        this.body = r100.body;
        this.requestBody = r100.requestBody;
        this.priorityLevel = r100.priorityLevel;
        this.requestPriorityLevel = r100.requestPriorityLevel;
        this.responseStreaming = r100.responseStreaming;
        this.maxLength = r100.maxLength;
        this.addCommonParam = r100.addCommonParam;
        this.commonParamLevel = r100.commonParamLevel;
        this.extraInfo = r100.extraInfo;
        this.serviceType = r100.serviceType;
        this.metrics = r100.metrics;
        this.tags = r100.tags;
        this.isQueryEncryptEnabled = r100.isQueryEncryptEnabled;
        this.isBodyEncryptEnabled = r100.isBodyEncryptEnabled;
        return;
    L9:
        this.headers = Collections.unmodifiableList(new ArrayList(r100.headers));
        goto L10
    L13:
        throw new NullPointerException("Method must not be null.");
    L15:
        throw new NullPointerException("URL must not be null.");
    }

    public static /* synthetic */ String access$000(Request r100) {
        return r100.method;
    }

    public static /* synthetic */ String access$100(Request r100) {
        return r100.url;
    }

    public static /* synthetic */ int access$1000(Request r100) {
        return r100.commonParamLevel;
    }

    public static /* synthetic */ Object access$1100(Request r100) {
        return r100.extraInfo;
    }

    public static /* synthetic */ String access$1200(Request r100) {
        return r100.serviceType;
    }

    public static /* synthetic */ RetrofitMetrics access$1300(Request r100) {
        return r100.metrics;
    }

    public static /* synthetic */ Map access$1400(Request r100) {
        return r100.tags;
    }

    public static /* synthetic */ boolean access$1500(Request r100) {
        return r100.isQueryEncryptEnabled;
    }

    public static /* synthetic */ boolean access$1600(Request r100) {
        return r100.isBodyEncryptEnabled;
    }

    public static /* synthetic */ List access$200(Request r100) {
        return r100.headers;
    }

    public static /* synthetic */ TypedOutput access$300(Request r100) {
        return r100.body;
    }

    public static /* synthetic */ RequestBody access$400(Request r100) {
        return r100.requestBody;
    }

    public static /* synthetic */ int access$500(Request r100) {
        return r100.priorityLevel;
    }

    public static /* synthetic */ int access$600(Request r100) {
        return r100.requestPriorityLevel;
    }

    public static /* synthetic */ boolean access$700(Request r100) {
        return r100.responseStreaming;
    }

    public static /* synthetic */ int access$800(Request r100) {
        return r100.maxLength;
    }

    public static /* synthetic */ boolean access$900(Request r100) {
        return r100.addCommonParam;
    }

    private static URI createUriWithOutQuery(String r100) throws RuntimeException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L18;
        int r101 = r100.indexOf("?");     // Catch: Exception -> L11
        if (r101 <= 0) goto L9;
        r100 = r100.substring(0, r101);     // Catch: Exception -> L11
    L9:
        return URI.create(r100);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    private static URI safeCreateUri(String r100) throws RuntimeException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L17;
        return new URI(r100);
    L8:
        return URI.create(r100.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r100);
    L17:
        return null;
    }

    public Header getFirstHeader(String r100) {
        if (r100 == null) goto L13;
        List<Header> r101 = this.headers;
        if (r101 == null) goto L13;
        Iterator<Header> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Header r103 = r102.next();
        if (r100.equalsIgnoreCase(r103.getName()) == false) goto L9;
        return r103;
    L13:
        return null;
    }

    public List<Header> headers(String r100) {
        ArrayList r101 = null;
        if (r100 == null) goto L15;
        List<Header> r102 = this.headers;
        if (r102 == null) goto L15;
        Iterator<Header> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        Header r104 = r103.next();
        if (r100.equalsIgnoreCase(r104.getName()) == false) goto L9;
        if (r101 != null) goto L14;
        r101 = new ArrayList();
    L14:
        r101.add(r104);
    L15:
        return r101;
    }

    public void setBodyEncryptEnabled(boolean r100) {
        this.isBodyEncryptEnabled = r100;
    }

    public void setCommonParamLevel(int r100) {
        this.commonParamLevel = r100;
    }

    public void setExtraInfo(Object r100) {
        this.extraInfo = r100;
    }

    public void setMetrics(RetrofitMetrics r100) {
        this.metrics = r100;
    }

    public void setQueryEncryptEnabled(boolean r100) {
        this.isQueryEncryptEnabled = r100;
    }

    public void setQueryFilterPriority(int r100) {
        this.queryFilterPriority = r100;
    }

    public <T> T tag(Class<? extends T> r100) {
        Map<Class<?>, Object> r101 = this.tags;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r100.cast(r101.get(r100));
    }

    public Request(String r110, String r111, List<Header> r112, TypedOutput r113, int r210, boolean r211, int r212, boolean r213, Object r214) {
        this(r110, r111, r112, r113, null, r210, 3, r211, r212, r213, 0, r214, "", null);
    }

    public Request(String r100, String r101, List<Header> r102, TypedOutput r103, RequestBody r104, int r105, int r106, boolean r107, int r110, boolean r111, int r112, Object r113, String r114, Map<Class<?>, Object> r115) {
        this.queryFilterPriority = 0;
        if (r100 == null) goto L14;
        if (r101 == null) goto L12;
        this.method = r100;
        this.url = r101;
        if (r102 != null) goto L8;
        this.headers = Collections.emptyList();
    L9:
        this.body = r103;
        this.requestBody = r104;
        this.priorityLevel = r105;
        this.requestPriorityLevel = r106;
        this.responseStreaming = r107;
        this.maxLength = r110;
        this.addCommonParam = r111;
        this.commonParamLevel = r112;
        this.extraInfo = r113;
        this.serviceType = r114;
        this.tags = r115;
        return;
    L8:
        this.headers = Collections.unmodifiableList(new ArrayList(r102));
        goto L9
    L12:
        throw new NullPointerException("URL must not be null.");
    L14:
        throw new NullPointerException("Method must not be null.");
    }
}
