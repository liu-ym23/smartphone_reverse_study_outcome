package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T, R> f241419a = null;

    static {
        f241419a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        TreeNode r101 = (TreeNode) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Boolean.valueOf(!r101.isShortcut());
    }
}
