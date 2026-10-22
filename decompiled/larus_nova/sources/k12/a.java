package k12;

import com.bytedance.android.scope.o;
import ft1.k;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements b, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // k12.b
    public final void trackPlayInfoForSlardar(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "slardarKey");
        Intrinsics.checkNotNullParameter(r101, "slardarInfo");
        int r102 = k.f478773a;
        HashMap r103 = new HashMap();
        r103.put(r100, r101);
        Unit r104 = Unit.INSTANCE;
        k.a(r103);
    }
}
