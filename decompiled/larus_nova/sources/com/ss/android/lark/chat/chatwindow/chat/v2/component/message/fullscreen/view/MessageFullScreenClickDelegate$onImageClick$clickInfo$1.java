package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/listener/ImageClickInfo;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMImageExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onImageClick$clickInfo$1 extends Lambda implements Function1<IMImageExtend, mcc.p> {
    final /* synthetic */ Rect $clickBounds;
    final /* synthetic */ v7b.l $image;
    final /* synthetic */ Drawable $thumbnail;

    public MessageFullScreenClickDelegate$onImageClick$clickInfo$1(v7b.l r100, Rect r101, Drawable r102) {
        this.$image = r100;
        this.$clickBounds = r101;
        this.$thumbnail = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final mcc.p invoke2(IMImageExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMImageExtend");
        mcc.p r101 = new mcc.p();
        r100.h(this.$image);
        r101.f513257c = IMImageExtend.j(this.$image);
        Rect r102 = this.$clickBounds;
        r101.f513260f = r102.left;
        r101.f513261g = r102.top;
        r101.f513258d = r102.width();
        r101.f513259e = this.$clickBounds.height();
        r101.f513262h = this.$thumbnail;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ mcc.p invoke(IMImageExtend r100) {
        return invoke2(r100);
    }
}
