package com.bytedance.mira.hook.proxy;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsMethodDelegate {
    public static final String TAG_AFTER = ">>";
    public static final String TAG_BEFORE = "<<";
    public static final String TAG_INVOKE = "invoke";

    public AbsMethodDelegate() {
    }

    public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
        return r103;
    }

    public Object beforeInvoke(Object r100, Method r101, Object[] r102) {
        return null;
    }
}
