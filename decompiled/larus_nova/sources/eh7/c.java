package eh7;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f472664a;

    public final Activity getActivity() {
        Activity r100 = this.f472664a.getActivity();
        if (r100 != null) goto L12;
        Fragment r101 = this.f472664a.f472666b;
        if (r101 == null) goto L7;
        r100 = r101.getActivity();
    L8:
        if (r100 != null) goto L12;
        throw new RuntimeException("Can not find activity");
    L7:
        r100 = null;
    L12:
        return r100;
    }

    public final Context getContext() {
        if (Build.VERSION.SDK_INT < 23) goto L15;
        Context r100 = this.f472664a.getActivity();
        if (r100 != null) goto L17;
        Fragment r101 = this.f472664a.f472666b;
        if (r101 == null) goto L10;
        r100 = r101.getContext();
    L11:
        if (r100 != null) goto L17;
        throw new RuntimeException("Can not find context");
    L10:
        r100 = null;
    L17:
        return r100;
    L15:
        r100 = this.f472664a.getActivity();
        if (r100 != null) goto L17;
        throw new RuntimeException("Can not find context");
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f472664a = r100;
    }
}
