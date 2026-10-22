package com.bytedance.locallife.dito.model;

import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoActionModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.utils.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class BaseDitoModel<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f258491i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoViewModel f258492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f258493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f258494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f258495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f258496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f258497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f258498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f258499h;

    public static final class a {
    }

    static {
    }

    public void h() {
    }

    public final T c() {
        DitoNode r100 = this.f258493b.f258221a;
        if (r100 == null) goto L5;
        Object r101 = r100.getRawData();
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        return (T) r101;
    L5:
        r101 = null;
        goto L6
    }

    public String f() {
        DitoNode r100 = this.f258493b.f258221a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L15;
        DitoNode r102 = this.f258493b.f258221a;
        if (r102 == null) goto L13;
        String r103 = r102.getSubType();
        if (r103 == null) goto L13;
        return r103;
    L13:
        return "";
    L15:
        return this.f258493b.f258222b;
    L5:
        if (r100.isStickNode() != true) goto L7;
        r101 = true;
        goto L7
    }

    public void g() {
        this.f258492a.f258041g.b0().setValue(this);
        j.o(this.f258492a, new BaseDitoModel$modelCreate$1(this));
    }

    public static Class d(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        Type r101 = r100.getGenericSuperclass();
        if ((r101 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r102 = (ParameterizedType) r101;
    L6:
        if (r102 == null) goto L10;
        Type[] r103 = r102.getActualTypeArguments();
        if (r103 == null) goto L10;
        Type r104 = r103[0];
    L11:
        if (r104 != null) goto L16;
        if (r100.getSuperclass() == null) goto L16;
        r104 = d(r100.getSuperclass());
    L16:
        if ((r104 instanceof Class) == true) goto L18;
        return null;
    L18:
        return (Class) r104;
    L10:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public Object a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        return GsonProtectorUtils.fromJson(this.f258492a.f258047m, r100, d(getClass()));
    }

    public final List<DitoActionModel> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        DitoNode r101 = this.f258493b.f258221a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getActions(r100);
    }

    public final Object e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((LinkedHashMap) this.f258499h).get(r100);
    }

    public BaseDitoModel(DitoViewModel r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "treeNode");
        this.f258492a = r100;
        this.f258493b = r101;
        this.f258494c = -1;
        this.f258495d = true;
        this.f258496e = new LinkedHashMap();
        this.f258498g = new b();
        this.f258499h = new LinkedHashMap();
    }

    public final void i(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f258499h.put(r100, r101);
    }
}
