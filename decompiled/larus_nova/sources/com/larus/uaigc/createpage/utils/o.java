package com.larus.uaigc.createpage.utils;

import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f372715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f372716b;

    public o(AtomicBoolean r100, String r101) {
        this.f372715a = r100;
        this.f372716b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f372715a.set(true);
        FLogger.f375446a.i("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess cancelled, curUploaderIdentifier:" + this.f372716b);
        ICreationResourceAccessService.a.a(ICreationResourceAccessService.f373925a, this.f372716b);
        return Unit.INSTANCE;
    }
}
