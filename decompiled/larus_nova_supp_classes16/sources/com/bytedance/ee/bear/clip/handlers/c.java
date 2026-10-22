package com.bytedance.ee.bear.clip.handlers;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements FlowableOnSubscribe {
    public final /* synthetic */ ClipFetchHandler.FetchData a;
    public final /* synthetic */ ClipFetchHandler b;

    public static final class a implements Runnable {
        public final /* synthetic */ ClipFetchHandler a;
        public final /* synthetic */ Call b;

        public a(ClipFetchHandler r1, Call r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.c.contains(this.b) == false) goto L9;
            this.b.cancel();     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class b implements Callback {
        public final /* synthetic */ ClipFetchHandler a;
        public final /* synthetic */ Call b;
        public final /* synthetic */ FlowableEmitter<ClipFetchHandler.FetchResult> c;
        public final /* synthetic */ String d;

        public final void onFailure(Call r8, IOException r9) {
            Intrinsics.checkNotNullParameter(r8, "call");
            Intrinsics.checkNotNullParameter(r9, "e");
            this.a.c.remove(this.b);
            if (this.c.isCancelled() == false) goto L5;
            return;
        L5:
            String r2 = r9.toString();
            if ((r9 instanceof RustIOException) == false) goto L8;
            int r10 = ((RustIOException) r9).getRustSdkErrorCode();
        L9:
            int r1 = r10;
            tt5.a.d("DocsClip#ClipFetchHandler", "onFailure()... url: " + this.d + ", errorCode: " + r1 + ", exception: " + r9);
            this.c.onNext(new ClipFetchHandler.FetchResult(r1, r2, "{}", null, 8, null));
            this.c.onComplete();
            return;
        L8:
            r10 = ax4.c.a(r9);
            goto L9
        }

        public final void onResponse(Call r13, Response r14) throws IOException {
            Intrinsics.checkNotNullParameter(r13, "call");
            Intrinsics.checkNotNullParameter(r14, "response");
            this.a.c.remove(this.b);
            if (this.c.isCancelled() == false) goto L5;
            return;
        L5:
            tt5.a.h("DocsClip#ClipFetchHandler", "onResponse()... request success for url: " + this.d);
            ResponseBody r0 = r14.body();
            if (r0 != null) goto L8;
            String r1 = "";
        L9:
            int r4 = 0;
            if (TextUtils.isEmpty(r1) == true) goto L14;
            Intrinsics.checkNotNull(r1);
            if (StringsKt.endsWith$default(r1, DocViewModel.ENTER_CHAR, false, 2, null) == false) goto L14;
            r1 = yu5.c.i(r1);
        L14:
            ClipFetchHandler.FetchResult r3 = new ClipFetchHandler.FetchResult(0, null, null, null, 15, null);
            Intrinsics.checkNotNull(r1);
            r3.setData(r1);
            r3.setMessage("");
            int r2 = r14.code();
            if (r2 == 200) goto L18;
            r4 = r2;
        L18:
            if (r4 <= 0) goto L20;
            int r5 = -r4;
        L21:
            r3.setCode(r5);
            if (r4 == 0) goto L24;
            tt5.a.d("DocsClip#ClipFetchHandler", "requestNetResource()... code = " + r4 + ", responseStr = " + r1 + ", for " + r13);
        L24:
            LinkedHashMap r16 = new LinkedHashMap();
            Headers r17 = r14.headers();
            Iterator<T> r6 = r17.names().iterator();
        L26:
            if (r6.hasNext() == false) goto L30;
            String r7 = (String) r6.next();
            String r8 = r17.get(r7);
            if (r8 == null) goto L26;
            r16.put(r7, r8);
            goto L26
        L30:
            r3.setHeaders(r16);
            this.c.onNext(r3);
            this.c.onComplete();
            return;
        L20:
            r5 = r4;
            goto L21
        L8:
            r1 = r0.string();
            goto L9
        }

        public b(ClipFetchHandler r1, Call r2, FlowableEmitter<ClipFetchHandler.FetchResult> r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public c(ClipFetchHandler.FetchData r1, ClipFetchHandler r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(FlowableEmitter<ClipFetchHandler.FetchResult> r16) {
        Intrinsics.checkNotNullParameter(r16, "emitter");
        if (r16.isCancelled() == false) goto L5;
        return;
    L5:
        String r0 = this.a.getUrl();
        String r1 = null;
        if (r0 != null) goto L8;
        r0 = null;
    L8:
        String r2 = du5.b.f(r0);
        tt5.a.h("DocsClip#ClipFetchHandler", "subscribe: begin request for url: " + r2);
        ClipFetchHandler r3 = this.b;
        ClipFetchHandler.FetchData r4 = this.a;
        r3.getClass();
        Map<String, String> r5 = r4.getHeaders();
        if (r5 == null) goto L11;
        String r6 = r5.remove("Accept-Encoding");
    L11:
        boolean r7 = true;
        if (StringsKt.equals("get", r4.getMethod(), true) == false) goto L14;
    L23:
        Request.Builder r8 = new Request.Builder();
        if (r4.getHeaders() == null) goto L30;
        Map<String, String> r9 = r4.getHeaders();
        Intrinsics.checkNotNull(r9);
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L27:
        if (r10.hasNext() == false) goto L30;
        Map.Entry<String, String> r11 = r10.next();
        r8.addHeader(r11.getKey(), r11.getValue());
    L30:
        if (StringsKt.equals("get", r4.getMethod(), true) == false) goto L49;
        String r12 = r4.getUrl();
        Intrinsics.checkNotNull(r12);
        Map<String, String> r13 = r4.getParams();
        if (r13 != null) goto L34;
    L37:
        boolean r14 = true;
    L38:
        if (r14 == true) goto L48;
        StringBuilder r17 = new StringBuilder(r12);
        char r18 = '?';
        if (StringsKt.contains$default(r12, '?', false, 2, null) == false) goto L43;
        r18 = '&';
    L43:
        r17.append(r18);
        Iterator<Map.Entry<String, String>> r19 = r13.entrySet().iterator();
    L45:
        if (r19.hasNext() == false) goto L47;
        Map.Entry<String, String> r110 = r19.next();
        String r111 = r110.getKey();
        String r112 = r110.getValue();
        r17.append(r111);
        r17.append('=');
        r17.append(r112);
        r17.append('&');
        goto L45
    L47:
        r12 = r17.substring(0, r17.length() - 1).toString();
    L48:
        r8.url(r12);
    L51:
        if (StringsKt.equals("get", r4.getMethod(), true) == false) goto L53;
        r8.method("get", null);
    L95:
        Call r20 = this.b.b.b().newCall(r8.build());
        this.b.c.add(r20);
        if (this.a.getTimeout() <= 0) goto L98;
        j.d(new a(this.b, r20), this.a.getTimeout());
    L98:
        r20.enqueue(new b(this.b, r20, r16, r2));
        return;
    L53:
        Map<String, String> r21 = r4.getParams();
        ClipFetchHandler.FileInfo r22 = r4.getFile();
        if (r22 == null) goto L56;
        String r23 = r22.getFileName();
    L57:
        if (r23 != null) goto L59;
    L62:
        if (r7 == true) goto L88;
        k.a r24 = new k.a();
        r24.e(k.f);
        if (r21 == null) goto L70;
        Iterator<Map.Entry<String, String>> r26 = r21.entrySet().iterator();
    L67:
        if (r26.hasNext() == false) goto L70;
        Map.Entry<String, String> r27 = r26.next();
        r24.a(r27.getKey(), r27.getValue());
    L70:
        if (ClipFetchHandler.b(r22) == false) goto L87;
        if (r22 == null) goto L75;
        String r28 = r22.getFileName();
        if (r28 == null) goto L75;
        VFSFile r29 = ay4.d.a().D(com.bytedance.ee.bear.clip.a.e(), r28);
    L76:
        if (r29 != null) goto L78;
    L83:
        StringBuilder r30 = new StringBuilder("file not exists: ");
        if (r29 == null) goto L86;
        r1 = r29.getAbsolutePath();
    L86:
        r30.append(r1);
        tt5.a.k("DocsClip#ClipFetchHandler", r30.toString());
        goto L87
    L78:
        if (r29.exists() == false) goto L83;
        RequestBody r31 = RequestBody.create(MediaType.parse("application/octet-stream"), r29);
        String r32 = r22.getParamName();
        if (r32 != null) goto L82;
        r32 = "file";
    L82:
        String r33 = r22.getTitle();
        Intrinsics.checkNotNull(r33);
        r24.b(r32, r33, r31);
    L75:
        r29 = null;
    L87:
        k r34 = r24.d();
    L94:
        r8.method("post", r34);
        goto L95
    L88:
        MediaType r36 = MediaType.parse("application/json");
        if (r21 == null) goto L92;
        String r37 = GsonProtectorUtils.toJson(new Gson(), r21);
        if (r37 == null) goto L92;
    L93:
        r34 = RequestBody.create(r36, r37);
    L92:
        r37 = "{}";
        goto L93
    L59:
        if (r23.length() == 0) goto L62;
        r7 = false;
        goto L62
    L56:
        r23 = null;
        goto L57
    L34:
        if (r13.isEmpty() == true) goto L37;
        r14 = false;
        goto L38
    L49:
        String r38 = r4.getUrl();
        Intrinsics.checkNotNull(r38);
        r8.url(r38);
        goto L51
    L14:
        if (r4.getHeaders() != null) goto L16;
        r4.setHeaders(new LinkedHashMap());
    L16:
        Map<String, String> r39 = r4.getHeaders();
        Intrinsics.checkNotNull(r39);
        if (r39.containsKey("Content-Type") == true) goto L23;
        Map<String, String> r40 = r4.getHeaders();
        Intrinsics.checkNotNull(r40);
        if (ClipFetchHandler.b(r4.getFile()) == false) goto L21;
        String r41 = "multipart/form-data";
    L22:
        r40.put("Content-Type", r41);
        goto L23
    L21:
        r41 = "application/json";
        goto L22
    }
}
