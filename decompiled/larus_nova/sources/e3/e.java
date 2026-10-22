package e3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import f2.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final Activity a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return k.b();
    }

    public static final Context b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Activity r101 = a(r100);
        if (r101 != null) goto L17;
        View r102 = r100.getEngineView();
        if (r102 == null) goto L8;
        Context r103 = r102.getContext();
    L9:
        if (r103 != null) goto L14;
        IHostContextDepend r104 = r4.a.f535974a;
        IHostContextDepend r105 = r4.a.f535974a;
        if (r105 != null) goto L16;
        return null;
    L16:
        return r105.getApplicationContext();
    L14:
        return r103;
    L8:
        r103 = null;
        goto L9
    L17:
        return r101;
    }
}
