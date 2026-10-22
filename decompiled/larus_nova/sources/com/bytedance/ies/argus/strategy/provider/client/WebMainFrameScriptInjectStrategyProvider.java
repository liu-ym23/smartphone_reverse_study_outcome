package com.bytedance.ies.argus.strategy.provider.client;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.c0;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusShouldInterceptResponseVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import t06.b0;

/* JADX INFO: loaded from: classes19.dex */
public final class WebMainFrameScriptInjectStrategyProvider extends u06.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246204a = 0;

    public static final class a {
    }

    static {
    }

    public WebMainFrameScriptInjectStrategyProvider() {
    }

    @Override // u06.a
    public final ArgusStrategyProviderType b() {
        return ArgusStrategyProviderType.WebMainFrameScriptInject;
    }

    @Override // u06.a
    public final void a(AspectConfigItem.a r100, t06.d r101, AspectContext<? extends BaseAspectParams<?>, ? extends com.bytedance.ies.argus.strategy.a>.a r102) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        AspectContext<PARAMS, REWRITE_PAYLOAD> r103 = r102.f246005d;
        PARAMS r104 = r103.f245987b;
        com.bytedance.ies.argus.bean.i<REWRITE_PAYLOAD> r105 = r102.f246003b;
        REWRITE_PAYLOAD r106 = r105.f246032c;
        com.bytedance.ies.argus.aspect.eventCenter.b<?> r107 = r103.f245994i;
        if (r101 == null) goto L5;
        b0 r108 = r101.t();
    L7:
        if ((r104 instanceof com.bytedance.ies.argus.api.params.b0) == true) goto L9;
    L24:
        com.bytedance.ies.argus.bean.i.g(r105, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, 6);
        return;
    L9:
        if ((r106 instanceof c0) == false) goto L24;
        if ((r107 instanceof com.bytedance.ies.argus.aspect.eventCenter.i) == false) goto L24;
        if (r108 != null) goto L16;
        com.bytedance.ies.argus.bean.i.g(r105, ArgusShouldInterceptResponseVerifyReason.STRATEGY_CONFIG_IS_NULL, null, 6);
        return;
    L16:
        WebResourceResponse r109 = ((c0) r106).f245730b;
        if (r109 != null) goto L19;
        ((com.bytedance.ies.argus.api.params.b0) r104).getClass();
        r109 = null;
    L19:
        if (r109 != null) goto L22;
        com.bytedance.ies.argus.bean.i.i(r105, ArgusShouldInterceptResponseVerifyReason.RESPONSE_IS_NULL_WHEN_INJECT_SCRIPT, null, 6);
        return;
    L22:
        ((com.bytedance.ies.argus.api.params.b0) r104).getClass();
        throw null;
    L5:
        r108 = null;
        goto L7
    }

    public final WebResourceResponse c(WebResourceResponse r110, List<t06.i> r111, Pair<String, String> r112) {
        String r113 = "<!DOCTYPE html>" + CollectionsKt.joinToString$default(r111, "\n", null, null, 0, null, new WebMainFrameScriptInjectStrategyProvider$getScriptsText$1(this), 30, null);
        String r100 = r110.getMimeType();
        String r101 = r110.getEncoding();
        Charset r102 = Charsets.UTF_8;
        if (r113 == null) goto L14;
        WebResourceResponse r103 = new WebResourceResponse(r100, r101, new SequenceInputStream(new ByteArrayInputStream(r113.getBytes(r102)), r110.getData()));
        Map<String, String> r114 = r110.getResponseHeaders();
        if (r112 == null) goto L7;
        r114.put(r112.getFirst(), r112.getSecond());
    L7:
        r103.setResponseHeaders(r114);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L10
        r103.setStatusCodeAndReasonPhrase(r110.getStatusCode(), r110.getReasonPhrase());     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        return r103;
    L10:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
