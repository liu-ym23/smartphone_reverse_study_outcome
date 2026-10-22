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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface NetService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ENV_TYPE {
    }

    public static class HttpErrorException extends Exception {
        private int code;
        private String httpStr;

        @Override // java.lang.Throwable
        public String toString() {
            return " HttpErrorException {code = " + this.code + ", httpStr = " + this.httpStr + "}";
        }

        public int getCode() {
            return this.code;
        }

        public String getHttpStr() {
            return this.httpStr;
        }

        public HttpErrorException(int r3, String r4) {
            super("http error, code = " + r3 + ", body = " + r4);
            this.code = r3;
            this.httpStr = r4;
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
            return " ServerErrorException {code = " + this.code + ", msg = " + this.msg + "}";
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

        public void setData(String r1) {
            this.data = r1;
        }

        public void setLogId(String r1) {
            this.logId = r1;
        }

        public ServerErrorException(int r7, String r8, String r9, String r10) {
            this(r7, r8, r9, r10, "");
        }

        public ServerErrorException(int r1, String r2, String r3, String r4, String r5) {
            this.code = r1;
            this.msg = r2;
            this.data = r3;
            this.json = r4;
            this.logId = r5;
        }
    }

    public static class a {
        public String a;

        public a() {
        }
    }

    public interface b {
        String s0(String r1);
    }

    public interface c<T extends Result> {
        T parse(String r1) throws ParseException;
    }

    public interface d<R extends Result> {
        Flowable<R> a(e r1);
    }

    public static class e {
        public String a;
        public String b;
        public int c;
        public final Map<String, String> d;
        public final Map<String, String> e;
        public final Map<String, List<String>> f;
        public final Map<String, List<String>> g;
        public final Map<String, String> h;
        public boolean i;
        public String j;

        public final String toString() {
            return "Request{, path='" + du5.b.g(this.b) + "', requestMethod=" + this.c + ", needCorrectPath= " + this.i + '}';
        }

        public e() {
            this.c = 2;
            this.d = new HashMap();
            this.e = new HashMap();
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
            this.i = true;
        }

        public final void c(Map<String, String> r2) {
            if (r2 == null) goto L5;
            ((HashMap) this.h).putAll(r2);
            return;
        }

        public final void d(Map<String, String> r2) {
            if (r2 == null) goto L5;
            ((HashMap) this.d).putAll(r2);
            return;
        }

        public final void a(String r2, List<String> r3) {
            ((HashMap) this.f).put(r2, r3);
        }

        public final void b(String r2, String r3) {
            ((HashMap) this.e).put(r2, r3);
        }
    }

    public static class f<DATA extends Serializable> extends e {
        public f(String r1) {
            this.b = r1;
            this.c = 2;
        }
    }

    void C7(b r1);

    <R extends Result> d<R> Rb(Type r1);

    <R extends Result> d<R> Vc(c<R> r1);

    void b();

    Response g6(Request r1);

    a getConfig();

    int getEnv();

    boolean w6();

    void z8(Request r1, Callback r2);
}
