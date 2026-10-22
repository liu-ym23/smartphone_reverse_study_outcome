package com.bytedance.ee.docsdk.impl.utils.keyboard;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProviderImpl;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes18.dex */
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

    public static KeyboardHeightProvider getImpl(Activity r100) {
        KeyboardHeightProvider r101 = keyboardHeightProviders.get(providerKey(r100));
        if (r101 != null) goto L5;
        r101 = innerCreate(r100);
        Log.i(TAG, "cache " + r100.getClass().getName() + r100.hashCode() + " to keyboardHeightProviders");
        cache(r100, r101);
    L5:
        showPopupWindowIfNeed(r101);
        return r101;
    }

    private static KeyboardHeightProvider innerCreate(Activity r100) {
        int r101 = providerKey(r100);
        KeyboardHeightProvider.Factory r102 = factories.get(r101);
        if (r102 != null) goto L6;
        r102 = new KeyboardHeightProviderFactory();
    L6:
        return r102.createKeyboardHeightProvider(r100);
    }

    private static int providerKey(Activity r100) {
        return r100.hashCode();
    }

    public static void removeCache(Activity r100) {
        Log.i(TAG, "remove cache " + r100.getClass().getName() + r100.hashCode() + " from keyboardHeightProviders");
        keyboardHeightProviders.remove(providerKey(r100));
    }

    private static void showPopupWindowIfNeed(KeyboardHeightProvider r100) {
        r100.restart();
    }

    public static void unregisterFactoryImpl(Activity r100) {
        factories.remove(providerKey(r100));
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider.Factory
    public KeyboardHeightProvider createKeyboardHeightProvider(Activity r100) {
        return new KeyboardHeightProviderImpl(r100);
    }

    public static void cache(Activity r100, KeyboardHeightProvider r101) {
        keyboardHeightProviders.put(providerKey(r100), r101);
    }

    public static void registerFactoryImpl(Activity r100, KeyboardHeightProvider.Factory r101) {
        factories.put(providerKey(r100), r101);
    }
}
