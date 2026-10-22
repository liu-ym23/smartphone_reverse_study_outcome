package com.bytedance.ee.bear.clip.handlers;

import android.app.Activity;
import at5.f;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.utils.LarkContext;
import f25.i;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ClipFetchHandler implements f<FetchData, LarkWebView> {
    public static final String e = null;
    public static final Lazy<List<String>> f = null;
    public static final Lazy<RemoteFetchUrlConfig> g = null;
    public final String a;
    public final i b;
    public final ConcurrentLinkedQueue<Call> c;
    public final CompositeDisposable d;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FetchData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "params", "", "getParams", "setParams", "file", "Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "getFile", "()Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "setFile", "(Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;)V", "body", "getBody", "setBody", "method", "getMethod", "setMethod", "secretKey", "getSecretKey", "setSecretKey", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FetchData implements NonProguard {
        private String body;
        private FileInfo file;
        private Map<String, String> headers;
        private String method;
        private Map<String, String> params;
        private String secretKey;
        private long timeout;
        private String url;

        public FetchData() {
        }

        public String toString() {
            return "{url='" + this.url + "', method='" + this.method + "', headers=" + this.headers + ", params=" + this.params + ", file=" + this.file + ", method=" + this.method + ", secretKey='" + this.secretKey + "', timeout=" + this.timeout + '}';
        }

        public final String getBody() {
            return this.body;
        }

        public final FileInfo getFile() {
            return this.file;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getMethod() {
            return this.method;
        }

        public final Map<String, String> getParams() {
            return this.params;
        }

        public final String getSecretKey() {
            return this.secretKey;
        }

        public final long getTimeout() {
            return this.timeout;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setBody(String r1) {
            this.body = r1;
        }

        public final void setFile(FileInfo r1) {
            this.file = r1;
        }

        public final void setHeaders(Map<String, String> r1) {
            this.headers = r1;
        }

        public final void setMethod(String r1) {
            this.method = r1;
        }

        public final void setParams(Map<String, String> r1) {
            this.params = r1;
        }

        public final void setSecretKey(String r1) {
            this.secretKey = r1;
        }

        public final void setTimeout(long r1) {
            this.timeout = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FetchResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "code", "", "message", "", "data", "headers", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getData", "setData", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FetchResult implements NonProguard {
        private int code;
        private String data;
        private Map<String, String> headers;
        private String message;

        public FetchResult() {
            this(0, null, null, null, 15, null);
        }

        public String toString() {
            return "FetchResult(code=" + this.code + ", message='" + this.message + "', data='" + this.data + "', headers=" + this.headers + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final String getData() {
            return this.data;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setCode(int r1) {
            this.code = r1;
        }

        public final void setData(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.data = r2;
        }

        public final void setHeaders(Map<String, String> r1) {
            this.headers = r1;
        }

        public final void setMessage(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.message = r2;
        }

        public FetchResult(int r2, String r3, String r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "data");
            this.code = r2;
            this.message = r3;
            this.data = r4;
            this.headers = r5;
        }

        public /* synthetic */ FetchResult(int r2, String r3, String r4, Map r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "paramName", "getParamName", "setParamName", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileInfo implements NonProguard {
        private String fileName;
        private String paramName;
        private String title;

        public FileInfo() {
        }

        public String toString() {
            return "FileInfo(fileName=" + this.fileName + ", title = " + this.title + ", paramName=" + this.paramName + ')';
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getParamName() {
            return this.paramName;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setFileName(String r1) {
            this.fileName = r1;
        }

        public final void setParamName(String r1) {
            this.paramName = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }
    }

    @AppConfig(key = "ccm_mobile_filter_url_config")
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$RemoteFetchUrlConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "filterUrls", "", "", "<init>", "(Ljava/util/List;)V", "getFilterUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoteFetchUrlConfig implements NonProguard {
        private final List<String> filterUrls;

        public RemoteFetchUrlConfig() {
            List r0 = null;
            this(r0, 1, r0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoteFetchUrlConfig copy$default(RemoteFetchUrlConfig r0, List r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.filterUrls;
        L6:
            return r0.copy(r1);
        }

        public final List<String> component1() {
            return this.filterUrls;
        }

        public final RemoteFetchUrlConfig copy(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "filterUrls");
            return new RemoteFetchUrlConfig(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof RemoteFetchUrlConfig) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.filterUrls, ((RemoteFetchUrlConfig) r4).filterUrls) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.filterUrls.hashCode();
        }

        public String toString() {
            return "RemoteFetchUrlConfig(filterUrls=" + this.filterUrls + ')';
        }

        public final List<String> getFilterUrls() {
            return this.filterUrls;
        }

        public RemoteFetchUrlConfig(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "filterUrls");
            this.filterUrls = r2;
        }

        public /* synthetic */ RemoteFetchUrlConfig(List r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = new ArrayList();
        L5:
            this(r1);
        }
    }

    public static final class a {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    static {
        e = "https://" + ((b0) org.koin.java.a.c(b0.class, null, null, 6)).p();
        f = LazyKt.lazy(ClipFetchHandler$Companion$validUrlList$2.INSTANCE);
        g = LazyKt.lazy(ClipFetchHandler$Companion$remoteFetchUrlConfig$2.INSTANCE);
    }

    public ClipFetchHandler(String r2) {
        Intrinsics.checkNotNullParameter(r2, "secretKey");
        this.a = r2;
        LarkContext.getApplication();
        this.b = new i(j.a.a);
        this.c = new ConcurrentLinkedQueue();
        this.d = new CompositeDisposable();
    }

    public static boolean b(FileInfo r3) {
        if (r3 == null) goto L22;
        String r1 = r3.getFileName();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L23;
        String r4 = r3.getTitle();
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (r4.length() == 0) goto L18;
        r5 = false;
        goto L19
    L23:
        return false;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L22:
        return false;
    }

    public final void a(Object r17, at5.d r18, String r19, LarkWebView r20) {
        FetchData r8 = (FetchData) r17;
        Intrinsics.checkNotNullParameter(r18, "callback");
        tt5.a.h("DocsClip#ClipFetchHandler", "fetch data = " + r8);
        if (r8 == null) goto L5;
        String r3 = r8.getUrl();
    L6:
        if (r3 == null) goto L43;
        String r4 = r8.getUrl();
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L43;
        if (r20 != null) goto L18;
        tt5.a.d("DocsClip#ClipFetchHandler", "webView is null!");
        return;
    L18:
        int r6 = n.a;
        Activity r7 = n.g(r20.getContext());
        if (r7 != null) goto L21;
    L42:
        tt5.a.d("DocsClip#ClipFetchHandler", "activity is null or finished or destroyed!");
        return;
    L21:
        if (r7.isFinishing() == true) goto L42;
        if (r7.isDestroyed() == true) goto L42;
        if (Intrinsics.areEqual(r8.getSecretKey(), this.a) == true) goto L28;
        tt5.a.d("DocsClip#ClipFetchHandler", "secretKey not match! expected = " + this.a + ", actually = " + r8.getSecretKey());
        return;
    L28:
        String r9 = r8.getUrl();
        Intrinsics.checkNotNull(r9);
        if (CollectionsKt.contains((List) f.getValue(), r8.getUrl()) == true) goto L31;
        tt5.a.d("DocsClip#ClipFetchHandler", "url is not valid!");
        return;
    L31:
        String r10 = r8.getUrl();
        if (r10 != null) goto L35;
        r10 = "";
    L35:
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == true) goto L37;
        r8.setUrl(e + r8.getUrl());
    L37:
        long r11 = System.currentTimeMillis();
        if (j.a.a.getNetworkState().a() == true) goto L40;
        tt5.a.k("DocsClip#ClipFetchHandler", "sendRequestIfNeed not connected ");
        Flowable r1 = Flowable.just(new FetchResult(-1, "no_network", "{}", null, 8, null));
    L41:
        this.d.add(r1.subscribe(new com.bytedance.ee.bear.clip.handlers.a(r11, r8, r9, r18), new b(r8, r18)));
        return;
    L40:
        r1 = Flowable.create(new c(r8, this), BackpressureStrategy.BUFFER);
        goto L41
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
    L43:
        tt5.a.d("DocsClip#ClipFetchHandler", "url is empty!");
        return;
    L5:
        r3 = null;
        goto L6
    }
}
