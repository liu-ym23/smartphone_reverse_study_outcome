package com.bytedance.geckox.logger;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import sy5.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/logger/DefaultLogger;", "Lcom/bytedance/geckox/logger/Logger;", "()V", "d", "", "tag", "", "msg", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "tr", "", "w", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class DefaultLogger implements Logger {
    public DefaultLogger() {
    }

    @Override // com.bytedance.geckox.logger.Logger
    public void w(String r100, String r101, Throwable r102) {
    }

    @Override // com.bytedance.geckox.logger.Logger
    public void d(String r100, Object... r101) {
        if (r101.length != 1) goto L11;
        Object r102 = r101[0];     // Catch: Throwable -> L13
        if ((r102 instanceof String) == false) goto L11;
        if (r102 == null) goto L10;
        ALog.i(r100, (String) r102);     // Catch: Throwable -> L13
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L13
    L11:
        b r103 = b.f543888b;     // Catch: Throwable -> L13
        ALog.i(r100, b.f543888b.f543890a.toJson(r101));     // Catch: Throwable -> L13
        return;
    L14:
        if (r101.length != 1) goto L21;
        Object r104 = r101[0];
        if ((r104 instanceof String) == false) goto L21;
        if (r104 == null) goto L20;
        String r105 = (String) r104;
        return;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L21:
        b r106 = b.f543888b;
        GsonProtectorUtils.toJson(b.f543888b.f543890a, r101);
    }

    @Override // com.bytedance.geckox.logger.Logger
    public void w(String r100, String r101) {
        ALog.w(r100, r101);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.geckox.logger.Logger
    public void e(String r100, String r101, Throwable r102) {
        ALog.e(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    }
}
