package com.larus.avlink.gallery.thumbnail;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final class a0 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f292788b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        FLogger.f375446a.i("GalleryThumbnailFragment", "User confirmed deletion of " + this.f292787a + " thumbnails");
        Function0<Unit> r100 = this.f292788b;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public a0(int r100, s r101) {
        this.f292787a = r100;
        this.f292788b = r101;
    }
}
