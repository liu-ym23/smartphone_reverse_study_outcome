package r73;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea$navBlurHandler$2;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f536417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f536418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f536419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f536420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f536421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f536422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f536423g;

    public a(View r100, AnchorV4NavArea$navBlurHandler$2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f536422f = r100;
        this.f536423g = r101;
        this.f536417a = (RecyclerView) r100.findViewById(R.id.anchor_v4_top_blur_mask);
        this.f536418b = k1.n(r100.getContext());
    }
}
