package com.bytedance.common.jato.jit.invokable;

import com.bytedance.common.jato.jit.JitCompiler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public class JitSaveProfile implements InvocationHandler {
    public JitSaveProfile() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) {
        JitCompiler.forceSaveProfile();
        return Boolean.TRUE;
    }
}
