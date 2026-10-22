package com.obric.capabilitykit.corecommon;

import android.os.IInterface;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/IInterface;", "Ljava/lang/reflect/InvocationHandler;", PickerReporterConstants.KEY.TARGET, "tag", "", "targetClass", "Ljava/lang/Class;", "(Landroid/os/IInterface;Ljava/lang/String;Ljava/lang/Class;)V", "Landroid/os/IInterface;", "getDefaultReturnValue", "", e.f25671s, "Ljava/lang/reflect/Method;", AbsMethodDelegate.TAG_INVOKE, "proxy", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinderExceptionHandlerProxy<T extends IInterface> implements InvocationHandler {
    public static final Companion Companion = null;
    private final String tag;
    private final T target;
    private final Class<T> targetClass;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy$Companion;", "", "()V", "createProxyInstance", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/IInterface;", "api", "tag", "", "(Landroid/os/IInterface;Ljava/lang/String;)Landroid/os/IInterface;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final /* synthetic */ <T extends IInterface> T createProxyInstance(T r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "api");
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            ClassLoader r102 = IInterface.class.getClassLoader();     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            Object r103 = Proxy.newProxyInstance(r102, new Class[]{IInterface.class}, new BinderExceptionHandlerProxy(r100, r101, IInterface.class));     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            return (T) r103;
        L5:
            th = move-exception;
            if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L9;
            r100.getClass().toString();
        L9:
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinderExceptionHandlerProxy(T r100, String r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "targetClass");
        this.target = r100;
        this.tag = r101;
        this.targetClass = r102;
    }

    private final Object getDefaultReturnValue(Method r100) {
        Class<?> r101 = r100.getReturnType();
        if (Intrinsics.areEqual(r101, Boolean.TYPE) == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (Intrinsics.areEqual(r101, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (Intrinsics.areEqual(r101, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (Intrinsics.areEqual(r101, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (Intrinsics.areEqual(r101, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (Intrinsics.areEqual(r101, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (Intrinsics.areEqual(r101, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (Intrinsics.areEqual(r101, Double.TYPE) == false) goto L27;
        return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L27:
        if (Intrinsics.areEqual(r101, Void.class) == true) goto L39;
        return null;
    L39:
        return Unit.INSTANCE;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
    L17:
        th = move-exception;
        r101.getName();
        ExceptionsKt.stackTraceToString(th);
        return getDefaultReturnValue(r101);
    L4:
        if (Intrinsics.areEqual(r101.getDeclaringClass(), this.targetClass) == true) goto L10;
        T r103 = this.target;     // Catch: Throwable -> L17
        if (r102 != null) goto L21;
        r102 = new Object[0];     // Catch: Throwable -> L17
    L21:
        return r101.invoke(r103, Arrays.copyOf(r102, r102.length));
    L10:
        if (this.target.asBinder().isBinderAlive() == false) goto L15;
        T r104 = this.target;     // Catch: Throwable -> L17
        if (r102 != null) goto L22;
        r102 = new Object[0];     // Catch: Throwable -> L17
    L22:
        return r101.invoke(r104, Arrays.copyOf(r102, r102.length));
    L15:
        r101.getName();     // Catch: Throwable -> L17
        return getDefaultReturnValue(r101);
    }
}
