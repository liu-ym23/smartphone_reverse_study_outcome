package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkLinkExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onLinkClick$previewId$1 extends Lambda implements Function1<LarkLinkExtend, String> {
    final /* synthetic */ v7b.n $link;

    public MessageFullScreenClickDelegate$onLinkClick$previewId$1(v7b.n r100) {
        this.$link = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(LarkLinkExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$LarkLinkExtend");
        return r100.d(this.$link);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(LarkLinkExtend r100) {
        return invoke2(r100);
    }
}
