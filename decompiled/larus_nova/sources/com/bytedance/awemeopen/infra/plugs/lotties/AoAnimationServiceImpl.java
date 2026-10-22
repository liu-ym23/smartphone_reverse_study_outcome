package com.bytedance.awemeopen.infra.plugs.lotties;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/lotties/AoAnimationServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "<init>", "()V", "ao_plugin_lottie_release"}, k = 1, mv = {1, 7, 1})
public final class AoAnimationServiceImpl implements AoAnimationService {
    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final j p0() {
        return new j();
    }

    public AoAnimationServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final boolean f() {
        return r0.c.a.f535397a;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i A2(InputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        return new i(LottieCompositionFactory.fromJsonInputStream(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f D2(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        LottieComposition r102 = LottieCompositionFactory.fromAssetSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i F1(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new i(LottieCompositionFactory.fromRawRes(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i K(ZipInputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        return new i(LottieCompositionFactory.fromZipStream(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f R(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        LottieComposition r102 = LottieCompositionFactory.fromUrlSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i W(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        return new i(LottieCompositionFactory.fromAsset(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i X1(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        return new i(LottieCompositionFactory.fromAsset(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f b2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        LottieComposition r102 = LottieCompositionFactory.fromJsonStringSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f c1(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LottieComposition r102 = LottieCompositionFactory.fromRawResSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final i i1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        return new i(LottieCompositionFactory.fromJsonString(r100, r101));
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f j0(ZipInputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        LottieComposition r102 = LottieCompositionFactory.fromZipStreamSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.AoAnimationService
    public final f w0(InputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "res");
        LottieComposition r102 = LottieCompositionFactory.fromJsonInputStreamSync(r100, r101).f24812a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return new f(r102);
    }
}
