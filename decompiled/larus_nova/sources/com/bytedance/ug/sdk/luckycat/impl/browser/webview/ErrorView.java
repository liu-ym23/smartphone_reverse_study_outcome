package com.bytedance.ug.sdk.luckycat.impl.browser.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn7.a;
import com.bytedance.ug.sdk.luckycat.api.depend.d;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.nova.R;
import vi7.b;

/* JADX INFO: loaded from: classes22.dex */
public class ErrorView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f271112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f271113b;

    @Override // vi7.b
    public ViewGroup getView() {
        return this;
    }

    @Override // vi7.b
    public final void j() {
    }

    @Override // vi7.b
    public void setOnCloseClickListener(View.OnClickListener r100) {
    }

    @Override // vi7.b
    public final boolean a() {
        View r100 = this.f271112a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // vi7.b
    public final void b() {
        View r100 = this.f271112a;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // vi7.b
    public final boolean c() {
        View r100 = this.f271113b;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // vi7.b
    public final void f() {
        View r100 = this.f271113b;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    @Override // vi7.b
    public final void g() {
        View r100 = this.f271113b;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // vi7.b
    public final void showLoadingView() {
        View r100 = this.f271112a;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public final void k() {
        LayoutInflater.from(getContext()).inflate(R.layout.luckycat_webview_error_layout, this);
        this.f271112a = findViewById(R.id.loading_view);
        this.f271113b = findViewById(R.id.retry_view);
        d r100 = m.a.f271349a.f271337e;
        if (r100 == null) goto L6;
        ((a) r100).a();
        return;
    }

    public ErrorView(Context r100) {
        super(r100);
        k();
    }

    @Override // vi7.b
    public void setOnRetryClickListener(View.OnClickListener r100) {
        View r101 = this.f271113b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public ErrorView(Context r100, AttributeSet r101) {
        super(r100, r101);
        k();
    }

    public ErrorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        k();
    }
}
