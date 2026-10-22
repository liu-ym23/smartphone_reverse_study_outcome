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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b<PARAMS extends Serializable, RESULT extends Serializable> {
    public final NetService.d<Result<RESULT>> a;
    public final String b;
    public final int c;
    public final int d;

    public class a extends TypeReference<Result<RESULT>> {
        public a(Type... r1) {
            super(r1);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b$b, reason: collision with other inner class name */
    public class C0215b implements Function<Result<RESULT>, RESULT> {
        public C0215b() {
        }

        public final Object apply(Object r4) throws Exception {
            Result r5 = (Result) r4;
            if (r5 == null) goto L11;
            if (r5.code != 0) goto L11;
            if (r5.getData() == null) goto L11;
            return r5.getData();
        L11:
            throw new Exception(C0215b.class.getSimpleName() + " access error: " + r5);
        }
    }

    public Type b() throws IllegalStateException {
        return new a(new Type[]{((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]}).getType();
    L5:
        e = move-exception;
        throw new IllegalStateException("BasePuller parseType() fail !!!", e);
    }

    public Map<String, Object> a(PARAMS r7) throws Exception {
        HashMap r0 = new HashMap();
        if (r7 == null) goto L11;
        Field[] r1 = r7.getClass().getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        Field r4 = r1[r3];
        r4.setAccessible(true);
        Object r5 = r4.get(r7);
        if (r5 == null) goto L10;
        r0.put(r4.getName(), r5);
    L10:
        r3 = r3 + 1;
    L11:
        return r0;
    }

    public final Flowable<RESULT> c(final PARAMS r13) {
        NetService.f r0 = new NetService.f(this.b);
        int r1 = this.c;
        ((NetService.e) r0).c = r1;
        if (r13 == null) goto L39;
        if (r1 == 2) goto L26;
        int r2 = this.d;
        if (r2 == 2) goto L26;
        if (r2 != 3) goto L25;
        HashMap r3 = new HashMap();
        HashMap r5 = new HashMap();     // Catch: Exception -> L22
        Field[] r6 = r13.getClass().getDeclaredFields();     // Catch: Exception -> L22
        int r7 = r6.length;     // Catch: Exception -> L22
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L21;
        Field r9 = r6[r8];     // Catch: Exception -> L22
        r9.setAccessible(true);     // Catch: Exception -> L22
        Object r10 = r9.get(r13);     // Catch: Exception -> L22
        if (r10 == null) goto L20;
        if ((r10 instanceof List) == true) goto L20;
        r5.put(r9.getName(), String.valueOf(r10));     // Catch: Exception -> L22
    L20:
        r8 = r8 + 1;
        goto L14
    L21:
        r3 = r5;
    L24:
        r0.d(r3);
    L22:
        e = move-exception;
        tt5.a.e("Wiki_BasePuller", "get request build urlParams fail. ", e, false);
        goto L24
    L25:
        ((NetService.e) r0).j = JSON.toJSONString(r13);
    L26:
        Map<String, Object> r4 = new HashMap();
        r4 = a(r13);     // Catch: Exception -> L29
    L31:
        Iterator<Map.Entry<String, Object>> r11 = r4.entrySet().iterator();
    L33:
        if (r11.hasNext() == false) goto L39;
        Map.Entry<String, Object> r12 = r11.next();
        Object r14 = r12.getValue();
        if ((r14 instanceof List) == true) goto L36;
        r0.b(r12.getKey(), String.valueOf(r14));
        goto L33
    L36:
        String r15 = r12.getKey();
        r0.a(r15, (List) r14);
    L29:
        e = move-exception;
        tt5.a.e("Wiki_BasePuller", "get request build urlParams fail. ", e, false);
    L39:
        return this.a.a(r0).map(new C0215b()).onErrorResumeNext(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.a(this, r13));
    }

    public final /* bridge */ /* synthetic */ Flowable d(Object r1) {
        return c((Serializable) r1);
    }

    public b(NetService r1, String r2, NetService.c r3) {
        this.b = r2;
        this.a = r1.Vc(r3);
        this.c = 2;
        this.d = 1;
    }

    public b(NetService r1, String r2, int r3, int r4) {
        this.b = r2;
        this.a = r1.Rb(b());
        this.c = r3;
        this.d = r4;
    }
}
