package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusWebOnPageFinishedParams extends BaseAspectParams<k> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f245650d;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new k();
    }

    public ArgusWebOnPageFinishedParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f245648b = r100;
        this.f245650d = LazyKt.lazy(new ArgusWebOnPageFinishedParams$isInnerHost$2(this));
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L5
        this.f245649c = r102.getHost();     // Catch: Throwable -> L5
        r102.getPath();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, MonitorConstants.URL_HOST, this.f245649c);
        JSONUtilsKt.d(r101, "is_inner_host", Boolean.valueOf(((Boolean) this.f245650d.getValue()).booleanValue()));
        JSONUtilsKt.d(r101, "url", this.f245648b);
        return r101;
    }
}
