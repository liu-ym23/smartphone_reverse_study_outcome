package com.bytedance.ee.docsdk.impl.utils.keyboard.provider;

import android.app.Activity;
import android.content.res.Configuration;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightProviderFactory;

/* JADX INFO: loaded from: classes18.dex */
public interface KeyboardHeightProvider {
    public static final float RAW_HEIGHT_LANDSCAPE_DIP = 200.0f;
    public static final float RAW_HEIGHT_PORTRAIT_DIP = 250.0f;

    public static abstract class Factory {
        public Factory() {
        }

        public abstract KeyboardHeightProvider createKeyboardHeightProvider(Activity r100);

        public static KeyboardHeightProvider get(Activity r100) {
            return KeyboardHeightProviderFactory.getImpl(r100);
        }

        public static void unregisterFactory(Activity r100) {
            KeyboardHeightProviderFactory.unregisterFactoryImpl(r100);
        }

        public static void registerFactory(Activity r100, Factory r101) {
            KeyboardHeightProviderFactory.registerFactoryImpl(r100, r101);
        }
    }

    void addKeyboardHeightObserver(KeyboardHeightObserver r100);

    void addKeyboardHeightObserverNoDelay(KeyboardHeightObserver r100);

    int getKeyboardTop();

    int getVisibleKeyboardHeight();

    boolean isKeyboardShowing();

    int keyBoardRawHeight();

    int keyBoardRawHeightWithOrientation(int r100);

    void onConfigurationChanged(Configuration r100, boolean r101);

    void removeKeyboardHeightObserver(KeyboardHeightObserver r100);

    void removeKeyboardHeightObserverNoDelay(KeyboardHeightObserver r100);

    void restart();

    void setDelayedDuration(Long r100);
}
