package jc1;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BundleCompat;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f498078a;

    public g(Object r100) {
        this.f498078a = r100;
    }

    public static <T> T a(Bundle r100, String r101) {
        IBinder r102 = BundleCompat.getBinder(r100, r101);
        if ((r102 instanceof g) == false) goto L7;
        return (T) ((g) r102).f498078a;
    L7:
        return null;
    L12:
        return null;
    }
}
