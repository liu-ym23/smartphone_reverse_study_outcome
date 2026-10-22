package com.bytedance.bdp.appbase.base.bdptask;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/BdpTaskError;", "Ljava/lang/Error;", "Lkotlin/Error;", "trace", "", PlayerResolution.SDKKEY.ORIGIN, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "toString", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class BdpTaskError extends Error {
    public final Throwable origin;
    public final String trace;

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = this.origin.getClass().getName();
        String r101 = getLocalizedMessage();
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 + ": " + r101;
    }

    public BdpTaskError(String r100, Throwable r101) {
        super(Intrinsics.stringPlus(r101.getMessage(), r100), r101.getCause());
        this.trace = r100;
        this.origin = r101;
        setStackTrace(r101.getStackTrace());
    }
}
