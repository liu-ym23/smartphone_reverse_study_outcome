package com.bytedance.awemeopen.apps.framework.landscape;

import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final boolean a = false;
    public static final boolean b = false;
    public static final long c = 0;
    public static final boolean d = false;
    public static final double e = 0.0d;
    public static Boolean f;

    static {
        JSONObject r0 = AoSettings.a("ao_landscape_feed");
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r2 = r0.optBoolean("landscape_enable", true);
    L6:
        a = r2;
        JSONObject r3 = AoSettings.a("ao_landscape_opt");
        if (r3 == null) goto L9;
        boolean r4 = r3.optBoolean("enable_surface_opt", true);
    L10:
        b = r4;
        JSONObject r5 = AoSettings.a("ao_landscape_opt");
        long r6 = 500;
        if (r5 == null) goto L13;
        r6 = r5.optLong("reset_surface_source_delay", 500);
    L13:
        c = r6;
        JSONObject r7 = AoSettings.a("ao_landscape_opt");
        if (r7 == null) goto L16;
        r1 = r7.optBoolean("upper_offset_enable", true);
    L16:
        d = r1;
        JSONObject r8 = AoSettings.a("ao_landscape_opt");
        double r9 = 0.0328d;
        if (r8 == null) goto L19;
        r9 = r8.optDouble("upper_offset", 0.0328d);
    L19:
        e = r9;
        return;
    L9:
        r4 = true;
        goto L10
    L5:
        r2 = true;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static boolean b(Video r3) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
        return false;
    L10:
        Boolean r5 = f;
        if (r5 == null) goto L14;
        Intrinsics.checkNotNull(r5);
        boolean r6 = r5.booleanValue();
    L20:
        if (r6 == true) goto L23;
        return false;
    L23:
        return a;
    L14:
        if (AoEnv.j() == true) goto L24;
    L19:
        Boolean r7 = Boolean.valueOf(r0);
        f = r7;
        Intrinsics.checkNotNull(r7);
        r6 = r7.booleanValue();
        goto L20
    L24:
        a();     // Catch: Throwable -> L18
    L18:
        r0 = false;
        goto L19
    L5:
        if (r3.getWidth() <= r3.getHeight()) goto L7;
        r4 = true;
        goto L8
    }
}
