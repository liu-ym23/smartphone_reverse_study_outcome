package rq2;

import com.bytedance.android.live.ai.api.IAiService;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements b {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static void a() {
        IAiService r100 = (IAiService) k.f(IAiService.class);
        if (r100 == null) goto L6;
        r100.getOhrService();
        return;
    }

    @Override // rq2.b
    public final boolean isEnable() {
        a();
        return false;
    }

    @Override // rq2.b
    public final void r3() {
        a();
    }

    @Override // rq2.b
    public final int mostUsedHand(boolean r100) {
        a();
        return 0;
    }
}
