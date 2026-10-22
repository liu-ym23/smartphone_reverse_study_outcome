package com.ss.android.lark.integrator.todo.dependency;

import android.content.Context;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class s implements g7c.r {
    public s() {
    }

    @Override // g7c.r
    public Context getContext() {
        return LarkContext.getApplication().getApplicationContext();
    }
}
