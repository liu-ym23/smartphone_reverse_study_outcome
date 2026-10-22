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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final C0009a a = null;

    /* JADX INFO: renamed from: iqc.a$a, reason: collision with other inner class name */
    public static class C0009a implements c {
        public C0009a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class b(String r3) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
            Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

        public static Object c(Context r3) {
            Field r0 = FieldUtils.getField(b("android.app.LoadedApk"), "mReceiverResource");     // Catch: Throwable -> L12
            if (r0 == null) goto L10;
            Field r1 = FieldUtils.getField(b("android.app.ContextImpl"), "mPackageInfo");     // Catch: Throwable -> L12
            if (r1 == null) goto L15;
            Object r4 = FieldUtils.readField(r1, r3);     // Catch: Throwable -> L12
            if (r4 == null) goto L16;
            return FieldUtils.readField(r0, r4);
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
        public boolean a(Context r6) throws Throwable {
            Object r0 = c(r6);
            if (r0 != null) goto L16;
        L6:
            Object r3 = null;
        L8:
            if ((r3 instanceof String[]) == false) goto L11;
            ArrayList r1 = new ArrayList();
            r1.add(r6.getPackageName());
            Collections.addAll(r1, (String[]) r3);
            FieldUtils.writeField(r0, "mWhiteList", r1.toArray(new String[r1.size()]));
            return true;
        L11:
            if (r0 == null) goto L18;
            FieldUtils.writeField(r0, "mResourceConfig", null);
            return false;
        L18:
            return false;
        L16:
            r3 = FieldUtils.readField(r0, "mWhiteList");     // Catch: Throwable -> L15
            goto L8
        }
    }

    public static class b extends e {
        @Override // iqc.a.e, iqc.a.C0009a, iqc.a.c
        public final boolean a(Context r1) throws Throwable {
            return false;
        }

        public b() {
        }
    }

    public interface c {
        boolean a(Context r1) throws Throwable;
    }

    public static class e extends C0009a {
        public e() {
        }

        @Override // iqc.a.C0009a, iqc.a.c
        public boolean a(Context r5) throws Throwable {
            Object r1 = C0009a.c(r5);
            if (r1 != null) goto L16;
        L6:
            Object r0 = null;
        L8:
            if ((r0 instanceof Map) == false) goto L14;
            Map r2 = (Map) r0;
            List r3 = (List) r2.get(0);
            if (r3 != null) goto L12;
            r3 = new ArrayList();
            r2.put(0, r3);
        L12:
            r3.add(r5.getPackageName());
            return true;
        L14:
            return false;
        L16:
            r0 = FieldUtils.readField(r1, "mWhiteListMap");     // Catch: Throwable -> L15
            goto L8
        }
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 24) goto L6;
        a = new C0009a();
        return;
    L6:
        if (r0 >= 26) goto L9;
        a = new d();
        return;
    L9:
        if (r0 >= 28) goto L11;
        a = new e();
        return;
    L11:
        a = new b();
    }
}
