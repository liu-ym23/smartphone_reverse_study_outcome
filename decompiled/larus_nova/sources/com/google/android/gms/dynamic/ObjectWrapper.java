package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes23.dex */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final Object f274635zza;

    private ObjectWrapper(Object r100) {
        this.f274635zza = r100;
    }

    @ResultIgnorabilityUnspecified
    public static <T> T unwrap(IObjectWrapper r100) {
        if ((r100 instanceof ObjectWrapper) == true) goto L5;
        IBinder r101 = r100.asBinder();
        Field[] r102 = r101.getClass().getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
        Field r105 = null;
        int r106 = 0;
    L7:
        if (r104 >= r103) goto L13;
        Field r107 = r102[r104];
        if (r107.isSynthetic() == true) goto L11;
        r106 = r106 + 1;
        r105 = r107;
    L11:
        r104 = r104 + 1;
        goto L7
    L13:
        if (r106 != 1) goto L28;
        Preconditions.checkNotNull(r105);
        if (r105.isAccessible() == true) goto L26;
        r105.setAccessible(true);
        return (T) r105.get(r101);
    L19:
        e = move-exception;
        throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
    L22:
        e = move-exception;
        throw new IllegalArgumentException("Binder object is null.", e);
    L26:
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    L28:
        throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + r102.length);
    L5:
        return (T) ((ObjectWrapper) r100).f274635zza;
    }

    public static <T> IObjectWrapper wrap(T r100) {
        return new ObjectWrapper(r100);
    }
}
