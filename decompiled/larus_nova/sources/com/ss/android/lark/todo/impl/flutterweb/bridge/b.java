package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.todo.impl.flutterweb.TodoWebPlugin;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<AbsChameleonPlugin> f444161c;

    public b(String r100, String r101, TodoWebPlugin r102) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        Intrinsics.checkNotNullParameter(r101, "callbackMethod");
        this.f444159a = r100;
        this.f444160b = r101;
        this.f444161c = new WeakReference(r102);
    }
}
