package tq2;

import com.bytedance.android.livesdkapi.service.ICleanScreenManager;
import com.bytedance.android.scope.o;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a, o {
    public c() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // tq2.a
    public final void enterCleanScreen(int r100) {
        ICleanScreenManager r101 = (ICleanScreenManager) k.f(ICleanScreenManager.class);
        if (r101 == null) goto L6;
        r101.enterCleanScreen(6);
        return;
    }

    @Override // tq2.a
    public final void exitCleanScreen(int r100) {
        ICleanScreenManager r101 = (ICleanScreenManager) k.f(ICleanScreenManager.class);
        if (r101 == null) goto L6;
        r101.exitCleanScreen(6);
        return;
    }
}
