package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\u0007H\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VMConsoleLogModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "log", "", "message", "", "level", "", "info", LynxTemplateRender.RENDER_PHASE_SETUP, "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VMConsoleLogModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "VMLog";
    private static final String TAG = "VMSDK_VMConsoleLogModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JSMethod
    public final void setup() {
        rnb.c.c(TAG, "setup: ");
    }

    public VMConsoleLogModule(Context r100) {
        super(r100);
    }

    @JSMethod
    public final void info(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        rnb.c.c(TAG, "log:" + r100 + ' ');
    }

    @JSMethod
    public final void log(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        rnb.c.c(TAG, "log level: " + r101 + ", " + r100 + ' ');
    }
}
