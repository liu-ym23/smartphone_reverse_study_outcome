package com.suite.component.logger.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f460105a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460106a = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[LogLevel.VERBOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[LogLevel.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[LogLevel.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[LogLevel.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f460106a = r100;
        }
    }

    public /* synthetic */ g() {
        this(LogcatPrinter$1.INSTANCE);
    }

    @Override // com.suite.component.logger.api.e
    public final boolean isEnable() {
        return this.f460105a.invoke().booleanValue();
    }

    public g(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "isEnable");
        this.f460105a = r100;
    }

    @Override // com.suite.component.logger.api.e
    public final void a(com.suite.component.logger.c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        String r101 = com.suite.component.logger.d.a(r100);
        if (r101 == null) goto L5;
        r100.b(r100.f460117c + " param:" + r101);
    L5:
        int r102 = a.f460106a[r100.f460115a.ordinal()];
    }

    @Override // com.suite.component.logger.api.e
    public final void b(com.suite.component.logger.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
