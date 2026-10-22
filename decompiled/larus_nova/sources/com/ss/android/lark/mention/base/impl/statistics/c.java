package com.ss.android.lark.mention.base.impl.statistics;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import z5c.l0;
import z5c.m0;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f431869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f431870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f431871c;

    public c(String r100, String r101, boolean r102) {
        this.f431869a = r100;
        this.f431870b = r101;
        this.f431871c = r102;
    }

    public final void a() {
        String r100 = this.f431869a;
        String r101 = this.f431870b;
        boolean r102 = this.f431871c;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        s5c.a r104 = l0.f570241c.a(r100);     // Catch: Throwable -> L5
        s5c.a r105 = m0.f570252f.a("ai_qa");     // Catch: Throwable -> L5
        s5c.d.f540773o2.getClass();     // Catch: Throwable -> L5
        s5c.a r106 = new s5c.a("conf", r101);     // Catch: Throwable -> L5
        s5c.a r107 = new s5c.a("qa_is_top", String.valueOf(r102));     // Catch: Throwable -> L5
        Statistics.sendEvent("im_mention_board_item_view", s5c.d.b.b(r105, r104).plus(r106).plus(r107).toJson());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
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
