package pj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.repository.dto.DividingLineDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements com.bytedance.android.shopping.store.hybridproduct.extension.d {
    public static final C0153a c = null;
    public ECUrlModel a;
    public ECUrlModel b;

    /* JADX INFO: renamed from: pj3.a$a, reason: collision with other inner class name */
    public static final class C0153a {
        public C0153a() {
        }

        public static a a(DividingLineDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "dto");
            a r0 = new a();
            r0.a = r2.getImage();
            r0.b = r2.getTopBarTitleImage();
            return r0;
        }
    }

    public a() {
    }

    public final int modelType() {
        return 10;
    }

    static {
        c = new C0153a();
    }
}
