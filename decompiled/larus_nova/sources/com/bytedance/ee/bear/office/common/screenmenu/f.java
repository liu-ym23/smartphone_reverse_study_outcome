package com.bytedance.ee.bear.office.common.screenmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements fk5.b {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<fk5.a, Unit> f235220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fk5.a f235221b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super fk5.a, Unit> r100, fk5.a r101) {
            this.f235220a = r100;
            this.f235221b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f235220a.invoke(this.f235221b);
        }
    }

    public f() {
    }

    public static void e(View r100, e r110) {
        TextView r101 = (TextView) r100.findViewById(R.id.menu_text);
        TextView r102 = (TextView) r100.findViewById(R.id.menu_sub_text);
        FrameLayout r103 = (FrameLayout) r100.findViewById(R.id.menu_icon_container);
        ImageView r104 = (ImageView) r100.findViewById(R.id.menu_icon);
        FrameLayout r105 = (FrameLayout) r100.findViewById(R.id.menu_end_icon_container);
        ImageView r106 = (ImageView) r100.findViewById(R.id.menu_end_icon);
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNull(r104);
        c(r103, r104, r110.f235218o);
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNull(r106);
        c(r105, r106, r110.f235218o);
        Integer r107 = r110.f235219p;
        if (r107 == null) goto L9;
        int r108 = r107.intValue();
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r109 = r101.getLayoutParams();
        if (r109 == null) goto L8;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r109;
        r111.setMarginStart(r108);
        r101.setLayoutParams(r111);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        String r112 = r110.f235205b;
        String r113 = "";
        if (r112 != null) goto L12;
        r112 = "";
    L12:
        r101.setText(r112);
        Integer r114 = r110.f235207d;
        if (r114 == null) goto L15;
        int r115 = r114.intValue();
    L16:
        r101.setTextColor(r115);
        Intrinsics.checkNotNull(r102);
        if (r110.f235206c == null) goto L19;
        boolean r116 = true;
    L20:
        if (r116 == false) goto L22;
        int r117 = 0;
    L23:
        r102.setVisibility(r117);
        String r118 = r110.f235206c;
        if (r118 == null) goto L27;
        r113 = r118;
    L27:
        r102.setText(r113);
        if (r110.f235209f == false) goto L30;
        Integer r119 = null;
    L31:
        d(r103, r104, r119, r110, r110.f235210g);
        if (r110.f235209f == false) goto L34;
        Integer r120 = r110.f235208e;
    L35:
        d(r105, r106, r120, r110, false);
        r100.setSelected(r110.f235212i);
        if (r110.f235217n == false) goto L38;
        float r121 = 0.5f;
    L39:
        r100.setAlpha(r121);
        r100.setEnabled(r110.f235216m);
        return;
    L38:
        r121 = 1.0f;
        goto L39
    L34:
        r120 = r110.f235211h;
        goto L35
    L30:
        r119 = r110.f235208e;
        goto L31
    L22:
        r117 = 8;
        goto L23
    L19:
        r116 = false;
        goto L20
    L15:
        r115 = ContextCompat.getColor(r100.getContext(), R.color.office_screen_menu_text);
        goto L16
    }

    @Override // fk5.b
    public void update(fk5.a r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof e) == false) goto L8;
        if (r101 == null) goto L9;
        e(r101, (e) r100);
        return;
    L9:
        return;
    }

    public static void c(View r100, View r101, Integer r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L13;
        r103.width = r102.intValue();
        r103.height = r102.intValue();
        r100.setLayoutParams(r103);
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 == null) goto L11;
        r104.width = r102.intValue();
        r104.height = r102.intValue();
        r101.setLayoutParams(r104);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // fk5.b
    public final void a(CommonMenu r100, fk5.a r101, View r102, Function1<? super fk5.a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "listener");
        if (r102 == null) goto L6;
        r102.setOnClickListener(new a(r103, r101));
        return;
    }

    @Override // fk5.b
    public final View b(CommonMenu r100, int r101, int r102, fk5.a r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        if ((r103 instanceof e) == true) goto L6;
        return null;
    L6:
        FrameLayout r104 = new FrameLayout(r100.getContext());
        e r105 = (e) r103;
        if (r105.f235206c == null) goto L9;
        Context r106 = r104.getContext();
        int r107 = 64;
    L10:
        r104.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, k.a(r106, r107)));
        int r108 = r105.f235215l;
        if (r108 > 0) goto L14;
        r108 = k.a(r104.getContext(), 16);
    L14:
        int r109 = k.a(r104.getContext(), 20);
        r104.setPadding(r108, r104.getPaddingTop(), r109, r104.getPaddingBottom());
        if (r102 != 1) goto L17;
        int r110 = R.drawable.office_bg_common_menu_item_single;
    L23:
        r104.setBackgroundResource(r110);
        LayoutInflater.from(r100.getContext()).inflate(R.layout.office_screen_menu_item_layout, r104, true);
        e(r104, r105);
        return r104;
    L17:
        if (r101 != 0) goto L20;
        r110 = R.drawable.office_bg_common_menu_item_first;
        goto L23
    L20:
        if (r101 != (r102 - 1)) goto L22;
        r110 = R.drawable.office_bg_common_menu_item_last;
        goto L23
    L22:
        r110 = R.drawable.office_bg_common_menu_item_middle;
        goto L23
    L9:
        r106 = r104.getContext();
        r107 = 48;
        goto L10
    }

    public static void d(View r100, ImageView r101, Integer r102, e r103, boolean r104) {
        int r105 = 0;
        if (r102 != null) goto L7;
        if (r104 == true) goto L7;
        int r106 = 8;
    L8:
        r100.setVisibility(r106);
        if (r102 == null) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L15;
        r105 = 8;
    L15:
        r101.setVisibility(r105);
        if (r102 == null) goto L25;
        r101.setImageResource(r102.intValue());
        if (r103.f235212i == true) goto L24;
        Integer r108 = r103.f235207d;
        if (r108 == null) goto L22;
        int r109 = r108.intValue();
    L23:
        r101.setColorFilter(r109);
        return;
    L22:
        r109 = ContextCompat.getColor(r101.getContext(), R.color.office_screen_menu_text);
        goto L23
    L24:
        r101.clearColorFilter();
        return;
    L25:
        r101.setImageDrawable(null);
        return;
    L11:
        r107 = false;
    L7:
        r106 = 0;
        goto L8
    }
}
