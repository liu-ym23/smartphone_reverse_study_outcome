package pk2;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements a {
    public final qk2.a a;

    public c() {
        qk2.a r0 = new qk2.a();
        Intrinsics.checkNotNullParameter(r0, "remoteSource");
        this.a = r0;
    }

    @Override // pk2.a
    public final Observable<ECCurrentPromotion> a(com.bytedance.android.livesdk.livecommerce.room.model.e r11, boolean r12, boolean r13, boolean r14, s r15, Map<String, String> r16, String r17, uj2.c r18) {
        Intrinsics.checkNotNullParameter(r11, "roomInfo");
        return this.a.a(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
