package y6a;

import android.view.View;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f566420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f566421b;

    public r(UIBody.UIBodyView r100) {
        this.f566420a = r100;
    }

    @Override // y6a.f
    public final void a(u0 r100) {
        UIThreadUtils.runOnUiThreadImmediately(new q(this, r100));
    }
}
