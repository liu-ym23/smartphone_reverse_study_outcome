package com.ss.android.photoeditor.graffiti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.base.view.ColorChoiceView;
import java.util.HashMap;
import pfc.f;
import pfc.k;
import pfc.u;
import rfc.g;

/* JADX INFO: loaded from: classes38.dex */
public class GraffitiPhotoEditorPlugin extends RelativeLayout implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GraffitiView f449192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ShowTipsSeekBarLinearLayout f449193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k.a f449194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f449195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorChoiceView f449196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public pfc.c f449197f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GraffitiPhotoEditorPlugin f449198a;

        @Override // java.lang.Runnable
        public final void run() {
            ColorChoiceView r100 = this.f449198a.f449196e;     // Catch: Throwable -> L7
            ColorChoiceView.ChoiceColor r101 = ColorChoiceView.ChoiceColor.RED;     // Catch: Throwable -> L7
            TextView r102 = (TextView) ((HashMap) r100.f449158i).get(r101);     // Catch: Throwable -> L7
            if (r102 == null) goto L5;
            r100.c(r102);     // Catch: Throwable -> L7
        L5:
            this.f449198a.setPaintSizeSeekBarProgress(50);     // Catch: Throwable -> L7
            GraffitiPhotoEditorPlugin.e(this.f449198a, 50);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(GraffitiPhotoEditorPlugin r100) {
            this.f449198a = r100;
        }
    }

    @Override // pfc.k
    public final boolean d() {
        return true;
    }

    @Override // pfc.k
    public View getEditView() {
        return this;
    }

    @Override // pfc.k
    public final void a() {
        GraffitiView r100 = this.f449192a;
        r100.getClass();
        Log.i("GraffitiView", "undo");
        f.a r101 = f.i().k();
        if (r101 == null) goto L11;
        f.b r102 = f.i().e();
        r101.c(r102);
        if (r102.f529061d == false) goto L8;
        r100.setImageBitmap(f.i().h());
        Log.i("GraffitiView", "refresh");
        com.ss.android.photoeditor.util.c.a(r100, new g(r100));
        return;
    L8:
        Bitmap r103 = Bitmap.createScaledBitmap(f.i().h(), r100.f449206g, r100.f449207h, true);
        r100.setImageBitmap(r103);
        r100.f449209j.e(r103);
        return;
    }

    @Override // pfc.k
    public final void b() {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.a("brush");
    }

    @Override // pfc.k
    public final void create() {
        ((u) this.f449194c).f529098a.f529111m.setVisibility(0);
        ((u) this.f449194c).f529098a.f529106h.setVisibility(0);
        GraffitiView r100 = this.f449192a;
        a r101 = new a(this);
        r100.getClass();
        Log.i("GraffitiView", "prepare");
        r100.f449200a = r101;
        com.ss.android.photoeditor.util.c.a(r100, new rfc.c(r100, r101));
    }

    @Override // pfc.k
    public final void destroy() {
        GraffitiView r100 = this.f449192a;
        r100.getClass();
        Log.i("GraffitiView", MapMonitorConst.EVENT_DESTROY);
        com.ss.android.photoeditor.util.b.e(r100.f449203d);
        com.ss.android.photoeditor.util.b.e(r100.f449204e);
        b r101 = r100.f449209j;
        if (r101 == null) goto L6;
        com.ss.android.photoeditor.util.b.e(r101.f449225h);
        com.ss.android.photoeditor.util.b.e(r101.f449224g);
        return;
    }

    @Override // pfc.k
    public RectF getLocation() {
        return this.f449192a.getLocation();
    }

    @Override // pfc.k
    public final void restart() {
        ((u) this.f449194c).f529098a.f529111m.setVisibility(0);
        ((u) this.f449194c).f529098a.f529106h.setVisibility(0);
        this.f449197f.b();
        GraffitiView r100 = this.f449192a;
        r100.getClass();
        Log.i("GraffitiView", IPerformanceManager.MODULE_RESTART);
        if (f.i().j(r100.f449212m) == false) goto L5;
        b r101 = r100.f449209j;
        rfc.d r102 = new rfc.d(r100, r101.f449232o, r101.f449231n);
        Log.i("GraffitiView", "prepare");
        r100.f449200a = r102;
        com.ss.android.photoeditor.util.c.a(r100, new rfc.c(r100, r102));
        return;
    L5:
        r100.f449209j.e(r100.f449203d);
        r100.m();
    }

    @Override // pfc.k
    public final void stop() {
        GraffitiView r100 = this.f449192a;
        r100.getClass();
        Log.i("GraffitiView", "stop");
        r100.f449212m = f.i().f();
    }

    public final void f() {
        this.f449192a = (GraffitiView) findViewById(R.id.graffiti_view);
        View r100 = findViewById(R.id.rl_graffiti_setting);
        this.f449195d = r100;
        r100.setBackgroundColor(UIUtils.getColor(getContext(), R.color.transparent));
        this.f449196e = (ColorChoiceView) findViewById(R.id.ll_paint_color_choice);
        this.f449193b = (ShowTipsSeekBarLinearLayout) findViewById(R.id.show_tips_seek_bar_ll);
        this.f449196e.setOnColorChangedListener(new rfc.a(this));
        this.f449192a.setMotionEventListener(new c(this));
        this.f449193b.setOnSeekBarChangeListener(new rfc.b(this));
        this.f449197f = new pfc.c(this.f449195d);
    }

    public GraffitiPhotoEditorPlugin(Context r100) {
        super(r100);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_graffiti_plugin, this);
        f();
    }

    private void setPaintSizeByProgress(int r100) {
        this.f449192a.setPaintSize(com.ss.android.photoeditor.util.d.b((int) (((r100 / 100.0f) * 6.0f) + 2.0f)));
    }

    @Override // pfc.k
    public void setImageBitmap(Bitmap r100) {
        this.f449192a.setImageBitmap(r100);
    }

    public void setPaintSizeSeekBarProgress(int r100) {
        this.f449193b.setProgress(r100);
    }

    @Override // pfc.k
    public void setPluginContext(k.a r100) {
        this.f449194c = r100;
    }

    public static /* synthetic */ void e(GraffitiPhotoEditorPlugin r100, int r101) {
        r100.setPaintSizeByProgress(r101);
    }

    @Override // pfc.k
    public final void c(RectF r100, boolean r101) {
        GraffitiView r102 = this.f449192a;
        r102.f449201b = r100;
        r102.f449202c = r101;
    }

    public GraffitiPhotoEditorPlugin(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_graffiti_plugin, this);
        f();
    }
}
