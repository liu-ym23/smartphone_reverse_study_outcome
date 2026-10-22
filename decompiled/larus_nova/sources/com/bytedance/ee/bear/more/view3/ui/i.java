package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.more.protocol3.k;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f235085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View.OnClickListener f235086o;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(R.layout.more_v3_item_right_button, R.layout.more_v3_item_right_button_doubao);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super.a(r100);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.icon);
        TextView r102 = (TextView) r100.findViewById(R.id.title);
        TextView r103 = (TextView) r100.findViewById(R.id.right_btn);
        r103.setTag("right_button");
        r100.setTag(MapController.ITEM_LAYER_TAG);
        g(r101, r102, null);
        r103.setText(this.f235085n);
        r103.setEnabled(this.f235059h);
        if (this.f235059h == false) goto L5;
        b r104 = new b(this, this.f235086o);
        r103.setOnClickListener(r104);
        r100.setOnClickListener(r104);
        return;
    L5:
        r103.setOnClickListener(null);
        r100.setOnClickListener(this.f235086o);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof i) == false) goto L21;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L21;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L21;
        if (this.f235057f != r101.f235057f) goto L21;
        if (this.f235058g != r101.f235058g) goto L21;
        if (this.f235059h != r101.f235059h) goto L21;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L21;
        if (Intrinsics.areEqual(this.f235085n, r101.f235085n) == false) goto L21;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public i(String r110, String r111, int r112, int r113, boolean r114, String r115, String r116, View.OnClickListener r117, View.OnClickListener r118) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r116, "rightButtonText");
        super(r110, r111, r112, r113, r114, r115, r117);
        this.f235085n = r116;
        this.f235086o = r118;
    }
}
