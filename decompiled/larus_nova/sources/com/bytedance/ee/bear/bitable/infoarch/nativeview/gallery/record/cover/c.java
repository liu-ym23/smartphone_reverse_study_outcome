package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements com.larksuite.component.ignition.widget.blur.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryCoverAdapter f213479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f213480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f213481c;

    @Override // com.larksuite.component.ignition.widget.blur.a
    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        GalleryCoverAdapter r101 = this.f213479a;
        ImageView r102 = this.f213480b;
        int r103 = GalleryCoverAdapter.f213452g;
        r101.getClass();
        j.f(new e(r102, r100));
        GalleryCoverAdapter r104 = this.f213479a;
        ImageView r105 = this.f213481c;
        r104.getClass();
        j.f(new b(r105));
    }

    public c(GalleryCoverAdapter r100, ImageView r101, ImageView r102) {
        this.f213479a = r100;
        this.f213480b = r101;
        this.f213481c = r102;
    }
}
