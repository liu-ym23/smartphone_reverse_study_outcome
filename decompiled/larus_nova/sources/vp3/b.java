package vp3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b implements QModel, yp3.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final fo.a<Integer> f556616c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final fo.a<String> f556617d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fo.b f556618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f556619b;

    public static final class a {
    }

    static {
        f556616c = new fo.a("shop_window_inner_flow_layout_position", new Integer[0]);
        f556617d = new fo.a("shop_window_inner_flow_bound_product_id", new String[0]);
    }

    public final int getType() {
        return this.f556619b;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return this.f556619b;
    }

    public b(int r100) {
        this.f556619b = r100;
        this.f556618a = new fo.b();
    }
}
