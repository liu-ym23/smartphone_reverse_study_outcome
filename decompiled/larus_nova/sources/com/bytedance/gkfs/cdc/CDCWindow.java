package com.bytedance.gkfs.cdc;

import android.app.Application;
import com.bytedance.gkfs.GeckoFileSystem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0003\u001a\u00020\u0002H\u0082 J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082 J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¨\u0006\r"}, d2 = {"Lcom/bytedance/gkfs/cdc/CDCWindow;", "", "", "nCreate", "wPtr", "", "b", "nSlide8", "", "nReset", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class CDCWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245130a;

    public static final class a {
    }

    private final native long nCreate();

    private final native void nReset(long r100);

    private final native long nSlide8(long r100, byte r101);

    public final long b() {
        return ((Number) this.f245130a.getValue()).longValue();
    }

    static {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        String[] r101 = GeckoFileSystem.f245101a;     // Catch: Throwable -> L8
        Application r102 = GeckoFileSystem.f245104d;     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L8
    L6:
        com.bytedance.librarian.a.e("gkfs", true, r102);     // Catch: Throwable -> L8
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public CDCWindow() {
        this.f245130a = LazyKt.lazy(new CDCWindow$nWindow$2(this));
    }

    public final void c() {
        if (b() == 0) goto L7;
        nReset(b());
        return;
    L7:
        throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
    }

    public static final /* synthetic */ long a(CDCWindow r100) {
        return r100.nCreate();
    }

    public final long d(byte r100) {
        if (b() == 0) goto L7;
        return nSlide8(b(), r100);
    L7:
        throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
    }
}
