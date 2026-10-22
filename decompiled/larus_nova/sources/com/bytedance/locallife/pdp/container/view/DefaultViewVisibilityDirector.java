package com.bytedance.locallife.pdp.container.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class DefaultViewVisibilityDirector implements t, Handler.Callback {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f261217l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.view.c f261218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f261219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f261220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f261221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f261222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f261223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f261224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f261225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<b> f261226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f261227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<s, Integer> f261228k;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f261229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f261230b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f261229a, r101.f261229a) == true) goto L12;
            return false;
        L12:
            if (this.f261230b == r101.f261230b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f261229a.hashCode() * 31;
            long r101 = this.f261230b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "ViewAndTimeStamp(targetView=" + this.f261229a + ", timeInMillions=" + this.f261230b + ')';
        }

        public b(s r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "targetView");
            this.f261229a = r100;
            this.f261230b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultViewVisibilityDirector f261231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f261232b;

        public c(DefaultViewVisibilityDirector r100, s r101) {
            this.f261231a = r100;
            this.f261232b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f261231a.b(this.f261232b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        new a();
    }

    public final void e() {
        g(DefaultViewVisibilityDirector$clearInMainThread$1.INSTANCE);
        f().removeCallbacksAndMessages(null);
        View r100 = this.f261225h;
        if (r100 == null) goto L9;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L9;
        if (r101.isAlive() == false) goto L9;
        r101.removeOnGlobalLayoutListener(this.f261218a);
    L9:
        this.f261225h = null;
        this.f261219b = 0;
        ((LinkedHashMap) this.f261228k).clear();
        ((ArrayList) this.f261226i).clear();
    }

    public final Handler f() {
        return (Handler) this.f261224g.getValue();
    }

    public final void h() {
        if (((ArrayList) this.f261226i).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f261226i).iterator();
    L7:
        if (r100.hasNext() == false) goto L15;
        s r101 = ((b) r100.next()).f261229a;
        int r102 = r101.getIndexInBody();
        if (r101.f() == false) goto L7;
        int r103 = this.f261219b;
        int r104 = 1;
        if (r102 == 0) goto L14;
        r104 = 1 << r102;
    L14:
        this.f261219b = r103 | r104;
        goto L7
    L15:
        Iterator r105 = ((ArrayList) this.f261226i).iterator();
    L17:
        if (r105.hasNext() == false) goto L24;
        final b r106 = (b) r105.next();
        final s r107 = r106.f261229a;
        if (d(r107, null) == false) goto L17;
        r107.v();
        g(new DefaultViewVisibilityDirector$triggerWaitingViewCheck$2(r107, r106));
        Integer r108 = (Integer) ((LinkedHashMap) this.f261228k).get(r107);
        if (r108 == null) goto L23;
        int r109 = r108.intValue();
        f().removeMessages(r109);
    L23:
        r105.remove();
        goto L17
    }

    public DefaultViewVisibilityDirector(int r100) {
        this.f261218a = new com.bytedance.locallife.pdp.container.view.c(this);
        this.f261224g = LazyKt.lazy(new DefaultViewVisibilityDirector$handler$2(this));
        this.f261220c = 3;
        this.f261223f = 7;
        this.f261221d = 300;
        this.f261226i = new ArrayList();
        this.f261228k = new LinkedHashMap();
    }

    public static void g(Function0 r100) {
        if (HostServiceUtilsKt.u().p() == false) goto L6;
        String r101 = (String) r100.invoke();
        return;
    }

    @Override // com.bytedance.locallife.pdp.container.view.t
    public final void a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b(r100);
        return;
    L5:
        f().post(new c(this, r100));
    }

    public final void b(s r100) {
        if (this.f261222e == false) goto L6;
        r100.v();
        return;
    L6:
        boolean r101 = true;
        this.f261227j++;
        final int r102 = r100.getIndexInBody();
        final boolean r103 = r100.f();
        g(new DefaultViewVisibilityDirector$addTargetViewInMainThread$1(r102, r103));
        if (r103 == false) goto L14;
        if (r102 < 0) goto L14;
        int r104 = this.f261219b;
        if (r102 != 0) goto L12;
        int r105 = 1;
    L13:
        this.f261219b = r104 | r105;
        boolean r106 = true;
    L16:
        if (d(r100, Integer.valueOf(r102)) == false) goto L19;
        r100.v();
        return;
    L19:
        r100.m();
        if (r106 == true) goto L22;
    L24:
        r101 = false;
    L25:
        List<b> r107 = this.f261226i;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = ((ArrayList) r107).iterator();
    L27:
        if (r109.hasNext() == false) goto L30;
        r108.add(((b) r109.next()).f261229a);
        goto L27
    L30:
        if (r108.contains(r100) == true) goto L32;
        b r110 = new b(r100, SystemClock.elapsedRealtime());
        ((ArrayList) this.f261226i).add(r110);
        this.f261228k.put(r100, Integer.valueOf(this.f261227j));
        f().sendMessageDelayed(Message.obtain(f(), this.f261227j, r110), this.f261221d);
    L32:
        if (r101 == false) goto L36;
        h();
        return;
    L36:
        return;
    L22:
        if ((!((ArrayList) this.f261226i).isEmpty()) == false) goto L24;
    L12:
        r105 = 1 << r102;
    L14:
        r106 = false;
        goto L16
    }

    public final void c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f261225h = r100;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 != null) goto L5;
    L7:
        g(DefaultViewVisibilityDirector$bindRootView$1.INSTANCE);
        return;
    L5:
        if (r101.isAlive() == false) goto L7;
        r101.removeOnGlobalLayoutListener(this.f261218a);
        r101.addOnGlobalLayoutListener(this.f261218a);
        goto L7
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Object r101 = r100.obj;
        if ((r101 instanceof b) == false) goto L5;
        final b r102 = (b) r101;
    L6:
        if (r102 == null) goto L13;
        s r103 = r102.f261229a;
        g(new DefaultViewVisibilityDirector$whenTimeoutForCheck$1(r102));
        this.f261228k.remove(r103);
        int r104 = r103.getIndexInBody();
        int r105 = this.f261219b;
        if (r104 != 0) goto L10;
        int r106 = 1;
    L11:
        this.f261219b = r106 | r105;
        r103.v();
        ((ArrayList) this.f261226i).remove(r102);
        h();
        return true;
    L10:
        r106 = 1 << r104;
        goto L11
    L13:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean d(s r100, Integer r101) {
        if (r101 == null) goto L4;
        int r102 = r101.intValue();
    L6:
        if (r102 >= 0) goto L9;
        return true;
    L9:
        if (r102 < this.f261220c) goto L15;
        int r103 = this.f261219b;
        int r104 = this.f261223f;
        if ((r103 & r104) == r104) goto L24;
        return false;
    L24:
        return true;
    L15:
        int r105 = r102 + 1;
        if (r105 != 0) goto L18;
        int r106 = 1;
    L20:
        if (r106 == (this.f261219b & r106)) goto L25;
        return false;
    L25:
        return true;
    L18:
        r106 = (1 << r105) - 1;
        goto L20
    L4:
        r102 = r100.getIndexInBody();
        goto L6
    }
}
