package ky0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;
import com.ss.alog.middleware.ALogService;
import jy0.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements c, jy0.a, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // jy0.a
    public final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogService.iSafely(r100, r101);
    }

    @Override // jy0.a
    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogService.dSafely(r100, r101);
    }

    @Override // jy0.a
    public final void M3(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L5;
        ALogService.eSafely(r100, r101, r102);
        return;
    L5:
        ALogService.eSafely(r100, r101);
    }

    @Override // jy0.a
    public final void d5(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L5;
        ALogService.wSafely(r100, r101, r102);
        return;
    L5:
        ALogService.wSafely(r100, r101);
    }

    @Override // jy0.c
    public final void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        ALogger.stacktrace(r100, r101, r102);
    }
}
