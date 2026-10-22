package com.bytedance.live.photoviewer.photoviewer.video;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerListener;
import com.bytedance.live.photoviewer.transition.TransitionLayout;
import com.bytedance.live.photoviewer.ui.LoadingLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/live/photoviewer/photoviewer/video/VideoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "photoviewer_release"}, k = 1, mv = {1, 4, 0})
public final class VideoVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionLayout f255671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f255672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f255673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LoadingLayout f255674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SeekBar f255675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f255676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f255677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f255678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f255679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f255680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f255681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f255682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f255683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f255684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PhotoViewerListener f255685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f255686p;

    public static final class a {
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoVH f255687a;

        public b(VideoVH r100) {
            this.f255687a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            PhotoViewerListener r101 = this.f255687a.f255685o;
            if (r101 == null) goto L5;
            r101.onUserChangeProgress();
        L5:
            this.f255687a.getClass();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            if (r100 == null) goto L4;
            r100.getProgress();
        L4:
            VideoVH r101 = this.f255687a;
            int r102 = r101.f255683m;
            r101.getClass();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L14;
            VideoVH r103 = this.f255687a;
            int r104 = r103.f255683m;
            int r105 = (r101 * r104) / 100;
            r103.f255682l = r105;
            if (r105 == 0) goto L8;
            if (r104 == 0) goto L8;
            int r106 = (int) ((r105 * 100.0f) / r104);
        L9:
            r103.f255675e.setProgress(r106);
            if (r103.f255683m == r104) goto L12;
            r103.f255683m = r104;
            r103.f255677g.setText(VideoVH.T3(r104 / 1000));
        L12:
            r103.f255676f.setText(VideoVH.T3(r103.f255682l / 1000));
            return;
        L8:
            r106 = 1;
            goto L9
        }
    }

    static {
    }

    public VideoVH(TransitionLayout r100) {
        super(r100);
        this.f255671a = r100;
        this.f255673c = (FrameLayout) r100.findViewById(R.id.video_container);
        this.f255674d = (LoadingLayout) r100.findViewById(R.id.loading_view);
        this.f255675e = (SeekBar) r100.findViewById(R.id.sb_video_progress);
        this.f255676f = (TextView) r100.findViewById(R.id.tv_video_progress);
        this.f255677g = (TextView) r100.findViewById(R.id.tv_video_duration);
        this.f255678h = (ImageView) r100.findViewById(R.id.iv_load_failed);
        this.f255679i = (ImageView) r100.findViewById(R.id.iv_play);
        this.f255680j = r100.findViewById(R.id.cl_bottom);
        this.f255681k = (ImageView) r100.findViewById(R.id.iv_mute);
        this.f255686p = new b(this);
    }

    public static String T3(int r100) {
        int r101 = r100 / 60;
        int r102 = r100 - (r101 * 60);
        StringBuilder r103 = new StringBuilder();
        if (r101 >= 10) goto L5;
        String r104 = "0" + r101;
    L6:
        r103.append(r104);
        r103.append(':');
        if (r102 >= 10) goto L9;
        String r105 = "0" + r102;
    L10:
        r103.append(r105);
        return r103.toString();
    L9:
        r105 = String.valueOf(r102);
        goto L10
    L5:
        r104 = String.valueOf(r101);
        goto L6
    }
}
