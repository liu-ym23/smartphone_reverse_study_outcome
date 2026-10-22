package com.bytedance.ee.bear.wikiv2.home2;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements RequestListener<Drawable> {
    public v() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        tt5.a.e("WikiHomeTopSpaceView", "bindImage glide onException", r100, false);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "dataSource");
        return false;
    }
}
