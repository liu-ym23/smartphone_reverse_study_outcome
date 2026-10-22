package com.larus.im.internal.jni;

import com.larus.im.depend.CallByNative;

/* JADX INFO: loaded from: classes4.dex */
class FlowIMSDKClassLoader {
    public FlowIMSDKClassLoader() {
    }

    @CallByNative
    public static ClassLoader getClassLoader() {
        return FlowIMSDKClassLoader.class.getClassLoader();
    }
}
