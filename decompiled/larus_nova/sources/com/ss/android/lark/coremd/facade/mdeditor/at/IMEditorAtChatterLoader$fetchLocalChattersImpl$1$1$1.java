package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class IMEditorAtChatterLoader$fetchLocalChattersImpl$1$1$1 extends Lambda implements Function1<IMAtNodeExtend, Unit> {
    final /* synthetic */ eab.a $node;
    final /* synthetic */ String $originName;
    final /* synthetic */ a.c $request;

    public IMEditorAtChatterLoader$fetchLocalChattersImpl$1$1$1(eab.a r100, a.c r101, String r102) {
        this.$node = r100;
        this.$request = r101;
        this.$originName = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IMAtNodeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMAtNodeExtend");
        this.$request.getClass();
        r100.a(null);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IMAtNodeExtend r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
