package com.ss.android.lark.mention.base.impl.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.l0;
import z5c.m0;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseAtBean f431867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f431868b;

    public b(BaseAtBean r100, String r101) {
        this.f431867a = r100;
        this.f431868b = r101;
    }

    public final void a() {
        BaseAtBean r100 = this.f431867a;
        String r101 = this.f431868b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Map<String, Boolean> r103 = frb.a.f478644e;     // Catch: Throwable -> L13
        Pair r104 = frb.a.C5946a.a();     // Catch: Throwable -> L13
        boolean r105 = ((Boolean) r104.component1()).booleanValue();     // Catch: Throwable -> L13
        boolean r106 = ((Boolean) r104.component2()).booleanValue();     // Catch: Throwable -> L13
        if (r105 == false) goto L10;
        s5c.a r107 = l0.f570241c.a(r100.getId());     // Catch: Throwable -> L13
        s5c.a r108 = m0.f570252f.a("ai_qa");     // Catch: Throwable -> L13
        s5c.d.a r109 = s5c.d.f540773o2;     // Catch: Throwable -> L13
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        r109.getClass();     // Catch: Throwable -> L13
        s5c.a r110 = new s5c.a("conf", r101);     // Catch: Throwable -> L13
        Statistics.sendEvent("im_mention_board_item_valid_view", s5c.d.b.b(r108, r107).plus(r110).plus(new s5c.a("qa_is_top", String.valueOf(r106))).toJson());     // Catch: Throwable -> L13
        Log.i("MessageHitPoint", "ai_knowledge is valid visible, isTop: " + r106);     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        Log.i("MessageHitPoint", "ai_knowledge is invisible or invalid");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
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
