package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<WeakReference<Activity>, WeakReference<f>> f271329a = null;

    static {
        f271329a = new LinkedHashMap();
    }

    public static boolean a(Activity r100) {
        Iterator r101 = ((LinkedHashMap) f271329a).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        WeakReference r102 = (WeakReference) r101.next();
        if (Intrinsics.areEqual((Activity) r102.get(), r100) == false) goto L4;
        WeakReference r103 = (WeakReference) ((LinkedHashMap) f271329a).get(r102);
        if (r103 == null) goto L10;
        f r104 = (f) r103.get();
    L11:
        if (r104 == null) goto L13;
        return true;
    L10:
        r104 = null;
    L13:
        return false;
    }

    public static boolean b(Activity r100) {
        Iterator r101 = ((LinkedHashMap) f271329a).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        WeakReference r102 = (WeakReference) r101.next();
        if (Intrinsics.areEqual((Activity) r102.get(), r100) == false) goto L4;
        WeakReference r103 = (WeakReference) ((LinkedHashMap) f271329a).get(r102);
        if (r103 == null) goto L10;
        f r104 = (f) r103.get();
    L11:
        if (r104 == null) goto L13;
        return r104.P();
    L10:
        r104 = null;
    L13:
        return false;
    }
}
