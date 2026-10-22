package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import h18.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class VideoResolutionAdapter extends RecyclerView.Adapter<VideoResolutionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ja5.a> f225599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f225600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f225601c;

    public static class VideoResolutionViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f225602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f225603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f225604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f225605d;

        public VideoResolutionViewHolder(View r100) {
            super(r100);
            this.f225602a = (LinearLayout) r100.findViewById(R.id.drive_horizontal_video_resolution_layout);
            this.f225603b = (ImageView) r100.findViewById(R.id.drive_horizontal_video_resolution_image);
            this.f225604c = (TextView) r100.findViewById(R.id.drive_horizontal_video_resolution_text);
            this.f225605d = r100.findViewById(R.id.drive_horizontal_video_resolution_divider);
        }
    }

    public interface a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f225599a).size();
    }

    public VideoResolutionAdapter() {
        this.f225599a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VideoResolutionViewHolder r102 = (VideoResolutionViewHolder) r100;
        if (r101 <= ((ArrayList) this.f225599a).size()) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "out of max position");
        return;
    L6:
        if (r101 != (((ArrayList) this.f225599a).size() - 1)) goto L8;
        r102.f225605d.setVisibility(8);
    L10:
        if (((ja5.a) ListProtector.get(this.f225599a, r101)).f497883a == false) goto L12;
        r102.f225603b.setVisibility(0);
        int r103 = e.f483540a;
        Typeface r104 = e.b(r102.f225604c.getContext(), 1);
        r102.f225604c.setTypeface(r104);
        r102.f225604c.setTextColor(this.f225600b.getResources().getColor(R.color.primary_fill_default));
    L13:
        r102.f225604c.setText(((ja5.a) ListProtector.get(this.f225599a, r101)).f497885c);
        r102.f225602a.setOnClickListener(new b(this, r101));
        return;
    L12:
        r102.f225603b.setVisibility(4);
        int r105 = e.f483540a;
        Typeface r106 = e.b(r102.f225604c.getContext(), 0);
        r102.f225604c.setTypeface(r106);
        r102.f225604c.setTextColor(this.f225600b.getResources().getColor(R.color.text_title));
        goto L13
    L8:
        r102.f225605d.setVisibility(0);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f225600b = r100.getContext();
        return new VideoResolutionViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.drive_horizontal_video_view_resolution_content_item, r100, false));
    }
}
