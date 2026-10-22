package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.facade.mdeditor.IMEditorContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import eab.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;)Ljava/lang/Integer;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorMediaPlugin$configureSpanFactory$1$draftResourceSource$1 extends Lambda implements Function1<IMEditorContextExtend, Integer> {
    final /* synthetic */ o<f> $this_on;

    public IMEditorMediaPlugin$configureSpanFactory$1$draftResourceSource$1(o<f> r100) {
        this.$this_on = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(IMEditorContextExtend r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$IMEditorContextExtend");
        o<f> r101 = this.$this_on;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return (Integer) ((Function0) r100.f419996r.getValue(r101, LarkContextExtend.f419980t[15])).invoke();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(IMEditorContextExtend r100) {
        return invoke2(r100);
    }
}
