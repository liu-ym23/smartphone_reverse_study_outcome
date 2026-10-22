package com.bytedance.awemeopen.infra.plugs.alog;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/alog/AoLogServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/log/AoLogService;", "<init>", "()V", "ao_plugin_alog_release"}, k = 1, mv = {1, 7, 1})
public final class AoLogServiceImpl implements AoLogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f198809a;

    @Override // com.bytedance.awemeopen.servicesapi.log.AoLogService
    public final void g2() {
    }

    public AoLogServiceImpl() {
        this.f198809a = true;
    }

    @Override // com.bytedance.awemeopen.servicesapi.log.AoLogService
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "messages");
        if (this.f198809a == false) goto L6;
        ALog.d(r100, r101);
        return;
    }

    @Override // com.bytedance.awemeopen.servicesapi.log.AoLogService
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "messages");
        if (this.f198809a == false) goto L6;
        ALog.e(r100, r101);
        return;
    }

    @Override // com.bytedance.awemeopen.servicesapi.log.AoLogService
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "messages");
        if (this.f198809a == false) goto L6;
        ALog.i(r100, r101);
        return;
    }

    @Override // com.bytedance.awemeopen.servicesapi.log.AoLogService
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "messages");
        if (this.f198809a == false) goto L6;
        ALog.w(r100, r101);
        return;
    }
}
