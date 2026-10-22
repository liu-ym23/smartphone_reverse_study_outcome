package m92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f512589a = null;

    static {
        f512589a = new f();
    }

    public f() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_pin_cannot_cancel, 0);
    }
}
