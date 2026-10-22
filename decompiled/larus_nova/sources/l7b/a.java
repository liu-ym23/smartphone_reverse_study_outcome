package l7b;

import android.app.Dialog;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, WeakReference<Dialog>> f507901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, WeakReference<PopupWindow>> f507902b = null;

    static {
        f507901a = new HashMap(8);
        f507902b = new HashMap(8);
    }

    public static void a(Dialog r100) {
        if (r100 == null) goto L12;
        Map<Integer, WeakReference<Dialog>> r101 = f507901a;
        HashMap r102 = (HashMap) r101;
        r102.put(Integer.valueOf(r100.hashCode()), new WeakReference(r100));
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.entrySet().iterator();
    L5:
        if (r104.hasNext() == false) goto L18;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (((WeakReference) r105.getValue()).get() == null) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L5;
        r103.put(r105.getKey(), r105.getValue());
        goto L5
    L9:
        r106 = false;
        goto L10
    L18:
        return;
    }
}
