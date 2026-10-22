package com.larus.uaigc.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/uaigc/service/ICreationReportService;", "", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationReportService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373922a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/larus/uaigc/service/ICreationReportService$Companion;", "Lcom/larus/uaigc/service/ICreationReportService;", "<init>", "()V", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationReportService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373923c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationReportService f373924b;

        static {
            f373923c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationReportService
        public final hy9.d j() {
            return this.f373924b.j();
        }

        private Companion() {
            ICreationReportService r100 = (ICreationReportService) ServiceManager.get().getService(ICreationReportService.class);
            if (r100 != null) goto L5;
            r100 = new ICreationReportServiceNoop();
        L5:
            this.f373924b = r100;
        }
    }

    static {
        f373922a = Companion.f373923c;
    }

    hy9.d j();
}
