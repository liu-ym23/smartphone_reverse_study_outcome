package po;

import com.bytedance.android.ec.window.base.dynamicview.common.e;
import com.bytedance.android.ec.window.base.dynamicview.common.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7215a f530017a = null;

    /* JADX INFO: renamed from: po.a$a, reason: collision with other inner class name */
    public static final class C7215a implements f {
        public C7215a() {
        }

        @Override // com.bytedance.android.ec.window.base.dynamicview.common.f
        public final e a(lo.a r100, List<? extends lo.a> r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            Intrinsics.checkNotNullParameter(r101, "siblings");
            c r102 = (c) uo.a.a(r100.a(), c.class);
            if (r102 == null) goto L6;
            List<String> r103 = r102.a();
            if (r103 == null) goto L6;
        L8:
            return new b(r103);
        L6:
            r103 = CollectionsKt.emptyList();
            goto L8
        }
    }

    static {
        f530017a = new C7215a();
    }
}
