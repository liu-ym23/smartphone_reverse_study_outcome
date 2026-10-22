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
public final class ThematicBreakThemeData extends a0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419583g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419586f;

    static {
        f419583g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "showThematicBreak", "getShowThematicBreak()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "thematicBreakColorRes", "getThematicBreakColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "thematicBreakHeight", "getThematicBreakHeight()I", 0))};
    }

    public ThematicBreakThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Boolean r111 = Boolean.TRUE;
        Function1<j, Boolean> r100 = new ThematicBreakThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f419583g;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f419584d = new c();
        final Integer r105 = Integer.valueOf(R.color.line_divider_default);
        Function1<j, Integer> r106 = new ThematicBreakThemeData$special$$inlined$extend$2(r105);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put(e.a(r107), r106);
        this.f419585e = new c();
        final int r108 = 1;
        Function1<j, Integer> r109 = new ThematicBreakThemeData$special$$inlined$extend$3(r108);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r112 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r112), r109);
        this.f419586f = new c();
    }
}
