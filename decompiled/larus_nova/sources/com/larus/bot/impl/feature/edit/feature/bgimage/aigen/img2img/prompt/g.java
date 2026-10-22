package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.net.Uri;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BgPromptGenerateViewModel f318743a;

    public /* synthetic */ g(BgPromptGenerateViewModel r100) {
        this.f318743a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        BgPromptGenerateViewModel r100 = this.f318743a;
        Uri r111 = (Uri) r110;
        if (((f) r100.f318719f.getValue()).f318742c != 0) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r111 != null) goto L8;
    L13:
        r100.g(null);
    L15:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r111.getScheme(), "file") == false) goto L10;
        Uri r101 = r111;
    L11:
        if (r101 == null) goto L13;
        BotImageUploadViewModel.upload$default(r100.f318717d, r101, 6, false, 4, null);
        goto L15
    L10:
        r101 = null;
        goto L11
    }
}
