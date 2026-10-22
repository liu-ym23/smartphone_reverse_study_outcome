package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.utils.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtLoadingLayout extends FrameLayout implements f, h {
    public View a;
    public FrameLayout b;
    public int c;
    public TextView d;
    public boolean e;
    public int f;

    public final void b() {
        if (this.e == true) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        int r1 = r0.height;
        int[] r3 = new int[2];
        getLocationOnScreen(r3);
        int r4 = (((d0.c(getContext()) - this.f) - r3[1]) / 2) - (r1 / 2);
        r0.gravity = 49;
        r0.topMargin = r4;
        this.b.setLayoutParams(r0);
    }

    public DmtLoadingLayout(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        return;
    }

    public void setProgressBarInfo(int r2) {
        if (r2 <= 0) goto L5;
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        r0.width = r2;
        r0.height = r2;
        this.a.setLayoutParams(r0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r2) {
        this.e = true;
        this.f = r2;
        b();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(r2);
    }

    public void setWeakInfoShow(boolean r2) {
        if (r2 == false) goto L7;
        this.d.setVisibility(0);
        if (TextUtils.isEmpty("") == true) goto L6;
        this.d.setText("");
        return;
    L6:
        this.d.setText("网络信号弱，马上加载完成");
        return;
    L7:
        this.d.setVisibility(8);
    }

    public DmtLoadingLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DmtLoadingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = 1;
        View r4 = LayoutInflater.from(r1).inflate(2131558673, this, true);
        this.a = r4.findViewById(2131370123);
        this.b = (FrameLayout) r4.findViewById(2131383290);
        this.d = (TextView) r4.findViewById(2131393035);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b();
    }
}
