package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class LoadingAnimView extends RelativeLayout implements m85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f225048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DriveComponentRenderVM f225049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BearLottieView f225050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f225051d;

    @Override // m85.a
    public String getReleaseKey() {
        return "LoadingAnimView";
    }

    public final void a() {
        setVisibility(8);
        Disposable r100 = Observable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new e(this)).subscribe();
        this.f225048a.add(r100);
    }

    @Override // m85.a
    public final void onRelease() {
        this.f225050c.cancelAnimation();
        this.f225048a.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225049b.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public LoadingAnimView(Context r100) {
        super(r100);
        this.f225048a = new CompositeDisposable();
        b(r100);
    }

    public final void b(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.drive_loading_anim_view, this);
        this.f225050c = (BearLottieView) findViewById(R.id.loading_anim_view);
        this.f225051d = (TextView) findViewById(R.id.loading_text);
    }

    public final void c(ViewOwner r100) {
        DriveComponentRenderVM r101 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f225049b = r101;
        r101.bindReleaseListener(this);
    }

    public void setTipText(String r100) {
        this.f225051d.setText(r100);
    }

    public LoadingAnimView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225048a = new CompositeDisposable();
        b(r100);
    }

    public LoadingAnimView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225048a = new CompositeDisposable();
        b(r100);
    }
}
