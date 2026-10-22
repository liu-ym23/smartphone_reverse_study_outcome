package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class u extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z.a<Effect> f457948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z.a<Effect> f457949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z.a<String> f457950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z.a<Effect> f457951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z.a<Pair<Effect, ExceptionResult>> f457952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final EffectConfig f457953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Effect> f457954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f457955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.model.a f457956o;

    public static final class a {
    }

    public static final class b implements hlc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f457957a;

        @Override // hlc.d
        public final void onProgress(Effect r100, int r101, long r102) {
        }

        @Override // hlc.d
        public final void onStart(Effect r100) {
        }

        public b(u r100) {
            this.f457957a = r100;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onSuccess(Effect r100) {
            Effect r101 = r100;
            if (r101 == null) goto L5;
            this.f457957a.f457950i.remove(r101.getId());
            this.f457957a.f457951j.add(r101);
        L5:
            this.f457957a.f();
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onFail(Effect r100, ExceptionResult r101) {
            Effect r102 = r100;
            if (r102 == null) goto L5;
            this.f457957a.f457950i.remove(r102.getId());
            this.f457957a.f457952k.add(new Pair(r102, r101));
        L5:
            this.f457957a.f();
        }
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        if (this.f457949h.isEmpty() == false) goto L6;
        e(new DownloadEffectListTask$onSuccess$1(this, new ArrayList()));
        return;
    L6:
        f();
    }

    public final void f() {
        z.a<Pair<Effect, ExceptionResult>> r100 = null;
        if ((!this.f457949h.isEmpty()) == false) goto L25;
        if (this.f457950i.size() >= 5) goto L55;
        int r101 = 5 - this.f457950i.size();
        int r102 = 0;
    L7:
        if (r102 > r101) goto L59;
        if ((!this.f457949h.isEmpty()) == false) goto L60;
        c0.e r103 = v.f457960a;
        r103.a();
        z.a<Effect> r104 = this.f457949h;     // Catch: Throwable -> L21
        if ((!r104.isEmpty()) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L20;
        Effect r105 = r104.remove(0);     // Catch: Throwable -> L21
        if (r105 == null) goto L20;
        g(r105);     // Catch: Throwable -> L21
        r102 = r102 + 1;
    L20:
        r103.b();
    L21:
        th = move-exception;
        r103.b();
        throw th;
    L60:
        return;
    L59:
        return;
    L55:
        return;
    L25:
        if ((this.f457951j.size() + this.f457952k.size()) == this.f457948g.size()) goto L27;
        return;
    L27:
        if (this.f457951j.size() != this.f457948g.size()) goto L29;
        e(new DownloadEffectListTask$onSuccess$1(this, this.f457954m));
        return;
    L29:
        z.a<Pair<Effect, ExceptionResult>> r106 = this.f457952k;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<Pair<Effect, ExceptionResult>> r108 = r106.iterator();
    L31:
        if (r108.hasNext() == false) goto L33;
        r107.add(r108.next().getFirst());
        goto L31
    L33:
        z.a<Pair<Effect, ExceptionResult>> r109 = this.f457952k;
        if ((!r109.isEmpty()) == false) goto L36;
        r100 = r109;
    L36:
        if (r100 == null) goto L42;
        Pair<Effect, ExceptionResult> r110 = r100.get(0);
        if (r110 == null) goto L42;
        final ExceptionResult r111 = r110.getSecond();
        if (r111 == null) goto L42;
    L44:
        if ((!r107.isEmpty()) == false) goto L58;
        e(new DownloadEffectListTask$onFail$1(this, r111));
        return;
    L58:
        return;
    L42:
        r111 = new ExceptionResult(10002);
        goto L44
    }

    public final void g(Effect r100) {
        this.f457950i.add(r100.getId());
        String r101 = com.ss.ugc.effectplatform.util.q.a();
        b r102 = new b(this);
        this.f457953l.N.b(r101, r102);
        DownloadEffectTask r103 = new DownloadEffectTask(r100, this.f457953l, r101, this.f457956o);
        q1 r104 = this.f457953l.D;
        if (r104 == null) goto L6;
        r104.a(r103);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(EffectConfig r100, List<? extends Effect> r101, String r102, com.ss.ugc.effectplatform.model.a r103) {
        super(r102, r100.N);
        this.f457953l = r100;
        this.f457954m = r101;
        this.f457955n = r102;
        this.f457956o = r103;
        this.f457948g = new z.a(true);
        this.f457949h = new z.a(true);
        this.f457950i = new z.a(true);
        this.f457951j = new z.a(true);
        this.f457952k = new z.a(true);
        HashSet r104 = new HashSet();
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Effect r106 = (Effect) r105.next();
        String r107 = com.ss.ugc.effectplatform.model.b.a(r106);
        if (r104.contains(r107) == true) goto L4;
        this.f457948g.add(r106);
        r104.add(r107);
        goto L4
    L8:
        this.f457949h.addAll(this.f457948g);
    }
}
