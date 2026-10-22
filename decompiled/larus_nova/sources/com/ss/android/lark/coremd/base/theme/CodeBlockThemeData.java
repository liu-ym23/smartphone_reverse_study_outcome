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
public class CodeBlockThemeData extends a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419554j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f419559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419560i;

    static {
        f419554j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "showCodeBlock", "getShowCodeBlock()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockBaseColorRes", "getCodeBlockBaseColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockHeadingColorRes", "getCodeBlockHeadingColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockBackgroundColorRes", "getCodeBlockBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockTextSize", "getCodeBlockTextSize()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockRadius", "getCodeBlockRadius()F", 0))};
    }

    public final boolean h() {
        return ((Boolean) this.f419555d.getValue(this, f419554j[0])).booleanValue();
    }

    public CodeBlockThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.TRUE;
        Function1<j, Boolean> r102 = new CodeBlockThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419554j;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419555d = new c();
        final Integer r107 = Integer.valueOf(R.color.ud_N900);
        Function1<j, Integer> r108 = new CodeBlockThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419556e = new c();
        final Integer r110 = Integer.valueOf(R.color.ud_N500);
        Function1<j, Integer> r111 = new CodeBlockThemeData$special$$inlined$extend$3(r110);
        Intrinsics.checkNotNullParameter(r111, "defaultProvider");
        KProperty<Object> r112 = r103[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r111, "value");
        r106.put(e.a(r112), r111);
        this.f419557f = new c();
        final Integer r113 = Integer.valueOf(R.color.ud_N200);
        Function1<j, Integer> r114 = new CodeBlockThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r103[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r106.put(e.a(r115), r114);
        this.f419558g = new c();
        final int r116 = 14;
        Function1<j, Integer> r117 = new CodeBlockThemeData$special$$inlined$extend$5(r116);
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r103[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r106.put(e.a(r118), r117);
        this.f419559h = new c();
        final Float r119 = Float.valueOf(12.0f);
        Function1<j, Float> r120 = new CodeBlockThemeData$special$$inlined$extend$6(r119);
        Intrinsics.checkNotNullParameter(r120, "defaultProvider");
        KProperty<Object> r121 = r103[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r121, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r121, "kProperty");
        Intrinsics.checkNotNullParameter(r120, "value");
        r106.put(e.a(r121), r120);
        this.f419560i = new c();
    }
}
