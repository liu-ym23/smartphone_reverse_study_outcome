package xd3;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.extensions.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final C0240a a = null;

    /* JADX INFO: renamed from: xd3.a$a, reason: collision with other inner class name */
    public static final class C0240a implements j {
        public C0240a() {
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            s0.a(new qk.a(k.n(r2.optString("feedTabPause"), false)));
        }
    }

    static {
        a = new C0240a();
    }
}
