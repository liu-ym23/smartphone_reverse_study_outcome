package com.ss.android.photoeditor.crop_rotate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXMode;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.photoeditor.util.b;
import com.ss.android.photoeditor.util.c;
import pfc.k;
import pfc.u;
import qfc.f;
import qfc.g;
import qfc.h;
import qfc.i;
import qfc.x;
import sfc.a;

/* JADX INFO: loaded from: classes38.dex */
public class ClipPhotoEditorPlugin extends RelativeLayout implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoClipView f449164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f449165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f449166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f449167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f449168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f449169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k.a f449170g;

    @Override // pfc.k
    public final void a() {
    }

    @Override // pfc.k
    public final boolean d() {
        return false;
    }

    @Override // pfc.k
    public View getEditView() {
        return this;
    }

    @Override // pfc.k
    public final void b() {
        a.f541747a.getClass();
        a.C7605a.a(GXMode.MODE_TYPE_CROP);
    }

    @Override // pfc.k
    public final void create() {
        int r100 = 8;
        ((u) this.f449170g).f529098a.f529106h.setVisibility(8);
        ((u) this.f449170g).f529098a.f529111m.setVisibility(8);
        boolean r101 = !CollectionUtils.isEmpty(((ofc.a) ((u) this.f449170g).f529098a.f529100b).f523137a.f523151n);
        TextView r102 = this.f449167d;
        if (r102 == null) goto L8;
        if (r101 == true) goto L7;
        r100 = 0;
    L7:
        r102.setVisibility(r100);
    L8:
        TextView r103 = this.f449169f;
        if (r103 == null) goto L14;
        if (r101 == false) goto L12;
        int r104 = R.string.Lark_ImageViewer_Crop;
    L13:
        r103.setText(r104);
        goto L14
    L12:
        r104 = R.string.Lark_Legacy_ClipEditRotateAndCrop;
    L14:
        this.f449164a.setIfFixClipRatio(((ofc.a) ((u) this.f449170g).f529098a.f529100b).f523137a.f523152o);
        this.f449164a.setCustomClipRatio(((ofc.a) ((u) this.f449170g).f529098a.f529100b).f523137a.f523153p);
        PhotoClipView r105 = this.f449164a;
        r105.getClass();
        c.a(r105, new x(r105));
        if (((u) this.f449170g).f529098a.f529102d.size() != 1) goto L18;
        this.f449169f.setVisibility(4);
        return;
    }

    @Override // pfc.k
    public final void destroy() {
        b.e(this.f449164a.f449174c);
    }

    @Override // pfc.k
    public RectF getLocation() {
        return this.f449164a.getClipRect();
    }

    @Override // pfc.k
    public final void restart() {
        ((u) this.f449170g).f529098a.f529106h.setVisibility(8);
        ((u) this.f449170g).f529098a.f529111m.setVisibility(8);
        this.f449164a.m();
    }

    @Override // pfc.k
    public final void stop() {
        if (((u) this.f449170g).f529098a.f529102d.size() == 1) goto L6;
        ((u) this.f449170g).f529098a.f529106h.setVisibility(0);
        ((u) this.f449170g).f529098a.f529111m.setVisibility(0);
        return;
    }

    public final void e() {
        this.f449164a = (PhotoClipView) findViewById(R.id.photo_clip_view);
        this.f449167d = (TextView) findViewById(R.id.tv_rotate);
        this.f449168e = (TextView) findViewById(R.id.tv_reset);
        this.f449165b = (TextView) findViewById(R.id.tv_cancel);
        this.f449166c = (TextView) findViewById(R.id.tv_finish);
        this.f449169f = (TextView) findViewById(R.id.tv_text_clip);
        this.f449167d.setOnClickListener(new f(this));
        this.f449168e.setOnClickListener(new g(this));
        this.f449165b.setOnClickListener(new h(this));
        this.f449166c.setOnClickListener(new i(this));
        WindowInsetsUtils.g(findViewById(R.id.rl_photo_editor_clip), false, true);
    }

    public ClipPhotoEditorPlugin(Context r100) {
        super(r100);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_clip_plugin, this);
        e();
    }

    @Override // pfc.k
    public void setImageBitmap(Bitmap r100) {
        this.f449164a.setImageBitmap(r100);
    }

    @Override // pfc.k
    public void setPluginContext(k.a r100) {
        this.f449170g = r100;
    }

    public ClipPhotoEditorPlugin(Context r100, AttributeSet r101) {
        super(r100, r101);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_clip_plugin, this);
        e();
    }

    @Override // pfc.k
    public final void c(RectF r100, boolean r101) {
        this.f449164a.setPreLocation(r100);
    }

    public ClipPhotoEditorPlugin(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        RelativeLayout.inflate(r100, R.layout.view_photo_editor_clip_plugin, this);
        e();
    }
}
