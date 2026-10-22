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

/* JADX INFO: loaded from: classes18.dex */
public final class CloudReqFun implements Function<k, Flowable<p>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f235097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f235098b;

    public static class OkHttpReqException extends Exception {
        public String exception;
        public Exception exceptionObj;

        public OkHttpReqException(Exception r100) {
            super("OkHttp request error. e = " + r100);
            this.exception = r100.getClass().getName();
            this.exceptionObj = r100;
        }
    }

    public static class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f235099a;

        @Override // ak5.l
        public final String a() {
            return this.f235099a.f4034a.a();
        }

        @Override // ak5.l
        public final Map<String, String> b() {
            Map<String, String> r100 = this.f235099a.f4034a.b();
            if (r100 != null) goto L6;
            r100 = new HashMap();
        L6:
            if (this.f235099a.f4035b == false) goto L8;
            r100.put("Env", "Pre_release");
        L8:
            r100.putAll(this.f235099a.f4036c);
            return r100;
        }

        @Override // ak5.l
        public final Map<String, List<String>> c() {
            return this.f235099a.f4034a.c();
        }

        @Override // ak5.l
        public final String d() {
            return this.f235099a.f4034a.d();
        }

        @Override // ak5.l
        public final Map<String, String> e() {
            return this.f235099a.f4034a.e();
        }

        @Override // ak5.l
        public final int getRequestType() {
            return this.f235099a.f4034a.getRequestType();
        }

        public a(k r100) {
            this.f235099a = r100;
        }
    }

    @Override // io.reactivex.functions.Function
    public final Flowable<p> apply(k r100) throws Exception {
        k r101 = r100;
        Flowable<p> r102 = Flowable.create(new com.bytedance.ee.bear.net.a(this, r101), BackpressureStrategy.BUFFER);
        e r103 = this.f235098b;
        if (r103 == null) goto L5;
        r103.a(r101.f4036c);
    L5:
        return r102;
    }

    public CloudReqFun(o r100, e r101) {
        this.f235097a = r100;
        this.f235098b = r101;
    }
}
