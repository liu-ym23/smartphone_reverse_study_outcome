package com.bytedance.ee.bear.list.docstate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SyncStateView extends LKUIRoundedImageView2 {
    public boolean a;
    public RotateAnimation b;
    public final a c;

    public class a implements Runnable {
        public final /* synthetic */ SyncStateView a;

        @Override // java.lang.Runnable
        public final void run() {
            SyncStateView r0 = this.a;     // Catch: Throwable -> L7
            if (r0.a == false) goto L5;
            r0.setSyncState(7);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            r0.setSyncState(0);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(SyncStateView r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        setVisibility(8);
        setBorderWidthInDp(1.0f);
        setRadiusInDp(6.0f);
        setBorderColor(getContext().getResources().getColor(2131103546));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        removeCallbacks(this.c);
        RotateAnimation r0 = this.b;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public SyncStateView(Context r1) {
        super(r1);
        this.c = new a(this);
        init();
    }

    public void setManualOffline(boolean r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSyncState(int r8) {
        tt5.a.h("SyncStateView", "setSyncState()...state = " + r8 + ", isManualOffline = " + this.a);
        setVisibility(8);
        clearAnimation();
        switch(r8) {
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
        setImageResource(2131235947);
        setVisibility(0);
        return;
    L6:
        setImageResource(2131235950);
        setVisibility(0);
        return;
    L7:
        setImageResource(2131235946);
        setVisibility(0);
        return;
    L8:
        setImageResource(2131235949);
        setVisibility(0);
        removeCallbacks(this.c);
        postDelayed(this.c, 1000);
        return;
    L9:
        setImageResource(2131235948);
        setVisibility(0);
        if (this.b != null) goto L12;
        this.b = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
    L12:
        this.b.reset();
        this.b.setDuration(800);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setRepeatCount(-1);
        setAnimation(this.b);
        this.b.startNow();
        return;
    L13:
        setImageResource(2131235951);
        setVisibility(0);
        return;
    }

    public SyncStateView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new a(this);
        init();
    }

    public SyncStateView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new a(this);
        init();
    }
}
