package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadTagViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f263576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f263577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f263578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f263579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f263580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f263581f;

    public TripPoiHeadTagViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f263576a = (DuxTextView) r100.findViewById(R.id.trip_head_image_text);
        this.f263577b = (DuxTextView) r100.findViewById(R.id.trip_head_image_num);
        this.f263578c = (LinearLayout) r100.findViewById(R.id.text_container_ll);
        this.f263579d = (int) UIUtils.dip2Px(r100.getContext(), 6.0f);
        this.f263580e = (int) UIUtils.dip2Px(r100.getContext(), 8.0f);
        this.f263581f = "linear-gradient(to right, #FFCC80, #FFB057)";
    }

    public static DisplayMetrics T3(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
