package fjc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class d {
    public static Activity a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Activity.class.isInstance(r100) == false) goto L10;
        return (Activity) r100;
    L10:
        if (ContextWrapper.class.isInstance(r100) == true) goto L12;
        return null;
    L12:
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static void b(tic.a r100, Object r101) {
        if (r100 == null) goto L14;
        Object r102 = null;
        if (Map.class.isInstance(null) == false) goto L7;
        r102 = Map.class.cast(null);     // Catch: Exception -> L11
    L7:
        Map r103 = (Map) r102;     // Catch: Exception -> L11
        if (r103 == null) goto L15;
        r103.put("release_reason", r101);     // Catch: Exception -> L11
        return;
    L15:
        return;
    L16:
        return;
    }
}
