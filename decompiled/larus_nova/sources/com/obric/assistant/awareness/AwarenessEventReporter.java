package com.obric.assistant.awareness;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.awareness.IAwarenessEventReporter;
import com.larus.utils.logger.FLogger;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessEventData;
import com.obric.memorydata.sdk.awareness.e;
import com.obric.memorydata.sdk.awareness.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tka.c;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/awareness/AwarenessEventReporter;", "Lcom/larus/dora/api/awareness/IAwarenessEventReporter;", "<init>", "()V", "report", "", "key", "", "value", "", "timestamp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwarenessEventReporter implements IAwarenessEventReporter {

    public static final class a {
    }

    static {
    }

    public AwarenessEventReporter() {
    }

    @Override // com.larus.dora.api.awareness.IAwarenessEventReporter
    public final void a(String r110, Object r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "value");
        e r100 = e.f397109a;
        Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
        AwarenessEventData r113 = new AwarenessEventData(r110, r111, r112, null, 8, null);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "event");
        Context r114 = r101.getApplicationContext();
        Bundle r115 = new Bundle();
        r115.putParcelable("awareness_event", r113);
        Unit r102 = Unit.INSTANCE;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        c.c("ContextAwareness", "call awareness provider method=report_awareness_event");     // Catch: Throwable -> L13
        Uri r104 = UriProtector.parse("content://com.obric.memorydata.awareness.provider");     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L13
        Bundle r116 = e.k(r114, r104, r115);     // Catch: Throwable -> L13
        int r117 = l.f397131a;     // Catch: Throwable -> L13
        if (r116 != null) goto L6;
        MemoryResponse r118 = new MemoryResponse(400, "provider returns null", 4);     // Catch: Throwable -> L13
    L8:
        if (r118.a() == false) goto L10;
        c.c("ContextAwareness", "call awareness provider success method=report_awareness_event");     // Catch: Throwable -> L13
    L11:
        Object r119 = Result.m9449constructorimpl(r118);     // Catch: Throwable -> L13
    L15:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L19;
        c.b("ContextAwareness", "call provider failed method=report_awareness_event", r120);
        r119 = new MemoryResponse(400, r120.getMessage(), 4);
    L19:
        MemoryResponse r121 = (MemoryResponse) r119;
        if (r121.a() == false) goto L22;
        FLogger.f375446a.i("AwarenessEventReporter", "感知事件已上报，key=" + r110);
        return;
    L22:
        FLogger.f375446a.e("AwarenessEventReporter", "感知事件上报失败，key=" + r110 + ", code=" + r121.f397051a);
        return;
    L10:
        c.d("ContextAwareness", "call awareness provider failed method=report_awareness_event code=" + r118.f397051a + " msg=" + r118.f397052b);     // Catch: Throwable -> L13
        goto L11
    L6:
        r118 = new MemoryResponse(r116.getInt("result_code", 400), r116.getString("result_message"), 4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
