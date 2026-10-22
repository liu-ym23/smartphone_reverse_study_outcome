package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.ViewGroup;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class DingIconBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f412724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f412725i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f412726j;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412723g;
    }

    public DingIconBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412723g = IMMessageKeys$Blocks.DING_ICON;
        this.f412724h = UIUtils.dp2px(getContext(), 24.0f);
        this.f412725i = UIUtils.dp2px(getContext(), 25.0f);
        this.f412726j = UIUtils.dp2px(getContext(), 1.0f);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412723g, IMMessageKeys$Slots.DING_ICON);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        y6b.c r103 = (y6b.c) r102;
        if (r103.T == true) goto L6;
        g(r101, this.f412723g, IMMessageKeys$Slots.DING_ICON);
        return;
    L6:
        com.ss.android.lark.blueprint.k r104 = r101.c(this.f412723g, IMMessageKeys$Slots.DING_ICON, new DingIconBlock$update$blockView$1(this));
        if (r103.getType() != Message.Type.IMAGE) goto L9;
    L18:
        LKUIRoundedImageView r105 = (LKUIRoundedImageView) r104.getView();
        int r106 = this.f412726j;
        r105.setPadding(r106, r106, 0, 0);
        ViewGroup.LayoutParams r107 = ((LKUIRoundedImageView) r104.getView()).getLayoutParams();
        int r108 = this.f412725i;
        r107.width = r108;
        r107.height = r108;
    L20:
        if (r103.d() == false) goto L22;
        float r109 = 8.0f;
    L23:
        ((LKUIRoundedImageView) r104.getView()).setCornerRadiusDP(r109, 0.0f, 0.0f, 0.0f);
        return;
    L22:
        r109 = com.ss.android.lark.chat.utils.f0.a(r103, 10.0f, 2.0f)[0];
        goto L23
    L9:
        if (r103.getType() == Message.Type.STICKER) goto L18;
        if (r103.getType() == Message.Type.LOCATION) goto L18;
        if (r103.getType() == Message.Type.SHARE_USER_CARD) goto L18;
        if (r103.d() == true) goto L18;
        ((LKUIRoundedImageView) r104.getView()).setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r110 = ((LKUIRoundedImageView) r104.getView()).getLayoutParams();
        int r111 = this.f412724h;
        r110.width = r111;
        r110.height = r111;
        goto L20
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
