package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b<PARAMS extends Serializable, RESULT extends Serializable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService.d<Result<RESULT>> f241689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f241691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f241692d;

    public class a extends TypeReference<Result<RESULT>> {
        public a(Type... r100) {
            super(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b$b, reason: collision with other inner class name */
    public class C3462b implements Function<Result<RESULT>, RESULT> {
        public C3462b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) throws Exception {
            Result r101 = (Result) r100;
            if (r101 == null) goto L11;
            if (r101.code != 0) goto L11;
            if (r101.getData() == null) goto L11;
            return r101.getData();
        L11:
            throw new Exception(C3462b.class.getSimpleName() + " access error: " + r101);
        }
    }

    public Type b() throws IllegalStateException {
        return new a(new Type[]{((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]}).getType();
    L5:
        e = move-exception;
        throw new IllegalStateException("BasePuller parseType() fail !!!", e);
    }

    public Map<String, Object> a(PARAMS r100) throws Exception {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L11;
        Field[] r102 = r100.getClass().getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        Field r105 = r102[r104];
        r105.setAccessible(true);
        Object r106 = r105.get(r100);
        if (r106 == null) goto L10;
        r101.put(r105.getName(), r106);
    L10:
        r104 = r104 + 1;
    L11:
        return r101;
    }

    public final Flowable<RESULT> c(final PARAMS r110) {
        NetService.f r100 = new NetService.f(this.f241690b);
        int r101 = this.f241691c;
        r100.f216906c = r101;
        if (r110 == null) goto L39;
        if (r101 == 2) goto L26;
        int r102 = this.f241692d;
        if (r102 == 2) goto L26;
        if (r102 != 3) goto L25;
        HashMap r103 = new HashMap();
        HashMap r104 = new HashMap();     // Catch: Exception -> L22
        Field[] r105 = r110.getClass().getDeclaredFields();     // Catch: Exception -> L22
        int r106 = r105.length;     // Catch: Exception -> L22
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L21;
        Field r108 = r105[r107];     // Catch: Exception -> L22
        r108.setAccessible(true);     // Catch: Exception -> L22
        Object r111 = r108.get(r110);     // Catch: Exception -> L22
        if (r111 == null) goto L20;
        if ((r111 instanceof List) == true) goto L20;
        r104.put(r108.getName(), String.valueOf(r111));     // Catch: Exception -> L22
    L20:
        r107 = r107 + 1;
        goto L14
    L21:
        r103 = r104;
    L24:
        r100.d(r103);
    L22:
        e = move-exception;
        tt5.a.e("Wiki_BasePuller", "get request build urlParams fail. ", e, false);
        goto L24
    L25:
        r100.f216913j = JSON.toJSONString(r110);
    L26:
        Map<String, Object> r109 = new HashMap();
        r109 = a(r110);     // Catch: Exception -> L29
    L31:
        Iterator<Map.Entry<String, Object>> r112 = r109.entrySet().iterator();
    L33:
        if (r112.hasNext() == false) goto L39;
        Map.Entry<String, Object> r113 = r112.next();
        Object r114 = r113.getValue();
        if ((r114 instanceof List) == true) goto L36;
        r100.b(r113.getKey(), String.valueOf(r114));
        goto L33
    L36:
        String r115 = r113.getKey();
        r100.a(r115, (List) r114);
    L29:
        e = move-exception;
        tt5.a.e("Wiki_BasePuller", "get request build urlParams fail. ", e, false);
    L39:
        return this.f241689a.a(r100).map(new C3462b()).onErrorResumeNext(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.a(this, r110));
    }

    public final /* bridge */ /* synthetic */ Flowable d(Object r100) {
        return c((Serializable) r100);
    }

    public b(NetService r100, String r101, NetService.c r102) {
        this.f241690b = r101;
        this.f241689a = r100.Vc(r102);
        this.f241691c = 2;
        this.f241692d = 1;
    }

    public b(NetService r100, String r101, int r102, int r103) {
        this.f241690b = r101;
        this.f241689a = r100.Rb(b());
        this.f241691c = r102;
        this.f241692d = r103;
    }
}
