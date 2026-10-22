package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.conditional.access.display.CustomDisplayModel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T, R> f418181a = null;

    static {
        f418181a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        CustomDisplayModel r101 = (CustomDisplayModel) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getConfig();
    }
}
