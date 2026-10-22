package com.oplus.ocs.base.utils;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f404310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> f404311b = null;

    public c() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        f404310a = "c";
        f404311b = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_oplus_ocs_base_utils_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static final <T extends Parcelable> T a(Parcel r100, ClassLoader r101, String r102) {
        Parcelable.Creator<?> r103 = b(r100, r101, r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        if ((r103 instanceof Parcelable.ClassLoaderCreator) == false) goto L11;
        return (T) ((Parcelable.ClassLoaderCreator) r103).createFromParcel(r100, r101);
    L11:
        return (T) r103.createFromParcel(r100);
    }

    private static Parcelable.Creator<?> b(Parcel r100, ClassLoader r101, String r102) {
        if (r100.readString() != null) goto L5;
        return null;
    L5:
        HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> r103 = f404311b;
        monitor-enter(r103);
        HashMap<String, Parcelable.Creator<?>> r104 = r103.get(r101);     // Catch: Throwable -> L44
        if (r104 != null) goto L10;
        r104 = new HashMap();     // Catch: Throwable -> L44
        r103.put(r101, r104);     // Catch: Throwable -> L44
    L10:
        Parcelable.Creator<?> r105 = r104.get(r102);     // Catch: Throwable -> L44
        monitor-exit(r103);     // Catch: Throwable -> L44
        if (r105 == null) goto L51;
        return r105;
    L51:
        Class r106 = INVOKESTATIC_com_oplus_ocs_base_utils_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102, false, r101);     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
        if (Parcelable.class.isAssignableFrom(r106) == false) goto L37;
        Field r107 = r106.getField("CREATOR");     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
        if ((r107.getModifiers() & 8) == 0) goto L35;
        if (Parcelable.Creator.class.isAssignableFrom(r107.getType()) == false) goto L33;
        Parcelable.Creator<?> r108 = (Parcelable.Creator) r107.get(null);     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
        if (r108 == null) goto L31;
        monitor-enter(r103);
        r104.put(r102, r108);     // Catch: Throwable -> L27
        monitor-exit(r103);     // Catch: Throwable -> L27
        return r108;
    L27:
        th = move-exception;
        throw th;
    L31:
        throw new BadParcelableException("Parcelable protocol requires a non-null Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(r102)));
    L33:
        throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(r102)));     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
    L35:
        throw new BadParcelableException("Parcelable protocol requires the CREATOR object to be static on class ".concat(String.valueOf(r102)));     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
    L37:
        throw new BadParcelableException("Parcelable protocol requires subclassing from Parcelable on class ".concat(String.valueOf(r102)));     // Catch: NoSuchFieldException -> L38 ClassNotFoundException -> L40 IllegalAccessException -> L42
    L40:
        "Class not found when unmarshalling: ".concat(String.valueOf(r102));
        throw new BadParcelableException("ClassNotFoundException when unmarshalling: ".concat(String.valueOf(r102)));
    L42:
        "Illegal access when unmarshalling: ".concat(String.valueOf(r102));
        throw new BadParcelableException("IllegalAccessException when unmarshalling: ".concat(String.valueOf(r102)));
    L39:
        throw new BadParcelableException("Parcelable protocol requires a Parcelable.Creator object called CREATOR on class ".concat(String.valueOf(r102)));
    L44:
        th = move-exception;
        throw th;
    }

    public static void a(Parcel r100, Parcelable r101, String r102) {
        if (r101 != null) goto L5;
        r100.writeString(null);
        return;
    L5:
        r100.writeString(r102);
        r101.writeToParcel(r100, 0);
    }
}
