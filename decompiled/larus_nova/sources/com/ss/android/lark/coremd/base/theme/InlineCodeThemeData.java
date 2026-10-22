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
public final class InlineCodeThemeData extends a0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419569h = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419573g;

    static {
        f419569h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "showInlineCode", "getShowInlineCode()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeTextColorRes", "getInlineCodeTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeBackgroundColorRes", "getInlineCodeBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeTextSize", "getInlineCodeTextSize()I", 0))};
    }

    public InlineCodeThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.TRUE;
        Function1<j, Boolean> r102 = new InlineCodeThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419569h;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419570d = new c();
        final Integer r107 = Integer.valueOf(R.color.transparent);
        Function1<j, Integer> r108 = new InlineCodeThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419571e = new c();
        final Integer r110 = Integer.valueOf(R.color.bg_body);
        Function1<j, Integer> r111 = new InlineCodeThemeData$special$$inlined$extend$3(r110);
        Intrinsics.checkNotNullParameter(r111, "defaultProvider");
        KProperty<Object> r112 = r103[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r111, "value");
        r106.put(e.a(r112), r111);
        this.f419572f = new c();
        final int r113 = 17;
        Function1<j, Integer> r114 = new InlineCodeThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r103[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r106.put(e.a(r115), r114);
        this.f419573g = new c();
    }
}
