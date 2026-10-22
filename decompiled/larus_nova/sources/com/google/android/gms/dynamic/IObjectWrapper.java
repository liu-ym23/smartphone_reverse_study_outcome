package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes23.dex */
public interface IObjectWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IObjectWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static IObjectWrapper asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if ((r101 instanceof IObjectWrapper) == false) goto L10;
            return (IObjectWrapper) r101;
        L10:
            return new zzb(r100);
        }
    }
}
