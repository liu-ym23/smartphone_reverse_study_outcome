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
public class LinkThemeData extends a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419574f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419576e;

    static {
        f419574f = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinkThemeData.class, "showLink", "getShowLink()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinkThemeData.class, "linkColorRes", "getLinkColorRes()I", 0))};
    }

    public final int h() {
        return ((Number) this.f419576e.getValue(this, f419574f[1])).intValue();
    }

    public final boolean i() {
        return ((Boolean) this.f419575d.getValue(this, f419574f[0])).booleanValue();
    }

    public LinkThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Boolean r101 = Boolean.TRUE;
        Function1<j, Boolean> r102 = new LinkThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419574f;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419575d = new c();
        final Integer r107 = Integer.valueOf(R.color.text_link_normal);
        Function1<j, Integer> r108 = new LinkThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419576e = new c();
    }
}
