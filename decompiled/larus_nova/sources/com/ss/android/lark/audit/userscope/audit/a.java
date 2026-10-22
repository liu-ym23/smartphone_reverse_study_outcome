package com.ss.android.lark.audit.userscope.audit;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f409464d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorScheduler f409465e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f409466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<Long> f409467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f409468c;

    /* JADX INFO: renamed from: com.ss.android.lark.audit.userscope.audit.a$a, reason: collision with other inner class name */
    public static final class C4756a {
    }

    static {
        ScheduledExecutorService r100 = CoreThreadPool.getDefault().getSingleScheduledThreadPool("audit_record");
        f409464d = r100;
        f409465e = new ExecutorScheduler(r100, false);
    }

    @Inject
    public a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "auditRecordImpl");
        this.f409466a = r100;
        PublishSubject<Long> r101 = PublishSubject.create();
        this.f409467b = r101;
        CompositeDisposable r102 = new CompositeDisposable();
        this.f409468c = r102;
        r102.add(r100.a(r101));
    }
}
