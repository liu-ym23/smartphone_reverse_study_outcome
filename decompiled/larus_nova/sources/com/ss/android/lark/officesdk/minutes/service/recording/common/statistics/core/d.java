package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f435436a;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        this.f435436a.remove("recording_id");
        return this.f435436a;
    }

    public d() {
        this.f435436a = new JSONObject();
    }

    public final void f(JSONObject r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Throwable -> L10
        this.f435436a.put(r103, r100.opt(r103));     // Catch: Throwable -> L10
        goto L6
    L8:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        lvb.a.b("MmRecordingTrackerParams", "[putAll] error:" + r105);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f435436a.put(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f435436a.put(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f435436a.put(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f435436a.put(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        lvb.a.b("MmRecordingTrackerParams", "[put] error: " + e.getMessage());
    }
}
