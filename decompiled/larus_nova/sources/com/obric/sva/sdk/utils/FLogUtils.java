package com.obric.sva.sdk.utils;

import com.obric.sva.sdk.logger.SpecialCategory;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/sva/sdk/utils/FLogUtils;", "", "<init>", "()V", "USE_SYSTEM_DEBUG", "", "d", "", "tag", "", "message", BaseSwitches.V, RXScreenCaptureService.KEY_INDEX, "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FLogUtils {
    public static final FLogUtils INSTANCE = null;
    private static final boolean USE_SYSTEM_DEBUG = false;

    private FLogUtils() {
    }

    static {
        INSTANCE = new FLogUtils();
        USE_SYSTEM_DEBUG = true;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        KtUtils.Flogger("d", r100, r101);
    }

    @JvmStatic
    public static final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        KtUtils.Flogger(RXScreenCaptureService.KEY_INDEX, r100, r101);
    }

    @JvmStatic
    public static final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        KtUtils.Flogger(BaseSwitches.V, r100, r101);
    }

    @JvmStatic
    public static final void s(String r100, String r101, SpecialCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "category");
        KtUtils.Flogger("e", r100, r101);
    }
}
