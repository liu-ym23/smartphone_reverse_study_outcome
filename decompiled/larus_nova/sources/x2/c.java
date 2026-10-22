package x2;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f562163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f562164b;

    public final Context getContext() {
        return this.f562164b.get();
    }

    public final int hashCode() {
        Context r100 = getContext();
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Arrays.hashCode(this.f562163a);
    L5:
        r101 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(getContext(), r101.getContext()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Arrays.equals(this.f562163a, r101.f562163a) == false) goto L13;
        return true;
    }

    public c(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "keys");
        this.f562163a = r101;
        this.f562164b = new WeakReference(r100);
    }
}
