package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class DefaultEmptyView extends a implements com.bytedance.jedi.ext.adapter.decorator.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f250978d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f250979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f250980c;

    static {
        f250978d = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultEmptyView.class), "content", "getContent()Landroid/view/View;"))};
    }

    public DefaultEmptyView(final ViewGroup r100, Function0<Unit> r101) {
        this.f250980c = r101;
        this.f250979b = LazyKt.lazy(new DefaultEmptyView$content$2(this, r100));
    }
}
