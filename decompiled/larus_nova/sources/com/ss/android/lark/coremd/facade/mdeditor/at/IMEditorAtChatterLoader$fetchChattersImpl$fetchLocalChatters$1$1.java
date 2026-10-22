package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtChatterLoader$fetchChattersImpl$fetchLocalChatters$1$1 extends Lambda implements Function1<IMAtNodeExtend, Boolean> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ a.c $it;

    public IMEditorAtChatterLoader$fetchChattersImpl$fetchLocalChatters$1$1(a.c r100, String r101) {
        this.$it = r100;
        this.$chatId = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(IMAtNodeExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMAtNodeExtend");
        this.$it.getClass();
        r100.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        boolean r101 = false;
        String r102 = (String) r100.f419652c.getValue(null, IMAtNodeExtend.f419651j[0]);
        this.$it.getClass();
        if (Intrinsics.areEqual(null, r102) == false) goto L11;
        if (this.$chatId.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        r101 = true;
        goto L11
    L7:
        r103 = false;
    L11:
        return Boolean.valueOf(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(IMAtNodeExtend r100) {
        return invoke2(r100);
    }
}
