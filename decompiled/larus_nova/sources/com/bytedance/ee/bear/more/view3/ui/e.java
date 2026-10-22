package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.k;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class e extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f235073n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f235074o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f235075p;

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public int e() {
        return i(R.layout.more_v3_item_text, R.layout.more_v3_item_text_doubao);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super.a(r110);
        AppCompatImageView r100 = (AppCompatImageView) r110.findViewById(R.id.icon);
        TextView r101 = (TextView) r110.findViewById(R.id.title);
        TextView r102 = (TextView) r110.findViewById(R.id.state);
        UDBadgeView r103 = (UDBadgeView) r110.findViewById(R.id.badge);
        TextView r104 = (TextView) r110.findViewById(R.id.newTips);
        TextView r105 = (TextView) r110.findViewById(R.id.freeTrialTips);
        g(r100, r101, null);
        int r106 = 0;
        if (this.f235075p.length() <= 0) goto L5;
        boolean r107 = true;
    L7:
        if (r107 == false) goto L9;
        int r108 = 0;
    L10:
        r102.setVisibility(r108);
        r102.setText(this.f235075p);
        if (this.f235073n == true) goto L13;
    L17:
        int r109 = 8;
    L18:
        r103.setVisibility(r109);
        if (this.f235074o == false) goto L24;
        if ((r101.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L24;
        ViewGroup.LayoutParams r111 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
        r112.setMarginEnd(y9c.d.a(40));
        r101.setLayoutParams(r112);
    L24:
        if (this.f235074o == true) goto L26;
    L30:
        r106 = 8;
    L31:
        r104.setVisibility(r106);
        if (r105 == null) goto L34;
        r105.setVisibility(8);
    L34:
        Intrinsics.checkNotNullParameter(r110, "itemView");
        r110.setOnClickListener(new b(this, null));
        return;
    L26:
        if (this.f235059h == false) goto L30;
        if (k.b(this.f234901a) == false) goto L30;
    L13:
        if (this.f235059h == false) goto L17;
        if (k.a(this.f234901a) == false) goto L17;
        r109 = 0;
        goto L18
    L9:
        r108 = 8;
        goto L10
    L5:
        r107 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public boolean f(com.bytedance.ee.bear.more.protocol3.k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof e) == false) goto L25;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L25;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L25;
        if (this.f235057f != r101.f235057f) goto L25;
        if (this.f235058g != r101.f235058g) goto L25;
        if (this.f235073n != r101.f235073n) goto L25;
        if (this.f235074o != r101.f235074o) goto L25;
        if (Intrinsics.areEqual(this.f235075p, r101.f235075p) == false) goto L25;
        if (this.f235059h != r101.f235059h) goto L25;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L25;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public e(String r110, String r111, int r112, int r113, boolean r114, boolean r115, String r116, boolean r117, String r118, View.OnClickListener r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r116, "label");
        Intrinsics.checkNotNullParameter(r118, "disableReason");
        super(r110, r111, r112, r113, r117, r118, r210);
        this.f235073n = r114;
        this.f235074o = r115;
        this.f235075p = r116;
    }
}
