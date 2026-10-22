package com.larus.uaigc.image.instruction;

import android.net.Uri;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class g implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageListSelectorWithMoreTemplateWidget f373089a;

    public /* synthetic */ g(ImageListSelectorWithMoreTemplateWidget r100) {
        this.f373089a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r100, Object r101, Object r102) {
        String r103 = (String) r101;
        return ImageListSelectorWithMoreTemplateWidget.i6(this.f373089a, (TemplateInfo$TemplateInfo) r100, (Uri) r102);
    }
}
