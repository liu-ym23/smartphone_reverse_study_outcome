package com.bytedance.ee.bear.clip.handlers;

import android.app.Activity;
import at5.f;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
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

/* JADX INFO: loaded from: classes16.dex */
public final class ClipFetchHandler implements f<FetchData, LarkWebView> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f216674e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<List<String>> f216675f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<RemoteFetchUrlConfig> f216676g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f216677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f216678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Call> f216679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f216680d;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FetchData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "params", "", "getParams", "setParams", "file", "Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "getFile", "()Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "setFile", "(Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;)V", ContainerPosition.BODY, "getBody", "setBody", com.alipay.sdk.m.p.e.f25671s, "getMethod", "setMethod", "secretKey", "getSecretKey", "setSecretKey", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void setBody(String r100) {
            this.body = r100;
        }

        public final void setFile(FileInfo r100) {
            this.file = r100;
        }

        public final void setHeaders(Map<String, String> r100) {
            this.headers = r100;
        }

        public final void setMethod(String r100) {
            this.method = r100;
        }

        public final void setParams(Map<String, String> r100) {
            this.params = r100;
        }

        public final void setSecretKey(String r100) {
            this.secretKey = r100;
        }

        public final void setTimeout(long r100) {
            this.timeout = r100;
        }

        public final void setUrl(String r100) {
            this.url = r100;
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

        public final void setCode(int r100) {
            this.code = r100;
        }

        public final void setData(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.data = r100;
        }

        public final void setHeaders(Map<String, String> r100) {
            this.headers = r100;
        }

        public final void setMessage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.message = r100;
        }

        public FetchResult(int r100, String r101, String r102, Map<String, String> r103) {
            Intrinsics.checkNotNullParameter(r101, "message");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.message = r101;
            this.data = r102;
            this.headers = r103;
        }

        public /* synthetic */ FetchResult(int r100, String r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$FileInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "paramName", "getParamName", "setParamName", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public final void setFileName(String r100) {
            this.fileName = r100;
        }

        public final void setParamName(String r100) {
            this.paramName = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @AppConfig(key = "ccm_mobile_filter_url_config")
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/clip/handlers/ClipFetchHandler$RemoteFetchUrlConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "filterUrls", "", "", "<init>", "(Ljava/util/List;)V", "getFilterUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoteFetchUrlConfig implements NonProguard {
        private final List<String> filterUrls;

        /* JADX WARN: Multi-variable type inference failed */
        public RemoteFetchUrlConfig() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RemoteFetchUrlConfig copy$default(RemoteFetchUrlConfig r100, List r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.filterUrls;
        L6:
            return r100.copy(r101);
        }

        public final List<String> component1() {
            return this.filterUrls;
        }

        public final RemoteFetchUrlConfig copy(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "filterUrls");
            return new RemoteFetchUrlConfig(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RemoteFetchUrlConfig) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.filterUrls, ((RemoteFetchUrlConfig) r100).filterUrls) == true) goto L11;
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

        public RemoteFetchUrlConfig(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "filterUrls");
            this.filterUrls = r100;
        }

        public /* synthetic */ RemoteFetchUrlConfig(List r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = new ArrayList();
        L5:
            this(r100);
        }
    }

    public static final class a {
    }

    @Override // at5.f
    public final boolean shouldRunInUIThread() {
        return true;
    }

    static {
        f216674e = "https://" + ((b0) org.koin.java.a.c(b0.class, null, null, 6)).p();
        f216675f = LazyKt.lazy(ClipFetchHandler$Companion$validUrlList$2.INSTANCE);
        f216676g = LazyKt.lazy(ClipFetchHandler$Companion$remoteFetchUrlConfig$2.INSTANCE);
    }

    public ClipFetchHandler(String r100) {
        Intrinsics.checkNotNullParameter(r100, "secretKey");
        this.f216677a = r100;
        LarkContext.getApplication();
        this.f216678b = new i(j.a.f217090a);
        this.f216679c = new ConcurrentLinkedQueue();
        this.f216680d = new CompositeDisposable();
    }

    public static boolean b(FileInfo r100) {
        if (r100 == null) goto L22;
        String r101 = r100.getFileName();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L23;
        String r103 = r100.getTitle();
        if (r103 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (r103.length() == 0) goto L18;
        r104 = false;
        goto L19
    L23:
        return false;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    L22:
        return false;
    }

    @Override // at5.f
    public final void a(Object r110, at5.d r111, String r112, LarkWebView r210) {
        FetchData r100 = (FetchData) r110;
        Intrinsics.checkNotNullParameter(r111, "callback");
        tt5.a.h("DocsClip#ClipFetchHandler", "fetch data = " + r100);
        if (r100 == null) goto L5;
        String r101 = r100.getUrl();
    L6:
        if (r101 == null) goto L43;
        String r102 = r100.getUrl();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L43;
        if (r210 != null) goto L18;
        tt5.a.d("DocsClip#ClipFetchHandler", "webView is null!");
        return;
    L18:
        int r104 = n.f243167a;
        Activity r105 = n.g(r210.getContext());
        if (r105 != null) goto L21;
    L42:
        tt5.a.d("DocsClip#ClipFetchHandler", "activity is null or finished or destroyed!");
        return;
    L21:
        if (r105.isFinishing() == true) goto L42;
        if (r105.isDestroyed() == true) goto L42;
        if (Intrinsics.areEqual(r100.getSecretKey(), this.f216677a) == true) goto L28;
        tt5.a.d("DocsClip#ClipFetchHandler", "secretKey not match! expected = " + this.f216677a + ", actually = " + r100.getSecretKey());
        return;
    L28:
        String r106 = r100.getUrl();
        Intrinsics.checkNotNull(r106);
        if (CollectionsKt.contains(f216675f.getValue(), r100.getUrl()) == true) goto L31;
        tt5.a.d("DocsClip#ClipFetchHandler", "url is not valid!");
        return;
    L31:
        String r107 = r100.getUrl();
        if (r107 != null) goto L35;
        r107 = "";
    L35:
        if (StringsKt.startsWith$default(r107, "http", false, 2, null) == true) goto L37;
        r100.setUrl(f216674e + r100.getUrl());
    L37:
        long r108 = System.currentTimeMillis();
        if (j.a.f217090a.getNetworkState().a() == true) goto L40;
        tt5.a.k("DocsClip#ClipFetchHandler", "sendRequestIfNeed not connected ");
        Flowable r109 = Flowable.just(new FetchResult(-1, "no_network", SliceInitService.DEFAULT_SWITCH, null, 8, null));
    L41:
        this.f216680d.add(r109.subscribe(new com.bytedance.ee.bear.clip.handlers.a(r108, r100, r106, r111), new b(r100, r111)));
        return;
    L40:
        r109 = Flowable.create(new c(r100, this), BackpressureStrategy.BUFFER);
        goto L41
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
    L43:
        tt5.a.d("DocsClip#ClipFetchHandler", "url is empty!");
        return;
    L5:
        r101 = null;
        goto L6
    }
}
