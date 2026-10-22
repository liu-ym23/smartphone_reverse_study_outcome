package com.ss.ugc.effectplatform.task;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class ReadUpdateTagTask extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EffectConfig f457660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f457661h;

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        com.ss.ugc.effectplatform.cache.j r100 = this.f457660g.A.f1239a;
        final HashMap r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.queryToValue(EffectConstants.KEY_EFFECT_UPDATE_TIME);
    L6:
        if (r102 != null) goto L18;
        final ExceptionResult r103 = new ExceptionResult(10009);
        e(new ReadUpdateTagTask$onFail$1(this, r103));
        return;
    L18:
        dlc.a r104 = this.f457660g.f457174t;     // Catch: Exception -> L15
        if (r104 == null) goto L11;
        r101 = (HashMap) r104.f469201a.convertJsonToObj(r102, HashMap.class);     // Catch: Exception -> L15
    L11:
        if (r101 == null) goto L13;
        e(new ReadUpdateTagTask$onSuccess$1(this, r101));     // Catch: Exception -> L15
        return;
    L13:
        final ExceptionResult r105 = new ExceptionResult(new IllegalStateException("local file destroy"));     // Catch: Exception -> L15
        e(new ReadUpdateTagTask$onFail$1(this, r105));     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        final ExceptionResult r106 = new ExceptionResult(e);
        e(new ReadUpdateTagTask$onFail$1(this, r106));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new ReadUpdateTagTask$onCancel$1(this));
    }

    public ReadUpdateTagTask(EffectConfig r100, String r101) {
        super(r101, null);
        this.f457660g = r100;
        this.f457661h = r101;
    }
}
