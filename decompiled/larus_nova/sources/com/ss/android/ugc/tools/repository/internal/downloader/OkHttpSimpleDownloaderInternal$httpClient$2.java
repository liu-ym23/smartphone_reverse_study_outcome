package com.ss.android.ugc.tools.repository.internal.downloader;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class OkHttpSimpleDownloaderInternal$httpClient$2 extends Lambda implements Function0<OkHttpClient> {
    public static final OkHttpSimpleDownloaderInternal$httpClient$2 INSTANCE = null;

    static {
        INSTANCE = new OkHttpSimpleDownloaderInternal$httpClient$2();
    }

    public OkHttpSimpleDownloaderInternal$httpClient$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OkHttpClient invoke2() {
        return new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(15, TimeUnit.SECONDS).build();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ OkHttpClient invoke() {
        return invoke2();
    }
}
