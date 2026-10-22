package com.ss.android.photoeditor.text;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.photoeditor.base.view.ColorChoiceView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import pfc.k;
import pfc.u;

/* JADX INFO: loaded from: classes38.dex */
public class TextPhotoEditorPlugin extends RelativeLayout implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextEditorView f449513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorChoiceView f449514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pfc.c f449515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k.a f449516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f449517e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextPhotoEditorPlugin f449518a;

        @Override // java.lang.Runnable
        public final void run() {
            ColorChoiceView r100 = this.f449518a.f449514b;     // Catch: Throwable -> L6
            ColorChoiceView.ChoiceColor r101 = ColorChoiceView.ChoiceColor.RED;     // Catch: Throwable -> L6
            TextView r102 = (TextView) ((HashMap) r100.f449158i).get(r101);     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            r100.c(r102);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(TextPhotoEditorPlugin r100) {
            this.f449518a = r100;
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
        TextEditorDrawView r100 = this.f449513a.f449491a;
        r100.getClass();
        pfc.f.a r101 = pfc.f.i().k();
        if (r101 == null) goto L11;
        r100.setImageBitmap(pfc.f.i().h());
        pfc.f.b r102 = pfc.f.i().e();
        r101.c(r102);
        if (r102.f529061d == false) goto L8;
        com.ss.android.photoeditor.util.c.a(r100, new com.ss.android.photoeditor.text.a(r100, null));
    L9:
        r100.invalidate();
        return;
    L8:
        r100.f449432i = Bitmap.createScaledBitmap(r100.f449428e, (int) r100.f449447x.width(), (int) r100.f449447x.height(), true);
        r100.m(true);
        goto L9
    }

    @Override // pfc.k
    public final void b() {
        sfc.a.f541747a.getClass();
        sfc.a.C7605a.a("text");
    }

    @Override // pfc.k
    public final void create() {
        ((u) this.f449516d).f529098a.f529111m.setVisibility(0);
        ((u) this.f449516d).f529098a.f529106h.setVisibility(0);
        TextEditorView r100 = this.f449513a;
        a r101 = new a(this);
        r100.getClass();
        com.ss.android.photoeditor.util.c.a(r100, new f(r100, r101));
    }

    @Override // pfc.k
    public final void destroy() {
        TextEditorDrawView r100 = this.f449513a.f449491a;
        com.ss.android.photoeditor.util.b.e(r100.f449428e);
        com.ss.android.photoeditor.util.b.e(r100.f449429f);
        com.ss.android.photoeditor.util.b.e(r100.f449431h);
    }

    @Override // pfc.k
    public RectF getLocation() {
        return this.f449513a.getLocation();
    }

    @Override // pfc.k
    public final void restart() {
        ((u) this.f449516d).f529098a.f529111m.setVisibility(0);
        RelativeLayout r100 = ((u) this.f449516d).f529098a.f529106h;
        if (this.f449513a.f449497g == false) goto L5;
        int r101 = 0;
    L6:
        r100.setVisibility(r101);
        this.f449515c.b();
        TextEditorDrawView r102 = this.f449513a.f449491a;
        Iterator r103 = ((HashMap) r102.A).keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        wfc.e r104 = (wfc.e) r103.next();
        ((TextEditorDrawView.g) ((HashMap) r102.A).get(r104)).f449456c = false;
        goto L8
    L10:
        wfc.e r105 = r102.f449440q;
        if (r105 != null) goto L13;
    L15:
        r102.setImageBitmap(pfc.f.i().h());
        if (pfc.f.i().j(r102.f449427d) == false) goto L18;
        com.ss.android.photoeditor.util.c.a(r102, new com.ss.android.photoeditor.text.a(r102, new wfc.b(r102)));
    L19:
        r102.invalidate();
        return;
    L18:
        r102.f449432i = Bitmap.createScaledBitmap(r102.f449428e, (int) r102.f449447x.width(), (int) r102.f449447x.height(), true);
        com.ss.android.photoeditor.util.c.a(r102, new wfc.c(r102));
        goto L19
    L13:
        if (r105.f559525q == true) goto L15;
        r105.f559525q = true;
        r105.b();
        goto L15
    L5:
        r101 = 8;
        goto L6
    }

    @Override // pfc.k
    public final void stop() {
        TextEditorDrawView r100 = this.f449513a.f449491a;
        Iterator r101 = ((HashMap) r100.A).keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((TextEditorDrawView.g) ((HashMap) r100.A).get((wfc.e) r101.next())).f449456c = true;
        goto L4
    L6:
        wfc.e r102 = r100.f449440q;
        if (r102 != null) goto L9;
    L11:
        r100.f449427d = pfc.f.i().f();
        pfc.f r103 = pfc.f.i();
        if (((ArrayList) r103.f529050b).size() <= 1) goto L40;
        int r104 = 0;
    L16:
        if (r104 >= ((ArrayList) r103.f529050b).size()) goto L18;
        ((pfc.f.a) ListProtector.get(r103.f529050b, r104)).f529057b = null;
        r104 = r104 + 1;
        goto L16
    L18:
        pfc.f.f529048i = true;
        int r105 = 3;
    L20:
        if (r105 >= ((ArrayList) r103.f529050b).size()) goto L31;
        pfc.f.b r106 = r103.e();
        int r107 = r105 - 1;
    L22:
        if (r107 < 0) goto L27;
        if (((pfc.f.a) ListProtector.get(r103.f529050b, r107)).f529057b != null) goto L25;
        r107 = r107 - 1;
        goto L22
    L25:
        r106 = new pfc.f.b(((pfc.f.a) ListProtector.get(r103.f529050b, r107)).f529057b);
    L27:
        r107 = r107 + 1;
        if (r107 > r105) goto L30;
        r106.a((pfc.f.a) ListProtector.get(r103.f529050b, r107));
        goto L27
    L30:
        ((pfc.f.a) ListProtector.get(r103.f529050b, r105)).f529057b = r106;
        r105 = r105 + 4;
        goto L20
    L31:
        pfc.f.f529048i = false;
        return;
    L40:
        return;
    L9:
        if (r102.f559525q == false) goto L11;
        r102.f559525q = false;
        r102.b();
        goto L11
    }

    public final void e() {
        TextEditorView r100 = (TextEditorView) findViewById(R.id.text_editor_view);
        this.f449513a = r100;
        r100.setActivity((Activity) getContext());
        this.f449514b = (ColorChoiceView) findViewById(R.id.color_choice_view);
        this.f449517e = findViewById(R.id.ll_paint_color_choice);
        wfc.d r101 = new wfc.d(this);
        this.f449514b.setOnColorChangedListener(r101);
        this.f449513a.setBottomColorChoiceView(this.f449514b);
        this.f449513a.setOnColorChangedListener(new g(this, r101));
        this.f449515c = new pfc.c(this.f449517e);
        this.f449513a.setToolBarVisiableCallback(new h(this));
    }

    public TextPhotoEditorPlugin(Context r100) {
        super(r100);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_text_plugin, this);
        e();
    }

    @Override // pfc.k
    public void setImageBitmap(Bitmap r100) {
        this.f449513a.setImageBitmap(r100);
    }

    @Override // pfc.k
    public void setPluginContext(k.a r100) {
        this.f449516d = r100;
        this.f449513a.setPluginContext(r100);
    }

    public TextPhotoEditorPlugin(Context r100, AttributeSet r101) {
        super(r100, r101);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_text_plugin, this);
        e();
    }

    @Override // pfc.k
    public final void c(RectF r100, boolean r101) {
        TextEditorDrawView r102 = this.f449513a.f449491a;
        r102.f449425b = r100;
        r102.f449426c = r101;
    }

    public TextPhotoEditorPlugin(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_text_plugin, this);
        e();
    }
}
