package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.TransitionManager;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends v0c.a implements y0c.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRequestCreator f447181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PhotoItem f447182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f447183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f447184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f447185i;

    @Override // y0c.b
    public final /* synthetic */ void f() {
    }

    @Override // y0c.b
    public final /* synthetic */ void onDoubleTap(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onDown(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onLongPress(MotionEvent r100) {
    }

    @Override // y0c.b
    public final /* synthetic */ void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.lark.widget.photo.preview.video.cover.c, java.lang.Object] */
    public final void r() {
        boolean r100 = false;
        if (this.f447184h.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        Context r102 = getContext();
        PhotoItem r103 = this.f447182f;
        ?? r104 = new c(this);
        PhotoUtilsNew r105 = PhotoUtilsNew.f447142a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "success");
        Log.i("PhotoUtilsNew", "applyVideoPlayResource");
        if (r103 != null) goto L10;
    L12:
        if (r100 == false) goto L14;
        WeakReference r106 = new WeakReference(r102);
        a0b.h.d(Scene.IM_Video_Play, true, new com.ss.android.lark.widget.photo.preview.utils.e(r104, r106));
        return;
    L14:
        r104.run();
        return;
    L10:
        if (r103.isVideo() != true) goto L12;
        r100 = true;
        goto L12
    L15:
        o();
        this.f447184h.setVisibility(0);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // v0c.o
    public final void g() {
        j(-66016, null);
        this.f447184h = this.f447183g.findViewById(R.id.play_label);
        this.f447185i = (ImageView) this.f447183g.findViewById(R.id.video_cover);
        final String r100 = this.f447182f.getPhoto().getPath();
        if (FileUtils.r(r100) == false) goto L5;
        RxScheduledExecutor.execInIO(new a(this, r100), new b(this));
        return;
    L5:
        this.f447181e.load(Integer.valueOf(R.drawable.__picker_ic_photo_black_48dp)).into(this.f447185i);
    }

    @Override // v0c.a
    public final void l() {
        a0b.h.e();
    }

    @Override // v0c.b, v0c.o
    public final void d(int r100) {
        switch(r100) {
            case -66018: goto L5;
            case -66017: goto L4;
            default: goto L8;
        };
    L4:
        q(8);
        return;
    L5:
        q(0);
        return;
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.local_controller_cover, null);
        this.f447183g = r101;
        return r101;
    }

    @Override // y0c.b
    public final void onSingleTapUp(MotionEvent r100) {
        r();
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        switch(r100) {
            case -99016: goto L6;
            case -99015: goto L5;
            case -99004: goto L4;
            default: goto L10;
        };
    L4:
        this.f447182f.setLoadStatus(PhotoItem.LOAD_STATUS.SUCCESS);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447182f);
        return;
    L5:
        TransitionManager.beginDelayedTransition(this.f447183g);
        this.f447185i.setVisibility(8);
        TransitionManager.endTransitions(this.f447183g);
        return;
    L6:
        r();
        return;
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        this.f447182f.setLoadStatus(PhotoItem.LOAD_STATUS.FAILED);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447182f);
    }

    public d(Context r100, IRequestCreator r101, PhotoItem r102) {
        super(r100);
        this.f447181e = r101;
        this.f447182f = r102;
    }
}
