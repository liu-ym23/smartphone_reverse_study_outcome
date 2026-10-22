package com.ss.android.photoeditor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.photoeditor.graffiti.ShowTipsSeekBarLinearLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pfc.f;
import pfc.k;
import pfc.u;
import tfc.d;
import tfc.e;
import tfc.h;
import tfc.i;
import tfc.j;

/* JADX INFO: loaded from: classes38.dex */
public class MosaicPhotoEditorPlugin extends RelativeLayout implements k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f449262s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f449263t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f449264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f449265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f449266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f449267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f449268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f449269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MosaicView f449270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShowTipsSeekBarLinearLayout f449271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f449272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f449273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<ImageView, AbstractMosaicStrategy> f449274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AbstractMosaicStrategy f449275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k.a f449276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<RectF> f449277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.ss.android.photoeditor.mosaic.c.a f449278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f449279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public pfc.c f449280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f449281r;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicPhotoEditorPlugin f449282a;

        public a(MosaicPhotoEditorPlugin r100) {
            this.f449282a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            MosaicPhotoEditorPlugin.e(this.f449282a, (ImageView) r100);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicPhotoEditorPlugin f449283a;

        public final void a() {
            MosaicPhotoEditorPlugin r100 = this.f449283a;
            int r101 = MosaicPhotoEditorPlugin.f449262s;
            boolean r102 = !CollectionUtils.isEmpty(r100.f449277n);
            View r103 = r100.f449266c;
            int r104 = 0;
            if (r103 == null) goto L8;
            if (r102 == false) goto L6;
            int r105 = 8;
        L7:
            r103.setVisibility(r105);
            goto L8
        L6:
            r105 = 0;
        L8:
            View r106 = r100.f449267d;
            if (r106 == null) goto L14;
            if (r102 == true) goto L13;
            r104 = 8;
        L13:
            r106.setVisibility(r104);
        L14:
            r100.i();
            MosaicPhotoEditorPlugin r107 = this.f449283a;
            MosaicPhotoEditorPlugin.e(r107, MosaicPhotoEditorPlugin.f(r107));
            this.f449283a.f449271h.setProgress(50);
            MosaicPhotoEditorPlugin.g(this.f449283a, 50);
            MosaicPhotoEditorPlugin r108 = this.f449283a;
            TextView r109 = r108.f449273j;
            if (r109 == null) goto L19;
            r109.setSelected(r108.f449279p);
            return;
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

        public b(MosaicPhotoEditorPlugin r100) {
            this.f449283a = r100;
        }
    }

    public static class c extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.photoeditor.mosaic.c.a f449284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.ss.android.photoeditor.mosaic.c.b f449285d;

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            return r100;
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return null;
        }

        @Override // pfc.f.a
        public final void k() {
            this.f449284c.f449340c = true;
            f r100 = f.i();
            Handler r101 = r100.f529054f;
            if (r101 == null) goto L5;
            r101.removeCallbacksAndMessages(null);
        L5:
            Iterator r102 = ((ArrayList) r100.f529051c).iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            f.a r103 = (f.a) r102.next();
            f.b r104 = r103.f529057b;
            if (r104 == null) goto L7;
            r104.f529062e = null;
            r104.f529063f = null;
            r103.f529057b = null;
            goto L7
        L11:
            Iterator r105 = ((ArrayList) r100.f529050b).iterator();
        L13:
            if (r105.hasNext() == false) goto L17;
            f.a r106 = (f.a) r105.next();
            f.b r107 = r106.f529057b;
            if (r107 == null) goto L13;
            r107.f529062e = null;
            r107.f529063f = null;
            r106.f529057b = null;
            goto L13
        L17:
            this.f449285d.a(this.f449284c);
        }

        public c(com.ss.android.photoeditor.mosaic.c.a r100, d r101) {
            this.f449284c = r100;
            this.f449285d = r101;
        }
    }

    static {
        f449262s = com.ss.android.photoeditor.util.d.b(2);
        f449263t = com.ss.android.photoeditor.util.d.b(10);
    }

    @Override // pfc.k
    public final boolean d() {
        return true;
    }

    @Override // pfc.k
    public View getEditView() {
        return this;
    }

    private ImageView getActiveBrushMosaicIV() {
        if ((!CollectionUtils.isEmpty(this.f449277n)) == false) goto L6;
        return this.f449269f;
    L6:
        return this.f449265b;
    }

    private ImageView getActiveNormalMosaicIV() {
        if ((!CollectionUtils.isEmpty(this.f449277n)) == false) goto L6;
        return this.f449268e;
    L6:
        return this.f449264a;
    }

    @Override // pfc.k
    public final void a() {
        MosaicView r100 = this.f449270g;
        r100.getClass();
        f.a r101 = f.i().k();
        f.b r102 = f.i().e();
        if (r101 == null) goto L5;
        r101.c(r102);
    L5:
        Bitmap r103 = f.i().h();
        r100.setImageBitmap(r103);
        if (r102.f529061d == false) goto L8;
        com.ss.android.photoeditor.util.c.a(r100, new j(r100, r103));
        r100.invalidate();
        return;
    L8:
        r100.f449290e = r100.j(r103);
        r100.f449291f = new Canvas(r100.f449290e);
        r100.setStrategy(r100.f449288c);
        r100.invalidate();
    }

    @Override // pfc.k
    public final void b() {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.a("mosaic");
    }

    @Override // pfc.k
    public final void create() {
        boolean r100 = false;
        ((u) this.f449276m).f529098a.f529106h.setVisibility(0);
        ((u) this.f449276m).f529098a.f529111m.setVisibility(0);
        if (this.f449277n != null) goto L10;
        k.a r101 = this.f449276m;
        if (r101 == null) goto L10;
        List<RectF> r102 = ((ofc.a) ((u) r101).f529098a.f529100b).f523137a.f523151n;
        this.f449277n = r102;
        if (r102 == null) goto L10;
        r102.size();
    L10:
        k.a r103 = this.f449276m;
        if (r103 != null) goto L13;
    L17:
        this.f449270g.setLongImageZoomEnabled(r100);
        MosaicView r104 = this.f449270g;
        b r105 = new b(this);
        r104.getClass();
        com.ss.android.photoeditor.util.c.a(r104, new h(r104, r105));
        return;
    L13:
        if (((ofc.a) ((u) r103).f529098a.f529100b).f523137a.f523154q == false) goto L17;
        if (CollectionUtils.isEmpty(this.f449277n) == true) goto L17;
        r100 = true;
        goto L17
    }

    @Override // pfc.k
    public final void destroy() {
        MosaicView r100 = this.f449270g;
        if (r100 == null) goto L8;
        com.ss.android.photoeditor.util.b.e(r100.f449289d);
        AbstractMosaicStrategy r101 = r100.f449288c;
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    }

    @Override // pfc.k
    public RectF getLocation() {
        return this.f449270g.getLocation();
    }

    public final void i() {
        HashMap r100 = new HashMap();
        this.f449274k = r100;
        r100.put(getActiveNormalMosaicIV(), new com.ss.android.photoeditor.mosaic.c(getContext()));
        this.f449274k.put(getActiveBrushMosaicIV(), new com.ss.android.photoeditor.mosaic.a(getContext()));
    }

    @Override // pfc.k
    public final void restart() {
        ((u) this.f449276m).f529098a.f529111m.setVisibility(0);
        ((u) this.f449276m).f529098a.f529106h.setVisibility(0);
        TextView r100 = this.f449273j;
        if (r100 == null) goto L6;
        r100.setSelected(this.f449279p);
    L6:
        this.f449280q.b();
        MosaicView r101 = this.f449270g;
        r101.getClass();
        if (f.i().j(r101.f449301p) == false) goto L9;
        com.ss.android.photoeditor.util.c.a(r101, new i(r101));
        r101.invalidate();
        return;
    L9:
        r101.f449290e = r101.j(r101.f449289d);
        r101.f449291f = new Canvas(r101.f449290e);
        r101.setStrategy(r101.f449288c);
        r101.l();
        r101.invalidate();
    }

    @Override // pfc.k
    public final void stop() {
        MosaicView r100 = this.f449270g;
        r100.getClass();
        r100.f449301p = f.i().f();
    }

    public final void h() {
        this.f449264a = (ImageView) findViewById(R.id.iv_normal_mosaic);
        this.f449265b = (ImageView) findViewById(R.id.iv_brush_mosaic);
        this.f449266c = findViewById(R.id.ll_mosaic_type_choice);
        this.f449267d = findViewById(R.id.ll_mosaic_secondary_tools);
        this.f449268e = (ImageView) findViewById(R.id.iv_normal_mosaic_compact);
        this.f449269f = (ImageView) findViewById(R.id.iv_brush_mosaic_compact);
        this.f449270g = (MosaicView) findViewById(R.id.mosaic_vew);
        this.f449272i = findViewById(R.id.rl_mosaic_select);
        this.f449271h = (ShowTipsSeekBarLinearLayout) findViewById(R.id.show_tips_seek_bar_ll);
        TextView r100 = (TextView) findViewById(R.id.tv_preset_mask_toggle);
        this.f449273j = r100;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new e(this));
    L5:
        this.f449271h.setOnSeekBarChangeListener(new tfc.f(this));
        this.f449270g.setMotionEventListener(new com.ss.android.photoeditor.mosaic.b(this));
        this.f449264a.setOnClickListener(this.f449281r);
        this.f449265b.setOnClickListener(this.f449281r);
        ImageView r101 = this.f449268e;
        if (r101 == null) goto L8;
        r101.setOnClickListener(this.f449281r);
    L8:
        ImageView r102 = this.f449269f;
        if (r102 == null) goto L11;
        r102.setOnClickListener(this.f449281r);
    L11:
        i();
        this.f449280q = new pfc.c(this.f449272i);
    }

    public MosaicPhotoEditorPlugin(Context r100) {
        super(r100);
        this.f449279p = false;
        this.f449281r = new a(this);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_mosaic_plugin, this);
        h();
    }

    public static /* synthetic */ ImageView f(MosaicPhotoEditorPlugin r100) {
        return r100.getActiveNormalMosaicIV();
    }

    private void setMosaicType(ImageView r100) {
        Iterator r101 = ((HashMap) this.f449274k).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ImageView) r101.next()).setSelected(false);
        goto L4
    L6:
        r100.setSelected(true);
        AbstractMosaicStrategy r102 = (AbstractMosaicStrategy) ((HashMap) this.f449274k).get(r100);
        this.f449275l = r102;
        this.f449270g.setStrategy(r102);
        if ((this.f449275l instanceof com.ss.android.photoeditor.mosaic.c) == false) goto L9;
        sfc.a.f541747a.getClass();
        ((ArrayList) sfc.a.f541756j).add(1);
        return;
    L9:
        sfc.a.f541747a.getClass();
        ((ArrayList) sfc.a.f541756j).add(2);
    }

    private void setPaintSizeByProgress(int r100) {
        int r101 = f449263t;
        int r102 = f449262s;
        this.f449270g.setPaintSize((int) (((r100 / 100.0f) * (r101 - r102)) + r102));
    }

    @Override // pfc.k
    public void setImageBitmap(Bitmap r100) {
        this.f449270g.setImageBitmap(r100);
    }

    @Override // pfc.k
    public void setPluginContext(k.a r100) {
        this.f449276m = r100;
    }

    public static /* synthetic */ void e(MosaicPhotoEditorPlugin r100, ImageView r101) {
        r100.setMosaicType(r101);
    }

    public static /* synthetic */ void g(MosaicPhotoEditorPlugin r100, int r101) {
        r100.setPaintSizeByProgress(r101);
    }

    @Override // pfc.k
    public final void c(RectF r100, boolean r101) {
        MosaicView r102 = this.f449270g;
        r102.f449286a = r100;
        r102.f449287b = r101;
    }

    public MosaicPhotoEditorPlugin(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449279p = false;
        this.f449281r = new a(this);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_mosaic_plugin, this);
        h();
    }
}
