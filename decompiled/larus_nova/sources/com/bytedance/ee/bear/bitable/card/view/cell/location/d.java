package com.bytedance.ee.bear.bitable.card.view.cell.location;

import android.content.Context;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.larus.nova.R;
import hp4.v;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f207903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f207904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e.a f207905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f207906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f207907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PoiInfo f207908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f207909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f207910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f207911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ActionMode f207912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f207913k;

    public final boolean a(double r100, double r101) {
        if (r100 >= (-90.0d)) goto L5;
    L11:
        return false;
    L5:
        if (r100 > 90.0d) goto L11;
        if (r101 < (-180.0d)) goto L11;
        if (r101 > 180.0d) goto L11;
        return true;
    }

    public abstract String b();

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.location.e
    public void A() {
        int r100 = 8;
        if (this.f207908f == null) goto L10;
        this.f207909g.setVisibility(0);
        this.f207910h.setText(this.f207908f.getFullAddress());
        View r101 = this.f207911i;
        if (c() == false) goto L7;
        r100 = 0;
    L7:
        r101.setVisibility(r100);
        if ((this.f207911i instanceof AppCompatImageView) == false) goto L14;
        this.f207909g.setPadding(0, 0, 0, 0);
        return;
    L14:
        return;
    L10:
        this.f207909g.setVisibility(8);
        this.f207911i.setVisibility(8);
        if ((this.f207911i instanceof AppCompatImageView) == false) goto L16;
        this.f207909g.setPadding(0, 0, 0, 0);
        return;
    }

    public final boolean c() {
        if (this.f207913k == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f207906d.canEdit() == false) goto L7;
        return true;
    }

    public d(Context r100, FrameLayout r101, e.a r102, v r103, int r104, AppCompatImageView r105) {
        this.f207913k = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("bitable.field.location");
        r101.removeAllViews();
        this.f207907e = r100;
        this.f207903a = r101;
        this.f207905c = r102;
        this.f207906d = r103;
        View r106 = LayoutInflater.from(r100).inflate(r104, r101);
        this.f207904b = r106;
        this.f207909g = (LinearLayout) r106.findViewById(R.id.location_des_container);
        TextView r107 = (TextView) r106.findViewById(R.id.location_title);
        this.f207910h = r107;
        if (r105 == null) goto L5;
        this.f207911i = r105;
    L6:
        r107.setOnClickListener(new vp4.e(this));
        r107.setOnLongClickListener(new vp4.d(this));
        this.f207911i.setOnClickListener(new c(this));
        return;
    L5:
        this.f207911i = r106.findViewById(R.id.location_edit_icon_container);
        goto L6
    }
}
