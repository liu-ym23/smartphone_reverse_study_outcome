package com.ss.android.lark.larkconfig.export.handler;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.appsetting.api.InternalLocalDefaultConfigStorage;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class AbstractBaseSettingHandler implements com.ss.android.lark.larkconfig.export.handler.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f431102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f431103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f431104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f431105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f431106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f431107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f431108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f431109h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Function0<Boolean>> f431110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Function0<Boolean>> f431111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Function0<Boolean>> f431112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Function1<String, Unit>> f431113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<Function3<String, Boolean, String, Unit>> f431114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Function0<Boolean>> f431115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<Function0<Unit>> f431116g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f431110a, r101.f431110a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f431111b, r101.f431111b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f431112c, r101.f431112c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f431113d, r101.f431113d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f431114e, r101.f431114e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f431115f, r101.f431115f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f431116g, r101.f431116g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f431110a.hashCode() * 31) + this.f431111b.hashCode()) * 31) + this.f431112c.hashCode()) * 31) + this.f431113d.hashCode()) * 31) + this.f431114e.hashCode()) * 31) + this.f431115f.hashCode()) * 31) + this.f431116g.hashCode();
        }

        public final String toString() {
            return "Strategy(isProcessRemoteSettingStrategies=" + this.f431110a + ", emptyMapStrategies=" + this.f431111b + ", emptyRemoteSettingStrategies=" + this.f431112c + ", processRemoteSetting=" + this.f431113d + ", processRemoteSettingWithUserSyncUpdate=" + this.f431114e + ", isProcessLocalSettingStrategies=" + this.f431115f + ", processLocalSettingStrategies=" + this.f431116g + ')';
        }

        public final a d() {
            return new a(new LinkedList(this.f431110a), new LinkedList(this.f431111b), new LinkedList(this.f431112c), new LinkedList(this.f431113d), new LinkedList(this.f431114e), new LinkedList(this.f431115f), new LinkedList(this.f431116g));
        }

        public /* synthetic */ a(int r100) {
            this(new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList());
        }

        public final void b(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            a(this.f431112c, r100);
        }

        public final void c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            a(this.f431113d, r100);
        }

        public final void a(List r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            r100.add(r101);
        }

        public a(List<Function0<Boolean>> r100, List<Function0<Boolean>> r101, List<Function0<Boolean>> r102, List<Function1<String, Unit>> r103, List<Function3<String, Boolean, String, Unit>> r104, List<Function0<Boolean>> r105, List<Function0<Unit>> r106) {
            Intrinsics.checkNotNullParameter(r100, "isProcessRemoteSettingStrategies");
            Intrinsics.checkNotNullParameter(r101, "emptyMapStrategies");
            Intrinsics.checkNotNullParameter(r102, "emptyRemoteSettingStrategies");
            Intrinsics.checkNotNullParameter(r103, "processRemoteSetting");
            Intrinsics.checkNotNullParameter(r104, "processRemoteSettingWithUserSyncUpdate");
            Intrinsics.checkNotNullParameter(r105, "isProcessLocalSettingStrategies");
            Intrinsics.checkNotNullParameter(r106, "processLocalSettingStrategies");
            this.f431110a = r100;
            this.f431111b = r101;
            this.f431112c = r102;
            this.f431113d = r103;
            this.f431114e = r104;
            this.f431115f = r105;
            this.f431116g = r106;
        }
    }

    public static abstract class b extends AbstractBaseSettingHandler {
        @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
        public final kpb.a.b c() {
            return ((kpb.a) ClaymoreServiceLoader.loadFirst(kpb.a.class)).getUserRepo();
        }

        public b() {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f431117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractBaseSettingHandler f431118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f431119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f431120d;

        public c(boolean r100, AbstractBaseSettingHandler r101, boolean r102, String r103) {
            this.f431117a = r100;
            this.f431118b = r101;
            this.f431119c = r102;
            this.f431120d = r103;
        }

        public final void a() {
            if (this.f431117a == false) goto L18;
            boolean r100 = AppSettingApiModule.a().isLogin();
            Log.i(this.f431118b.f(), "checkValue isLogin: " + r100);
            if (r100 == false) goto L13;
            if (this.f431119c == false) goto L21;
            List<Function1<String, Unit>> r101 = this.f431118b.f431107f.f431113d;
            String r102 = this.f431120d;
            Iterator<T> r103 = r101.iterator();
        L10:
            if (r103.hasNext() == false) goto L23;
            ((Function1) r103.next()).invoke(r102);
            goto L10
        L23:
            return;
        L21:
            return;
        L13:
            if (this.f431119c == true) goto L22;
            List<Function1<String, Unit>> r104 = this.f431118b.f431107f.f431113d;
            String r105 = this.f431120d;
            Iterator<T> r106 = r104.iterator();
        L16:
            if (r106.hasNext() == false) goto L24;
            ((Function1) r106.next()).invoke(r105);
            goto L16
        L24:
            return;
        L22:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f431121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractBaseSettingHandler f431122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f431123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f431124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f431125e;

        public d(boolean r100, AbstractBaseSettingHandler r101, boolean r102, String r103, String r104) {
            this.f431121a = r100;
            this.f431122b = r101;
            this.f431123c = r102;
            this.f431124d = r103;
            this.f431125e = r104;
        }

        public final void a() {
            if (this.f431121a == false) goto L18;
            boolean r100 = AppSettingApiModule.a().isLogin();
            Log.i(this.f431122b.f(), "checkValue isLogin: " + r100);
            if (r100 == false) goto L13;
            if (this.f431123c == false) goto L18;
            List<Function1<String, Unit>> r101 = this.f431122b.f431107f.f431113d;
            String r102 = this.f431124d;
            Iterator<T> r103 = r101.iterator();
        L10:
            if (r103.hasNext() == false) goto L18;
            ((Function1) r103.next()).invoke(r102);
            goto L10
        L13:
            if (this.f431123c == true) goto L18;
            List<Function1<String, Unit>> r104 = this.f431122b.f431107f.f431113d;
            String r105 = this.f431124d;
            Iterator<T> r106 = r104.iterator();
        L16:
            if (r106.hasNext() == false) goto L18;
            ((Function1) r106.next()).invoke(r105);
        L18:
            List<Function3<String, Boolean, String, Unit>> r107 = this.f431122b.f431107f.f431114e;
            String r108 = this.f431124d;
            boolean r109 = this.f431123c;
            String r110 = this.f431125e;
            Iterator<T> r111 = r107.iterator();
        L20:
            if (r111.hasNext() == false) goto L22;
            ((Function3) r111.next()).invoke(r108, Boolean.valueOf(r109), r110);
            goto L20
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract String f();

    public kpb.a.b c() {
        return ((kpb.a) ClaymoreServiceLoader.loadFirst(kpb.a.class)).getLarkRepo();
    }

    public String d() {
        return f() + a();
    }

    public final String g() {
        String r100 = this.f431103b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f431109h == true) goto L20;
        if (this.f431104c != null) goto L20;
        this.f431109h = true;
        String r101 = e(this, d());
        String r102 = null;
        if ((true ^ TextUtils.isEmpty(r101)) == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L17;
        String r103 = a();
        if (r103 == null) goto L18;
        r102 = InternalLocalDefaultConfigStorage.f408932g.getValue().b(r103);
    L18:
        this.f431104c = r102;
        goto L20
    L17:
        r102 = r101;
    L20:
        return this.f431104c;
    }

    public AbstractBaseSettingHandler() {
        this.f431102a = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("setting_blocking_update_service");
        a r100 = new a(0);
        Function0<Boolean> r101 = new AbstractBaseSettingHandler$softStrategy$1(this);
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r100.a(r100.f431111b, r101);
        r100.b(new AbstractBaseSettingHandler$softStrategy$2(this));
        Function0<Boolean> r102 = new AbstractBaseSettingHandler$softStrategy$3(this);
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r100.a(r100.f431115f, r102);
        this.f431105d = r100;
        a r103 = r100.d();
        r103.c(new AbstractBaseSettingHandler$mixedStrategy$1(this));
        Function0<Unit> r104 = new AbstractBaseSettingHandler$mixedStrategy$2(this);
        Intrinsics.checkNotNullParameter(r104, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r103.a(r103.f431116g, r104);
        this.f431106e = r103;
        a r105 = r103.d();
        Function0<Boolean> r106 = new AbstractBaseSettingHandler$defaultStrategy$1(this);
        Intrinsics.checkNotNullParameter(r106, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        r105.a(r105.f431111b, r106);
        r105.b(new AbstractBaseSettingHandler$defaultStrategy$2(this));
        this.f431107f = r105;
    }

    public static String e(AbstractBaseSettingHandler r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter("", "value");
        String r102 = r100.c().getString(r101, "");
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public static void h(AbstractBaseSettingHandler r100, String r101) {
        String r102 = r100.d();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "key");
        r100.c().putString(r102, r101);
    }

    public final void b(String r100, boolean r101, boolean r110, boolean r111, String r112) {
        if (TextUtils.isEmpty(r100) == false) goto L14;
        Iterator<Function0<Boolean>> r102 = this.f431107f.f431112c.iterator();
        boolean r103 = false;
    L6:
        if (r102.hasNext() == false) goto L11;
        if (r102.next().invoke().booleanValue() == true) goto L6;
        r103 = true;
        goto L6
    L11:
        if (r103 == false) goto L14;
        Log.i(f(), "value is not valid");
        return;
    L14:
        if (r100 != null) goto L17;
        Log.i(f(), "value is null");
        return;
    L17:
        this.f431108g = true;
        if (r111 == false) goto L23;
        this.f431102a.execute(new c(r110, this, r101, r100));
        Iterator<T> r113 = this.f431107f.f431114e.iterator();
    L21:
        if (r113.hasNext() == false) goto L31;
        ((Function3) r113.next()).invoke(r100, Boolean.valueOf(r101), r112);
        goto L21
    L31:
        return;
    L23:
        this.f431102a.execute(new d(r110, this, r101, r100, r112));
    }

    public final void i(Map<String, String> r100, boolean r101, boolean r102, boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "uid");
        Log.d(f(), "setting handler start set setting from remote");
        Iterator<Function0<Boolean>> r103 = this.f431107f.f431110a.iterator();
        boolean r104 = false;
        boolean r105 = false;
    L3:
        boolean r106 = true;
        if (r103.hasNext() == false) goto L10;
        if (r103.next().invoke().booleanValue() == true) goto L3;
        r105 = true;
        goto L3
    L10:
        if ((!r105) == true) goto L13;
        Log.d(f(), "setting from remote not allowed");
        return;
    L13:
        if (r100 != null) goto L22;
        Iterator<Function0<Boolean>> r107 = this.f431107f.f431111b.iterator();
    L16:
        if (r107.hasNext() == false) goto L21;
        if (r107.next().invoke().booleanValue() == true) goto L16;
        r104 = true;
        goto L16
    L21:
        r106 = true ^ r104;
    L22:
        if (r106 == true) goto L25;
        Log.i(f(), "map is not valid");
        return;
    L25:
        if (r100 != null) goto L28;
        Log.i(f(), "value is null");
        return;
    L28:
        monitor-enter(this);
        if (r102 == true) goto L42;
    L36:
        b(r100.get(a()), r101, r102, r110, r111);     // Catch: Throwable -> L39
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L39:
        th = move-exception;
        throw th;
    L42:
        boolean r109 = AppSettingApiModule.a().isLogin();     // Catch: Throwable -> L39
        Log.i(f(), "setSettingFromRemote, isLogin: " + r109 + ", isUserData: " + r101);     // Catch: Throwable -> L39
        if (r109 == false) goto L34;
        if (r101 == false) goto L36;
        this.f431103b = r100.get(a());     // Catch: Throwable -> L39
        goto L36
    L34:
        if (r101 == true) goto L36;
        this.f431103b = r100.get(a());     // Catch: Throwable -> L39
        goto L36
    }
}
