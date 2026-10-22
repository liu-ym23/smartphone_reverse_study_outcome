package v19;

import androidx.activity.result.ActivityResultLauncher;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final <T> void a(ActivityResultLauncher<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.launch(r101);
        Iterator r102 = ((ArrayList) a.f552443a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((q5) r102.next()).gotoToSystemPage();
        goto L4
    }
}
