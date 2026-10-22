package fm;

import android.content.Context;
import com.bytedance.android.ec.core.utils.b1;
import com.bytedance.android.ec.core.utils.i0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements j {
    public b() {
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        i0 r101 = i0.f45612f;
        WeakHashMap<Context, b1> r102 = i0.f45608b;
        ECAppInfoService r103 = ECAppInfoService.f48114e;
        r102.put(r103.getApplicationContext(), null);
        Context r104 = r103.getApplicationContext();
        r101.getClass();
        i0.b(r104);
    }
}
