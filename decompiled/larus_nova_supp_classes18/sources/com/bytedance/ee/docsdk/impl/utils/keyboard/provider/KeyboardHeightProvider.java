package com.bytedance.ee.docsdk.impl.utils.keyboard.provider;

import android.app.Activity;
import android.content.res.Configuration;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightProviderFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface KeyboardHeightProvider {
    public static final float RAW_HEIGHT_LANDSCAPE_DIP = 200.0f;
    public static final float RAW_HEIGHT_PORTRAIT_DIP = 250.0f;

    public static abstract class Factory {
        public Factory() {
        }

        public abstract KeyboardHeightProvider createKeyboardHeightProvider(Activity r1);

        public static KeyboardHeightProvider get(Activity r0) {
            return KeyboardHeightProviderFactory.getImpl(r0);
        }

        public static void unregisterFactory(Activity r0) {
            KeyboardHeightProviderFactory.unregisterFactoryImpl(r0);
        }

        public static void registerFactory(Activity r0, Factory r1) {
            KeyboardHeightProviderFactory.registerFactoryImpl(r0, r1);
        }
    }

    void addKeyboardHeightObserver(KeyboardHeightObserver r1);

    void addKeyboardHeightObserverNoDelay(KeyboardHeightObserver r1);

    int getKeyboardTop();

    int getVisibleKeyboardHeight();

    boolean isKeyboardShowing();

    int keyBoardRawHeight();

    int keyBoardRawHeightWithOrientation(int r1);

    void onConfigurationChanged(Configuration r1, boolean r2);

    void removeKeyboardHeightObserver(KeyboardHeightObserver r1);

    void removeKeyboardHeightObserverNoDelay(KeyboardHeightObserver r1);

    void restart();

    void setDelayedDuration(Long r1);
}
