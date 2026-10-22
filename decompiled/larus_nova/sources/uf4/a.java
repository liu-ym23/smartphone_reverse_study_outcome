package uf4;

import android.app.Application;
import com.bytedance.commerce.base.reflect.ReflectException;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static Application a() {
        Class r100 = zf4.a.a();     // Catch: Exception -> L5
        return (Application) new zf4.a(r100, r100).call("currentApplication").f571756b;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    static {
    }
}
