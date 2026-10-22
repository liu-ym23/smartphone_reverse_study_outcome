package io.noties.markwon.core.spans;

import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes41.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<TextView> f492372a;

    public v(TextView r100) {
        this.f492372a = new WeakReference(r100);
    }

    public static TextView a(Spanned r100) {
        v[] r101 = (v[]) r100.getSpans(0, r100.length(), v.class);
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if (r101.length <= 0) goto L7;
        return r101[0].f492372a.get();
    }
}
