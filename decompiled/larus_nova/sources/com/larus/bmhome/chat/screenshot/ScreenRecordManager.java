package com.larus.bmhome.chat.screenshot;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes25.dex */
public final class ScreenRecordManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<e>> f308569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f308570b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f308571c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f308572d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f308573e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f308574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f308575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f308576h = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f308577a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static k f308578b;

        static {
            f308577a = new a();
        }

        public a() {
        }

        public static void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r101 = AppHost.f326268a.a().getCurrentActivity();
            WindowManager r102 = null;
            if (r101 == null) goto L5;
            Object r103 = r101.getSystemService(LiveEndPageData.TAG_WINDOW);
        L7:
            if ((r103 instanceof WindowManager) == false) goto L9;
            WindowManager r104 = (WindowManager) r103;
        L10:
            if (r104 != null) goto L25;
            Object r105 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
            if ((r105 instanceof WindowManager) == false) goto L14;
            r102 = (WindowManager) r105;
        L14:
            if (r102 != null) goto L16;
            return;
        L16:
            r104 = r102;
        L25:
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L19
            Executor r107 = ContextCompat.getMainExecutor(r100);     // Catch: Throwable -> L19
            k r108 = f308578b;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L19
            int r109 = r104.addScreenRecordingCallback(r107, r108);     // Catch: Throwable -> L19
            FLogger.f375446a.d("ScreenRecordManager", "Check current recording status: " + r109);     // Catch: Throwable -> L19
            k r110 = f308578b;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L19
            r110.accept(Integer.valueOf(r109));     // Catch: Throwable -> L19
            Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L27;
            FLogger.f375446a.e("ScreenRecordManager", "register screen recording callback error: ", r112);
            return;
        L27:
            return;
        L19:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            CopyOnWriteArrayList<WeakReference<e>> r100 = ScreenRecordManager.f308569a;
            ScreenRecordManager.b("app_background");
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            CopyOnWriteArrayList<WeakReference<e>> r100 = ScreenRecordManager.f308569a;
            ScreenRecordManager.b("app_background");
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            if (Build.VERSION.SDK_INT < 35) goto L6;
            a r100 = a.f308577a;
            Application r101 = AppHost.f326268a.getApplication();
            r100.getClass();
            a.a(r101);
            return;
        }
    }

    public ScreenRecordManager() {
    }

    static {
        f308569a = new CopyOnWriteArrayList();
        f308570b = new AtomicBoolean(false);
        f308571c = new LinkedHashSet();
        f308572d = new LinkedHashSet();
        f308573e = new Object();
        f308576h = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.bmhome.chat.screenshot.j] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(e r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        Iterator<WeakReference<e>> r100 = f308569a.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(r100.next().get(), r110) == false) goto L6;
        return;
    L10:
        com.larus.platform.service.g.f365738a.i(new j());
        AtomicBoolean r101 = f308570b;
        if (r101.get() == true) goto L43;
        AppHost.Companion r102 = AppHost.f326268a;
        r102.a().j(f308576h);
        if (Build.VERSION.SDK_INT < 35) goto L19;
        a r103 = a.f308577a;
        Application r104 = r102.getApplication();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a.f308578b != null) goto L18;
        a.f308578b = new k();
    L18:
        a.a(r104);
    L19:
        boolean r105 = true;
        r101.set(true);
        Keva r106 = Keva.getRepo("screen_record_crash_cache");
        Set<String> r107 = r106.getStringSet("crash_msg_ids", null);
        Set<String> r108 = r106.getStringSet("crash_log_ids", null);
        Set<String> r109 = r107;
        if (r109 != null) goto L22;
    L25:
        boolean r111 = true;
    L26:
        if (r111 == false) goto L34;
        Set<String> r112 = r108;
        if (r112 != null) goto L30;
    L33:
        if (r105 == true) goto L43;
    L30:
        if (r112.isEmpty() == true) goto L33;
        r105 = false;
    L34:
        if (r107 == null) goto L37;
        List r113 = CollectionsKt.toMutableList(r107);
        if (r113 == null) goto L37;
    L38:
        if (r108 == null) goto L41;
        List r114 = CollectionsKt.toMutableList(r108);
        if (r114 == null) goto L41;
    L42:
        r106.erase("crash_msg_ids");
        r106.erase("crash_log_ids");
        FLogger.f375446a.i("ScreenRecordManager", "Found crash cache! Uploading " + r113.size() + " messages from previous session.");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ScreenRecordManager$checkAndUploadCrashData$1(r113, r114, null), 2, null);
    L41:
        r114 = new ArrayList();
    L37:
        r113 = new ArrayList();
        goto L38
    L22:
        if (r109.isEmpty() == true) goto L25;
        r111 = false;
    L43:
        f308569a.add(new WeakReference(r110));
        FLogger.f375446a.i("ScreenRecordManager", "addScreenRecordSessionListener");
    }

    public static void b(String r100) {
        FLogger.f375446a.d("ScreenRecordManager", "End session due to ".concat(r100));
        if (f308574f == true) goto L5;
        return;
    L5:
        String r101 = f308575g;
        if (r101 != null) goto L8;
        return;
    L8:
        CopyOnWriteArrayList<WeakReference<e>> r102 = f308569a;
        Iterator<WeakReference<e>> r103 = r102.iterator();
    L9:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L18;
        WeakReference<e> r105 = r103.next();
        WeakReference<e> r106 = r105;
        Intrinsics.checkNotNullParameter(r106, "it");
        if (r106.get() == null) goto L16;
        r104 = false;
    L16:
        if (Boolean.valueOf(r104).booleanValue() == false) goto L9;
        r102.remove(r105);
        goto L9
    L18:
        Iterator<WeakReference<e>> r107 = r102.iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        e r108 = r107.next().get();
        if (r108 == null) goto L20;
        r108.b(r101, r100);
        goto L20
    L24:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("Start processing session messages: msgIdsize - ");
        Set<String> r111 = f308571c;
        r110.append(r111.size());
        r110.append(" logIdsize ");
        Set<String> r112 = f308572d;
        r110.append(r112.size());
        r109.i("ScreenRecordManager", r110.toString());
        Object r113 = f308573e;
        monitor-enter(r113);
        Pair r114 = new Pair(CollectionsKt.toList(r111), CollectionsKt.toList(r112));     // Catch: Throwable -> L44
        monitor-exit(r113);
        f308574f = false;
        f308575g = null;
        monitor-enter(r113);
        r111.clear();     // Catch: Throwable -> L41
        r112.clear();     // Catch: Throwable -> L41
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r113);
        if ((!((Collection) r114.getFirst()).isEmpty()) == true) goto L37;
        if ((!((Collection) r114.getSecond()).isEmpty()) == true) goto L37;
        return;
    L37:
        if (Intrinsics.areEqual(r100, "App crash") == false) goto L39;
        Keva r116 = Keva.getRepo("screen_record_crash_cache");
        r116.storeStringSet("crash_msg_ids", CollectionsKt.toSet((Iterable) r114.getFirst()));
        r116.storeStringSet("crash_log_ids", CollectionsKt.toSet((Iterable) r114.getSecond()));
        r109.i("ScreenRecordManager", "Saved " + ((List) r114.getFirst()).size() + " messages to Keva for next launch due to crash.");
        return;
    L39:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ScreenRecordManager$endSession$4(r114, null), 2, null);
        return;
    L41:
        th = move-exception;
        throw th;
    L44:
        th = move-exception;
        throw th;
    }

    public static void c(Collection r100, Collection r101) {
        Intrinsics.checkNotNullParameter(r100, "messageIdList");
        Intrinsics.checkNotNullParameter(r101, "logIdList");
        if (f308574f == true) goto L5;
        return;
    L5:
        Object r102 = f308573e;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L35
        Iterator r104 = r100.iterator();     // Catch: Throwable -> L35
    L8:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L15;
        Object r106 = r104.next();     // Catch: Throwable -> L35
        if (((String) r106).length() <= 0) goto L13;
        r105 = true;
    L13:
        if (r105 == false) goto L8;
        r103.add(r106);     // Catch: Throwable -> L35
        goto L8
    L15:
        Iterator r107 = r103.iterator();     // Catch: Throwable -> L35
    L17:
        if (r107.hasNext() == false) goto L19;
        String r108 = (String) r107.next();     // Catch: Throwable -> L35
        f308571c.add(r108);     // Catch: Throwable -> L35
        goto L17
    L19:
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L35
        Iterator r110 = r101.iterator();     // Catch: Throwable -> L35
    L21:
        if (r110.hasNext() == false) goto L28;
        Object r111 = r110.next();     // Catch: Throwable -> L35
        if (((String) r111).length() <= 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L21;
        r109.add(r111);     // Catch: Throwable -> L35
        goto L21
    L25:
        r112 = false;
        goto L26
    L28:
        Iterator r113 = r109.iterator();     // Catch: Throwable -> L35
    L30:
        if (r113.hasNext() == false) goto L32;
        String r114 = (String) r113.next();     // Catch: Throwable -> L35
        f308572d.add(r114);     // Catch: Throwable -> L35
        goto L30
    L32:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r102);
        return;
    L35:
        th = move-exception;
        throw th;
    }
}
