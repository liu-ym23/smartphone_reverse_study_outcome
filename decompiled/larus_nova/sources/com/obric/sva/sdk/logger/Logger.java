package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\tJ&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/sva/sdk/logger/Logger;", "", "<init>", "()V", "isDebug", "", "getDirPath", "", BaseSwitches.V, "", "tag", "msg", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "flush", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "LogInfo", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Logger {
    public static final Logger INSTANCE = null;

    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/sva/sdk/logger/Logger$LogInfo;", "", "level", "", "tag", "", "message", "th", "", "millis", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;J)V", "getLevel", "()I", "getTag", "()Ljava/lang/String;", "getMessage", "getTh", "()Ljava/lang/Throwable;", "getMillis", "()J", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LogInfo {
        private final int level;
        private final String message;
        private final long millis;
        private final String tag;

        /* JADX INFO: renamed from: th, reason: collision with root package name */
        private final Throwable f403932th;

        public final int getLevel() {
            return this.level;
        }

        public final String getMessage() {
            return this.message;
        }

        public final long getMillis() {
            return this.millis;
        }

        public final String getTag() {
            return this.tag;
        }

        public final Throwable getTh() {
            return this.f403932th;
        }

        public LogInfo(int r100, String r101, String r102, Throwable r103, long r104) {
            Intrinsics.checkNotNullParameter(r101, "tag");
            this.level = r100;
            this.tag = r101;
            this.message = r102;
            this.f403932th = r103;
            this.millis = r104;
        }

        public /* synthetic */ LogInfo(int r100, String r101, String r110, Throwable r111, long r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 16) == 0) goto L5;
            r112 = System.currentTimeMillis();
        L5:
            this(r100, r101, r110, r111, r112);
        }
    }

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    public final void flush() {
    }

    public final void uploadAllLog(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    public final String getDirPath() {
        return ILogDepend.f384986a.getDirPath();
    }

    public final boolean isDebug() {
        return ILogDepend.f384986a.isDebug();
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.i(r100, r101);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.e(r100, r101);
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.i(r100, r101);
    }

    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.i(r100, r101);
    }

    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.w(r100, "", r101);
    }

    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.w(r100, r101);
    }

    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.e(r100, r101, r102);
    }

    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogDepend.f384986a.w(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadAllLog$default(Logger r100, String r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.uploadAllLog(r101, r102);
    }
}
