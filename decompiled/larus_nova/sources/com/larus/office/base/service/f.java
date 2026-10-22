package com.larus.office.base.service;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f361103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f361104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f361105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static OfficeSDKUserApi f361106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LinkedHashSet<String> f361107e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashSet<String> f361108f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinkedHashSet<String> f361109g = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISdkLifecycleV2) r101).lifecycleOrder()), Integer.valueOf(((ISdkLifecycleV2) r100).lifecycleOrder()));
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ISdkLifecycleV2) r100).lifecycleOrder()), Integer.valueOf(((ISdkLifecycleV2) r101).lifecycleOrder()));
        }
    }

    public f() {
    }

    static {
        f361103a = new f();
        f361104b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f361105c = kotlinx.coroutines.sync.b.a();
        f361107e = new LinkedHashSet();
        f361108f = new LinkedHashSet();
        f361109g = new LinkedHashSet();
    }

    public static void b() {
        LinkedHashSet<String> r100 = f361107e;
        Set r101 = CollectionsKt.toSet(r100);
        f361106d = null;
        r100.clear();
        f361108f.clear();
        f361109g.clear();
        if (r101.isEmpty() == false) goto L6;
        FLogger.f375446a.d("OfficeSdkLifecycleRunner", "destroy skipped: no active lifecycle");
        return;
    L6:
        Set r102 = ServiceManager.get().getServices(ISdkLifecycleV2.class);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        f361103a.getClass();
        if (r101.contains(d((ISdkLifecycleV2) r105)) == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        HashSet r106 = new HashSet();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        if (r106.add(d((ISdkLifecycleV2) r109)) == false) goto L14;
        r107.add(r109);
        goto L14
    L18:
        List r110 = CollectionsKt.sortedWith(r107, new a());
        FLogger.f375446a.d("OfficeSdkLifecycleRunner", "destroy: size=" + r110.size());
        Iterator r111 = r110.iterator();
    L20:
        if (r111.hasNext() == false) goto L29;
        ISdkLifecycleV2 r112 = (ISdkLifecycleV2) r111.next();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L24
        r112.destroyDocSdk();     // Catch: Throwable -> L24
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L20;
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "destroy failed: lifecycle=".concat(r112.getClass().getName()), r115);
    L24:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public static List c(boolean r100) {
        if (z2.f365865a.getDocFusionConfig().f547230a == true) goto L7;
        if (r100 == true) goto L7;
        boolean r101 = false;
    L8:
        Set r102 = ServiceManager.get().getServices(ISdkLifecycleV2.class);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L34;
        Object r105 = r104.next();
        String r106 = ((ISdkLifecycleV2) r105).lifecycleCategory();
        if (Intrinsics.areEqual(r106, "office") == true) goto L30;
        if (r101 == false) goto L17;
        if (Intrinsics.areEqual(r106, "doc") == true) goto L30;
    L17:
        if (Intrinsics.areEqual(r106, "slides") == true) goto L30;
        if (Intrinsics.areEqual(r106, DocumentType.SHEET_NAME) == true) goto L30;
        if (Intrinsics.areEqual(r106, DocumentType.BITABLE_NAME) == true) goto L30;
        if (Intrinsics.areEqual(r106, DocumentType.MINUTES_NAME) == true) goto L30;
        if (Intrinsics.areEqual(r106, "watermark") == true) goto L30;
        if (Intrinsics.areEqual(r106, "drive") == true) goto L30;
        boolean r107 = false;
    L31:
        if (r107 == false) goto L10;
        r103.add(r105);
    L30:
        r107 = true;
        goto L31
    L34:
        return CollectionsKt.sortedWith(r103, new b());
    L7:
        r101 = true;
        goto L8
    }

    public static String d(ISdkLifecycleV2 r100) {
        return r100.getClass().getName();
    }

    public static final void a(f r100, OfficeSDKUserApi r101, String r102) {
        r100.getClass();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl((gk5.e) r101.getService(gk5.e.class));     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "preload IOfficeCCMService failed, source=" + r102, r105);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void e(f r110, OfficeSDKUserApi r111, boolean r112, String r113) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "officeSDKUserApi");
        Intrinsics.checkNotNullParameter(r113, "source");
        if (z2.f365865a.enableOfficeSdkLifecycleAsyncInit() == true) goto L5;
        r110.f(r111, r112, r113, null);
        return;
    L5:
        BuildersKt.launch$default(f361104b, null, null, new OfficeSdkLifecycleRunner$run$1(r111, r113, r112, null, null), 3, null);
    }

    public final synchronized void f(OfficeSDKUserApi r110, boolean r111, String r210, Function0<Unit> r211) {
        monitor-enter(this);
        OfficeSDKUserApi r100 = f361106d;     // Catch: Throwable -> L81
        if (r100 == null) goto L8;
        if (r100 == r110) goto L8;
        FLogger.f375446a.w("OfficeSdkLifecycleRunner", "run: OfficeSDKUserApi changed without destroy, reset old lifecycle state");     // Catch: Throwable -> L81
        b();     // Catch: Throwable -> L81
    L8:
        f361106d = r110;     // Catch: Throwable -> L81
        Set r101 = ServiceManager.get().getServices(ISdkLifecycleV2.class);     // Catch: Throwable -> L81
        List r102 = c(r111);     // Catch: Throwable -> L81
        HashSet r103 = new HashSet();     // Catch: Throwable -> L81
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L81
        Iterator r105 = r102.iterator();     // Catch: Throwable -> L81
    L10:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();     // Catch: Throwable -> L81
        if (r103.add(d((ISdkLifecycleV2) r106)) == false) goto L10;
        r104.add(r106);     // Catch: Throwable -> L81
        goto L10
    L14:
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L81
        Iterator r108 = r104.iterator();     // Catch: Throwable -> L81
    L15:
        boolean r109 = true;
        if (r108.hasNext() == false) goto L25;
        Object r112 = r108.next();     // Catch: Throwable -> L81
        f361103a.getClass();     // Catch: Throwable -> L81
        String r113 = d((ISdkLifecycleV2) r112);     // Catch: Throwable -> L81
        if (f361109g.contains(r113) == false) goto L20;
    L22:
        r109 = false;
    L23:
        if (r109 == false) goto L15;
        r107.add(r112);     // Catch: Throwable -> L81
        goto L15
    L20:
        if (f361108f.contains(r113) == true) goto L22;
    L25:
        FLogger.f375446a.d("OfficeSdkLifecycleRunner", "run: srcSize=" + r101.size() + ", selectedSize=" + r104.size() + ", pendingSize=" + r107.size() + ", forceInitDoc=" + r111 + ", source=" + r210 + ", pending=" + CollectionsKt.joinToString$default(r107, null, null, null, 0, null, new e(), 31, null));     // Catch: Throwable -> L81
        if ((!r107.isEmpty()) == false) goto L70;
        LinkedHashSet r114 = new LinkedHashSet();     // Catch: Throwable -> L81
        Iterator r115 = r107.iterator();     // Catch: Throwable -> L81
    L29:
        if (r115.hasNext() == false) goto L31;
        r114.add(d((ISdkLifecycleV2) r115.next()));     // Catch: Throwable -> L81
        goto L29
    L31:
        LinkedHashSet r116 = new LinkedHashSet();     // Catch: Throwable -> L81
        f361108f.addAll(r114);     // Catch: Throwable -> L81
        f361107e.addAll(r114);     // Catch: Throwable -> L81
        Iterator r117 = r107.iterator();     // Catch: Throwable -> L67
    L34:
        if (r117.hasNext() == false) goto L43;
        ISdkLifecycleV2 r118 = (ISdkLifecycleV2) r117.next();     // Catch: Throwable -> L67
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L38
        r118.preInitDocSdk(r110);     // Catch: Throwable -> L38
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L67
        if (r121 == null) goto L34;
        f361103a.getClass();     // Catch: Throwable -> L67
        r116.add(d(r118));     // Catch: Throwable -> L67
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "run failed: phase=preInit, lifecycle=" + r118.getClass().getName(), r121);     // Catch: Throwable -> L67
        goto L34
    L38:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L67
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L40
    L43:
        Iterator r123 = r107.iterator();     // Catch: Throwable -> L67
    L45:
        if (r123.hasNext() == false) goto L54;
        ISdkLifecycleV2 r124 = (ISdkLifecycleV2) r123.next();     // Catch: Throwable -> L67
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L49
        r124.initDocSdk(r110);     // Catch: Throwable -> L49
        Object r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);     // Catch: Throwable -> L67
        if (r127 == null) goto L45;
        f361103a.getClass();     // Catch: Throwable -> L67
        r116.add(d(r124));     // Catch: Throwable -> L67
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "run failed: phase=init, lifecycle=" + r124.getClass().getName(), r127);     // Catch: Throwable -> L67
        goto L45
    L49:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L67
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L51
    L54:
        Iterator r129 = r107.iterator();     // Catch: Throwable -> L67
    L56:
        if (r129.hasNext() == false) goto L65;
        ISdkLifecycleV2 r130 = (ISdkLifecycleV2) r129.next();     // Catch: Throwable -> L67
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L60
        r130.postInitDocSdk(r110);     // Catch: Throwable -> L60
        Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);     // Catch: Throwable -> L67
        if (r133 == null) goto L56;
        f361103a.getClass();     // Catch: Throwable -> L67
        r116.add(d(r130));     // Catch: Throwable -> L67
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "run failed: phase=postInit, lifecycle=" + r130.getClass().getName(), r133);     // Catch: Throwable -> L67
        goto L56
    L60:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L67
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L62
    L65:
        f361109g.addAll(SetsKt.minus(r114, r116));     // Catch: Throwable -> L67
        f361108f.removeAll(r114);     // Catch: Throwable -> L81
        goto L70
    L67:
        th = move-exception;
        f361108f.removeAll(r114);     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L81
    L70:
        if (r211 != null) goto L91;
    L79:
        monitor-exit(this);
        return;
    L91:
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L73
        r211.invoke();     // Catch: Throwable -> L73
        Object r136 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L73
    L75:
        Throwable r137 = Result.m9452exceptionOrNullimpl(r136);     // Catch: Throwable -> L81
        if (r137 == null) goto L78;
        FLogger.f375446a.e("OfficeSdkLifecycleRunner", "run afterInit failed, source=" + r210, r137);     // Catch: Throwable -> L81
    L78:
        Result.m9448boximpl(r136);     // Catch: Throwable -> L81
        goto L79
    L73:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L81
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    }
}
