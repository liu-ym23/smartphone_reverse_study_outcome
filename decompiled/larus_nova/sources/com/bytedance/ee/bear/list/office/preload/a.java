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

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f229134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f229135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f229136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f229137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f229138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> f229139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List<OfficeSpaceDbPreloadWorker.b> f229140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f229141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Context f229142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function1<OfficeSpaceDbPreloadWorker.a, Unit> f229143j;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, Ref.IntRef r102, Ref.BooleanRef r103, AtomicBoolean r104, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r105, List<OfficeSpaceDbPreloadWorker.b> r106, long r107, Context r110, Function1<? super OfficeSpaceDbPreloadWorker.a, Unit> r111) {
        this.f229134a = r100;
        this.f229135b = r101;
        this.f229136c = r102;
        this.f229137d = r103;
        this.f229138e = r104;
        this.f229139f = r105;
        this.f229140g = r106;
        this.f229141h = r107;
        this.f229142i = r110;
        this.f229143j = r111;
    }

    public final void a() {
        tt5.a.h("OfficeSpaceDbPreloadWorker", "office_space_db_preload_timeout requestId=" + this.f229134a + " key=" + this.f229135b + " remaining=" + this.f229136c.element);
        OfficeSpaceDbPreloadWorker.b(this.f229137d, this.f229138e, this.f229136c, this.f229139f, this.f229134a, this.f229140g, this.f229135b, this.f229141h, this.f229142i, this.f229143j, true);
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
