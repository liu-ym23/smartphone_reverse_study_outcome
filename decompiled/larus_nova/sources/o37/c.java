package o37;

import android.content.Context;
import com.bytedance.nita.exception.NitaViewNotFindException;
import com.bytedance.nita.schduler.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f521914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f521915b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7006c f521916c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f521917d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f521918e = null;

    public static final class a extends r37.a<Object, Context> {
        @Override // r37.a
        public final Context b() {
            return o37.a.f521913b.getContext();
        }

        public a() {
        }
    }

    public static final class b extends r37.a<Object, Boolean> {
        @Override // r37.a
        public final Boolean b() {
            o37.b r100 = o37.a.f521912a;
            if (r100 == null) goto L5;
            Boolean r101 = r100.getDebug();
        L7:
            return Boolean.valueOf(Intrinsics.areEqual(r101, Boolean.TRUE));
        L5:
            r101 = null;
            goto L7
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: o37.c$c, reason: collision with other inner class name */
    public static final class C7006c extends r37.a<Object, com.bytedance.nita.api.b> {
        @Override // r37.a
        public final com.bytedance.nita.api.b b() {
            o37.b r100 = o37.a.f521912a;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f();
        }

        public C7006c() {
        }
    }

    static {
        f521914a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), PerfLog.PARAM_KEY_CONTEXT_ID, "getContext$core_release()Landroid/content/Context;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "nitaInflateMonitor", "getNitaInflateMonitor$core_release()Lcom/bytedance/nita/api/INitaMonitor;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "debug", "getDebug()Z"))};
        f521918e = new c();
        f521915b = new a();
        f521916c = new C7006c();
        f521917d = new b();
    }

    public c() {
    }

    public static com.bytedance.nita.api.b d() {
        C7006c r100 = f521916c;
        KProperty r101 = f521914a[1];
        return (com.bytedance.nita.api.b) r100.a();
    }

    public static Context b() {
        a r100 = f521915b;
        KProperty r101 = f521914a[0];
        Context r102 = (Context) r100.a();
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("can't use the non context, please check ");
    }

    public static boolean c() {
        b r100 = f521917d;
        KProperty r101 = f521914a[2];
        Boolean r102 = (Boolean) r100.a();
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L7:
        return Boolean.valueOf(r103).booleanValue();
    L5:
        r103 = false;
        goto L7
    }

    public static com.bytedance.nita.api.c e(String r100) {
        com.bytedance.nita.api.c r101 = com.bytedance.nita.view.d.f266017a.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NitaViewNotFindException(r100);
    }

    public static boolean f(String r100) {
        com.bytedance.nita.view.d r101 = com.bytedance.nita.view.d.f266018b;
        o37.b r102 = o37.a.f521912a;
        if ((o37.a.a() & 2) != 0) goto L17;
        monitor-enter(r101);
        if (com.bytedance.nita.view.d.f266017a.get(r100) == null) goto L9;
        boolean r103 = true;
    L10:
        monitor-exit(r101);
        return r103;
    L9:
        r103 = false;
    L12:
        th = move-exception;
        throw th;
    L17:
        return com.bytedance.nita.view.d.f266017a.containsKey(r100);
    }

    public final void a(com.bytedance.nita.api.c r100) {
        com.bytedance.nita.view.d r101 = com.bytedance.nita.view.d.f266018b;
        o37.b r102 = o37.a.f521912a;
        if ((o37.a.a() & 2) == 0) goto L5;
        com.bytedance.nita.view.d.f266017a.put(r100.h(), r100);
        return;
    L5:
        monitor-enter(r101);
        com.bytedance.nita.view.d.f266017a.put(r100.h(), r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void g(String r100, int r101) {
        o37.b r102 = o37.a.f521912a;
        if (r102 == null) goto L5;
        r102.e();
    L5:
        com.bytedance.nita.api.c r103 = com.bytedance.nita.view.d.f266017a.get(r100);
        if (r103 == null) goto L17;
        if (r103.theme() == 0) goto L10;
        f521918e.getClass();
        p37.a r104 = new p37.a(b(), r103.theme());
    L11:
        com.bytedance.nita.schduler.d r105 = f.f266015a.get(r103.a());
        if (r105 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r105.b(r103, r104, r101);
        return;
    L10:
        f521918e.getClass();
        r104 = new p37.a(b());
        goto L11
    L17:
        throw new NitaViewNotFindException(r100);
    }
}
