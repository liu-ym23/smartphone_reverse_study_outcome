package dagger.hilt.android.internal;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes41.dex */
public final class Contexts {
    private Contexts() {
    }

    public static Application getApplication(Context r100) {
        if ((r100 instanceof Application) == true) goto L5;
        Context r101 = r100;
    L8:
        if ((r101 instanceof ContextWrapper) == false) goto L14;
        r101 = ((ContextWrapper) r101).getBaseContext();
        if ((r101 instanceof Application) == false) goto L8;
        return (Application) r101;
    L14:
        throw new IllegalStateException("Could not find an Application in the given context: " + r100);
    L5:
        return (Application) r100;
    }
}
