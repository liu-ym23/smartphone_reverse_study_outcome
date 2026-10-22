package com.ss.android.lark.coremd.nonimbiz.calendar;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class CalendarContextExtend implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419922d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f419923c;

    public static final class a implements h<CalendarContextExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419924c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (CalendarContextExtend) this.f419924c.a();
        }

        public a() {
            this.f419924c = new ExtendProviderImpl(CalendarContextExtend.class);
        }
    }

    static {
        f419922d = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(CalendarContextExtend.class, "isFoldMessage", "isFoldMessage(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0))};
        new a();
    }

    public CalendarContextExtend() {
        final Boolean r100 = Boolean.FALSE;
        Function1<j, Boolean> r101 = new CalendarContextExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object> r102 = f419922d[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        d.f419619a.put(e.a(r102), r101);
        this.f419923c = new c();
    }
}
