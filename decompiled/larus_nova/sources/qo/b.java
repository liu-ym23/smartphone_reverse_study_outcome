package qo;

import com.bytedance.android.ec.window.base.dynamicview.common.e;
import com.bytedance.android.ec.window.base.dynamicview.common.f;
import com.google.gson.Gson;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f534143a = null;

    public static final class a implements f {
        public a() {
        }

        @Override // com.bytedance.android.ec.window.base.dynamicview.common.f
        public final e a(lo.a r100, List<? extends lo.a> r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            Intrinsics.checkNotNullParameter(r101, "siblings");
            d r102 = (d) uo.a.a(r100.a(), d.class);
            if (r102 == null) goto L6;
            List<String> r103 = r102.a();
            if (r103 == null) goto L6;
        L8:
            return new c(r103);
        L6:
            r103 = CollectionsKt.emptyList();
            goto L8
        }
    }

    static {
        new Gson();
        f534143a = new a();
    }
}
