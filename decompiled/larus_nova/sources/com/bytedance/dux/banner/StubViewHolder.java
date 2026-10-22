package com.bytedance.dux.banner;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dux/banner/StubViewHolder;", "Lcom/bytedance/dux/banner/BannerViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class StubViewHolder extends BannerViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f204878g = null;

    public static final class a implements d {
        public a() {
        }

        @Override // com.bytedance.dux.banner.d
        public final StubViewHolder a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r101 = new View(r100.getContext());
            r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new StubViewHolder(r101);
        }
    }

    static {
        f204878g = new a();
    }

    @Override // com.bytedance.dux.banner.BannerViewHolder
    public final void U3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public StubViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }
}
