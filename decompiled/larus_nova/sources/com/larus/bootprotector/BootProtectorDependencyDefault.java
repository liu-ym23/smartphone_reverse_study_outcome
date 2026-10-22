package com.larus.bootprotector;

import android.content.Context;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/larus/bootprotector/BootProtectorDependencyDefault;", "Lcom/larus/bootprotector/BootProtectorDependency;", "<init>", "()V", "initBootProtectorLandingPageDependency", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "", "()Z", "uid", "", "getUid", "()Ljava/lang/String;", a.KEY_DID, "getDid", "exeUrgentCmdTask", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorDependencyDefault implements BootProtectorDependency {
    public BootProtectorDependencyDefault() {
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final void b() {
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final String getDid() {
        return "";
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final String getUid() {
        return "";
    }

    @Override // com.larus.bootprotector.BootProtectorDependency
    public final boolean isDebug() {
        return true;
    }
}
