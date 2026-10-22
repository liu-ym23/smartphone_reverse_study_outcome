package pl0;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.lynx.tasm.LynxEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kjc.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529749a = 0;

    static {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, kotlin.Unit] */
    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (LynxEnv.inst().hasInited() == false) goto L6;
        return;
    L6:
        if ((r100 instanceof Application) == true) goto L8;
        Context r101 = null;
    L9:
        Application r102 = (Application) r101;
        if (r102 != null) goto L15;
        Context r103 = r100.getApplicationContext();
        if ((r103 instanceof Application) == true) goto L14;
        r103 = null;
    L14:
        r102 = (Application) r103;
    L15:
        if (r102 == null) goto L37;
        ((IHostAction) k.n(IHostAction.class)).initLynxEnv();
        c r104 = new c();
        if (2 != kjc.a.a()) goto L29;
        kjc.b<T> r105 = r104.f503730a;
        if (LynxEnv.inst().hasInited() == true) goto L27;
        String r106 = LiveSlardarConstants.suffixError("ttlive_lynx_initial");
        JSONObject r107 = new JSONObject();
        ClassLoader r108 = r107.getClass().getClassLoader();
        if (r108 == null) goto L25;
        String r109 = r108.getClass().toString();
        if (r109 == null) goto L25;
    L26:
        r107.put("class_loader", r109);
        r107.put("status", "1");
        Unit r110 = Unit.INSTANCE;
        LiveSlardarMonitor.monitorEvent(r106, r107, null, null);
    L25:
        r109 = "null";
    L27:
        r105.f503729a = Unit.INSTANCE;
        r104.f503731b = true;
    L29:
        if (r104.f503731b == true) goto L31;
        r104.f503730a.f503729a = Unit.INSTANCE;
    L31:
        T r111 = r104.f503730a.f503729a;
        Npth.addAttachUserData(a.f529748a, CrashType.ALL);     // Catch: Throwable -> L34
        return;
    L38:
        return;
    L37:
        return;
    L8:
        r101 = r100;
        goto L9
    }
}
