package w43;

import android.view.View;
import com.larus.nova.R;
import k43.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f558253b;

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "debugView");
        super(r100);
        this.f558253b = r100;
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L4;
        this.f558253b.setBackgroundResource(R.color.buynow_FFA526);
        return;
    L4:
        this.f558253b.setBackgroundResource(R.color.buynow_FE496A);
    }
}
