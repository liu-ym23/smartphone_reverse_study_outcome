package com.obric.assistant.common.spi.alog;

import android.util.EventsUtils;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096\u0001J\u001f\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000fH\u0096\u0001J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0019\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/common/spi/alog/ObricAlogServiceDelegate;", "Lcom/obric/assistant/common/spi/alog/IObricAlogService;", "<init>", "()V", "flushPluginAlog", XmlPullParser.NO_NAMESPACE, "getAlogFileDir", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "getAlogFileList", "getAlogFilePathByProcessName", "processName", "getResolvedAlogFilePath", "currentPath", "isForbitHighFreqLogs", XmlPullParser.NO_NAMESPACE, "isObricSubProcess", "isObricUploadEnable", "isZeusAlogUploadEnable", "mergeAlogFileList", "alogFiles", "modifyObricConfig", "aLogConfig", XmlPullParser.NO_NAMESPACE, "shouldKeepUploadedAlogFiles", "subListLodFileEnable", "useOpenNewAnrMonitor", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAlogServiceDelegate implements IObricAlogService {
    public static final ObricAlogServiceDelegate b = null;
    public final /* synthetic */ IObricAlogService a;

    static {
        b = new ObricAlogServiceDelegate();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "alogFiles");
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> b() {
        return this.a.b();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final String c(String r2, String r3) {
        return this.a.c(r2, null);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void d() {
        this.a.d();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void e() {
        this.a.e();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean f() {
        return this.a.f();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean g() {
        return this.a.g();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void h(ALogConfig r2) {
        this.a.h(r2);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean i() {
        return this.a.i();
    }

    private ObricAlogServiceDelegate() {
        DefaultObricAlogServiceImpl r0 = (IObricAlogService) ServiceManager.get().getService(IObricAlogService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricAlogServiceImpl();
    L5:
        this.a = r0;
    }
}
