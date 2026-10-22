package g4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, InterfaceC5984b> f479939a = null;

    public static class a implements InterfaceC5984b {
        public a() {
        }
    }

    /* JADX INFO: renamed from: g4.b$b, reason: collision with other inner class name */
    public interface InterfaceC5984b {
        Intent b(Context r100);
    }

    public static final class c extends a {
        public c() {
        }

        @Override // g4.b.InterfaceC5984b
        public final Intent b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ComponentName r101 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent r102 = new Intent();
            r102.setComponent(r101);
            r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
            r102.setFlags(268435456);
            return r102;
        }
    }

    static {
        f479939a = MapsKt.mapOf(TuplesKt.to("meizu", new c()));
    }
}
