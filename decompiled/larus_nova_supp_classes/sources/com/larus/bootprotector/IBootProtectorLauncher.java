package com.larus.bootprotector;

import android.content.Context;
import android.util.EventsUtils;
import au8.e;
import com.google.gson.JsonArray;
import com.larus.init.task.anr.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001f"}, d2 = {"Lcom/larus/bootprotector/IBootProtectorLauncher;", XmlPullParser.NO_NAMESPACE, "init", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "checkBootProtectorEffect", "baseContext", "checkToCleanFileSilent", "isBootProtectorEnabled", XmlPullParser.NO_NAMESPACE, "shouldEnterBootProtectorPage", "updateBootProtectorSettings", "initNpthMonitor", "initAnrMonitor", "startBootProtectorLandingPage", "getBootProtectorDependency", "Lcom/larus/bootprotector/BootProtectorDependency;", "executeCmdArray", "ctx", "cmds", "Lcom/google/gson/JsonArray;", "executeCmds", XmlPullParser.NO_NAMESPACE, "onAppRestartAfterCrash", "clearBootProtectorData", "registerANRListener", "listener", "Lcom/larus/bootprotector/anr/FlowAnrListener;", "unregisterANRListener", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IBootProtectorLauncher {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<IBootProtectorLauncher> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(new e());
        }

        public static IBootProtectorLauncher c() {
            return b.getValue();
        }

        public static BootProtectorDependency b() {
            IBootProtectorLauncher r0 = c();
            if (r0 == null) goto L7;
            BootProtectorDependency r1 = r0.b();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new BootProtectorDependencyDefault();
        }

        public static void a(Context r1, JsonArray r2) {
            Intrinsics.checkNotNullParameter(r1, "ctx");
            Intrinsics.checkNotNullParameter(r2, "cmds");
            IBootProtectorLauncher r0 = c();
            if (r0 == null) goto L6;
            r0.e(r1, r2);
            return;
        }
    }

    static {
        a = a.a;
    }

    void a(c r1);

    BootProtectorDependency b();

    boolean c(Context r1);

    void d(Context r1);

    void e(Context r1, JsonArray r2);

    void f();

    void g(Context r1);

    void h(Context r1);

    void i(Context r1);

    void init(Context r1);

    void j(Context r1);

    void k();
}
