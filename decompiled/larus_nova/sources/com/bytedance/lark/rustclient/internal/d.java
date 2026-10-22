package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.Packet;
import com.bytedance.larksuite.wire.CommandScope;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.lark.rustclient.api.j> f253962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f253963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<Pair<com.bytedance.lark.sdk.refactor.q, com.bytedance.lark.rustclient.api.w>> f253964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Subject<com.bytedance.lark.sdk.refactor.b>> f253965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Integer> f253966e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f253967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.lark.sdk.refactor.q f253968b;

        public a(d r100, com.bytedance.lark.sdk.refactor.q r101) {
            this.f253967a = r100;
            this.f253968b = r101;
        }

        public final void a() {
            PublishSubject<Pair<com.bytedance.lark.sdk.refactor.q, com.bytedance.lark.rustclient.api.w>> r100 = this.f253967a.f253964c;
            com.bytedance.lark.sdk.refactor.q r101 = this.f253968b;
            Packet r102 = r101.f254278b;
            Intrinsics.checkNotNullParameter(r102, "<this>");
            CommandScope r103 = e.a(r102.cmd);
            int r104 = e.a.f253973a[r103.ordinal()];
            if (r104 != 1) goto L5;
            Object r105 = com.bytedance.lark.rustclient.api.e.f253910a;
        L10:
            r100.onNext(TuplesKt.to(r101, r105));
            return;
        L5:
            if (r104 != 2) goto L8;
            r105 = new com.bytedance.lark.rustclient.api.y(r102.user_id, r102.user_container_id);
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.lark.sdk.refactor.b f253969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Subject<com.bytedance.lark.sdk.refactor.b> f253970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f253971c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f253972a = null;

            static {
                int[] r100 = new int[Packet.StreamStatus.values().length];
                r100[Packet.StreamStatus.ACTIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Packet.StreamStatus.FINAL_WITHOUT_PAYLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f253972a = r100;
            }
        }

        public b(com.bytedance.lark.sdk.refactor.b r100, Subject<com.bytedance.lark.sdk.refactor.b> r101, d r102) {
            this.f253969a = r100;
            this.f253970b = r101;
            this.f253971c = r102;
        }

        public final void a() {
            Packet.StreamStatus r100 = this.f253969a.f254250g;
            int r101 = a.f253972a[r100.ordinal()];
            if (r101 != 1) goto L5;
            this.f253970b.onNext(this.f253969a);
            return;
        L5:
            if (r101 == 2) goto L7;
            this.f253971c.f253965d.remove(Long.valueOf(this.f253969a.f254244a));
            this.f253971c.f253966e.remove(Long.valueOf(this.f253969a.f254244a));
            this.f253970b.onNext(this.f253969a);
            this.f253970b.onComplete();
            return;
        L7:
            this.f253971c.f253965d.remove(Long.valueOf(this.f253969a.f254244a));
            this.f253971c.f253966e.remove(Long.valueOf(this.f253969a.f254244a));
            this.f253970b.onComplete();
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

    public final Observable<Pair<com.bytedance.lark.sdk.refactor.q, com.bytedance.lark.rustclient.api.w>> f() {
        return this.f253964c.hide();
    }

    public final void a(com.bytedance.lark.sdk.refactor.q r100) {
        Intrinsics.checkNotNullParameter(r100, "pushData");
        List<com.bytedance.lark.rustclient.api.j> r101 = this.f253962a;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (((com.bytedance.lark.rustclient.api.j) r103.next()).a(r100) == false) goto L9;
        r102 = true;
    L13:
        if (r102 == false) goto L15;
        return;
    L15:
        this.f253963b.e().scheduleDirect(new a(this, r100));
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public final void b(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Subject<com.bytedance.lark.sdk.refactor.b> r101 = this.f253965d.get(Long.valueOf(r100.f254244a));
        if (r101 != null) goto L5;
        return;
    L5:
        this.f253963b.d(this.f253966e.get(Long.valueOf(r100.f254244a))).scheduleDirect(new b(r100, r101, this));
    }

    @Override // com.bytedance.lark.sdk.refactor.i
    public final boolean d(long r100) {
        return this.f253965d.containsKey(Long.valueOf(r100));
    }

    @Override // com.bytedance.lark.rustclient.internal.l
    public final Observable<com.bytedance.lark.sdk.refactor.b> e(long r100) {
        return c(r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends com.bytedance.lark.rustclient.api.j> r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "definition");
        this.f253962a = r100;
        this.f253963b = r101;
        this.f253964c = PublishSubject.create();
        this.f253965d = new ConcurrentHashMap();
        this.f253966e = new ConcurrentHashMap();
    }

    public final Observable<com.bytedance.lark.sdk.refactor.b> c(long r100, Integer r101) {
        if (r101 == null) goto L4;
        int r102 = r101.intValue();
        Integer r103 = this.f253966e.putIfAbsent(Long.valueOf(r100), Integer.valueOf(r102));
    L4:
        ConcurrentHashMap<Long, Subject<com.bytedance.lark.sdk.refactor.b>> r104 = this.f253965d;
        Long r105 = Long.valueOf(r100);
        Subject<com.bytedance.lark.sdk.refactor.b> r106 = r104.get(r105);
        if (r106 != null) goto L11;
        r106 = BehaviorSubject.create();
        Subject<com.bytedance.lark.sdk.refactor.b> r107 = r104.putIfAbsent(r105, r106);
        if (r107 == null) goto L11;
        r106 = r107;
    L11:
        return r106.hide();
    }
}
