package k97;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.UnifiedResponsesKt;
import com.bytedance.android.live.network.response.d;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final d.b a(e r100, Extra r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "extra");
        Intrinsics.checkNotNullParameter(r102, "logId");
        d.b r103 = new d.b(r100, r101);
        ((Field) UnifiedResponsesKt.f83938a.getValue()).set(r103, r102);
        return r103;
    }
}
