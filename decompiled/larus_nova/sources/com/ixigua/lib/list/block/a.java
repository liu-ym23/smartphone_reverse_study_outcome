package com.ixigua.lib.list.block;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f278517e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Block<?>> f278518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<Block<?>>, LinkedList<Block<?>>> f278519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f278520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f278521d;

    /* JADX INFO: renamed from: com.ixigua.lib.list.block.a$a, reason: collision with other inner class name */
    public static final class C3882a {
    }

    static {
    }

    public final Context getContext() {
        return this.f278520c;
    }

    public a(Context r100) {
        this.f278520c = r100;
        this.f278521d = 20;
        this.f278518a = new LinkedList();
        this.f278519b = new HashMap();
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == true) goto L7;
        LayoutInflater.from(r100);
        new AsyncLayoutInflater(r100);
        return;
    L7:
        throw new RuntimeException("BlockManager must created on main thread");
    }
}
