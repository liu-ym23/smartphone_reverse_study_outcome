package com.bytedance.locallife.dito.provider;

import com.bytedance.locallife.dito.data.DitoActionModel;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f258660i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoActionModel f258661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseDitoModel<?> f258663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f258664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<b<Object>, Unit> f258665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f258666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f258667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f258668h;

    /* JADX INFO: renamed from: com.bytedance.locallife.dito.provider.a$a, reason: collision with other inner class name */
    public static final class C3660a {
        public C3660a() {
        }

        public static a a(String r100, Map r101) {
            int r102 = a.f258660i;
            LinkedHashMap r103 = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r103, "extMap");
            return new a(new DitoActionModel(r100, r101, null), null, null, r103, null);
        }
    }

    static {
        new C3660a();
    }

    public final String getType() {
        return this.f258666f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(DitoActionModel r100, String r101, BaseDitoModel<?> r102, Map<String, ? extends Object> r103, Function1<? super b<Object>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "actionModel");
        Intrinsics.checkNotNullParameter(r103, "extMap");
        this.f258661a = r100;
        this.f258662b = r101;
        this.f258663c = r102;
        this.f258664d = r103;
        this.f258665e = r104;
        this.f258666f = r100.getType();
        this.f258667g = r100.getDitoParams();
        this.f258668h = r100.getParams();
    }

    public /* synthetic */ a(DitoActionModel r100, String r101, BaseDitoModel r102, Map r110, Function1 r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r110 = new LinkedHashMap();
    L5:
        Map r103 = r110;
        if ((r112 & 16) == 0) goto L8;
        r111 = null;
    L8:
        this(r100, r101, r102, r103, r111);
    }
}
