package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.mdeditor.IMEditorContextExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtPlugin$configureVisitor$1$currentChatId$1 extends Lambda implements Function1<IMEditorContextExtend, String> {
    final /* synthetic */ r<eab.a> $this_on;

    public IMEditorAtPlugin$configureVisitor$1$currentChatId$1(r<eab.a> r100) {
        this.$this_on = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(IMEditorContextExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMEditorContextExtend");
        r<eab.a> r101 = this.$this_on;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return (String) ((Function0) r100.f419763u.getValue(r101, IMEditorContextExtend.f419762v[0])).invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(IMEditorContextExtend r100) {
        return invoke2(r100);
    }
}
