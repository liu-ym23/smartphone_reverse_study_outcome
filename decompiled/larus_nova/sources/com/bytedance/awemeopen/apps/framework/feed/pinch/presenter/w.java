package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w extends b implements rz3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f195765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f195766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f195767j;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void d() {
    }

    @Override // rz3.a
    public final void a() {
        View r100 = this.f195767j.findViewById(R.id.right_btn_layout);
        if (r100 == null) goto L5;
        r100.setBackgroundResource(R.drawable.familiar_pinch_view_btn_bg);
    L5:
        View r101 = this.f195767j.findViewById(R.id.close_btn);
        if (r101 == null) goto L9;
        r101.setBackgroundResource(R.drawable.familiar_pinch_view_btn_bg);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        this.f195765h.setVisibility(0);
        View r100 = this.f195767j.findViewById(R.id.video_pinch_bar);
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        FrameLayout r101 = (FrameLayout) this.f195767j.findViewById(R.id.close_btn_container);
        this.f195766i = r101;
        if (r101 == null) goto L9;
        r101.setOnClickListener(new v(this));
    L9:
        FrameLayout r102 = this.f195766i;
        if (r102 == null) goto L13;
        r102.setOnTouchListener(new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.c());
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        this.f195765h.setVisibility(8);
    }

    public w(View r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "parentView");
        super(r100);
        this.f195765h = r101;
        this.f195767j = LayoutInflater.from(getContext()).inflate(R.layout.familiar_pinch_btn_bar, r101);
    }
}
