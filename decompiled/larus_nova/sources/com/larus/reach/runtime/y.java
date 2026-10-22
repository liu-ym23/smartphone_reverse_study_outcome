package com.larus.reach.runtime;

import com.larus.reach.api.ReachPresentationCapabilityProvider;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, ? extends List<? extends ReachSceneLifecycleListener>> f367359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, ? extends List<? extends ReachSceneInterceptor>> f367360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, ? extends List<? extends ReachPresentationCapabilityProvider>> f367361c;

    static {
    }

    public static Map b() {
        Map<String, ? extends List<? extends ReachPresentationCapabilityProvider>> r100 = f367361c;
        if (r100 != null) goto L19;
        Set r101 = ServiceManager.get().getServices(ReachPresentationCapabilityProvider.class, true);
        if (r101 != null) goto L7;
        r101 = SetsKt.emptySet();
    L7:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        String r105 = ((ReachPresentationCapabilityProvider) r104).a();
        Object r106 = r102.get(r105);
        if (r106 != null) goto L13;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L13:
        ((List) r106).add(r104);
        goto L9
    L14:
        f367361c = r102;
        return r102;
    L19:
        return r100;
    }

    public static Map e() {
        Map<String, ? extends List<? extends ReachSceneInterceptor>> r100 = f367360b;
        if (r100 != null) goto L19;
        Set r101 = ServiceManager.get().getServices(ReachSceneInterceptor.class, true);
        if (r101 != null) goto L7;
        r101 = SetsKt.emptySet();
    L7:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        String r105 = ((ReachSceneInterceptor) r104).a();
        Object r106 = r102.get(r105);
        if (r106 != null) goto L13;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L13:
        ((List) r106).add(r104);
        goto L9
    L14:
        f367360b = r102;
        return r102;
    L19:
        return r100;
    }

    public static Map g() {
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r100 = f367359a;
        if (r100 != null) goto L19;
        Set r101 = ServiceManager.get().getServices(ReachSceneLifecycleListener.class, true);
        if (r101 != null) goto L7;
        r101 = SetsKt.emptySet();
    L7:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        String r105 = ((ReachSceneLifecycleListener) r104).a();
        Object r106 = r102.get(r105);
        if (r106 != null) goto L13;
        r106 = new ArrayList();
        r102.put(r105, r106);
    L13:
        ((List) r106).add(r104);
        goto L9
    L14:
        f367359a = r102;
        return r102;
    L19:
        return r100;
    }

    public static boolean a(ns9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        List r101 = f(r100.f520408a.f520395c);
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L24;
        ReachSceneInterceptor r103 = (ReachSceneInterceptor) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r103.f(r100)));     // Catch: Throwable -> L13
    L15:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        FLogger.f375446a.w("ReachSceneDispatcher", "reach scene canShow failed, reachUniqueId=" + r100.f520408a.f520400h + ", scene=" + r100.f520408a.f520395c, r106);
    L18:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = r107;
    L22:
        if (((Boolean) r105).booleanValue() == true) goto L9;
        return false;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public static void d(ns9.t r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Iterator r101 = h(r100.f520408a.f520395c).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        ReachSceneLifecycleListener r102 = (ReachSceneLifecycleListener) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.g(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        FLogger.f375446a.w("ReachSceneDispatcher", "reach scene onShow failed, reachUniqueId=" + r100.f520408a.f520400h + ", scene=" + r100.f520408a.f520395c, r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static List f(String r100) {
        List r101 = (List) e().get("*");
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r102 = r101;
        List r103 = (List) e().get(r100);
        if (r103 != null) goto L9;
        r103 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r102, r103);
    }

    public static List h(String r100) {
        List r101 = (List) g().get("*");
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List r102 = r101;
        List r103 = (List) g().get(r100);
        if (r103 != null) goto L9;
        r103 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r102, r103);
    }

    public static void c(ns9.t r100, ReachRejectReason r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Iterator r102 = h(r100.f520408a.f520395c).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        ReachSceneLifecycleListener r103 = (ReachSceneLifecycleListener) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.f(r100, r101);     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L4;
        FLogger.f375446a.w("ReachSceneDispatcher", "reach scene onDiscard failed, reachUniqueId=" + r100.f520408a.f520400h + ", scene=" + r100.f520408a.f520395c, r106);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
