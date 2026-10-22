package com.edu.onetex.utils;

import com.edu.onetex.latex.LaTeXEngine;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Deprecated(message = "使用IParseLogger")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/edu/onetex/utils/LaTeXLogger;", "Lcom/edu/onetex/utils/ILogger;", "()V", "customLogger", "getCustomLogger", "()Lcom/edu/onetex/utils/ILogger;", "setCustomLogger", "(Lcom/edu/onetex/utils/ILogger;)V", "d", "", "tag", "", "msg", "e", RXScreenCaptureService.KEY_INDEX, "w", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class LaTeXLogger implements ILogger {
    public static final LaTeXLogger INSTANCE = null;
    private static ILogger customLogger;

    private LaTeXLogger() {
    }

    static {
        INSTANCE = new LaTeXLogger();
    }

    public final ILogger getCustomLogger() {
        return customLogger;
    }

    public final void setCustomLogger(ILogger r100) {
        customLogger = r100;
    }

    @Override // com.edu.onetex.utils.ILogger
    public void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode() == true) goto L5;
        return;
    L5:
        ILogger r102 = customLogger;
        if (r102 == null) goto L10;
        if (r102 == null) goto L11;
        r102.d(r100, r101);
        return;
    L11:
        return;
    }

    @Override // com.edu.onetex.utils.ILogger
    public void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode() == true) goto L5;
        return;
    L5:
        ILogger r102 = customLogger;
        if (r102 == null) goto L10;
        if (r102 == null) goto L11;
        r102.e(r100, r101);
        return;
    L11:
        return;
    }

    @Override // com.edu.onetex.utils.ILogger
    public void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode() == true) goto L5;
        return;
    L5:
        ILogger r102 = customLogger;
        if (r102 == null) goto L10;
        if (r102 == null) goto L11;
        r102.i(r100, r101);
        return;
    L11:
        return;
    }

    @Override // com.edu.onetex.utils.ILogger
    public void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode() == true) goto L5;
        return;
    L5:
        ILogger r102 = customLogger;
        if (r102 == null) goto L10;
        if (r102 == null) goto L11;
        r102.w(r100, r101);
        return;
    L11:
        return;
    }
}
