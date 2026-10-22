package com.larus.slides.operation.download;

import android.content.Context;
import android.net.Uri;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class a implements Function4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f369714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f369715b;

    public /* synthetic */ a(Context r100, Function3 r101) {
        this.f369714a = r100;
        this.f369715b = r101;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r100, Object r101, Object r102, Object r103) {
        Context r104 = this.f369714a;
        Function3 r105 = this.f369715b;
        Uri r106 = (Uri) r101;
        Integer r107 = (Integer) r102;
        String r108 = (String) r103;
        String r109 = "";
        if (((Boolean) r100).booleanValue() == false) goto L27;
        if (r106 == null) goto L11;
        String r110 = com.larus.office.base.utils.b.c(r104, r106);
        if (r110 != null) goto L9;
        r110 = r106.toString();
    L9:
        r109 = r110;
    L11:
        if (StringsKt.isBlank(r109) == false) goto L33;
    L26:
        r105.invoke(Boolean.TRUE, r107, r109);
    L31:
        c.f369721a = false;
        return Unit.INSTANCE;
    L33:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L21
        IFlowSdkDepend r112 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L21
        if (r112 == null) goto L18;
        r112.D0();     // Catch: Throwable -> L21
        boolean r113 = b1.f346144a.b(r109);     // Catch: Throwable -> L21
        FLogger.f375446a.i("SlidesDownloader", "[runMetadataCheck] success=" + r113 + ", path=" + r109);     // Catch: Throwable -> L21
        Object r114 = Boolean.valueOf(r113);     // Catch: Throwable -> L21
    L19:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L21
    L23:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L26;
        FLogger.f375446a.e("SlidesDownloader", "[runMetadataCheck] failed, path=" + r109, r116);
        goto L26
    L18:
        FLogger.f375446a.i("SlidesDownloader", "[runMetadataCheck] metadata check service is null, path=" + r109);     // Catch: Throwable -> L21
        r114 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L27:
        Boolean r118 = Boolean.FALSE;
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        r105.invoke(r118, r107, r108);
        goto L31
    }
}
