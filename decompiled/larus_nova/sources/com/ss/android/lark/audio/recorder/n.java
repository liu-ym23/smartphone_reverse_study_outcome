package com.ss.android.lark.audio.recorder;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements m {

    public static final class a {
    }

    static {
    }

    public n() {
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final boolean a() {
        return false;
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
        Log.i("IdleRecordState", "[onStop]hashCode:" + hashCode());
        m r101 = r100.a(4);
        r100.b(r101);
        r101.b(r100);
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void c(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void d(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void e(p r100) {
        m.a.a(r100);
    }

    @Override // com.ss.android.lark.audio.recorder.m
    public final void f(p r100) {
        Intrinsics.checkNotNullParameter(r100, "recordTask");
        Log.i("IdleRecordState", "[onStart]hashCode:" + hashCode());
        m r101 = r100.a(1);
        r100.b(r101);
        r101.f(r100);
    }
}
