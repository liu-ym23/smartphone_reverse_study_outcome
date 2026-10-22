package com.ss.android.lark.widget.photopickernew.grid;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rdc.n;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class GridCameraShowPlugin extends pdc.a<t, CameraViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f447879a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/widget/photopickernew/grid/GridCameraShowPlugin$CameraViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "iconView", "Landroid/widget/ImageView;", "<init>", "(Landroid/widget/ImageView;)V", "getIconView", "()Landroid/widget/ImageView;", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f447880a;

        public CameraViewHolder(ImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "iconView");
            super(r100);
            this.f447880a = r100;
        }
    }

    public interface a extends View.OnClickListener {
    }

    public GridCameraShowPlugin(n r100) {
        Intrinsics.checkNotNullParameter(r100, "onCameraClick");
        this.f447879a = r100;
    }

    @Override // pdc.a
    public final RecyclerView.ViewHolder b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new CameraViewHolder(new ImageView(r100.getContext()));
    }

    @Override // pdc.a
    public final void a(RecyclerView.ViewHolder r100, Photo r101) {
        CameraViewHolder r102 = (CameraViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        Intrinsics.checkNotNullParameter((t) r101, "data");
        r102.f447880a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView r103 = r102.f447880a;
        r103.setColorFilter(UDColorUtils.getColor(r103.getContext(), R.color.icon_n2), PorterDuff.Mode.SRC_ATOP);
        r102.f447880a.setImageResource(R.drawable.__picker_ic_camera_new);
        r102.f447880a.setOnClickListener(this.f447879a);
    }
}
