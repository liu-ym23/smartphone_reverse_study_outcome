package fy3;

import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.collect.UserCollectViewModel;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.collect.i f479255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DmtTextView f479256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AoImageView f479257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f479258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f479259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f479260i;

    @Override // f04.a
    public final void k() {
        UserCollectViewModel r100 = this.f479255d.f193987b;
        r100.getUserName().removeObserver(this.f479259h);
        r100.getHeaderImage().removeObserver(this.f479260i);
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [fy3.e] */
    /* JADX WARN: Type inference failed for: r2v14, types: [fy3.f] */
    public h(com.bytedance.awemeopen.apps.framework.collect.i r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f193986a);
        this.f479255d = r100;
        LinearLayout r101 = (LinearLayout) i(R.id.user_info_cl);
        this.f479256e = (DmtTextView) i(R.id.user_name_tv);
        this.f479257f = (AoImageView) i(R.id.header_image);
        this.f479258g = (LinearLayout) i(R.id.collect_header_linear_layout);
        this.f479259h = new e(this);
        this.f479260i = new f(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        UserCollectViewModel r101 = this.f479255d.f193987b;
        r101.getUserName().observe(this.f479255d.f193988c, this.f479259h);
        r101.getHeaderImage().observe(this.f479255d.f193988c, this.f479260i);
        this.f479257f.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.aos_bg_header_image_default));
    }
}
