package com.bytedance.ee.bear.net;

import ak5.e;
import ak5.k;
import ak5.l;
import ak5.o;
import ak5.p;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CloudReqFun implements Function<k, Flowable<p>> {
    public final o a;
    public final e b;

    public static class OkHttpReqException extends Exception {
        public String exception;
        public Exception exceptionObj;

        public OkHttpReqException(Exception r3) {
            super("OkHttp request error. e = " + r3);
            this.exception = r3.getClass().getName();
            this.exceptionObj = r3;
        }
    }

    public static class a implements l {
        public final k a;

        @Override // ak5.l
        public final String a() {
            return this.a.a.a();
        }

        @Override // ak5.l
        public final Map<String, String> b() {
            Map<String, String> r0 = this.a.a.b();
            if (r0 != null) goto L6;
            r0 = new HashMap();
        L6:
            if (this.a.b == false) goto L8;
            r0.put("Env", "Pre_release");
        L8:
            r0.putAll(this.a.c);
            return r0;
        }

        @Override // ak5.l
        public final Map<String, List<String>> c() {
            return this.a.a.c();
        }

        @Override // ak5.l
        public final String d() {
            return this.a.a.d();
        }

        @Override // ak5.l
        public final Map<String, String> e() {
            return this.a.a.e();
        }

        @Override // ak5.l
        public final int getRequestType() {
            return this.a.a.getRequestType();
        }

        public a(k r1) {
            this.a = r1;
        }
    }

    public final Object apply(Object r3) throws Exception {
        k r4 = (k) r3;
        Flowable r0 = Flowable.create(new com.bytedance.ee.bear.net.a(this, r4), BackpressureStrategy.BUFFER);
        e r1 = this.b;
        if (r1 == null) goto L5;
        r1.a(r4.c);
    L5:
        return r0;
    }

    public CloudReqFun(o r1, e r2) {
        this.a = r1;
        this.b = r2;
    }
}
