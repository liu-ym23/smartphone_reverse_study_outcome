package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0007H&J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/sva/sdk/logger/ILogger;", "", "isDebug", "", BaseSwitches.V, "", "tag", "", "msg", "d", RXScreenCaptureService.KEY_INDEX, "tr", "", "w", "e", "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "getDirPath", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "flush", "special", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILogger {
    public static final Companion Companion = null;

    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/logger/ILogger$Companion;", "", "<init>", "()V", "LOG_TAG_PREFIX", "", "getLOG_TAG_PREFIX", "()Ljava/lang/String;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final String LOG_TAG_PREFIX = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            LOG_TAG_PREFIX = "SVA-";
        }

        public final String getLOG_TAG_PREFIX() {
            return LOG_TAG_PREFIX;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void special(ILogger r100, String r101, SpecialCategory r102) {
            Intrinsics.checkNotNullParameter(r102, "category");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void uploadAllLog$default(ILogger r100, String r101, Function1 r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.uploadAllLog(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadAllLog");
        }

        public static /* synthetic */ void s$default(ILogger r100, String r101, String r102, SpecialCategory r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = SpecialCategory.WAKEUP_DURATION;
        L6:
            r100.s(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: s");
        }

        public static /* synthetic */ void s$default(ILogger r100, String r101, String r102, Throwable r103, SpecialCategory r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = SpecialCategory.WAKEUP_DURATION;
        L6:
            r100.s(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: s");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void d(String r100, String r101);

    void e(String r100, String r101);

    void e(String r100, String r101, Throwable r102);

    void flush();

    String getDirPath();

    void i(String r100, String r101);

    void i(String r100, String r101, Throwable r102);

    boolean isDebug();

    void s(String r100, String r101, SpecialCategory r102);

    void s(String r100, String r101, Throwable r102, SpecialCategory r103);

    void special(String r100, SpecialCategory r101);

    void uploadAllLog(String r100, Function1<? super Boolean, Unit> r101);

    void v(String r100, String r101);

    void w(String r100, String r101);

    void w(String r100, String r101, Throwable r102);

    void w(String r100, Throwable r101);
}
