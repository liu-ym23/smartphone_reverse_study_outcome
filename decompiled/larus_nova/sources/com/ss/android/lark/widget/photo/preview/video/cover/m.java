package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.DonutProgress;

/* JADX INFO: loaded from: classes38.dex */
public final class m extends v0c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f447220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f447221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DonutProgress f447222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f447223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.ss.android.lark.widget.photopicker.utils.d f447224i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f447225a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f447225a.q(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r100) {
            this.f447225a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f447226a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f447226a.q(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(m r100) {
            this.f447226a = r100;
        }
    }

    @Override // v0c.o
    public final void g() {
        this.f447221f = this.f447220e.findViewById(R.id.loading_progress);
        this.f447222g = (DonutProgress) this.f447220e.findViewById(R.id.down_load_percent);
    }

    @Override // v0c.a
    public final void k() {
        v0c.r r100 = i();
        this.f447222g.setShowText(false);
        this.f447222g.setFinishedStrokeColor(UIUtils.getColor(this.f447223h, R.color.lkui_N00));
        this.f447222g.setUnfinishedStrokeColor(j08.b.c(this.f447223h, R.color.lkui_N00, 0.5f));
        float r101 = UIUtils.dp2px(this.f447223h, 2.0f);
        this.f447222g.setFinishedStrokeWidth(r101);
        this.f447222g.setUnfinishedStrokeWidth(r101);
        this.f447222g.setStartingDegree(-90);
        this.f447222g.setInnerBackgroundColor(j08.b.c(this.f447223h, R.color.lkui_N900, 0.5f));
        this.f447222g.setMax(100);
        if (r100 == null) goto L19;
        int r102 = r100.getState();
        if (r102 != (-2)) goto L7;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L19;
        r(r100.a());
        return;
    L7:
        if (r102 == (-1)) goto L16;
        if (r102 == 0) goto L16;
        r103 = true;
        if (r102 == 1) goto L16;
        if (r102 == 4) goto L16;
        if (r102 == 5) goto L16;
    L19:
        r(false);
    }

    public m(FragmentActivity r100) {
        super(r100);
        this.f447224i = new com.ss.android.lark.widget.photopicker.utils.d();
    }

    @Override // v0c.a
    public final View m(Context r100) {
        this.f447223h = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.online_loading_cover, null);
        this.f447220e = r101;
        return r101;
    }

    public final void r(boolean r110) {
        if (r110 == false) goto L8;
        this.f447222g.setVisibility(8);
        this.f447221f.setVisibility(0);
        com.ss.android.lark.widget.photopicker.utils.d r111 = this.f447224i;
        a r100 = new a(this);
        r111.f447651a = 0;
        r111.f447652b = false;
        Log.d("DelayShower", "show delay");
        com.ss.android.lark.widget.photopicker.utils.c r101 = new com.ss.android.lark.widget.photopicker.utils.c(r111, r100);
        long r102 = 300;
        if (r102 != 0) goto L7;
        r101.run();
        return;
    L7:
        UICallbackExecutor.executeDelayed(r101, r102);
        return;
    L8:
        com.ss.android.lark.widget.photopicker.utils.d r112 = this.f447224i;
        b r103 = new b(this);
        if (r112.f447652b == true) goto L11;
        Log.d("DelayShower", "hide and not need to show");
        r112.f447652b = true;
        long r104 = 0;
    L13:
        if (r104 > 0) goto L17;
        r104 = 0;
    L17:
        if (r104 != 0) goto L19;
        r103.run();
        return;
    L19:
        UICallbackExecutor.executeDelayed(r103, r104);
        return;
    L11:
        r104 = ((long) 300) - (System.currentTimeMillis() - r112.f447651a);
        goto L13
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        switch(r100) {
            case -99052: goto L5;
            case -99050: goto L4;
            case -99015: goto L5;
            case -99014: goto L5;
            case -99013: goto L4;
            case -99011: goto L5;
            case -99010: goto L4;
            case -99007: goto L5;
            case -99001: goto L4;
            default: goto L8;
        };
    L4:
        r(true);
        return;
    L5:
        r(false);
        return;
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        q(8);
    }
}
