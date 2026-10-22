package com.bytedance.reparo.core;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends WandTrick {

    public class a extends WandTrick.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e97.a f267327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f267328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f267329e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List f267330f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ List f267331g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ d97.b f267332h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Class[] f267333i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ byte[][] f267334j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ ArrayList f267335k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ ArrayList f267336l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f267337m;

        @Override // com.bytedance.reparo.core.WandTrick.a
        public final boolean b(int r100) {
            if (r100 != 0) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // com.bytedance.reparo.core.WandTrick.a
        public final int a() throws Exception {
            ArrayList r100 = new ArrayList();
            r100.addAll(this.f267328d);
            int r101 = this.f267337m.c(this.f267329e, this.f267330f, this.f267331g, r100, this.f267332h);
            if (r101 == 0) goto L9;
            e97.a r102 = this.f267327c;
            if (e97.a.f471512g == true) goto L7;
            r102.getClass();
        L8:
            return r101;
        L7:
            r102.a();
            goto L8
        L9:
            this.f267332h.b("redefineClassesNative");
            String[] r103 = new String[10];
            b r104 = this.f267337m;
            Class[] r105 = this.f267333i;
            byte[][] r106 = this.f267334j;
            Object[] r107 = this.f267335k.toArray();
            b r108 = this.f267337m;
            Object[] r109 = this.f267335k.toArray();
            r108.getClass();
            int[] r110 = WandTrick.g(r109);
            Object[] r111 = this.f267336l.toArray();
            String[] r112 = new String[100];
            this.f267332h.f467627e.add(r112);
            long[] r113 = new long[100];
            this.f267332h.f467628f.add(r113);
            int r114 = r104.redefineClassesNative(r105, r106, r107, r110, r111, r103, r112, r113);
            this.f267332h.a("redefineClassesNative");
            k.d("redefine", r103);
            if (r114 != (-9)) goto L16;
            e97.a r115 = this.f267327c;
            if (e97.a.f471512g == true) goto L14;
            r115.getClass();
        L15:
            return r114;
        L14:
            r115.a();
            goto L15
        L16:
            if (r114 != 0) goto L30;
            e97.a r116 = this.f267327c;
            if (e97.a.f471512g == true) goto L20;
            r116.getClass();
        L29:
            return 0;
        L20:
            if (r116.f471513f.f467633c.f22892l == false) goto L29;
            if (r116.c() < r116.f471530b) goto L24;
            boolean r117 = true;
        L25:
            if (r117 == true) goto L29;
            r116.b();
            goto L29
        L24:
            r117 = false;
            goto L25
        L30:
            StringBuilder r118 = new StringBuilder("Failure in redefinition, ret: ");
            if (r114 <= 0) goto L33;
            Object r119 = Marker.ANY_NON_NULL_MARKER + r114;
        L34:
            r118.append(r119);
            throw new Exception(r118.toString());
        L33:
            r119 = Integer.valueOf(r114);
            goto L34
        }

        public a(b r100, d97.d r101, List r102, Application r103, boolean r104, Map r105, List r106, List r107, d97.b r108, Class[] r110, byte[][] r111, ArrayList r112, ArrayList r113) {
            this.f267337m = r100;
            this.f267328d = r102;
            this.f267329e = r105;
            this.f267330f = r106;
            this.f267331g = r107;
            this.f267332h = r108;
            this.f267333i = r110;
            this.f267334j = r111;
            this.f267335k = r112;
            this.f267336l = r113;
            this.f267327c = new e97.a(r101, e97.f.b(r100.f267319c));
        }
    }

    public b() {
    }

    @Override // com.bytedance.reparo.core.WandTrick
    public final WandTrick.a b(Application r110, boolean r111, Map<Class, h> r112, List<String> r210, List<String> r211, List<Object> r212, d97.b r213, d97.d r214) throws Exception {
        r213.b("read_patch_dex");
        HashMap r100 = (HashMap) r112;
        byte[][] r113 = new byte[r100.size()][];
        int r101 = r100.size();
        Class[] r114 = new Class[r101];
        Iterator r102 = r100.keySet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L36;
        Class r104 = (Class) r102.next();
        PolarisFileInputStreamWrapper r105 = null;
        h r106 = (h) r100.get(r104);     // Catch: Throwable -> L25
        if (r106 == null) goto L9;
        String r107 = r106.f267368a;     // Catch: Throwable -> L25
    L11:
        if (TextUtils.isEmpty(r107) == true) goto L17;
        PolarisFileInputStreamWrapper r115 = new PolarisFileInputStreamWrapper(r107);     // Catch: Throwable -> L25
        byte[] r108 = new byte[r115.available()];     // Catch: Throwable -> L15
        r115.read(r108);     // Catch: Throwable -> L15
        r113[r103] = r108;     // Catch: Throwable -> L15
        r114[r103] = r104;     // Catch: Throwable -> L15
        int r109 = r103 + 1;
        r105 = r115;
    L18:
        HashMap<String, Class> r116 = n.f267407a;
        if (r105 == null) goto L24;
        r105.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        b97.a.c("closeSafely", e);
    L24:
        r103 = r109;
    L15:
        th = th;
        r105 = r115;
    L98:
    L28:
        th = move-exception;
        HashMap<String, Class> r117 = n.f267407a;
        if (r105 == null) goto L130;
        r105.close();     // Catch: IOException -> L33
        throw th;
    L33:
        e = move-exception;
        b97.a.c("closeSafely", e);
        throw th;
    L130:
        throw th;
    L27:
        throw new Exception("Failed to read dex: " + r104.getName(), th);     // Catch: Throwable -> L28
    L17:
        r109 = r103;
        goto L18
    L9:
        r107 = null;
    L25:
        th = th;
        goto L98
    L36:
        ArrayList r118 = new ArrayList();
        int r119 = 0;
    L37:
        if (r119 >= r101) goto L48;
        Class<?> r120 = r114[r119];
        Constructor r121 = getClinitMethod(r120);
        if (r121 == null) goto L41;
        r118.add(r121);
    L41:
        r118.addAll(WandTrick.d(r120));
        ArrayList r122 = new ArrayList();
        Constructor<?>[] r123 = r120.getDeclaredConstructors();
        int r124 = r123.length;
        int r125 = 0;
    L42:
        if (r125 >= r124) goto L47;
        Constructor<?> r126 = r123[r125];
        if (r126.getDeclaringClass() != r120) goto L46;
        r122.add(r126);
    L46:
        r125 = r125 + 1;
        goto L42
    L47:
        r118.addAll(r122);
        r119 = r119 + 1;
        goto L37
    L48:
        ArrayList r127 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) goto L94;
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r128 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r129 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L106;
        Class<?> r130 = Class.forName("java.lang.reflect.Executable");     // Catch: Throwable -> L65
        if (r129 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L78;
        FastClassNotFoundHandler.a("java.lang.reflect.Executable");     // Catch: Throwable -> L65
    L78:
        Field r131 = r130.getDeclaredField("accessFlags");
        r131.setAccessible(true);
        Iterator r132 = r118.iterator();
    L80:
        if (r132.hasNext() == false) goto L94;
        Object r133 = r132.next();
        int r134 = r131.getInt(r133);
        if (Build.VERSION.SDK_INT == 26) goto L84;
        if ((r134 & 1024) != 0) goto L92;
        if ((r134 & 16777216) == 0) goto L80;
    L92:
        r127.add(r133);
        goto L80
    L84:
        if ((r134 & 1024) != 0) goto L87;
        if ((r134 & 8388608) == 0) goto L80;
    L87:
        r127.add(r133);
    L65:
        th = move-exception;
        if (r129 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L70;
        FastClassNotFoundHandler.b("java.lang.reflect.Executable");
    L70:
        if ((th instanceof PluginClassNotFoundException) == false) goto L72;
        throw th;
    L72:
        if ((th instanceof ClassNotFoundException) == false) goto L74;
    L77:
        r130 = MiraPluginFix.forName("java.lang.reflect.Executable");
        goto L78
    L74:
        if ((th instanceof NoClassDefFoundError) == true) goto L77;
        throw th;
    L106:
        r130 = Class.forName("java.lang.reflect.Executable");     // Catch: Throwable -> L56
        if (r129 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L78;
        FastClassNotFoundHandler.a("java.lang.reflect.Executable");     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        if (r129 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L60;
        FastClassNotFoundHandler.b("java.lang.reflect.Executable");
    L60:
        throw th;
    L94:
        r213.a("read_patch_dex");
        return new a(this, r214, r212, r110, r111, r100, r210, r211, r213, r114, r113, r118, r127);
    }
}
