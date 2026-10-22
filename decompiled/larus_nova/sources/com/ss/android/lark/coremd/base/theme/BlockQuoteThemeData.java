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
public final class BlockQuoteThemeData extends a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419547j = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f419552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419553i;

    static {
        f419547j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "showBlockQuote", "getShowBlockQuote()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteWidth", "getBlockQuoteWidth()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteVerticalPadding", "getBlockQuoteVerticalPadding()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteColorRes", "getBlockQuoteColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteTextMargin", "getBlockQuoteTextMargin()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "quoteTextColorRes", "getQuoteTextColorRes()I", 0))};
    }

    public BlockQuoteThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Boolean r111 = Boolean.TRUE;
        Function1<j, Boolean> r100 = new BlockQuoteThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f419547j;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f419548d = new c();
        final int r105 = 2;
        Function1<j, Integer> r106 = new BlockQuoteThemeData$special$$inlined$extend$2(r105);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put(e.a(r107), r106);
        this.f419549e = new c();
        final int r108 = 4;
        Function1<j, Integer> r109 = new BlockQuoteThemeData$special$$inlined$extend$3(r108);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r112 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r112), r109);
        this.f419550f = new c();
        final Integer r113 = Integer.valueOf(R.color.udtoken_quote_bar_bg);
        Function1<j, Integer> r114 = new BlockQuoteThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r104.put(e.a(r115), r114);
        this.f419551g = new c();
        final int r116 = 10;
        Function1<j, Integer> r117 = new BlockQuoteThemeData$special$$inlined$extend$5(r116);
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r104.put(e.a(r118), r117);
        this.f419552h = new c();
        final Integer r119 = Integer.valueOf(R.color.text_caption);
        Function1<j, Integer> r120 = new BlockQuoteThemeData$special$$inlined$extend$6(r119);
        Intrinsics.checkNotNullParameter(r120, "defaultProvider");
        KProperty<Object> r121 = r101[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r121, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r121, "kProperty");
        Intrinsics.checkNotNullParameter(r120, "value");
        r104.put(e.a(r121), r120);
        this.f419553i = new c();
    }
}
