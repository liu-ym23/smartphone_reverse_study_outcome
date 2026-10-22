package com.bytedance.ee.permission;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.permission.define.IPermissionApi$ERequestMethod;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ut5.b;
import ut5.c;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsPermissionApiExecutor<T extends ut5.b, R extends ut5.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f243004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<R> f243005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ut5.a<R> f243006d;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/permission/AbsPermissionApiExecutor$PermissionRawJsonData;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "rawJson", "", "<init>", "(Ljava/lang/String;)V", "getRawJson", "()Ljava/lang/String;", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionRawJsonData extends Result<Serializable> {
        private final String rawJson;

        public final String getRawJson() {
            return this.rawJson;
        }

        public PermissionRawJsonData(String r100) {
            this.rawJson = r100;
        }
    }

    public static final class a<R extends ut5.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f243007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f243008b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f243007a, r101.f243007a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243008b, r101.f243008b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            R r100 = this.f243007a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Throwable r104 = this.f243008b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Parsed(result=" + this.f243007a + ", error=" + this.f243008b + ')';
        }

        public a(R r100, Throwable r101) {
            this.f243007a = r100;
            this.f243008b = r101;
        }
    }

    public static final class b implements NetService.c<PermissionRawJsonData> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) {
            return new PermissionRawJsonData(r100);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243009a = null;

        static {
            int[] r100 = new int[IPermissionApi$ERequestMethod.values().length];
            r100[IPermissionApi$ERequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IPermissionApi$ERequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f243009a = r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsPermissionApiExecutor<T, R> f243010a;

        public d(AbsPermissionApiExecutor<T, R> r100) {
            this.f243010a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PermissionRawJsonData r101 = (PermissionRawJsonData) r100;
            AbsPermissionApiExecutor<T, R> r102 = this.f243010a;
            if (r101 == null) goto L5;
            String r103 = r101.getRawJson();
        L6:
            a<R> r104 = r102.a(r103);
            Throwable r105 = r104.f243008b;
            if (r105 == null) goto L11;
            AbsPermissionApiExecutor<T, R> r106 = this.f243010a;
            tt5.a.e(r106.f243003a, "requestJson - onNext, parse result failed, e:", r105, false);
            ut5.a<R> r107 = r106.f243006d;
            if (r107 == null) goto L15;
            r107.onError(-1, r105);
            return;
        L15:
            return;
        L11:
            tt5.a.h(this.f243010a.f243003a, "requestJson - onNext, result: " + r104.f243007a);
            ut5.a<R> r108 = this.f243010a.f243006d;
            if (r108 == null) goto L17;
            r108.onResult(r104.f243007a);
            return;
        L17:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsPermissionApiExecutor<T, R> f243011a;

        public e(AbsPermissionApiExecutor<T, R> r100) {
            this.f243011a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e(this.f243011a.f243003a, "requestJson - onError, e:", r101, false);
            ut5.a<R> r102 = this.f243011a.f243006d;
            if (r102 == null) goto L6;
            r102.onError(-1, r101);
            return;
        }
    }

    public final void b() {
        String r100 = this.f243004b.a();
        IPermissionApi$ERequestMethod r101 = this.f243004b.getMethod();
        NetService.f r102 = new NetService.f(r100);
        int r103 = c.f243009a[r101.ordinal()];
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L6;
        tt5.a.d(this.f243003a, "requestJson, unknown request method: " + r101);
    L19:
        tt5.a.h(this.f243003a, "");
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b()).a(r102).subscribe(new d(this), new e(this));
        return;
    L6:
        r102.f216906c = 1;
        Map<String, Serializable> r104 = this.f243004b.b();
        if (r104 != null) goto L21;
        String r105 = null;
    L17:
        r102.f216913j = r105;
        goto L19
    L21:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L15
        Iterator<Map.Entry<String, Serializable>> r107 = r104.entrySet().iterator();     // Catch: Exception -> L15
    L11:
        if (r107.hasNext() == false) goto L13;
        Map.Entry<String, Serializable> r108 = r107.next();     // Catch: Exception -> L15
        r106.putOpt(r108.getKey(), r108.getValue());     // Catch: Exception -> L15
        goto L11
    L13:
        r105 = r106.toString();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        tt5.a.e(this.f243003a, "buildJsonParams, error: ", e, false);
        r105 = "";
        goto L17
    L18:
        r102.f216906c = 2;
        goto L19
    }

    public a<R> a(String r100) {
    L8:
        e = move-exception;
        return new a(null, e);
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return new a((ut5.c) JSON.parseObject(new JSONObject(r100).optString("data"), this.f243005c), null);
    }

    public AbsPermissionApiExecutor(String r100, T r101, Class<R> r102, ut5.a<R> r103) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "resultClass");
        this.f243003a = r100;
        this.f243004b = r101;
        this.f243005c = r102;
        this.f243006d = r103;
    }
}
