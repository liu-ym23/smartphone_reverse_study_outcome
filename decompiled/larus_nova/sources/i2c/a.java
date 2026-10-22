package i2c;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final LifecycleOwner a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof LifecycleOwner) == false) goto L6;
        return (LifecycleOwner) r100;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        Context r101 = ((ContextWrapper) r100).getBaseContext();
        if (r101 == null) goto L11;
        return a(r101);
    L11:
        return null;
    }
}
