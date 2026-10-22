package com.suite.lark.component.navroute.api;

import android.content.Context;
import com.suite.lark.component.navroute.api.a;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public interface f<T extends a<?, ?>> {
    f<? extends a<?, ?>> a();

    String b();

    h<T> c();

    String e();

    KClass<T> f();

    Context getContext();

    com.suite.lark.component.navroute.a getNavController();
}
