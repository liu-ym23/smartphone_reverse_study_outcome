package com.relax;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxNativeInvocationHandler implements InvocationHandler {
    static Handler mHandler;
    private long nativePtr;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f404558a;

        @Override // java.lang.Runnable
        public final void run() {
            RelaxNativeInvocationHandler.access$000(this.f404558a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(long r100) {
            this.f404558a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f404559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RelaxNativeInvocationHandler f404560b;

        @Override // java.lang.Runnable
        public final void run() {
            RelaxNativeInvocationHandler.access$100(this.f404560b, this.f404559a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(RelaxNativeInvocationHandler r100, long r101) {
            this.f404560b = r100;
            this.f404559a = r101;
        }
    }

    private static native void nativeCallTask(long r100);

    private native void nativeDestroy(long r100);

    private native Object nativeInvoke(long r100, String r101, String[] r102, boolean[] r103, Object[] r104);

    private static native void nativePrepareProps(Object r100);

    static {
        mHandler = new Handler(Looper.myLooper());
    }

    public void destroy() {
        long r100 = this.nativePtr;
        if (r100 == 0) goto L6;
        mHandler.post(new b(this, r100));
        this.nativePtr = 0;
        return;
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public RelaxNativeInvocationHandler(long r100) {
        this.nativePtr = r100;
    }

    public static /* synthetic */ void access$000(long r100) {
        nativeCallTask(r100);
    }

    public static String[] getJNISignature(Method r100) {
        ArrayList r101 = new ArrayList();
        Class<?>[] r102 = r100.getParameterTypes();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(getJNIType(r102[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        r101.add(getJNIType(r100.getReturnType()));
        return (String[]) r101.toArray(new String[0]);
    }

    private static String getJNIType(Class<?> r100) {
        if (r100 != Void.TYPE) goto L7;
        return "V";
    L7:
        if (r100 != Integer.TYPE) goto L11;
        return "I";
    L11:
        if (r100 != Boolean.TYPE) goto L15;
        return "Z";
    L15:
        if (r100 != Byte.TYPE) goto L19;
        return "B";
    L19:
        if (r100 != Character.TYPE) goto L23;
        return "C";
    L23:
        if (r100 != Short.TYPE) goto L27;
        return ExifInterface.LATITUDE_SOUTH;
    L27:
        if (r100 != Long.TYPE) goto L31;
        return "J";
    L31:
        if (r100 != Float.TYPE) goto L35;
        return FaceService.girlLabel;
    L35:
        if (r100 != Double.TYPE) goto L39;
        return "D";
    L39:
        if (r100.isArray() == false) goto L43;
        return r100.getName().replace('.', '/');
    L43:
        return r100.getName().replace('.', '/');
    }

    public static void prepareProps(Object r100) {
        nativePrepareProps(r100);
    }

    public static void runTask(long r100) {
        mHandler.post(new a(r100));
    }

    public static /* synthetic */ void access$100(RelaxNativeInvocationHandler r100, long r101) {
        r100.nativeDestroy(r101);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r110) throws Throwable {
        int r102 = l.f404652a;
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        int r103 = r101.getParameterTypes().length + 1;
        boolean[] r104 = new boolean[r103];
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L6;
        r104[r105] = false;
        r105 = r105 + 1;
        goto L3
    L6:
        return nativeInvoke(this.nativePtr, r101.getName(), getJNISignature(r101), r104, r110);
    }
}
