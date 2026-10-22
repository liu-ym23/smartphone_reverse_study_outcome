package com.lynx.devtool.recorder;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderTemplateProvider extends d8a.b {
    private final OkHttpClient client;
    private final Handler mainHandler;

    /* JADX INFO: renamed from: com.lynx.devtool.recorder.LynxRecorderTemplateProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements Callback {
        final /* synthetic */ LynxRecorderTemplateProvider this$0;
        final /* synthetic */ d8a.b.a val$callback;

        public static /* synthetic */ void a(d8a.b.a r100, byte[] r101) {
            lambda$onResponse$2(r100, r101);
        }

        public static /* synthetic */ void b(d8a.b.a r100, IOException r101) {
            lambda$onFailure$0(r100, r101);
        }

        public static /* synthetic */ void c(d8a.b.a r100, IOException r101) {
            lambda$onResponse$1(r100, r101);
        }

        public AnonymousClass1(LynxRecorderTemplateProvider r100, d8a.b.a r101) {
            this.this$0 = r100;
            this.val$callback = r101;
        }

        private static /* synthetic */ void lambda$onFailure$0(d8a.b.a r100, IOException r101) {
            r100.onFailed(r101.toString());
        }

        private static /* synthetic */ void lambda$onResponse$1(d8a.b.a r100, IOException r101) {
            r100.onFailed(r101.toString());
        }

        private static /* synthetic */ void lambda$onResponse$2(d8a.b.a r100, byte[] r101) {
            r100.onSuccess(r101);
        }

        @Override // okhttp3.Callback
        public void onFailure(Call r100, final IOException r101) {
            Handler r102 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r103 = this.val$callback;
            r102.post(new i(r103, r101));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call r100, Response r101) throws IOException {
            if (r101.isSuccessful() == true) goto L6;
            final IOException r102 = new IOException("Unexpected code: " + r101);
            Handler r103 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r104 = this.val$callback;
            r103.post(new j(r104, r102));
            return;
        L6:
            final byte[] r105 = r101.body().bytes();
            Handler r106 = LynxRecorderTemplateProvider.access$000(this.this$0);
            final d8a.b.a r107 = this.val$callback;
            r106.post(new k(r107, r105));
        }
    }

    public LynxRecorderTemplateProvider() {
        this.client = new OkHttpClient();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler access$000(LynxRecorderTemplateProvider r100) {
        return r100.mainHandler;
    }

    @Override // d8a.b
    public void loadTemplate(String r100, d8a.b.a r101) {
        Request r102 = new Request.Builder().url(r100).build();
        this.client.newCall(r102).enqueue(new AnonymousClass1(this, r101));
    }
}
