package com.bytedance.ies.bullet.pool.util;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.e;
import com.bytedance.ies.bullet.service.base.f;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class PoolUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f247494a = null;

    static {
        f247494a = View.class.getDeclaredField("mContext");
    }

    public static final void a(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        g(r100, new PoolUtilKt$removeParent$1(r100));
    }

    public static final BulletContainerView e(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof BulletContainerView) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        return (BulletContainerView) r100;
    }

    public static final f f(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f(r100.f247885a, r100.f247886b, r100.f247888d);
    }

    public static final void b(View r100, Context r101) {
        Field r102 = f247494a;     // Catch: Exception -> L14
        if (r102 != null) goto L5;
        return;
    L5:
        monitor-enter(View.class);     // Catch: Exception -> L14
        r102.setAccessible(true);     // Catch: Throwable -> L10
        r102.set(r100, r101);     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(View.class);     // Catch: Exception -> L14
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    }

    public static final void c(View r100, Context r101) {
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L4:
        if ((r100.getContext() instanceof Activity) == true) goto L6;
    L7:
        b(r100, r101);     // Catch: Throwable -> L16
        if ((r100 instanceof ViewGroup) == false) goto L13;
        Iterator<View> r102 = new b((ViewGroup) r100).iterator();     // Catch: Throwable -> L16
    L11:
        if (r102.hasNext() == false) goto L13;
        c(r102.next(), r101);     // Catch: Throwable -> L16
    L13:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L6:
        if (Intrinsics.areEqual(r100.getContext(), r101) == true) goto L13;
        goto L7
    }

    public static final void g(View r100, Function1<? super ViewGroup, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, JSEventListener.ACTION_RESOLVE);
        ViewParent r102 = r100.getParent();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof ViewGroup) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L12;
        r101.invoke((ViewGroup) r102);
        return;
    }

    public static final boolean d(View r100, BulletContainerView r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "originView");
        final BulletContainerView r104 = e(r100);
        final BulletContainerView r105 = e(r101);
        if (r104 == null) goto L43;
        if (r105 == null) goto L45;
        Map<String, m16.b> r106 = c36.a.f22277a;
        BulletContext r107 = r104.getBulletContext();
        com.bytedance.ies.bullet.core.e r108 = null;
        if (r107 == null) goto L9;
        String r109 = r107.getSessionId();
    L10:
        c36.a.b(r109, r104.getProviderFactory());
        BulletContext r110 = r104.getBulletContext();
        if (r110 == null) goto L13;
        String r111 = r110.getSessionId();
    L14:
        c36.a.a(r111).d(Context.class, r101.getContext());
        Context r112 = r101.getContext();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r113 = r104.getContext();
        if (r113 != null) goto L17;
    L22:
        MutableContextWrapper r114 = null;
    L23:
        if (r114 == null) goto L25;
        r114.setBaseContext(r112);
    L25:
        c(r104, r101.getContext());
        if (r102 == false) goto L34;
        CacheType r115 = CacheType.PRE_RENDER;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r115, "cacheType");
        BulletContext r116 = r104.getBulletContext();
        if (r116 == null) goto L30;
        com.bytedance.ies.bullet.core.e r117 = r116.f246455w;
    L31:
        if (r117 == null) goto L34;
        r117.f246477e = r115;
        goto L34
    L30:
        r117 = null;
    L34:
        if (r103 == false) goto L41;
        CacheType r118 = CacheType.REUSE;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r118, "cacheType");
        BulletContext r119 = r104.getBulletContext();
        if (r119 == null) goto L38;
        r108 = r119.f246455w;
    L38:
        if (r108 == null) goto L41;
        r108.f246477e = r118;
    L41:
        r105.release();
        a(r104);
        g(r105, new PoolUtilKt$replaceView$1(r105, r104));
        return true;
    L17:
        if ((r113 instanceof MutableContextWrapper) == true) goto L20;
        r113 = null;
    L20:
        if (r113 == null) goto L22;
        r114 = (MutableContextWrapper) r113;
        goto L23
    L13:
        r111 = null;
        goto L14
    L9:
        r109 = null;
        goto L10
    L45:
        return false;
    L43:
        return false;
    }
}
