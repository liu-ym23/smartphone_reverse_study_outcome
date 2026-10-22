package com.larus.im.internal.jni.logger;

import com.larus.im.internal.delegate.a;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/logger/OmniLinkLogger;", "", "<init>", "()V", "d", "", "tag", "", "msg", RXScreenCaptureService.KEY_INDEX, "w", "e", LynxError.LYNX_THROWABLE, "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniLinkLogger {
    public static final OmniLinkLogger INSTANCE = null;

    static {
        INSTANCE = new OmniLinkLogger();
    }

    private OmniLinkLogger() {
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a r102 = a.f348188b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.d(r100, r101);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a r102 = a.f348188b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.e(r100, r101);
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a r102 = a.f348188b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.i(r100, r101);
    }

    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a r102 = a.f348188b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.w(r100, r101);
    }

    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        a r103 = a.f348188b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.e(r100, r101, r102);
    }
}
