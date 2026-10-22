package le1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import le1.c;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b<Plugin extends c> implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.arch.context.a f508907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f508908b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f508909a;

        public a(Function1 r100) {
            this.f508909a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            this.f508909a.invoke(r100);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            ke1.a.f502996a.getClass();
            ke1.a r101 = ke1.a.C6543a.a();
            if (r101 == null) goto L11;
            SimpleAlogArgsBuilder r102 = new SimpleAlogArgsBuilder();
            r102.c("AbsTbPluginHandler onStateChange error, action fail");
            Intrinsics.checkNotNullParameter(e, "e");
            r102.f98897a = e;
            Unit r103 = Unit.INSTANCE;
            r101.c(r102.b());
            ke1.f.a r104 = new ke1.f.a("AbsTbPluginHandler onStateChange error, action fail");
            r104.f503016b = true;
            r104.a("error_msg", String.valueOf(e.getMessage()));
            r104.a("stack", ke1.b.a(e));
            r101.a(new ke1.f(r104));
            return;
        }
    }

    /* JADX INFO: renamed from: le1.b$b, reason: collision with other inner class name */
    public static final class C6682b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6682b f508910a = null;

        static {
            f508910a = new C6682b();
        }

        public C6682b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ke1.a.f502996a.getClass();
            ke1.a r102 = ke1.a.C6543a.a();
            if (r102 == null) goto L12;
            SimpleAlogArgsBuilder r103 = new SimpleAlogArgsBuilder();
            r103.c("AbsTbPluginHandler onStateChange error, receive an exception");
            if (r101 == null) goto L7;
            Intrinsics.checkNotNullParameter(r101, "e");
            r103.f98897a = r101;
        L7:
            Unit r104 = Unit.INSTANCE;
            r102.c(r103.b());
            ke1.f.a r105 = new ke1.f.a("AbsTbPluginHandler onStateChange error, receive an exception");
            if (r101 == null) goto L10;
            r105.f503016b = true;
            r105.a("error_msg", String.valueOf(r101.getMessage()));
            r105.a("stack", ke1.b.a(r101));
        L10:
            r102.a(new ke1.f(r105));
            return;
        }
    }

    @Override // le1.d
    public void a() {
    }

    @Override // le1.d
    public void c() {
        this.f508908b.clear();
    }

    public b() {
        this.f508908b = new CompositeDisposable();
    }

    @Override // le1.d
    public void d(com.bytedance.android.livesdk.arch.context.a r100) {
        Intrinsics.checkNotNullParameter(r100, "tbContext");
        this.f508907a = r100;
    }

    public final void e(com.bytedance.android.livesdk.arch.comp.b r110, Function1<? super Plugin, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "tbComp");
        Intrinsics.checkNotNullParameter(r111, "handle");
        List<c> r100 = r110.f103723b;
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (b((c) r103) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L46;
        c r105 = (c) r104.next();
        Map r106 = null;
        if ((r105 instanceof c) == true) goto L14;
        c r107 = null;
    L15:
        if (r107 == null) goto L16;
        r111.invoke(r107);
        goto L10
    L16:
        ke1.a.f502996a.getClass();
        ke1.a r108 = ke1.a.C6543a.a();
        if (r108 == null) goto L44;
        Pair[] r109 = new Pair[2];
        ToolbarMatchInterface r112 = r110.d();
        if (r112 == null) goto L21;
        String r113 = r112.compInfo();
    L22:
        r109[0] = TuplesKt.to("comp", r113);
        r109[1] = TuplesKt.to(CloudControlInf.PLUGIN, r105.getId().name());
        Map r114 = MapsKt.mapOf(r109);
        SimpleAlogArgsBuilder r115 = new SimpleAlogArgsBuilder();
        r115.c("can't handle plugin, plugin cast error");
        if (r114 != null) goto L25;
    L33:
        Unit r116 = Unit.INSTANCE;
        r108.c(r115.b());
        ke1.f.a r117 = new ke1.f.a("can't handle plugin, plugin cast error");
        if (r114 != null) goto L36;
    L43:
        Unit r118 = Unit.INSTANCE;
        r108.a(new ke1.f(r117));
        goto L44
    L36:
        if ((true ^ r114.isEmpty()) == false) goto L38;
        r106 = r114;
    L38:
        if (r106 == null) goto L43;
        Iterator r119 = r106.entrySet().iterator();
    L41:
        if (r119.hasNext() == false) goto L43;
        Map.Entry r120 = (Map.Entry) r119.next();
        r117.a((String) r120.getKey(), String.valueOf(r120.getValue()));
        goto L41
    L25:
        if ((!r114.isEmpty()) == false) goto L27;
        Map r121 = r114;
    L28:
        if (r121 == null) goto L33;
        Iterator r122 = r121.entrySet().iterator();
    L31:
        if (r122.hasNext() == false) goto L33;
        Map.Entry r123 = (Map.Entry) r122.next();
        r115.a((String) r123.getKey(), String.valueOf(r123.getValue()));
        goto L31
    L27:
        r121 = null;
        goto L28
    L21:
        r113 = null;
    L44:
        ALogger.i("AbsTbPluginHandler", "plugin cast error");
        goto L10
    L14:
        r107 = r105;
        goto L15
    }

    public final <T> void f(Function1<? super me1.a, ? extends z51.d<T>> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "action");
        com.bytedance.android.livesdk.arch.context.a r102 = this.f508907a;
        if (r102 == null) goto L14;
        me1.a r103 = r102.stateDispatcher();
        if (r103 == null) goto L15;
        z51.d<T> r104 = r100.invoke(r103);
        if (r104 == null) goto L16;
        Observable<T> r105 = r104.f570051b;
        if (r105 == null) goto L17;
        Disposable r106 = r105.subscribe(new a(r101), C6682b.f508910a);
        if (r106 == null) goto L18;
        RxUtilKt.c(r106, this.f508908b);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
