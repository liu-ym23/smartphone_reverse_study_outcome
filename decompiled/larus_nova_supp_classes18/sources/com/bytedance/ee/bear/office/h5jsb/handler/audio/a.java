package com.bytedance.ee.bear.office.h5jsb.handler.audio;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.common.AudioRecordHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Set<Integer> d = null;
    public volatile gk5.a a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.h5jsb.handler.audio.a$a, reason: collision with other inner class name */
    public static final class C0132a {
    }

    static {
        d = SetsKt.setOf(new Integer[]{Integer.valueOf(AudioRecordHelper.AudioRecordState.TOO_SHORT.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.CANCEL.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.FAILED.getValue()), Integer.valueOf(AudioRecordHelper.AudioRecordState.SUCCESS.getValue())});
    }

    public a() {
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }

    public final void a(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        gk5.a r0 = this.a;
        if (r0 == null) goto L5;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        nk5.b.a(r0, r6);     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        tt5.a.e("AudioFrameRecordedHandler", "dispatch record event failed", r4, false);
    L16:
        if (d.contains(Integer.valueOf(r6.getIntValue("state"))) == false) goto L26;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (this.a != r0) goto L21;
        this.a = null;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L26:
        return;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        if (this.b.compareAndSet(false, true) == false) goto L31;
        tt5.a.k("AudioFrameRecordedHandler", "drop record event: callback unavailable");
        b("callback unavailable when dispatching");
        return;
    }

    public final void b(String r4) {
        if (this.c.compareAndSet(false, true) == true) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        AudioRecordHelper.a.h();     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        tt5.a.e("AudioFrameRecordedHandler", "stop record failed, reason=".concat(r4), r2, false);
    L12:
        this.c.set(false);
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
