package com.ss.android.lark.conditional.access.auth.v2.handler;

import android.os.Handler;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.o;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f417823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, WeakReference<o>> f417824b;

    public static final class a {
    }

    static {
    }

    private final void update(o.b r100) {
        qqb.a.h("VCFileProtectTimerHandler update");     // Catch: Throwable -> L5
        int r101 = ScsLogger.f440428a;     // Catch: Throwable -> L5
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "update(), identifier is " + r100.getIdentifier());     // Catch: Throwable -> L5
        new ArrayList();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof o.b) == false) goto L6;
        o.b r101 = (o.b) r100;
        String r102 = r101.getIdentifier();
        this.f417824b.put(r102, new WeakReference(r101.getContext()));
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "handleEvent(), event is OpenEvent, identifier is " + r102);
        ((Handler) this.f417823a.getValue()).removeCallbacksAndMessages(r102);
        update(r101);
        return;
    L6:
        if ((r100 instanceof o.a) == false) goto L10;
        String r104 = ((o.a) r100).getIdentifier();
        this.f417824b.remove(r104);
        int r105 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "handleEvent(), event is LeaveEvent, identifier is " + r104);
        ((Handler) this.f417823a.getValue()).removeCallbacksAndMessages(r104);
        return;
    }

    public f(q r100, Lazy<? extends Handler> r101) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        Intrinsics.checkNotNullParameter(r101, "timerHandler");
        this.f417823a = r101;
        this.f417824b = new LinkedHashMap();
    }
}
