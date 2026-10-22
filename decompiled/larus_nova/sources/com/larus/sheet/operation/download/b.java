package com.larus.sheet.operation.download;

import android.content.Context;
import android.net.Uri;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class b implements Function5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f369085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function4 f369086b;

    public /* synthetic */ b(Context r100, Function4 r101) {
        this.f369085a = r100;
        this.f369086b = r101;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104) {
        Context r105 = this.f369085a;
        Function4 r106 = this.f369086b;
        Uri r107 = (Uri) r101;
        Throwable r108 = (Throwable) r102;
        Integer r109 = (Integer) r103;
        String r110 = (String) r104;
        String r111 = "";
        if (((Boolean) r100).booleanValue() == false) goto L27;
        if (r107 == null) goto L11;
        String r112 = com.larus.office.base.utils.b.c(r105, r107);
        if (r112 != null) goto L9;
        r112 = r107.toString();
    L9:
        r111 = r112;
    L11:
        if (StringsKt.isBlank(r111) == false) goto L33;
    L26:
        r106.invoke(Boolean.TRUE, null, r109, r111);
    L31:
        d.f369092a = false;
        return Unit.INSTANCE;
    L33:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L21
        IFlowSdkDepend r114 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L21
        if (r114 == null) goto L18;
        r114.D0();     // Catch: Throwable -> L21
        boolean r115 = b1.f346144a.b(r111);     // Catch: Throwable -> L21
        FLogger.f375446a.i("SheetDownloader", "[runMetadataCheck] success=" + r115 + ", path=" + r111);     // Catch: Throwable -> L21
        Object r116 = Boolean.valueOf(r115);     // Catch: Throwable -> L21
    L19:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L21
    L23:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L26;
        FLogger.f375446a.e("SheetDownloader", "[runMetadataCheck] failed, path=" + r111, r118);
        goto L26
    L18:
        FLogger.f375446a.i("SheetDownloader", "[runMetadataCheck] metadata check service is null, path=" + r111);     // Catch: Throwable -> L21
        r116 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L27:
        Boolean r120 = Boolean.FALSE;
        if (r110 != null) goto L30;
        r110 = "";
    L30:
        r106.invoke(r120, r108, r109, r110);
        goto L31
    }
}
