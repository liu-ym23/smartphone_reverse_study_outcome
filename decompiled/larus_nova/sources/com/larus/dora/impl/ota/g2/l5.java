package com.larus.dora.impl.ota.g2;

import com.larus.common.apphost.AppHost;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class l5 implements o {
    private static final a Companion = null;
    private static final Set<Integer> NETWORK_ERRORS = null;

    public static final class a {
        public a() {
        }
    }

    public l5() {
    }

    static {
        Companion = new a();
        NETWORK_ERRORS = SetsKt.setOf(new Integer[]{1049, 1055, 1013});
    }

    public static final /* synthetic */ a a() {
        return Companion;
    }

    public static final /* synthetic */ Set d() {
        return NETWORK_ERRORS;
    }

    @Override // com.larus.dora.impl.ota.g2.o
    public final void b(int r100) {
        Downloader.getInstance(AppHost.f326268a.getApplication()).cancel(r100, true);
    }

    @Override // com.larus.dora.impl.ota.g2.o
    public final void pause(int r100) {
        Downloader.getInstance(AppHost.f326268a.getApplication()).pause(r100);
    }

    @Override // com.larus.dora.impl.ota.g2.o
    public final int c(e5 r100, k4.b r110, boolean r111, AndroidG2OtaRuntime$startLocked$1 r112) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r112, "callback");
        AppHost.Companion r101 = AppHost.f326268a;
        Downloader.getInstance(r101.getApplication());
        if (r110.b() != 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        DownloadTask r103 = Downloader.with(r101.getApplication()).url(r100.i());
        List<String> r104 = r100.b();
        if (r104.isEmpty() == false) goto L18;
        String r105 = r100.a();
        if ((!StringsKt.isBlank(r105)) == true) goto L16;
        r105 = null;
    L16:
        r104 = CollectionsKt.listOfNotNull(r105);
    L18:
        return r103.backUpUrls(r104).name(r110.c()).savePath(r110.a()).onlyWifi(r111).retryCount(3).backUpUrlRetryCount(3).force(false).mainThreadListener(new m5(r112)).download();
    L20:
        throw new IllegalStateException("Downloader cache is not ready".toString());
    L5:
        if (DownloadComponentManager.getDownloadCache().ensureDownloadCacheSyncSuccess() == true) goto L8;
        r102 = false;
        goto L9
    }
}
