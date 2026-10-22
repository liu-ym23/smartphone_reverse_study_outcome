package com.bytedance.ee.bear.office.h5jsb.handler.audio;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f235483d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile gk5.a f235484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f235485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f235486c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.h5jsb.handler.audio.a$a, reason: collision with other inner class name */
    public static final class C3379a {
    }

    static {
        f235483d = SetsKt.setOf(new Integer[]{Integer.valueOf(AudioRecordHelper.AudioRecordState.TOO_SHORT.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.CANCEL.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.FAILED.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.SUCCESS.getValue())});
    }

    public a() {
        this.f235485b = new AtomicBoolean(false);
        this.f235486c = new AtomicBoolean(false);
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        gk5.a r101 = this.f235484a;
        if (r101 == null) goto L5;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        nk5.b.a(r101, r100);     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        tt5.a.e("AudioFrameRecordedHandler", "dispatch record event failed", r104, false);
    L16:
        if (f235483d.contains(Integer.valueOf(r100.getIntValue("state"))) == false) goto L26;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (this.f235484a != r101) goto L21;
        this.f235484a = null;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L26:
        return;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        if (this.f235485b.compareAndSet(false, true) == false) goto L31;
        tt5.a.k("AudioFrameRecordedHandler", "drop record event: callback unavailable");
        b("callback unavailable when dispatching");
        return;
    }

    public final void b(String r100) {
        if (this.f235486c.compareAndSet(false, true) == true) goto L14;
        return;
    L14:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        AudioRecordHelper.f214330a.h();     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        tt5.a.e("AudioFrameRecordedHandler", "stop record failed, reason=".concat(r100), r103, false);
    L12:
        this.f235486c.set(false);
        return;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
