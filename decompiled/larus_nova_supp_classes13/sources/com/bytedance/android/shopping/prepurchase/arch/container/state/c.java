package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c<T> {
    T a();

    @Deprecated(message = "改方法继承了 LiveData 的 bug，详见[getValueImmediately]", replaceWith = @ReplaceWith(expression = "getValueImmediately()", imports = {}))
    T getValue();
}
