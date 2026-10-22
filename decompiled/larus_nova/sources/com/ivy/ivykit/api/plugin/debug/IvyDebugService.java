package com.ivy.ivykit.api.plugin.debug;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&J+\u0010\u0012\u001a\u00020\b2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\b0\u0014H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0003H&J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0003H&¨\u0006\u001e"}, d2 = {"Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService;", "", "handleSchema", "", "schema", "", "isEnable", "log", "", "level", "Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$LogLevel;", "type", "tag", "msg", "extra", "openInstancePanel", "lynxView", "Landroid/view/View;", "registerScanCallback", "scanCallback", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", PerfLog.PARAM_KEY_CONTEXT_ID, "setEnable", "enable", "switchDevTool", "Companion", "LogLevel", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IvyDebugService {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$Companion;", "Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IvyDebugService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f278359a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IvyDebugService> f278360b = null;

        private Companion() {
        }

        static {
            f278359a = new Companion();
            f278360b = LazyKt.lazy(IvyDebugService$Companion$impl$2.INSTANCE);
        }

        public static IvyDebugService a() {
            return f278360b.getValue();
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final boolean isEnable() {
            IvyDebugService r100 = a();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isEnable();
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final boolean handleSchema(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            IvyDebugService r101 = a();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.handleSchema(r100);
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final void openInstancePanel(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            IvyDebugService r101 = a();
            if (r101 == null) goto L6;
            r101.openInstancePanel(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final void registerScanCallback(Function1<? super Context, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "scanCallback");
            IvyDebugService r101 = a();
            if (r101 == null) goto L6;
            r101.registerScanCallback(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final void setEnable(boolean r100) {
            IvyDebugService r101 = a();
            if (r101 == null) goto L6;
            r101.setEnable(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final void switchDevTool(Context r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IvyDebugService r102 = a();
            if (r102 == null) goto L6;
            r102.switchDevTool(r100, r101);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
        public final void log(LogLevel r100, String r101, String r110, Object r111, Object r112) {
            Intrinsics.checkNotNullParameter(r100, "level");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r110, "tag");
            IvyDebugService r102 = a();
            if (r102 == null) goto L6;
            r102.log(r100, r101, r110, r111, r112);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$LogLevel;", "", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final enum LogLevel extends Enum<LogLevel> {
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel VERBOSE = null;
        public static final LogLevel WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogLevel[] f278361a = null;

        public static LogLevel valueOf(String r100) {
            return (LogLevel) a.a(LogLevel.class, r100);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) f278361a.clone();
        }

        static {
            LogLevel r100 = new LogLevel("VERBOSE", 0);
            VERBOSE = r100;
            LogLevel r101 = new LogLevel("DEBUG", 1);
            DEBUG = r101;
            LogLevel r102 = new LogLevel("INFO", 2);
            INFO = r102;
            LogLevel r103 = new LogLevel("WARN", 3);
            WARN = r103;
            LogLevel r104 = new LogLevel("ERROR", 4);
            ERROR = r104;
            f278361a = new LogLevel[]{r100, r101, r102, r103, r104};
        }

        public LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = Companion.f278359a;
    }

    boolean handleSchema(String r100);

    boolean isEnable();

    void log(LogLevel r100, String r101, String r102, Object r103, Object r104);

    void openInstancePanel(View r100);

    void registerScanCallback(Function1<? super Context, Unit> r100);

    void setEnable(boolean r100);

    void switchDevTool(Context r100, boolean r101);
}
