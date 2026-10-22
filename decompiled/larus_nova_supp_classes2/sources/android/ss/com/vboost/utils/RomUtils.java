package android.ss.com.vboost.utils;

import android.os.Build;
import android.ss.com.vboost.e;
import android.ss.com.vboost.f;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class RomUtils {
    private static final String TAG = "RomUtils";

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f178a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f179b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f180c = null;
        public static final a d = null;
        public static final a e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f181f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f182g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f183h = null;

        static {
            a r0 = new a("UNKNOWN", 0, "unknown", 0);
            f178a = r0;
            a r1 = new a("SS", 1, "ss", 1);
            f179b = r1;
            a r2 = new a("CHRY", 2, "chry", 2);
            f180c = r2;
            a r4 = new a("XM", 3, "xm", 3);
            d = r4;
            a r6 = new a("OP", 4, "op", 4);
            e = r6;
            a r8 = new a("VO", 5, "vo", 5);
            f181f = r8;
            a r10 = new a("MZ", 6, "mz", 6);
            f182g = r10;
            f183h = new a[]{r0, r1, r2, r4, r6, r8, r10};
        }

        private a(String r1, int r2, String r3, int r4) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f183h.clone();
        }
    }

    public RomUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static a getRomType() {
        if (isSsRom() == false) goto L7;
        return a.f179b;
    L7:
        if (isCHRYRom() == false) goto L11;
        return a.f180c;
    L11:
        if (isXmRom() == false) goto L15;
        return a.d;
    L15:
        if (isOpRom() == false) goto L19;
        return a.e;
    L19:
        if (isVoRom() == false) goto L23;
        return a.f181f;
    L23:
        return a.f178a;
    }

    public static String getSystemProperty(String r6) {
        Class r0 = INVOKESTATIC_android_ss_com_vboost_utils_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L6
        return (String) r0.getMethod("get", new Class[]{String.class}).invoke(r0, new Object[]{r6});
    L6:
        LogUtil.error(TAG, "Failed to read system property " + r6);
        return null;
    }

    public static boolean isCHRYRom() {
        return android.ss.com.vboost.a.a();
    }

    public static boolean isOpRom() {
        return android.ss.com.vboost.c.a();
    }

    public static boolean isSsRom() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains("samsung") == false) goto L7;
        return true;
    }

    public static boolean isVoRom() {
        return e.a();
    }

    public static boolean isXmRom() {
        return f.a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_android_ss_com_vboost_utils_RomUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
