package pj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.repository.dto.DividingLineDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements com.bytedance.android.shopping.store.hybridproduct.extension.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7199a f529455c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUrlModel f529456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECUrlModel f529457b;

    /* JADX INFO: renamed from: pj3.a$a, reason: collision with other inner class name */
    public static final class C7199a {
        public C7199a() {
        }

        public static a a(DividingLineDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            a r101 = new a();
            r101.f529456a = r100.getImage();
            r101.f529457b = r100.getTopBarTitleImage();
            return r101;
        }
    }

    public a() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 10;
    }

    static {
        f529455c = new C7199a();
    }
}
