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
import h18.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VideoResolutionAdapter extends RecyclerView.Adapter<VideoResolutionViewHolder> {
    public final List<ja5.a> a;
    public Context b;
    public a c;

    public static class VideoResolutionViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final ImageView b;
        public final TextView c;
        public final View d;

        public VideoResolutionViewHolder(View r2) {
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131370271);
            this.b = (ImageView) r2.findViewById(2131370270);
            this.c = (TextView) r2.findViewById(2131370272);
            this.d = r2.findViewById(2131370269);
        }
    }

    public interface a {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public VideoResolutionAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        VideoResolutionViewHolder r7 = (VideoResolutionViewHolder) r5;
        if (r6 <= ((ArrayList) this.a).size()) goto L6;
        tt5.a.d("DRIVE_VideoPlayer", "out of max position");
        return;
    L6:
        if (r6 != (((ArrayList) this.a).size() - 1)) goto L8;
        r7.d.setVisibility(8);
    L10:
        if (((ja5.a) ListProtector.get(this.a, r6)).a == false) goto L12;
        r7.b.setVisibility(0);
        int r0 = e.a;
        Typeface r1 = e.b(r7.c.getContext(), 1);
        r7.c.setTypeface(r1);
        r7.c.setTextColor(this.b.getResources().getColor(2131105548));
    L13:
        r7.c.setText(((ja5.a) ListProtector.get(this.a, r6)).c);
        r7.a.setOnClickListener(new b(this, r6));
        return;
    L12:
        r7.b.setVisibility(4);
        int r2 = e.a;
        Typeface r3 = e.b(r7.c.getContext(), 0);
        r7.c.setTypeface(r3);
        r7.c.setTextColor(this.b.getResources().getColor(2131106622));
        goto L13
    L8:
        r7.d.setVisibility(0);
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        this.b = r3.getContext();
        return new VideoResolutionViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560196, r3, false));
    }
}
