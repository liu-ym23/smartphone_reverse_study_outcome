package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.larus.nova.R;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes22.dex */
public final class j extends FrameLayout implements vi7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f271235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f271236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f271237c;

    public int getLayout() {
        return R.layout.luckycat_lynx_error_layout;
    }

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
        RelativeLayout r100 = this.f271235a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // vi7.b
    public final void b() {
        RelativeLayout r100 = this.f271235a;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // vi7.b
    public final boolean c() {
        View r100 = this.f271236b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // vi7.b
    public final void g() {
        View r100 = this.f271236b;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // vi7.b
    public final void showLoadingView() {
        RelativeLayout r100 = this.f271235a;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    @Override // vi7.b
    public final void f() {
        b();
        View r100 = this.f271236b;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public j(Context r100) {
        super(r100);
        LayoutInflater.from(getContext()).inflate(getLayout(), this);
        this.f271235a = (RelativeLayout) findViewById(R.id.loading_view);
        this.f271236b = findViewById(R.id.retry_view);
        ImageView r101 = (ImageView) findViewById(R.id.retry_view_network_icon);
        if (Build.VERSION.SDK_INT >= 24) goto L10;
        Drawable r102 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.polaris_ic_not_network_lynx, getContext().getTheme());
    L8:
        r101.setImageDrawable(r102);
        this.f271237c = (TextView) findViewById(R.id.loading_view_progress_text);
        com.bytedance.ug.sdk.luckycat.impl.manager.m r103 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        getContext();
        return;
    L10:
        r102 = VectorDrawableCompat.create(getContext().getResources(), R.drawable.polaris_ic_not_network_lynx, getContext().getTheme());     // Catch: Resources.NotFoundException -> L6
    L6:
        r102 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.polaris_ic_not_network_lynx, getContext().getTheme());
        goto L8
    }

    @Override // vi7.d
    public final void I7(int r100) {
        TextView r101 = this.f271237c;
        if (r101 != null) goto L5;
    L6:
        TextView r102 = this.f271237c;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        TextView r103 = this.f271237c;
        if (r103 == null) goto L13;
        r103.setText(NumberFormat.getPercentInstance().format(Float.valueOf(r100 / 100.0f)));
        return;
    L13:
        return;
    L5:
        if (r101.getVisibility() == 0) goto L9;
        goto L6
    }

    @Override // vi7.b
    public void setOnRetryClickListener(View.OnClickListener r100) {
        View r101 = this.f271236b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }
}
