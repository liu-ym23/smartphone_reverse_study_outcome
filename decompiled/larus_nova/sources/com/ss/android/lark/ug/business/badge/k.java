package com.ss.android.lark.ug.business.badge;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f444428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<k> f444429c;

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f444427a = r100;
        this.f444429c = new CopyOnWriteArrayList();
    }
}
