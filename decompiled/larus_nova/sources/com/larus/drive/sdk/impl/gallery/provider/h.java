package com.larus.drive.sdk.impl.gallery.provider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.p;
import com.larus.gallery.api.t;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends t<z79.c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z79.b f341847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusGalleryChatTitleBinding f341848g;

    @Override // com.larus.gallery.api.t
    public final boolean n() {
        return false;
    }

    @Override // com.larus.gallery.api.t
    public final void t() {
    }

    @Override // com.larus.gallery.api.t
    public final ViewGroup.LayoutParams q() {
        int r100 = i5.c0();
        i0.f375410a.getClass();
        return new ViewGroup.LayoutParams(-1, r100 + i0.g());
    }

    public h(z79.b r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryContext");
        this.f341847f = r100;
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r100) {
        final DriveFileItem r101 = this.f341847f.f570685b;
        final LarusGalleryChatTitleBinding r102 = LarusGalleryChatTitleBinding.a(LayoutInflater.from(getContext()), r100);
        this.f341848g = r102;
        TextView r103 = r102.f343963g;
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setTextSize(2, 15.0f);
        e1.o(r102.f343962f);
        r102.f343958b.setOnClickListener(new d(this));
        e1.x(r102.f343959c);
        r102.f343959c.setOnClickListener(new e(this, r102, r101));
        LarusGalleryChatTitleBinding r104 = this.f341848g;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.f343957a;
    }

    @Override // com.larus.gallery.api.t
    public final void x(p r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = r100 instanceof p.e;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Object, z79.c] */
    @Override // com.larus.gallery.api.t
    public final void w(z79.c r100, int r101) {
        z79.c r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f343898d = r102;
        LarusGalleryChatTitleBinding r103 = this.f341848g;
        if (r103 == null) goto L11;
        TextView r104 = r103.f343963g;
        if (r104 == null) goto L11;
        DriveFileItem r105 = r102.f570691a;
        if (r105 == null) goto L9;
        String r106 = r105.f341564a;
    L10:
        r104.setText(r106);
        goto L11
    L9:
        r106 = null;
    L11:
        DriveFileItem r107 = r102.f570691a;
        if (r107 == null) goto L15;
        BuildersKt.launch$default(this.f341847f.f570686c, Dispatchers.getIO(), null, new DriveGalleryTopBarProvider$onPreviewChanged$1$1(r107, null), 2, null);
        return;
    }
}
