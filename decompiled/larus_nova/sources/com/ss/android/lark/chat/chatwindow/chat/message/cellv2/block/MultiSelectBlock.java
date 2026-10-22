package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MultiSelectBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412835g;

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412835g;
    }

    public MultiSelectBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412835g = IMMessageKeys$Blocks.MULTI_SELECT;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412835g, IMMessageKeys$Slots.SELECT);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f r103 = null;
        int r104 = 0;
        if (this.f412673c.s8() == true) goto L16;
        g(r101, this.f412835g, IMMessageKeys$Slots.SELECT);
        boolean r105 = r101 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f;
        if (r105 == false) goto L7;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f r106 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r101;
    L8:
        if (r106 == null) goto L10;
        r106.setSelected(false);
    L10:
        if (r105 == false) goto L12;
        r103 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r101;
    L12:
        if (r103 == null) goto L47;
        r103.d(false);
        return;
    L47:
        return;
    L7:
        r106 = null;
        goto L8
    L16:
        if ((r102 instanceof y6b.c) == false) goto L18;
        y6b.c r107 = (y6b.c) r102;
    L19:
        if (r107 != null) goto L22;
        return;
    L22:
        if ((r101 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) == false) goto L24;
        r103 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f) r101;
    L24:
        if (r103 != null) goto L26;
        return;
    L26:
        com.ss.android.lark.blueprint.k r108 = r101.c(this.f412835g, IMMessageKeys$Slots.SELECT, new MultiSelectBlock$update$blockView$1(this));
        com.ss.android.lark.biz.im.api.message.params.p r109 = (com.ss.android.lark.biz.im.api.message.params.p) this.f412673c.d0(com.ss.android.lark.biz.im.api.message.params.p.class);
        if (r109 == null) goto L31;
        Integer r110 = r109.f410374a;
        if (r110 == null) goto L31;
        ((UDCheckBox) r108.getView()).setUncheckedBorderColor(UIUtils.getColor(getContext(), r110.intValue()));
    L31:
        boolean r111 = lpc.a.d(r107);
        if (this.f412673c.s8() == true) goto L34;
        r103.setSelected(false);
        if (this.f412673c.isClickable() == false) goto L41;
        r103.d(false);
    L41:
        UDCheckBox r112 = (UDCheckBox) r108.getView();
        if (this.f412673c.y8(r107) == true) goto L45;
        r104 = 4;
    L45:
        r112.setVisibility(r104);
        return;
    L34:
        if (r111 == false) goto L36;
        ((UDCheckBox) r108.getView()).setEnabled(false);
        r103.setSelected(false);
    L37:
        r103.d(true);
        goto L41
    L36:
        ((UDCheckBox) r108.getView()).setEnabled(true);
        ((UDCheckBox) r108.getView()).setChecked(this.f412673c.E8(r107));
        r103.setSelected(this.f412673c.E8(r107));
        goto L37
    L18:
        r107 = null;
        goto L19
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
