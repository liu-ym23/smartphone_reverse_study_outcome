package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
    }

    public static <T> T checkCompatWrapper(T r1) {
        if ((r1 instanceof CompatWrapped) == false) goto L7;
        T r0 = (T) ((CompatWrapped) r1).getWrapper();
        if (r0 == null) goto L7;
        return r0;
    L7:
        return r1;
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Application) checkCompatWrapper(super.instantiateApplication(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader r1, String r2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity) checkCompatWrapper(super.instantiateActivity(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader r1, String r2, Intent r3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Service) checkCompatWrapper(super.instantiateService(r1, r2, r3));
    }
}
