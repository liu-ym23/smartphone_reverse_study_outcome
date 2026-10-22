package com.ss.android.ugc.aweme.framework.services.dyext.utils;

import com.bytedance.ies.ugc.appcontext.AppContextManager;
import com.ss.android.agilelogger.ALog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/utils/SpiExtLogger;", "", "()V", "LOCAL_TEST", "", "TAG", "d", "", "label", "string", "isUpload", "", "e", RXScreenCaptureService.KEY_INDEX, "isLocalTest", BaseSwitches.V, "w", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class SpiExtLogger {
    public static final SpiExtLogger INSTANCE = null;
    private static final String LOCAL_TEST = "local_test";
    private static final String TAG = "spi-ext";

    private SpiExtLogger() {
    }

    static {
        INSTANCE = new SpiExtLogger();
    }

    public final boolean isLocalTest() {
        Lazy r100 = AppContextManager.f248843a;
        if (Intrinsics.areEqual("local_test", AppContextManager.f248844b) == false) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(String r100, String r101, boolean r102) {
        if (isLocalTest() == true) goto L8;
        if (r102 == false) goto L9;
        ALog.d(TAG, "[" + r100 + "] " + r101);
        return;
    L9:
        return;
    }

    public final void e(String r100, String r101, boolean r102) {
        if (isLocalTest() == true) goto L8;
        if (r102 == false) goto L9;
        ALog.e(TAG, "[" + r100 + "] " + r101);
        return;
    L9:
        return;
    }

    public final void i(String r100, String r101, boolean r102) {
        if (isLocalTest() == true) goto L8;
        if (r102 == false) goto L9;
        ALog.i(TAG, "[" + r100 + "] " + r101);
        return;
    L9:
        return;
    }

    public final void v(String r100, String r101, boolean r102) {
        if (isLocalTest() == true) goto L8;
        if (r102 == false) goto L9;
        ALog.v(TAG, "[" + r100 + "] " + r101);
        return;
    L9:
        return;
    }

    public final void w(String r100, String r101, boolean r102) {
        if (isLocalTest() == true) goto L8;
        if (r102 == false) goto L9;
        ALog.w(TAG, "[" + r100 + "] " + r101);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void d$default(SpiExtLogger r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.d(r101, r102, r103);
    }

    public static /* synthetic */ void e$default(SpiExtLogger r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.e(r101, r102, r103);
    }

    public static /* synthetic */ void i$default(SpiExtLogger r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.i(r101, r102, r103);
    }

    public static /* synthetic */ void v$default(SpiExtLogger r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.v(r101, r102, r103);
    }

    public static /* synthetic */ void w$default(SpiExtLogger r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.w(r101, r102, r103);
    }
}
