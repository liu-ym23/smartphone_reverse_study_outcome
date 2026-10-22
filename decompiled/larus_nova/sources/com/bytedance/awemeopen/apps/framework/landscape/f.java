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

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f197129a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f197130b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f197131c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f197132d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f197133e = 0.0d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f197134f;

    static {
        JSONObject r100 = AoSettings.a("ao_landscape_feed");
        boolean r101 = true;
        if (r100 == null) goto L5;
        boolean r102 = r100.optBoolean("landscape_enable", true);
    L6:
        f197129a = r102;
        JSONObject r103 = AoSettings.a("ao_landscape_opt");
        if (r103 == null) goto L9;
        boolean r104 = r103.optBoolean("enable_surface_opt", true);
    L10:
        f197130b = r104;
        JSONObject r105 = AoSettings.a("ao_landscape_opt");
        long r106 = 500;
        if (r105 == null) goto L13;
        r106 = r105.optLong("reset_surface_source_delay", 500);
    L13:
        f197131c = r106;
        JSONObject r107 = AoSettings.a("ao_landscape_opt");
        if (r107 == null) goto L16;
        r101 = r107.optBoolean("upper_offset_enable", true);
    L16:
        f197132d = r101;
        JSONObject r108 = AoSettings.a("ao_landscape_opt");
        double r109 = 0.0328d;
        if (r108 == null) goto L19;
        r109 = r108.optDouble("upper_offset", 0.0328d);
    L19:
        f197133e = r109;
        return;
    L9:
        r104 = true;
        goto L10
    L5:
        r102 = true;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.android.dy.sdk.stub.VideoStubActivity$Activity_Landscape1");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static boolean b(Video r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        Boolean r103 = f197134f;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNull(r103);
        boolean r104 = r103.booleanValue();
    L20:
        if (r104 == true) goto L23;
        return false;
    L23:
        return f197129a;
    L14:
        if (AoEnv.j() == true) goto L24;
    L19:
        Boolean r105 = Boolean.valueOf(r101);
        f197134f = r105;
        Intrinsics.checkNotNull(r105);
        r104 = r105.booleanValue();
        goto L20
    L24:
        a();     // Catch: Throwable -> L18
    L18:
        r101 = false;
        goto L19
    L5:
        if (r100.getWidth() <= r100.getHeight()) goto L7;
        r102 = true;
        goto L8
    }
}
