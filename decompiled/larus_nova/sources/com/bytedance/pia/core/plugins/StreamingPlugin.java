package com.bytedance.pia.core.plugins;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.d;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import i47.e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import r47.m;
import s47.l;
import s47.n;

/* JADX INFO: loaded from: classes21.dex */
public class StreamingPlugin extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f266271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f266272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f266273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f266274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f266275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicReference<WebMessagePort> f266276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<String> f266277i;

    public static class Module extends JSModule {
        private static final String CHUNK_END_MARK = "<!-- chunk end -->";
        public static final String NAME = "StreamingModule";
        private String chunkCache;
        private final StreamingPlugin plugin;

        @JSMethod
        public void finish() {
        }

        @JSMethod
        public void appendBody(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            int r101 = r100.lastIndexOf(CHUNK_END_MARK);
            if (r101 != (-1)) goto L9;
            this.chunkCache += r100;
            return;
        L9:
            StreamingPlugin r102 = this.plugin;
            String r103 = this.chunkCache + r100.substring(0, r101);
            monitor-enter(r102);
        L22:
            th = move-exception;
            throw th;
        L12:
            if (r102.f266275g == false) goto L16;
            monitor-exit(r102);
        L20:
            this.chunkCache = r100.substring(r101 + 18);
            return;
        L16:
            if (r102.f266274f == false) goto L18;
            r102.f266277i.a(r103);     // Catch: Throwable -> L22
        L19:
            monitor-exit(r102);
            goto L20
        L18:
            r102.f266273e += r103;     // Catch: Throwable -> L22
            r102.f266272d.countDown();     // Catch: Throwable -> L22
            goto L19
        }

        @JSMethod
        public void appendHeaders(ReadableMap r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            HashMap r101 = new HashMap();
            ReadableMapKeySetIterator r102 = r100.keySetIterator();
        L6:
            if (r102.hasNextKey() == false) goto L10;
            String r103 = r102.nextKey();
            if (r100.getType(r103) != ReadableType.String) goto L6;
            r101.put(r103, r100.getString(r103));
            goto L6
        L10:
            StreamingPlugin r104 = this.plugin;
            monitor-enter(r104);
        L22:
            th = move-exception;
            throw th;
        L13:
            if (r104.f266275g == false) goto L17;
            monitor-exit(r104);
            return;
        L17:
            if (r104.f266274f == false) goto L19;
            d.c("[Streaming] Can't append headers after responded!");     // Catch: Throwable -> L22
        L20:
            monitor-exit(r104);
            return;
        L19:
            ((HashMap) r104.f266271c).putAll(r101);     // Catch: Throwable -> L22
            goto L20
        }

        public Module(Context r100, Object r101) {
            super(r100, r101);
            this.chunkCache = "";
            this.plugin = (StreamingPlugin) r101;
        }
    }

    public static class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f266278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f266279b;

        @Override // i47.e
        public final String getEncoding() {
            return "UTF-8";
        }

        @Override // i47.e
        public final String getMimeType() {
            return "text/html";
        }

        @Override // i47.e
        public final String getReasonPhrase() {
            return "OK";
        }

        @Override // i47.e
        public final int getStatusCode() {
            return 200;
        }

        @Override // i47.e
        public final InputStream getData() {
            return new ByteArrayInputStream(this.f266279b.getBytes());
        }

        @Override // i47.e
        public final LoadFrom a() {
            return LoadFrom.Online;
        }

        @Override // i47.e
        public final Map<String, String> getHeaders() {
            return this.f266278a;
        }

        public a(Map<String, String> r100, String r101) {
            if (r100 == null) goto L5;
            this.f266278a = new HashMap(r100);
        L6:
            boolean r102 = true;
            if (r101.lastIndexOf("</body>") == (-1)) goto L9;
            boolean r103 = true;
        L11:
            if (r101.lastIndexOf("</html>") != (-1)) goto L14;
            r102 = false;
        L14:
            if (r103 == true) goto L17;
            if (r102 == true) goto L17;
            this.f266279b = r101.concat("</body></html>");
            return;
        L17:
            if (r102 == true) goto L19;
            this.f266279b = r101.concat("</html>");
            return;
        L19:
            this.f266279b = r101;
            return;
        L9:
            r103 = false;
            goto L11
        L5:
            this.f266278a = new HashMap();
            goto L6
        }
    }

    @Override // s47.l
    public final String a() {
        return SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING;
    }

    @Override // s47.l
    public final void b() {
        Worker.a.C3723a r100 = new Worker.a.C3723a();
        n r101 = this.f540648b;
        r100.f266444c = r101;
        r100.f266449h = SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING;
        r100.f266442a = r101.f17559h.toString();
        r100.f266443b = this.f540648b.f17555d.e();
        r100.f266450i = this.f540648b.f17567p;
        Worker.a r102 = r100.a();
        if (r102 != null) goto L10;
        return;
    L10:
        Worker r103 = new Worker(r102);     // Catch: Throwable -> L7
        r103.f(new m(this));     // Catch: Throwable -> L7
        r103.f266417o.b(Module.NAME, Module.class, this);     // Catch: Throwable -> L7
        r103.g();     // Catch: Throwable -> L7
        this.f540648b.a(r103, "streaming-worker");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d.d("[Streaming] create streaming worker error:", th);
    }

    @Override // s47.l
    public final void g() {
        final View r100 = this.f540648b.g();
        if ((r100 instanceof WebView) == true) goto L5;
        return;
    L5:
        ThreadUtil.b(new r47.n(this, r100));
    }

    @Override // s47.l, l47.c
    public final void release() {
        this.f266272d.countDown();
    }

    public StreamingPlugin(n r100) {
        super(r100);
        this.f266271c = new HashMap();
        this.f266272d = new CountDownLatch(1);
        this.f266273e = "";
        this.f266274f = false;
        this.f266275g = false;
        this.f266276h = new AtomicReference(null);
        this.f266277i = new com.bytedance.pia.core.utils.a();
    }

    @Override // s47.l
    public final e d(i47.d r100) {
        if (r100.isForMainFrame() == false) goto L46;
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L6:
        if (this.f266275g == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L43
        return null;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(this.f266273e) == true) goto L54;
        boolean r101 = false;
    L25:
        if (TextUtils.isEmpty(this.f266273e) == true) goto L36;
        if (r101 == true) goto L36;
        monitor-enter(this);
        this.f266274f = true;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        return new a(this.f266271c, this.f266273e);
    L33:
        th = move-exception;
        throw th;
    L36:
        monitor-enter(this);
        this.f266275g = true;     // Catch: Throwable -> L40
        monitor-exit(this);     // Catch: Throwable -> L40
        return null;
    L40:
        th = move-exception;
        throw th;
    L54:
        CountDownLatch r102 = this.f266272d;     // Catch: Throwable -> L14
        Lazy<Settings> r103 = Settings.f266286f;     // Catch: Throwable -> L14
        r101 = !r102.await(Settings.a.a().j(), TimeUnit.SECONDS);
    L14:
        th = move-exception;
        d.d("[Streaming] intercept html failed, error:", th);
        monitor-enter(this);
        this.f266275g = true;     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    L46:
        return null;
    }
}
