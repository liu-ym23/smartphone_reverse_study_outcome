package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class n implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f372373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f372374b;

    public n(AtomicBoolean r100, String r101) {
        this.f372373a = r100;
        this.f372374b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f372373a.set(true);
        FLogger.f375446a.i("CreationMessageStrategy", "submitLocalImageResourceAccess cancelled, curUploaderIdentifier:" + this.f372374b);
        ICreationResourceAccessService.a.a(ICreationResourceAccessService.f373925a, this.f372374b);
        return Unit.INSTANCE;
    }
}
