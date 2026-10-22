package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class WriteUpdateTagTask extends BaseTask {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EffectConfig f457667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f457668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z.b<String, String> f457669i;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        HashMap r100 = new HashMap();
        z.b<String, String> r101 = this.f457669i;
        if (r101 == null) goto L18;
        r100.putAll(r101);
    L18:
        dlc.a r102 = this.f457667g.f457174t;     // Catch: Exception -> L15
        if (r102 == null) goto L8;
        String r103 = r102.f469201a.convertObjToJson(r100);     // Catch: Exception -> L15
    L9:
        if (r103 == null) goto L13;
        com.ss.ugc.effectplatform.cache.j r104 = this.f457667g.A.f1239a;     // Catch: Exception -> L15
        if (r104 == null) goto L13;
        r104.save(EffectConstants.KEY_EFFECT_UPDATE_TIME, r103);     // Catch: Exception -> L15
    L13:
        e(new WriteUpdateTagTask$onSuccess$1(this));     // Catch: Exception -> L15
        return;
    L8:
        r103 = null;
    L15:
        e = move-exception;
        final ExceptionResult r105 = new ExceptionResult(e);
        e(new WriteUpdateTagTask$onFail$1(this, r105));
        Logger.e$default(Logger.INSTANCE, "WriteUpdateTagTask", String.valueOf(e), null, 4, null);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new WriteUpdateTagTask$onCancel$1(this));
    }

    public WriteUpdateTagTask(EffectConfig r100, String r101, z.b<String, String> r102) {
        super(r101, null);
        this.f457667g = r100;
        this.f457668h = r101;
        this.f457669i = r102;
    }
}
