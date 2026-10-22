package com.ss.android.lark.assembly.avatar.officesdk;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import sz7.l;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarModel f408963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f408964b;

    @Override // sz7.l
    public final void onError(Throwable r100) {
        if (this.f408963a.f284044c != this.f408964b.getTag(R.id.avatar_tag)) goto L9;
        Drawable r101 = this.f408963a.f284046e;
        if (r101 == null) goto L9;
        this.f408964b.setImageDrawable(r101);
        return;
    L9:
        Log.w("OfficeAvatar", "asyncLoad image tag not match or placeHolder is null");
    }

    @Override // sz7.l
    public final void onSuccess(Drawable r100) {
        if (this.f408963a.f284044c == this.f408964b.getTag(R.id.avatar_tag)) goto L6;
        Log.w("OfficeAvatar", "asyncLoad image tag not match");
        return;
    L6:
        this.f408964b.setImageDrawable(r100);
    }

    public a(AvatarModel r100, ImageView r101) {
        this.f408963a = r100;
        this.f408964b = r101;
    }
}
