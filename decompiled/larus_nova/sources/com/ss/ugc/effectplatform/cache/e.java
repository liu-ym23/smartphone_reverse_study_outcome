package com.ss.ugc.effectplatform.cache;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.StrategyCacheClearModel;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements IEffectPlatformBaseListener<StrategyCacheClearModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f457332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f457333b;

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(StrategyCacheClearModel r100) {
        final StrategyCacheClearModel r101 = r100;
        Logger.INSTANCE.d("JKL", "queryCacheClearStrategyFromServer onSuccess");
        g.a(this.f457332a, "before");
        q1 r102 = this.f457332a.f457335a.D;
        if (r102 == null) goto L6;
        r102.a(new com.ss.ugc.effectplatform.task.b(q.a(), new EffectCacheCleaner$cleanResourcesByServerStrategyWithAllowList$1$onSuccess$1(this, r101)));
        return;
    }

    public e(g r100, Function3 r101) {
        this.f457332a = r100;
        this.f457333b = r101;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(StrategyCacheClearModel r100, ExceptionResult r101) {
        Logger.INSTANCE.d("JKL", "queryFromServer onFail, server error: logId: " + r101.getLogId());
        klc.a r102 = this.f457332a.f457335a.f457176v.f1239a;
        if (r102 == null) goto L6;
        klc.b.m(r102, -1, "server error", r101.getLogId(), null, null, 24);
        return;
    }
}
