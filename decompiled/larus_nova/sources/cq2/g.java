package cq2;

import android.view.View;
import com.bytedance.android.live.browser.IBrowserService;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements c {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // cq2.c
    public final void Y2(View r110, String r111, String r112, JSONObject r113, JSONObject r114, JSONObject r115, boolean r116) {
        ((IBrowserService) k.n(IBrowserService.class)).reportCustomV2(r110, r111, r112, r113, r114, r115, null, r116 ? 1 : 0);
    }
}
