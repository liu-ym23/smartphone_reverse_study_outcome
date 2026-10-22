package com.bytedance.locallife.poi.media.photo;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lighten.core.ImagePiplinePriority;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import df6.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/SlidePhotosViewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/media/photo/SlidePhotosViewPagerAdapter$SlidesPhotosViewPagerHolder;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SlidesPhotosViewPagerHolder", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SlidePhotosViewPagerAdapter extends RecyclerView.Adapter<SlidesPhotosViewPagerHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f262697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hy6.c f262698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f262699c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/media/photo/SlidePhotosViewPagerAdapter$SlidesPhotosViewPagerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public final class SlidesPhotosViewPagerHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SmartImageView f262700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f262701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ProgressBar f262702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SlidePhotosViewPagerAdapter f262703d;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SlidePhotosViewPagerAdapter f262704a;

            public a(SlidePhotosViewPagerAdapter r100) {
                this.f262704a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                View.OnClickListener r101 = this.f262704a.f262699c;
                if (r101 == null) goto L6;
                r101.onClick(r100);
                return;
            }
        }

        public SlidesPhotosViewPagerHolder(SlidePhotosViewPagerAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f262703d = r100;
            super(r101);
            this.itemView.setOnClickListener(new a(r100));
            this.f262700a = (SmartImageView) r101.findViewById(R.id.poi_photo_view);
            this.f262701b = (ImageView) r101.findViewById(R.id.poi_image_load_fail);
            this.f262702c = (ProgressBar) r101.findViewById(R.id.poi_image_loading_view);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f262697a).size();
    }

    public SlidePhotosViewPagerAdapter() {
        this.f262697a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        SlidesPhotosViewPagerHolder r101 = (SlidesPhotosViewPagerHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.f262700a.setImageBitmap(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SlidesPhotosViewPagerHolder r102 = (SlidesPhotosViewPagerHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (r101 >= ((ArrayList) this.f262697a).size()) goto L13;
        String r103 = (String) ListProtector.get(this.f262697a, r101);
        r102.f262700a.setTag(r103);
        Intrinsics.checkNotNullParameter(r103, "url");
        hy6.c r104 = r102.f262703d.f262698b;
        if (r104 == null) goto L10;
        r104.d(r103);
    L10:
        u r105 = df6.q.e(r103);
        r105.f468277c = r102.itemView.getContext();
        r105.f468288n = ScaleType.FIT_CENTER;
        r105.b(String.valueOf(r103.hashCode()));
        r105.f468287m = Bitmap.Config.ARGB_8888;
        r105.f468294t = r102.f262700a;
        r105.f468291q = ImagePiplinePriority.HIGH;
        r105.f468280f = true;
        r105.f468278d = true;
        r105.d(new n(r102, r103, r102.f262703d));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new SlidesPhotosViewPagerHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.life_poi_media_slide_photo_item, r100, false));
    }
}
