package com.obric.sva.framework.log;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008a\u0001\u0010\f\u001a\u00020\u00072\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0007H\u0007J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0007R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/framework/log/AiagentLog;", "", "<init>", "()V", "debug", "Lkotlin/Function2;", "", "", "warn", "verbose", "error", "info", "init", BaseSwitches.V, "d", RXScreenCaptureService.KEY_INDEX, "w", "e", BasicTestActionHandler.TEST_ACTION_RESET, "tag", "msg", "api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiagentLog {
    public static final AiagentLog INSTANCE = null;
    private static Function2<? super String, ? super String, Unit> debug;
    private static Function2<? super String, ? super String, Unit> error;
    private static Function2<? super String, ? super String, Unit> info;
    private static Function2<? super String, ? super String, Unit> verbose;
    private static Function2<? super String, ? super String, Unit> warn;

    static {
        INSTANCE = new AiagentLog();
    }

    private AiagentLog() {
    }

    @JvmStatic
    public static final void reset() {
        verbose = null;
        debug = null;
        info = null;
        warn = null;
        error = null;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = debug;
        if (r102 == null) goto L6;
        r102.invoke("SVA-" + r100, r101);
        return;
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = error;
        if (r102 == null) goto L6;
        r102.invoke("SVA-" + r100, r101);
        return;
    }

    @JvmStatic
    public static final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = info;
        if (r102 == null) goto L6;
        r102.invoke("SVA-" + r100, r101);
        return;
    }

    @JvmStatic
    public static final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = verbose;
        if (r102 == null) goto L6;
        r102.invoke("SVA-" + r100, r101);
        return;
    }

    @JvmStatic
    public static final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function2<? super String, ? super String, Unit> r102 = warn;
        if (r102 == null) goto L6;
        r102.invoke("SVA-" + r100, r101);
        return;
    }

    @JvmStatic
    public static final void init(Function2<? super String, ? super String, Unit> r100, Function2<? super String, ? super String, Unit> r101, Function2<? super String, ? super String, Unit> r102, Function2<? super String, ? super String, Unit> r103, Function2<? super String, ? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "d");
        Intrinsics.checkNotNullParameter(r102, RXScreenCaptureService.KEY_INDEX);
        Intrinsics.checkNotNullParameter(r103, "w");
        Intrinsics.checkNotNullParameter(r104, "e");
        verbose = r100;
        debug = r101;
        info = r102;
        warn = r103;
        error = r104;
    }
}
