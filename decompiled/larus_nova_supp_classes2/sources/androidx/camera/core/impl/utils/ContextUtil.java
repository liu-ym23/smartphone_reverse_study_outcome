package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ContextUtil {

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static String getAttributionTag(Context r0) {
            return r0.getAttributionTag();
        }

        public static Context createAttributionContext(Context r0, String r1) {
            return r0.createAttributionContext(r1);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getDeviceId(Context r0) {
            return r0.getDeviceId();
        }

        public static Context createDeviceContext(Context r0, int r1) {
            return r0.createDeviceContext(r1);
        }
    }

    private ContextUtil() {
    }

    public static Context getApplicationContext(Context r4) {
        Context r0 = r4.getApplicationContext();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 34) goto L8;
        int r2 = Api34Impl.getDeviceId(r4);
        if (r2 == Api34Impl.getDeviceId(r0)) goto L8;
        r0 = Api34Impl.createDeviceContext(r0, r2);
    L8:
        if (r1 < 30) goto L13;
        String r5 = Api30Impl.getAttributionTag(r4);
        if (Objects.equals(r5, Api30Impl.getAttributionTag(r0)) == false) goto L12;
        return r0;
    L12:
        return Api30Impl.createAttributionContext(r0, r5);
    L13:
        return r0;
    }

    public static Application getApplicationFromContext(Context r1) {
        Context r2 = getApplicationContext(r1);
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L9;
        if ((r2 instanceof Application) == true) goto L13;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L13:
        return (Application) r2;
    L9:
        return null;
    }
}
