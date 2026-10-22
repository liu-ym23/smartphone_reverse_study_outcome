package com.larus.office.card.ppt;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class l extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f361596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f361597b;

    public l(k r100, int r101) {
        this.f361596a = r100;
        this.f361597b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        FLogger.f375446a.d("SlidesPPTCard", "updateBriefImage onFailure");
        e1.x(k.b(this.f361596a).f361313e);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        super.onSubmit(r100, r101);
        FLogger.f375446a.d("SlidesPPTCard", "updateBriefImage onSubmit");
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        FLogger.f375446a.d("SlidesPPTCard", "updateBriefImage onFinalImageSet");
        e1.o(k.b(this.f361596a).f361313e);
        k.c(this.f361596a, r101, this.f361597b);
    }
}
