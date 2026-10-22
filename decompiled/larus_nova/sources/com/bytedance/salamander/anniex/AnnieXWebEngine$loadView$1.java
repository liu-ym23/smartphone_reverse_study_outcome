package com.bytedance.salamander.anniex;

import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<no name provided>", "", "value", "", "key", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class AnnieXWebEngine$loadView$1 extends Lambda implements Function2<Object, String, Unit> {
    final /* synthetic */ AnnieXWebEngine this$0;

    public AnnieXWebEngine$loadView$1(AnnieXWebEngine r100) {
        this.this$0 = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "key");
        AnnieXWebModel r102 = this.this$0.f267866b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("webModel");
        r102 = null;
    L5:
        Map<String, Object> r103 = r102.f41472g;
        if (r103 == null) goto L9;
        r103.put(r101, r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object r100, String r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
