package com.bytedance.ee.bear.contract;

import io.reactivex.Flowable;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes16.dex */
public interface NetService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ENV_TYPE {
    }

    public static class HttpErrorException extends Exception {
        private int code;
        private String httpStr;

        @Override // java.lang.Throwable
        public String toString() {
            return " HttpErrorException {code = " + this.code + ", httpStr = " + this.httpStr + com.alipay.sdk.m.u.i.f25855d;
        }

        public int getCode() {
            return this.code;
        }

        public String getHttpStr() {
            return this.httpStr;
        }

        public HttpErrorException(int r100, String r101) {
            super("http error, code = " + r100 + ", body = " + r101);
            this.code = r100;
            this.httpStr = r101;
        }
    }

    public static class ParseException extends Exception {
        public ParseException() {
            super("Parse json from server error!");
        }
    }

    public static class ServerErrorException extends Exception {
        private int code;
        private String data;
        private String json;
        private String logId;
        private String msg;

        @Override // java.lang.Throwable
        public String toString() {
            return " ServerErrorException {code = " + this.code + ", msg = " + this.msg + com.alipay.sdk.m.u.i.f25855d;
        }

        public int getCode() {
            return this.code;
        }

        public String getData() {
            return this.data;
        }

        public String getJson() {
            return this.json;
        }

        public String getLogId() {
            return this.logId;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setData(String r100) {
            this.data = r100;
        }

        public void setLogId(String r100) {
            this.logId = r100;
        }

        public ServerErrorException(int r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, "");
        }

        public ServerErrorException(int r100, String r101, String r102, String r103, String r104) {
            this.code = r100;
            this.msg = r101;
            this.data = r102;
            this.json = r103;
            this.logId = r104;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f216903a;

        public a() {
        }
    }

    public interface b {
        String s0(String r100);
    }

    public interface c<T extends Result> {
        T parse(String r100) throws ParseException;
    }

    public interface d<R extends Result> {
        Flowable<R> a(e r100);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f216904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f216905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f216906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f216907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, String> f216908e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, List<String>> f216909f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, List<String>> f216910g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f216911h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f216912i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f216913j;

        public final String toString() {
            return "Request{, path='" + du5.b.g(this.f216905b) + "', requestMethod=" + this.f216906c + ", needCorrectPath= " + this.f216912i + '}';
        }

        public e() {
            this.f216906c = 2;
            this.f216907d = new HashMap();
            this.f216908e = new HashMap();
            this.f216909f = new HashMap();
            this.f216910g = new HashMap();
            this.f216911h = new HashMap();
            this.f216912i = true;
        }

        public final void c(Map<String, String> r100) {
            if (r100 == null) goto L5;
            ((HashMap) this.f216911h).putAll(r100);
            return;
        }

        public final void d(Map<String, String> r100) {
            if (r100 == null) goto L5;
            ((HashMap) this.f216907d).putAll(r100);
            return;
        }

        public final void a(String r100, List<String> r101) {
            ((HashMap) this.f216909f).put(r100, r101);
        }

        public final void b(String r100, String r101) {
            ((HashMap) this.f216908e).put(r100, r101);
        }
    }

    public static class f<DATA extends Serializable> extends e {
        public f(String r100) {
            this.f216905b = r100;
            this.f216906c = 2;
        }
    }

    void C7(b r100);

    <R extends Result> d<R> Rb(Type r100);

    <R extends Result> d<R> Vc(c<R> r100);

    void b();

    Response g6(Request r100);

    a getConfig();

    int getEnv();

    boolean w6();

    void z8(Request r100, Callback r101);
}
