package com.ss.android.lark.coremd.facade.mdeditor.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMEditorAtThemeData extends LarkAtThemeData {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419768n = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f419770m;

    static {
        f419768n = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMEditorAtThemeData.class, "parseAtChatter", "getParseAtChatter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMEditorAtThemeData.class, "showAtAll", "getShowAtAll()Z", 0))};
    }

    public IMEditorAtThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.FALSE;
        Function1<j, Boolean> r102 = new IMEditorAtThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419768n;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419769l = new c();
        final Boolean r107 = Boolean.TRUE;
        Function1<j, Boolean> r108 = new IMEditorAtThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419770m = new c();
    }
}
