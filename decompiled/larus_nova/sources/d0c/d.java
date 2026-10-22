package d0c;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes37.dex */
public final class d {
    public static final /* synthetic */ Context a(c r100) {
        return getContext(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context getContext(c r100) {
        if ((r100 instanceof Activity) == false) goto L6;
        return (Context) r100;
    L6:
        if ((r100 instanceof Service) == false) goto L9;
        return (Context) r100;
    L9:
        if ((r100 instanceof Fragment) == false) goto L12;
        return ((Fragment) r100).requireContext();
    L12:
        if ((r100 instanceof View) == false) goto L15;
        return ((View) r100).getContext();
    L15:
        if ((r100 instanceof a) == false) goto L19;
        return ((a) r100).getContext();
    L19:
        throw new IllegalStateException("UserScopeView should a instance of Activity, Service, Fragment or View. Found: " + r100.getClass());
    }
}
