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
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileLoadingView extends FrameLayout implements m85.a {
    public static final /* synthetic */ int g = 0;
    public ViewGroup a;
    public UDProgress b;
    public ImageView c;
    public TextView d;
    public DriveComponentRenderVM e;
    public final CompositeDisposable f;

    @Override // m85.a
    public String getReleaseKey() {
        return "FileLoadingView";
    }

    @Override // m85.a
    public final void onRelease() {
        this.f.clear();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560208, this);
        this.a = (ViewGroup) findViewById(2131379061);
        this.b = findViewById(2131383297);
        this.c = (ImageView) findViewById(2131382393);
        this.d = (TextView) findViewById(2131388367);
        this.b.setMax(100);
        this.b.setProgress(0);
        setVisibility(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public FileLoadingView(Context r1) {
        super(r1);
        this.f = new CompositeDisposable();
        a();
    }

    public final void b(ViewOwner r2) {
        DriveComponentRenderVM r3 = (DriveComponentRenderVM) r2.viewModel(DriveComponentRenderVM.class);
        this.e = r3;
        r3.bindReleaseListener(this);
    }

    public final void e(final int r4) {
        Disposable r5 = Observable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new c(this, r4)).subscribe();
        this.f.add(r5);
    }

    public void setProgress(int r2) {
        if (r2 > 0) goto L5;
        this.b.setProgress(0);
        return;
    L5:
        if (r2 < 100) goto L7;
        this.b.setProgress(100);
        return;
    L7:
        this.b.setProgress(r2);
    }

    public FileLoadingView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = new CompositeDisposable();
        a();
    }

    public final void c(int r2, int r3) {
        this.b.setTrackColor(r3);
        this.b.setIndicatorColor(r2);
    }

    public final void d(int r3, int r4) {
        this.d.setTextSize(0, r3);
        this.d.setTextColor(r4);
    }

    public FileLoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = new CompositeDisposable();
        a();
    }
}
