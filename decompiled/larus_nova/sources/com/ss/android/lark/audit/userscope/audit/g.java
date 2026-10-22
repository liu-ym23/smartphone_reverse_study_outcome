package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.security_event.Event;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class g implements l, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f409492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.audit.userscope.audit.a f409493b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.audit.userscope.audit.l
    public final void a4() {
        Log.i("AUDIT_AuditRecordService", EventConstant.Value.RETRY);
        com.ss.android.lark.audit.userscope.audit.a r100 = this.f409493b;
        r100.getClass();
        Log.i("AUDIT_AuditDispatcher", "tryUploadEvent");
        r100.f409467b.onNext(1L);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f409492a;
    }

    @Override // com.ss.android.lark.audit.userscope.audit.j
    public final void Qe(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Log.i("AUDIT_AuditRecordService", "recordAuditLog");
        com.ss.android.lark.audit.userscope.audit.a r101 = this.f409493b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        Log.i("AUDIT_AuditDispatcher", "tryRecordEvent");
        com.ss.android.lark.audit.userscope.audit.a.f409464d.execute(new c(r101, r100));
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("AUDIT_AuditRecordService", "onUserOffline");
        com.ss.android.lark.audit.userscope.audit.a r101 = this.f409493b;
        r101.getClass();
        Log.i("AUDIT_AuditDispatcher", "clear");
        r101.f409467b.onComplete();
        r101.f409468c.clear();
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("AUDIT_AuditRecordService", "onUserOnline");
        com.ss.android.lark.audit.userscope.audit.a r101 = this.f409493b;
        r101.getClass();
        io.reactivex.observers.e r102 = new io.reactivex.observers.e(r101.f409467b);
        Observable.interval(60000, TimeUnit.MILLISECONDS).doOnNext(b.f409469a).subscribe(r102);
        r101.f409468c.add(r102);
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Inject
    public g(m r100, d r101, com.ss.android.lark.audit.userscope.audit.a r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "storage");
        Intrinsics.checkNotNullParameter(r102, "dispatcher");
        this.f409492a = r100;
        this.f409493b = r102;
        s.a(this);
    }
}
