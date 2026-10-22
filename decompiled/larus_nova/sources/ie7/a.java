package ie7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f489497a = null;

    /* JADX INFO: renamed from: ie7.a$a, reason: collision with other inner class name */
    public static class C6258a implements b {
        public C6258a() {
        }
    }

    public interface b {
        Intent b(Context r100);
    }

    public static final class c extends C6258a {
        public c() {
        }

        @Override // ie7.a.b
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
        f489497a = MapsKt.mapOf(TuplesKt.to("meizu", new c()));
    }
}
