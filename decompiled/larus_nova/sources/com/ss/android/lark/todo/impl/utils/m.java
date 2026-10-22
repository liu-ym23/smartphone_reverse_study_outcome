package com.ss.android.lark.todo.impl.utils;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class m {
    public static final int a(int r100) {
        return (int) UIUtils.sp2px(LarkContext.getApplication(), r100);
    }

    public static final float b(float r100) {
        return r100 * (UIHelper.sp2px(17.0f) / UIHelper.dp2px(17.0f));
    }
}
