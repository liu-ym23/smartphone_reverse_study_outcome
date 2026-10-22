package vp3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b implements QModel, yp3.f {
    public static final fo.a<Integer> c = null;
    public static final fo.a<String> d = null;
    public final fo.b a;
    public final int b;

    public static final class a {
    }

    static {
        c = new fo.a("shop_window_inner_flow_layout_position", new Integer[0]);
        d = new fo.a("shop_window_inner_flow_bound_product_id", new String[0]);
    }

    public final int getType() {
        return this.b;
    }

    public final int modelType() {
        return this.b;
    }

    public b(int r1) {
        this.b = r1;
        this.a = new fo.b();
    }
}
