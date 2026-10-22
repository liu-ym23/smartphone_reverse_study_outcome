package com.larus.ivykit.forest;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx7.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000fH\u0016J*\u0010\u0013\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/ivykit/forest/ObricGeckoResourceService;", "Lcom/larus/ivykit/forest/IObricForestService;", "<init>", "()V", "tag", "", "resourceLoader", "Lcom/larus/ivykit/forest/ObricGeckoAppConfigResourceLoader;", "loadAsync", "", "bundleOrUrl", "channel", "onlyLocal", "", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "filePath", "loadSync", "waitGeckoUpdate", "getLoader", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricGeckoResourceService implements IObricForestService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f351636b;

    public ObricGeckoResourceService() {
        this.f351635a = "ObricGeckoResourceSvc";
    }

    @Override // com.larus.ivykit.forest.IObricForestService
    public final String a(String r100, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter("com_flow_obric", "channel");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return "";
    L12:
        e r102 = this.f351636b;
        String r103 = null;
        if (r102 != null) goto L27;
        GeckoGlobalConfig.ENVType r104 = GeckoGlobalConfig.ENVType.PROD;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        r104 = h.a();     // Catch: Throwable -> L18
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
        FLogger.f375446a.i(this.f351635a, "GeckoSetting.getGeckoEnv() fail");
    L24:
        if (StringsKt.isBlank(pg9.h.f529218a.a(r104)) == false) goto L26;
        FLogger.f375446a.i(this.f351635a, "skip create loader because accessKey is blank for env=" + r104);
        r102 = null;
        goto L27
    L26:
        e r107 = new e(r104);
        this.f351636b = r107;
        r102 = r107;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        if (r102 == null) goto L29;
        r103 = r102.c(r100, "com_flow_obric", r110, r111);
    L29:
        if (r103 != null) goto L32;
        return "";
    L32:
        return r103;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }
}
