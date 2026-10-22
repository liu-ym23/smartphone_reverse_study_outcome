package com.bytedance.ee.bear.drive.view.preview.wps;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements g {
    public static final /* synthetic */ int c = 0;
    public final WpsView a;
    public final com.bytedance.ee.bear.drive.view.preview.wps.e b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.wps.a$a, reason: collision with other inner class name */
    public static final class C0187a {
        public static String a(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            JSONObject r1 = new JSONObject();
            r1.put("key", r2);
            r1.put("value", r3);
            return Base64.encodeToString(r1.toJSONString().getBytes(Charsets.UTF_8), 2);
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r6) {
            WpsAccessTokenPuller.Result r7 = (WpsAccessTokenPuller.Result) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            com.bytedance.ee.bear.drive.report.a r0 = o75.b.a().Tb();     // Catch: Exception -> L7
            String r1 = r7.token;     // Catch: Exception -> L7
            r0.getClass();     // Catch: Exception -> L7
            String r2 = t85.e.e(r1, 3);     // Catch: Exception -> L7
            if (r0.c.a(r2) != null) goto L9;
            t85.e r3 = new t85.e();     // Catch: Exception -> L7
            r0.c.b(r2, r3);     // Catch: Exception -> L7
            r0.c.b(r1, r3);     // Catch: Exception -> L7
        L9:
            return r7;
        L7:
            e = move-exception;
            tt5.a.k("BaseWpsVersionController", "report fail: " + e);
            goto L9
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            WpsAccessTokenPuller.Result r5 = (WpsAccessTokenPuller.Result) r4;
            Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
            JSONObject r0 = new JSONObject();
            r0.put("token", r5.token);
            r0.put("expire", Long.valueOf(r5.expire));
            JSONObject r1 = new JSONObject();
            r1.put("authToken", r0);
            r1.put("wpsOptions", this.a.b.f());
            r1.put("wpsIframeUrl", this.a.b(r5));
            r1.put("shouldWpsUrlCheck", Boolean.TRUE);
            r1.put("wpsUrlCheckTimeout", 10000);
            int r6 = a.c;
            String r7 = C0187a.a("setInitialData", r1);
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            return String.format("javascript:triggerJSEvent('%1$s')", Arrays.copyOf(new Object[]{r7}, 1));
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((String) r6, "it");
            WpsHeadIframeUriPuller$Params r7 = WpsHeadIframeUriPuller$Params.fromJson(this.a);
            if (r7 != null) goto L5;
        L15:
            tt5.a.d("WpsHeadIframeUriPuller", "getHeadResponse fail, becase params is null");
            WpsHeadIframeUriPuller$Result r8 = new WpsHeadIframeUriPuller$Result();
            r8.code = 1;
            r8.msg = "params is null";
            return Flowable.just(r8);
        L5:
            if (TextUtils.isEmpty(r7.iframeUrl) == true) goto L15;
            Response r9 = new OkHttpClient().newCall(new Request.Builder().url(r7.iframeUrl).head().build()).execute();     // Catch: IOException -> L13
            tt5.a.h("WpsHeadIframeUriPuller", "getHeadResponse run finish: isSuccessful= " + r9.isSuccessful() + ", code= " + r9.code() + ", msg= " + r9.message());     // Catch: IOException -> L13
            if (r9.isSuccessful() == false) goto L11;
            Flowable r10 = Flowable.just(new WpsHeadIframeUriPuller$Result());     // Catch: IOException -> L13
        L17:
            return r10;
        L11:
            WpsHeadIframeUriPuller$Result r0 = new WpsHeadIframeUriPuller$Result();     // Catch: IOException -> L13
            r0.code = r9.code();     // Catch: IOException -> L13
            r0.msg = r9.message();     // Catch: IOException -> L13
            r10 = Flowable.just(r0);     // Catch: IOException -> L13
        L13:
            e = move-exception;
            tt5.a.d("WpsHeadIframeUriPuller", "getHeadResponse run fail: " + e);
            WpsHeadIframeUriPuller$Result r1 = new WpsHeadIframeUriPuller$Result();
            r1.code = 1;
            r1.msg = e.getMessage();
            return Flowable.just(r1);
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r4) {
            WpsHeadIframeUriPuller$Result r5 = (WpsHeadIframeUriPuller$Result) r4;
            Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
            JSONObject r0 = new JSONObject();
            r0.put("code", Integer.valueOf(r5.code));
            r0.put("msg", r5.msg);
            int r6 = a.c;
            String r7 = C0187a.a("setWpsIframeUrlHeadData", r0);
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            return String.format("javascript:triggerJSEvent('%1$s')", Arrays.copyOf(new Object[]{r7}, 1));
        }
    }

    public static final class f<T, R> implements Function {
        public static final f<T, R> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r5) {
            WpsAccessTokenPuller.Result r6 = (WpsAccessTokenPuller.Result) r5;
            Intrinsics.checkNotNullParameter(r6, TipCallBackData.RESULT);
            JSONObject r0 = new JSONObject();
            JSONObject r1 = new JSONObject();
            r1.put("token", r6.token);
            r1.put("expire", Long.valueOf(r6.expire));
            r0.put("authToken", r1);
            int r7 = a.c;
            String r8 = C0187a.a("refreshAuthToken", r0);
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            return String.format("javascript:triggerJSEvent('%1$s')", Arrays.copyOf(new Object[]{r8}, 1));
        }
    }

    static {
    }

    public final Flowable<String> d() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        tt5.a.b("BaseWpsVersionController", "getInitialDataImp");
        WpsAccessTokenPuller.Params r1 = c(true);
        return new WpsAccessTokenPuller(r0).pull(r1).onErrorResumeNext(new j(r1)).observeOn(fo5.d.e()).map(b.a).map(new c(this));
    }

    public final Flowable<String> f() {
        JSONObject r0 = new JSONObject();
        r0.put("fileType", "ppt");
        r0.put("command", "ActivePresentation.SlideShowSettings.Run");
        String r1 = C0187a.a("triggerWpsApi", r0);
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        return Flowable.just(String.format("javascript:triggerJSEvent('%1$s')", Arrays.copyOf(new Object[]{r1}, 1)));
    }

    public final Flowable<String> g() {
        JSONObject r0 = new JSONObject();
        r0.put("fileType", "ppt");
        r0.put("command", "ActivePresentation.SlideShowWindow.View.Exit");
        String r1 = C0187a.a("triggerWpsApi", r0);
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        return Flowable.just(String.format("javascript:triggerJSEvent('%1$s')", Arrays.copyOf(new Object[]{r1}, 1)));
    }

    public final Context getContext() {
        return this.a.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wps.g
    public String getType() {
        String r0 = this.a.getEntity().a.b;
        if (i75.h.j(r0) == false) goto L6;
        return "p";
    L6:
        if (i75.h.g(r0) == false) goto L9;
        return "w";
    L9:
        if (i75.h.h(r0) == false) goto L11;
    L14:
        return "s";
    L11:
        if (i75.h.f(r0) == true) goto L14;
        return "f";
    }

    public final void i() {
        this.b.onDetachedFromWindow();
    }

    public final Flowable<String> j() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        WpsAccessTokenPuller.Params r1 = c(false);
        return new WpsAccessTokenPuller(r0).pull(r1).onErrorResumeNext(new j(r1)).map(f.a);
    }

    public final WpsAccessTokenPuller.Params c(boolean r8) {
        com.bytedance.ee.bear.drive.view.preview.wrapper.z r0 = this.a.getEntity().a;
        if ((!TextUtils.isEmpty(r0.r)) == false) goto L6;
        WpsAccessTokenPuller.DriveSdkParams r9 = new WpsAccessTokenPuller.DriveSdkParams(r0.r, this.b.c(), a(), r8).setSdkParams(r0.p, r0.o);
        Intrinsics.checkNotNull(r9);
        return r9;
    L6:
        return new WpsAccessTokenPuller.Params(r0.o, r0.s, this.b.c(), a(), r8);
    }

    public String e(WpsAccessTokenPuller.Result r2) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        if (Intrinsics.areEqual(getContext().getResources().getConfiguration().locale.getLanguage(), Locale.CHINESE.getLanguage()) == false) goto L5;
        return "zh-CN";
    L5:
        return "en-US";
    }

    public final Flowable<String> h(String r3) {
        tt5.a.b("BaseWpsVersionController", "getWpsIframeUrlHeadData");
        return Flowable.just("").observeOn(fo5.d.e()).flatMap(new d(r3)).map(e.a);
    }

    public final void k(ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.b.e(r2);
    }

    public a(WpsView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "wpsView");
        this.a = r2;
        boolean r0 = this instanceof n;
        if (r3 == false) goto L5;
        com.bytedance.ee.bear.drive.view.preview.wps.e r4 = new WpsCanWriteController(r2, r0);
    L6:
        this.b = r4;
        return;
    L5:
        r4 = new s(r2, r0);
        goto L6
    }
}
