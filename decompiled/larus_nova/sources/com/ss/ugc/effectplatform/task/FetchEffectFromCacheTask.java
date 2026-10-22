package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: classes36.dex */
public final class FetchEffectFromCacheTask extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EffectConfig f457595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Effect f457596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f457597i;

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        if (this.f457596h != null) goto L5;
    L6:
        final ExceptionResult r100 = new ExceptionResult(10003);
        e(new FetchEffectFromCacheTask$onFail$1(this, r100));
    L7:
        com.ss.ugc.effectplatform.cache.j r101 = this.f457595g.A.f1239a;
        if (r101 == null) goto L23;
        final Effect r102 = this.f457596h;
        if (r102 == null) goto L24;
    L16:
        e = move-exception;
        final ExceptionResult r103 = new ExceptionResult(e);
        e(new FetchEffectFromCacheTask$onFail$1(this, r103));
        return;
    L12:
        if (r101.has(r102.getId()) == false) goto L14;
        e(new FetchEffectFromCacheTask$execute$1(this, r102));     // Catch: Exception -> L16
    L19:
        return;
    L14:
        final ExceptionResult r104 = new ExceptionResult(10003);     // Catch: Exception -> L16
        e(new FetchEffectFromCacheTask$onFail$1(this, r104));     // Catch: Exception -> L16
        goto L19
    L24:
        return;
    L23:
        return;
    L5:
        if (this.f457595g.A.f1239a != null) goto L7;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new FetchEffectFromCacheTask$onCancel$1(this));
    }

    public FetchEffectFromCacheTask(EffectConfig r100, Effect r101, String r102) {
        super(r102, null);
        this.f457595g = r100;
        this.f457596h = r101;
        this.f457597i = r102;
    }
}
