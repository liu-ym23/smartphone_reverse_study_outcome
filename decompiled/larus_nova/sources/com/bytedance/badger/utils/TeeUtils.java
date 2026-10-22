package com.bytedance.badger.utils;

import android.content.Context;
import com.bytedance.bd_sec_tee.core.model.TeeResult;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/badger/utils/TeeUtils;", "", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "", "hmacSign", "([B[B)Z", "<init>", "()V", "badger-core_release"}, k = 1, mv = {1, 1, 15})
public final class TeeUtils {
    public static final TeeUtils INSTANCE = null;

    static {
        INSTANCE = new TeeUtils();
    }

    public TeeUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean hmacSign(byte[] r100, byte[] r101) {
        if (r101.length == 32) goto L30;
        return false;
    L30:
        Context r102 = AppContextBridge.get();     // Catch: Throwable -> L25
        if (a0.f199214b == null) goto L8;
    L17:
        TeeResult r103 = a0.f199214b.f199215a.j(r100);     // Catch: Throwable -> L25
        if (r103.f199579c == 0) goto L20;
    L23:
        com.bytedance.badger.e.g("TeeUtils", "hmacSign failed error=" + r103.f199579c + ',' + r103.f199580d);     // Catch: Throwable -> L25
        return false;
    L20:
        if (r103.f199583g != TeeResult.ResultType.SECRET_DERIVE_SUCCESS) goto L23;
        byte[] r104 = (byte[]) r103.f199578b;     // Catch: Throwable -> L25
        System.arraycopy(r104, 0, r101, 0, r104.length);     // Catch: Throwable -> L25
        return true;
    L8:
        monitor-enter(a0.class);     // Catch: Throwable -> L25
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L10:
        if (a0.f199214b != null) goto L12;
        a0.f199214b = new a0(r102);     // Catch: Throwable -> L14
    L12:
        monitor-exit(a0.class);     // Catch: Throwable -> L14
    L25:
        th = move-exception;
        com.bytedance.badger.e.c("TeeUtils", "hmacSign failed", th);
        return false;
    }
}
