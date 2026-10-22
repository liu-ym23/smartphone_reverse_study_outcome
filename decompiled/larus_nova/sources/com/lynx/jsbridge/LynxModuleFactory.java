package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class LynxModuleFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, f> f381299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f381300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IModuleCreator f381301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f381302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f381303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LynxModule.a f381304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f381305g;

    public static abstract class a {
        public a() {
        }
    }

    private native boolean nativeRetainJniObject(long r100);

    public final void d() {
        if (nativeRetainJniObject(this.f381300b) == true) goto L6;
        LLog.e("LynxModuleFactory", "LynxModuleFactory try to retainJniObject failed");
        destroy();
        return;
    }

    public void destroy() {
        if (this.f381303e == false) goto L5;
        return;
    L5:
        a r100 = this.f381305g;
        if (r100 == null) goto L8;
        UIThreadUtils.runOnUiThread(((LynxTemplateRender.f) r100).f381683a);
    L8:
        IModuleCreator r101 = this.f381301c;
        if (r101 == null) goto L17;
        com.lynx.jsbridge.a r102 = (com.lynx.jsbridge.a) r101;
        Iterator<LynxModuleWrapper> r103 = r102.f381353a.values().iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        LynxModule r104 = r103.next().f381307a;
        if (r104 == null) goto L12;
        r104.destroy();
        goto L12
    L16:
        r102.f381353a.clear();
    L17:
        this.f381299a.clear();
        this.f381300b = 0;
        this.f381303e = true;
    }

    public LynxModuleFactory() {
        this.f381300b = 0;
        this.f381303e = false;
        this.f381299a = new ConcurrentHashMap();
    }

    public long getNativePtr() {
        return this.f381300b;
    }

    private LynxModuleWrapper moduleWrapperForName(String r100) {
        return b(r100);
    }

    private void setNativePtr(long r100) {
        this.f381300b = r100;
    }

    public final void a(List<f> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L17;
        Iterator<f> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L18;
        f r102 = r101.next();
        String r103 = r102.b();
        f r104 = this.f381299a.get(r103);
        if (r104 == null) goto L12;
        LLog.e("LynxModuleFactory", "Duplicated LynxModule For Name: " + r103 + ", " + r104 + " will be override");
    L12:
        this.f381299a.put(r103, r102);
        LLog.v("LynxModuleFactory", "method addModuleParamWrapper ,  registered module with name: " + r103 + " class" + r102);
        goto L8
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.lynx.jsbridge.LynxModule] */
    public final LynxModuleWrapper b(String r110) {
        IModuleCreator r100 = this.f381301c;
        LynxModuleWrapper r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        ConcurrentHashMap<String, f> r102 = this.f381299a;
        com.lynx.jsbridge.a r103 = (com.lynx.jsbridge.a) r100;
        if (r110 != null) goto L8;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule failed, name is null");
    L119:
        if (r101 == null) goto L121;
        r101.getModule().setExtraData(this.f381302d);
        r101.f381311e = this.f381304f;
    L121:
        return r101;
    L8:
        LynxModuleWrapper r104 = r103.f381353a.get(r110);
        if (r104 == null) goto L11;
        r101 = r104;
        goto L119
    L11:
        f r105 = r102.get(r110);
        if (r105 != null) goto L16;
        r105 = LynxEnv.inst().getModuleFactory().f381299a.get(r110);
        if (r105 != null) goto L16;
    L23:
        LynxModuleWrapper r111 = null;
    L114:
        r101 = r111;
    L116:
        if (r101 != null) goto L118;
        r101 = r111;
        goto L119
    L118:
        r103.f381353a.put(r110, r101);
    L16:
        WeakReference r106 = r103.f381354b.a();
        if (r106.get() != null) goto L19;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule failed, context is null");
        goto L23
    L19:
        Class<? extends LynxModule> r107 = r105.a();
        boolean r108 = LynxContextModule.class.isAssignableFrom(r107);     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        Context r109 = (Context) r106.get();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        if (r109 != null) goto L122;
        LLog.e("LynxModuleFactory:CommonModuleCreator", r107.getCanonicalName() + " called with Null context");     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        goto L23
    L122:
        if (r108 == false) goto L123;
        if ((r109 instanceof LynxContext) == false) goto L52;
        if (r105.c() != null) goto L50;
        Constructor<?>[] r112 = r107.getConstructors();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        int r113 = r112.length;     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        int r114 = 0;
    L31:
        if (r114 >= r113) goto L49;
        Constructor<?> r115 = r112[r114];     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        Class<?>[] r116 = r115.getParameterTypes();     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        if (r116.length != 1) goto L39;
        if (LynxContext.class.equals(r116[0]) == false) goto L39;
        LynxModule r117 = (LynxModule) r115.newInstance(new Object[]{(LynxContext) r109});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L62:
        ?? r118 = r117;
        r111 = null;
    L112:
        if (r118 != 0) goto L115;
        LLog.e("LynxModuleFactory:CommonModuleCreator", "getModule" + r110 + "failed");
        goto L114
    L115:
        LynxModuleWrapper r119 = new LynxModuleWrapper(r110, r118);
        r119.f381312f = r103.f381354b;
        r101 = r119;
    L39:
        if (r116.length != 2) goto L48;
        if (LynxContext.class.equals(r116[0]) == false) goto L48;
        if (Object.class.equals(r116[1]) == false) goto L48;
        Object[] r120 = new Object[2];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r120[0] = (LynxContext) r109;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r120[1] = null;     // Catch: Exception -> L96 InvocationTargetException -> L99 NoSuchMethodException -> L102 IllegalAccessException -> L105 InstantiationException -> L108
        r117 = (LynxModule) r115.newInstance(r120);     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L48:
        r114 = r114 + 1;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r101 = null;
        goto L31
    L49:
        r111 = r101;
    L111:
        r118 = r111;
        goto L112
    L50:
        r117 = r107.getConstructor(new Class[]{LynxContext.class, Object.class}).newInstance(new Object[]{(LynxContext) r109, r105.c()});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        goto L62
    L52:
        throw new Exception(r107.getCanonicalName() + " must be created with LynxContext");     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L123:
        if (r105.c() != null) goto L74;
        Constructor<?>[] r121 = r107.getConstructors();     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        int r122 = r121.length;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        int r123 = 0;
    L56:
        if (r123 >= r122) goto L73;
        Constructor<?> r124 = r121[r123];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        Class<?>[] r125 = r124.getParameterTypes();     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        if (r125.length != 1) goto L64;
        if (Context.class.equals(r125[0]) == false) goto L64;
        r117 = (LynxModule) r124.newInstance(new Object[]{r109});     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
    L64:
        if (r125.length != 2) goto L72;
        if (Context.class.equals(r125[0]) == false) goto L72;
        if (Object.class.equals(r125[1]) == false) goto L72;
        Object[] r126 = new Object[2];     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r126[0] = r109;     // Catch: Exception -> L86 InvocationTargetException -> L88 NoSuchMethodException -> L90 IllegalAccessException -> L92 InstantiationException -> L94
        r111 = null;
        r126[1] = null;     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
        r118 = (LynxModule) r124.newInstance(r126);     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
    L72:
        r123 = r123 + 1;     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
        goto L56
    L73:
        r111 = null;
        goto L111
    L74:
        r111 = null;
        r118 = r107.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{r109, r105.c()});     // Catch: Exception -> L76 InvocationTargetException -> L78 NoSuchMethodException -> L80 IllegalAccessException -> L82 InstantiationException -> L84
    L82:
        e = e;
    L107:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L84:
        e = e;
    L110:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L80:
        e = e;
    L104:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L78:
        e = e;
    L101:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get TargetException " + e.getTargetException());
    L76:
        e = e;
    L98:
        LLog.e("LynxModuleFactory:CommonModuleCreator", "get Module failed" + e);
    L92:
        e = e;
        r111 = null;
    L94:
        e = e;
        r111 = null;
    L90:
        e = e;
        r111 = null;
    L88:
        e = e;
        r111 = null;
    L86:
        e = e;
        r111 = null;
    L105:
        e = e;
        r111 = null;
    L108:
        e = e;
        r111 = null;
    L102:
        e = e;
        r111 = null;
    L99:
        e = e;
        r111 = null;
    L96:
        e = e;
        r111 = null;
        goto L98
    }

    public final void c(String r100, Class<? extends LynxModule> r101, Object r102) {
        f r103 = new f();
        r103.f381362a = r100;
        r103.f381363b = r101;
        r103.f381364c = r102;
        f r104 = this.f381299a.get(r100);
        if (r104 == null) goto L5;
        LLog.e("LynxModuleFactory", "Duplicated LynxModule For Name: " + r100 + ", " + r104 + " will be override");
    L5:
        this.f381299a.put(r100, r103);
        LLog.v("LynxModuleFactory", "method registerModule , registered module with name: " + r100 + " class" + r101);
    }
}
