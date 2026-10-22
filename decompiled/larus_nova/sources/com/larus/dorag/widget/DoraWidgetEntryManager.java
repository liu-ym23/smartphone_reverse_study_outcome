package com.larus.dorag.widget;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraServerResourceType;
import com.larus.dora.api.IDoraService;
import com.larus.dorag.widget.provider.DoraWidget2x2Provider;
import com.larus.dorag.widget.provider.DoraWidget4x2Provider;
import com.larus.dorag.widget.provider.DoraWidgetDiaryProvider;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraWidgetEntryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraWidgetEntryManager f340986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f340987b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f340988c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f340989d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f340990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f340991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f340992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f340993h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends AppWidgetProvider> f340994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f340995b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f340994a, r101.f340994a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f340995b, r101.f340995b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f340994a.hashCode() * 31) + this.f340995b.hashCode();
        }

        public final String toString() {
            return "WidgetDefinition(providerClass=" + this.f340994a + ", previewResourceName=" + this.f340995b + ')';
        }

        public a(Class<? extends AppWidgetProvider> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "providerClass");
            Intrinsics.checkNotNullParameter(r101, "previewResourceName");
            this.f340994a = r100;
            this.f340995b = r101;
        }
    }

    public DoraWidgetEntryManager() {
    }

    static {
        f340986a = new DoraWidgetEntryManager();
        f340987b = CollectionsKt.listOf(new a[]{new a(DoraWidget4x2Provider.class, "pic_dora_widget_preview_4x2.png"), new a(DoraWidget2x2Provider.class, "pic_dora_widget_preview_2x2.png"), new a(DoraWidgetDiaryProvider.class, "larus_pic_dora_widget_diary_preview_4x4.png")});
        f340988c = new Object();
        f340989d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f340993h = LazyKt.lazy(new g());
    }

    public static Map c(AppWidgetManager r100) {
        List<AppWidgetProviderInfo> r101 = r100.getInstalledProvidersForPackage(AppHost.f326268a.getApplication().getPackageName(), null);
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.put(((AppWidgetProviderInfo) r104).provider, r104);
        goto L4
    L6:
        return r102;
    }

    public static void f(boolean r110) {
        Object r100 = f340988c;
        monitor-enter(r100);
        f340991f = r110;     // Catch: Throwable -> L17
        f340992g++;     // Catch: Throwable -> L17
        Job r101 = f340990e;     // Catch: Throwable -> L17
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Throwable -> L17
    L7:
        f340990e = null;     // Catch: Throwable -> L17
        g(r110);     // Catch: Throwable -> L17
        if (r110 == true) goto L10;
    L12:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r100);
        if (r110 == false) goto L22;
        String r111 = f.f340998a;
        f.a();
        return;
    L22:
        return;
    L10:
        if (Build.VERSION.SDK_INT < 35) goto L12;
        f340990e = BuildersKt.launch$default(f340989d, null, null, new DoraWidgetEntryManager$launchPreviewUpdate$1(f340992g, null), 3, null);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static void g(boolean r110) {
        Application r100 = AppHost.f326268a.getApplication();
        PackageManager r101 = r100.getPackageManager();
        if (r110 == false) goto L5;
        int r102 = 1;
    L6:
        Iterator<T> r103 = f340987b.iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Class<? extends AppWidgetProvider> r104 = ((a) r103.next()).f340994a;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        ComponentName r106 = new ComponentName(r100, r104);     // Catch: Throwable -> L15
        if (r101.getComponentEnabledSetting(r106) == r102) goto L8;
        r101.setComponentEnabledSetting(r106, r102, 1);     // Catch: Throwable -> L15
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateWidgetEntryEnabled: " + r104.getSimpleName() + " -> " + r110);     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L8;
        FLogger.f375446a.e("DoraWidgetEntryManager", "updateWidgetEntryEnabled failed: ".concat(r104.getSimpleName()), r108);
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L20:
        return;
    L5:
        r102 = 2;
        goto L6
    }

    public static boolean b(AppWidgetManager r100, AppWidgetProviderInfo r101) {
        if (r100.getWidgetPreview(r101.provider, null, 1) == null) goto L5;
        boolean r102 = true;
    L7:
        if ((r101.generatedPreviewCategories & 1) == 0) goto L9;
        boolean r103 = true;
    L10:
        if (r102 == false) goto L13;
        if (r103 == false) goto L13;
        return true;
    L13:
        return false;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0121 -> B:39:0x0123). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0129 -> B:41:0x0132). Please report as a decompilation issue!!! */
    public static final Object a(DoraWidgetEntryManager r210, long r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof DoraWidgetEntryManager$updateWidgetPreview$1) == false) goto L7;
        DoraWidgetEntryManager$updateWidgetPreview$1 r100 = (DoraWidgetEntryManager$updateWidgetPreview$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        DoraWidgetEntryManager r102 = r210;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L51:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r106 = r100.I$0;
        long r107 = r100.J$0;
        List r110 = (List) r100.L$1;
        AppWidgetManager r111 = (AppWidgetManager) r100.L$0;
        ResultKt.throwOnFailure(r103);
    L39:
        DoraWidgetEntryManager$updateWidgetPreview$1 r108 = r100;
        long r109 = r107;
        List r112 = r110;
        Object r113 = r104;
        AppWidgetManager r114 = r111;
    L41:
        int r115 = r106 + 1;
        DoraWidgetEntryManager$updateWidgetPreview$1 r116 = r108;
    L20:
        if (r115 >= 20) goto L43;
        JobKt.ensureActive(r116.getContext());
        Intrinsics.checkNotNull(r114);
        Map r117 = c(r114);
        long r213 = r109;
        AppWidgetManager r118 = r114;
        r100 = r116;
        r104 = r113;
        r106 = r115;
        Iterator r119 = r112.iterator();
        List r120 = r112;
        r107 = r213;
    L23:
        if (r119.hasNext() == false) goto L32;
        JobKt.ensureActive(r100.getContext());
        a r121 = (a) r119.next();
        AppWidgetProviderInfo r122 = (AppWidgetProviderInfo) r117.get(new ComponentName(AppHost.f326268a.getApplication(), r121.f340994a));
        if (r122 == null) goto L23;
        r119.remove();
        Intrinsics.checkNotNull(r118);
        r100.L$0 = r118;
        r100.L$1 = r120;
        r100.L$2 = r117;
        r100.L$3 = r119;
        r100.J$0 = r107;
        r100.I$0 = r106;
        r100.label = 1;
        if (r102.d(r118, r122, r121, r107, r100) != r104) goto L23;
        return r104;
    L32:
        if (r120.isEmpty() == false) goto L34;
        r116 = r100;
        Object r214 = r104;
        r114 = r118;
        r109 = r107;
        r112 = r120;
        r113 = r214;
        goto L43
    L34:
        if (r106 >= 19) goto L40;
        r100.L$0 = r118;
        r100.L$1 = r120;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.J$0 = r107;
        r100.I$0 = r106;
        r100.label = 2;
        if (DelayKt.delay(250, r100) == r104) goto L59;
        r111 = r118;
        r110 = r120;
        goto L39
    L59:
        return r104;
    L40:
        r108 = r100;
        Object r215 = r104;
        r114 = r118;
        r109 = r107;
        r112 = r120;
        r113 = r215;
    L43:
        Iterator r123 = r112.iterator();
    L45:
        if (r123.hasNext() == false) goto L47;
        a r124 = (a) r123.next();
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateWidgetPreview: " + r124.f340994a.getSimpleName() + " provider registration timed out");
        goto L45
    L47:
        Intrinsics.checkNotNull(r114);
        r116.L$0 = null;
        r116.L$1 = null;
        r116.L$2 = null;
        r116.L$3 = null;
        r116.label = 3;
        if (r102.h(r114, r109, r116) != r113) goto L51;
        return r113;
    L17:
        r106 = r100.I$0;
        r107 = r100.J$0;
        r119 = (Iterator) r100.L$3;
        r117 = (Map) r100.L$2;
        r120 = (List) r100.L$1;
        AppWidgetManager r125 = (AppWidgetManager) r100.L$0;
        ResultKt.throwOnFailure(r103);
        r118 = r125;
        goto L23
    L18:
        ResultKt.throwOnFailure(r103);
        AppWidgetManager r126 = AppWidgetManager.getInstance(AppHost.f326268a.getApplication());
        r113 = r104;
        r112 = CollectionsKt.toMutableList(f340987b);
        r115 = 0;
        r114 = r126;
        r116 = r100;
        r109 = r211;
    L7:
        r102 = r210;
        r100 = new DoraWidgetEntryManager$updateWidgetPreview$1(r102, r212);
        goto L8
    }

    public final Object h(AppWidgetManager r110, long r210, Continuation<? super Unit> r211) {
        if ((r211 instanceof DoraWidgetEntryManager$verifyAndBackfillPreview$1) == false) goto L7;
        DoraWidgetEntryManager$verifyAndBackfillPreview$1 r100 = (DoraWidgetEntryManager$verifyAndBackfillPreview$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r106 = r100.J$0;
        Iterator r107 = (Iterator) r100.L$2;
        Map r108 = (Map) r100.L$1;
        AppWidgetManager r109 = (AppWidgetManager) r100.L$0;
        ResultKt.throwOnFailure(r102);
        AppWidgetManager r111 = r109;
    L34:
        if (r107.hasNext() == false) goto L45;
        a r112 = (a) r107.next();
        JobKt.ensureActive(r100.getContext());
        DoraWidgetEntryManager r113 = f340986a;
        AppWidgetProviderInfo r114 = (AppWidgetProviderInfo) r108.get(new ComponentName(AppHost.f326268a.getApplication(), r112.f340994a));
        if (r114 == null) goto L34;
        if (b(r111, r114) == true) goto L34;
        FLogger.f375446a.i("DoraWidgetEntryManager", "verifyAndBackfillPreview: " + r112.f340994a.getSimpleName() + " not applied, backfilling");
        r100.L$0 = r111;
        r100.L$1 = r108;
        r100.L$2 = r107;
        r100.J$0 = r106;
        r100.label = 2;
        if (r113.d(r111, r114, r112, r106, r100) != r103) goto L34;
        return r103;
    L45:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r115 = r100.J$0;
        AppWidgetManager r116 = (AppWidgetManager) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r111 = r116;
    L19:
        JobKt.ensureActive(r100.getContext());
        Object r117 = f340988c;
        monitor-enter(r117);
    L46:
        th = move-exception;
        throw th;
    L22:
        if (f340991f == false) goto L27;
        if (f340992g != r115) goto L27;
    L28:
        monitor-exit(r117);
        if (r105 == false) goto L31;
        r108 = c(r111);
        r107 = f340987b.iterator();
        r106 = r115;
        goto L34
    L31:
        return Unit.INSTANCE;
    L27:
        r105 = false;
        goto L28
    L16:
        ResultKt.throwOnFailure(r102);
        r111 = r110;
        r100.L$0 = r111;
        r115 = r210;
        r100.J$0 = r115;
        r100.label = 1;
        if (DelayKt.delay(10000, r100) != r103) goto L19;
        return r103;
    L7:
        r100 = new DoraWidgetEntryManager$verifyAndBackfillPreview$1(this, r211);
        goto L8
    }

    public static Unit e(AppWidgetManager r110, AppWidgetProviderInfo r111, String r112, long r210, Continuation r211) {
        ComponentName r100 = r111.provider;
        boolean r101 = b(r110, r111);
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        RemoteViews r103 = null;
        if (r102 == null) goto L5;
        t39.f r104 = r102.B(DoraEnableScope.G1, DoraServerResourceType.DRAWABLE, r112);
    L7:
        if ((r104 instanceof t39.f.b) == false) goto L9;
        t39.f.b r105 = (t39.f.b) r104;
    L11:
        if (r105 == null) goto L22;
        File r106 = r105.f544468a;
        if (r106 == null) goto L22;
        if (r106.isFile() == true) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r107 == false) goto L22;
    L23:
        if (r106 != null) goto L26;
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateProviderPreview: " + r100.getShortClassName() + " resource unavailable, applied=" + r101);
        return Unit.INSTANCE;
    L26:
        MessageDigest r108 = MessageDigest.getInstance("SHA-256");
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper(r106);
        byte[] r113 = new byte[8192];     // Catch: Throwable -> L65
        int r114 = r109.read(r113);     // Catch: Throwable -> L65
    L29:
        if (r114 == (-1)) goto L31;
        r108.update(r113, 0, r114);     // Catch: Throwable -> L65
        r114 = r109.read(r113);     // Catch: Throwable -> L65
        goto L29
    L31:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L65
        CloseableKt.closeFinally(r109, null);
        String r116 = "1:" + ArraysKt.joinToString$default(r108.digest(), "", null, null, 0, null, new h(), 30, null);
        String r117 = r100.flattenToString();
        if (r101 == true) goto L35;
    L38:
        JobKt.ensureActive(r211.getContext());
        Bitmap r118 = BitmapFactory.decodeFile(r106.getAbsolutePath());
        if (r118 == null) goto L42;
        r103 = new RemoteViews(AppHost.f326268a.getApplication().getPackageName(), R.layout.larus_layout_dora_widget_preview);
        r103.setImageViewBitmap(R.id.dora_widget_preview_image, r118);
    L42:
        if (r103 != null) goto L45;
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateProviderPreview: " + r100.getShortClassName() + " decode failed");
        return Unit.INSTANCE;
    L45:
        JobKt.ensureActive(r211.getContext());
        Object r119 = f340988c;
        monitor-enter(r119);
    L62:
        th = move-exception;
        throw th;
    L48:
        if (f340991f == true) goto L50;
    L59:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(r119);
        return r120;
    L50:
        if (f340992g != r210) goto L59;
        boolean r121 = r110.setWidgetPreview(r100, 1, r103);     // Catch: Throwable -> L62
        if (r121 == false) goto L55;
        ((SharedPreferences) f340993h.getValue()).edit().putString(r117, r116).apply();     // Catch: Throwable -> L62
    L55:
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateProviderPreview: " + r100.getShortClassName() + " accepted=" + r121 + ", previousApplied=" + r101);     // Catch: Throwable -> L62
        monitor-exit(r119);
        return Unit.INSTANCE;
    L35:
        if (Intrinsics.areEqual(((SharedPreferences) f340993h.getValue()).getString(r117, null), r116) == false) goto L38;
        FLogger.f375446a.i("DoraWidgetEntryManager", "updateProviderPreview: " + r100.getShortClassName() + " reuse system preview");
        return Unit.INSTANCE;
    L65:
        th = move-exception;
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);
        throw th;
    L17:
        if (r106.length() <= 0) goto L19;
        r107 = true;
    L22:
        r106 = null;
        goto L23
    L9:
        r105 = null;
        goto L11
    L5:
        r104 = null;
        goto L7
    }

    public final Object d(AppWidgetManager r100, AppWidgetProviderInfo r101, a r110, long r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof DoraWidgetEntryManager$runProviderPreviewSafely$1) == false) goto L7;
        DoraWidgetEntryManager$runProviderPreviewSafely$1 r102 = (DoraWidgetEntryManager$runProviderPreviewSafely$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        DoraWidgetEntryManager$runProviderPreviewSafely$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r110 = (a) r104.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L20 CancellationException -> L24
    L26:
    L23:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r113);
        String r107 = r110.f340995b;     // Catch: Exception -> L20 CancellationException -> L24
        r104.L$0 = r110;     // Catch: Exception -> L20 CancellationException -> L24
        r104.label = 1;     // Catch: Exception -> L20 CancellationException -> L24
        if (e(r100, r101, r107, r111, r104) != r105) goto L26;
        return r105;
    L24:
        e = move-exception;
        throw e;
    L20:
        e = move-exception;
        FLogger.f375446a.e("DoraWidgetEntryManager", "updateProviderPreview failed: ".concat(r110.f340994a.getSimpleName()), e);
    L7:
        r102 = new DoraWidgetEntryManager$runProviderPreviewSafely$1(this, r112);
        goto L8
    }
}
