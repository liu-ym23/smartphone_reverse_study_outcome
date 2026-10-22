package com.larus.community.impl.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes27.dex */
public final class g extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAvatarEntranceViewHolder f330047a;

    public g(CreationAvatarEntranceViewHolder r100) {
        this.f330047a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        m29.a.c("CreationAvatarEntranceViewHolder", "cover image failed");
        super.onFailure(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        m29.a.c("CreationAvatarEntranceViewHolder", "cover image submit");
        super.onSubmit(r100, r101);
        e1.o(this.f330047a.f329946b);
        View r102 = this.f330047a.f329948d;
        if (r102 == null) goto L6;
        e1.o(r102);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        m29.a.c("CreationAvatarEntranceViewHolder", "cover image set");
        e1.x(this.f330047a.f329946b);
        View r103 = this.f330047a.f329948d;
        if (r103 == null) goto L5;
        e1.x(r103);
    L5:
        this.f330047a.f329946b.setText(ContextCompat.getString(AppHost.f326268a.getApplication().getApplicationContext(), R.string.larus_replicaTemplate_label_creating));
    }
}
