package com.ss.android.lark.compose.foundation.toast;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f417655a = 0;

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f417656a;

        public a(Handler r100) {
            Intrinsics.checkNotNullParameter(r100, "mHandler");
            this.f417656a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f417656a.handleMessage(r100);     // Catch: Throwable -> L5
            return true;
        L5:
            th = move-exception;
            th.printStackTrace();
            return true;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f417657a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f417657a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "mRunnable");
            this.f417657a = r100;
        }
    }

    static {
    }

    public static Object a(Object r100, String r101) {
        Class<?> r102 = r100.getClass();
    L4:
        if (r102 == null) goto L10;
        if (Intrinsics.areEqual(r102, Object.class) == true) goto L10;
        Field r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L9
    L11:
        if (r103 == null) goto L27;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        if (r103.isAccessible() == true) goto L15;
        r103.setAccessible(true);     // Catch: Exception -> L17
    L15:
        return r103.get(r100);
    L27:
        return null;
    L9:
        r102 = r102.getSuperclass();
    L10:
        r103 = null;
        goto L11
    }

    public static boolean b(Object r100, String r101, Object r102) {
        Class<?> r103 = r100.getClass();
    L3:
        if (r103 == null) goto L9;
        if (Intrinsics.areEqual(r103, Object.class) == true) goto L9;
        Field r104 = r103.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L8
    L10:
        if (r104 == null) goto L30;
    L19:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        if (Modifier.isFinal(r104.getModifiers()) == false) goto L15;
        Field r105 = Field.class.getDeclaredField("accessFlags");     // Catch: Exception -> L19
        r105.setAccessible(true);     // Catch: Exception -> L19
        r105.setInt(r104, r104.getModifiers() & (-17));     // Catch: Exception -> L19
    L15:
        if (r104.isAccessible() == true) goto L17;
        r104.setAccessible(true);     // Catch: Exception -> L19
    L17:
        r104.set(r100, r102);     // Catch: Exception -> L19
        return true;
    L30:
        return false;
    L8:
        r103 = r103.getSuperclass();
    L9:
        r104 = null;
        goto L10
    }
}
