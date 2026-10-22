package u69;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r101 = true;
    L6:
        u.f(r100, !r101);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
