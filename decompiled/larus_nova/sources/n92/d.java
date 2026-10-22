package n92;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f518391a = null;

    static {
        f518391a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f2.b(R.string.ttlive_pin_cannot_cancel, 0);
    }
}
