package com.obric.assistant.common.spi.alog;

import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096\u0001J\u001f\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000fH\u0096\u0001J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/common/spi/alog/ObricAlogServiceDelegate;", "Lcom/obric/assistant/common/spi/alog/IObricAlogService;", "<init>", "()V", "flushPluginAlog", "", "getAlogFileDir", "", "", "getAlogFileList", "getAlogFilePathByProcessName", "processName", "getResolvedAlogFilePath", "currentPath", "isForbitHighFreqLogs", "", "isObricSubProcess", "isObricUploadEnable", "isZeusAlogUploadEnable", "mergeAlogFileList", "alogFiles", "modifyObricConfig", "aLogConfig", "", "shouldKeepUploadedAlogFiles", "subListLodFileEnable", "useOpenNewAnrMonitor", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAlogServiceDelegate implements IObricAlogService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAlogServiceDelegate f387841b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAlogService f387842a;

    static {
        f387841b = new ObricAlogServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "alogFiles");
        return this.f387842a.a(r100);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> b() {
        return this.f387842a.b();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final String c(String r100, String r101) {
        return this.f387842a.c(r100, null);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void d() {
        this.f387842a.d();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void e() {
        this.f387842a.e();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean f() {
        return this.f387842a.f();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean g() {
        return this.f387842a.g();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void h(ALogConfig r100) {
        this.f387842a.h(r100);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean i() {
        return this.f387842a.i();
    }

    private ObricAlogServiceDelegate() {
        IObricAlogService r100 = (IObricAlogService) ServiceManager.get().getService(IObricAlogService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricAlogServiceImpl();
    L5:
        this.f387842a = r100;
    }
}
