package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class RecyclerViewExKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f450775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f450776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f450777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f450778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f450779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f450780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f450781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f450782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f450783i;

    public static final boolean c(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isInvalid");
        if (f450777c != null) goto L5;
        ReflectUtil.f450784a.getClass();
        f450777c = ReflectUtil.b(r100, "isInvalid", new Class[0]);
    L5:
        Method r101 = f450777c;
        if (r101 == null) goto L8;
        Object r102 = r101.invoke(r100, new Object[0]);
    L9:
        if (r102 == null) goto L13;
        return ((Boolean) r102).booleanValue();
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L8:
        r102 = null;
        goto L9
    }

    public static final boolean a(RecyclerView r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$checkLayoutParams");
        Intrinsics.checkNotNullParameter(r101, "lp");
        if (f450780f != null) goto L5;
        ReflectUtil.f450784a.getClass();
        f450780f = ReflectUtil.b(r100, "checkLayoutParams", new Class[]{ViewGroup.LayoutParams.class});
    L5:
        Method r102 = f450780f;
        if (r102 == null) goto L8;
        Object r103 = r102.invoke(r100, new Object[]{r101});
    L9:
        if (r103 == null) goto L13;
        return ((Boolean) r103).booleanValue();
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L8:
        r103 = null;
        goto L9
    }

    public static final RecyclerView.LayoutParams b(RecyclerView r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$generateLayoutParams");
        Intrinsics.checkNotNullParameter(r101, "lp");
        if (f450779e != null) goto L5;
        ReflectUtil.f450784a.getClass();
        f450779e = ReflectUtil.b(r100, "generateLayoutParams", new Class[]{ViewGroup.LayoutParams.class});
    L5:
        Method r102 = f450779e;
        Object r103 = null;
        if (r102 == null) goto L8;
        Object r104 = r102.invoke(r100, new Object[]{r101});
    L10:
        if ((r104 instanceof RecyclerView.LayoutParams) == false) goto L14;
        r103 = r104;
    L14:
        return (RecyclerView.LayoutParams) r103;
    L8:
        r104 = null;
        goto L10
    }

    public static final void d(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setPosition");
        if (f450775a != null) goto L5;
        ReflectUtil.f450784a.getClass();
        f450775a = ReflectUtil.a(r100, "mPosition");
    L5:
        Field r102 = f450775a;
        if (r102 == null) goto L9;
        r102.set(r100, Integer.valueOf(r101));
        return;
    }
}
