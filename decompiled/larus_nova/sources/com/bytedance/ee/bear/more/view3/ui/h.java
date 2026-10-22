package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.k;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f235083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View.OnClickListener f235084o;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(R.layout.more_v3_item_next_page, R.layout.more_v3_item_next_page_doubao);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super.a(r100);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.icon);
        TextView r102 = (TextView) r100.findViewById(R.id.title);
        TextView r103 = (TextView) r100.findViewById(R.id.newTips);
        g(r101, r102, (ImageView) r100.findViewById(R.id.next_page_icon));
        if (this.f235083n == true) goto L5;
    L9:
        int r104 = 8;
    L10:
        r103.setVisibility(r104);
        View.OnClickListener r105 = this.f235084o;
        Intrinsics.checkNotNullParameter(r100, "itemView");
        r100.setOnClickListener(new b(this, r105));
        return;
    L5:
        if (this.f235059h == false) goto L9;
        if (k.b(this.f234901a) == false) goto L9;
        r104 = 0;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(com.bytedance.ee.bear.more.protocol3.k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof h) == false) goto L23;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L23;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L23;
        if (this.f235057f != r101.f235057f) goto L23;
        if (this.f235058g != r101.f235058g) goto L23;
        if (this.f235083n != r101.f235083n) goto L23;
        if (this.f235059h != r101.f235059h) goto L23;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L23;
        if (Intrinsics.areEqual(this.f235084o, r101.f235084o) == false) goto L23;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public h(String r110, String r111, int r112, int r113, boolean r114, boolean r115, String r116, View.OnClickListener r117, View.OnClickListener r118) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r116, "disableReason");
        super(r110, r111, r112, r113, r115, r116, r117);
        this.f235083n = r114;
        this.f235084o = r118;
    }
}
