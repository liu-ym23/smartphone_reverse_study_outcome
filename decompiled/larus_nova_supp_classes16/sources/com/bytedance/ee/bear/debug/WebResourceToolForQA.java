package com.bytedance.ee.bear.debug;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.resupdate.g;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.vfs.VFSPath;
import jx4.a0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebResourceToolForQA {
    private static final String TAG = "WebResourceToolForQA";
    private static final String VERSION = "version";
    private static JSONObject sResourceInfoJson;

    public interface IDownloadListener {
        void onDownloadFail(String r1);

        void onDownloadSuccess(String r1);
    }

    public interface IResourceVersionCallback {
        void onFail(String r1);

        void onReceiveResourceVersion(String r1);
    }

    public class a implements com.bytedance.ee.bear.doc.resupdate.f {
        public final /* synthetic */ IDownloadListener a;
        public final /* synthetic */ Context b;

        @Override // u45.a
        public final void a(int r1) {
        }

        @Override // com.bytedance.ee.bear.doc.resupdate.f
        public final void d(String r1) {
        }

        @Override // u45.a
        public final void onStart() {
        }

        @Override // u45.a
        public final void b(VFSPath r3) {
            IDownloadListener r0 = this.a;
            if (r0 == null) goto L6;
            if (r3 == null) goto L6;
            r0.onDownloadSuccess(r3.getAbsolutePath());
        L6:
            Context r4 = this.b;
            Toast.showSuccessText(r4, r4.getString(2131887648), 1);
        }

        @Override // u45.a
        public final void c(Exception r2) {
            IDownloadListener r0 = this.a;
            if (r0 == null) goto L7;
            if (r2 == null) goto L8;
            r0.onDownloadFail(r2.getMessage());
            return;
        L8:
            return;
        }

        public a(IDownloadListener r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ void a(IResourceVersionCallback r0, String r1) {
        lambda$fetchWebResourceVersion$0(r0, r1);
    }

    public static String getWebResourceVersion() {
        JSONObject r0 = sResourceInfoJson;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.optString(VERSION);
    }

    private WebResourceToolForQA() {
    }

    public static void fetchWebResourceVersion(final IResourceVersionCallback r2) {
        if (sResourceInfoJson == null) goto L7;
        if (r2 == null) goto L9;
        r2.onReceiveResourceVersion(getWebResourceVersion());
        return;
    L9:
        return;
    L7:
        l7 r0 = y7.j;
        y7.a.a.t(null).evaluateJavascript("window.scm", new a0(r2));
    }

    private static void lambda$fetchWebResourceVersion$0(IResourceVersionCallback r4, String r5) {
        if (r5 != null) goto L30;
        return;
    L30:
        if (TextUtils.isEmpty(r5) == true) goto L34;
        sResourceInfoJson = new JSONObject(r5);     // Catch: Throwable -> L13 JSONException -> L15
        if (r4 == null) goto L29;
        String r6 = getWebResourceVersion();
        if (TextUtils.isEmpty(r6) == true) goto L12;
    L11:
        r4.onReceiveResourceVersion(r6);
    L12:
        r4.onFail("webview does not exist resource version");
    L29:
        return;
    L15:
        e = move-exception;
        tt5.a.e(TAG, "window.scm error:", e, false);     // Catch: Throwable -> L13
        if (r4 == null) goto L29;
        r6 = getWebResourceVersion();
        if (TextUtils.isEmpty(r6) == true) goto L12;
    L34:
        return;
    L13:
        th = move-exception;
        if (r4 == null) goto L27;
        String r1 = getWebResourceVersion();
        if (TextUtils.isEmpty(r1) == true) goto L26;
        r4.onReceiveResourceVersion(r1);
        goto L27
    L26:
        r4.onFail("webview does not exist resource version");
    L27:
        throw th;
    }

    public static void setCustomDocsResource(String r3, IDownloadListener r4) {
        Context r0 = LarkAppContext.inst().getContext().getApplicationContext();
        ((g) org.koin.java.a.a(g.class)).f(r0, r3, new a(r4, r0));
    }
}
