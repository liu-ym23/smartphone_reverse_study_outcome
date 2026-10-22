package r00;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.fh;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s00.f;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements s00.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<b> f535404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<s00.c> f535405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<s00.c> f535406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f535407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<r00.a, Long> f535408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f535409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<r00.a, ArrayList<Function0<Unit>>> f535410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f535411h;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f535412a;

        public a(Throwable r100) {
            this.f535412a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw new Exception(this.f535412a);     // Catch: Throwable -> L4
        }
    }

    public final b d() {
        Iterator<T> r100 = this.f535404a.iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        b r101 = (b) r100.next();
        Iterator<T> r102 = r101.f535402b.iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        r00.a r103 = (r00.a) r102.next();
        Iterator<T> r104 = this.f535406c.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((s00.c) r105).getName(), r103) == false) goto L10;
    L15:
        if (r105 != null) goto L7;
    L14:
        r105 = null;
        goto L15
    L17:
        return r101;
    L18:
        return null;
    }

    public final void f() {
        this.f535407d.removeCallbacksAndMessages(null);
        this.f535409f.clear();
        if (fh.f120202a.getValue().booleanValue() == false) goto L6;
        this.f535410g.clear();
        return;
    }

    public final void g() {
        if (this.f535404a.isEmpty() == false) goto L7;
        ALogger.i(this.f535411h, "all task is completed.");
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        b r100 = d();
        if (r100 == null) goto L14;
        this.f535404a.remove(r100);
        e(r100.f535401a);
        return;
    L14:
        return;
    L12:
        this.f535407d.post(new e(this));
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tagName");
        this.f535411h = r100;
        this.f535404a = new LinkedList();
        this.f535405b = new HashSet();
        this.f535406c = new HashSet();
        this.f535407d = new Handler(Looper.getMainLooper());
        this.f535408e = new HashMap();
        this.f535409f = new CompositeDisposable();
        this.f535410g = new HashMap();
    }

    @Override // s00.d
    public final void a(s00.b r100) {
        Intrinsics.checkNotNullParameter(r100, "stateTask");
        ALogger.i(this.f535411h, r100.getName() + " is error.");
        this.f535405b.remove(r100);
        this.f535406c.add(r100);
    }

    @Override // s00.d
    public final void b(s00.c r100) {
        Intrinsics.checkNotNullParameter(r100, "stateTask");
        ALogger.i(this.f535411h, r100.getName() + " is success.");
        this.f535405b.remove(r100);
        this.f535406c.add(r100);
        g();
    }

    public final void e(s00.c r110) {
        if ((r110 instanceof s00.b) == false) goto L33;
        if (r110 == null) goto L32;
        s00.b r111 = (s00.b) r110;
        long r100 = System.currentTimeMillis();
        this.f535408e.put(r111.getName(), Long.valueOf(r100));
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(r111.a(this));     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L17;
        ALogger.e(this.f535411h, "run StateTask " + r111.getName() + " error. " + r103);
        SafetyGuard.a(null, r103, "LiveStateTaskExecutorError");
        if (v.a() == false) goto L16;
        MainThreadPostUtils.b(new c(r103));
    L16:
        r102 = new f.a();
    L17:
        f r104 = (f) r102;
        long r105 = System.currentTimeMillis();
        ALogger.i(this.f535411h, "run state task " + r111.getName() + " spending " + (r105 - r100) + " ms, return " + r104.getClass().getSimpleName());
        if ((r104 instanceof f.b) == false) goto L26;
        if (this.f535406c.contains(r111) == true) goto L22;
        this.f535405b.add(r111);
        g();
    L22:
        Disposable r112 = r111.f540006a;
        if (r112 == null) goto L54;
        RxUtilKt.c(r112, this.f535409f);
        return;
    L54:
        return;
    L26:
        if ((r104 instanceof f.c) == false) goto L29;
        b(r111);
        return;
    L29:
        if ((r104 instanceof f.a) == false) goto L57;
        a(r111);
        g();
        return;
    L57:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.corepath.base.AbsPreviewStateTask");
    L33:
        long r107 = System.currentTimeMillis();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L36
        r110.run();     // Catch: Throwable -> L36
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);
        if (r113 == null) goto L43;
        ALogger.e(this.f535411h, "run task " + r110.getName() + " error. " + r113);
        SafetyGuard.a(null, r113, "LiveTaskExecutorError");
        if (v.a() == false) goto L43;
        MainThreadPostUtils.b(new a(r113));
    L43:
        long r114 = System.currentTimeMillis();
        ALogger.i(this.f535411h, "run normal task " + r110.getName() + " spending " + (r114 - r107) + " ms.");
        if ((r110 instanceof s00.a) == false) goto L48;
        Disposable r115 = ((s00.a) r110).f540005a;
        if (r115 == null) goto L48;
        this.f535409f.add(r115);
    L48:
        this.f535405b.remove(r110);
        this.f535406c.add(r110);
        g();
        return;
    L36:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    }

    public final void c(List<? extends s00.c> r110, HashMap<s00.c, ArrayList<r00.a>> r111) {
        List r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "list");
        String r101 = this.f535411h;
        StringBuilder r102 = new StringBuilder("task size = ");
        ArrayList r103 = (ArrayList) r100;
        r102.append(r103.size());
        ALogger.i(r101, r102.toString());
        int r104 = com.bytedance.android.live.broadcast.corepath.util.a.f59100a;
        Intrinsics.checkNotNullParameter(r100, "compConfigList");
        if (r111 == null) goto L51;
        if (r103.isEmpty() == true) goto L51;
        ArrayList r105 = new ArrayList();
        HashMap r106 = new HashMap();
        LinkedList r107 = new LinkedList();
        Iterator<T> r108 = r110.iterator();
    L8:
        int r112 = 0;
        if (r108.hasNext() == false) goto L21;
        s00.c r109 = (s00.c) r108.next();
        r00.a r113 = r109.getName();
        ArrayList<r00.a> r114 = r111.get(r109);
        if (r114 == null) goto L13;
        r112 = r114.size();
    L13:
        r106.put(r113, Integer.valueOf(r112));
        if (r111.get(r109) == null) goto L19;
        ArrayList<r00.a> r115 = r111.get(r109);
        if (r115 == null) goto L8;
        if (r115.isEmpty() != true) goto L8;
    L19:
        r107.add(r109);
    L21:
        if ((!r107.isEmpty()) == false) goto L42;
        s00.c r116 = (s00.c) r107.poll();
        if (r116 == null) goto L21;
        r105.add(r116);
        Iterator<T> r117 = r110.iterator();
    L26:
        if (r117.hasNext() == false) goto L21;
        s00.c r118 = (s00.c) r117.next();
        ArrayList<r00.a> r119 = r111.get(r118);
        if (r119 == null) goto L26;
        if (r119.contains(r116.getName()) != true) goto L26;
        r00.a r120 = r118.getName();
        Integer r121 = (Integer) r106.get(r120);
        if (r121 == null) goto L34;
        int r122 = r121.intValue() - 1;
    L35:
        r106.put(r120, Integer.valueOf(r122));
        Integer r123 = (Integer) r106.get(r120);
        if (r123 == null) goto L26;
        if (r123.intValue() != 0) goto L26;
        r107.add(r118);
        goto L26
    L34:
        r122 = 0;
        goto L35
    L42:
        if (r105.size() == r103.size()) goto L48;
        StringBuilder r124 = new StringBuilder("Error : + ");
        List r125 = CollectionsKt.minus(r100, r105);
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r127 = r125.iterator();
    L45:
        if (r127.hasNext() == false) goto L47;
        r126.add(((s00.c) r127.next()).getName());
        goto L45
    L47:
        r124.append(CollectionsKt.joinToString$default(r126, ", ", null, null, 0, null, null, 62, null));
        ALogger.e("topologicalSort", r124.toString());
    L49:
        r100 = r105;
        goto L51
    L48:
        ALogger.e("topologicalSort", "Success.");
    L51:
        if (r100.isEmpty() == false) goto L54;
        ALogger.i(this.f535411h, "sortList is empty");
        return;
    L54:
        ALogger.i(this.f535411h, "sorted task size = " + r100.size());
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r129 = r100.iterator();
    L56:
        if (r129.hasNext() == false) goto L63;
        s00.c r130 = (s00.c) r129.next();
        if (r111 == null) goto L61;
        ArrayList<r00.a> r131 = r111.get(r130);
        if (r131 == null) goto L61;
    L62:
        r128.add(new b(r130, r131));
    L61:
        r131 = new ArrayList();
        goto L62
    L63:
        this.f535404a = new LinkedList(r128);
        g();
    }
}
