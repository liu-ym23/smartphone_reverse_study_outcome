package com.bytedance.sdk.xbridge.cn.system;

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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f270195a = null;

    public static class a implements b {
        public a() {
        }
    }

    public interface b {
        Intent a(Context r100);

        Intent b(Context r100);

        Intent c(Context r100);
    }

    public static final class c extends a {
        public c() {
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.i.b
        public final Intent a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r101.addCategory("android.intent.category.DEFAULT");
            r101.putExtra("packageName", r100.getPackageName());
            return r101;
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.i.b
        public final Intent b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ComponentName r101 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent r102 = new Intent();
            r102.setComponent(r101);
            r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
            r102.setFlags(268435456);
            return r102;
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.i.b
        public final Intent c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intent r101 = new Intent("com.meizu.connectivitysettings.CONNECTIVITY_SETTINGS");
            r101.addFlags(268435456);
            r101.putExtra(":settings:show_fragment", "com.meizu.settings.location.MzLocationSettings");
            return r101;
        }
    }

    static {
        f270195a = MapsKt.mapOf(TuplesKt.to("meizu", new c()));
    }
}
