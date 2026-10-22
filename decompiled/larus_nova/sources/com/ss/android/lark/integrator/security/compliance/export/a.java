package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.pb.security_event.Event;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class a implements b {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.export.a$a, reason: collision with other inner class name */
    public static final class C5073a {
    }

    static {
    }

    @Inject
    public a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b.d.f409722a.b();     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L13;
        Log.e("BehaviorAuditService", "init AuditSdk failed", r102);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.b
    public final void T3(Event.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.security.activity_auditing_for_doubao_chat") == true) goto L14;
        Log.i("BehaviorAuditService", "auditEvent skipped: FG disabled");
        return;
    L14:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        owa.a.a().getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r100, "builder");     // Catch: Throwable -> L8
        com.ss.android.lark.auditsdk.wrapper.b.d.f409722a.a(r100);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        Log.e("BehaviorAuditService", "auditEvent failed", r103);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
