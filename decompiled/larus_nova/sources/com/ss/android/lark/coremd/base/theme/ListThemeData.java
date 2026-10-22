package com.ss.android.lark.coremd.base.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.coremd.base.parse.a0;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class ListThemeData extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419577i = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f419582h;

    static {
        f419577i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "showList", "getShowList()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listItemColorRes", "getListItemColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listFloorWidth", "getListFloorWidth()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listRightMargin", "getListRightMargin()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listLabelSize", "getListLabelSize()I", 0))};
    }

    public final int h() {
        return ((Number) this.f419580f.getValue(this, f419577i[2])).intValue();
    }

    public final int i() {
        return ((Number) this.f419579e.getValue(this, f419577i[1])).intValue();
    }

    public final int j() {
        return ((Number) this.f419582h.getValue(this, f419577i[4])).intValue();
    }

    public final float k() {
        return ((Number) this.f419581g.getValue(this, f419577i[3])).floatValue();
    }

    public final boolean l() {
        return ((Boolean) this.f419578d.getValue(this, f419577i[0])).booleanValue();
    }

    public ListThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.TRUE;
        Function1<j, Boolean> r102 = new ListThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419577i;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419578d = new c();
        final Integer r107 = Integer.valueOf(R.color.text_link_normal);
        Function1<j, Integer> r108 = new ListThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419579e = new c();
        final int r110 = 24;
        Function1<j, Integer> r111 = new ListThemeData$special$$inlined$extend$3(r110);
        Intrinsics.checkNotNullParameter(r111, "defaultProvider");
        KProperty<Object> r112 = r103[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r111, "value");
        r106.put(e.a(r112), r111);
        this.f419580f = new c();
        final Float r113 = Float.valueOf(2.0f);
        Function1<j, Float> r114 = new ListThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r103[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r106.put(e.a(r115), r114);
        this.f419581g = new c();
        final int r116 = 16;
        Function1<j, Integer> r117 = new ListThemeData$special$$inlined$extend$5(r116);
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r103[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r106.put(e.a(r118), r117);
        this.f419582h = new c();
    }
}
