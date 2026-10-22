package xd3;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.extensions.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C8216a f563284a = null;

    /* JADX INFO: renamed from: xd3.a$a, reason: collision with other inner class name */
    public static final class C8216a implements j {
        public C8216a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            s0.a(new qk.a(k.n(r100.optString("feedTabPause"), false)));
        }
    }

    static {
        f563284a = new C8216a();
    }
}
