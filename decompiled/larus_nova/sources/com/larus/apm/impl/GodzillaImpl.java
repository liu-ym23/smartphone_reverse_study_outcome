package com.larus.apm.impl;

import android.os.Build;
import com.bytedance.apm.ApmAgent;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.StartType;
import com.larus.apm.api.IGodzilla;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.ty;
import com.larus.settings.value.xy;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p57.f;
import q48.g;
import u57.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/apm/impl/GodzillaImpl;", "Lcom/larus/apm/api/IGodzilla;", "<init>", "()V", "startGzlRunnable", "Ljava/lang/Runnable;", "enableGodzillaInTestChannel", "", "init", "", "enable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GodzillaImpl implements IGodzilla {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f286957b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f286958a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f286959a = null;

        static {
            int[] r100 = new int[Logger.Level.values().length];
            r100[Logger.Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Logger.Level.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Logger.Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Logger.Level.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f286959a = r100;
        }
    }

    public static final class c implements f {
        public c() {
        }

        @Override // p57.f
        public final Field b(Class<?> r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "fieldName");
            return p57.d.a(r100, r101);
        }

        @Override // p57.f
        public final Method a(Class<?> r100, String r101, Class<?>... r102) {
            Intrinsics.checkNotNullParameter(r101, "methodName");
            Intrinsics.checkNotNullParameter(r102, "params");
            Class[] r103 = (Class[]) Arrays.copyOf(r102, r102.length);
            if (e.a() == false) goto L8;
            return p57.e.a(r100, r101, r103);
        L6:
            return null;
        L8:
            return u57.d.a(r100, r101, r103);
        }
    }

    public static final class d implements s57.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GodzillaImpl f286960a;

        @Override // s57.b.a
        public final List<p57.c> a() {
        L19:
            e = move-exception;
            FLogger.f375446a.w("GodzillaExt", "getCrashPortrait", e);
        L22:
            return new ArrayList();
        L4:
            if (AppHost.f326268a.isTestChannel() == false) goto L7;
            GodzillaImpl r100 = this.f286960a;     // Catch: Exception -> L19
            int r101 = GodzillaImpl.f286957b;     // Catch: Exception -> L19
            r100.getClass();     // Catch: Exception -> L19
            FLogger.f375446a.e("GodzillaExt", "isTestChannel, disable SuperUncaughtExceptionPlugin");     // Catch: Exception -> L19
            return new ArrayList();
        L7:
            FLogger.f375446a.i("GodzillaExt", "SuperUncaughtExceptionPlugin getCrashPortrait");     // Catch: Exception -> L19
            e10 r102 = e10.f368561a;     // Catch: Exception -> L19
            int r103 = l0.f375430a;     // Catch: Exception -> L19
            List<jt9.a> r104 = ((jt9.b) l0.a(new jt9.b(), new ty())).a();     // Catch: Exception -> L19
            if (r104 == null) goto L16;
            List r105 = CollectionsKt.filterNotNull(r104);     // Catch: Exception -> L19
            if (r105 == null) goto L16;
            List r106 = r105;     // Catch: Exception -> L19
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));     // Catch: Exception -> L19
            Iterator r108 = r106.iterator();     // Catch: Exception -> L19
        L13:
            if (r108.hasNext() == false) goto L17;
            jt9.a r109 = (jt9.a) r108.next();     // Catch: Exception -> L19
            p57.c r110 = new p57.c();     // Catch: Exception -> L19
            r110.f527791a = r109.e();     // Catch: Exception -> L19
            r110.f527794d = r109.f();     // Catch: Exception -> L19
            r110.f527792b = r109.b();     // Catch: Exception -> L19
            r110.f527793c = r109.d();     // Catch: Exception -> L19
            r110.f527797g = r109.g();     // Catch: Exception -> L19
            r110.f527796f = r109.c();     // Catch: Exception -> L19
            r110.f527795e = r109.a();     // Catch: Exception -> L19
            r107.add(r110);     // Catch: Exception -> L19
        L17:
            if (r107 == null) goto L22;
            return r107;
        L16:
            r107 = null;
            goto L17
        }

        @Override // s57.b.a
        public final String getAppVersion() {
            return AppHost.f326268a.getVersionName();
        }

        @Override // s57.b.a
        public final int getUpdateVersion() {
            return AppHost.f326268a.getUpdateVersionCode();
        }

        public d(GodzillaImpl r100) {
            this.f286960a = r100;
        }

        @Override // s57.b.a
        public final void b(p57.c r100) {
            Intrinsics.checkNotNullParameter(r100, "crashPortrait");
            JSONObject r101 = new JSONObject();
            r101.put("process_name", r100.f527791a);
            r101.put("thread_name", r100.f527794d);
            r101.put("clazz_name", r100.f527792b);
            r101.put("method_name", r100.f527793c);
            r101.put("throwable_class_name", r100.f527797g);
            r101.put("message", r100.f527796f);
            r101.put("app_version", r100.f527795e);
            r101.put("update_version", 0);
            r101.put("os_version", 0);
            ApmAgent.monitorEvent("crash_portrait", r101, null, null);
            FLogger.f375446a.e("GodzillaExt", "onCrashCatchSucceed", new Throwable(r100.toString()));
        }
    }

    static {
    }

    public GodzillaImpl() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [q48.g] */
    @Override // com.larus.apm.api.IGodzilla
    public final void init() {
        AppHost.Companion r100 = AppHost.f326268a;
        l57.a.C6650a r101 = new l57.a.C6650a(r100.getApplication());
        r101.f507536c = new q48.f();
        r101.f507537d = new c();
        e10 r102 = e10.f368561a;
        jt9.c r103 = (jt9.c) l0.a(new jt9.c(0), new xy());
        FLogger.f375446a.i("GodzillaExt", "godzillaPluginConfig " + r103);
        r101.a(new s57.a());
        Boolean r104 = r103.e();
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L6;
        r101.a(new r48.b());
    L6:
        if (Intrinsics.areEqual(r103.b(), r105) == false) goto L9;
        r101.a(new r48.a());
    L9:
        if (Intrinsics.areEqual(r103.d(), r105) == false) goto L12;
        r101.a(new q57.a());
    L12:
        if (Intrinsics.areEqual(r103.f(), r105) == false) goto L15;
        r101.a(new r48.d());
    L15:
        if (Intrinsics.areEqual(r103.c(), Boolean.FALSE) == true) goto L21;
        ArrayList r106 = new ArrayList();
        Integer r107 = r103.a();
        if (r107 == null) goto L19;
        int r108 = r107.intValue();
    L20:
        r101.a(new q48.e(r106, r108));
        goto L21
    L19:
        r108 = 460800;
    L21:
        e10.j0();
        if (Build.VERSION.SDK_INT >= 26) goto L24;
        r101.a(new m57.a());
    L24:
        r101.a(new r48.c());
        r101.a(new s57.b(new d(this), r100.getApplication()));
        l57.a r109 = new l57.a(r101.f507534a, r101.f507535b, r101.f507536c, r101.f507537d);
        monitor-enter(l57.a.class);
    L33:
        th = move-exception;
        throw th;
    L27:
        if (l57.a.f507531c != null) goto L29;
        l57.a.f507531c = r109;     // Catch: Throwable -> L33
    L30:
        monitor-exit(l57.a.class);     // Catch: Throwable -> L33
        l57.a r110 = l57.a.f507531c;
        r110.getClass();
        r110.a(StartType.IMMEDIATE);
        ?? r111 = new g(this);
        this.f286958a = r111;
        r111.run();
        return;
    L29:
        Logger.a("Godzilla", "Godzilla instance is already set. this invoking will be ignored");     // Catch: Throwable -> L33
        goto L30
    }
}
