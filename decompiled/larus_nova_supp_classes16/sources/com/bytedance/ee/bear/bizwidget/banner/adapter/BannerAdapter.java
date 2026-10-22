package com.bytedance.ee.bear.bizwidget.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import rv4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public List<T> a;
    public int b;

    public final int y2() {
        List<T> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public final int getItemCount() {
        if (y2() <= 1) goto L6;
        return y2() + this.b;
    L6:
        return y2();
    }

    public BannerAdapter(List<T> r2) {
        this.a = new ArrayList();
        this.b = 2;
        if (r2 != null) goto L5;
        r2 = new ArrayList();
    L5:
        this.a = r2;
    }

    public final void onBindViewHolder(VH r7, int r8) {
        boolean r1 = false;
        if (this.b != 2) goto L5;
        boolean r0 = true;
    L6:
        int r9 = a.b(r0, r8, y2());
        Object r2 = ListProtector.get(this.a, r9);
        y2();
        TemplateBannerAdapter r3 = (TemplateBannerAdapter) this;
        TemplateBannerAdapter.ImageHolder r10 = (TemplateBannerAdapter.ImageHolder) r7;
        BannerData r4 = (BannerData) r2;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        r3.z2(true, r4);
        new RequestOptions();
        FragmentActivity r5 = r10.a.getContext();
        if ((r5 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r6 = r5;
    L10:
        if (r6 != null) goto L12;
    L14:
        if (r1 == true) goto L18;
        Glide.with(r10.a.getContext()).asBitmap().load(new BearGlideUrl(r4.getUrl())).apply(RequestOptions.bitmapTransform(new RoundedCorners(n.d(4)))).error(2131243721).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(r10.a);
        r10.a.setOnClickListener(new com.bytedance.ee.bear.templates.banner.a(r3, r10, r4, r9));
        return;
    L18:
        return;
    L12:
        if (r6.isFinishing() != true) goto L14;
        r1 = true;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.ImageView, com.bytedance.ee.bear.facade.common.widget.NiceImageView] */
    public final VH onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        ?? r4 = new NiceImageView(r2.getContext());
        r4.setCornerRadius(4);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new TemplateBannerAdapter.ImageHolder(r4);
    }
}
