package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.more.protocol3.k;
import com.larksuite.component.universe_design.udswitch.UDSwitchWithLoading;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends com.bytedance.ee.bear.more.view3.ui.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f235078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f235079o;

    public static final class a implements UDSwitchWithLoading.b {
        public a() {
        }

        @Override // com.larksuite.component.universe_design.udswitch.UDSwitchWithLoading.b
        public final void a() {
        }
    }

    public static final class b implements UDSwitchWithLoading.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDSwitchWithLoading f235080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f235081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f235082c;

        @Override // com.larksuite.component.universe_design.udswitch.UDSwitchWithLoading.b
        public final void a() {
            this.f235080a.toggle();
            g r100 = this.f235081b;
            com.bytedance.ee.bear.more.view3.ui.a.h(this.f235082c, r100.f235059h, r100.f235060i, r100.f235061j, null);
        }

        public b(UDSwitchWithLoading r100, g r101, View r102) {
            this.f235080a = r100;
            this.f235081b = r101;
            this.f235082c = r102;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        return i(R.layout.more_v3_item_loading_switch, R.layout.more_v3_item_loading_switch_doubao);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super.a(r100);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.icon);
        TextView r102 = (TextView) r100.findViewById(R.id.title);
        UDSwitchWithLoading r103 = (UDSwitchWithLoading) r100.findViewById(R.id.switchBtn);
        r103.setOnLoadingStatusChangeListener(new a());
        g(r101, r102, null);
        boolean r104 = r103.isChecked();
        boolean r105 = this.f235078n;
        if (r104 == r105) goto L6;
        r103.setChecked(r105);
    L6:
        if (this.f235079o == false) goto L8;
        r103.performClick();
    L9:
        r103.setEnabled(this.f235059h);
        r103.setOnLoadingStatusChangeListener(new b(r103, this, r100));
        return;
    L8:
        r103.d(this.f235078n);
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        if ((r100 instanceof g) == false) goto L21;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f234901a, r101.f234901a) == false) goto L21;
        if (Intrinsics.areEqual(this.f235056e, r101.f235056e) == false) goto L21;
        if (this.f235057f != r101.f235057f) goto L21;
        if (this.f235058g != r101.f235058g) goto L21;
        if (this.f235078n != r101.f235078n) goto L21;
        if (this.f235059h != r101.f235059h) goto L21;
        if (Intrinsics.areEqual(this.f235060i, r101.f235060i) == false) goto L21;
        if (Intrinsics.areEqual(this.f234903c, r101.f234903c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public g(String r110, String r111, int r112, int r113, boolean r114, boolean r115, boolean r116, String r117, com.bytedance.ee.bear.more.view3.d.c r118) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r117, "disableReason");
        super(r110, r111, r112, r113, r116, r117, r118);
        this.f235078n = r114;
        this.f235079o = r115;
    }
}
