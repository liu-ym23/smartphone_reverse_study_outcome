package iqc;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6351a f495426a = null;

    /* JADX INFO: renamed from: iqc.a$a, reason: collision with other inner class name */
    public static class C6351a implements c {
        public C6351a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

        public static Object c(Context r100) {
            Field r101 = FieldUtils.getField(b("android.app.LoadedApk"), "mReceiverResource");     // Catch: Throwable -> L12
            if (r101 == null) goto L10;
            Field r102 = FieldUtils.getField(b("android.app.ContextImpl"), "mPackageInfo");     // Catch: Throwable -> L12
            if (r102 == null) goto L15;
            Object r103 = FieldUtils.readField(r102, r100);     // Catch: Throwable -> L12
            if (r103 == null) goto L16;
            return FieldUtils.readField(r101, r103);
        L16:
            return null;
        L15:
            return null;
        L10:
            return null;
        L17:
            return null;
        }

        @Override // iqc.a.c
        public boolean a(Context r100) throws Throwable {
            Object r101 = c(r100);
            if (r101 != null) goto L16;
        L6:
            Object r102 = null;
        L8:
            if ((r102 instanceof String[]) == false) goto L11;
            ArrayList r103 = new ArrayList();
            r103.add(r100.getPackageName());
            Collections.addAll(r103, (String[]) r102);
            FieldUtils.writeField(r101, "mWhiteList", r103.toArray(new String[r103.size()]));
            return true;
        L11:
            if (r101 == null) goto L18;
            FieldUtils.writeField(r101, "mResourceConfig", null);
            return false;
        L18:
            return false;
        L16:
            r102 = FieldUtils.readField(r101, "mWhiteList");     // Catch: Throwable -> L15
            goto L8
        }
    }

    public static class b extends e {
        @Override // iqc.a.e, iqc.a.C6351a, iqc.a.c
        public final boolean a(Context r100) throws Throwable {
            return false;
        }

        public b() {
        }
    }

    public interface c {
        boolean a(Context r100) throws Throwable;
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class d extends C6351a {
        public d() {
        }

        @Override // iqc.a.C6351a, iqc.a.c
        public final boolean a(Context r100) throws Throwable {
            Object r101 = C6351a.c(r100);
            if (r101 != null) goto L14;
        L6:
            Object r102 = null;
        L8:
            if ((r102 instanceof List) == false) goto L11;
            ((List) r102).add(r100.getPackageName());
            return true;
        L11:
            return false;
        L14:
            r102 = FieldUtils.readField(r101, "mWhiteList");     // Catch: Throwable -> L13
            goto L8
        }
    }

    public static class e extends C6351a {
        public e() {
        }

        @Override // iqc.a.C6351a, iqc.a.c
        public boolean a(Context r100) throws Throwable {
            Object r101 = C6351a.c(r100);
            if (r101 != null) goto L16;
        L6:
            Object r102 = null;
        L8:
            if ((r102 instanceof Map) == false) goto L14;
            Map r103 = (Map) r102;
            List r104 = (List) r103.get(0);
            if (r104 != null) goto L12;
            r104 = new ArrayList();
            r103.put(0, r104);
        L12:
            r104.add(r100.getPackageName());
            return true;
        L14:
            return false;
        L16:
            r102 = FieldUtils.readField(r101, "mWhiteListMap");     // Catch: Throwable -> L15
            goto L8
        }
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L6;
        f495426a = new C6351a();
        return;
    L6:
        if (r100 >= 26) goto L9;
        f495426a = new d();
        return;
    L9:
        if (r100 >= 28) goto L11;
        f495426a = new e();
        return;
    L11:
        f495426a = new b();
    }
}
