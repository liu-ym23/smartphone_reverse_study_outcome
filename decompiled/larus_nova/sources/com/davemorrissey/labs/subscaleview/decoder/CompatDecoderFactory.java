package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes22.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    @Override // com.davemorrissey.labs.subscaleview.decoder.DecoderFactory
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.bitmapConfig != null) goto L7;
        return this.clazz.newInstance();
    L7:
        return this.clazz.getConstructor(new Class[]{Bitmap.Config.class}).newInstance(new Object[]{this.bitmapConfig});
    }

    public CompatDecoderFactory(Class<? extends T> r100) {
        this(r100, null);
    }

    public CompatDecoderFactory(Class<? extends T> r100, Bitmap.Config r101) {
        this.clazz = r100;
        this.bitmapConfig = r101;
    }
}
