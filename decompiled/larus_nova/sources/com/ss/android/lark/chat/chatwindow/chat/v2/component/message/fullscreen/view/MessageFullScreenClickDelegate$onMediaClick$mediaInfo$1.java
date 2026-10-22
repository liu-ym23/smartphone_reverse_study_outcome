package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.widget.span.MediaInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/span/MediaInfo;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMMediaExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onMediaClick$mediaInfo$1 extends Lambda implements Function1<IMMediaExtend, MediaInfo> {
    final /* synthetic */ Rect $clickBounds;
    final /* synthetic */ eab.f $media;
    final /* synthetic */ Drawable $thumbnail;

    public MessageFullScreenClickDelegate$onMediaClick$mediaInfo$1(Drawable r100, eab.f r101, Rect r102) {
        this.$thumbnail = r100;
        this.$media = r101;
        this.$clickBounds = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MediaInfo invoke2(IMMediaExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMMediaExtend");
        MediaInfo r101 = new MediaInfo();
        r101.mediaThumbnail = this.$thumbnail;
        eab.f r102 = this.$media;
        r100.getClass();
        r101.key = IMMediaExtend.g(r102);
        r101.url = r100.j(this.$media);
        Rect r103 = this.$clickBounds;
        r101.left = r103.left;
        r101.top = r103.top;
        r101.height = r103.height();
        r101.width = this.$clickBounds.width();
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MediaInfo invoke(IMMediaExtend r100) {
        return invoke2(r100);
    }
}
