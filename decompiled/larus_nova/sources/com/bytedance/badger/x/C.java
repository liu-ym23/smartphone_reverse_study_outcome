package com.bytedance.badger.x;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.bytedance.badger.BadgerCore;

/* JADX INFO: loaded from: classes47.dex */
public abstract class C extends Binder implements D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f199363a = 0;

    public static D a(IBinder r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        BadgerCore.Companion.getClass();
        IInterface r101 = r100.queryLocalInterface(com.bytedance.badger.j.b(2418618557650235769L));
        if (r101 == null) goto L12;
        if ((r101 instanceof D) == false) goto L12;
        return (D) r101;
    L12:
        return new B(r100);
    }
}
