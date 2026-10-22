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
public final class LarkTableThemeData extends a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420074e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420075d;

    static {
        f420074e = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkTableThemeData.class, "showTableDetail", "getShowTableDetail()Z", 0))};
    }

    public final void h() {
        this.f420075d.setValue(this, f420074e[0], Boolean.TRUE);
    }

    public LarkTableThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.FALSE;
        Function1<j, Boolean> r102 = new LarkTableThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object> r103 = f420074e[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        d.f419619a.put(e.a(r103), r102);
        this.f420075d = new c();
    }
}
