package com.larus.im.internal.network.link.impl.rtc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f349305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f349306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f349307c;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f349305a = new AtomicBoolean(false);
        this.f349306b = new ArrayList();
        this.f349307c = new ArrayList();
    }

    public final synchronized void a(JSONObject r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "params");     // Catch: Throwable -> L13
        if (((ArrayList) this.f349306b).isEmpty() == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        r110.put("connect_retry_count", ((ArrayList) this.f349306b).size());     // Catch: Throwable -> L9
        r110.put("connect_retry_reasons", CollectionsKt.joinToString$default(this.f349306b, ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L9
        Result.m9449constructorimpl(r110.put("connect_retry_attempt_costs", CollectionsKt.joinToString$default(this.f349307c, ",", null, null, 0, null, null, 62, null)));     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r100, long r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L6
        ((ArrayList) this.f349306b).add(r100);     // Catch: Throwable -> L6
        List<Long> r102 = this.f349307c;     // Catch: Throwable -> L6
        ArrayList r103 = (ArrayList) r102;     // Catch: Throwable -> L6
        r103.add(Long.valueOf(r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
