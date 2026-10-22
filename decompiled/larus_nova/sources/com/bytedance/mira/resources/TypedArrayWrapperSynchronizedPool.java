package com.bytedance.mira.resources;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.TypedArrayWrapper;
import android.os.Build;
import android.util.Pools;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public class TypedArrayWrapperSynchronizedPool extends Pools.SynchronizedPool<TypedArray> {
    private static boolean isOpen;
    private WeakReference<Resources> resourcesHolder;

    static {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        boolean r100 = true;
    L6:
        isOpen = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public TypedArray acquire() {
        TypedArray r100 = (TypedArray) super.acquire();
        if (isOpen == true) goto L5;
        return r100;
    L5:
        Resources r101 = this.resourcesHolder.get();
        if (r101 != null) goto L8;
        return r100;
    L8:
        if (r100 != null) goto L12;
        return new TypedArrayWrapper(r101);
    L12:
        if ((r100 instanceof TypedArrayWrapper) == false) goto L15;
        return r100;
    L15:
        return new TypedArrayWrapper(r101);
    }

    /* JADX INFO: renamed from: acquire, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8520acquire() {
        return acquire();
    }

    public TypedArrayWrapperSynchronizedPool(int r100, Resources r101) {
        super(r100);
        this.resourcesHolder = new WeakReference(r101);
    }
}
