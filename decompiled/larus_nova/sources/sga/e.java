package sga;

import android.view.View;
import com.obric.assistant.spi.office.OfficeSdkLazyInitServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OfficeSdkLazyInitServiceDelegate.f392901a.b() == true) goto L5;
        return;
    L5:
        r100.getViewTreeObserver().addOnPreDrawListener(new d(r100));
    }
}
