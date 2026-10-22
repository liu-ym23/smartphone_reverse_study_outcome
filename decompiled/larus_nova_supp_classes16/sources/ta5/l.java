package ta5;

import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l extends k {
    public final Fragment b;

    @Override // ta5.k
    public final List<Fragment> k() {
        if (this.b.isAdded() == true) goto L7;
        return null;
    L7:
        return this.b.getChildFragmentManager().getFragments();
    }

    public l(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(0);
        this.b = r2;
    }
}
