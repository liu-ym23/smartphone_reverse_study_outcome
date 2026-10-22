package com.ss.android.lark.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.github.ybq.android.spinkit.SpinKitView;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import com.ss.android.lark.widget.ptr.a;
import xu7.b;

/* JADX INFO: loaded from: classes38.dex */
public class ChatWindowPtrLoadingHeader extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpinKitView f445570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f445571b;

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r102, wdc.a r103) {
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
    }

    public ChatWindowPtrLoadingHeader(Context r100) {
        this(r100, null);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        this.f445570a.setVisibility(8);
        this.f445571b.stop();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
        this.f445570a.setVisibility(0);
        this.f445571b.start();
    }

    public ChatWindowPtrLoadingHeader(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ChatWindowPtrLoadingHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.default_white_ptr_loading, this);
        SpinKitView r103 = (SpinKitView) findViewById(R.id.spin_kit);
        this.f445570a = r103;
        r103.setColor(getContext().getResources().getColor(R.color.lkui_N500));
        this.f445570a.setVisibility(8);
        b r104 = new b();
        this.f445571b = r104;
        this.f445570a.setIndeterminateDrawable(r104);
        this.f445571b.stop();
    }
}
