package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<T> f211980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f211981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f211982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Class<T> f211983d;

    public static final class a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class<T> f211984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter<T> f211985b;

        public a(Class<T> r100, com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<T> r101, ObservableEmitter<T> r102) {
            this.f211984a = r100;
            this.f211985b = r102;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            Object r102 = new GsonBuilder().create().fromJson(r101, this.f211984a);     // Catch: Exception -> L8
            if (r102 == null) goto L6;
            this.f211985b.onNext((T) r102);     // Catch: Exception -> L8
        L11:
            return;
        L6:
            this.f211985b.onError(new Throwable("result is null"));     // Catch: Exception -> L8
        L8:
            e = move-exception;
            this.f211985b.onError(e);
        }
    }

    public b(com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r100, JSONObject r101, Class r102) {
        this.f211980a = r100;
        this.f211981b = "lark.biz.util.getBitableCommonData";
        this.f211982c = r101;
        this.f211983d = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a<T> r101 = this.f211980a;
        vv4.k r102 = r101.f211977f;
        if (r102 == null) goto L6;
        r102.a(this.f211981b, this.f211982c, new a(this.f211983d, r101, r100));
        return;
    }
}
