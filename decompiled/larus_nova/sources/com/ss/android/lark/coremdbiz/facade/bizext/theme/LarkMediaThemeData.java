package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.facebook.keyframes.model.KFAnimation;
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
public class LarkMediaThemeData extends a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420063j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f420065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f420066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f420067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f420068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f420069i;

    static {
        f420063j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "showMediaDetail", "getShowMediaDetail()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingLeft", "getPaddingLeft()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingTop", "getPaddingTop()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingRight", "getPaddingRight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingBottom", "getPaddingBottom()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "alignment", "getAlignment()I", 0))};
    }

    public LarkMediaThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Boolean r111 = Boolean.TRUE;
        Function1<j, Boolean> r100 = new LarkMediaThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f420063j;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f420064d = new c();
        final Float r105 = Float.valueOf(0.0f);
        Function1<j, Float> r106 = new LarkMediaThemeData$special$$inlined$extend$2(r105);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put(e.a(r107), r106);
        this.f420065e = new c();
        Function1<j, Float> r108 = new LarkMediaThemeData$special$$inlined$extend$3(r105);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r104.put(e.a(r109), r108);
        this.f420066f = new c();
        Function1<j, Float> r112 = new LarkMediaThemeData$special$$inlined$extend$4(r105);
        Intrinsics.checkNotNullParameter(r112, "defaultProvider");
        KProperty<Object> r113 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r113, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r113, "kProperty");
        Intrinsics.checkNotNullParameter(r112, "value");
        r104.put(e.a(r113), r112);
        this.f420067g = new c();
        Function1<j, Float> r114 = new LarkMediaThemeData$special$$inlined$extend$5(r105);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r104.put(e.a(r115), r114);
        this.f420068h = new c();
        final int r116 = 0;
        Function1<j, Integer> r117 = new LarkMediaThemeData$special$$inlined$extend$6(r116);
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r101[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r104.put(e.a(r118), r117);
        this.f420069i = new c();
    }
}
