package ew;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements bw.e {
    public i() {
    }

    @Override // bw.e
    public final void E() {
    }

    @Override // bw.e
    public final void F() {
    }

    @Override // bw.e
    public final void X(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    @Override // bw.e
    public final void f0(String r100, dw.e r101) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "permissionCallback");
    }

    @Override // bw.e
    public final boolean o2() {
        return true;
    }

    @Override // bw.e
    public final void orderGame(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
    }

    @Override // bw.e
    public final void t() {
    }

    @Override // bw.e
    public final boolean useGameCPDownloaderConfig() {
        return false;
    }

    @Override // bw.e
    public final void x1() {
    }
}
