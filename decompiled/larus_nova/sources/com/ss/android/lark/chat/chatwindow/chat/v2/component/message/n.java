package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements mya.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<Class<? extends mya.g>, List<mya.g>> f414162a;

    @Override // mya.h
    public final <T extends mya.g> void a(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        Intrinsics.checkNotNullParameter(r101, "handlerInstance");
    }

    @Override // mya.h
    public final <T extends mya.g> T b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        return null;
    }

    @Override // mya.h
    public final <T extends mya.g> boolean d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        return false;
    }

    @Override // mya.h
    public final void e(mya.h r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
    }

    @Override // mya.h
    public final Map<Class<? extends mya.g>, List<mya.g>> f() {
        return this.f414162a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(Map<Class<? extends mya.g>, ? extends List<mya.g>> r100) {
        this.f414162a = r100;
    }

    @Override // mya.h
    public final <T extends mya.g> List<T> c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerApiClass");
        return new ArrayList();
    }
}
