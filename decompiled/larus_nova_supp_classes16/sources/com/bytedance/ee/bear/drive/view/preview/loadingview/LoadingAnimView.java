package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoadingAnimView extends RelativeLayout implements m85.a {
    public final CompositeDisposable a;
    public DriveComponentRenderVM b;
    public BearLottieView c;
    public TextView d;

    @Override // m85.a
    public String getReleaseKey() {
        return "LoadingAnimView";
    }

    public final void a() {
        setVisibility(8);
        Disposable r0 = Observable.timer(400, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).doOnComplete(new e(this)).subscribe();
        this.a.add(r0);
    }

    @Override // m85.a
    public final void onRelease() {
        this.c.cancelAnimation();
        this.a.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public LoadingAnimView(Context r2) {
        super(r2);
        this.a = new CompositeDisposable();
        b(r2);
    }

    public final void b(Context r2) {
        LayoutInflater.from(r2).inflate(2131560206, this);
        this.c = (BearLottieView) findViewById(2131378998);
        this.d = (TextView) findViewById(2131379082);
    }

    public final void c(ViewOwner r2) {
        DriveComponentRenderVM r3 = (DriveComponentRenderVM) r2.viewModel(DriveComponentRenderVM.class);
        this.b = r3;
        r3.bindReleaseListener(this);
    }

    public void setTipText(String r2) {
        this.d.setText(r2);
    }

    public LoadingAnimView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new CompositeDisposable();
        b(r1);
    }

    public LoadingAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new CompositeDisposable();
        b(r1);
    }
}
