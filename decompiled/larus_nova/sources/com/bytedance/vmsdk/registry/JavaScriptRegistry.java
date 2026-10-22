package com.bytedance.vmsdk.registry;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaScriptObject;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.bytedance.vmsdk.worker.VmSdkException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public class JavaScriptRegistry {
    HashMap<Class<? extends com.bytedance.vmsdk.registry.a>, com.bytedance.vmsdk.registry.a> mFunctionMap;
    HashMap<Class<? extends com.bytedance.vmsdk.registry.b>, com.bytedance.vmsdk.registry.b> mModuleMap;

    /* JADX INFO: loaded from: classes22.dex */
    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsWorker f272510a;

        public a(JsWorker r100) {
            this.f272510a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            JavaOnlyArray r103 = JavaOnlyArray.of(r102);
            Class<?>[] r104 = r101.getExceptionTypes();
            int r105 = r104.length;
            boolean r106 = false;
            int r107 = 0;
        L3:
            if (r107 >= r105) goto L9;
            if (VmSdkException.class == r104[r107]) goto L6;
            r107 = r107 + 1;
            goto L3
        L6:
            r106 = true;
        L9:
            return this.f272510a.invokeJavaScriptFunction(r101.getName(), r103, JavaScriptRegistry.returnTypeToChar(r101.getReturnType()), r106);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsWorker f272511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f272512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<? extends com.bytedance.vmsdk.registry.b> f272513c;

        public b(JsWorker r100, Class<? extends com.bytedance.vmsdk.registry.b> r101) {
            this.f272511a = r100;
            this.f272513c = r101;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            JavaOnlyArray r103 = JavaOnlyArray.of(r102);
            Class<?>[] r104 = r101.getExceptionTypes();
            int r105 = r104.length;
            int r106 = 0;
        L3:
            if (r106 >= r105) goto L8;
            if (VmSdkException.class == r104[r106]) goto L8;
            r106 = r106 + 1;
        L8:
            JsWorker r107 = this.f272511a;
            if (TextUtils.isEmpty(this.f272512b) == false) goto L15;
            String r108 = ((JavaScriptObject) this.f272513c.getAnnotation(JavaScriptObject.class)).name();
            if ("".equals(r108) == false) goto L13;
            r108 = this.f272513c.getSimpleName();
        L13:
            this.f272512b = r108;
        L15:
            return r107.invokeJavaScriptModule(this.f272512b, r101.getName(), r103, JavaScriptRegistry.returnTypeToChar(r101.getReturnType()));
        }
    }

    public JavaScriptRegistry() {
        this.mModuleMap = new HashMap();
        this.mFunctionMap = new HashMap();
    }

    private static char commonTypeToChar(Class r100) {
        if (r100 != Boolean.TYPE) goto L7;
        return 'z';
    L7:
        if (r100 != Boolean.class) goto L11;
        return Matrix.MATRIX_TYPE_ZERO;
    L11:
        if (r100 != Integer.TYPE) goto L15;
        return 'i';
    L15:
        if (r100 != Integer.class) goto L19;
        return 'I';
    L19:
        if (r100 != Short.TYPE) goto L23;
        return 's';
    L23:
        if (r100 != Short.class) goto L27;
        return 'S';
    L27:
        if (r100 != Double.TYPE) goto L31;
        return Directory.UNIX_ID;
    L31:
        if (r100 != Double.class) goto L35;
        return 'D';
    L35:
        if (r100 != Float.TYPE) goto L39;
        return 'f';
    L39:
        if (r100 != Float.class) goto L43;
        return 'F';
    L43:
        if (r100 != String.class) goto L47;
        return OthersPermission.STICKY;
    L47:
        if (r100 != Byte.TYPE) goto L51;
        return BlockDevice.UNIX_ID;
    L51:
        if (r100 != Byte.class) goto L55;
        return 'B';
    L55:
        if (r100 != Long.TYPE) goto L59;
        return Symlink.UNIX_ID;
    L59:
        if (r100 != Long.class) goto L63;
        return Matrix.MATRIX_TYPE_RANDOM_LT;
    L63:
        if (r100 != byte[].class) goto L66;
        return 'a';
    L66:
        return 0;
    }

    public static char returnTypeToChar(Class r100) {
        char r101 = commonTypeToChar(r100);
        if (r101 == 0) goto L6;
        return r101;
    L6:
        if (r100 != Void.TYPE) goto L10;
        return 'v';
    L10:
        if (r100 != WritableMap.class) goto L14;
        return 'M';
    L14:
        if (r100 != WritableArray.class) goto L18;
        return 'A';
    L18:
        throw new RuntimeException("Got unknown return class: ".concat(r100.getSimpleName()));
    }

    public <T extends com.bytedance.vmsdk.registry.a> T getJavaScriptFunction(JsWorker r100, Class<? extends com.bytedance.vmsdk.registry.a> r101) {
        T r102 = (T) this.mFunctionMap.get(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        T r103 = (T) Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new a(r100));
        this.mFunctionMap.put(r101, r103);
        return r103;
    }

    public <T extends com.bytedance.vmsdk.registry.b> T getJavaScriptModule(JsWorker r100, Class<? extends com.bytedance.vmsdk.registry.b> r101) {
        T r102 = (T) this.mModuleMap.get(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        T r103 = (T) Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new b(r100, r101));
        this.mModuleMap.put(r101, r103);
        return r103;
    }
}
