package com.bytedance.ee.bear.list.docstate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SyncStateView extends LKUIRoundedImageView2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f227860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateAnimation f227861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f227862c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncStateView f227863a;

        @Override // java.lang.Runnable
        public final void run() {
            SyncStateView r100 = this.f227863a;     // Catch: Throwable -> L7
            if (r100.f227860a == false) goto L5;
            r100.setSyncState(7);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            r100.setSyncState(0);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(SyncStateView r100) {
            this.f227863a = r100;
        }
    }

    public final void init() {
        setVisibility(8);
        setBorderWidthInDp(1.0f);
        setRadiusInDp(6.0f);
        setBorderColor(getContext().getResources().getColor(R.color.lkui_transparent));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f227862c);
        RotateAnimation r100 = this.f227861b;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public SyncStateView(Context r100) {
        super(r100);
        this.f227862c = new a(this);
        init();
    }

    public void setManualOffline(boolean r100) {
        this.f227860a = r100;
    }

    public void setSyncState(int r100) {
        tt5.a.h("SyncStateView", "setSyncState()...state = " + r100 + ", isManualOffline = " + this.f227860a);
        setVisibility(8);
        clearAnimation();
        switch(r100) {
            case 1: goto L13;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L5;
            case 8: goto L7;
            default: goto L20;
        };
    L5:
        setImageResource(R.drawable.ic_icon_tool_offlinesuccess);
        setVisibility(0);
        return;
    L6:
        setImageResource(R.drawable.ic_icon_tool_waitdownload);
        setVisibility(0);
        return;
    L7:
        setImageResource(R.drawable.ic_icon_tool_offlinefail);
        setVisibility(0);
        return;
    L8:
        setImageResource(R.drawable.ic_icon_tool_uploading);
        setVisibility(0);
        removeCallbacks(this.f227862c);
        postDelayed(this.f227862c, 1000);
        return;
    L9:
        setImageResource(R.drawable.ic_icon_tool_synching);
        setVisibility(0);
        if (this.f227861b != null) goto L12;
        this.f227861b = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
    L12:
        this.f227861b.reset();
        this.f227861b.setDuration(800);
        this.f227861b.setInterpolator(new LinearInterpolator());
        this.f227861b.setRepeatCount(-1);
        setAnimation(this.f227861b);
        this.f227861b.startNow();
        return;
    L13:
        setImageResource(R.drawable.ic_icon_tool_waituploading);
        setVisibility(0);
        return;
    }

    public SyncStateView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f227862c = new a(this);
        init();
    }

    public SyncStateView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f227862c = new a(this);
        init();
    }
}
