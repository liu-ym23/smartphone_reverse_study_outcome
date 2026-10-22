package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f235067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f235068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f235069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f235070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f235071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f235072v;

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return R.layout.more_v3_item_indicator;
    }

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super.a(r100);
        if (this.f235059h == true) goto L5;
    L7:
        ((TextView) r100.findViewById(R.id.state)).setVisibility(8);
    L9:
        if (this.f235071u != (-1)) goto L11;
    L15:
        ((AppCompatImageView) r100.findViewById(R.id.icon_state)).setVisibility(8);
        return;
    L11:
        if (this.f235070t == false) goto L15;
        ((AppCompatImageView) r100.findViewById(R.id.icon_state)).setVisibility(0);
        ((AppCompatImageView) r100.findViewById(R.id.icon_state)).setImageResource(this.f235071u);
        if (this.f235072v == (-1)) goto L17;
        l.c((ImageView) r100.findViewById(R.id.icon_state), this.f235072v);
        return;
    L17:
        return;
    L5:
        if (this.f235070t == false) goto L7;
        ((TextView) r100.findViewById(R.id.state)).setVisibility(0);
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.view3.ui.e, com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof d) == false) goto L29;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L29;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L29;
        if (this.f235057f != r101.f235057f) goto L29;
        if (this.f235058g != r101.f235058g) goto L29;
        if (this.f235067q != r101.f235067q) goto L29;
        if (this.f235068r != r101.f235068r) goto L29;
        if (Intrinsics.areEqual(this.f235069s, r101.f235069s) == false) goto L29;
        if (this.f235059h != r101.f235059h) goto L29;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L29;
        if (this.f235070t != r101.f235070t) goto L29;
        if (this.f235071u != r101.f235071u) goto L29;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L29;
        return true;
    L29:
        return false;
    }

    public d(String r110, String r111, int r112, int r113, boolean r114, String r115, boolean r210, String r211, View.OnClickListener r212, boolean r213, int r214, int r215) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r115, "label");
        Intrinsics.checkNotNullParameter(r211, "disableReason");
        super(r110, r111, r112, r113, false, r114, r115, r210, r211, r212);
        this.f235067q = false;
        this.f235068r = r114;
        this.f235069s = r115;
        this.f235070t = r213;
        this.f235071u = r214;
        this.f235072v = r215;
    }
}
