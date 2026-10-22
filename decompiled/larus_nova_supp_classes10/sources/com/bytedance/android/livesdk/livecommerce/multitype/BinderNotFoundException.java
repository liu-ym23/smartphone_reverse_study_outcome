package com.bytedance.android.livesdk.livecommerce.multitype;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
class BinderNotFoundException extends RuntimeException {
    public BinderNotFoundException(Class<?> r3) {
        super("Do you have registered {className}.class to the binder in the adapter/pool?".replace("{className}", r3.getSimpleName()));
    }
}
