package com.bytedance.ee.bear.drive.view.preview.video.videopopupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public View b;
    public VideoResolutionAdapter c;
    public ResolutionPopupWindow d;
    public final Context e;
    public boolean f;
    public RecyclerView g;

    public a(Context r3, String r4) {
        this.e = r3;
        this.a = r4;
        View r5 = LayoutInflater.from(r3).inflate(2131560197, null);
        this.b = r5;
        this.g = r5.findViewById(2131370346);
        LinearLayoutManager r6 = new LinearLayoutManager(r3, 1, false);
        this.g.setLayoutManager(r6);
        VideoResolutionAdapter r7 = new VideoResolutionAdapter();
        this.c = r7;
        this.g.setAdapter(r7);
    }
}
