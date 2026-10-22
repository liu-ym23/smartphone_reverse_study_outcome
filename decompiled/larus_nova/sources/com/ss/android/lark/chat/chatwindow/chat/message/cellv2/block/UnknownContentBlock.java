package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.widget.TextView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class UnknownContentBlock implements com.ss.android.lark.blueprint.i<y6b.a<?>, v5b.a<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.blueprint.g f413048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413049b;

    @Override // com.ss.android.lark.blueprint.i
    public final Class<v5b.a<?>> b() {
        return null;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f413049b;
    }

    public UnknownContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f413048a = r100;
        this.f413049b = IMMessageKeys$Blocks.UNKNOWN_CONTENT;
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        TextView r103 = (TextView) r101.c(this.f413049b, IMMessageKeys$Slots.CONTENT, new UnknownContentBlock$update$textView$1(this)).getView();
        zz7.a.d(r103, LarkFont.TITLE3);
        r103.setText(UIHelper.mustacheFormat(R.string.Lark_Legacy_UnknownMessageTypeTip));
        boolean r104 = r102.h();
        int r105 = p3b.a.W;
        if (r104 == false) goto L5;
        int r106 = v4b.a.f553167e;
    L6:
        r103.setTextColor(r106);
        return;
    L5:
        r106 = v4b.a.D;
        goto L6
    }

    @Override // com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        update2(r100, r101, r102);
    }

    @Override // com.ss.android.lark.blueprint.i
    public final void c(BlueprintCell r100, com.ss.android.lark.blueprint.q r101, Object r102, Object r103) {
        com.ss.android.lark.blueprint.i.a.b(this, r100, r101, (y6b.a) r102, (v5b.a) r103);
    }
}
