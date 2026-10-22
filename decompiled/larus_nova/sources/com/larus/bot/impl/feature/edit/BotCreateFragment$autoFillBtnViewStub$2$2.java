package com.larus.bot.impl.feature.edit;

import android.view.View;
import com.larus.bot.impl.databinding.LarusLayoutAutoFillBtnBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BotCreateFragment$autoFillBtnViewStub$2$2 extends FunctionReferenceImpl implements Function1<View, LarusLayoutAutoFillBtnBinding> {
    public static final BotCreateFragment$autoFillBtnViewStub$2$2 INSTANCE = null;

    static {
        INSTANCE = new BotCreateFragment$autoFillBtnViewStub$2$2();
    }

    public BotCreateFragment$autoFillBtnViewStub$2$2() {
        super(1, LarusLayoutAutoFillBtnBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/bot/impl/databinding/LarusLayoutAutoFillBtnBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusLayoutAutoFillBtnBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return LarusLayoutAutoFillBtnBinding.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusLayoutAutoFillBtnBinding invoke(View r100) {
        return invoke2(r100);
    }
}
