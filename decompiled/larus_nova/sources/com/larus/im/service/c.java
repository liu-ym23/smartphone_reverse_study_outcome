package com.larus.im.service;

import com.larus.im.callback.IMError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f350825a;

    public static final class a {
    }

    static {
    }

    public abstract void a(IMError r100);

    public abstract Object b(ouc.d0 r100, Continuation<? super Unit> r101);

    public c(int r100) {
        this.f350825a = r100;
    }
}
