package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/widget/codeblock/entity/LineContent;", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkCodeBlockExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onCodeBlockClick$lineContents$1 extends Lambda implements Function1<LarkCodeBlockExtend, List<? extends LineContent>> {
    final /* synthetic */ v7b.g $code;

    public MessageFullScreenClickDelegate$onCodeBlockClick$lineContents$1(v7b.g r100) {
        this.$code = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<LineContent> invoke2(LarkCodeBlockExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$LarkCodeBlockExtend");
        return r100.a(this.$code);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends LineContent> invoke(LarkCodeBlockExtend r100) {
        return invoke2(r100);
    }
}
