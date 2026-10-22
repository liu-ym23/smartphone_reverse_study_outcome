package com.bytedance.locallife.host;

import com.bytedance.android.life.service.annotation.ReturnSubService;
import kotlin.Metadata;
import ut6.a;
import ut6.b;
import ut6.c;
import ut6.d;
import ut6.e;
import ut6.f;
import ut6.g;
import ut6.h;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\t\u001a\u00020\bH'J\b\u0010\u000b\u001a\u00020\nH'J\b\u0010\r\u001a\u00020\fH'J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/host/ILifeHostPerfService;", "", "Lut6/h;", "getScanPerformanceMonitorService", "Lut6/e;", "getLifePerformanceService", "Lut6/a;", "getLifeCacheOptService", "Lut6/c;", "getLifeJatoOptService", "Lut6/d;", "getLifeLynxOptService", "Lut6/f;", "getLifeTempoOptService", "Lut6/g;", "getLifeECRService", "Lut6/b;", "getLifeGenericPerfService", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public interface ILifeHostPerfService {
    @ReturnSubService
    /* JADX INFO: renamed from: getLifeCacheOptService */
    a mo8489getLifeCacheOptService();

    @ReturnSubService
    g getLifeECRService();

    @ReturnSubService
    b getLifeGenericPerfService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeJatoOptService */
    c mo8490getLifeJatoOptService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeLynxOptService */
    d mo8491getLifeLynxOptService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifePerformanceService */
    e mo8492getLifePerformanceService();

    @ReturnSubService
    /* JADX INFO: renamed from: getLifeTempoOptService */
    f mo8493getLifeTempoOptService();

    @ReturnSubService
    h getScanPerformanceMonitorService();
}
