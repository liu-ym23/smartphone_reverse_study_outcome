package com.larus.ugc.feed.impl.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes31.dex */
public final class g extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAvatarEntranceViewHolder f375025a;

    public g(CreationAvatarEntranceViewHolder r100) {
        this.f375025a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image failed");
        super.onFailure(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image submit");
        super.onSubmit(r100, r101);
        e1.o(this.f375025a.f374959b);
        View r102 = this.f375025a.f374960c;
        if (r102 == null) goto L6;
        e1.o(r102);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        w0a.a.c("CreationAvatarEntranceViewHolder", "cover image set");
        e1.x(this.f375025a.f374959b);
        View r103 = this.f375025a.f374960c;
        if (r103 == null) goto L5;
        e1.x(r103);
    L5:
        this.f375025a.f374959b.setText(ContextCompat.getString(AppHost.f326268a.getApplication().getApplicationContext(), R.string.larus_replica_feed_tag_myReplica));
    }
}
