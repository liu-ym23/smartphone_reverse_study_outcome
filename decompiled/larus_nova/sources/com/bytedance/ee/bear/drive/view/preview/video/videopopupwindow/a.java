package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f225606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f225607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoResolutionAdapter f225608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResolutionPopupWindow f225609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f225610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f225611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f225612g;

    public a(Context r100, String r101) {
        this.f225610e = r100;
        this.f225606a = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.drive_horizontal_video_view_resolution_layout, null);
        this.f225607b = r102;
        this.f225612g = (RecyclerView) r102.findViewById(R.id.drive_video_pop_window_recycler_view);
        LinearLayoutManager r103 = new LinearLayoutManager(r100, 1, false);
        this.f225612g.setLayoutManager(r103);
        VideoResolutionAdapter r104 = new VideoResolutionAdapter();
        this.f225608c = r104;
        this.f225612g.setAdapter(r104);
    }
}
