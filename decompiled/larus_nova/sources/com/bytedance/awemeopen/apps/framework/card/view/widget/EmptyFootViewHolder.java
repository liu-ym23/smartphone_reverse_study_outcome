package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class EmptyFootViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f193911f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingMoreView f193912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f193913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f193914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f193915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f193916e;

    public EmptyFootViewHolder(View r100) {
        super(r100);
        this.f193912a = (LoadingMoreView) r100.findViewById(R.id.more);
        this.f193913b = (TextView) r100.findViewById(R.id.tips);
        this.f193914c = r100.findViewById(R.id.anim_view_left);
        this.f193915d = r100.findViewById(R.id.anim_view_right);
        this.f193916e = r100.findViewById(R.id.anim_view_middle);
        r100.setVisibility(0);
    }

    public final void T3(View r100) {
        TextView r101 = this.f193913b;
        r101.setText(r101.getResources().getString(R.string.aos_video_card_left_move_tips));
        LoadingMoreView r102 = this.f193912a;
        r102.f193924g = 0.0f;
        r102.invalidate();
        View r103 = this.f193914c;
        if (r103 == null) goto L5;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103.getLayoutParams();
        r104.width = 0;
        this.f193914c.setLayoutParams(r104);
    L5:
        View r105 = this.f193915d;
        if (r105 == null) goto L8;
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105.getLayoutParams();
        r106.width = 0;
        this.f193915d.setLayoutParams(r106);
    L8:
        if (r100 == null) goto L11;
        r100.scrollTo(0, r100.getScrollY());
        return;
    }
}
