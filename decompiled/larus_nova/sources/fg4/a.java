package fg4;

import com.bytedance.android.shopping.anchorv3.view.AnchorV3ProductFormatItemView;
import com.bytedance.commerce.uikit.flowlayout.FlowLayout;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends T> f476828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f476829b;

    public abstract AnchorV3ProductFormatItemView a(FlowLayout r100, Object r101);

    public a(List<? extends T> r100) {
        this.f476828a = r100;
        this.f476829b = new HashSet();
    }
}
