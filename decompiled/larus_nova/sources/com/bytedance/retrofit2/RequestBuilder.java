package com.bytedance.retrofit2;

import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.k;
import okio.BufferedSink;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestBuilder {
    private boolean addCommonParam;

    @Nullable
    private String apiUrl;

    @Nullable
    private TypedOutput body;
    private int commonParamLevel;
    private String contentTypeHeader;
    private final boolean enableRecordFormFields;
    private Object extraInfo;
    private final FormUrlEncodedTypedOutput formBody;
    private final boolean hasBody;

    @Nullable
    private List<Header> headers;
    private int maxLength;
    private String method;

    @Nullable
    private final MultipartTypedOutput multipartBody;

    @Nullable
    private final k.a multipartBuilder;
    private int priorityLevel;

    @Nullable
    private String queryObjectParams;

    @Nullable
    private StringBuilder queryParams;

    @Nullable
    private String relativeUrl;

    @Nullable
    private RequestBody requestBody;
    private final int requestPriorityLevel;
    private boolean responseStreaming;
    private final Endpoint server;
    private final String serviceType;
    private final Map<Class<?>, Object> tags;
    private boolean useRequestBody;

    public static class ContentTypeOverridingRequestBody extends RequestBody {
        private final String contentType;
        private final RequestBody delegate;

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(this.contentType);
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink r100) throws IOException {
            this.delegate.writeTo(r100);
        }

        public ContentTypeOverridingRequestBody(RequestBody r100, String r101) {
            this.delegate = r100;
            this.contentType = r101;
        }
    }

    public static class MimeOverridingTypedOutput extends AbsTypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public String bodyCompressType() {
            TypedOutput r100 = this.delegate;
            if ((r100 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r100).bodyCompressType();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.delegate.fileName();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public byte[] getOriginBody() {
            TypedOutput r100 = this.delegate;
            if ((r100 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r100).getOriginBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public boolean interceptRequestBody() {
            TypedOutput r100 = this.delegate;
            if ((r100 instanceof AbsTypedOutput) == true) goto L5;
            return false;
        L5:
            return ((AbsTypedOutput) r100).interceptRequestBody();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.delegate.length();
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            this.mBodyMd5Stub = this.delegate.md5Stub();
            return this.mBodyMd5Stub;
        }

        public TypedOutput getDelegate() {
            return this.delegate;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.mimeType;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r100) throws IOException {
            this.delegate.writeTo(r100);
        }

        public MimeOverridingTypedOutput(TypedOutput r100, String r101) {
            this.delegate = r100;
            this.mimeType = r101;
        }

        @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
        public TTRequestCompressManager.CompressData compressRequestBody(String r100, String r101, boolean r102) {
            TypedOutput r103 = this.delegate;
            if ((r103 instanceof AbsTypedOutput) == true) goto L5;
            return null;
        L5:
            return ((AbsTypedOutput) r103).compressRequestBody(r100, r101, r102);
        }
    }

    public void useRequestBody() {
        this.useRequestBody = true;
    }

    @Nullable
    public String getApiUrl() {
        return this.apiUrl;
    }

    @Nullable
    public TypedOutput getBody() {
        return this.body;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRelativeUrl() {
        return this.relativeUrl;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public boolean isAddCommonParam() {
        return this.addCommonParam;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public void addPart(k.b r100) {
        this.multipartBuilder.c(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.RequestBuilder] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.retrofit2.mime.TypedOutput] */
    public Request build(ExpandCallback<?> r110) {
        MultipartTypedOutput r100 = this.multipartBody;
        if (r100 != null) goto L5;
    L11:
        ?? r101 = this.server.getUrl();
        if (Platform.squareRetrofitExists() == false) goto L95;
        HttpUrl r102 = HttpUrl.parse(r101);
        if (r102 == null) goto L28;
        if (r102.encodedPath() != null) goto L18;
    L22:
        HttpUrl r103 = r102.resolve(this.relativeUrl);
        if (r103 == null) goto L26;
        r101 = new StringBuilder(r103.toString());
    L46:
        StringBuilder r104 = this.queryParams;
        if (r104 != null) goto L49;
    L56:
        String r105 = this.queryObjectParams;
        if (r105 == null) goto L59;
        r101.append(r105);
    L59:
        this.apiUrl = r101.toString();
        if ((r110 instanceof ExpandCallback) == false) goto L62;
        r110.onAsyncPreRequest(this);
    L62:
        TypedOutput r106 = this.body;
        List<Header> r107 = this.headers;
        RequestBody r108 = this.requestBody;
        ContentTypeOverridingRequestBody r109 = null;
        if (this.useRequestBody == false) goto L76;
        if (r108 != null) goto L71;
        k.a r111 = this.multipartBuilder;
        if (r111 == null) goto L69;
        r108 = r111.d();
        goto L71
    L69:
        if (this.hasBody == false) goto L71;
        r108 = RequestBody.create(null, new byte[0]);
    L71:
        if (r108 == null) goto L75;
        String r112 = this.contentTypeHeader;
        if (r112 == null) goto L75;
        r109 = new ContentTypeOverridingRequestBody(r108, r112);
    L84:
        List<Header> r113 = r107;
        TypedOutput r114 = r106;
    L85:
        RequestBody r115 = r109;
        ?? r116 = r114;
    L86:
        if (r116 != 0) goto L93;
        if (Utils.requiresRequestBody(this.method) == false) goto L93;
        if (this.useRequestBody == true) goto L93;
        r116 = new FormUrlEncodedTypedOutput();
        r116.addField(ContainerPosition.BODY, "null");
    L93:
        return new Request(this.method, this.apiUrl, r113, r116, r115, this.priorityLevel, this.requestPriorityLevel, this.responseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.serviceType, this.tags);
    L75:
        r113 = r107;
        r115 = r108;
        r116 = r106;
        goto L86
    L76:
        String r117 = this.contentTypeHeader;
        if (r117 == null) goto L84;
        if (r106 == null) goto L80;
        r113 = r107;
        r114 = new MimeOverridingTypedOutput(r106, r117);
        goto L85
    L80:
        Header r118 = new Header("Content-Type", r117);
        if (r107 != null) goto L83;
        r107 = Collections.singletonList(r118);
        goto L84
    L83:
        r107.add(r118);
        goto L84
    L49:
        if ('?' != r104.charAt(0)) goto L55;
        String r119 = this.relativeUrl;
        if (r119 == null) goto L55;
        if (r119.indexOf(63) == (-1)) goto L55;
        r104.setCharAt(0, Typography.amp);
    L55:
        r101.append(r104);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r102 + ", Relative: " + this.relativeUrl);
    L18:
        if (r102.encodedPath().length() <= 0) goto L22;
        if (HTTP.URL_DEFAULT.equals(this.relativeUrl) == false) goto L22;
        r101 = newUrlBuilder(r101, this.relativeUrl);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r102 + ", Relative: " + this.relativeUrl);
    L95:
        URI r120 = URI.create(r101);     // Catch: Throwable -> L38
        if (r120.getPath() == null) goto L37;
        if (r120.getPath().length() < 1) goto L37;
        if (HTTP.URL_DEFAULT.equals(this.relativeUrl) == false) goto L37;
        r101 = newUrlBuilder(r101, this.relativeUrl);     // Catch: Throwable -> L38
    L94:
    L37:
        r101 = new StringBuilder(r120.resolve(this.relativeUrl).toString());     // Catch: Throwable -> L38
    L38:
        String r121 = this.relativeUrl;
        if (r121 != null) goto L41;
    L45:
        r101 = newUrlBuilder(r101, this.relativeUrl);
        goto L46
    L41:
        if (r121.startsWith("http://") == false) goto L43;
    L44:
        r101 = new StringBuilder(this.relativeUrl);
        goto L46
    L43:
        if (this.relativeUrl.startsWith("https://") == false) goto L45;
    L5:
        if (r100.getPartCount() != 0) goto L11;
        if (this.useRequestBody == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    public void setAddCommonParam(boolean r100) {
        this.addCommonParam = r100;
    }

    public void setApiUrl(String r100) {
        this.apiUrl = r100;
    }

    public void setBody(TypedOutput r100) {
        this.body = r100;
    }

    public void setCommonParamLevel(int r100) {
        this.commonParamLevel = r100;
    }

    public void setExtraInfo(Object r100) {
        this.extraInfo = r100;
    }

    public void setHeaders(List<Header> r100) {
        this.headers = r100;
    }

    public void setMaxLength(int r100) {
        this.maxLength = r100;
    }

    public void setMethod(String r100) {
        this.method = r100;
    }

    public void setPriorityLevel(int r100) {
        this.priorityLevel = r100;
    }

    public void setQueryObjectParams(String r100) {
        this.queryObjectParams = r100;
    }

    public void setRelativeUrl(Object r100) {
        if (r100 == null) goto L6;
        this.relativeUrl = r100.toString();
        return;
    L6:
        throw new NullPointerException("@Url parameter is null.");
    }

    public void setResponseStreaming(boolean r100) {
        this.responseStreaming = r100;
    }

    public void setBody(RequestBody r100) {
        this.requestBody = r100;
    }

    private StringBuilder newUrlBuilder(String r100, String r101) {
        StringBuilder r102 = new StringBuilder(r100);
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L5;
        r102.deleteCharAt(r102.length() - 1);
    L5:
        r102.append(r101);
        return r102;
    }

    public void addHeader(String r100, String r101) {
        if (r100 == null) goto L13;
        if ("Content-Type".equalsIgnoreCase(r100) == false) goto L7;
        this.contentTypeHeader = r101;
        return;
    L7:
        List r102 = this.headers;
        if (r102 != null) goto L10;
        r102 = new ArrayList(2);
        this.headers = r102;
    L10:
        r102.add(new Header(r100, r101));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void addPart(Headers r100, RequestBody r101) {
        k.a r102 = this.multipartBuilder;
        r102.getClass();
        r102.c(k.b.a(r100, r101));
    }

    public <T> void addTag(Class<? super T> r100, T r101) {
        this.tags.put(r100, r100.cast(r101));
    }

    public void setMethod(String r100, String r101) {
        String r102 = this.method;
        if (r102 == null) goto L7;
        this.method = r102.replace("{" + r100 + i.f25855d, r101);
        return;
    L7:
        throw new AssertionError();
    }

    public void addPart(String r100, TypedOutput r101) {
        this.multipartBody.addPart(r100, r101);
    }

    public void addFormField(String r100, String r101, boolean r102) {
        this.formBody.addField(r100, r102, r101, r102);
    }

    public void addPart(String r100, String r101, TypedOutput r102) {
        this.multipartBody.addPart(r100, r101, r102);
    }

    public void addPathParam(String r100, String r101, boolean r102) {
        String r103 = this.relativeUrl;
        if (r103 == null) goto L19;
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        if (r102 == false) goto L9;
        String r104 = URLEncoder.encode(r101, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");     // Catch: UnsupportedEncodingException -> L11
        this.relativeUrl = this.relativeUrl.replace("{" + r100 + i.f25855d, r104);     // Catch: UnsupportedEncodingException -> L11
    L20:
        return;
    L9:
        this.relativeUrl = r103.replace("{" + r100 + i.f25855d, r101);     // Catch: UnsupportedEncodingException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r100 + "\" value to UTF-8:" + r101, e);
    L15:
        throw new IllegalArgumentException("Path replacement \"" + r100 + "\" value must not be null.");
    L17:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L19:
        throw new AssertionError();
    }

    public void addQueryParam(String r100, String r101, boolean r102) {
        if (r100 == null) goto L27;
        StringBuilder r103 = this.queryParams;     // Catch: UnsupportedEncodingException -> L23
        if (r103 != null) goto L7;
        r103 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.queryParams = r103;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r103.length() <= 0) goto L9;
        char r104 = Typography.amp;
    L10:
        r103.append(r104);     // Catch: UnsupportedEncodingException -> L23
        if (r102 == false) goto L14;
        r100 = URLEncoder.encode(r100, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r102 == false) goto L16;
        r101 = URLEncoder.encode(r101, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r101 != null) goto L18;
    L21:
        r103.append(r100);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r101.isEmpty() == true) goto L21;
        r103.append(r100);     // Catch: UnsupportedEncodingException -> L23
        r103.append(a.f25612h);     // Catch: UnsupportedEncodingException -> L23
        r103.append(r101);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r104 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r100 + "\" value to UTF-8: " + r101, e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public RequestBuilder(String r100, Endpoint r101, @Nullable String r102, @Nullable List<Header> r103, String r104, int r110, int r111, boolean r112, int r113, boolean r114, int r115, Object r116, boolean r117, boolean r118, boolean r119, String r210, boolean r211) {
        this.tags = new LinkedHashMap();
        this.method = r100;
        this.server = r101;
        this.relativeUrl = r102;
        this.contentTypeHeader = r104;
        this.priorityLevel = r110;
        this.requestPriorityLevel = r111;
        this.responseStreaming = r112;
        this.maxLength = r113;
        this.addCommonParam = r114;
        this.commonParamLevel = r115;
        this.extraInfo = r116;
        this.hasBody = r117;
        this.headers = r103;
        this.serviceType = r210;
        this.enableRecordFormFields = r211;
        if (r118 == false) goto L5;
        FormUrlEncodedTypedOutput r105 = new FormUrlEncodedTypedOutput(r211);
        this.formBody = r105;
        this.multipartBody = null;
        this.body = r105;
        this.multipartBuilder = null;
        return;
    L5:
        if (r119 == false) goto L7;
        this.formBody = null;
        MultipartTypedOutput r106 = new MultipartTypedOutput();
        this.multipartBody = r106;
        this.body = r106;
        k.a r107 = new k.a();
        this.multipartBuilder = r107;
        r107.e(k.f523924f);
        return;
    L7:
        this.formBody = null;
        this.multipartBody = null;
        this.multipartBuilder = null;
    }
}
