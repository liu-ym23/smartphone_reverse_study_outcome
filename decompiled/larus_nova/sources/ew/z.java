package ew;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z implements bw.r {
    public z() {
    }

    @Override // bw.r
    public final boolean handle(Context r100, Uri r101) {
        return false;
    }

    @Override // bw.r
    public final boolean handle(Context r100, String r101) {
        return false;
    }

    @Override // bw.r
    public final boolean handleWithCallback(Context r100, Uri r101, DialogInterface.OnDismissListener r102) {
        return false;
    }

    @Override // bw.r
    public final void openExternalBrowser(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "gameId");
    }
}
