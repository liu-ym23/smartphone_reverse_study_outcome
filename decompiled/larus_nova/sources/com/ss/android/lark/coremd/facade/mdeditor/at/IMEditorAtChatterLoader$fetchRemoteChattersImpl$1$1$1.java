package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$1$1 extends Lambda implements Function1<IMAtNodeExtend, Unit> {
    final /* synthetic */ ChatChatter $chatter;
    final /* synthetic */ Map<String, Boolean> $inChatMap;
    final /* synthetic */ String $it;
    final /* synthetic */ eab.a $node;
    final /* synthetic */ String $originName;

    public IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$1$1(eab.a r100, ChatChatter r101, String r102, Map<String, Boolean> r103, String r104) {
        this.$node = r100;
        this.$chatter = r101;
        this.$originName = r102;
        this.$inChatMap = r103;
        this.$it = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IMAtNodeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMAtNodeExtend");
        r100.d(this.$node, this.$chatter.isAnonymous());
        eab.a r101 = this.$node;
        String r102 = this.$originName;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f419657h.setValue(r101, IMAtNodeExtend.f419651j[5], r102);
        r100.f(this.$node, !Intrinsics.areEqual(this.$inChatMap.get(this.$it), Boolean.TRUE));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IMAtNodeExtend r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
