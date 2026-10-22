package com.suite.lark.platform.component.widgetrenderinterceptor;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import com.suite.lark.platform.component.widgetrenderinterceptor.interceptor.CSAMImageRenderInterceptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f461188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMBizImageRenderInterceptor.a f461189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kpc.a f461190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f461191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f461192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<BizInterceptorType, IMBizImageRenderInterceptor> f461193f;

    /* JADX INFO: renamed from: com.suite.lark.platform.component.widgetrenderinterceptor.a$a, reason: collision with other inner class name */
    public static class C5532a<T extends C5532a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f461194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IMBizImageRenderInterceptor.a f461195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final kpc.a f461196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<BizInterceptorType, IMBizImageRenderInterceptor> f461197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<BizInterceptorType> f461198e;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.widgetrenderinterceptor.a$a$a, reason: collision with other inner class name */
        public static final class C5533a<T> implements Comparator {
            public C5533a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BizInterceptorType) r101).getPriority()), Integer.valueOf(((BizInterceptorType) r100).getPriority()));
            }
        }

        public final Context getContext() {
            return this.f461194a;
        }

        public final void b(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "used");
            List<BizInterceptorType> r101 = this.f461198e;
            ArrayList r102 = (ArrayList) r101;
            r102.addAll(ArraysKt.toList((Object[]) r100.invoke()));
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.suite.lark.platform.component.widgetrenderinterceptor.ImBizImageRender.BaseRender");
        }

        public final Map<BizInterceptorType, IMBizImageRenderInterceptor> a(Map<BizInterceptorType, IMBizImageRenderInterceptor> r100, IMBizImageRenderInterceptor.Scene r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Map<BizInterceptorType, IMBizImageRenderInterceptor> r102 = this.f461197d;
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r104 = r102.entrySet().iterator();
        L4:
            if (r104.hasNext() == false) goto L13;
            Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor> r105 = r104.next();
            boolean r106 = true;
            if (r101 != null) goto L8;
        L11:
            if (r106 == false) goto L4;
            r103.put(r105.getKey(), r105.getValue());
            goto L4
        L8:
            if (r105.getValue().c() == r101) goto L11;
            r106 = false;
            goto L11
        L13:
            SortedMap r107 = MapsKt.toSortedMap(r103, new C5533a());
            LinkedHashMap r108 = new LinkedHashMap();
            Iterator r109 = r107.entrySet().iterator();
        L15:
            if (r109.hasNext() == false) goto L20;
            Map.Entry r110 = (Map.Entry) r109.next();
            BizInterceptorType r111 = (BizInterceptorType) r110.getKey();
            if (((ArrayList) this.f461198e).contains(r111) == false) goto L15;
            r108.put(r110.getKey(), r110.getValue());
            goto L15
        L20:
            return MapsKt.toMutableMap(r108);
        }

        public C5532a(Context r100, IMBizImageRenderInterceptor.a r101, kpc.a r102, Map<BizInterceptorType, IMBizImageRenderInterceptor> r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "viewProvider");
            Intrinsics.checkNotNullParameter(r102, "interceptData");
            Intrinsics.checkNotNullParameter(r103, "imageRenderInterceptors");
            this.f461194a = r100;
            this.f461195b = r101;
            this.f461196c = r102;
            this.f461197d = r103;
            this.f461198e = new ArrayList();
        }
    }

    public static final class b {
    }

    public static final class c extends C5532a<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function0<Unit> f461199f;

        public c(Context r100, IMBizImageRenderInterceptor.a r101, kpc.a r102, Map<BizInterceptorType, IMBizImageRenderInterceptor> r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "viewProvider");
            Intrinsics.checkNotNullParameter(r102, "interceptData");
            Intrinsics.checkNotNullParameter(r103, "imageRenderInterceptors");
            super(r100, r101, r102, r103);
        }
    }

    public static final class d extends C5532a<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function0<Unit> f461200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public IMBizImageRenderInterceptor.b f461201g;

        public d(Context r100, IMBizImageRenderInterceptor.a r101, kpc.a r102, Map<BizInterceptorType, IMBizImageRenderInterceptor> r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "viewProvider");
            Intrinsics.checkNotNullParameter(r102, "interceptData");
            Intrinsics.checkNotNullParameter(r103, "imageRenderInterceptors");
            super(r100, r101, r102, r103);
            new ArrayList();
        }
    }

    static {
    }

    public final void a() {
        c r100 = this.f461192e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f461199f != null) goto L7;
        Log.e("ImBizImageRender", "no image click setup!");
        return;
    L7:
        Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r101 = r100.a(r100.f461197d, null).entrySet().iterator();
        boolean r102 = false;
    L9:
        if (r101.hasNext() == false) goto L13;
        IMBizImageRenderInterceptor r103 = r101.next().getValue();
        if (r103.a(r100.getContext(), r100.f461195b, r100.f461196c).invoke().booleanValue() == false) goto L9;
        Log.i("ImBizImageRender", "image click by renderInterceptor: " + r103.getType());
        r102 = true;
        goto L9
    L13:
        if (r102 == true) goto L25;
        Function0<Unit> r104 = r100.f461199f;
        if (r104 == null) goto L26;
        r104.invoke();
        return;
    L26:
        return;
    }

    public final void d() {
        d r100 = this.f461191d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f461200f != null) goto L7;
        Log.e("ImBizImageRender", "no image render setup!");
        return;
    L7:
        Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r101 = r100.a(r100.f461197d, IMBizImageRenderInterceptor.Scene.BeforeRender).entrySet().iterator();
        boolean r102 = false;
    L9:
        if (r101.hasNext() == false) goto L13;
        IMBizImageRenderInterceptor r103 = r101.next().getValue();
        if (r103.b(r100.getContext(), r100.f461195b, r100.f461196c, r100.f461201g).invoke().booleanValue() == false) goto L9;
        Log.i("ImBizImageRender", "image render by renderInterceptor: " + r103.getType());
        r102 = true;
        goto L9
    L13:
        if (r102 == true) goto L25;
        Function0<Unit> r104 = r100.f461200f;
        if (r104 == null) goto L26;
        r104.invoke();
        return;
    L26:
        return;
    }

    public final Context getContext() {
        return this.f461188a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f461188a = r100;
        EnumMap r101 = new EnumMap(BizInterceptorType.class);
        this.f461193f = r101;
        r101.put(BizInterceptorType.CSAM_DELETE, new CSAMImageRenderInterceptor());
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "imageClick");
        IMBizImageRenderInterceptor.a r101 = this.f461189b;
        if (r101 == null) goto L9;
        kpc.a r102 = this.f461190c;
        if (r102 == null) goto L9;
        c r103 = new c(this.f461188a, r101, r102, this.f461193f);
        r100.invoke(r103);
        this.f461192e = r103;
        return;
    L9:
        Log.e("ImBizImageRender", "render not build complete");
    }

    public final void c(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "imageRender");
        IMBizImageRenderInterceptor.a r101 = this.f461189b;
        if (r101 == null) goto L9;
        kpc.a r102 = this.f461190c;
        if (r102 == null) goto L9;
        d r103 = new d(this.f461188a, r101, r102, this.f461193f);
        r100.invoke(r103);
        this.f461191d = r103;
        return;
    L9:
        Log.e("ImBizImageRender", "render not build complete");
    }
}
