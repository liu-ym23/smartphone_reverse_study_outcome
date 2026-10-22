package com.larus.drive.sdk.impl.gallery.provider;

import android.widget.TextView;
import com.larus.gallery.api.p;
import com.larus.gallery.api.w;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements v79.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f341846a;

    public g(h r100) {
        this.f341846a = r100;
    }

    @Override // v79.e
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        w r101 = this.f341846a.f343899e;
        if (r101 == null) goto L6;
        r101.Rf(p.g.f343882a);
        return;
    }

    @Override // v79.e
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r101, "newFileName");
        LarusGalleryChatTitleBinding r102 = this.f341846a.f341848g;
        if (r102 == null) goto L8;
        TextView r103 = r102.f343963g;
        if (r103 == null) goto L9;
        r103.setText(r101);
        return;
    L9:
        return;
    }
}
