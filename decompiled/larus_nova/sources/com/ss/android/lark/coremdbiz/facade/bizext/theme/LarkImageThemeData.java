package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.base.theme.ImageThemeData;
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
public class LarkImageThemeData extends ImageThemeData {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420049l = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f420050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f420051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f420052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f420053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f420054k;

    static {
        f420049l = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingLeft", "getPaddingLeft()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingTop", "getPaddingTop()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingRight", "getPaddingRight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingBottom", "getPaddingBottom()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "alignment", "getAlignment()I", 0))};
    }

    public final float h() {
        return ((Number) this.f420053j.getValue(this, f420049l[3])).floatValue();
    }

    public final float i() {
        return ((Number) this.f420050g.getValue(this, f420049l[0])).floatValue();
    }

    public final float j() {
        return ((Number) this.f420051h.getValue(this, f420049l[1])).floatValue();
    }

    public LarkImageThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Float r111 = Float.valueOf(0.0f);
        Function1<j, Float> r100 = new LarkImageThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f420049l;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f420050g = new c();
        Function1<j, Float> r105 = new LarkImageThemeData$special$$inlined$extend$2(r111);
        Intrinsics.checkNotNullParameter(r105, "defaultProvider");
        KProperty<Object> r106 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r106, "kProperty");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.put(e.a(r106), r105);
        this.f420051h = new c();
        Function1<j, Float> r107 = new LarkImageThemeData$special$$inlined$extend$3(r111);
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r104.put(e.a(r108), r107);
        this.f420052i = new c();
        Function1<j, Float> r109 = new LarkImageThemeData$special$$inlined$extend$4(r111);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r112 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r112), r109);
        this.f420053j = new c();
        final int r113 = 0;
        Function1<j, Integer> r114 = new LarkImageThemeData$special$$inlined$extend$5(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r104.put(e.a(r115), r114);
        this.f420054k = new c();
    }
}
