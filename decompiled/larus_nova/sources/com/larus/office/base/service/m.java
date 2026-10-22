package com.larus.office.base.service;

import com.larus.office.base.plugins.toast.ToastPluginV2;
import java.lang.ref.WeakReference;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f361113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f361114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, vm9.d> f361115c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static vm9.a f361116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ym9.c> f361117e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static WeakReference<ToastPluginV2> f361118f;

    public m() {
    }

    static {
        f361113a = LazyKt.lazy(new l());
        f361114b = new ConcurrentHashMap();
        f361115c = new ConcurrentHashMap();
        f361117e = new ConcurrentHashMap();
    }

    public static vm9.d b() {
        Intrinsics.checkNotNullParameter("default_doc_logic_key", "docKey");
        return f361115c.get("default_doc_logic_key");
    }

    public static /* synthetic */ b d() {
        return c("default_doc_logic_key");
    }

    public static ym9.c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "docKey");
        return f361117e.get(r100);
    }

    public static b c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "docLogicKey");
        n r101 = (n) f361113a.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "id");
        CopyOnWriteArrayList<b> r102 = r101.f361119a;
        ListIterator<b> r103 = r102.listIterator(r102.size());
    L3:
        String r104 = null;
        if (r103.hasPrevious() == false) goto L11;
        b r105 = r103.previous();
        Function0<String> r106 = r105.getIdGetter();
        if (r106 == null) goto L9;
        r104 = r106.invoke();
    L9:
        if (Intrinsics.areEqual(r104, r100) == false) goto L3;
        r104 = r105;
    L11:
        b r107 = (b) r104;
        if (r107 == null) goto L14;
        return r107;
    L14:
        return (n) f361113a.getValue();
    }

    public static c e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "docKey");
        return f361114b.get(r100);
    }

    public static void f(vm9.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "docKey");
        if (r100 != null) goto L6;
        f361115c.remove(r101);
        return;
    L6:
        f361115c.put(r101, r100);
    }

    public static void g(c r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "docKey");
        if (r100 != null) goto L6;
        f361114b.remove(r101);
        return;
    L6:
        f361114b.put(r101, r100);
    }
}
