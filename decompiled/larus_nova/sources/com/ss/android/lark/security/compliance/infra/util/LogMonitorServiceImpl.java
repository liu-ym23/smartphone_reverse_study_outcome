package com.ss.android.lark.security.compliance.infra.util;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@RemoteServiceImpl(service = ILogMonitorService.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/util/LogMonitorServiceImpl;", "Lcom/ss/android/lark/security/compliance/infra/util/ILogMonitorService;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "traceId", "", "getTraceId", "()Ljava/lang/String;", RemoteMessageConst.MSGID, "", "getMsgId", "()I", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogMonitorServiceImpl implements ILogMonitorService {
    private final Context mContext;

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public int getMsgId() {
        return g.f440481a.incrementAndGet();
    }

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public String getTraceId() {
        return u4c.a.f548750a;
    }

    public LogMonitorServiceImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.mContext = r100;
    }
}
