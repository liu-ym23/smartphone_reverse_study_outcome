package g15;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Singleton
public final class a implements rw4.d {
    @Inject
    public a() {
    }

    @Override // rw4.d
    public final void Z(rw4.c r2) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
    }

    @Override // rw4.d
    public final void j1(rw4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }
}
