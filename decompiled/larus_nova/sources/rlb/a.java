package rlb;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes36.dex */
public class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends T> f538502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap.Config f538503b;

    @Override // rlb.b
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.f538503b != null) goto L7;
        return this.f538502a.newInstance();
    L7:
        return this.f538502a.getConstructor(new Class[]{Bitmap.Config.class}).newInstance(new Object[]{this.f538503b});
    }

    public a(Class<? extends T> r100) {
        this.f538502a = r100;
        this.f538503b = null;
    }
}
