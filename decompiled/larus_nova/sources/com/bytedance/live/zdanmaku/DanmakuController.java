package com.bytedance.live.zdanmaku;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.live.artist.render.EntityState;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class DanmakuController<T extends Danmaku> implements rk6.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f255811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f255812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<Object> f255813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vk6.e f255814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque<T> f255815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<T> f255816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f255817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b<T> f255818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<Object, RenderEntity> f255819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f255820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.live.zdanmaku.data.c<T> f255821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final rk6.a<T> f255822l;

    public static final class a {
    }

    public interface b<T extends Danmaku> {
        void a(T r100);

        void b(T r100);
    }

    public static final class c implements vk6.e.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DanmakuController f255823a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f255824a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Danmaku f255825b;

            public a(c r100, Danmaku r101) {
                this.f255824a = r100;
                this.f255825b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b<T> r100 = this.f255824a.f255823a.f255818h;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.b(this.f255825b);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f255826a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Danmaku f255827b;

            public static final class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f255828a;

                public a(b r100) {
                    this.f255828a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    RenderEntity r100 = this.f255828a.f255827b.f255835c;     // Catch: Throwable -> L7
                    if (r100 != null) goto L5;
                    Intrinsics.throwUninitializedPropertyAccessException("renderEntity");     // Catch: Throwable -> L7
                L5:
                    r100.getClass();     // Catch: Throwable -> L7
                    r100.g(EntityState.WaitDestroy);     // Catch: Throwable -> L7
                    return;
                L7:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L11;
                    return;
                L11:
                    throw th;
                }
            }

            public b(c r100, Danmaku r101) {
                this.f255826a = r100;
                this.f255827b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b<T> r100 = this.f255826a.f255823a.f255818h;     // Catch: Throwable -> L9
                if (r100 == null) goto L5;
                r100.a(this.f255827b);     // Catch: Throwable -> L9
            L5:
                i r101 = this.f255826a.f255823a.f255811a;     // Catch: Throwable -> L9
                if (r101 == null) goto L12;
                r101.postRunnable(new a(this));     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public c(DanmakuController r100) {
            this.f255823a = r100;
        }

        @Override // vk6.e.b
        public final void a(T r100) {
            this.f255823a.f255812b.post(new b(this, r100));
        }

        @Override // vk6.e.b
        public final void b(T r100) {
            this.f255823a.f255812b.post(new a(this, r100));
        }
    }

    static {
    }

    @Override // rk6.a
    public final void b(vk6.e r100, float r101, Function0 r102) {
        this.f255822l.b(r100, r101, r102);
    }

    @Override // rk6.a
    public final boolean c() {
        return this.f255822l.c();
    }

    public final boolean a() {
        if (this.f255813c.isEmpty() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f255814d.isEmpty() == false) goto L11;
        if (this.f255815e.isEmpty() == false) goto L11;
        if (this.f255822l.c() == true) goto L11;
        return true;
    }

    public final void d() {
    L3:
        if (((LinkedList) this.f255815e).size() > this.f255817g) goto L11;
        if (((LinkedBlockingDeque) this.f255813c).size() == 0) goto L20;
        Object r100 = ((LinkedBlockingDeque) this.f255813c).removeFirst();
        Function1<Object, RenderEntity> r101 = this.f255819i;
        if (r101 == null) goto L3;
        RenderEntity r102 = r101.invoke(r100);
        if (r102 == null) goto L3;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r103 = this.f255821k.a();
        r103.f255835c = r102;
        r103.f(Danmaku.State.PREPARE);
        ((LinkedList) this.f255815e).add(r103);
        goto L3
    L20:
        return;
    }

    public DanmakuController(com.bytedance.live.zdanmaku.data.c<T> r100, rk6.a<T> r101) {
        this.f255821k = r100;
        this.f255822l = r101;
        this.f255812b = new Handler(Looper.getMainLooper());
        this.f255813c = new LinkedBlockingDeque();
        this.f255814d = new vk6.e(new c(this), new LinkedList());
        this.f255815e = new LinkedList();
        this.f255816f = (Function0<T>) new DanmakuController$nextPreparedDanmakuSupplier$1(this);
        this.f255817g = 4;
    }
}
