package com.larus.audio;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements m58.v {
    public z() {
    }

    @Override // m58.v
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i(r100, r101);
    }

    @Override // m58.v
    public final void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("AudioTrace", "tag");
        FLogger.f375446a.e("AudioTrace", r100, r101);
    }

    @Override // m58.v
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i(r100, r101);
    }

    @Override // m58.v
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w(r100, r101);
    }

    @Override // m58.v
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e(r100, r101);
    }
}
