package wj2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements com.bytedance.android.livesdk.livecommerce.ability.e {
    public final /* synthetic */ Function0 a;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onFail(int r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onSuccess() {
        Function0 r0 = this.a;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public e(Function0 r1) {
        this.a = r1;
    }
}
