package com.bytedance.ee.docsdk.impl.utils.keyboard;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProviderImpl;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class KeyboardHeightProviderFactory extends KeyboardHeightProvider.Factory {
    private static final String TAG = "InsetsBseKBH#Provider";
    private static final SparseArray<KeyboardHeightProvider.Factory> factories = null;
    private static final SparseArray<KeyboardHeightProvider> keyboardHeightProviders = null;

    static {
        factories = new SparseArray();
        keyboardHeightProviders = new SparseArray();
    }

    public KeyboardHeightProviderFactory() {
    }

    public static KeyboardHeightProvider getImpl(Activity r3) {
        KeyboardHeightProvider r0 = keyboardHeightProviders.get(providerKey(r3));
        if (r0 != null) goto L5;
        r0 = innerCreate(r3);
        Log.i(TAG, "cache " + r3.getClass().getName() + r3.hashCode() + " to keyboardHeightProviders");
        cache(r3, r0);
    L5:
        showPopupWindowIfNeed(r0);
        return r0;
    }

    private static KeyboardHeightProvider innerCreate(Activity r2) {
        int r0 = providerKey(r2);
        KeyboardHeightProvider.Factory r1 = factories.get(r0);
        if (r1 != null) goto L6;
        r1 = new KeyboardHeightProviderFactory();
    L6:
        return r1.createKeyboardHeightProvider(r2);
    }

    private static int providerKey(Activity r0) {
        return r0.hashCode();
    }

    public static void removeCache(Activity r2) {
        Log.i(TAG, "remove cache " + r2.getClass().getName() + r2.hashCode() + " from keyboardHeightProviders");
        keyboardHeightProviders.remove(providerKey(r2));
    }

    private static void showPopupWindowIfNeed(KeyboardHeightProvider r0) {
        r0.restart();
    }

    public static void unregisterFactoryImpl(Activity r1) {
        factories.remove(providerKey(r1));
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider.Factory
    public KeyboardHeightProvider createKeyboardHeightProvider(Activity r2) {
        return new KeyboardHeightProviderImpl(r2);
    }

    public static void cache(Activity r1, KeyboardHeightProvider r2) {
        keyboardHeightProviders.put(providerKey(r1), r2);
    }

    public static void registerFactoryImpl(Activity r1, KeyboardHeightProvider.Factory r2) {
        factories.put(providerKey(r1), r2);
    }
}
