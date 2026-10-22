package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.protocol3.k;
import com.larksuite.component.universe_design.p010switch.UDSwitch;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends com.bytedance.ee.bear.more.view3.ui.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f235087n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f235088o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f235089p;

    public static final class a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f235090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f235091b;

        public b(j r100, View r101) {
            this.f235090a = r100;
            this.f235091b = r101;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            j r102 = this.f235090a;
            com.bytedance.ee.bear.more.view3.ui.a.h(this.f235091b, r102.f235059h, r102.f235060i, r102.f235061j, null);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(R.layout.more_v3_item_switch, R.layout.more_v3_item_switch_doubao);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        super.a(r110);
        AppCompatImageView r100 = (AppCompatImageView) r110.findViewById(R.id.icon);
        TextView r101 = (TextView) r110.findViewById(R.id.title);
        UDSwitch r102 = (UDSwitch) r110.findViewById(R.id.switchBtn);
        String r103 = null;
        r102.setOnCheckedChangeListener(null);
        g(r100, r101, null);
        TextView r104 = (TextView) r110.findViewById(R.id.freeTrialTips);
        if (r104 == null) goto L28;
        r104.setText(this.f235088o);
        Object r105 = r104.getTag(2025031300);
        if (r105 != null) goto L8;
    L17:
        TextPaint r106 = r104.getPaint();
        CharSequence r107 = r104.getText();
        if (r107 == null) goto L20;
        r103 = r107.toString();
    L20:
        LinearGradient r108 = new LinearGradient(r106.measureText(r103), 0.0f, 0.0f, r104.getTextSize(), r104.getContext().getResources().getColor(R.color.ud_P500), r104.getContext().getResources().getColor(R.color.ud_I600), Shader.TileMode.CLAMP);
        r106.setShader(r108);
        r104.setTag(2025031300, r108);
        Unit r109 = Unit.INSTANCE;
    L22:
        if (this.f235059h == true) goto L24;
    L26:
        int r111 = 8;
    L27:
        r104.setVisibility(r111);
        goto L28
    L24:
        if (this.f235087n == false) goto L26;
        r111 = 0;
        goto L27
    L8:
        if ((r105 instanceof Shader) == true) goto L11;
        r105 = null;
    L11:
        if (r105 == null) goto L17;
        if ((r105 instanceof Shader) == false) goto L15;
        Shader r112 = (Shader) r105;
    L16:
        if (r112 != null) goto L22;
    L15:
        r112 = null;
    L28:
        r102.setEnabled(this.f235059h);
        r102.setChecked(this.f235089p);
        r102.setOnCheckedChangeListener(new b(this, r110));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof j) == false) goto L23;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L23;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L23;
        if (this.f235057f != r101.f235057f) goto L23;
        if (this.f235058g != r101.f235058g) goto L23;
        if (this.f235087n != r101.f235087n) goto L23;
        if (this.f235089p != r101.f235089p) goto L23;
        if (this.f235059h != r101.f235059h) goto L23;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L23;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L23;
        return true;
    L23:
        return false;
    }

    public j(String r110, String r111, int r112, int r113, boolean r114, String r115, boolean r116, boolean r117, String r118, View.OnClickListener r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r115, "freeTrialTipText");
        Intrinsics.checkNotNullParameter(r118, "disableReason");
        super(r110, r111, r112, r113, r117, r118, r210);
        this.f235087n = r114;
        this.f235088o = r115;
        this.f235089p = r116;
    }
}
