package com.ss.android.lark.chat.cot.detail.blueprint;

import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.k;
import com.ss.android.lark.chat.cot.detail.t;
import com.ss.android.lark.chat.cot.detail.u;
import com.ss.android.lark.chat.entity.message.CotStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotDetailItemLayout$Companion$bindItemChrome$1 extends FunctionReferenceImpl implements Function3<ImageView, k, Boolean, Unit> {
    public CotDetailItemLayout$Companion$bindItemChrome$1(Object r100) {
        super(3, r100, com.ss.android.lark.chat.cot.detail.widget.a.class, "bind", "bind(Landroid/widget/ImageView;Lcom/ss/android/lark/chat/cot/detail/CotDetailItem;Z)V", 0);
    }

    public final void invoke(ImageView r100, k r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((com.ss.android.lark.chat.cot.detail.widget.a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "markerView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        boolean r102 = true;
        com.ss.android.lark.chat.cot.c r103 = null;
        CotStatus r104 = null;
        com.ss.android.lark.chat.cot.c r105 = null;
        com.ss.android.lark.chat.cot.c r106 = null;
        if (r110 == true) goto L81;
        CotDetailBlockType r111 = r101.f414983b;
        if (r111 == CotDetailBlockType.STATUS) goto L7;
    L9:
        int r112 = com.ss.android.lark.chat.cot.detail.widget.a.b.f415047a[r111.ordinal()];
        if (r112 == 1) goto L80;
        if (r112 != 2) goto L13;
        u r107 = r101.c();
        if (r107 == null) goto L79;
        r106 = r107.f415008a;
    L79:
        com.ss.android.lark.chat.cot.detail.widget.a.f(r100, r106);
        return;
    L13:
        if (r112 != 3) goto L15;
        com.ss.android.lark.chat.cot.detail.widget.a.a(r100);
        return;
    L15:
        if (r112 != 4) goto L17;
        com.ss.android.lark.chat.cot.detail.b r113 = r101.f414988g;
        if ((r113 instanceof com.ss.android.lark.chat.cot.detail.a) == false) goto L62;
        com.ss.android.lark.chat.cot.detail.a r114 = (com.ss.android.lark.chat.cot.detail.a) r113;
    L64:
        if (r101.f414983b == CotDetailBlockType.ACTION) goto L67;
        r102 = false;
    L67:
        if (r102 == true) goto L70;
        r114 = null;
    L70:
        if (r114 == null) goto L72;
        r105 = r114.f414849a;
    L72:
        if (r105 != null) goto L74;
        com.ss.android.lark.chat.cot.detail.widget.a.a(r100);
        return;
    L74:
        com.ss.android.lark.chat.cot.detail.widget.a.f(r100, r105);
        return;
    L62:
        r114 = null;
        goto L64
    L17:
        if (r112 != 5) goto L58;
        if (r101.f414986e != CotBlockStatus.VIOLATED) goto L21;
        com.ss.android.lark.chat.cot.detail.widget.a.C4853a r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_info_outlined);
    L56:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r100, r108.f415045a, false);
        r100.setColorFilter(UDColorUtils.getColor(r100.getContext(), r108.f415046b));
        return;
    L21:
        t r115 = r101.b();
        if (r115 == null) goto L24;
        CotStatus r116 = r115.f415006a;
    L26:
        if (r116 != CotStatus.DONE) goto L28;
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_yes_outlined);
        goto L56
    L28:
        t r117 = r101.b();
        if (r117 == null) goto L31;
        CotStatus r118 = r117.f415006a;
    L33:
        if (r118 != CotStatus.ERROR) goto L35;
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_info_outlined);
        goto L56
    L35:
        t r119 = r101.b();
        if (r119 == null) goto L38;
        CotStatus r120 = r119.f415006a;
    L40:
        if (r120 != CotStatus.TIMEOUT) goto L42;
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_info_outlined);
        goto L56
    L42:
        t r121 = r101.b();
        if (r121 == null) goto L45;
        CotStatus r122 = r121.f415006a;
    L47:
        if (r122 != CotStatus.INTERRUPTED) goto L49;
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_info_outlined);
        goto L56
    L49:
        t r109 = r101.b();
        if (r109 == null) goto L53;
        r104 = r109.f415006a;
    L53:
        if (r104 != CotStatus.PAUSED) goto L55;
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_info_outlined);
        goto L56
    L55:
        r108 = new com.ss.android.lark.chat.cot.detail.widget.a.C4853a(R.drawable.ud_icon_yes_outlined);
        goto L56
    L45:
        r122 = null;
        goto L47
    L38:
        r120 = null;
        goto L40
    L31:
        r118 = null;
        goto L33
    L24:
        r116 = null;
        goto L26
    L58:
        throw new NoWhenBranchMatchedException();
    L80:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r100, R.drawable.icon_cot_tool_call_group, true);
        return;
    L7:
        if (r101.f414986e != CotBlockStatus.RUNNING) goto L9;
        com.ss.android.lark.chat.cot.detail.widget.a.g(r100);
        return;
    L81:
        int r123 = com.ss.android.lark.chat.cot.detail.widget.a.b.f415047a[r101.f414983b.ordinal()];
        if (r123 == 1) goto L92;
        if (r123 == 2) goto L85;
        com.ss.android.lark.chat.cot.detail.widget.a.g(r100);
        return;
    L85:
        u r124 = r101.c();
        if (r124 == null) goto L88;
        r103 = r124.f415008a;
    L88:
        Intrinsics.checkNotNullParameter(r100, "iconView");
        if (com.ss.android.lark.chat.cot.detail.widget.a.e(r100, r103) == false) goto L91;
        r100.setVisibility(0);
        return;
    L91:
        com.ss.android.lark.chat.cot.detail.widget.a.g(r100);
        r100.setVisibility(8);
        return;
    L92:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r100, R.drawable.icon_cot_tool_call_group, true);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ImageView r100, k r101, Boolean r102) {
        invoke(r100, r101, r102.booleanValue());
        return Unit.INSTANCE;
    }
}
