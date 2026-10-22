package com.ss.android.lark.coremdbiz.facade.bizext.theme;

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
public class LarkAtThemeData extends a0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420030k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f420032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f420033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f420034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f420035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f420036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f420037j;

    static {
        f420030k = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "showAt", "getShowAt()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atColorRes", "getAtColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "showAtSelfStyle", "getShowAtSelfStyle()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atSelfTextColorRes", "getAtSelfTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atSelfBgColor", "getAtSelfBgColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atTextSize", "getAtTextSize()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "enableUnifyAtStyle", "getEnableUnifyAtStyle()Lcom/ss/android/lark/coremdbiz/facade/bizext/configs/UnifyAtStyleConfig;", 0))};
    }

    public final int h() {
        return ((Number) this.f420032e.getValue(this, f420030k[1])).intValue();
    }

    public final z9b.c i() {
        return (z9b.c) this.f420037j.getValue(this, f420030k[6]);
    }

    public final boolean j() {
        return ((Boolean) this.f420031d.getValue(this, f420030k[0])).booleanValue();
    }

    public LarkAtThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Boolean r111 = Boolean.TRUE;
        Function1<j, Boolean> r100 = new LarkAtThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f420030k;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f420031d = new c();
        final Integer r105 = Integer.valueOf(R.color.imtoken_message_text_bubbles_blue);
        Function1<j, Integer> r106 = new LarkAtThemeData$special$$inlined$extend$2(r105);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put(e.a(r107), r106);
        this.f420032e = new c();
        Function1<j, Boolean> r108 = new LarkAtThemeData$special$$inlined$extend$3(r111);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r112 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r104.put(e.a(r112), r108);
        this.f420033f = new c();
        final Integer r113 = Integer.valueOf(R.color.static_white);
        Function1<j, Integer> r109 = new LarkAtThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r114 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r114, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r114, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r114), r109);
        this.f420034g = new c();
        final Integer r115 = Integer.valueOf(R.color.primary_fill_default);
        Function1<j, Integer> r116 = new LarkAtThemeData$special$$inlined$extend$5(r115);
        Intrinsics.checkNotNullParameter(r116, "defaultProvider");
        KProperty<Object> r117 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r117, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r117, "kProperty");
        Intrinsics.checkNotNullParameter(r116, "value");
        r104.put(e.a(r117), r116);
        this.f420035h = new c();
        final Float r118 = Float.valueOf(17.0f);
        Function1<j, Float> r119 = new LarkAtThemeData$special$$inlined$extend$6(r118);
        Intrinsics.checkNotNullParameter(r119, "defaultProvider");
        KProperty<Object> r120 = r101[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r120, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r120, "kProperty");
        Intrinsics.checkNotNullParameter(r119, "value");
        r104.put(e.a(r120), r119);
        this.f420036i = new c();
        final z9b.c r121 = new z9b.c(R.color.static_black, R.color.static_black, 8);
        Function1<j, z9b.c> r122 = new LarkAtThemeData$special$$inlined$extend$7(r121);
        Intrinsics.checkNotNullParameter(r122, "defaultProvider");
        KProperty<Object> r123 = r101[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r123, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r123, "kProperty");
        Intrinsics.checkNotNullParameter(r122, "value");
        r104.put(e.a(r123), r122);
        this.f420037j = new c();
    }

    public final void k(float r100) {
        this.f420036i.setValue(this, f420030k[5], Float.valueOf(r100));
    }
}
