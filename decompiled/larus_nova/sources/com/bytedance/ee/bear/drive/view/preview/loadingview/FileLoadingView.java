package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class FileLoadingView extends FrameLayout implements m85.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f225041g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f225042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDProgress f225043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f225044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f225045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DriveComponentRenderVM f225046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f225047f;

    @Override // m85.a
    public String getReleaseKey() {
        return "FileLoadingView";
    }

    @Override // m85.a
    public final void onRelease() {
        this.f225047f.clear();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_loading_view, this);
        this.f225042a = (ViewGroup) findViewById(R.id.loading_root);
        this.f225043b = (UDProgress) findViewById(R.id.progress_bar);
        this.f225044c = (ImageView) findViewById(R.id.placeholder);
        this.f225045d = (TextView) findViewById(R.id.text);
        this.f225043b.setMax(100);
        this.f225043b.setProgress(0);
        setVisibility(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225046e.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public FileLoadingView(Context r100) {
        super(r100);
        this.f225047f = new CompositeDisposable();
        a();
    }

    public final void b(ViewOwner r100) {
        DriveComponentRenderVM r101 = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        this.f225046e = r101;
        r101.bindReleaseListener(this);
    }

    public final void e(final int r100) {
        Disposable r101 = Observable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new c(this, r100)).subscribe();
        this.f225047f.add(r101);
    }

    public void setProgress(int r100) {
        if (r100 > 0) goto L5;
        this.f225043b.setProgress(0);
        return;
    L5:
        if (r100 < 100) goto L7;
        this.f225043b.setProgress(100);
        return;
    L7:
        this.f225043b.setProgress(r100);
    }

    public FileLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225047f = new CompositeDisposable();
        a();
    }

    public final void c(int r100, int r101) {
        this.f225043b.setTrackColor(r101);
        this.f225043b.setIndicatorColor(r100);
    }

    public final void d(int r100, int r101) {
        this.f225045d.setTextSize(0, r100);
        this.f225045d.setTextColor(r101);
    }

    public FileLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225047f = new CompositeDisposable();
        a();
    }
}
