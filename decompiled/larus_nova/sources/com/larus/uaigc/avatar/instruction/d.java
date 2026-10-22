package com.larus.uaigc.avatar.instruction;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DigitalAvatarSelectorHolder f370321a;

    public d(DigitalAvatarSelectorHolder r100) {
        this.f370321a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        FLogger.f375446a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image failed");
        super.onFailure(r100, r101);
        e1.x(this.f370321a.f370297f);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        FLogger.f375446a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image submit");
        super.onSubmit(r100, r101);
        e1.o(this.f370321a.f370296e);
        e1.o(this.f370321a.f370297f);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        FLogger.f375446a.i("DigitalAvatarTemplateListSelectorWidget", "item cover image set");
        if (r101 == null) goto L5;
        e1.x(this.f370321a.f370296e);
        return;
    L5:
        e1.x(this.f370321a.f370297f);
    }
}
