package com.obric.sva.sdk.utils;

import com.obric.sva.framework.log.AiagentLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/utils/SvaFramework;", "", "<init>", "()V", "init", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaFramework {
    public static final SvaFramework INSTANCE = null;

    static {
        INSTANCE = new SvaFramework();
    }

    private SvaFramework() {
    }

    public static /* synthetic */ Unit a(String r100, String r101) {
        return init$lambda$0(r100, r101);
    }

    public static /* synthetic */ Unit b(String r100, String r101) {
        return init$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit c(String r100, String r101) {
        return init$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit d(String r100, String r101) {
        return init$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit e(String r100, String r101) {
        return init$lambda$4(r100, r101);
    }

    public final void init() {
        AiagentLog.init(new c(), new d(), new e(), new f(), new g());
    }

    private static final Unit init$lambda$0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "m");
        LogUtils.v(r100, r101, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "m");
        LogUtils.d(r100, r101, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "m");
        LogUtils.i(r100, r101, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$3(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "m");
        LogUtils.w(r100, r101, new Object[0]);
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$4(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "m");
        LogUtils.e(r100, r101, new Object[0]);
        return Unit.INSTANCE;
    }
}
