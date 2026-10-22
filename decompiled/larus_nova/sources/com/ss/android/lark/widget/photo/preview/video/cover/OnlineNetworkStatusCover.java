package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.larus.nova.R;
import com.ss.android.lark.widget.photo.preview.video.online.f0;
import com.ss.android.lark.widget.photo.preview.video.online.g0;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes38.dex */
public class OnlineNetworkStatusCover extends v0c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f447159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f447160f;

    @BindView(AVMDLDataLoader.KeyIsGetEnableHls)
    View mStatusCancel;

    @BindView(9408)
    View mStatusContinue;

    @BindView(9409)
    TextView mStatusTip;

    public interface a {
    }

    @Override // v0c.o
    public final void g() {
        ButterKnife.bind(this, this.f447159e);
    }

    @Override // v0c.a
    public final void k() {
        q(8);
    }

    public OnlineNetworkStatusCover(FragmentActivity r100) {
        super(r100);
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.online_network_status_cover, null);
        this.f447159e = r101;
        return r101;
    }

    @OnClick({AVMDLDataLoader.KeyIsGetEnableHls})
    public void onCancelClick(View r100) {
        a r101 = this.f447160f;
        if (r101 == null) goto L6;
        ((g0) r101).f447359a.finish();
        return;
    }

    @OnClick({9408})
    public void onContinueClick(View r100) {
        a r101 = this.f447160f;
        if (r101 == null) goto L6;
        f0 r102 = ((g0) r101).f447359a;
        com.ss.android.lark.widget.photo.preview.video.online.c.a r103 = r102.f447326g;
        PhotoItem r104 = r102.f447320a;
        int r105 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
        r103.X4(r104, Integer.valueOf(com.ss.android.lark.widget.photo.preview.utils.a.a(r104.getVideoKey())));
        return;
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        if (r100 != (-99053)) goto L7;
        q(8);
        return;
    }
}
