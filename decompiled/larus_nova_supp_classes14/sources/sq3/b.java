package sq3;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b extends com.bytedance.android.window.shop.repository.tab.entity.f {
    public static final /* synthetic */ int n = 0;
    public boolean j;
    public boolean k;
    public boolean l;
    public final h m;

    public static final class a {
    }

    static {
    }

    public b(h r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        super(303);
        this.m = r3;
        ((WindowV2ProductItemVO) r3).C.b(wn.a.f, 303);
    }
}
