package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.parse.FilterConditionDeserializer;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.larus.nova.R;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<T> implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FilterFieldOption f211973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f211974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f211975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f211976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vv4.k f211977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.a f211978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i.a f211979h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a$a, reason: collision with other inner class name */
    public static final class C3043a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public void a(EFilterStep.SubValueStep r100) {
    }

    public abstract T c();

    public void g(T r100) {
    }

    public abstract void h(T r100);

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i
    public String getTitle() {
        return this.f211972a.getString(R.string.Bitable_Relation_ConditionValue_Mobile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Object r100) {
        FilterFieldOption r101 = this.f211973b;     // Catch: Exception -> L15
        Object r102 = null;
        if (r101 != null) goto L5;
    L11:
        if (r100 != null) goto L13;
        r100 = null;
    L13:
        g(r100);     // Catch: Exception -> L15
    L18:
        return;
    L5:
        if (r101.isProxyType() == false) goto L11;
        EFieldType r103 = this.f211973b.getFieldCompositeType().getType();     // Catch: Exception -> L15
        EFieldType r104 = this.f211973b.getValueFieldType();     // Catch: Exception -> L15
        Map<EFieldType, Class<?>> r105 = FilterConditionDeserializer.f211883a;     // Catch: Exception -> L15
        Object r106 = FilterConditionDeserializer.a.b(r103, r104, r100);     // Catch: Exception -> L15
        if (r106 == null) goto L10;
        r102 = r106;
    L10:
        g(r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        tt5.a.b("BaseFilterValueEditViewHolder", "setFilterDisplayValue()... class cast failed, " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(Object r100) {
        FilterFieldOption r101 = this.f211973b;     // Catch: Exception -> L15
        Object r102 = null;
        if (r101 != null) goto L5;
    L11:
        if (r100 != null) goto L13;
        r100 = null;
    L13:
        h(r100);     // Catch: Exception -> L15
    L18:
        return;
    L5:
        if (r101.isProxyType() == false) goto L11;
        EFieldType r103 = this.f211973b.getFieldCompositeType().getType();     // Catch: Exception -> L15
        EFieldType r104 = this.f211973b.getValueFieldType();     // Catch: Exception -> L15
        Map<EFieldType, Class<?>> r105 = FilterConditionDeserializer.f211883a;     // Catch: Exception -> L15
        Object r106 = FilterConditionDeserializer.a.b(r103, r104, r100);     // Catch: Exception -> L15
        if (r106 == null) goto L10;
        r102 = r106;
    L10:
        h(r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        tt5.a.b("BaseFilterValueEditViewHolder", "setFilterValue()... class cast failed, " + e);
    }

    public a(Context r100, FilterFieldOption r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f211972a = r100;
        this.f211973b = r101;
    }

    public final <T> Single<T> d(String r110, String r111, boolean r112, Function1<? super String, ? extends T> r113) {
        Intrinsics.checkNotNullParameter(r110, PrefetchTiming.ROUTER);
        Intrinsics.checkNotNullParameter(r111, "keywords");
        Intrinsics.checkNotNullParameter(r113, "parser");
        com.bytedance.ee.bear.bitable.a r100 = this.f211978g;
        if (r100 == null) goto L22;
        BitableAsyncRequestBiz r101 = BitableAsyncRequestBiz.Toolbar;
        String r102 = this.f211974c;
        String r103 = "";
        if (r102 != null) goto L7;
        String r104 = "";
    L8:
        String r105 = this.f211975d;
        if (r105 != null) goto L11;
        String r106 = "";
    L12:
        Pair[] r107 = new Pair[4];
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r107[0] = TuplesKt.to("tableId", r105);
        FilterFieldOption r108 = this.f211973b;
        if (r108 == null) goto L21;
        String r109 = r108.getId();
        if (r109 == null) goto L21;
        r103 = r109;
    L21:
        r107[1] = TuplesKt.to("fieldId", r103);
        r107[2] = TuplesKt.to("keywords", r111);
        r107[3] = TuplesKt.to("showCurrentUserOption", Boolean.valueOf(r112));
        return r100.a(r101, r110, r104, r106, MapsKt.mapOf(r107), r113);
    L11:
        r106 = r105;
        goto L12
    L7:
        r104 = r102;
        goto L8
    L22:
        return null;
    }
}
