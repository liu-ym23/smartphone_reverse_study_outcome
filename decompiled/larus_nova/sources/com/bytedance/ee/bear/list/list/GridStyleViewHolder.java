package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class GridStyleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f228468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f228469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f228470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f228471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f228472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f228473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f228474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f228475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SyncStateView f228476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f228477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SpaceTagTitleView f228478k;

    public GridStyleViewHolder(View r100) {
        super(r100);
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.grid_item);
        this.f228468a = r101;
        this.f228469b = (AppCompatImageView) r100.findViewById(R.id.list_grid_thumbnail);
        this.f228470c = (AppCompatImageView) r100.findViewById(R.id.list_grid_folder_thumbnail);
        this.f228471d = r100.findViewById(R.id.list_grid_pin);
        this.f228472e = (AppCompatImageView) r100.findViewById(R.id.list_grid_item_type);
        this.f228473f = (AppCompatImageView) r100.findViewById(R.id.list_grid_item_shortcut);
        this.f228474g = (TextView) r100.findViewById(R.id.list_grid_item_title);
        this.f228475h = r100.findViewById(R.id.list_grid_more);
        this.f228476i = (SyncStateView) r100.findViewById(R.id.list_grid_item_sync_state);
        this.f228477j = (AppCompatImageView) r101.findViewById(R.id.list_external_notice);
        this.f228478k = (SpaceTagTitleView) r100.findViewById(R.id.list_grid_item_tag);
    }
}
