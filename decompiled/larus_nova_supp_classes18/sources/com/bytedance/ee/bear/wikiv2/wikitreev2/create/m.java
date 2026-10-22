package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T, R> implements Function {
    public static final m<T, R> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object apply(Object r2) {
        TreeNode r3 = (TreeNode) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(!r3.isShortcut());
    }
}
