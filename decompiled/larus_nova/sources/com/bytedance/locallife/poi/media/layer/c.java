package com.bytedance.locallife.poi.media.layer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.locallife.poi.media.api.PlayState;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements hy6.d {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f262677a;

        public a(ViewGroup r100) {
            this.f262677a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = this.f262677a.getContext();
            if ((r101 instanceof Activity) == true) goto L6;
            r101 = null;
        L6:
            if (r101 == null) goto L9;
            ((Activity) r101).finish();
            return;
        }
    }

    public c() {
    }

    @Override // hy6.d
    public final void a() {
    }

    @Override // hy6.d
    public final void e(iy6.c r100) {
    }

    @Override // hy6.d
    public final void f(iy6.d r100) {
    }

    @Override // hy6.b
    public final void g() {
    }

    @Override // hy6.b
    public final void h(int r100, int r101) {
    }

    @Override // hy6.d
    public final void i(JsonObject r100) {
    }

    @Override // hy6.d
    public final void k(JsonObject r100) {
    }

    @Override // hy6.d
    public final void m(String r100) {
    }

    @Override // hy6.d
    public final void n() {
    }

    @Override // hy6.b
    public final void onRenderStart() {
    }

    @Override // hy6.b
    public final void onVideoSizeChanged(int r100, int r101) {
    }

    @Override // hy6.d
    public final void release() {
    }

    @Override // hy6.d
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.life_poi_media_simple_toolbar, r100, false);
        r101.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ((ImageView) r101.findViewById(R.id.poi_simple_player_back)).setOnClickListener(new a(r100));
        return r101;
    }

    @Override // hy6.b
    public final void o(PlayState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // hy6.b
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
    }
}
