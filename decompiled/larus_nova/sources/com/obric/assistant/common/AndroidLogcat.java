package com.obric.assistant.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidLogcat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387831a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/common/AndroidLogcat$Level;", "", "<init>", "(Ljava/lang/String;I)V", "V", "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Level extends Enum<Level> {
        public static final Level D = null;
        public static final Level E = null;
        public static final Level I = null;
        public static final Level V = null;
        public static final Level W = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f387832a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f387833b = null;

        public static EnumEntries<Level> getEntries() {
            return f387833b;
        }

        static {
            Level r100 = new Level("V", 0);
            V = r100;
            Level r101 = new Level("D", 1);
            D = r101;
            Level r102 = new Level("I", 2);
            I = r102;
            Level r103 = new Level(ExifInterface.LONGITUDE_WEST, 3);
            W = r103;
            Level r104 = new Level(ExifInterface.LONGITUDE_EAST, 4);
            E = r104;
            Level[] r105 = {r100, r101, r102, r103, r104};
            f387832a = r105;
            f387833b = EnumEntriesKt.enumEntries(r105);
        }

        public static Level[] values() {
            return (Level[]) f387832a.clone();
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387834a = null;

        static {
            int[] r100 = new int[Level.values().length];
            r100[Level.V.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[Level.D.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[Level.I.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Level.W.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[Level.E.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f387834a = r100;
        }
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.util.Log");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.util.Log");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.util.Log");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.util.Log");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.util.Log");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.util.Log");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.util.Log");
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c(Level.I, r100, r101);
    }

    public static void c(Level r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Class r103 = a();     // Catch: Exception -> L24
        int r104 = a.f387834a[r100.ordinal()];     // Catch: Exception -> L24
        if (r104 == 1) goto L18;
        if (r104 != 2) goto L7;
        Method r105 = r103.getMethod("d", new Class[]{String.class, String.class});     // Catch: Exception -> L24
    L19:
        Object[] r106 = new Object[2];     // Catch: Exception -> L24
        r106[0] = r101;     // Catch: Exception -> L24
        if (r102 != null) goto L22;
        r102 = "";
    L22:
        r106[1] = r102;     // Catch: Exception -> L24
        r105.invoke(null, r106);     // Catch: Exception -> L24
        return;
    L7:
        if (r104 != 3) goto L9;
        r105 = r103.getMethod(RXScreenCaptureService.KEY_INDEX, new Class[]{String.class, String.class});     // Catch: Exception -> L24
        goto L19
    L9:
        if (r104 != 4) goto L11;
        r105 = r103.getMethod("w", new Class[]{String.class, String.class});     // Catch: Exception -> L24
        goto L19
    L11:
        if (r104 != 5) goto L14;
        r105 = r103.getMethod("e", new Class[]{String.class, String.class});     // Catch: Exception -> L24
        goto L19
    L14:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L24
    L18:
        r105 = r103.getMethod(BaseSwitches.V, new Class[]{String.class, String.class});     // Catch: Exception -> L24
        goto L19
    }
}
