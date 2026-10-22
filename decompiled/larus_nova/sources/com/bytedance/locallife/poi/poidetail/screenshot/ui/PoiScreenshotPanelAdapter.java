package com.bytedance.locallife.poi.poidetail.screenshot.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.LifeAccessibilityUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/screenshot/ui/PoiScreenshotPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/poidetail/screenshot/ui/PoiScreenshotPanelAdapter$ViewHolder;", "ViewHolder", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiScreenshotPanelAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.locallife.poi.poidetail.screenshot.model.a> f264188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final az6.a f264189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f264190c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/screenshot/ui/PoiScreenshotPanelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f264191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f264192b;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f264191a = (AppCompatImageView) r100.findViewById(R.id.iv_channel);
            this.f264192b = (TextView) r100.findViewById(R.id.tv_channel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f264188a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.bytedance.locallife.poi.poidetail.screenshot.model.a r103 = (com.bytedance.locallife.poi.poidetail.screenshot.model.a) ListProtector.get(this.f264188a, r101);
        Integer r104 = r103.b();
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
        r102.f264191a.setImageResource(r105);
    L5:
        String r106 = r103.c();
        if (r106 == null) goto L8;
        r102.f264192b.setText(r106);
        LifeAccessibilityUtil.setAccessibilityDelegate(r102.itemView, new b(r106));
    L8:
        View r107 = r102.itemView;
        r107.setOnClickListener(new a(r107, this, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_fragment_screenshot_share_item, r100, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PoiScreenshotPanelAdapter(List<? extends com.bytedance.locallife.poi.poidetail.screenshot.model.a> r100, az6.a r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "channels");
        Intrinsics.checkNotNullParameter(r101, "screenshotMob");
        Intrinsics.checkNotNullParameter(r102, "dismiss");
        this.f264188a = r100;
        this.f264189b = r101;
        this.f264190c = r102;
    }
}
