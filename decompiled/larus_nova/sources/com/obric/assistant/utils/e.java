package com.obric.assistant.utils;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393874a = 0;

    static {
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "activityClass");
        List<Activity> r101 = AppHost.f326268a.a().g();
        ListIterator<Activity> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        Object r103 = r102.previous();
        if (r100.isInstance((Activity) r103) == false) goto L4;
    L9:
        Activity r104 = (Activity) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r104.getTaskId() != 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        List<Activity> r106 = AppHost.f326268a.a().m();
        if ((true ^ r106.contains(r104)) == false) goto L22;
        Object r107 = (Activity) CollectionsKt.getOrNull(r101, r101.lastIndexOf(r104) - 1);
        if (r107 != null) goto L26;
    L31:
        return null;
    L26:
        if (r100.isInstance(r107) == false) goto L31;
        if (r106.contains(r107) == false) goto L31;
        return r100.cast(r107);
    L22:
        return r100.cast(r104);
    L18:
        return r100.cast(r104);
    L15:
        r105 = false;
        goto L16
    L8:
        r103 = null;
        goto L9
    }
}
