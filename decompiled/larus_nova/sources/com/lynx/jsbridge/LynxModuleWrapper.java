package com.lynx.jsbridge;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class LynxModuleWrapper {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends LynxModule>, ArrayList<MethodDescriptor>> f381306g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxModule f381307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<MethodDescriptor> f381308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<AttributeDescriptor> f381309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f381310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LynxModule.a f381311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.lynx.jsbridge.b f381312f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f381313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f381314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxModuleWrapper f381315c;

        public final void a() {
            WeakReference r100 = this.f381313a;
            if (r100 == null) goto L8;
            Context r101 = (Context) r100.get();
            if ((r101 instanceof LynxContext) == false) goto L9;
            LynxError r102 = new LynxError(99900, "NativeModules: GetMethodDescriptors error!moduleName: " + this.f381315c.f381310d + " exception: " + this.f381314b.toString());
            r102.setLogBoxOnly(true);
            ((LynxContext) r101).handleLynxError(r102);
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxModuleWrapper r100, WeakReference r101, RuntimeException r102) {
            this.f381315c = r100;
            this.f381313a = r101;
            this.f381314b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f381316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f381317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxModuleWrapper f381318c;

        public final void a() {
            WeakReference r100 = this.f381316a;
            if (r100 == null) goto L8;
            Context r101 = (Context) r100.get();
            if ((r101 instanceof LynxContext) == false) goto L9;
            LynxError r102 = new LynxError(99900, "NativeModules: getAttributeDescriptors error!moduleName: " + this.f381318c.f381310d + " exception: " + this.f381317b.toString());
            r102.setLogBoxOnly(true);
            ((LynxContext) r101).handleLynxError(r102);
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxModuleWrapper r100, WeakReference r101, RuntimeException r102) {
            this.f381318c = r100;
            this.f381316a = r101;
            this.f381317b = r102;
        }
    }

    static {
        f381306g = new ConcurrentHashMap();
    }

    public final void a() {
        HashSet r100 = new HashSet();
        Field[] r101 = this.f381307a.getClass().getDeclaredFields();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        Field r104 = r101[r103];
        if (((LynxAttribute) r104.getAnnotation(LynxAttribute.class)) == null) goto L16;
        String r105 = r104.getName();
        if (r100.contains(r105) == true) goto L15;
        r100.add(r105);
        JavaOnlyArray r106 = new JavaOnlyArray();
        r106.add(r104.get(this.f381307a));     // Catch: IllegalAccessException -> L11
    L13:
        this.f381309c.add(new AttributeDescriptor(r105, r106));
    L11:
        e = move-exception;
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r105);
    L16:
        r103 = r103 + 1;
        goto L3
    }

    public final void b() {
        Class<?> r100 = this.f381307a.getClass();
        ConcurrentHashMap<Class<? extends LynxModule>, ArrayList<MethodDescriptor>> r101 = f381306g;
        if (r101.containsKey(r100) == false) goto L6;
        this.f381308b.addAll(r101.get(r100));
        return;
    L6:
        Method[] r102 = r100.getDeclaredMethods();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L95;
        Method r105 = r102[r104];
        if (((LynxMethod) r105.getAnnotation(LynxMethod.class)) == null) goto L94;
        String r106 = r105.getName();
        MethodDescriptor r107 = new MethodDescriptor();
        e r108 = new e(r105);
        r107.f381352c = r106;
        boolean r109 = r108.f381360b;
        if (r109 == true) goto L89;
        if (r109 == true) goto L89;
        r108.f381360b = true;
        Class[] r110 = r108.f381359a;
        StringBuilder r111 = new StringBuilder(r110.length + 2);
        Class<?> r112 = r105.getReturnType();
        char r113 = e.a(r112);
        if (r113 == 0) goto L18;
    L49:
        r111.append(r113);
        r111.append('.');
        int r114 = 0;
    L51:
        if (r114 >= r110.length) goto L88;
        Class r115 = r110[r114];
        if (r115 == Promise.class) goto L55;
    L62:
        char r116 = e.a(r115);
        if (r116 != 0) goto L85;
        if (r115 != Callback.class) goto L69;
        r116 = 'X';
        goto L85
    L69:
        if (r115 != Promise.class) goto L72;
        r116 = 'P';
        goto L85
    L72:
        if (((HashSet) e.f381357d).contains(r115) == false) goto L75;
        r116 = 'M';
        goto L85
    L75:
        if (((HashSet) e.f381358e).contains(r115) == false) goto L78;
        r116 = 'A';
        goto L85
    L78:
        if (r115 != f6a.a.class) goto L80;
        r116 = 'Y';
        goto L85
    L80:
        if (r115 != byte[].class) goto L83;
        r116 = 'a';
        goto L85
    L83:
        if (r115 != LynxContext.class) goto L87;
        r116 = 'K';
        goto L85
    L87:
        throw new RuntimeException("Got unknown param class: ".concat(r115.getSimpleName()));
    L85:
        r111.append(r116);
        r114 = r114 + 1;
        goto L51
    L55:
        if (r114 != (r110.length - 1)) goto L57;
        boolean r117 = true;
    L58:
        if (r117 == true) goto L62;
        throw new AssertionError("Promise must be used as last parameter only");
    L57:
        r117 = false;
        goto L58
    L88:
        r108.f381361c = r111.toString();
        goto L89
    L18:
        if (r112 != Void.TYPE) goto L21;
        r113 = 'v';
        goto L49
    L21:
        if (r112 != WritableMap.class) goto L23;
    L48:
        r113 = 'M';
        goto L49
    L23:
        if (r112 == ReadableMap.class) goto L48;
        if (r112 == JavaOnlyMap.class) goto L48;
        if (r112 != WritableArray.class) goto L30;
    L47:
        r113 = 'A';
        goto L49
    L30:
        if (r112 == ReadableArray.class) goto L47;
        if (r112 == JavaOnlyArray.class) goto L47;
        if (r112 != byte[].class) goto L37;
        r113 = 'a';
        goto L49
    L37:
        if (r112 != PiperData.class) goto L40;
        r113 = 'J';
        goto L49
    L40:
        if (r112 != ILynxJSIObject.class) goto L43;
        r113 = 'O';
        goto L49
    L43:
        if (r112 != TemplateData.class) goto L46;
        r113 = 'E';
        goto L49
    L46:
        throw new RuntimeException("Got unknown return class: ".concat(r112.getSimpleName()));
    L89:
        String r118 = r108.f381361c;
        if (r118 == null) goto L93;
        r107.f381351b = r118;
        r107.f381350a = r105;
        this.f381308b.add(r107);
        goto L94
    L93:
        throw new AssertionError();
    L94:
        r104 = r104 + 1;
        goto L7
    L95:
        f381306g.putIfAbsent((Class<? extends LynxModule>) r100, new ArrayList(this.f381308b));
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        WeakReference r100 = this.f381312f.a();
        if (this.f381309c.isEmpty() == false) goto L9;
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        UIThreadUtils.runOnUiThread(new b(this, r100, e));
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
    L9:
        return this.f381309c;
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        WeakReference r100 = this.f381312f.a();
        if (this.f381308b.isEmpty() == false) goto L9;
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        UIThreadUtils.runOnUiThread(new a(this, r100, e));
        LLog.e("NativeModule:LynxModuleWrapper", e.toString());
    L9:
        return this.f381308b;
    }

    public boolean hasAuthValidator() {
        if (this.f381311e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public LynxModule getModule() {
        return this.f381307a;
    }

    public String getName() {
        return this.f381310d;
    }

    public LynxContext getLynxContext(String r100) {
        WeakReference r101 = this.f381312f.a();
        LLog.d("NativeModule:LynxModuleWrapper", " GetLynxContext instanceId:" + r100 + ", contextRef: " + r101 + ", module: " + this.f381307a);
        if (r101 == null) goto L12;
        Context r102 = (Context) r101.get();
        if ((r102 instanceof LynxContext) == true) goto L7;
        if (r102 == null) goto L13;
        LLog.w("NativeModule:LynxModuleWrapper", "GetLynxContext , Context found but is not a LynxContext:".concat(r102.getClass().getName()));
        return null;
    L13:
        return null;
    L7:
        return (LynxContext) r102;
    L12:
        return null;
    }

    public LynxModuleWrapper(String r100, LynxModule r101) {
        this.f381310d = r100;
        this.f381307a = r101;
        this.f381308b = new ArrayList();
        this.f381309c = new ArrayList();
    }

    public boolean verify(String r100, String r101, JavaOnlyArray r102) {
        LynxModule.a r103 = this.f381311e;
        if (r103 != null) goto L7;
        return true;
    L7:
        return r103.a(r100, r101, r102);
    }
}
