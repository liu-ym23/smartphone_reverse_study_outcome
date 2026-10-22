package wj2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.livesdk.livecommerce.ability.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f559969a;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onFail(int r100, String r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onSuccess() {
        Function0 r100 = this.f559969a;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    public b(Function0 r100) {
        this.f559969a = r100;
    }
}
