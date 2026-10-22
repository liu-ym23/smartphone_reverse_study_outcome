package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.view.View;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dux.image.DuxImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadVideoViewHolder f263689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f263690c;

    public m(DuxImageView r100, TripPoiHeadVideoViewHolder r101, View r102) {
        this.f263688a = r100;
        this.f263689b = r101;
        this.f263690c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263688a) == false) goto L6;
        return;
    L6:
        if (this.f263689b.f263628m == false) goto L8;
    L12:
        this.f263689b.f263632q.l();
        return;
    L8:
        if (NetworkUtils.isWifi(this.f263690c.getContext()) == true) goto L12;
        this.f263689b.f263628m = true;
        com.bytedance.dux.toast.b.b(this.f263690c.getContext(), R.string.poi_play_video_in_mobile, null, 1);
        s r101 = this.f263689b.f263623h;
        if (r101 == null) goto L12;
        r101.b();
        goto L12
    }
}
