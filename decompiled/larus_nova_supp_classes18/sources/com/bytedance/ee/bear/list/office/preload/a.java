package com.bytedance.ee.bear.list.office.preload;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ AtomicBoolean e;
    public final /* synthetic */ List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> f;
    public final /* synthetic */ List<OfficeSpaceDbPreloadWorker.b> g;
    public final /* synthetic */ long h;
    public final /* synthetic */ Context i;
    public final /* synthetic */ Function1<OfficeSpaceDbPreloadWorker.a, Unit> j;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r1, String r2, Ref.IntRef r3, Ref.BooleanRef r4, AtomicBoolean r5, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r6, List<OfficeSpaceDbPreloadWorker.b> r7, long r8, Context r10, Function1<? super OfficeSpaceDbPreloadWorker.a, Unit> r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r10;
        this.j = r11;
    }

    public final void a() {
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_timeout requestId=" + this.a + " key=" + this.b + " remaining=" + this.c.element);
        OfficeSpaceDbPreloadWorker.b(this.d, this.e, this.c, this.f, this.a, this.g, this.b, this.h, this.i, this.j, true);
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
