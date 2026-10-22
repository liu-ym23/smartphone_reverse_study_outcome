package com.ss.android.photoeditor.mosaic.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.photoeditor.graffiti.ShowTipsSeekBarLinearLayout;
import com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy;
import com.ss.android.photoeditor.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pfc.f;
import pfc.k;
import pfc.u;
import vfc.g;
import vfc.m;
import vfc.o;

/* JADX INFO: loaded from: classes38.dex */
public class MosaicPhotoEditorPluginV2 extends RelativeLayout implements k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f449347n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f449348o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f449349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f449350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f449351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadioGroup f449352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MosaicViewV2 f449353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShowTipsSeekBarLinearLayout f449354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f449355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<ImageView, AbstractMosaicStrategy> f449356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AbstractMosaicStrategy f449357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k.a f449358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public pfc.c f449359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f449360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f449361m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicPhotoEditorPluginV2 f449362a;

        public a(MosaicPhotoEditorPluginV2 r100) {
            this.f449362a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MosaicPhotoEditorPluginV2.e(this.f449362a, (ImageView) r100);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicPhotoEditorPluginV2 f449363a;

        public final void a() {
            MosaicPhotoEditorPluginV2 r100 = this.f449363a;
            MosaicPhotoEditorPluginV2.e(r100, r100.f449349a);
            this.f449363a.f449354f.setProgress(50);
            MosaicPhotoEditorPluginV2.f(this.f449363a, 50);
            k.a r101 = this.f449363a.f449358j;
            if (r101 != null) goto L6;
        L10:
            boolean r102 = false;
        L11:
            if (r102 == true) goto L14;
            this.f449363a.f449352d.setVisibility(8);
            return;
        L14:
            return;
        L6:
            if (((ofc.a) ((u) r101).f529098a.f529100b).f523137a.f523149l == null) goto L10;
            if (p0c.a.a().isFeatureGatingEnable("image_editor.smart_mosaic") == false) goto L10;
            r102 = true;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MosaicPhotoEditorPluginV2 r100) {
            this.f449363a = r100;
        }
    }

    static {
        f449347n = d.b(2);
        f449348o = d.b(10);
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
        MosaicViewV2 r100 = this.f449353e;
        r100.getClass();
        f.a r101 = f.i().k();
        f.b r102 = f.i().e();
        if (r101 == null) goto L5;
        r101.c(r102);
    L5:
        r100.o(r102);
    }

    @Override // pfc.k
    public final void b() {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.a("mosaic");
    }

    @Override // pfc.k
    public final void create() {
        ((u) this.f449358j).f529098a.f529106h.setVisibility(0);
        ((u) this.f449358j).f529098a.f529111m.setVisibility(0);
        MosaicViewV2 r100 = this.f449353e;
        b r101 = new b(this);
        r100.getClass();
        com.ss.android.photoeditor.util.c.a(r100, new vfc.f(r100, r101));
    }

    @Override // pfc.k
    public final void destroy() {
        MosaicViewV2 r100 = this.f449353e;
        if (r100 == null) goto L7;
        com.ss.android.photoeditor.util.b.e(r100.f449367d);
        AbstractMosaicStrategy r101 = r100.f449366c;
        if (r101 == null) goto L7;
        r101.a();
    L7:
        o r102 = this.f449360l;
        if (r102 == null) goto L14;
        m r103 = new m(r102);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L12;
        r103.run();
        return;
    L12:
        new Handler(Looper.getMainLooper()).post(r103);
        return;
    }

    @Override // pfc.k
    public RectF getLocation() {
        return this.f449353e.getLocation();
    }

    @Override // pfc.k
    public final void restart() {
        ((u) this.f449358j).f529098a.f529111m.setVisibility(0);
        ((u) this.f449358j).f529098a.f529106h.setVisibility(0);
        this.f449359k.b();
        MosaicViewV2 r100 = this.f449353e;
        r100.getClass();
        Bitmap r101 = f.i().h();
        r100.setImageBitmap(r101);
        if (f.i().j(r100.f449389z) == false) goto L5;
        com.ss.android.photoeditor.util.c.a(r100, new g(r100));
        r100.invalidate();
        return;
    L5:
        r100.f449368e = Bitmap.createScaledBitmap(r101, (int) r100.f449384u.width(), (int) r100.f449384u.height(), true);
        r100.f449369f = new Canvas(r100.f449368e);
        r100.f449370g = Bitmap.createBitmap(r100.f449368e);
        r100.f449371h = new Canvas(r100.f449370g);
        r100.setStrategy(r100.f449366c);
        r100.n();
        r100.invalidate();
    }

    @Override // pfc.k
    public final void stop() {
        MosaicViewV2 r100 = this.f449353e;
        r100.getClass();
        r100.f449389z = f.i().f();
    }

    public final void g() {
        this.f449349a = (ImageView) findViewById(R.id.iv_normal_mosaic);
        this.f449350b = (ImageView) findViewById(R.id.iv_brush_mosaic);
        this.f449353e = (MosaicViewV2) findViewById(R.id.mosaic_vew);
        this.f449355g = findViewById(R.id.rl_mosaic_select);
        this.f449354f = (ShowTipsSeekBarLinearLayout) findViewById(R.id.show_tips_seek_bar_ll);
        RadioButton r100 = (RadioButton) findViewById(R.id.path_radioBtn);
        this.f449351c = (RadioButton) findViewById(R.id.rect_radioBtn);
        this.f449352d = (RadioGroup) findViewById(R.id.selection_group);
        this.f449354f.setOnSeekBarChangeListener(new vfc.b(this));
        this.f449353e.setMotionEventListener(new com.ss.android.photoeditor.mosaic.v2.b(this));
        this.f449349a.setOnClickListener(this.f449361m);
        this.f449350b.setOnClickListener(this.f449361m);
        this.f449352d.check(R.id.path_radioBtn);
        this.f449352d.setOnCheckedChangeListener(new vfc.c(this));
        HashMap r101 = new HashMap();
        this.f449356h = r101;
        r101.put(this.f449349a, new c(getContext(), AbstractMosaicStrategy.Effect.NORMAL_MOSAIC));
        Map<ImageView, AbstractMosaicStrategy> r102 = this.f449356h;
        HashMap r103 = (HashMap) r102;
        r103.put(this.f449350b, new c(getContext(), AbstractMosaicStrategy.Effect.GAUSSIAN_BLUR));
        this.f449359k = new pfc.c(this.f449355g);
        this.f449360l = new o(getContext());
    }

    public MosaicPhotoEditorPluginV2(Context r100) {
        super(r100);
        this.f449361m = new a(this);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_mosaic_plugin_v2, this);
        g();
    }

    private void setMosaicType(ImageView r100) {
        Iterator r101 = ((HashMap) this.f449356h).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ImageView) r101.next()).setSelected(false);
        goto L4
    L6:
        r100.setSelected(true);
        this.f449357i = (AbstractMosaicStrategy) ((HashMap) this.f449356h).get(r100);
        int r102 = this.f449352d.getCheckedRadioButtonId();
        if (r102 != R.id.path_radioBtn) goto L10;
        AbstractMosaicStrategy r103 = this.f449357i;
        r103.f449252h = AbstractMosaicStrategy.SelectionMode.PATH;
    L12:
        this.f449353e.setStrategy(this.f449357i);
        if (this.f449357i.f449252h != AbstractMosaicStrategy.SelectionMode.PATH) goto L15;
        sfc.a.f541747a.getClass();
        ((ArrayList) sfc.a.f541756j).add(1);
        return;
    L15:
        sfc.a.f541747a.getClass();
        ((ArrayList) sfc.a.f541756j).add(2);
        return;
    L10:
        if (r102 != R.id.rect_radioBtn) goto L12;
        AbstractMosaicStrategy r104 = this.f449357i;
        r104.f449252h = AbstractMosaicStrategy.SelectionMode.RECT;
        goto L12
    }

    private void setPaintSizeByProgress(int r100) {
        int r101 = f449348o;
        int r102 = f449347n;
        this.f449353e.setPaintSize((int) (((r100 / 100.0f) * (r101 - r102)) + r102));
    }

    @Override // pfc.k
    public void setImageBitmap(Bitmap r100) {
        this.f449353e.setImageBitmap(r100);
    }

    @Override // pfc.k
    public void setPluginContext(k.a r100) {
        this.f449358j = r100;
    }

    public static /* synthetic */ void e(MosaicPhotoEditorPluginV2 r100, ImageView r101) {
        r100.setMosaicType(r101);
    }

    public static /* synthetic */ void f(MosaicPhotoEditorPluginV2 r100, int r101) {
        r100.setPaintSizeByProgress(r101);
    }

    @Override // pfc.k
    public final void c(RectF r100, boolean r101) {
        MosaicViewV2 r102 = this.f449353e;
        r102.f449364a = r100;
        r102.f449365b = r101;
    }

    public MosaicPhotoEditorPluginV2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449361m = new a(this);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_mosaic_plugin_v2, this);
        g();
    }
}
